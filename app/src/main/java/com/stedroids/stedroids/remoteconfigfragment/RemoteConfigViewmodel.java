package com.stedroids.stedroids.remoteconfigfragment;

import android.widget.Toast;

import com.stedroids.framework.config.ConfigurationManager;
import com.stedroids.framework.config.LocalConfigurationManager;
import com.stedroids.framework.config.OnConfigurationFetchListener;
import com.stedroids.framework.viewmodel.AbstractViewModel;
import com.stedroids.stedroids.databinding.RemoteconfigFragmentBinding;
import com.stedroids.stedroids.global.SampleRemoteConfig;

import java.util.Objects;

/**
 * Created by gastonsanguinetti on 27/07/16.
 */
public class RemoteConfigViewmodel extends AbstractViewModel<RemoteconfigFragmentBinding>
    implements OnConfigurationFetchListener {

    ConfigurationManager configurationManager;

    @Override
    public void onResume() {
        super.onResume();
        configurationManager = (SampleRemoteConfig) getAbstractApplication()
                .getPluggedComponent(SampleRemoteConfig.SAMPLE_REMOTE_CONFIG_ID);
        configurationManager.setDefaults();
        configurationManager.setOnConfigurationFetchListener(this);

        LocalConfigurationManager local = (LocalConfigurationManager)configurationManager;
        local.putString("sampleString", "fetched Value");

        configurationManager.fetch();
    }


    @Override
    public void onFetchComplete() {
        notifyChange();
        Toast.makeText(getContext(), "Fetch successfully!!!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFetchFailed() {
        notifyChange();
        Toast.makeText(getContext(), "Fetch failed", Toast.LENGTH_LONG).show();
    }

    public String getString() {
        return configurationManager.getString("sampleString");
    }

    public String getBoolean() {
        Boolean value = configurationManager.getBoolean("sampleBoolean");
        return evalValue(value);
    }

    public String getLong() {
        Long value = configurationManager.getLong("sampleLong");
        return evalValue(value);
    }

    public String getInteger() {
        Integer value = configurationManager.getInteger("sampleInteger");
        return evalValue(value);
    }

    public String getDouble() {
        Double value = configurationManager.getDouble("sampleDouble");
        return evalValue(value);
    }

    private String evalValue(Object value) {
        return value != null ? value.toString() : null;
    }
}
