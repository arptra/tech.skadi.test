package com.honey.account.h3;

import com.ucar.vehiclesdk.UCarAdapter;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarAdapter f4490a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public /* synthetic */ l(UCarAdapter uCarAdapter, String str, int i, int i2) {
        this.f4490a = uCarAdapter;
        this.b = str;
        this.c = i;
        this.d = i2;
    }

    public final void run() {
        this.f4490a.m1(this.b, this.c, this.d);
    }
}
