package com.ucar.vehiclesdk;

import com.ucar.vehiclesdk.UCarAdapter;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarAdapter.AnonymousClass6 f5457a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ i(UCarAdapter.AnonymousClass6 r1, boolean z) {
        this.f5457a = r1;
        this.b = z;
    }

    public final void run() {
        this.f5457a.t(this.b);
    }
}
