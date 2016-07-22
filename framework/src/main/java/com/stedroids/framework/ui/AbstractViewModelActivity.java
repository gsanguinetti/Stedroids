package com.stedroids.framework.ui;

import android.databinding.ViewDataBinding;

import com.stedroids.framework.global.AbstractApplication;
import com.stedroids.framework.viewmodel.AbstractViewModel;

import cz.kinst.jakub.viewmodelbinding.ViewModelActivity;
import cz.kinst.jakub.viewmodelbinding.ViewModelBindingConfig;

/**
 * Created by gastonsanguinetti on 02/07/16.
 */

public abstract class AbstractViewModelActivity<T extends ViewDataBinding, S extends AbstractViewModel<T>>
        extends ViewModelActivity<T, S> implements ViewArtifact<S> {
    @Override
    public ViewModelBindingConfig<S> getViewModelBindingConfig() {
        return new ViewModelBindingConfig<>(getMainLayoutRes(), getViewModelClass());
    }

    public AbstractApplication getAbstractApplication() {
        return (AbstractApplication) getApplication();
    }
}
