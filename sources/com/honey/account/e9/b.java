package com.honey.account.e9;

import android.os.IBinder;
import com.upuphone.xr.sapp.vu.utils.GlassesManager;

public final /* synthetic */ class b implements IBinder.DeathRecipient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GlassesManager f7282a;

    public /* synthetic */ b(GlassesManager glassesManager) {
        this.f7282a = glassesManager;
    }

    public final void binderDied() {
        this.f7282a.t();
    }
}
