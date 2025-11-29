package com.ucar.vehiclesdk;

import com.ucar.vehiclesdk.UCarAdapter;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarAdapter.AnonymousClass6 f5455a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ g(UCarAdapter.AnonymousClass6 r1, String str, String str2) {
        this.f5455a = r1;
        this.b = str;
        this.c = str2;
    }

    public final void run() {
        this.f5455a.v(this.b, this.c);
    }
}
