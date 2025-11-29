package com.upuphone.starrynet.strategy.channel.uup;

import android.os.Bundle;
import com.upuphone.starrynet.core.ble.client.response.BleConnectResponse;

public final /* synthetic */ class a implements BleConnectResponse {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UupShareGatt f6538a;

    public /* synthetic */ a(UupShareGatt uupShareGatt) {
        this.f6538a = uupShareGatt;
    }

    public final void onResponse(int i, Object obj) {
        this.f6538a.lambda$connect$0(i, (Bundle) obj);
    }
}
