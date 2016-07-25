package com.stedroids.stedroids.analytics;

import com.stedroids.framework.analytics.AbstractAnalyticsSender;
import com.stedroids.framework.global.AbstractApplication;
import com.stedroids.framework.utils.ExecutorUtils;

/**
 * Created by gastonsanguinetti on 25/07/16.
 */
public class SampleAnalyticsSender extends AbstractAnalyticsSender<SampleTracker> implements ISampleTracker {

    public SampleAnalyticsSender(AbstractApplication abstractApplication, SampleTracker... trackers) {
        super(abstractApplication, trackers);
    }

    @Override
    public void trackAppMenuOpened() {
        ExecutorUtils.Execute(new TrackerRunnable() {
            @Override
            protected void track(SampleTracker tracker) {
                tracker.trackAppMenuOpened();
            }
        });
    }
}
