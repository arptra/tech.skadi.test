package com.upuphone.starrynet.common.utils.tracker.detail;

import android.os.Build;
import android.text.TextUtils;
import com.upuphone.starrynet.common.utils.tracker.ReportTracker;
import com.upuphone.starrynet.common.utils.tracker.TrackerConstant;
import java.util.HashMap;
import java.util.Map;

public class BluetoothConnectionTracker extends Tracker {
    /* access modifiers changed from: private */
    public long bleConnectEndTime;
    private long bleConnectStartTime;
    /* access modifiers changed from: private */
    public long btConnectEndTime;
    private long btConnectStartTime;
    private int dataSource;
    private int deviceType = -1;
    private String phoneBrand;
    private int resultCode = 0;
    private String resultReason;
    private String romVersion;
    private String starryNetVersion;
    private String version = "1.0.0";

    public BluetoothConnectionTracker(ReportTracker reportTracker, int i, String str) {
        super(reportTracker, i, str);
        String str2 = Build.BRAND;
        this.phoneBrand = str2;
        String str3 = Build.VERSION.RELEASE;
        this.romVersion = str3;
        this.logTag = "ConnectionTracker";
        log("brand =%s, romVersion =%s", str2, str3);
    }

    private Map<String, Object> buildDeviceMatchMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("ver", this.version);
        if (TextUtils.isEmpty(this.romVersion)) {
            hashMap.put("rom_version", "");
            hashMap.put("phone_rom_version", "");
        } else if (this.dataSource == 0) {
            hashMap.put("rom_version", this.romVersion);
            hashMap.put("phone_rom_version", "");
        } else {
            hashMap.put("rom_version", "");
            hashMap.put("phone_rom_version", this.romVersion);
        }
        if (TextUtils.isEmpty(this.starryNetVersion)) {
            hashMap.put("glass_starrynet_version", "");
            hashMap.put("phone_starrynet_version", "");
        } else if (this.dataSource == 0) {
            hashMap.put("glass_starrynet_version", this.starryNetVersion);
            hashMap.put("phone_starrynet_version", "");
        } else {
            hashMap.put("glass_starrynet_version", "");
            hashMap.put("phone_starrynet_version", this.starryNetVersion);
        }
        int i = this.ownTerminalType;
        if (i == 4 || i == 1) {
            hashMap.put("phone_starrynet_device_id", this.ownDeviceID);
            hashMap.put("glass_starrynet_device_id", this.peerDeviceID);
        } else if (i == 2) {
            hashMap.put("phone_starrynet_device_id", this.peerDeviceID);
            hashMap.put("glass_starrynet_device_id", this.ownDeviceID);
        }
        hashMap.put("phone_brand", this.phoneBrand);
        hashMap.put("devices_type", Integer.valueOf(this.deviceType));
        hashMap.put("devices_match_result", Integer.valueOf(this.resultCode));
        String str = this.resultReason;
        if (str == null) {
            str = String.valueOf(this.resultCode);
        }
        hashMap.put("reason_fail_devices_match_result", str);
        long j = this.btConnectEndTime;
        long j2 = j - this.btConnectStartTime;
        long j3 = this.bleConnectEndTime - this.bleConnectStartTime;
        long j4 = j - this.eventTime;
        if (j4 <= 0) {
            j4 = j3;
        }
        hashMap.put("devices_match_times", Long.valueOf(j4));
        if (j3 <= 0) {
            j3 = 0;
        }
        hashMap.put("time_ble_connect", Long.valueOf(j3));
        if (j2 <= 0) {
            j2 = 0;
        }
        hashMap.put("time_bt_connect", Long.valueOf(j2));
        hashMap.put("data_reporting_source", Integer.valueOf(this.dataSource));
        return hashMap;
    }

    private Map<String, Object> buildDeviceReconnectMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("ver", this.version);
        if (TextUtils.isEmpty(this.romVersion)) {
            hashMap.put("rom_version", "");
            hashMap.put("phone_rom_version", "");
        } else if (this.dataSource == 0) {
            hashMap.put("rom_version", this.romVersion);
            hashMap.put("phone_rom_version", "");
        } else {
            hashMap.put("rom_version", "");
            hashMap.put("phone_rom_version", this.romVersion);
        }
        if (TextUtils.isEmpty(this.starryNetVersion)) {
            hashMap.put("glass_starrynet_version", "");
            hashMap.put("phone_starrynet_version", "");
        } else if (this.dataSource == 0) {
            hashMap.put("glass_starrynet_version", this.starryNetVersion);
            hashMap.put("phone_starrynet_version", "");
        } else {
            hashMap.put("glass_starrynet_version", "");
            hashMap.put("phone_starrynet_version", this.starryNetVersion);
        }
        int i = this.ownTerminalType;
        if (i == 4 || i == 1) {
            hashMap.put("phone_starrynet_device_id", this.ownDeviceID);
            hashMap.put("glass_starrynet_device_id", this.peerDeviceID);
        } else if (i == 2) {
            hashMap.put("phone_starrynet_device_id", this.peerDeviceID);
            hashMap.put("glass_starrynet_device_id", this.ownDeviceID);
        }
        hashMap.put("phone_brand", this.phoneBrand);
        hashMap.put("devices_type", Integer.valueOf(this.deviceType));
        hashMap.put("devices_reconnect_result", Integer.valueOf(this.resultCode));
        String str = this.resultReason;
        if (str == null) {
            str = String.valueOf(this.resultCode);
        }
        hashMap.put("reason_devices_reconnect", str);
        long j = this.btConnectEndTime - this.btConnectStartTime;
        long j2 = this.bleConnectEndTime - this.bleConnectStartTime;
        if (j2 <= 0) {
            j2 = 0;
        }
        hashMap.put("time_devices_reconnect", Long.valueOf(j2));
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 > 0) {
            if (i2 <= 0) {
                j = 0;
            }
            hashMap.put("bt_reconnect_times", Long.valueOf(j));
            hashMap.put("result_bt_reconnect", 0);
        } else {
            hashMap.put("bt_reconnect_times", -1);
            hashMap.put("result_bt_reconnect", 1);
        }
        hashMap.put("data_reporting_source", Integer.valueOf(this.dataSource));
        return hashMap;
    }

    private void reportEventIfNeed() {
        new Thread("ConnectionTracker") {
            public void run() {
                super.run();
                BluetoothConnectionTracker bluetoothConnectionTracker = BluetoothConnectionTracker.this;
                if (bluetoothConnectionTracker.peerTerminalType == 3) {
                    if (bluetoothConnectionTracker.bleConnectEndTime > 0) {
                        BluetoothConnectionTracker.this.log("reportEventIfNeed4Car", new Object[0]);
                        BluetoothConnectionTracker.this.startReport();
                    }
                } else if (bluetoothConnectionTracker.btConnectEndTime > 0 && BluetoothConnectionTracker.this.bleConnectEndTime > 0) {
                    BluetoothConnectionTracker.this.log("reportEventIfNeed", new Object[0]);
                    BluetoothConnectionTracker.this.startReport();
                }
            }
        }.start();
    }

    public BluetoothConnectionTracker bleConnected(int i, String str, String str2) {
        if (!checkValid(i, str)) {
            return this;
        }
        log("bleConnected", new Object[0]);
        this.peerModelID = str2;
        this.bleConnectEndTime = System.currentTimeMillis();
        reportEventIfNeed();
        return this;
    }

    public BluetoothConnectionTracker btConnected(int i, String str, String str2) {
        if (!checkValid(i, str)) {
            return this;
        }
        log("btConnected", new Object[0]);
        this.peerModelID = str2;
        this.btConnectEndTime = System.currentTimeMillis();
        reportEventIfNeed();
        return this;
    }

    public Map<String, Object> buildMap() {
        if (TrackerConstant.EVENT_NAME_DEVICE_MATCH.equals(this.eventName)) {
            return buildDeviceMatchMap();
        }
        if (TrackerConstant.EVENT_NAME_DEVICE_RECONNECT.equals(this.eventName)) {
            return buildDeviceReconnectMap();
        }
        return null;
    }

    public BluetoothConnectionTracker isPhone(boolean z) {
        if (!isSupportTracker()) {
            return this;
        }
        log("isPhone:" + z, new Object[0]);
        this.dataSource = z ? 1 : 0;
        return this;
    }

    public /* bridge */ /* synthetic */ boolean isSupportTracker() {
        return super.isSupportTracker();
    }

    public BluetoothConnectionTracker peerModelID(String str) {
        if (!isSupportTracker()) {
            return this;
        }
        log("peerModelID:" + str, new Object[0]);
        this.peerModelID = str;
        return this;
    }

    public void recycle() {
        this.eventName = null;
        this.peerDeviceID = null;
        this.peerTerminalType = -1;
        this.resultCode = 0;
        this.resultReason = null;
        this.deviceType = -1;
        this.eventTime = 0;
        this.bleConnectStartTime = 0;
        this.bleConnectEndTime = 0;
        this.btConnectStartTime = 0;
        this.btConnectEndTime = 0;
    }

    public BluetoothConnectionTracker result(int i, String str, int i2, String str2) {
        if (!checkValid(i, str) || TextUtils.isEmpty(this.eventName)) {
            return this;
        }
        log("result code=%d, error=%s", Integer.valueOf(i2), str2);
        this.resultCode = i2;
        this.resultReason = str2;
        if (this.bleConnectStartTime > 0 && this.bleConnectEndTime == 0) {
            this.bleConnectEndTime = System.currentTimeMillis();
        }
        if (this.btConnectStartTime > 0 && this.btConnectEndTime == 0) {
            this.btConnectEndTime = System.currentTimeMillis();
        }
        return this;
    }

    public BluetoothConnectionTracker romVersion(String str) {
        this.romVersion = str;
        return this;
    }

    public BluetoothConnectionTracker setStarryNetVersion(String str) {
        log("setStarryNetVersion =" + str, new Object[0]);
        this.starryNetVersion = str;
        return this;
    }

    public BluetoothConnectionTracker start(boolean z, int i, String str) {
        if (!isSupportTracker()) {
            return this;
        }
        if (!TextUtils.isEmpty(this.eventName)) {
            if (!checkValid(i, str)) {
                return this;
            }
            startReport();
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.eventTime = currentTimeMillis;
        this.peerTerminalType = i;
        this.peerDeviceID = str;
        log("start isDeviceMatch =%s, peer deviceID =%s, peerTerminalType=%d", Boolean.valueOf(z), str, Integer.valueOf(i));
        this.eventName = z ? TrackerConstant.EVENT_NAME_DEVICE_MATCH : TrackerConstant.EVENT_NAME_DEVICE_RECONNECT;
        this.bleConnectStartTime = currentTimeMillis;
        if (!z) {
            this.btConnectStartTime = currentTimeMillis;
        }
        this.deviceType = 1;
        if (this.ownTerminalType == 4) {
            this.deviceType = 0;
        }
        return this;
    }

    public /* bridge */ /* synthetic */ boolean start3rdReport() {
        return super.start3rdReport();
    }

    public BluetoothConnectionTracker startConnectBt(int i, String str) {
        if (!checkValid(i, str)) {
            return this;
        }
        log("startBtConnect peer deviceID =" + str, new Object[0]);
        this.btConnectStartTime = System.currentTimeMillis();
        return this;
    }

    public /* bridge */ /* synthetic */ boolean startReport() {
        return super.startReport();
    }

    public /* bridge */ /* synthetic */ boolean isSupportTracker(int i) {
        return super.isSupportTracker(i);
    }
}
