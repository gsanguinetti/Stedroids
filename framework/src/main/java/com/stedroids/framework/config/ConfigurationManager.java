package com.stedroids.framework.config;

import android.content.Context;
import android.support.annotation.NonNull;

import com.stedroids.framework.global.PlugableGlobalComponent;

/**
 * Created by gastonsanguinetti on 26/07/16.
 */
public abstract class ConfigurationManager implements PlugableGlobalComponent {

    protected boolean fetched = false;
    protected boolean fetchedSuccesful = false;
    protected OnConfigurationFetchListener onConfigurationFetchListener = null;

    @Override
    public void onPluggedInto(Context object) {

    }

    public boolean hasFetched() {
        return fetched;
    }

    public boolean isFetchedSuccesful() {
        return fetchedSuccesful;
    }

    public void setOnConfigurationFetchListener(OnConfigurationFetchListener onConfigurationFetchListener) {
        this.onConfigurationFetchListener = onConfigurationFetchListener;
    }

    public abstract int getDefaultParamsXmlRes();
    public abstract void setDefaults();
    public abstract void fetch();

    public abstract Boolean getBoolean(String key);
    public abstract Double getDouble(String key);
    public abstract Integer getInteger(String key);
    public abstract String getString(String key);
    public abstract Long getLong(String key);
}
