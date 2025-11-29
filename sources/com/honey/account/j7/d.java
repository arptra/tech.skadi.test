package com.honey.account.j7;

import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.client.response.BleNotifyResponse;
import com.upuphone.starrynet.strategy.protocol.starrynet.PadStarryNetProtocol;

public final /* synthetic */ class d implements BleNotifyResponse {
    public final void onResponse(int i, Object obj) {
        StLog.v(PadStarryNetProtocol.TAG, "openNotify4Config notify(%s) code=%d", BluetoothConstants.STARRY_NET_READ_CONFIG_UUID.toString(), Integer.valueOf(i));
    }
}
