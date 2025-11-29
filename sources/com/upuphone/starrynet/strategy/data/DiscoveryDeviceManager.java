package com.upuphone.starrynet.strategy.data;

import android.bluetooth.BluetoothDevice;
import android.hardware.usb.UsbAccessory;
import android.text.TextUtils;
import android.util.LruCache;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import java.util.ArrayList;
import java.util.List;

final class DiscoveryDeviceManager {
    private static final String TAG = "DiscoveryDeviceManager";
    private final LruCache<String, StDiscoveryDevice> hmFoundDevices = new LruCache<>(128);
    private final LruCache<String, StDiscoveryDevice> mFoundByBleDevices = new LruCache<>(128);

    public void addDevice(StDiscoveryDevice stDiscoveryDevice) {
        String identifier2String = stDiscoveryDevice.getIdentifier2String();
        if (identifier2String == null) {
            StLog.i(TAG, "the idStr of device is null");
            return;
        }
        StDiscoveryDevice stDiscoveryDevice2 = this.hmFoundDevices.get(identifier2String);
        if (stDiscoveryDevice2 == null) {
            StLog.d(TAG, "Add new idStr: " + identifier2String + " device : " + stDiscoveryDevice);
            this.hmFoundDevices.put(identifier2String, stDiscoveryDevice);
        } else {
            stDiscoveryDevice2.copyDeviceInfo(stDiscoveryDevice);
            if (stDiscoveryDevice.getDeviceType() == 3) {
                byte discoveryType = stDiscoveryDevice.getDiscoveryType();
                if (discoveryType == 16) {
                    stDiscoveryDevice2.setCarPinCode(stDiscoveryDevice.getCarPinCode());
                    stDiscoveryDevice2.setUsbAccessory(stDiscoveryDevice.getUsbAccessory());
                } else if (discoveryType == 1) {
                    stDiscoveryDevice2.setIccoaSerialNum(stDiscoveryDevice.getIccoaSerialNum());
                }
                StLog.v(TAG, "addDevice: foundDevice:" + stDiscoveryDevice2.getDiscoveryType() + " device:" + discoveryType);
                byte discoveryType2 = stDiscoveryDevice2.getDiscoveryType();
                if (discoveryType2 != discoveryType) {
                    discoveryType2 = (byte) (discoveryType | discoveryType2);
                    stDiscoveryDevice2.setDiscType(discoveryType2);
                    stDiscoveryDevice.setDiscType(discoveryType2);
                }
                if ((discoveryType2 & 16) == 0) {
                    stDiscoveryDevice2.setCarPinCode((String) null);
                    stDiscoveryDevice2.setUsbAccessory((UsbAccessory) null);
                }
                if ((discoveryType2 & 1) == 0) {
                    stDiscoveryDevice2.setIccoaSerialNum((String) null);
                }
                stDiscoveryDevice.setCarPinCode(stDiscoveryDevice2.getCarPinCode());
                stDiscoveryDevice.setUsbAccessory(stDiscoveryDevice2.getUsbAccessory());
                stDiscoveryDevice.setIccoaSerialNum(stDiscoveryDevice2.getIccoaSerialNum());
            }
        }
        String bleMac = stDiscoveryDevice.getBleMac();
        if (!TextUtils.isEmpty(bleMac)) {
            this.mFoundByBleDevices.put(bleMac, stDiscoveryDevice);
        }
    }

    public BluetoothDevice getBluetoothDevice(byte[] bArr) {
        StDiscoveryDevice stDiscoveryDevice = this.hmFoundDevices.get(StDevice.bytes2HexString(bArr));
        if (stDiscoveryDevice != null) {
            return stDiscoveryDevice.getBluetoothDevice();
        }
        return null;
    }

    public StDiscoveryDevice getDevice(byte[] bArr) {
        if (bArr != null) {
            return this.hmFoundDevices.get(StDevice.bytes2HexString(bArr));
        }
        StLog.i(TAG, "getDevice identifier null");
        return null;
    }

    public StDiscoveryDevice getDeviceByBleMac(String str) {
        if (str != null) {
            return this.mFoundByBleDevices.get(str);
        }
        StLog.i(TAG, "getDeviceByBleMac bleMac null");
        return null;
    }

    public List<StDiscoveryDevice> getDevices() {
        return new ArrayList(this.hmFoundDevices.snapshot().values());
    }

    public StDiscoveryDevice removeDevice(String str) {
        StLog.i(TAG, "removeDevice id = " + str);
        return this.hmFoundDevices.remove(str);
    }
}
