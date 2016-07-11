package com.stedroids.framework.ui;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.stedroids.framework.image.ImageLoaderHelper;

/**
 * Created by gastonsanguinetti on 10/07/16.
 */
public class BindingAdapters {

    @BindingAdapter({"imageUrl", "placeholder"})
    public static void loadImage(ImageView imageView, String imageUrl, Drawable drawable) {
        ImageLoaderHelper.loadRemoteImage(imageView, imageUrl, drawable);
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String imageUrl) {
        ImageLoaderHelper.loadRemoteImage(imageView, imageUrl, imageView.getDrawable());
    }
}
