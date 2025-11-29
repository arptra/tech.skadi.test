package com.honey.account.ha;

import android.app.Application;
import com.xjsd.ai.assistant.phone.Commander;
import java.util.concurrent.CountDownLatch;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Commander f7332a;
    public final /* synthetic */ CountDownLatch b;
    public final /* synthetic */ Application c;

    public /* synthetic */ b(Commander commander, CountDownLatch countDownLatch, Application application) {
        this.f7332a = commander;
        this.b = countDownLatch;
        this.c = application;
    }

    public final void run() {
        this.f7332a.lambda$initComponents$1(this.b, this.c);
    }
}
