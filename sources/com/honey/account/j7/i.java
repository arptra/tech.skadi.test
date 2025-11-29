package com.honey.account.j7;

import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.core.ble.client.response.BleReadResponse;
import com.upuphone.starrynet.strategy.pair.IPairMsgCallback;

public final /* synthetic */ class i implements BleReadResponse {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IPairMsgCallback f4888a;
    public final /* synthetic */ StDevice b;

    public /* synthetic */ i(IPairMsgCallback iPairMsgCallback, StDevice stDevice) {
        this.f4888a = iPairMsgCallback;
        this.b = stDevice;
    }

    public final void onResponse(int i, Object obj) {
        this.f4888a.onResponse(this.b, (byte[]) obj, i);
    }
}
