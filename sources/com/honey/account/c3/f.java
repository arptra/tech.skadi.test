package com.honey.account.c3;

import android.content.IntentFilter;
import com.share.connect.wifiap.WifiApService;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiApService f9709a;
    public final /* synthetic */ IntentFilter b;

    public /* synthetic */ f(WifiApService wifiApService, IntentFilter intentFilter) {
        this.f9709a = wifiApService;
        this.b = intentFilter;
    }

    public final void run() {
        this.f9709a.g0(this.b);
    }
}
