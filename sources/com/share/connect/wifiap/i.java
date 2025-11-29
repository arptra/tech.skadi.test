package com.share.connect.wifiap;

import com.share.connect.wifiap.WifiApService;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiApService.WifiApStub f9938a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ boolean g;

    public /* synthetic */ i(WifiApService.WifiApStub wifiApStub, String str, String str2, int i, boolean z, boolean z2, boolean z3) {
        this.f9938a = wifiApStub;
        this.b = str;
        this.c = str2;
        this.d = i;
        this.e = z;
        this.f = z2;
        this.g = z3;
    }

    public final void run() {
        this.f9938a.lambda$createSoftAp$0(this.b, this.c, this.d, this.e, this.f, this.g);
    }
}
