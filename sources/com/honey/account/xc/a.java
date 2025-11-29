package com.honey.account.xc;

import java.lang.Thread;

public final /* synthetic */ class a implements Thread.UncaughtExceptionHandler {
    public final void uncaughtException(Thread thread, Throwable th) {
        th.printStackTrace();
    }
}
