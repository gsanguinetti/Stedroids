package com.stedroids.framework.global;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by gastonsanguinetti on 04/07/16.
 */
public interface PlugableGlobalComponent extends Plugable<Context> {

    @NonNull
    String getPluginId();
}
