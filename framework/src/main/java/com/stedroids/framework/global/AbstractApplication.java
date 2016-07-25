package com.stedroids.framework.global;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.stedroids.framework.analytics.BaseAnalyticsSender;
import com.stedroids.framework.crash.CrashReporter;
import com.stedroids.framework.crash.FirebaseCrashReporter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gastonsanguinetti on 04/07/16.
 */
public abstract class AbstractApplication<T extends BaseAnalyticsSender> extends Application {

    Map<String, PlugableGlobalComponent> pluggedComponents;
    Map<String, CrashReporter> crashReporters;
    T analyticsSender;

    @Override
    public void onCreate() {
        super.onCreate();
        pluggedComponents = new HashMap<>();
        crashReporters = new HashMap<>();

        registerCrashReporter(FirebaseCrashReporter.class.getCanonicalName(),
                new FirebaseCrashReporter());

        initDB();

        analyticsSender = startAnalyticsTrackers();
    }

    public void plugComponent(PlugableGlobalComponent component) {
        PlugableGlobalComponent pluggedComponent = pluggedComponents.get(component.getPluginId());
        if(pluggedComponent == null) {
            component.onPluggedInto(this);
            pluggedComponents.put(component.getPluginId(), component);
        }
    }

    public PlugableGlobalComponent getPluggedComponent(String plugId) {
        return pluggedComponents.get(plugId);
    }

    public void initDB() {
        FlowManager.init(new FlowConfig.Builder(this)
                .build());
    }

    public void registerCrashReporter(String crashClassName, CrashReporter crashReporter) {
        crashReporters.put(crashClassName, crashReporter);
    }

    public Map<String, CrashReporter> getCrashReporters() {
        return crashReporters;
    }

    public CrashReporter getCrashReporter(String crashClassName) {
        return crashReporters.get(crashClassName);
    }

    public abstract T startAnalyticsTrackers();

    public T getAnalyticsSender() {
        return analyticsSender;
    }

}
