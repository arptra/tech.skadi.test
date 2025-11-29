package com.share.connect.wifiap;

import com.share.connect.wifiap.WifiApService;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiApService.ApCallbackHandler f9935a;
    public final /* synthetic */ Object[] b;

    public /* synthetic */ f(WifiApService.ApCallbackHandler apCallbackHandler, Object[] objArr) {
        this.f9935a = apCallbackHandler;
        this.b = objArr;
    }

    public final void run() {
        this.f9935a.j(this.b);
    }
}
