package com.honey.account.j7;

import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.client.response.BleNotifyResponse;
import com.upuphone.starrynet.strategy.protocol.starrynet.PhoneStarryNetProtocol;
import java.util.UUID;

public final /* synthetic */ class g implements BleNotifyResponse {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UUID f4886a;

    public /* synthetic */ g(UUID uuid) {
        this.f4886a = uuid;
    }

    public final void onResponse(int i, Object obj) {
        StLog.d((String) PhoneStarryNetProtocol.TAG, "open notify(%s) code=%d", this.f4886a.toString(), Integer.valueOf(i));
    }
}
