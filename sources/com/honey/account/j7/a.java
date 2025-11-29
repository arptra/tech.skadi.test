package com.honey.account.j7;

import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.client.response.BleNotifyResponse;
import com.upuphone.starrynet.strategy.protocol.starrynet.PadStarryNetProtocol;
import java.util.UUID;

public final /* synthetic */ class a implements BleNotifyResponse {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UUID f4882a;

    public /* synthetic */ a(UUID uuid) {
        this.f4882a = uuid;
    }

    public final void onResponse(int i, Object obj) {
        StLog.d((String) PadStarryNetProtocol.TAG, "open notify(%s) code=%d", this.f4882a.toString(), Integer.valueOf(i));
    }
}
