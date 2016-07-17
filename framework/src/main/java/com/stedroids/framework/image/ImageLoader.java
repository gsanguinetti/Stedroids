package com.stedroids.framework.image;

import android.content.Context;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by gastonsanguinetti on 05/07/16.
 */
public interface ImageLoader {
    void loadImage(ObservableField<Drawable> observableField, String imageUrl, Context context);
    void loadImage(ImageView imageView, String imageUrl, Drawable drawable, boolean offlineCacheOnError);
}
