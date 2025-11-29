package com.upuphone.xr.interconnect.util.log;

import com.upuphone.xr.interconnect.Constants;

public class ILog {
    private static final ILogger logger = new DefaultLogger();

    private ILog() {
    }

    public static void d(String str, String str2) {
        ILogger iLogger = logger;
        iLogger.d(Constants.LOG_PREFIX + str, str2);
    }

    public static void disableLogger() {
        logger.setEnable(false);
    }

    public static void e(String str, String str2) {
        ILogger iLogger = logger;
        iLogger.e(Constants.LOG_PREFIX + str, str2);
    }

    public static void enableLogger() {
        logger.setEnable(true);
    }

    public static void i(String str, String str2) {
        ILogger iLogger = logger;
        iLogger.i(Constants.LOG_PREFIX + str, str2);
    }

    public static void v(String str, String str2) {
        ILogger iLogger = logger;
        iLogger.v(Constants.LOG_PREFIX + str, str2);
    }

    public static void w(String str, String str2) {
        ILogger iLogger = logger;
        iLogger.w(Constants.LOG_PREFIX + str, str2);
    }

    public static void d(String str, String str2, Throwable th) {
        ILogger iLogger = logger;
        iLogger.d(Constants.LOG_PREFIX + str, str2, th);
    }

    public static void e(String str, String str2, Throwable th) {
        ILogger iLogger = logger;
        iLogger.e(Constants.LOG_PREFIX + str, str2, th);
    }

    public static void i(String str, String str2, Throwable th) {
        ILogger iLogger = logger;
        iLogger.i(Constants.LOG_PREFIX + str, str2, th);
    }

    public static void v(String str, String str2, Throwable th) {
        ILogger iLogger = logger;
        iLogger.v(Constants.LOG_PREFIX + str, str2, th);
    }

    public static void w(String str, String str2, Throwable th) {
        ILogger iLogger = logger;
        iLogger.w(Constants.LOG_PREFIX + str, str2, th);
    }
}
