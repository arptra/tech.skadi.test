package com.upuphone.starrynetsdk.ability.ble;

import com.upuphone.runasone.ble.BleRawDevice;
import com.upuphone.runasone.ble.ConnectConfig;

public class BleDevice extends BleRawDevice {
    private final BleAbility bleAbility;

    public BleDevice(String str, String str2, String str3, String str4, String str5, String str6, byte[] bArr, BleAbility bleAbility2) {
        super(str, str2, str3, str4, str5, str6, bArr);
        this.bleAbility = bleAbility2;
    }

    public static BleDevice wrap(BleRawDevice bleRawDevice) {
        BleAbility bleAbility2 = new BleAbility();
        bleAbility2.setDeviceId(bleRawDevice.getDeviceId());
        return new BleDevice(bleRawDevice.getDeviceId(), bleRawDevice.getVid(), bleRawDevice.getPid(), bleRawDevice.getVersion(), bleRawDevice.getDeviceName(), bleRawDevice.getAddress(), bleRawDevice.getPayload(), bleAbility2);
    }

    public int connect(ConnectConfig connectConfig) {
        return this.bleAbility.connect(connectConfig);
    }

    public int disconnect() {
        return this.bleAbility.disconnect();
    }

    public void registerDeviceListener(BleDeviceListener bleDeviceListener) {
        this.bleAbility.registerDeviceListener(bleDeviceListener);
    }

    public void unregisterDeviceListener() {
        this.bleAbility.unregisterDeviceListener();
    }

    public BleRawDevice unwrap() {
        return new BleRawDevice(getDeviceId(), getVid(), getPid(), getVersion(), getDeviceName(), getAddress(), getPayload());
    }
}
