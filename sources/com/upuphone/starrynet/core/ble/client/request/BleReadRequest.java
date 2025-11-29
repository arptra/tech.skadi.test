package com.upuphone.starrynet.core.ble.client.request;

import android.bluetooth.BluetoothGattCharacteristic;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.client.listener.ReadCharacterListener;
import com.upuphone.starrynet.core.ble.client.response.BleResponser;
import java.util.UUID;

public class BleReadRequest extends BleRequest implements ReadCharacterListener {
    public BleReadRequest(UUID uuid, UUID uuid2, BleResponser bleResponser) {
        super(bleResponser);
        this.mServiceUUID = uuid;
        this.mCharacterUUID = uuid2;
    }

    private void startRead() {
        if (!readCharacteristic(this.mServiceUUID, this.mCharacterUUID)) {
            onRequestCompleted(-1);
        } else {
            startRequestTiming();
        }
    }

    public void onCharacteristicRead(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte[] bArr) {
        stopRequestTiming();
        if (i == 0) {
            putByteArray(BluetoothConstants.KEY_BYTES, bArr);
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
            startRead();
        } else if (currentStatus != 19) {
            onRequestCompleted(-1);
        } else {
            startRead();
        }
    }
}
