package com.upuphone.starrynet.common.utils.tracker.detail;

import android.os.Build;
import android.text.TextUtils;
import com.upuphone.starrynet.common.utils.tracker.ReportTracker;
import com.upuphone.starrynet.common.utils.tracker.TrackerConstant;
import java.util.HashMap;
import java.util.Map;

public class UnpairDeviceTracker extends Tracker {
    private int dataSource;
    private int deviceType = -1;
    private String phoneBrand;
    private String romVersion;
    private String starryNetVersion;
    private int unpairResult = -1;
    private int unpairWays = -1;
    private String version = "1.0.0";

    public UnpairDeviceTracker(ReportTracker reportTracker, int i, String str) {
        super(reportTracker, i, str);
        String str2 = Build.BRAND;
        this.phoneBrand = str2;
        String str3 = Build.VERSION.RELEASE;
        this.romVersion = str3;
        this.logTag = "UnpairDeviceTracker";
        log("brand =%s, romVersion =%s", str2, str3);
    }

    public Map<String, Object> buildMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("ver", this.version);
        hashMap.put("unpair_ways", Integer.valueOf(this.unpairWays));
        hashMap.put("unpair_result", Integer.valueOf(this.unpairResult));
        hashMap.put("devices_type", Integer.valueOf(this.deviceType));
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
        hashMap.put("data_reporting_source", Integer.valueOf(this.dataSource));
        return hashMap;
    }

    public /* bridge */ /* synthetic */ boolean isSupportTracker() {
        return super.isSupportTracker();
    }

    public UnpairDeviceTracker peerModelID(String str) {
        if (!isSupportTracker()) {
            return this;
        }
        log("peerModelID:" + str, new Object[0]);
        this.peerModelID = str;
        return this;
    }

    public void recycle() {
        this.eventName = null;
        this.unpairWays = -1;
        this.unpairResult = -1;
    }

    public UnpairDeviceTracker result(int i, String str, int i2) {
        if (!checkValid(i, str)) {
            return this;
        }
        log("result=" + i2, new Object[0]);
        this.unpairResult = i2;
        return this;
    }

    public UnpairDeviceTracker romVersion(String str) {
        this.romVersion = str;
        return this;
    }

    public UnpairDeviceTracker setStarryNetVersion(String str) {
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

    public UnpairDeviceTracker startUnpair(int i, String str) {
        if (!isSupportTracker()) {
            return this;
        }
        this.peerTerminalType = i;
        this.peerDeviceID = str;
        this.eventName = TrackerConstant.EVENT_NAME_UNPAIR;
        int i2 = this.ownTerminalType;
        if (i2 == 2) {
            this.dataSource = 0;
            this.deviceType = 0;
        } else {
            if (i2 == 4) {
                this.deviceType = 0;
            } else {
                this.deviceType = 1;
            }
            this.dataSource = 1;
        }
        return this;
    }

    public UnpairDeviceTracker way(int i) {
        if (!isSupportTracker()) {
            return this;
        }
        log("way=" + i, new Object[0]);
        this.unpairWays = i;
        return this;
    }

    public /* bridge */ /* synthetic */ boolean isSupportTracker(int i) {
        return super.isSupportTracker(i);
    }
}
