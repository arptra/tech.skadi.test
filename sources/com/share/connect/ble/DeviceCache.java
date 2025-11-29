package com.share.connect.ble;

import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.easy.logger.EasyLog;
import com.share.connect.Device;
import com.share.connect.ble.Constants;

class DeviceCache {

    /* renamed from: a  reason: collision with root package name */
    public OnDeviceChangeCallback f9903a;
    public ArrayMap b = new ArrayMap();

    public class BtDevice extends Device {
        private int mSignal;
        /* access modifiers changed from: private */
        public String mac;

        public BtDevice() {
        }

        public String getMac() {
            return this.mac;
        }

        public int getSignal() {
            return this.mSignal;
        }

        public BtDevice setMac(String str) {
            this.mac = str;
            return this;
        }

        public BtDevice setSignal(int i) {
            this.mSignal = i;
            return this;
        }
    }

    public interface OnDeviceChangeCallback {
        void a(BtDevice btDevice);

        void b(BtDevice btDevice);
    }

    public boolean a(String str) {
        return this.b.containsKey(str);
    }

    public final boolean b(String str) {
        for (BtDevice access$000 : this.b.values()) {
            if (TextUtils.equals(str, access$000.mac)) {
                return true;
            }
        }
        return false;
    }

    public final BtDevice c(String str) {
        for (BtDevice btDevice : this.b.values()) {
            if (TextUtils.equals(str, btDevice.mac)) {
                return btDevice;
            }
        }
        return null;
    }

    public String d(String str) {
        BtDevice btDevice = (BtDevice) this.b.get(str);
        if (btDevice != null) {
            return btDevice.mac;
        }
        EasyLog.i("DeviceCache", "Try to get mac with an id which is not exist.");
        return "";
    }

    public ArrayMap e() {
        ArrayMap arrayMap = new ArrayMap();
        for (BtDevice btDevice : this.b.values()) {
            arrayMap.put(btDevice.getVin(), Integer.valueOf(btDevice.getSignal()));
        }
        return arrayMap;
    }

    public final boolean f(ScanResult scanResult) {
        ScanRecord scanRecord = scanResult.getScanRecord();
        if (scanRecord == null) {
            EasyLog.c("DeviceCache", "ScanRecord is null.");
            return false;
        } else if (scanResult.getDevice() == null) {
            EasyLog.c("DeviceCache", "BluetoothDevice is null.");
            return false;
        } else {
            if ((scanRecord.getServiceUuids() != null ? scanRecord.getServiceUuids().get(0) : null) != null) {
                return true;
            }
            EasyLog.c("DeviceCache", "Service UUID is null, it shouldn't happen.");
            return false;
        }
    }

    public void g(ScanResult scanResult) {
        if (f(scanResult)) {
            h(scanResult.getDevice().getAddress());
        }
    }

    public final void h(String str) {
        do {
            BtDevice c = c(str);
            if (c != null) {
                this.b.remove(c.getVin());
                this.f9903a.a(c);
            }
        } while (c(str) != null);
    }

    public void i(ScanResult scanResult) {
        BtDevice k;
        if (f(scanResult)) {
            try {
                if (Constants.ServiceInfo.b.equals(scanResult.getScanRecord().getServiceUuids().get(0)) && (k = k(scanResult)) != null) {
                    j(k);
                }
            } catch (Exception e) {
                EasyLog.c("DeviceCache", "Parse data error: " + e.getMessage() + ", ignored.");
            }
        }
    }

    public final void j(BtDevice btDevice) {
        String access$000 = btDevice.mac;
        String vin = btDevice.getVin();
        String pName = btDevice.getPName();
        boolean a2 = a(vin);
        boolean b2 = b(access$000);
        if (!a2) {
            this.b.put(vin, btDevice);
            this.f9903a.b(btDevice);
        } else if (!b2) {
            BtDevice btDevice2 = (BtDevice) this.b.get(vin);
            this.b.put(vin, btDevice);
            if (btDevice2 != null && !TextUtils.equals(btDevice2.getPName(), pName)) {
                this.f9903a.b(btDevice);
            }
        }
    }

    public final BtDevice k(ScanResult scanResult) {
        String b2 = BleUtils.b(scanResult.getScanRecord().getServiceData(Constants.ServiceInfo.c));
        String b3 = BleUtils.b(scanResult.getScanRecord().getServiceData(Constants.ServiceInfo.d));
        if (TextUtils.isEmpty(b2) || TextUtils.isEmpty(b3)) {
            EasyLog.i("DeviceCache", "Package data missing, illegal content:\n" + BleUtils.a(scanResult.getScanRecord().getBytes()));
            return null;
        }
        Log.d("DeviceCache", String.format("parse: id=%s, name=%s", new Object[]{b2, b3}));
        BtDevice btDevice = new BtDevice();
        btDevice.setVin(b2).setPName(b3);
        btDevice.setSignal(scanResult.getRssi());
        btDevice.setMac(scanResult.getDevice().getAddress());
        return btDevice;
    }

    public void l(OnDeviceChangeCallback onDeviceChangeCallback) {
        this.f9903a = onDeviceChangeCallback;
    }
}
