package com.upuphone.hub;

import android.os.Handler;
import android.os.Looper;

public class MainThread {

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f6425a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        f6425a.post(runnable);
    }
}
