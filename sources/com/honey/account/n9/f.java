package com.honey.account.n9;

import com.upuphone.xr.sapp.entity.GlassCheckUpdateState;
import com.xjmz.myvu.MYVUActivity;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Boolean f7466a;
    public final /* synthetic */ GlassCheckUpdateState b;
    public final /* synthetic */ MYVUActivity c;

    public /* synthetic */ f(Boolean bool, GlassCheckUpdateState glassCheckUpdateState, MYVUActivity mYVUActivity) {
        this.f7466a = bool;
        this.b = glassCheckUpdateState;
        this.c = mYVUActivity;
    }

    public final void run() {
        MYVUActivity.F1(this.f7466a, this.b, this.c);
    }
}
