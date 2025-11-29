package com.honey.account.d4;

import com.upuphone.ar.navi.lite.NaviFragmentActivity;
import com.upuphone.xr.interconnect.common.INaviActionResult;

public final /* synthetic */ class e0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NaviFragmentActivity f4244a;
    public final /* synthetic */ int b;
    public final /* synthetic */ INaviActionResult c;

    public /* synthetic */ e0(NaviFragmentActivity naviFragmentActivity, int i, INaviActionResult iNaviActionResult) {
        this.f4244a = naviFragmentActivity;
        this.b = i;
        this.c = iNaviActionResult;
    }

    public final void run() {
        this.f4244a.o1(this.b, this.c);
    }
}
