package com.honey.account.k7;

import com.upuphone.starrynet.core.ble.client.response.BleReadResponse;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.protocol.uupshare.UupShareProtocol;

public final /* synthetic */ class a implements BleReadResponse {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UupShareProtocol f4911a;
    public final /* synthetic */ StConnectDevice b;

    public /* synthetic */ a(UupShareProtocol uupShareProtocol, StConnectDevice stConnectDevice) {
        this.f4911a = uupShareProtocol;
        this.b = stConnectDevice;
    }

    public final void onResponse(int i, Object obj) {
        this.f4911a.lambda$readDeviceInfo$0(this.b, i, (byte[]) obj);
    }
}
