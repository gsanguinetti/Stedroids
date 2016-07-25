package com.stedroids.framework.utils;

import android.os.Handler;

/**
 * Created by gastonsanguinetti on 25/07/16.
 */
public class ExecutorUtils {

    public static void Execute(Runnable runnable) {
        Handler handler = new Handler();
        handler.post(runnable);
    }
}
