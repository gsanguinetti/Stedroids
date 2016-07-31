package com.stedroids.framework.config;

import android.content.Context;
import android.content.SharedPreferences;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gastonsanguinetti on 27/07/16.
 */
public abstract class LocalConfigurationManager extends ConfigurationManager {

    Map<String, String> configValues;
    Context context;
    SharedPreferences prefs;

    @Override
    public void onPluggedInto(Context context) {
        configValues = new HashMap<>();
        this.context = context;
        prefs = context.getSharedPreferences(getPluginId(), Context.MODE_PRIVATE);
    }

    @Override
    public void setDefaults() {
        parseDefaultXML();
    }

    @Override
    public void fetch() {
        try {
            for (Map.Entry<String, String> entry : configValues.entrySet()) {
                if(prefs.contains(entry.getKey())) {
                    configValues.put(entry.getKey(), prefs.getString(entry.getKey(), entry.getValue()));
                }
            }
            fetched = true;
            fetchedSuccesful = true;
            if(onConfigurationFetchListener != null) {
                onConfigurationFetchListener.onFetchComplete();
            }
        }
        catch (Exception ex) {
            if(onConfigurationFetchListener != null) {
                onConfigurationFetchListener.onFetchFailed();
            }
        }

    }

    @Override
    public Boolean getBoolean(String key) {
        return hasValue(key) ? Boolean.parseBoolean(configValues.get(key)) : null;
    }

    @Override
    public Double getDouble(String key) {
        return hasValue(key) ? Double.parseDouble(configValues.get(key)) : null;
    }

    @Override
    public Integer getInteger(String key) {
        return hasValue(key) ? Integer.parseInt(configValues.get(key)) : null;
    }

    @Override
    public String getString(String key) {
        return configValues.get(key);
    }

    @Override
    public Long getLong(String key) {
        return hasValue(key) ? Long.parseLong(configValues.get(key)) : null;
    }

    public void putBoolean(String key, Boolean value) {
        configValues.put(key, value.toString());
        prefs.edit().putBoolean(key, value).apply();
    }

    public void putInteger(String key, Integer value) {
        configValues.put(key, value.toString());
        prefs.edit().putInt(key, value).apply();
    }

    public void putString(String key, String value) {
        configValues.put(key, value);
        prefs.edit().putString(key, value).apply();
    }

    public void putDouble(String key, Double value) {
        configValues.put(key, value.toString());
        prefs.edit().putFloat(key, value.floatValue()).apply();
    }

    public void putLong(String key, Long value) {
        configValues.put(key, value.toString());
        prefs.edit().putLong(key, value).apply();
    }

    private boolean hasValue(String key) {
        return configValues.get(key) != null;
    }

    private void parseDefaultXML() {
        try {
            XmlPullParser parser = context.getResources().getXml(getDefaultParamsXmlRes());
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);

            int eventType = parser.getEventType();
            Entry currentEntry = null;
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String name;
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        configValues = new HashMap<>();
                        break;
                    case XmlPullParser.START_TAG:
                        name = parser.getName();
                        if (name.equals("entry")) {
                            currentEntry = new Entry();
                        } else if (currentEntry != null) {
                            if (name.equals("key")) {
                                currentEntry.key = parser.nextText();
                            } else if (name.equals("value")) {
                                currentEntry.value = parser.nextText();
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        name = parser.getName();
                        if (name.equals("entry") && currentEntry != null) {
                            configValues.put(currentEntry.key, currentEntry.value);
                        }
                        break;
                    case XmlPullParser.END_DOCUMENT:
                        return;
                }
                eventType = parser.next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
    }

    private class Entry {
        String key;
        String value;
    }
}
