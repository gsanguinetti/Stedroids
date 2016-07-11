package com.stedroids.framework.viewmodel.helper;

import com.stedroids.framework.usecase.UseCase;
import com.stedroids.framework.usecase.UseCaseListener;
import com.stedroids.framework.viewmodel.UseCaseExecutionType;

/**
 * Created by gastonsanguinetti on 09/07/16.
 */
public class UseCaseExecutorHelper<T> {

    protected UseCase<T> useCase;
    protected UseCaseExecutionType executionType;

    boolean useCaseAlreadyExecutedOnce = false;

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
        if (executionType.equals(UseCaseExecutionType.ALWAYS)
                || executionType.equals(UseCaseExecutionType.ONCE) && !useCaseAlreadyExecutedOnce) {
            runUseCase();
            useCaseAlreadyExecutedOnce = true;
        }
    }
}
