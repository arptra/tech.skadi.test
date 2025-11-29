package com.honey.account.d4;

import com.upuphone.ar.navi.lite.NaviFragmentActivity;
import com.upuphone.ar.navi.lite.base.SearchModel;

public final /* synthetic */ class m0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NaviFragmentActivity f4268a;
    public final /* synthetic */ SearchModel b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;

    public /* synthetic */ m0(NaviFragmentActivity naviFragmentActivity, SearchModel searchModel, int i, boolean z) {
        this.f4268a = naviFragmentActivity;
        this.b = searchModel;
        this.c = i;
        this.d = z;
    }

    public final void run() {
        this.f4268a.t1(this.b, this.c, this.d);
    }
}
