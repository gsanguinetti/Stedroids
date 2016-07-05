package com.stedroids.framework.viewmodel;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

import com.stedroids.framework.usecase.UseCase;
import com.stedroids.framework.usecase.UseCaseListener;

/**
 * Created by gastonsanguinetti on 03/07/16.
 */
public abstract class AbstractUseCaseViewModel<T extends ViewDataBinding, U> extends AbstractViewModel<T>
    implements UseCaseListener<U>{

    protected U data;
    protected UseCase<U> useCase;

    boolean useCaseAlreadyExecutedOnce = false;

    @Override
    public void onResume() {
        super.onResume();

        if(getExecutiontype().equals(UseCaseExecutionType.ALWAYS)
                || getExecutiontype().equals(UseCaseExecutionType.ONCE) && !useCaseAlreadyExecutedOnce) {
            runUseCase();
            useCaseAlreadyExecutedOnce = true;
        }
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
        useCase = getUseCase();
        useCase.setUseCaseListener(this);
        useCase.runUseCase();
    }

    @NonNull
    public abstract UseCase<U> getUseCase();

    @NonNull
    public abstract UseCaseExecutionType getExecutiontype();
}
