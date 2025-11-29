package com.google.crypto.tink.shaded.protobuf;

final class Android {
    private static final boolean IS_ROBOLECTRIC = (getClassForName("org.robolectric.Robolectric") != null);
    private static final Class<?> MEMORY_CLASS = getClassForName("libcore.io.Memory");

    private static <T> Class<T> getClassForName(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<?> getMemoryClass() {
        return MEMORY_CLASS;
    }

    public static boolean isOnAndroidDevice() {
        return MEMORY_CLASS != null && !IS_ROBOLECTRIC;
    }
}
