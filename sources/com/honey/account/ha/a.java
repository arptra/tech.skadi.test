package com.honey.account.ha;

import android.app.Application;
import com.xjsd.ai.assistant.core.Component;
import com.xjsd.ai.assistant.phone.Commander;
import java.util.concurrent.CountDownLatch;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Component f7331a;
    public final /* synthetic */ Application b;
    public final /* synthetic */ CountDownLatch c;

    public /* synthetic */ a(Component component, Application application, CountDownLatch countDownLatch) {
        this.f7331a = component;
        this.b = application;
        this.c = countDownLatch;
    }

    public final void run() {
        Commander.lambda$initComponents$0(this.f7331a, this.b, this.c);
    }
}
