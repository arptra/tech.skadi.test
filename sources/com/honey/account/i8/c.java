package com.honey.account.i8;

import com.upuphone.starrynetsdk.InstallListener;
import com.upuphone.xr.sapp.glass.GlassLogUpdateHelper;

public final /* synthetic */ class c implements InstallListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GlassLogUpdateHelper f4855a;

    public /* synthetic */ c(GlassLogUpdateHelper glassLogUpdateHelper) {
        this.f4855a = glassLogUpdateHelper;
    }

    public final void onInstalled() {
        GlassLogUpdateHelper.b(this.f4855a);
    }
}
