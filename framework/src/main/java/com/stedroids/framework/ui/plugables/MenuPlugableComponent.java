package com.stedroids.framework.ui.plugables;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by gastonsanguinetti on 20/07/16.
 */
public abstract class MenuPlugableComponent<T> extends UIPlugableComponent<T, Menu> {

    Context context;
    MenuItem menuItem;

    public MenuPlugableComponent(T plugableObject, Context context) {
        super(plugableObject);
        this.context = context;
    }

    @Override
    public void onPluggedInto(Menu menu) {
        menuItem = menu.add(getComponentIdentifier(getPlugableComponent()));
        onComponentPluggedToMenu(menuItem, getPlugableComponent());
    }

    public abstract void onComponentPluggedToMenu(MenuItem menuItem, T plugableObject);
    public abstract String getComponentIdentifier(T plugableObject);
}
