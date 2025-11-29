package com.honey.account.z6;

import com.upuphone.starrynet.core.ble.client.response.BleRequestMtuResponse;
import com.upuphone.starrynet.strategy.channel.ble.BleClientChannel;

public final /* synthetic */ class b implements BleRequestMtuResponse {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleClientChannel f5346a;
    public final /* synthetic */ String b;

    public /* synthetic */ b(BleClientChannel bleClientChannel, String str) {
        this.f5346a = bleClientChannel;
        this.b = str;
    }

    public final void onResponse(int i, Object obj) {
        this.f5346a.lambda$requestMtu$1(this.b, i, (Integer) obj);
    }
}
