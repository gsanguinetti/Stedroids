package com.stedroids.framework.analytics;

import android.os.Bundle;

/**
 * Things to track must inherit from this
 */
public class AbstractAppTracker<T extends AbstractTrackerHelper> implements AppAnalyticsTracker {

    T helper;
    boolean enabled;

    public AbstractAppTracker(T trackerHelper, boolean isEnabled) {
        helper = trackerHelper;
        enabled = isEnabled;
    }

    @Override
    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public void onInitTracker() {
        helper.onInitTracker();
    }

    protected void sendEvent(String eventName, Bundle params, Bundle customProps) {
        helper.sendEvent(eventName, params, customProps);
    }

    protected void setUserId(String userId) {
        setUserId(userId);
    }

    protected void sendTransaction(Double amount, String currency, Bundle customProps){
        helper.sendTransaction(amount, currency, customProps);
    }


}
