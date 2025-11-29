package com.honey.account.z6;

import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.client.response.BleNotifyResponse;
import com.upuphone.starrynet.strategy.channel.ble.BleClientChannel;
import java.util.UUID;

public final /* synthetic */ class d implements BleNotifyResponse {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UUID f5348a;

    public /* synthetic */ d(UUID uuid) {
        this.f5348a = uuid;
    }

    public final void onResponse(int i, Object obj) {
        StLog.i((String) BleClientChannel.TAG, "openNotify(%s) code=%d", this.f5348a.toString(), Integer.valueOf(i));
    }
}
