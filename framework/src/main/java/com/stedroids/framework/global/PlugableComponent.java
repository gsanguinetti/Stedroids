package com.stedroids.framework.global;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by gastonsanguinetti on 04/07/16.
 */
public interface PlugableComponent {

    void onPluggedIn(Context context);

    @NonNull
    String getPluginId();
}
