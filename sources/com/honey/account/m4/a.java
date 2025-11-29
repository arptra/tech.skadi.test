package com.honey.account.m4;

import com.upuphone.ar.navi.lite.service.NaviDocerService;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NaviDocerService f4940a;
    public final /* synthetic */ StarryNetMessage b;

    public /* synthetic */ a(NaviDocerService naviDocerService, StarryNetMessage starryNetMessage) {
        this.f4940a = naviDocerService;
        this.b = starryNetMessage;
    }

    public final void run() {
        this.f4940a.n(this.b);
    }
}
