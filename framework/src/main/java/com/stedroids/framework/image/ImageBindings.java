package com.stedroids.framework.image;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

/**
 * Created by gastonsanguinetti on 10/07/16.
 */
public class ImageBindings {

    @BindingAdapter({"imageUrl", "placeholder"})
    public static void loadImage(ImageView imageView, String imageUrl, int drawable) {
        ImageLoaderHelper.loadRemoteImage(imageView, imageUrl,
                ContextCompat.getDrawable(imageView.getContext(), drawable));
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String imageUrl) {
        ImageLoaderHelper.loadRemoteImage(imageView, imageUrl, imageView.getDrawable());
    }
}
