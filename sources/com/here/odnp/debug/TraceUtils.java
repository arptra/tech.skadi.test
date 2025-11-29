package com.here.odnp.debug;

public final class TraceUtils {
    public static String getTag(String str, Object obj) {
        return String.format("%s-%08X", new Object[]{str, Integer.valueOf(System.identityHashCode(obj))});
    }
}
