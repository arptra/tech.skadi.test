package com.upuphone.starrynet.common.utils.tracker.detail;

import android.os.Build;
import android.text.TextUtils;
import com.upuphone.starrynet.api.StConstant;
import com.upuphone.starrynet.common.utils.tracker.ReportTracker;
import com.upuphone.starrynet.common.utils.tracker.TrackerConstant;
import java.util.HashMap;
import java.util.Map;

public class BluetoothSwtchStateTracker extends Tracker {
    private int deviceType = -1;
    private int msgType = -1;
    private String phoneBrand;
    private String romVersion = "";
    private int scanMode = -1;
    private String starryNetVersion = "";
    private int switchInfoResult = -1;
    private int switchKeyResult = -1;
    private String version = "1.0.0";

    public BluetoothSwtchStateTracker(ReportTracker reportTracker, int i, String str) {
        super(reportTracker, i, str);
        String str2 = Build.BRAND;
        this.phoneBrand = str2;
        String str3 = Build.VERSION.RELEASE;
        this.romVersion = str3;
        this.logTag = "BluetoothSwitchStateTracker";
        if (i == 4) {
            this.deviceType = 0;
        } else if (i == 1) {
            this.deviceType = 1;
        }
        log("brand =%s, romVersion =%s", str2, str3);
    }

    public BluetoothSwtchStateTracker bleStartScanResult(int i, String str, int i2) {
        if (!isSupportTracker()) {
            return this;
        }
        log("ble scanMode =" + i2, new Object[0]);
        this.peerTerminalType = i;
        this.peerDeviceID = str;
        this.eventName = TrackerConstant.EVENT_NAME_START_SCAN;
        this.scanMode = i2;
        return this;
    }

    public BluetoothSwtchStateTracker bleSwitchInfoResult(int i, String str, int i2, int i3) {
        if (!isSupportTracker()) {
            return this;
        }
        log("bleSwitchInfoResult=" + i3, new Object[0]);
        this.peerTerminalType = i;
        this.peerDeviceID = str;
        this.eventName = TrackerConstant.EVENT_NAME_DEVICE_SWITCH_INFO;
        this.msgType = i2;
        this.switchInfoResult = i3;
        return this;
    }

    public BluetoothSwtchStateTracker bleSwitchKeyResult(int i, String str, int i2, int i3) {
        if (!isSupportTracker()) {
            return this;
        }
        log("bleSwitchKeyResult=" + i3, new Object[0]);
        this.peerTerminalType = i;
        this.peerDeviceID = str;
        this.eventName = TrackerConstant.EVENT_NAME_DEVICE_SWITCH_KEY;
        this.switchKeyResult = i3;
        this.msgType = i2;
        return this;
    }

    public Map<String, Object> buildMap() {
        HashMap hashMap = new HashMap();
        if (TrackerConstant.EVENT_NAME_START_SCAN.equals(this.eventName)) {
            hashMap.put("scan_mode", Integer.valueOf(this.scanMode));
        } else if (TrackerConstant.EVENT_NAME_DEVICE_SWITCH_KEY.equals(this.eventName)) {
            hashMap.put("devices_switch_key_result", Integer.valueOf(this.switchKeyResult));
        } else if (TrackerConstant.EVENT_NAME_DEVICE_SWITCH_INFO.equals(this.eventName)) {
            hashMap.put("devices_switch_info_result", Integer.valueOf(this.switchInfoResult));
        }
        hashMap.put(StConstant.KEY_PAYLOAD_MESSAGE_MSG_TYPE, Integer.valueOf(this.msgType));
        hashMap.put("ble_state", 1);
        hashMap.put("ver", this.version);
        if (TextUtils.isEmpty(this.romVersion)) {
            hashMap.put("rom_version", "");
            hashMap.put("phone_rom_version", "");
        } else if (this.ownTerminalType == 2) {
            hashMap.put("rom_version", this.romVersion);
            hashMap.put("phone_rom_version", "");
        } else {
            hashMap.put("rom_version", "");
            hashMap.put("phone_rom_version", this.romVersion);
        }
        if (TextUtils.isEmpty(this.starryNetVersion)) {
            hashMap.put("glass_starrynet_version", "");
            hashMap.put("phone_starrynet_version", "");
        } else if (this.ownTerminalType == 2) {
            hashMap.put("glass_starrynet_version", this.starryNetVersion);
            hashMap.put("phone_starrynet_version", "");
        } else {
            hashMap.put("glass_starrynet_version", "");
            hashMap.put("phone_starrynet_version", this.starryNetVersion);
        }
        hashMap.put("phone_brand", this.phoneBrand);
        hashMap.put("devices_type", Integer.valueOf(this.deviceType));
        return hashMap;
    }

    public /* bridge */ /* synthetic */ boolean isSupportTracker() {
        return super.isSupportTracker();
    }

    public BluetoothSwtchStateTracker peerModelID(String str) {
        if (!isSupportTracker()) {
            return this;
        }
        log("peerModelID:" + str, new Object[0]);
        this.peerModelID = str;
        return this;
    }

    public void recycle() {
        this.eventName = null;
        this.msgType = -1;
        this.scanMode = -1;
        this.switchKeyResult = -1;
        this.switchInfoResult = -1;
    }

    public BluetoothSwtchStateTracker romVersion(String str) {
        this.romVersion = str;
        return this;
    }

    public BluetoothSwtchStateTracker setStarryNetVersion(String str) {
        log("setStarryNetVersion =" + str, new Object[0]);
        this.starryNetVersion = str;
        return this;
    }

    public /* bridge */ /* synthetic */ boolean start3rdReport() {
        return super.start3rdReport();
    }

    public /* bridge */ /* synthetic */ boolean startReport() {
        return super.startReport();
    }

    public /* bridge */ /* synthetic */ boolean isSupportTracker(int i) {
        return super.isSupportTracker(i);
    }
}
