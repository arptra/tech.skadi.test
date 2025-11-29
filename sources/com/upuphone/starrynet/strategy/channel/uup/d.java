package com.upuphone.starrynet.strategy.channel.uup;

import com.upuphone.starrynet.core.ble.client.response.BleWriteResponse;

public final /* synthetic */ class d implements BleWriteResponse {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UupShareGatt f6541a;

    public /* synthetic */ d(UupShareGatt uupShareGatt) {
        this.f6541a = uupShareGatt;
    }

    public final void onResponse(int i, Object obj) {
        this.f6541a.lambda$sendP2PInfo2PeerDevice$4(i, (byte[]) obj);
    }
}
