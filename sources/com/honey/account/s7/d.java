package com.honey.account.s7;

import com.upuphone.xr.interconnect.api.OpenRemoteStarryNetAppCallback;
import com.upuphone.xr.interconnect.api.StarryNetAppManagerImpl;
import com.upuphone.xr.interconnect.api.StarryNetMessenger;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StarryNetAppManagerImpl f5136a;
    public final /* synthetic */ StarryNetMessenger b;
    public final /* synthetic */ StarryNetMessage c;
    public final /* synthetic */ String d;
    public final /* synthetic */ OpenRemoteStarryNetAppCallback e;

    public /* synthetic */ d(StarryNetAppManagerImpl starryNetAppManagerImpl, StarryNetMessenger starryNetMessenger, StarryNetMessage starryNetMessage, String str, OpenRemoteStarryNetAppCallback openRemoteStarryNetAppCallback) {
        this.f5136a = starryNetAppManagerImpl;
        this.b = starryNetMessenger;
        this.c = starryNetMessage;
        this.d = str;
        this.e = openRemoteStarryNetAppCallback;
    }

    public final void run() {
        this.f5136a.lambda$openRemoteStarryNetApp$1(this.b, this.c, this.d, this.e);
    }
}
