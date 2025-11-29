package com.honey.account.z6;

import android.os.Bundle;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.core.ble.client.response.BleConnectResponse;
import com.upuphone.starrynet.strategy.channel.ble.BleClientChannel;

public final /* synthetic */ class c implements BleConnectResponse {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleClientChannel f5347a;
    public final /* synthetic */ StDevice b;

    public /* synthetic */ c(BleClientChannel bleClientChannel, StDevice stDevice) {
        this.f5347a = bleClientChannel;
        this.b = stDevice;
    }

    public final void onResponse(int i, Object obj) {
        this.f5347a.lambda$connectBle$0(this.b, i, (Bundle) obj);
    }
}
