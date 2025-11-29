package com.honey.account.u6;

import com.upuphone.starrynet.core.ble.client.request.BleRequest;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleRequest f5227a;
    public final /* synthetic */ int b;

    public /* synthetic */ a(BleRequest bleRequest, int i) {
        this.f5227a = bleRequest;
        this.b = i;
    }

    public final void run() {
        this.f5227a.lambda$onResponse$0(this.b);
    }
}
