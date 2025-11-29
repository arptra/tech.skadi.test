package com.honey.account.h3;

import com.ucar.vehiclesdk.UCarAdapter;
import com.ucar.vehiclesdk.UCarCommon;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarAdapter f4489a;
    public final /* synthetic */ String b;
    public final /* synthetic */ UCarCommon.PhoneStateInfo c;

    public /* synthetic */ k(UCarAdapter uCarAdapter, String str, UCarCommon.PhoneStateInfo phoneStateInfo) {
        this.f4489a = uCarAdapter;
        this.b = str;
        this.c = phoneStateInfo;
    }

    public final void run() {
        this.f4489a.w1(this.b, this.c);
    }
}
