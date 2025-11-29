package com.share.connect.wifiap;

import com.share.connect.wifiap.WifiApService;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiApService.ApCallbackHandler f9934a;

    public /* synthetic */ e(WifiApService.ApCallbackHandler apCallbackHandler) {
        this.f9934a = apCallbackHandler;
    }

    public final void run() {
        this.f9934a.i();
    }
}
