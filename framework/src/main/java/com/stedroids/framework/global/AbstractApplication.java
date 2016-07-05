package com.stedroids.framework.global;

import android.app.Application;

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

}
