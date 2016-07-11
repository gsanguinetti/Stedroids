package com.stedroids.framework.global;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gastonsanguinetti on 04/07/16.
 */
public class AbstractApplication extends Application {

    Map<String, PlugableComponent> pluggedComponents;

    @Override
    public void onCreate() {
        super.onCreate();
        pluggedComponents = new HashMap<>();
        initDB();
    }

    public void plugComponent(PlugableComponent component) {
        PlugableComponent pluggedComponent = pluggedComponents.get(component.getPluginId());
        if(pluggedComponent == null) {
            component.onPluggedIn(this);
            pluggedComponents.put(component.getPluginId(), component);
        }
    }

    public PlugableComponent getPluggedComponent(String plugId) {
        return pluggedComponents.get(plugId);
    }

    public void initDB() {
        FlowManager.init(new FlowConfig.Builder(this)
                .openDatabasesOnInit(true)
                .build());
    }

}
