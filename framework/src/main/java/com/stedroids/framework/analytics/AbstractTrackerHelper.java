package com.stedroids.framework.analytics;

import android.os.Bundle;

/**
 * Created by gastonsanguinetti on 25/07/16.
 */
public interface AbstractTrackerHelper {
    void sendEvent(String eventName, Bundle params, Bundle customProps);
    void setUserId(String userId);
    void sendTransaction(Double amount, String currency, Bundle customProps);
    void onInitTracker();
}
