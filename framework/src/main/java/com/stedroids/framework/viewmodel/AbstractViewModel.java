package com.stedroids.framework.viewmodel;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.stedroids.framework.global.AbstractApplication;
import com.stedroids.framework.global.PlugableComponent;
import com.stedroids.framework.global.PlugableConstants;
import com.stedroids.framework.image.ImageLoader;
import com.stedroids.framework.image.ImageLoaderHelper;

import cz.kinst.jakub.viewmodelbinding.ViewModel;

/**
 * Created by gastonsanguinetti on 02/07/16.
 */
public abstract class AbstractViewModel<T extends ViewDataBinding> extends ViewModel<T> {

    //Support for image loader libraries in Stedroids
    public void loadRemoteImage(ObservableField<Drawable> observableField, String imageUrl, Context context) {
        ImageLoaderHelper.loadRemoteImage(observableField, imageUrl, context);
    }

}
