package com.upuphone.starrynet.core.ble.client;

import com.upuphone.starrynet.core.ble.client.listener.GattResponseListener;
import com.upuphone.starrynet.core.ble.client.response.BleResponse;
import java.util.UUID;

public interface IBleWorker {
    void clearGattResponseListener(GattResponseListener gattResponseListener);

    void closeGatt();

    void destroy();

    boolean discoverService();

    int getCurrentStatus();

    void isCharacterExist(UUID uuid, UUID uuid2, BleResponse<Void> bleResponse);

    boolean openGatt(BleConnectConfig bleConnectConfig);

    boolean readCharacteristic(UUID uuid, UUID uuid2);

    boolean refreshDeviceCache();

    void registerGattResponseListener(GattResponseListener gattResponseListener);

    boolean requestMtu(int i);

    boolean setCharacteristicNotification(UUID uuid, UUID uuid2, boolean z);

    boolean writeCharacteristic(UUID uuid, UUID uuid2, byte[] bArr);

    boolean writeCharacteristicWithNoRsp(UUID uuid, UUID uuid2, byte[] bArr);
}
