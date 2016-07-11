package com.stedroids.framework.ui;

import android.databinding.BindingAdapter;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.stedroids.framework.image.ImageLoaderHelper;
import com.stedroids.framework.viewmodel.AbstractViewModel;

import cz.kinst.jakub.viewmodelbinding.ViewModelBindingConfig;
import cz.kinst.jakub.viewmodelbinding.ViewModelFragment;

/**
 * Created by gastonsanguinetti on 02/07/16.
 */
public abstract class AbstractViewModelFragment<T extends ViewDataBinding, S extends AbstractViewModel>
        extends ViewModelFragment<T, S> implements ViewArtifact<S> {

    @Override
    public ViewModelBindingConfig<S> getViewModelBindingConfig() {
        return new ViewModelBindingConfig<>(getMainLayoutRes(), getViewModelClass());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onArgumentsObtained(getArguments());
    }

    protected void onArgumentsObtained(Bundle args) {
        //Override me
    }
}
