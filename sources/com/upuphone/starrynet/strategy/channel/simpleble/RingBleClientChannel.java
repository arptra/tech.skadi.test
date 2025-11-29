package com.upuphone.starrynet.strategy.channel.simpleble;

import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.client.BleConnectConfig;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class RingBleClientChannel extends SimpleBleClientChannel {
    public BleConnectConfig getConnectConfig(StDevice stDevice) {
        BleConnectConfig bleConnectConfig = new BleConnectConfig(stDevice.getBleMac());
        bleConnectConfig.openHighSpeed(false);
        bleConnectConfig.checkDestCharacterUUID(PayloadConstant.STARRY_NET_PAYLOAD_RING_CHARACTER_UUID);
        return bleConnectConfig;
    }

    public HashMap<UUID, List<UUID>> getNeedNotifyCharacterMap() {
        HashMap<UUID, List<UUID>> hashMap = new HashMap<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add(PayloadConstant.STARRY_NET_PAYLOAD_RING_CHARACTER_UUID);
        hashMap.put(PayloadConstant.STARRY_NET_PAYLOAD_RING_SERVICE_UUID, arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(BluetoothConstants.BATTERY_LEVEL_CHARACTER);
        hashMap.put(BluetoothConstants.BATTERY_SERVICE, arrayList2);
        return hashMap;
    }
}
