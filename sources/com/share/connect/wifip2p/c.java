package com.share.connect.wifip2p;

import com.share.connect.wifip2p.WifiP2pService;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiP2pService.WifiP2pStub f9963a;

    public /* synthetic */ c(WifiP2pService.WifiP2pStub wifiP2pStub) {
        this.f9963a = wifiP2pStub;
    }

    public final void run() {
        this.f9963a.lambda$createGroupForClient$0();
    }
}
