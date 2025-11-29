package com.upuphone.starrynet.core.ble.client.request;

import android.bluetooth.BluetoothGattDescriptor;
import com.upuphone.starrynet.core.ble.client.listener.WriteDescriptorListener;
import com.upuphone.starrynet.core.ble.client.response.BleResponser;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;
import java.util.UUID;

public class BleNotifyRequest extends BleRequest implements WriteDescriptorListener {
    public BleNotifyRequest(UUID uuid, UUID uuid2, BleResponser bleResponser) {
        super(bleResponser);
        this.mServiceUUID = uuid;
        this.mCharacterUUID = uuid2;
    }

    private void openNotify() {
        BluetoothLog.log("BleNotifyRequest", "openNotify...ServiceUUID is " + this.mServiceUUID + "  CharacterUUID is " + this.mCharacterUUID, new Object[0]);
        if (!setCharacteristicNotification(this.mServiceUUID, this.mCharacterUUID, true)) {
            onRequestCompleted(-1);
        } else {
            startRequestTiming();
        }
    }

    public void onDescriptorWrite(BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
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
            onRequestCompleted(-1);
        } else if (currentStatus == 2) {
            openNotify();
        } else if (currentStatus != 19) {
            onRequestCompleted(-1);
        } else {
            openNotify();
        }
    }
}
