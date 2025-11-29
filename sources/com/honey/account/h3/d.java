package com.honey.account.h3;

import com.ucar.vehiclesdk.UCarAdapter;
import com.ucar.vehiclesdk.UCarCommon;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarAdapter f4481a;
    public final /* synthetic */ String b;
    public final /* synthetic */ UCarCommon.POIAddress c;

    public /* synthetic */ d(UCarAdapter uCarAdapter, String str, UCarCommon.POIAddress pOIAddress) {
        this.f4481a = uCarAdapter;
        this.b = str;
        this.c = pOIAddress;
    }

    public final void run() {
        this.f4481a.r1(this.b, this.c);
    }
}
