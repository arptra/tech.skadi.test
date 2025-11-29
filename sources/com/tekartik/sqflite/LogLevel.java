package com.tekartik.sqflite;

import io.flutter.plugin.common.MethodCall;

public class LogLevel {
    public static Integer a(MethodCall methodCall) {
        return (Integer) methodCall.argument("logLevel");
    }

    public static boolean b(int i) {
        return i >= 1;
    }

    public static boolean c(int i) {
        return i >= 2;
    }
}
