package com.upuphone.starrynet.common.utils.tracker.detail;

import android.os.Build;
import android.text.TextUtils;
import com.upuphone.starrynet.common.utils.tracker.ReportTracker;
import com.upuphone.starrynet.common.utils.tracker.TrackerConstant;
import java.util.HashMap;
import java.util.Map;

public class BluetoothDisconnectTracker extends Tracker {
    private int deviceType = -1;
    private String disconnectReason = "";
    private int isBtOn = -1;
    private String phoneBrand;
    private String romVersion = "";
    private String starryNetVersion = "";
    private String version = "1.0.0";

    public BluetoothDisconnectTracker(ReportTracker reportTracker, int i, String str) {
        super(reportTracker, i, str);
        String str2 = Build.BRAND;
        this.phoneBrand = str2;
        String str3 = Build.VERSION.RELEASE;
        this.romVersion = str3;
        this.logTag = "BluetoothDisconnectTracker";
        if (i == 4) {
            this.deviceType = 0;
        } else if (i == 1) {
            this.deviceType = 1;
        }
        log("brand =%s, romVersion =%s", str2, str3);
    }

    public BluetoothDisconnectTracker bleDisconnectResult(int i, String str, int i2) {
        if (!isSupportTracker()) {
            return this;
        }
        log("bleDisconnectResult=" + i2, new Object[0]);
        this.peerTerminalType = i;
        this.peerDeviceID = str;
        this.eventName = TrackerConstant.EVENT_NAME_DEVICE_DISCONNECT;
        this.disconnectReason = String.valueOf(i2);
        return this;
    }

    public Map<String, Object> buildMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("ble_state", 1);
        hashMap.put("bt_state", Integer.valueOf(this.isBtOn));
        hashMap.put("reason_devices_disconnect", this.disconnectReason);
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
        if (this.ownTerminalType != 2) {
            hashMap.put("wear_state", -1);
        }
        hashMap.put("phone_brand", this.phoneBrand);
        hashMap.put("devices_type", Integer.valueOf(this.deviceType));
        return hashMap;
    }

    public BluetoothDisconnectTracker isBtOn(boolean z) {
        if (!isSupportTracker()) {
            return this;
        }
        log("isBtOn=" + z, new Object[0]);
        this.isBtOn = z ^ true ? 1 : 0;
        return this;
    }

    public /* bridge */ /* synthetic */ boolean isSupportTracker() {
        return super.isSupportTracker();
    }

    public BluetoothDisconnectTracker peerModelID(String str) {
        if (!isSupportTracker()) {
            return this;
        }
        log("peerModelID:" + str, new Object[0]);
        this.peerModelID = str;
        return this;
    }

    public void recycle() {
        this.eventName = null;
        this.disconnectReason = "";
        this.isBtOn = -1;
    }

    public BluetoothDisconnectTracker romVersion(String str) {
        this.romVersion = str;
        return this;
    }

    public BluetoothDisconnectTracker setStarryNetVersion(String str) {
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
