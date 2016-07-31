package com.stedroids.stedroids.global;

import android.support.annotation.NonNull;

import com.mejorana.configurationmanager.RemoteConfigurationManager;
import com.stedroids.framework.config.LocalConfigurationManager;
import com.stedroids.stedroids.R;

/**
 * Created by gastonsanguinetti on 27/07/16.
 */
public class SampleRemoteConfig extends LocalConfigurationManager {

    public static final String SAMPLE_REMOTE_CONFIG_ID = "sampleRemoteConfig";

    @Override
    public int getDefaultParamsXmlRes() {
        return R.xml.remote_config;
    }


    @NonNull
    @Override
    public String getPluginId() {
        return SAMPLE_REMOTE_CONFIG_ID;
    }
}
