package com.honey.account.h3;

import com.ucar.vehiclesdk.UCarAdapter;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarAdapter f4475a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;

    public /* synthetic */ a(UCarAdapter uCarAdapter, String str, int i) {
        this.f4475a = uCarAdapter;
        this.b = str;
        this.c = i;
    }

    public final void run() {
        this.f4475a.n1(this.b, this.c);
    }
}
