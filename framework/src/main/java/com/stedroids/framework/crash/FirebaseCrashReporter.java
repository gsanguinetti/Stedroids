package com.stedroids.framework.crash;

import com.google.firebase.crash.FirebaseCrash;

/**
 * Created by gastonsanguinetti on 22/07/16.
 */
public class FirebaseCrashReporter implements CrashReporter {

    @Override
    public void reportHandledException(Exception ex) {
        FirebaseCrash.report(ex);
    }

    @Override
    public void Log(String text) {
        FirebaseCrash.log(text);
    }

}
