package com.stedroids.framework.ui;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.stedroids.framework.image.ImageLoaderHelper;
import com.stedroids.framework.utils.LayoutUtils;

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

    @BindingAdapter({"loading_visibility"})
    public static void handleLoadingLayout(ViewGroup container, boolean showLoadingLayout) {
        handleLoadingLayout(container, UiDefaults.DEFAULT_LOADING_LAYOUT_RES_ID, showLoadingLayout);
    }

    @BindingAdapter({"loading_layout", "loading_visibility"})
    public static void handleLoadingLayout(ViewGroup container, int loadingResId, boolean showLoadingLayout) {
        LayoutUtils.handleLayout(container, loadingResId, showLoadingLayout, "loading_layout");
    }

    @BindingAdapter({"error_visibility"})
    public static void handleErrorLayout(ViewGroup container, boolean showErrorLayout) {
        handleErrorLayout(container, UiDefaults.DEFAULT_ERROR_LAYOUT_RES_ID, showErrorLayout);
    }

    @BindingAdapter({"error_layout", "error_visibility"})
    public static void handleErrorLayout(ViewGroup container, int errorResId, boolean showErrorLayout) {
        LayoutUtils.handleLayout(container, errorResId, showErrorLayout, "error_layout");
    }

    @BindingAdapter({"error_retry_click"})
    public static void handleErrorLayout(ViewGroup container, View.OnClickListener retryListener) {
        View errorRetryView = container.findViewWithTag("error_layout");
        if(errorRetryView != null) {
            errorRetryView.setOnClickListener(retryListener);
        }
    }

}