package com.share.connect.wifiap;

import com.share.connect.wifiap.WifiApService;
import java.util.List;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiApService.ApCallbackHandler f9931a;
    public final /* synthetic */ List b;

    public /* synthetic */ b(WifiApService.ApCallbackHandler apCallbackHandler, List list) {
        this.f9931a = apCallbackHandler;
        this.b = list;
    }

    public final void run() {
        this.f9931a.f(this.b);
    }
}
