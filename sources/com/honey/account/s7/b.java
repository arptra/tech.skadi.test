package com.honey.account.s7;

import com.upuphone.xr.interconnect.api.StarryNetAppManagerImpl;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StarryNetAppManagerImpl f5134a;

    public /* synthetic */ b(StarryNetAppManagerImpl starryNetAppManagerImpl) {
        this.f5134a = starryNetAppManagerImpl;
    }

    public final void run() {
        this.f5134a.lambda$notifyPeerAppInstalled$3();
    }
}
