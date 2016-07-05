package com.stedroids.framework.usecase;

import android.os.AsyncTask;
import android.support.v4.os.AsyncTaskCompat;

import java.lang.ref.WeakReference;

/**
 * Created by gastonsanguinetti on 03/07/16.
 */
public abstract class UseCase<T> extends AsyncTask<Void, Void, Boolean>{

    private WeakReference<UseCaseListener<T>> listener;

    //Use case response properties
    protected T data;
    protected String errorMessage;

    @Override
    protected Boolean doInBackground(Void... voids) {
        return innerExecute();
    }

    @Override
    protected void onPostExecute(Boolean finishSuccessfully) {
        UseCaseListener<T> useCaseListener = listener.get();
        if(useCaseListener != null) {
            if (finishSuccessfully) {
                useCaseListener.onUseCaseFinished(data);
            } else {
                useCaseListener.onUseCaseFinishFailed(errorMessage);
            }
        }
    }

    public void runUseCase() {
        if(listener.get() == null) {
            //Listener not set
            throw new IllegalStateException("You must supply a UseCaseListener first.");
        }

        AsyncTaskCompat.executeParallel(this);
        listener.get().onUseCaseStarted();
    }

    protected abstract boolean innerExecute();

    public void setUseCaseListener(UseCaseListener<T> listener) {
        this.listener = new WeakReference<>(listener);
    }
}
