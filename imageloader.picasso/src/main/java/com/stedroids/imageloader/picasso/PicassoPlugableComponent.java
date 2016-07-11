package com.stedroids.imageloader.picasso;

import android.content.Context;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.stedroids.framework.global.PlugableComponent;
import com.stedroids.framework.global.PlugableConstants;
import com.stedroids.framework.image.ImageLoader;
import com.stedroids.framework.utils.StringUtils;

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
        if(canLoad(imageUrl)) {
            BindableFieldTarget bindableFieldTarget = new BindableFieldTarget(observableField, context.getResources());
            Picasso.with(context)
                    .load(imageUrl)
                    .into(bindableFieldTarget);
        }
    }

    @Override
    public void loadImage(ImageView imageView, String imageUrl, Drawable drawable) {
        if(canLoad(imageUrl)) {
            Picasso.with(imageView.getContext()).load(imageUrl).placeholder(drawable).into(imageView);
        } else {
            imageView.setImageDrawable(drawable);
        }
    }

    private static boolean canLoad(String url) {
        return !StringUtils.isEmpty(url);
    }
}
