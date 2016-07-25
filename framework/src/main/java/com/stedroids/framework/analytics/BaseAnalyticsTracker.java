package com.stedroids.framework.analytics;

/**
 * Created by gastonsanguinetti on 25/07/16.
 */
public interface BaseAnalyticsTracker {

    Boolean isEnabled();
    void onInitTracker();

}
