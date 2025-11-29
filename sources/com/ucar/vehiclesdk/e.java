package com.ucar.vehiclesdk;

import com.ucar.vehiclesdk.UCarAdapter;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarAdapter.AnonymousClass6 f5453a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;

    public /* synthetic */ e(UCarAdapter.AnonymousClass6 r1, String str, int i) {
        this.f5453a = r1;
        this.b = str;
        this.c = i;
    }

    public final void run() {
        this.f5453a.s(this.b, this.c);
    }
}
