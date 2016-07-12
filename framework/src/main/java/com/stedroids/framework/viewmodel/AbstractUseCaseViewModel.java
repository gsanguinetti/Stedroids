package com.stedroids.framework.viewmodel;

import android.databinding.ViewDataBinding;
import android.os.AsyncTask;
import android.view.View;

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
        executorHelper.setExecutionType(getExecutiontype());
    }

    @Override
    public void onResume() {
        super.onResume();
        handleUseCase();
    }

    @Override
    public void onUseCaseFinishFailed(String error) {
        notifyChange();
    }

    @Override
    public void onUseCaseStarted() {
        notifyChange();
    }

    private void handleUseCase() {
        if(executorHelper.canRun()) {
            runUseCase();
        }
    }

    public void runUseCase() {
        if(executorHelper.canRun()) {
            executorHelper.setUseCase(getUseCase(), this);
            executorHelper.doExecuteUseCase();
        } else {
            throw new IllegalStateException("UseCase is not set to run at this moment");
        }
    }

    public boolean isUseCaseFinished() {
        return executorHelper.getUseCase().getStatus() == AsyncTask.Status.FINISHED;
    }

    public boolean isUseCaseFailed() {
        return isUseCaseFinished()
                && executorHelper.getUseCase().hasFailed();
    }

    public View.OnClickListener onRetryClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executorHelper.resetExecutor();
                handleUseCase();
            }
        };
    }
}
