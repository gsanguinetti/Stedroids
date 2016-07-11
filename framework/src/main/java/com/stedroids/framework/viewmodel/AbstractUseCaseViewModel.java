package com.stedroids.framework.viewmodel;

import android.databinding.ViewDataBinding;

import com.stedroids.framework.usecase.UseCaseListener;
import com.stedroids.framework.viewmodel.helper.UseCaseExecutorHelper;
import com.stedroids.framework.viewmodel.helper.UseCaseHandler;

/**
 * Created by gastonsanguinetti on 03/07/16.
 */
public abstract class AbstractUseCaseViewModel<T extends ViewDataBinding, U>
        extends AbstractViewModel<T>
        implements UseCaseListener<U>, UseCaseHandler<U> {

    protected U data;
    protected UseCaseExecutorHelper<U> executorHelper = new UseCaseExecutorHelper<>();

    @Override
    public void onViewModelCreated() {
        super.onViewModelCreated();
        executorHelper.setUseCase(getUseCase(), this);
        executorHelper.setExecutionType(getExecutiontype());
    }

    @Override
    public void onResume() {
        super.onResume();
        executorHelper.doExecuteUseCase();
    }

    @Override
    public void onUseCaseFinishFailed(String error) {
        // Override me
    }

    @Override
    public void onUseCaseStarted() {
        // Override me
    }

    public void runUseCase() {
        executorHelper.runUseCase();
    }
}
