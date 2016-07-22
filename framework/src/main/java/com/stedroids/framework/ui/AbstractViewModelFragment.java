package com.stedroids.framework.ui;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.stedroids.framework.global.AbstractApplication;
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

    public AbstractApplication getAbstractApplication() {
        return (AbstractApplication) getActivity().getApplication();
    }
}
