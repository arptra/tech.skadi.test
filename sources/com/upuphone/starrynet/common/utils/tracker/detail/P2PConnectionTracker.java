package com.upuphone.starrynet.common.utils.tracker.detail;

import android.text.TextUtils;
import com.upuphone.starrynet.common.utils.tracker.ReportTracker;
import com.upuphone.starrynet.common.utils.tracker.TrackerConstant;
import java.util.HashMap;
import java.util.Map;

public class P2PConnectionTracker extends Tracker {
    private String band = "";
    private int connectDuration = -1;
    private String connectFailReason = "";
    private long disconnectTime = -1;
    private int result = -1;
    private long startConnectTime = -1;
    private String whoCallService = "";

    public P2PConnectionTracker(ReportTracker reportTracker, int i, String str) {
        super(reportTracker, i, str);
        this.logTag = "P2PConnectionTracker";
        if (i == 1) {
            this.whoCallService = "自研手机";
        } else if (i == 4) {
            this.whoCallService = "三方Android";
        }
    }

    public P2PConnectionTracker band(String str) {
        if (!isSupportTracker()) {
            return this;
        }
        log("band=" + str, new Object[0]);
        this.band = str;
        return this;
    }

    public Map<String, Object> buildMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("p2p_connect_star_result", Integer.valueOf(this.result));
        hashMap.put("servies_call_p2p", this.whoCallService);
        hashMap.put("time_p2p_connect_star", Integer.valueOf(this.connectDuration));
        hashMap.put("p2p_connect_time", Long.valueOf(this.startConnectTime));
        hashMap.put("p2p_disconnect_time", Long.valueOf(this.disconnectTime));
        hashMap.put("reason_fail_p2p_connect_star", this.connectFailReason);
        hashMap.put("channel_band", this.band);
        return hashMap;
    }

    public P2PConnectionTracker connectFailReason(String str) {
        if (!isSupportTracker() || this.result == 0) {
            return this;
        }
        log("connectFailReason=" + str, new Object[0]);
        this.connectFailReason = str;
        this.result = 1;
        return this;
    }

    public boolean isConnected() {
        return this.result == 0;
    }

    public boolean isConnecting() {
        return !isConnected() && !TextUtils.isEmpty(this.eventName);
    }

    public /* bridge */ /* synthetic */ boolean isSupportTracker() {
        return super.isSupportTracker();
    }

    public P2PConnectionTracker onDisconnect() {
        if (!isSupportTracker()) {
            return this;
        }
        log("p2p onDisconnect", new Object[0]);
        this.disconnectTime = System.currentTimeMillis();
        return this;
    }

    public P2PConnectionTracker p2pConnected() {
        if (!isSupportTracker()) {
            return this;
        }
        log("p2pConnected", new Object[0]);
        this.connectDuration = (int) (System.currentTimeMillis() - this.startConnectTime);
        this.result = 0;
        return this;
    }

    public void recycle() {
        this.eventName = null;
        this.result = -1;
        this.connectFailReason = "";
        this.band = "";
        this.startConnectTime = -1;
        this.disconnectTime = -1;
        this.connectDuration = -1;
    }

    public /* bridge */ /* synthetic */ boolean start3rdReport() {
        return super.start3rdReport();
    }

    public P2PConnectionTracker startConnect(int i, String str) {
        if (!isSupportTracker()) {
            return this;
        }
        this.peerTerminalType = i;
        this.peerDeviceID = str;
        log("startConnectP2P", new Object[0]);
        this.startConnectTime = System.currentTimeMillis();
        this.eventName = TrackerConstant.EVENT_NAME_CONNECT_P2P;
        return this;
    }

    public /* bridge */ /* synthetic */ boolean startReport() {
        return super.startReport();
    }

    public /* bridge */ /* synthetic */ boolean isSupportTracker(int i) {
        return super.isSupportTracker(i);
    }
}
