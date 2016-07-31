package com.mejorana.configurationmanager;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.stedroids.framework.config.ConfigurationManager;

/**
 * Created by gastonsanguinetti on 27/07/16.
 */
public abstract class RemoteConfigurationManager extends ConfigurationManager {

    @Override
    public void onPluggedInto(Context object) {
    }

    @Override
    public void setDefaults() {
        FirebaseRemoteConfig.getInstance().setDefaults(getDefaultParamsXmlRes());
    }

    @Override
    public void fetch() {
        FirebaseRemoteConfig.getInstance().fetch().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                fetched = true;
                fetchedSuccesful = task.isSuccessful();
                if (task.isSuccessful()) {
                    FirebaseRemoteConfig.getInstance().activateFetched();
                    if (onConfigurationFetchListener != null)
                        onConfigurationFetchListener.onFetchComplete();
                } else {
                    if (onConfigurationFetchListener != null)
                        onConfigurationFetchListener.onFetchFailed();
                }
            }
        });
    }

    @Override
    public Boolean getBoolean(String key) {
        return FirebaseRemoteConfig.getInstance().getBoolean(key);
    }

    @Override
    public Double getDouble(String key) {
        return FirebaseRemoteConfig.getInstance().getDouble(key);
    }

    @Override
    public Integer getInteger(String key) {
        return Integer.parseInt(FirebaseRemoteConfig.getInstance().getString(key));
    }

    @Override
    public String getString(String key) {
        return FirebaseRemoteConfig.getInstance().getString(key);
    }

    @Override
    public Long getLong(String key) {
        return FirebaseRemoteConfig.getInstance().getLong(key);
    }
}
