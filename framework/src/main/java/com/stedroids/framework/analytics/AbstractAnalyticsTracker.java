package com.stedroids.framework.analytics;

import android.os.Bundle;

/**
 * Different trackers must inherit from this
 */
public abstract class AbstractAnalyticsTracker implements AbstractTrackerHelper {

    @Override
    public void sendEvent(String eventName, Bundle params, Bundle customProps) {
        //
    }

    @Override
    public void setUserId(String userId) {
        //
    }

    @Override
    public void sendTransaction(Double amount, String currency, Bundle customProps) {

    }

    @Override
    public void onInitTracker() {

    }
}
