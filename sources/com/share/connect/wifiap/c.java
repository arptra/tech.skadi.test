package com.share.connect.wifiap;

import com.share.connect.wifiap.WifiApService;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiApService.ApCallbackHandler f9932a;

    public /* synthetic */ c(WifiApService.ApCallbackHandler apCallbackHandler) {
        this.f9932a = apCallbackHandler;
    }

    public final void run() {
        this.f9932a.g();
    }
}
