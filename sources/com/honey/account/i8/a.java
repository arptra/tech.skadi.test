package com.honey.account.i8;

import com.upuphone.starrynetsdk.InstallListener;
import com.upuphone.xr.sapp.glass.AirGlassUpdater;

public final /* synthetic */ class a implements InstallListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AirGlassUpdater f4854a;

    public /* synthetic */ a(AirGlassUpdater airGlassUpdater) {
        this.f4854a = airGlassUpdater;
    }

    public final void onInstalled() {
        AirGlassUpdater.l(this.f4854a);
    }
}
