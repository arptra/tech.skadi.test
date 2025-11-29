package com.honey.account.s7;

import com.upuphone.xr.interconnect.api.StarryNetAppManagerImpl;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StarryNetAppManagerImpl f5135a;

    public /* synthetic */ c(StarryNetAppManagerImpl starryNetAppManagerImpl) {
        this.f5135a = starryNetAppManagerImpl;
    }

    public final void run() {
        this.f5135a.lambda$notifyPeerAppRemoved$4();
    }
}
