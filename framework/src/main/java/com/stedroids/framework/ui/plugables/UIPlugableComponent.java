package com.stedroids.framework.ui.plugables;

import com.stedroids.framework.global.Plugable;

/**
 * Created by gastonsanguinetti on 20/07/16.
 */
public abstract class UIPlugableComponent<T, S> implements Plugable<S> {

    protected T plugableObject;
    protected OnPlugableObjectSelectedListener listener;

    public UIPlugableComponent(T plugableObject) {
        this.plugableObject = plugableObject;
    }

    public void onSelected() {
        if (listener != null) {
            listener.onSelectedPlugableObject(plugableObject);
        }
    }

    public void setOnPlugableObjectSelectedListener(OnPlugableObjectSelectedListener listener) {
        this.listener = listener;
    }

    public T getPlugableComponent() {
        return plugableObject;
    }

    // Inner interface
    public interface OnPlugableObjectSelectedListener {
        void onSelectedPlugableObject(Object plugableObject);
    }

}
