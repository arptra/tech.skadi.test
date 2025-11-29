package com.upuphone.starrynet.common.utils.tracker.detail;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mmkv.MMKV;
import com.upuphone.starrynet.common.utils.DigestUtils;
import com.upuphone.starrynet.common.utils.tracker.ReportTracker;
import com.upuphone.starrynet.common.utils.tracker.Ring2TrackerConstant;
import java.util.HashMap;
import java.util.Map;

public class MyvuRing2BleTracker extends Tracker {
    String EVENT_NAME_RING2_AUTH_RESULT = "starrynet_ring2_auth_result";
    String EVENT_NAME_RING2_CONNECT = "starrynet_ring2_connect";
    String EVENT_NAME_RING2_DATA_ERROR = "starrynet_ring2_data_error";
    String EVENT_NAME_RING2_DISCONNECT = "starrynet_ring2_disconnect";
    String EVENT_NAME_RING2_RECONNECT = "starrynet_ring2_reconnect";
    String EVENT_NAME_RING2_SCAN = "starrynet_ring2_scan";
    String EVENT_NAME_RING2_SECURITY_STATE = "starrynet_ring2_security_state";
    String EVENT_NAME_RING2_UNPAIR = "starrynet_ring2_unpair";
    private int authResult = -1;
    private long bleConnectEndTime;
    private long bleConnectStartTime;
    private int connectWays = -1;
    private int currentProcess = -1;
    private int dataLength = -1;
    private int dataSource;
    private int deviceType = -1;
    private int disConnectWays = -1;
    private int disResultCode = 0;
    private String disconnectReason = "";
    private int isBond = -1;
    private int isBtOn = -1;
    private boolean isDeviceMatch = true;
    private String originData = "";
    private String phoneBrand;
    private int resultCode = 0;
    private String resultReason;
    private String romVersion;
    private int securityState = -1;
    private String starryNetVersion;
    private int statusRecord = 0;
    private int unpairWays = -1;
    private String version = "1.0.0";
    private int ways = -1;

    public MyvuRing2BleTracker(ReportTracker reportTracker, int i, String str) {
        super(reportTracker, i, str);
        String str2 = Build.BRAND;
        this.phoneBrand = str2;
        String str3 = Build.VERSION.RELEASE;
        this.romVersion = str3;
        this.logTag = "MyvuRing2BleTracker";
        if (i == 4) {
            this.deviceType = 0;
        } else if (i == 1) {
            this.deviceType = 1;
        }
        log("brand =%s, romVersion =%s", str2, str3);
    }

