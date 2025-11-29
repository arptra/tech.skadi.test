package com.honey.account.s7;

import com.upuphone.xr.interconnect.api.StarryNetAppManagerImpl;
import com.upuphone.xr.interconnect.entity.StarryNetApp;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StarryNetAppManagerImpl f5137a;
    public final /* synthetic */ StarryNetApp b;

    public /* synthetic */ e(StarryNetAppManagerImpl starryNetAppManagerImpl, StarryNetApp starryNetApp) {
        this.f5137a = starryNetAppManagerImpl;
        this.b = starryNetApp;
    }

    public final void run() {
        this.f5137a.lambda$dynamicUpdateStarryNetApp$2(this.b);
    }
}
