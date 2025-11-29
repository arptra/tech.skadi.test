package com.here.odnp.util;

import android.os.Looper;

public class ClientLooper {
    public static Looper getLooper() {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return mainLooper;
        }
        throw new IllegalStateException("Looper is not prepared");
    }
}
