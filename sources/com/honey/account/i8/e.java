package com.honey.account.i8;

import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.xr.sapp.glass.GlassUpdateHelper;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GlassUpdateInfo f4856a;

    public /* synthetic */ e(GlassUpdateInfo glassUpdateInfo) {
        this.f4856a = glassUpdateInfo;
    }

    public final void run() {
        GlassUpdateHelper.g0(this.f4856a);
    }
}
