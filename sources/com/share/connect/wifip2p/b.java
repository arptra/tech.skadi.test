package com.share.connect.wifip2p;

import android.net.wifi.p2p.WifiP2pGroup;
import com.share.connect.wifip2p.WifiP2pService;
import com.share.connect.wifip2p.proxy.GroupInfo;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiP2pService.AnonymousClass11.AnonymousClass1 f9962a;
    public final /* synthetic */ WifiP2pGroup b;
    public final /* synthetic */ GroupInfo c;

    public /* synthetic */ b(WifiP2pService.AnonymousClass11.AnonymousClass1 r1, WifiP2pGroup wifiP2pGroup, GroupInfo groupInfo) {
        this.f9962a = r1;
        this.b = wifiP2pGroup;
        this.c = groupInfo;
    }

    public final void run() {
        this.f9962a.b(this.b, this.c);
    }
}
