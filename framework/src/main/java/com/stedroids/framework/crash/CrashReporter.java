package com.stedroids.framework.crash;

/**
 * Created by gastonsanguinetti on 22/07/16.
 */
public interface CrashReporter {
    void reportHandledException(Exception ex);
    void Log(String text);
}
