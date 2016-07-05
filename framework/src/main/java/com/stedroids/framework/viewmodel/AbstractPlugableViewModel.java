package com.stedroids.framework.viewmodel;

import android.databinding.ViewDataBinding;

import com.stedroids.framework.global.AbstractApplication;
import com.stedroids.framework.global.PlugableComponent;

/**
 * Created by gastonsanguinetti on 04/07/16.
 */
public abstract class AbstractPlugableViewModel<T extends ViewDataBinding> extends AbstractViewModel<T>
        implements PlugableComponent {

    @Override
    public void onViewModelCreated() {
        super.onViewModelCreated();
        if (!(getContext().getApplicationContext() instanceof AbstractApplication)){
            throw new IllegalStateException("Cannot use plugable components in non stedroids AbstractApplication");
        }
        AbstractApplication application = (AbstractApplication) getContext().getApplicationContext();
        application.plugComponent(this);
    }
}
