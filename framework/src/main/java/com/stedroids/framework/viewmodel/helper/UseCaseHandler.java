package com.stedroids.framework.viewmodel.helper;

import android.support.annotation.NonNull;

import com.stedroids.framework.usecase.UseCase;
import com.stedroids.framework.viewmodel.UseCaseExecutionType;

/**
 * Created by gastonsanguinetti on 09/07/16.
 */
public interface UseCaseHandler<T> {

    @NonNull
    UseCase<T> getUseCase();

    @NonNull
    UseCaseExecutionType getExecutiontype();
}
