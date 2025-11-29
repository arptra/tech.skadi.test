package com.honey.account.h3;

import com.ucar.vehiclesdk.UCarAdapter;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarAdapter f4501a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ w(UCarAdapter uCarAdapter, String str, boolean z) {
        this.f4501a = uCarAdapter;
        this.b = str;
        this.c = z;
    }

    public final void run() {
        this.f4501a.o1(this.b, this.c);
    }
}
