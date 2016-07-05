package com.stedroids.framework.usecase;

/**
 * Created by gastonsanguinetti on 03/07/16.
 */
public interface UseCaseListener<T> {
    void onUseCaseFinishFailed(String error);
    void onUseCaseFinished(T response);
    void onUseCaseStarted();
}
