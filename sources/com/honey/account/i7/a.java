package com.honey.account.i7;

import com.upuphone.starrynet.strategy.protocol.iccoa.IccoaProtocol;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IccoaProtocol f4853a;
    public final /* synthetic */ Integer b;

    public /* synthetic */ a(IccoaProtocol iccoaProtocol, Integer num) {
        this.f4853a = iccoaProtocol;
        this.b = num;
    }

    public final void run() {
        this.f4853a.lambda$onWiFiEnabled$0(this.b);
    }
}
