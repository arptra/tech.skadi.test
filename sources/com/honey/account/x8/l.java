package com.honey.account.x8;

import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.view.GenericWindowView;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7666a;
    public final /* synthetic */ GenericWindowView b;
    public final /* synthetic */ int c;
    public final /* synthetic */ StarryNetDevice d;

    public /* synthetic */ l(int i, GenericWindowView genericWindowView, int i2, StarryNetDevice starryNetDevice) {
        this.f7666a = i;
        this.b = genericWindowView;
        this.c = i2;
        this.d = starryNetDevice;
    }

    public final void run() {
        GenericWindowView.N(this.f7666a, this.b, this.c, this.d);
    }
}
