package com.upuphone.starrynet.strategy.channel.uup;

import com.upuphone.starrynet.core.ble.client.response.BleReadResponse;

public final /* synthetic */ class c implements BleReadResponse {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UupShareGatt f6540a;

    public /* synthetic */ c(UupShareGatt uupShareGatt) {
        this.f6540a = uupShareGatt;
    }

    public final void onResponse(int i, Object obj) {
        this.f6540a.lambda$readDeviceInfo$3(i, (byte[]) obj);
    }
}
