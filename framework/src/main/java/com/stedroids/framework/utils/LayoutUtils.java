package com.stedroids.framework.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gastonsanguinetti on 12/07/16.
 */
public class LayoutUtils {

    public static View handleLayout(ViewGroup container, int layoutResId, boolean showLayout, String layoutTag) {
        View layout = container.findViewWithTag(layoutTag);
        if(showLayout) {
            if (layout == null) {
                LayoutInflater inflater = LayoutInflater.from(container.getContext());
                layout = inflater.inflate(layoutResId, container, false);
                layout.setTag(layoutTag);
                container.addView(layout);
            }
        } else {
            if(layout != null) {
                container.removeView(layout);
                layout = null;
            }
        }
        return layout;
    }
}
