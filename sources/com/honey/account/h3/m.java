package com.honey.account.h3;

import com.ucar.vehiclesdk.UCarAdapter;
import com.ucar.vehiclesdk.common.UCarNotification;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarAdapter f4491a;
    public final /* synthetic */ String b;
    public final /* synthetic */ UCarNotification c;

    public /* synthetic */ m(UCarAdapter uCarAdapter, String str, UCarNotification uCarNotification) {
        this.f4491a = uCarAdapter;
        this.b = str;
        this.c = uCarNotification;
    }

    public final void run() {
        this.f4491a.p1(this.b, this.c);
    }
}
