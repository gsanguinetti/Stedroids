package com.stedroids.imageloader.picasso;

import android.content.Context;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import com.squareup.picasso.Picasso;
import com.stedroids.framework.global.PlugableComponent;
import com.stedroids.framework.global.PlugableConstants;
import com.stedroids.framework.image.ImageLoader;

/**
 * Created by gastonsanguinetti on 05/07/16.
 */
public class PicassoPlugableComponent implements PlugableComponent, ImageLoader {

    @Override
    public void onPluggedIn(Context context) {
        //Do nothing
    }

    @NonNull
    @Override
    public String getPluginId() {
        return PlugableConstants.IMAGE_LOADER_LIBRARY;
    }


    @Override
    public void loadImage(ObservableField<Drawable> observableField, String imageUrl, Context context) {
        BindableFieldTarget bindableFieldTarget = new BindableFieldTarget(observableField, context.getResources());
        Picasso.with(context)
                .load(imageUrl)
                .into(bindableFieldTarget);
    }
}
