package com.stedroids.stedroids.couchdbfragment.global;

import com.stedroids.framework.global.AbstractApplication;
import com.stedroids.imageloader.picasso.PicassoPlugableGlobalComponent;

/**
 * Created by gastonsanguinetti on 05/07/16.
 */
public class SampleApp extends AbstractApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        this.plugComponent(new PicassoPlugableGlobalComponent());
    }
}
