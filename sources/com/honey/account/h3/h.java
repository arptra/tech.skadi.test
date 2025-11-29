package com.honey.account.h3;

import com.ucar.vehiclesdk.UCarAdapter;
import com.ucar.vehiclesdk.UCarCommon;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarAdapter f4486a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ UCarCommon.AudioFormat f;

    public /* synthetic */ h(UCarAdapter uCarAdapter, boolean z, boolean z2, boolean z3, boolean z4, UCarCommon.AudioFormat audioFormat) {
        this.f4486a = uCarAdapter;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = z4;
        this.f = audioFormat;
    }

    public final void run() {
        this.f4486a.t1(this.b, this.c, this.d, this.e, this.f);
    }
}
