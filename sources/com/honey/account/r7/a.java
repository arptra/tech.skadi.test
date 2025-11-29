package com.honey.account.r7;

import com.upuphone.xr.interconnect.InterconnectManager;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterconnectManager f5118a;
    public final /* synthetic */ String b;

    public /* synthetic */ a(InterconnectManager interconnectManager, String str) {
        this.f5118a = interconnectManager;
        this.b = str;
    }

    public final void run() {
        this.f5118a.lambda$toast$0(this.b);
    }
}
