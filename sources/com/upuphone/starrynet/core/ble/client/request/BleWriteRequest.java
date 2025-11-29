package com.upuphone.starrynet.core.ble.client.request;

import android.bluetooth.BluetoothGattCharacteristic;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.client.listener.WriteCharacterListener;
import com.upuphone.starrynet.core.ble.client.response.BleResponser;
import java.util.UUID;

public class BleWriteRequest extends BleRequest implements WriteCharacterListener {
    public BleWriteRequest(UUID uuid, UUID uuid2, byte[] bArr, BleResponser bleResponser) {
        super(bleResponser);
        this.mServiceUUID = uuid;
        this.mCharacterUUID = uuid2;
        this.mBytes = bArr;
    }

    private void startWrite() {
        if (!writeCharacteristic(this.mServiceUUID, this.mCharacterUUID, this.mBytes)) {
            onRequestCompleted(-1);
        } else {
            startRequestTiming();
        }
    }

    public void onCharacteristicWrite(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte[] bArr) {
        stopRequestTiming();
        if (i == 0) {
            putByteArray(BluetoothConstants.KEY_CHARACTER_VALUE, bArr);
            onRequestCompleted(0);
            return;
        }
        onRequestCompleted(-1);
    }

    public void processRequest() {
        int currentStatus = getCurrentStatus();
        if (currentStatus == 0) {
            onRequestCompleted(-1);
        } else if (currentStatus == 2) {
            startWrite();
        } else if (currentStatus != 19) {
            onRequestCompleted(-1);
        } else {
            startWrite();
        }
    }
}
