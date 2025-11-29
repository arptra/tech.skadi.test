package com.share.connect.wifiap;

import android.net.wifi.SoftApConfiguration;
import com.share.connect.wifiap.WifiApService;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiApService.ApCallbackHandler f9933a;
    public final /* synthetic */ int b;
    public final /* synthetic */ SoftApConfiguration c;

    public /* synthetic */ d(WifiApService.ApCallbackHandler apCallbackHandler, int i, SoftApConfiguration softApConfiguration) {
        this.f9933a = apCallbackHandler;
        this.b = i;
        this.c = softApConfiguration;
    }

    public final void run() {
        this.f9933a.h(this.b, this.c);
    }
}
