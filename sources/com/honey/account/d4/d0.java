package com.honey.account.d4;

import com.upuphone.ar.navi.lite.MapLocationActivity;

public final /* synthetic */ class d0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MapLocationActivity f4241a;
    public final /* synthetic */ float b;

    public /* synthetic */ d0(MapLocationActivity mapLocationActivity, float f) {
        this.f4241a = mapLocationActivity;
        this.b = f;
    }

    public final void run() {
        this.f4241a.l1(this.b);
    }
}