    private Map<String, Object> buildAuthResultMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("ver", this.version);
        hashMap.put("auto_result", Integer.valueOf(this.authResult));
        hashMap.put("devices_type", Integer.valueOf(this.deviceType));
        putCommonMapData(hashMap);
        return hashMap;
    }

    private Map<String, Object> buildDataErrorMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("ver", this.version);
        hashMap.put("data_length", Integer.valueOf(this.dataLength));
        hashMap.put("origin_data", this.originData);
        hashMap.put("devices_type", Integer.valueOf(this.deviceType));
        putCommonMapData(hashMap);
        return hashMap;
    }

    private Map<String, Object> buildDeviceConnectMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("ver", this.version);
        hashMap.put("devices_type", Integer.valueOf(this.deviceType));
        hashMap.put("devices_match_result", Integer.valueOf(this.resultCode));
        hashMap.put("status_record", Integer.valueOf(this.statusRecord));
        String str = this.resultReason;
        if (str == null) {
            str = String.valueOf(this.resultCode);
        }
        hashMap.put("reason_fail_devices_match_result", str);
        long j = this.bleConnectEndTime - this.bleConnectStartTime;
        if (j <= 0) {
            j = 0;
        }
        hashMap.put("time_ble_connect", Long.valueOf(j));
        putCommonMapData(hashMap);
        return hashMap;
    }

    private Map<String, Object> buildDeviceDisConnectMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("ble_state", 1);
        hashMap.put("isBtOn", Integer.valueOf(this.isBtOn));
        hashMap.put("isBond", Integer.valueOf(this.isBond));
        hashMap.put("status_record", Integer.valueOf(this.statusRecord));
        hashMap.put("code_ring2_disconnect", Integer.valueOf(this.disResultCode));
        hashMap.put("reason_ring2_disconnect", this.disconnectReason);
        hashMap.put("devices_type", Integer.valueOf(this.deviceType));
        hashMap.put("ver", this.version);
        putCommonMapData(hashMap);
        return hashMap;
    }

    private Map<String, Object> buildDeviceMatchFailMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("ver", this.version);
        hashMap.put("devices_type", Integer.valueOf(this.deviceType));
        hashMap.put("devices_reconnect_result", Integer.valueOf(this.resultCode));
        hashMap.put("status_record", Integer.valueOf(this.statusRecord));
        String str = this.resultReason;
        if (str == null) {
            str = String.valueOf(this.resultCode);
        }
        hashMap.put("reason_devices_reconnect", str);
        long j = this.bleConnectEndTime - this.bleConnectStartTime;
        if (j <= 0) {
            j = 0;
        }
        hashMap.put("time_devices_reconnect", Long.valueOf(j));
        putCommonMapData(hashMap);
        return hashMap;
    }

    private Map<String, Object> buildDeviceReconnectMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("ver", this.version);
        hashMap.put("devices_type", Integer.valueOf(this.deviceType));
        hashMap.put("devices_reconnect_result", Integer.valueOf(this.resultCode));
        hashMap.put("status_record", Integer.valueOf(this.statusRecord));
        String str = this.resultReason;
        if (str == null) {
            str = String.valueOf(this.resultCode);
        }
        hashMap.put("reason_devices_reconnect", str);
        long j = this.bleConnectEndTime - this.bleConnectStartTime;
        if (j <= 0) {
            j = 0;
        }
        hashMap.put("time_devices_reconnect", Long.valueOf(j));
        putCommonMapData(hashMap);
        return hashMap;
    }

    private Map<String, Object> buildDeviceUnpairMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("ver", this.version);
        hashMap.put("unpair_ways", Integer.valueOf(this.unpairWays));
        hashMap.put("devices_type", Integer.valueOf(this.deviceType));
        putCommonMapData(hashMap);
        return hashMap;
    }

    private Map<String, Object> buildSecurityStateMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("ver", this.version);
        hashMap.put("security_result", Integer.valueOf(this.securityState));
        hashMap.put("devices_type", Integer.valueOf(this.deviceType));
        putCommonMapData(hashMap);
        return hashMap;
    }

    private void putCommonMapData(Map<String, Object> map) {
        if (map != null) {
            if (TextUtils.isEmpty(this.romVersion)) {
                map.put("rom_version", "");
                map.put("phone_rom_version", "");
            } else if (this.dataSource == 0) {
                map.put("rom_version", this.romVersion);
                map.put("phone_rom_version", "");
            } else {
                map.put("rom_version", "");
                map.put("phone_rom_version", this.romVersion);
            }
            if (TextUtils.isEmpty(this.starryNetVersion)) {
                map.put("ring2_starrynet_version", "");
                map.put("phone_starrynet_version", "");
            } else if (this.dataSource == 0) {
                map.put("ring2_starrynet_version", this.starryNetVersion);
                map.put("phone_starrynet_version", "");
            } else {
                map.put("ring2_starrynet_version", "");
                map.put("phone_starrynet_version", this.starryNetVersion);
            }
            int i = this.ownTerminalType;
            if (i == 4 || i == 1) {
                map.put("phone_starrynet_device_id", this.ownDeviceID);
                map.put("ring2_starrynet_device_id", this.peerDeviceID);
            } else if (i == 5) {
                map.put("phone_starrynet_device_id", this.peerDeviceID);
                map.put("ring2_starrynet_device_id", this.ownDeviceID);
            }
            if (!TextUtils.isEmpty(this.peerModelID)) {
                map.put("model_id", this.peerModelID);
            }
            map.put("peer_terminal_type", Integer.valueOf(this.peerTerminalType));
            map.put("phone_brand", this.phoneBrand);
            map.put("data_reporting_source", Integer.valueOf(this.dataSource));
            if (MMKV.x() != null) {
                if (TextUtils.isEmpty(this.iotDeviceId)) {
                    this.iotDeviceId = MMKV.n().k(Ring2TrackerConstant.SAVE_IOT_DEVICE_ID, "");
                }
                if (TextUtils.isEmpty(this.iotDeviceRom)) {
                    this.iotDeviceRom = MMKV.n().k(Ring2TrackerConstant.SAVE_IOT_DEVICE_ROM, "");
                }
                if (TextUtils.isEmpty(this.iotDeviceModel)) {
                    this.iotDeviceModel = MMKV.n().k(Ring2TrackerConstant.SAVE_IOT_DEVICE_MODEL, "");
                }
            }
            map.put("iot_device_id", this.iotDeviceId);
            map.put("iot_device_rom", this.iotDeviceRom);
            map.put("iot_device_model", this.iotDeviceModel);
        }
    }

    public Map<String, Object> buildMap() {
        if (this.EVENT_NAME_RING2_CONNECT.equals(this.eventName)) {
            return buildDeviceConnectMap();
        }
        if (Ring2TrackerConstant.EVENT_NAME_RING2_MATCH_FAIL.equals(this.eventName)) {
            return buildDeviceMatchFailMap();
        }
        if (this.EVENT_NAME_RING2_RECONNECT.equals(this.eventName)) {
            return buildDeviceReconnectMap();
        }
        if (this.EVENT_NAME_RING2_DISCONNECT.equals(this.eventName)) {
            return buildDeviceDisConnectMap();
        }
        if (this.EVENT_NAME_RING2_UNPAIR.equals(this.eventName)) {
            return buildDeviceUnpairMap();
        }
        if (this.EVENT_NAME_RING2_AUTH_RESULT.equals(this.eventName)) {
            return buildAuthResultMap();
        }
        if (this.EVENT_NAME_RING2_SECURITY_STATE.equals(this.eventName)) {
            return buildSecurityStateMap();
        }
        if (this.EVENT_NAME_RING2_DATA_ERROR.equals(this.eventName)) {
            return buildDataErrorMap();
        }
        return null;
    }

    public boolean checkRing2Valid(int i, String str) {
        return ring2IsSupportTracker(i);
    }

    public void clearIotDeviceInfo() {
        this.iotDeviceId = "";
        this.iotDeviceRom = "";
        this.iotDeviceModel = "";
        if (MMKV.x() != null) {
            MMKV.n().remove(Ring2TrackerConstant.SAVE_IOT_DEVICE_ID);
            MMKV.n().remove(Ring2TrackerConstant.SAVE_IOT_DEVICE_ROM);
            MMKV.n().remove(Ring2TrackerConstant.SAVE_IOT_DEVICE_MODEL);
        }
    }

    public MyvuRing2BleTracker isFlymePhone() {
        this.deviceType = 1;
        if (this.ownTerminalType == 4) {
            this.deviceType = 0;
        }
        return this;
    }

    public MyvuRing2BleTracker isPhone(boolean z) {
        if (!ring2IsSupportTracker()) {
            return this;
        }
        log("isPhone:" + z, new Object[0]);
        this.dataSource = z ? 1 : 0;
        return this;
    }

    public /* bridge */ /* synthetic */ boolean isSupportTracker() {
        return super.isSupportTracker();
    }

    public MyvuRing2BleTracker pairWay(int i) {
        if (!ring2IsSupportTracker()) {
            return this;
        }
        log("ring2 way=" + i, new Object[0]);
        this.ways = i;
        return this;
    }

    public MyvuRing2BleTracker peerModelID(String str) {
        if (!ring2IsSupportTracker()) {
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
        this.connectWays = -1;
        this.disConnectWays = -1;
        this.unpairWays = -1;
        this.authResult = -1;
        this.statusRecord = -1;
        this.securityState = -1;
        this.dataLength = -1;
        this.isBond = -1;
        this.isBtOn = -1;
        this.originData = "";
        this.resultCode = 0;
        this.disResultCode = 0;
        this.resultReason = null;
        this.deviceType = -1;
        this.eventTime = 0;
    }

    public MyvuRing2BleTracker resultAuth(int i, String str, int i2) {
        if (!checkRing2Valid(i, str)) {
            return this;
        }
        this.peerTerminalType = i;
        this.peerDeviceID = str;
        this.eventName = this.EVENT_NAME_RING2_AUTH_RESULT;
        log("ring2 resultAuth=" + i2, new Object[0]);
        this.authResult = i2;
        return this;
    }

    public MyvuRing2BleTracker resultBleConnect(boolean z, int i, String str, int i2, String str2, int i3) {
        if (!checkRing2Valid(i, str)) {
            return this;
        }
        this.eventName = this.isDeviceMatch ? this.EVENT_NAME_RING2_CONNECT : this.EVENT_NAME_RING2_RECONNECT;
        this.resultCode = i2;
        this.peerTerminalType = i;
        this.peerDeviceID = str;
        this.statusRecord = i3;
        if (z) {
            log("ring2 resultBleConnect success", new Object[0]);
            this.bleConnectEndTime = System.currentTimeMillis();
            return this;
        }
        this.resultReason = str2;
        log("ring2 resultBleConnect fail code=%d, error=%s", Integer.valueOf(i2), this.resultReason);
        if (this.bleConnectStartTime > 0 && this.bleConnectEndTime == 0) {
            this.bleConnectEndTime = System.currentTimeMillis();
        }
        return this;
    }

    public MyvuRing2BleTracker resultBleDisconnect(int i, String str, boolean z, boolean z2, int i2, String str2, int i3) {
        if (!ring2IsSupportTracker()) {
            return this;
        }
        this.peerTerminalType = i;
        this.peerDeviceID = str;
        this.eventName = this.EVENT_NAME_RING2_DISCONNECT;
        this.disResultCode = i2;
        this.statusRecord = i3;
        this.disconnectReason = str2;
        this.isBtOn = z ^ true ? 1 : 0;
        this.isBond = z2 ^ true ? 1 : 0;
        log("ring2 resultBleDisconnect=" + this.disconnectReason, new Object[0]);
        return this;
    }

    public MyvuRing2BleTracker resultMatchFail(int i, String str, int i2, String str2, int i3) {
        if (!checkRing2Valid(i, str)) {
            return this;
        }
        this.eventName = Ring2TrackerConstant.EVENT_NAME_RING2_MATCH_FAIL;
        this.resultCode = i2;
        this.peerTerminalType = i;
        this.peerDeviceID = str;
        this.resultReason = str2;
        this.statusRecord = i3;
        log("ring2 resultBleConnect fail code=%d, error=%s", Integer.valueOf(i2), this.resultReason);
        if (this.bleConnectStartTime > 0 && this.bleConnectEndTime == 0) {
            this.bleConnectEndTime = System.currentTimeMillis();
        }
        return this;
    }

    public MyvuRing2BleTracker resultRing2DataError(int i, String str, int i2, String str2) {
        if (!checkRing2Valid(i, str)) {
            return this;
        }
        this.peerTerminalType = i;
        this.peerDeviceID = str;
        this.eventName = this.EVENT_NAME_RING2_DATA_ERROR;
        log("ring2 DataError length = " + i2 + " ,originData = " + str2, new Object[0]);
        this.dataLength = i2;
        this.originData = str2;
        return this;
    }

    public MyvuRing2BleTracker resultSecurity(int i, String str, int i2) {
        if (!checkRing2Valid(i, str)) {
            return this;
        }
        this.peerTerminalType = i;
        this.peerDeviceID = str;
        this.eventName = this.EVENT_NAME_RING2_SECURITY_STATE;
        log("ring2 resultSecurity = " + i2, new Object[0]);
        this.securityState = i2;
        return this;
    }

    public boolean ring2IsSupportTracker() {
        int i = this.ownTerminalType;
        return i == 4 || i == 1;
    }

    public MyvuRing2BleTracker romVersion(String str) {
        this.romVersion = str;
        return this;
    }

    public MyvuRing2BleTracker setIotDeviceId(String str) {
        if (!ring2IsSupportTracker()) {
            return this;
        }
        log("ring2 iotDeviceId =" + str, new Object[0]);
        this.iotDeviceId = TextUtils.isEmpty(str) ? "" : DigestUtils.getSnSign(str);
        log("ring2 iotDeviceId =" + this.iotDeviceId, new Object[0]);
        if (MMKV.x() != null) {
            MMKV.n().u(Ring2TrackerConstant.SAVE_IOT_DEVICE_ID, this.iotDeviceId);
        }
        return this;
    }

    public MyvuRing2BleTracker setIotDeviceModel(String str) {
        if (!ring2IsSupportTracker()) {
            return this;
        }
        if (TextUtils.isEmpty(str)) {
            str = "XAR020C";
        }
        this.iotDeviceModel = str;
        log("ring2 iotDeviceModel =" + this.iotDeviceModel, new Object[0]);
        if (MMKV.x() != null) {
            MMKV.n().u(Ring2TrackerConstant.SAVE_IOT_DEVICE_MODEL, this.iotDeviceModel);
        }
        return this;
    }

    public MyvuRing2BleTracker setIotDeviceRom(String str) {
        if (!ring2IsSupportTracker()) {
            return this;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.iotDeviceRom = str;
        log("ring2 iotDeviceRom =" + this.iotDeviceRom, new Object[0]);
        if (MMKV.x() != null) {
            MMKV.n().u(Ring2TrackerConstant.SAVE_IOT_DEVICE_ROM, this.iotDeviceRom);
        }
        return this;
    }

    public MyvuRing2BleTracker setStarryNetVersion(String str) {
        log("setStarryNetVersion =" + str, new Object[0]);
        this.starryNetVersion = str;
        return this;
    }

    public /* bridge */ /* synthetic */ boolean start3rdReport() {
        return super.start3rdReport();
    }

    public MyvuRing2BleTracker startMatchOrReConnect(boolean z, int i, String str) {
        if (!ring2IsSupportTracker()) {
            return this;
        }
        this.bleConnectStartTime = 0;
        this.bleConnectEndTime = 0;
        this.isDeviceMatch = z;
        long currentTimeMillis = System.currentTimeMillis();
        this.eventTime = currentTimeMillis;
        this.peerTerminalType = i;
        this.peerDeviceID = str;
        this.connectWays = this.ways;
        log("ring2 start isDeviceMatch =%s, peer deviceID =%s, peerTerminalType=%d", Boolean.valueOf(z), str, Integer.valueOf(i));
        this.eventName = z ? this.EVENT_NAME_RING2_CONNECT : this.EVENT_NAME_RING2_RECONNECT;
        this.bleConnectStartTime = currentTimeMillis;
        this.deviceType = 1;
        if (this.ownTerminalType == 4) {
            this.deviceType = 0;
        }
        return this;
    }

    public /* bridge */ /* synthetic */ boolean startReport() {
        return super.startReport();
    }

    public MyvuRing2BleTracker startUnpair(int i, String str, int i2) {
        if (!ring2IsSupportTracker()) {
            return this;
        }
        log("ring2 start Unpair , peer deviceID =%s, peerTerminalType=%d", str, Integer.valueOf(i));
        this.peerTerminalType = i;
        this.peerDeviceID = str;
        this.unpairWays = i2;
        this.eventName = this.EVENT_NAME_RING2_UNPAIR;
        int i3 = this.ownTerminalType;
        if (i3 == 5) {
            this.dataSource = 0;
            this.deviceType = 0;
        } else {
            if (i3 == 4) {
                this.deviceType = 0;
            } else {
                this.deviceType = 1;
            }
            this.dataSource = 1;
        }
        return this;
    }

    public /* bridge */ /* synthetic */ boolean isSupportTracker(int i) {
        return super.isSupportTracker(i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r1.ownTerminalType;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean ring2IsSupportTracker(int r2) {
        /*
            r1 = this;
            r0 = 5
            if (r2 != r0) goto L_0x000c
            int r1 = r1.ownTerminalType
            r2 = 4
            r0 = 1
            if (r1 == r2) goto L_0x000d
            if (r1 != r0) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r0 = 0
        L_0x000d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.common.utils.tracker.detail.MyvuRing2BleTracker.ring2IsSupportTracker(int):boolean");
    }
}
