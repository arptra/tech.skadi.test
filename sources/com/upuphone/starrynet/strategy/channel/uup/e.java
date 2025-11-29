package com.upuphone.starrynet.strategy.channel.uup;

import com.upuphone.starrynet.core.ble.client.response.BleNotifyResponse;

public final /* synthetic */ class e implements BleNotifyResponse {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UupShareGatt f6542a;

    public /* synthetic */ e(UupShareGatt uupShareGatt) {
        this.f6542a = uupShareGatt;
    }

    public final void onResponse(int i, Object obj) {
        this.f6542a.lambda$openNotify$2(i, (Void) obj);
    }
}
