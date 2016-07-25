package com.stedroids.stedroids.analytics;

import com.stedroids.framework.analytics.AbstractAnalyticsTracker;
import com.stedroids.framework.analytics.AbstractAppTracker;

/**
 * Created by gastonsanguinetti on 25/07/16.
 */
public abstract class SampleTracker<T extends AbstractAnalyticsTracker> extends AbstractAppTracker<T>
    implements ISampleTracker {

    public SampleTracker(T trackerHelper, boolean isEnabled) {
        super(trackerHelper, isEnabled);
    }

}
