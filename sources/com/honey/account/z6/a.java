package com.honey.account.z6;

import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.client.response.BleNotifyResponse;
import com.upuphone.starrynet.strategy.channel.ble.BleClientChannel;

public final /* synthetic */ class a implements BleNotifyResponse {
    public final void onResponse(int i, Object obj) {
        StLog.i((String) BleClientChannel.TAG, "openNotify4Message notify(%s) code=%d", BluetoothConstants.STARRY_NET_WRITE_MESSAGE_UUID.toString(), Integer.valueOf(i));
    }
}
