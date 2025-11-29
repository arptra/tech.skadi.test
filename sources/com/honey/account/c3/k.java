package com.honey.account.c3;

import android.net.wifi.SoftApConfiguration;
import com.share.connect.wifiap.WifiApService;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiApService f9714a;
    public final /* synthetic */ SoftApConfiguration b;

    public /* synthetic */ k(WifiApService wifiApService, SoftApConfiguration softApConfiguration) {
        this.f9714a = wifiApService;
        this.b = softApConfiguration;
    }

    public final void run() {
        this.f9714a.c0(this.b);
    }
}
