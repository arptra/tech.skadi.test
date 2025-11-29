package com.upuphone.starrynet.common.utils.tracker.detail;

import android.text.TextUtils;
import com.tencent.mmkv.MMKV;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.tracker.ReportTracker;
import com.upuphone.starrynet.common.utils.tracker.Ring2TrackerConstant;
import java.util.HashMap;
import java.util.Map;

abstract class Tracker {
    protected static final int NONE_INT = -1;
    protected static final String NONE_STRING = "";
    protected String eventName;
    protected long eventTime;
    protected String iotDeviceId;
    protected String iotDeviceModel;
    protected String iotDeviceRom;
    protected String logTag = "Tracker";
    protected String ownDeviceID;
    protected int ownTerminalType;
    protected String peerDeviceID;
    protected String peerModelID;
    protected int peerTerminalType = 0;
    protected ReportTracker reporter;

    public Tracker(ReportTracker reportTracker, int i, String str) {
        this.reporter = reportTracker;
        this.ownTerminalType = i;
        this.ownDeviceID = str;
    }

    public abstract Map<String, Object> buildMap();

    public boolean checkValid(int i, String str) {
        return isSupportTracker(i) && TextUtils.equals(this.peerDeviceID, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0006, code lost:
        r1 = r1.ownTerminalType;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isSupportTracker(int r2) {
        /*
            r1 = this;
            r0 = 2
            if (r2 == r0) goto L_0x0006
            r0 = 3
            if (r2 != r0) goto L_0x000f
        L_0x0006:
            int r1 = r1.ownTerminalType
            r2 = 4
            r0 = 1
            if (r1 == r2) goto L_0x0010
            if (r1 != r0) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.common.utils.tracker.detail.Tracker.isSupportTracker(int):boolean");
    }

    public void log(String str, Object... objArr) {
        StLog.d(this.logTag, str, objArr);
    }

    public abstract void recycle();

    public boolean start3rdReport() {
        if (!isSupportTracker()) {
            return false;
        }
        if (this.reporter == null) {
            StLog.w("Tracker", "reporter is null ");
            return false;
        } else if (TextUtils.isEmpty(this.eventName)) {
            StLog.w("Tracker", "event name is null ");
            return false;
        } else {
            Map buildMap = buildMap();
            if (buildMap == null) {
                buildMap = new HashMap();
            }
            Map map = buildMap;
            map.put("peer_terminal_type", Integer.valueOf(this.peerTerminalType));
            if (!TextUtils.isEmpty(this.peerModelID)) {
                map.put("model_id", this.peerModelID);
            }
            if (this.ownTerminalType == 4) {
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
                if (!TextUtils.isEmpty(this.eventName) && this.eventName.equals(Ring2TrackerConstant.EVENT_NAME_RING2_MATCH_FAIL)) {
                    this.reporter.report3rdEvent(this.eventName, this.peerTerminalType, map, this.iotDeviceId, this.iotDeviceModel, this.iotDeviceRom);
                    return true;
                } else if (TextUtils.isEmpty(this.iotDeviceId)) {
                    return false;
                } else {
                    this.reporter.report3rdEvent(this.eventName, this.peerTerminalType, map, this.iotDeviceId, this.iotDeviceModel, this.iotDeviceRom);
                }
            } else {
                this.reporter.reportMap(this.eventName, this.peerTerminalType, map);
            }
            recycle();
            return true;
        }
    }

    public boolean startReport() {
        if (!isSupportTracker()) {
            return false;
        }
        if (this.reporter == null) {
            StLog.w("Tracker", "reporter is null ");
            return false;
        } else if (TextUtils.isEmpty(this.eventName)) {
            StLog.w("Tracker", "event name is null ");
            return false;
        } else {
            Map buildMap = buildMap();
            if (buildMap == null) {
                buildMap = new HashMap();
            }
            buildMap.put("peer_terminal_type", Integer.valueOf(this.peerTerminalType));
            if (!TextUtils.isEmpty(this.peerModelID)) {
                buildMap.put("model_id", this.peerModelID);
            }
            this.reporter.reportMap(this.eventName, this.peerTerminalType, buildMap);
            recycle();
            return true;
        }
    }

    public boolean isSupportTracker() {
        int i = this.ownTerminalType;
        return i == 4 || i == 1;
    }
}
