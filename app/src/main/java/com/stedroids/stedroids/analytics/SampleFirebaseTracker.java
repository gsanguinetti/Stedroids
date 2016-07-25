package com.stedroids.stedroids.analytics;

import android.os.Bundle;

import com.stedroids.framework.analytics.Firebase.FirebaseAnalyticsTracker;

/**
 * Created by gastonsanguinetti on 25/07/16.
 */
public class SampleFirebaseTracker extends SampleTracker<FirebaseAnalyticsTracker> {

    private final static String EVENT_MENU_OPENED = "menu_opened";

    public SampleFirebaseTracker(FirebaseAnalyticsTracker trackerHelper, boolean isEnabled) {
        super(trackerHelper, isEnabled);
    }

    @Override
    public void trackAppMenuOpened() {
        sendEvent(EVENT_MENU_OPENED, new Bundle(), null);
    }
}
