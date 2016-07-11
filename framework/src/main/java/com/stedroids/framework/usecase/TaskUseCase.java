package com.stedroids.framework.usecase;

/**
 * Created by gastonsanguinetti on 11/07/16.
 */
public abstract class TaskUseCase<T> extends UseCase<T> {


    @Override
    protected boolean innerExecute() {
        try {
            data = execute();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public abstract T execute();
}
