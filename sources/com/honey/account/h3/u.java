package com.honey.account.h3;

import com.ucar.vehiclesdk.UCarAdapter;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarAdapter f4499a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ u(UCarAdapter uCarAdapter, boolean z) {
        this.f4499a = uCarAdapter;
        this.b = z;
    }

    public final void run() {
        this.f4499a.x1(this.b);
    }
}
