package com.stedroids.framework.analytics;

import android.content.Context;

import com.stedroids.framework.crash.CrashReporter;
import com.stedroids.framework.global.AbstractApplication;

import java.util.Map;

/**
 * Created by gastonsanguinetti on 25/07/16.
 */
public class AbstractAnalyticsSender<T extends BaseAnalyticsTracker> extends BaseAnalyticsSender<T> {

    public AbstractAnalyticsSender(final AbstractApplication abstractApplication, T... trackers) {
        super(new OnEventTrackedListener() {
            @Override
            public void onEventTracked() {
            }

            @Override
            public void onEventTrackerFail(Exception ex) {
                Map<String, CrashReporter> crashReporterMap = abstractApplication.getCrashReporters();
                for (Map.Entry<String, CrashReporter> crashReporter : crashReporterMap.entrySet()) {
                    crashReporter.getValue().reportHandledException(ex);
                }
            }
        }, trackers);
    }
}
