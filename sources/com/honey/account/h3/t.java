package com.honey.account.h3;

import com.ucar.vehiclesdk.UCarAdapter;
import java.util.concurrent.CountDownLatch;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarAdapter f4498a;
    public final /* synthetic */ CountDownLatch b;

    public /* synthetic */ t(UCarAdapter uCarAdapter, CountDownLatch countDownLatch) {
        this.f4498a = uCarAdapter;
        this.b = countDownLatch;
    }

    public final void run() {
        this.f4498a.B1(this.b);
    }
}
