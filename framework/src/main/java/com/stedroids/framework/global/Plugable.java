package com.stedroids.framework.global;

/**
 * Created by gastonsanguinetti on 20/07/16.
 */
public interface Plugable<T> {

    void onPluggedInto(T object);
}
