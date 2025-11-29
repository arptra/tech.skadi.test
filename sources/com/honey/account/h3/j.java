package com.honey.account.h3;

import com.ucar.vehiclesdk.UCarAdapter;
import com.ucar.vehiclesdk.UCarCommon;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarAdapter f4488a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ int e;
    public final /* synthetic */ UCarCommon.AppState f;
    public final /* synthetic */ int g;
    public final /* synthetic */ int h;
    public final /* synthetic */ UCarCommon.VisibleRegion i;
    public final /* synthetic */ UCarCommon.DisplayMode j;

    public /* synthetic */ j(UCarAdapter uCarAdapter, String str, int i2, boolean z, int i3, UCarCommon.AppState appState, int i4, int i5, UCarCommon.VisibleRegion visibleRegion, UCarCommon.DisplayMode displayMode) {
        this.f4488a = uCarAdapter;
        this.b = str;
        this.c = i2;
        this.d = z;
        this.e = i3;
        this.f = appState;
        this.g = i4;
        this.h = i5;
        this.i = visibleRegion;
        this.j = displayMode;
    }

    public final void run() {
        this.f4488a.k1(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
    }
}
