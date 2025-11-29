package com.upuphone.starrynet.strategy.service;

import android.os.Bundle;
import com.upuphone.starrynet.api.IStarryNetConfig;
import com.upuphone.starrynet.api.StConstant;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;

public class StarryNetConfigManager implements IStarryNetConfig {
    private static final String TAG = "StarryNetConfigManager";

    private Bundle buildAllConfig() {
        Bundle bundle = new Bundle();
        bundle.putAll(buildLogConfig());
        return bundle;
    }

    private Bundle buildLogConfig() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(StConstant.KEY_OPEN_BLE_DETAIL_LOG, false);
        bundle.putBoolean(StConstant.KEY_OPEN_BLUETOOTH_ADVERTISE_DETAIL_LOG, false);
        return bundle;
    }

    public Bundle getConfig(int i) {
        if (i == 1) {
            return buildLogConfig();
        }
        StLog.w(TAG, "getConfig ,not support scene =%d", Integer.valueOf(i));
        return new Bundle();
    }

    public Bundle getConfigAll() {
        return buildAllConfig();
    }

    public void updateConfig(Bundle bundle) {
        if (bundle.containsKey(StConstant.KEY_OPEN_BLE_DETAIL_LOG)) {
            int i = 0;
            boolean z = bundle.getBoolean(StConstant.KEY_OPEN_BLE_DETAIL_LOG, false);
            StLog.d(TAG, "onReceive: KEY_OPEN_BLE_DETAIL_LOG, switch=" + z);
            if (z) {
                i = 2;
            }
            BluetoothLog.setLogMode(i);
        }
        if (bundle.containsKey(StConstant.KEY_OPEN_BLUETOOTH_ADVERTISE_DETAIL_LOG)) {
            boolean z2 = bundle.getBoolean(StConstant.KEY_OPEN_BLUETOOTH_ADVERTISE_DETAIL_LOG, true);
            StLog.d(TAG, "onReceive: KEY_OPEN_BLUETOOTH_ADVERTISE_DETAIL_LOG, switch=" + z2);
        }
    }
}
