package com.honey.account.i8;

import com.upuphone.starrynetsdk.InstallListener;
import com.upuphone.xr.sapp.glass.StarGlassUpdater;

public final /* synthetic */ class k implements InstallListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StarGlassUpdater f4862a;

    public /* synthetic */ k(StarGlassUpdater starGlassUpdater) {
        this.f4862a = starGlassUpdater;
    }

    public final void onInstalled() {
        StarGlassUpdater.l(this.f4862a);
    }
}
