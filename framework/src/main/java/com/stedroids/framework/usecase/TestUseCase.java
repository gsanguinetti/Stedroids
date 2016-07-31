package com.stedroids.framework.usecase;

import android.os.SystemClock;

/**
 * Created by gastonsanguinetti on 31/07/16.
 */
public abstract class TestUseCase<T> extends UseCase<T> {

    @Override
    protected boolean innerExecute() {
        SystemClock.sleep(secsToResponse() * 1000);
        data = responseReturned();
        return isResponseSuccessfully();
    }

    public abstract int secsToResponse();

    public abstract T responseReturned();

    public abstract boolean isResponseSuccessfully();
}
