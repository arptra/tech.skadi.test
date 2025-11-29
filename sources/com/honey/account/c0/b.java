package com.honey.account.c0;

import androidx.room.AutoCloser;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AutoCloser f3023a;

    public /* synthetic */ b(AutoCloser autoCloser) {
        this.f3023a = autoCloser;
    }

    public final void run() {
        AutoCloser.c(this.f3023a);
    }
}
