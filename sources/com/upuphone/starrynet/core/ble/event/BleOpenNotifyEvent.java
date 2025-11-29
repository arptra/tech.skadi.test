package com.upuphone.starrynet.core.ble.event;

import android.bluetooth.BluetoothGattDescriptor;
import java.util.Arrays;
import java.util.UUID;

public class BleOpenNotifyEvent {
    private UUID character;
    private String mac;
    private byte[] value;

    public BleOpenNotifyEvent(String str, UUID uuid, byte[] bArr) {
        this.mac = str;
        this.character = uuid;
        this.value = bArr;
    }

    public UUID getCharacter() {
        return this.character;
    }

    public String getMac() {
        return this.mac;
    }

    public boolean isDisable() {
        byte[] bArr = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        byte[] bArr2 = this.value;
        return bArr2 != null && bArr2.length == 2 && bArr[0] == bArr2[0] && bArr[1] == bArr2[1];
    }

    public boolean isEnable() {
        byte[] bArr = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        byte[] bArr2 = this.value;
        return bArr2 != null && bArr2.length == 2 && bArr[0] == bArr2[0] && bArr[1] == bArr2[1];
    }

    public String toString() {
        return "BleOpenNotifyEvent{mac='" + this.mac + '\'' + ", character=" + this.character + ", value=" + Arrays.toString(this.value) + '}';
    }
}
