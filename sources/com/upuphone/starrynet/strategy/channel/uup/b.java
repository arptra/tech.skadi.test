package com.upuphone.starrynet.strategy.channel.uup;

import com.upuphone.starrynet.core.ble.client.response.BleRequestMtuResponse;

public final /* synthetic */ class b implements BleRequestMtuResponse {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UupShareGatt f6539a;

    public /* synthetic */ b(UupShareGatt uupShareGatt) {
        this.f6539a = uupShareGatt;
    }

    public final void onResponse(int i, Object obj) {
        this.f6539a.lambda$requestMtu$1(i, (Integer) obj);
    }
}
