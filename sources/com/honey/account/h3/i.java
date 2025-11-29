package com.honey.account.h3;

import com.ucar.vehiclesdk.UCarAdapter;
import com.ucar.vehiclesdk.UCarCommon;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarAdapter f4487a;
    public final /* synthetic */ String b;
    public final /* synthetic */ UCarCommon.CallInfo c;

    public /* synthetic */ i(UCarAdapter uCarAdapter, String str, UCarCommon.CallInfo callInfo) {
        this.f4487a = uCarAdapter;
        this.b = str;
        this.c = callInfo;
    }

    public final void run() {
        this.f4487a.l1(this.b, this.c);
    }
}
