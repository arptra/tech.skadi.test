package com.honey.account.h3;

import com.ucar.vehiclesdk.UCarAdapter;
import com.ucar.vehiclesdk.UCarCommon;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarAdapter f4479a;
    public final /* synthetic */ String b;
    public final /* synthetic */ UCarCommon.NavigationInfo c;

    public /* synthetic */ c(UCarAdapter uCarAdapter, String str, UCarCommon.NavigationInfo navigationInfo) {
        this.f4479a = uCarAdapter;
        this.b = str;
        this.c = navigationInfo;
    }

    public final void run() {
        this.f4479a.v1(this.b, this.c);
    }
}
