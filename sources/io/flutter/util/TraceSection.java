package io.flutter.util;

import androidx.annotation.NonNull;
import androidx.tracing.Trace;

public final class TraceSection implements AutoCloseable {
    private TraceSection(String str) {
        begin(str);
    }

    public static void begin(@NonNull String str) {
        Trace.c(cropSectionName(str));
    }

    public static void beginAsyncSection(String str, int i) {
        Trace.a(cropSectionName(str), i);
    }

    private static String cropSectionName(@NonNull String str) {
        if (str.length() < 124) {
            return str;
        }
        return str.substring(0, 124) + "...";
    }

    public static void end() throws RuntimeException {
        Trace.f();
    }

    public static void endAsyncSection(String str, int i) {
        Trace.d(cropSectionName(str), i);
    }

    public static TraceSection scoped(String str) {
        return new TraceSection(str);
    }

    public void close() {
        end();
    }
}
