package com.stedroids.framework.viewmodel.helper;

import android.os.AsyncTask;

import com.stedroids.framework.usecase.UseCase;
import com.stedroids.framework.usecase.UseCaseListener;
import com.stedroids.framework.viewmodel.UseCaseExecutionType;

/**
 * Created by gastonsanguinetti on 09/07/16.
 */
public class UseCaseExecutorHelper<T> {

    protected UseCase<T> useCase;
    protected UseCaseExecutionType executionType;

    boolean useCaseAlreadyExecutedOnce;

    public UseCaseExecutorHelper() {
        resetExecutor();
    }

    public void resetExecutor() {
        useCase = null;
        useCaseAlreadyExecutedOnce = false;
    }

    public void runUseCase() {
        useCase.runUseCase();
    }

    public UseCase<T> getUseCase() {
        return useCase;
    }

    public void setUseCase(UseCase<T> useCase, UseCaseListener<T> listener) {
        this.useCase = useCase;
        this.useCase.setUseCaseListener(listener);
    }

    public UseCaseExecutionType getExecutionType() {
        return executionType;
    }

    public void setExecutionType(UseCaseExecutionType executionType) {
        this.executionType = executionType;
    }

    public void doExecuteUseCase() {
        if(useCase.getStatus() == AsyncTask.Status.PENDING ) {
            runUseCase();
            useCaseAlreadyExecutedOnce = true;
        }
    }

    public boolean canRun() {
        return executionType.equals(UseCaseExecutionType.ALWAYS)
                || executionType.equals(UseCaseExecutionType.MANUAL)
                || (executionType.equals(UseCaseExecutionType.ONCE) && !useCaseAlreadyExecutedOnce);
    }
}
