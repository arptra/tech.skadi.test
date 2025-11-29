package com.airbnb.epoxy;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public final class EpoxyAsyncUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f2282a = b(Looper.getMainLooper(), false);
    public static final Handler b = b(Looper.getMainLooper(), true);
    public static Handler c;

    public static Looper a(String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        return handlerThread.getLooper();
    }

    public static Handler b(Looper looper, boolean z) {
        return !z ? new Handler(looper) : Handler.createAsync(looper);
    }

    public static Handler c() {
        if (c == null) {
            c = b(a("epoxy"), true);
        }
        return c;
    }
}
