package com.stedroids.imageloader.picasso;

import android.content.Context;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;
import com.stedroids.framework.global.PlugableGlobalComponent;
import com.stedroids.framework.global.PlugableConstants;
import com.stedroids.framework.image.ImageLoader;
import com.stedroids.framework.utils.StringUtils;

/**
 * Created by gastonsanguinetti on 05/07/16.
 */
public class PicassoPlugableGlobalComponent implements PlugableGlobalComponent, ImageLoader {

    @Override
    public void onPluggedInto(Context context) {
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttpDownloader(context, Integer.MAX_VALUE));
        Picasso.setSingletonInstance(builder.build());
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
    public void loadImage(final ImageView imageView, final String imageUrl, Drawable drawable, final boolean offlineCacheOnError) {
        if(canLoad(imageUrl)) {
            Picasso.with(imageView.getContext()).load(imageUrl).placeholder(drawable)
                    .into(imageView, new Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError() {
                            if(offlineCacheOnError) {
                                Picasso.with(imageView.getContext())
                                        .load(imageUrl)
                                        .networkPolicy(NetworkPolicy.OFFLINE)
                                        .into(imageView);
                            }
                        }
                    });
        } else {
            imageView.setImageDrawable(drawable);
        }
    }

    private static boolean canLoad(String url) {
        return !StringUtils.isEmpty(url);
    }
}
