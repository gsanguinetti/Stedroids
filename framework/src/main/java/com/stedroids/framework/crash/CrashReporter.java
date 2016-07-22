package com.stedroids.framework.crash;

/**
 * Created by gastonsanguinetti on 22/07/16.
 */
public interface CrashReporter {
    void reportControlledException(Exception ex);
    void Log(String text);
}
