package com.honey.account.m9;

import android.os.IBinder;
import com.xjmz.glasses.ipc.client.GlassesManager;

public final /* synthetic */ class a implements IBinder.DeathRecipient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GlassesManager f7461a;

    public /* synthetic */ a(GlassesManager glassesManager) {
        this.f7461a = glassesManager;
    }

    public final void binderDied() {
        this.f7461a.g();
    }
}
