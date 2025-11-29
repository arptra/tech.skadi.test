package com.honey.account.h3;

import com.ucar.vehiclesdk.UCarAdapter;
import java.util.List;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarAdapter f4492a;
    public final /* synthetic */ String b;
    public final /* synthetic */ List c;

    public /* synthetic */ n(UCarAdapter uCarAdapter, String str, List list) {
        this.f4492a = uCarAdapter;
        this.b = str;
        this.c = list;
    }

    public final void run() {
        this.f4492a.q1(this.b, this.c);
    }
}
