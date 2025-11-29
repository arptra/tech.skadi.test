package com.upuphone.starrynet.core.ble.client.request;

import android.bluetooth.BluetoothGattCharacteristic;
import com.upuphone.starrynet.core.ble.client.listener.WriteCharacterListener;
import com.upuphone.starrynet.core.ble.client.response.BleResponser;
import java.util.UUID;

public class BleWriteNoRspRequest extends BleRequest implements WriteCharacterListener {
    public BleWriteNoRspRequest(UUID uuid, UUID uuid2, byte[] bArr, BleResponser bleResponser) {
        super(bleResponser);
        this.mServiceUUID = uuid;
        this.mCharacterUUID = uuid2;
        this.mBytes = bArr;
    }

    private void startWrite() {
        if (!writeCharacteristicWithNoRsp(this.mServiceUUID, this.mCharacterUUID, this.mBytes)) {
            onRequestCompleted(-1);
        } else {
            startRequestTiming();
        }
    }

    public void onCharacteristicWrite(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte[] bArr) {
        stopRequestTiming();
        if (i == 0) {
            onRequestCompleted(0);
        } else {
            onRequestCompleted(-1);
        }
    }

    public void processRequest() {
        int currentStatus = getCurrentStatus();
        if (currentStatus == 0) {
            onRequestCompleted(-8);
        } else if (currentStatus == 2 || currentStatus == 19) {
            startWrite();
        } else {
            onRequestCompleted(-1);
        }
    }
}
