package com.honey.account.k7;

import com.upuphone.starrynet.core.ble.client.response.BleWriteResponse;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.protocol.uupshare.UupShareProtocol;

public final /* synthetic */ class b implements BleWriteResponse {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UupShareProtocol f4912a;
    public final /* synthetic */ StConnectDevice b;

    public /* synthetic */ b(UupShareProtocol uupShareProtocol, StConnectDevice stConnectDevice) {
        this.f4912a = uupShareProtocol;
        this.b = stConnectDevice;
    }

    public final void onResponse(int i, Object obj) {
        this.f4912a.lambda$sendP2PInfo2PeerDevice$1(this.b, i, (byte[]) obj);
    }
}
