package com.stedroids.framework.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.stedroids.framework.global.AbstractApplication;
import com.stedroids.framework.global.PlugableComponent;
import com.stedroids.framework.global.PlugableConstants;
import com.stedroids.framework.image.ImageLoader;

import cz.kinst.jakub.viewmodelbinding.ViewModel;

/**
 * Created by gastonsanguinetti on 02/07/16.
 */
public abstract class AbstractViewModel<T extends ViewDataBinding> extends ViewModel<T> {

    //Support for image loader libraries in Stedroids
    public void loadRemoteImage(ObservableField<Drawable> observableField, String imageUrl, Context context) {
        if(!(context.getApplicationContext() instanceof AbstractApplication)) {
            throw new IllegalStateException("You must use image loader libraries only in Stedroids apps");
        }

        AbstractApplication application = (AbstractApplication) context.getApplicationContext();
        PlugableComponent imageLoaderComponent = application.getPluggedComponent(PlugableConstants
                .IMAGE_LOADER_LIBRARY);
        if(imageLoaderComponent != null) {
            ((ImageLoader) imageLoaderComponent).loadImage(observableField, imageUrl, context);
        } else {
            throw new IllegalStateException("You must plug into app some image loader library first");
        }
    }

}
