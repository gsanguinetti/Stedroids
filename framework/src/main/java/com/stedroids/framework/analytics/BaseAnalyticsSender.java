package com.stedroids.framework.analytics;


import com.stedroids.framework.utils.collections.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * Created by gastonsanguinetti on 25/07/16.
 */
public class BaseAnalyticsSender<T extends BaseAnalyticsTracker> implements BaseAnalyticsTracker  {

    private List<T> trackers = Lists.newArrayList();
    private OnEventTrackedListener onEventTrackedListener;

    @SafeVarargs
    public BaseAnalyticsSender(OnEventTrackedListener onEventTrackedListener, T... trackers) {
        this(onEventTrackedListener, Lists.newArrayList(trackers));
    }

    public BaseAnalyticsSender(OnEventTrackedListener onEventTrackedListener, List<T> trackers) {
        this.onEventTrackedListener = onEventTrackedListener;
        this.trackers = Lists.newArrayList();
        Iterator<T> i$ = trackers.iterator();

        while(i$.hasNext()) {
            BaseAnalyticsTracker tracker = i$.next();
            if(tracker.isEnabled()) {
                addTracker((T) tracker);
            }
        }

    }

    public Boolean isEnabled() {
        return null;
    }

    @Override
    public void onInitTracker() {
        //
    }

    public List<T> getTrackers() {
        return this.trackers;
    }

    public void addTracker(T tracker) {
        tracker.onInitTracker();
        this.trackers.add(tracker);
    }

    public abstract class TrackerRunnable implements Runnable {
        public TrackerRunnable() {
        }

        public void run() {
            Iterator<T> i$ = BaseAnalyticsSender.this.trackers.iterator();

            while(i$.hasNext()) {
                BaseAnalyticsTracker tracker = i$.next();

                try {
                    if(tracker.isEnabled()) {
                        this.track((T) tracker);
                        if(onEventTrackedListener != null){
                            onEventTrackedListener.onEventTracked();
                        }
                    }
                } catch (Exception ex) {
                    if(onEventTrackedListener != null){
                        onEventTrackedListener.onEventTrackerFail(ex);
                    }
                }
            }

        }

        protected abstract void track(T var1);
    }

    public interface OnEventTrackedListener {
        void onEventTracked();
        void onEventTrackerFail(Exception ex);
    }
}
