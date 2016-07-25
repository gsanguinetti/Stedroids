package com.stedroids.framework.analytics.Firebase;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.stedroids.framework.analytics.AbstractAnalyticsTracker;

/**
 * Created by gastonsanguinetti on 25/07/16.
 */
public class FirebaseAnalyticsTracker extends AbstractAnalyticsTracker {

    private FirebaseAnalytics firebaseAnalytics;

    public FirebaseAnalyticsTracker(Context context) {
        firebaseAnalytics = FirebaseAnalytics.getInstance(context);
    }

    @Override
    public void sendEvent(String eventName, Bundle params, Bundle customProps) {
        if(customProps!= null) {
            for (String key: customProps.keySet()) {
                firebaseAnalytics.setUserProperty(key, customProps.get(key).toString());
            }
        }
        firebaseAnalytics.logEvent(eventName, params);
    }

    @Override
    public void setUserId(String userId) {
        firebaseAnalytics.setUserId(userId);
    }

    @Override
    public void sendTransaction(Double amount, String currency, Bundle customProps) {
        Bundle params = new Bundle();
        params.putDouble(FirebaseAnalytics.Param.VALUE, amount);
        params.putString(FirebaseAnalytics.Param.CURRENCY, currency);
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.ECOMMERCE_PURCHASE, params);
    }

    @Override
    public void onInitTracker() {
        //
    }

}
