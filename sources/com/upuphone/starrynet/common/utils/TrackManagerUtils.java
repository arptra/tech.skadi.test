package com.upuphone.starrynet.common.utils;

import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.tracker.StTracker;
import java.util.HashMap;

public class TrackManagerUtils {
    private static final String EVENT_BLE_RECONNECT_SUCCESS_RATE = "ble_reconnect_success_rate";
    private static final String EVENT_BLE_RECONNECT_TIME = "ble_reconnect_time";
    private static final String EVENT_P2P_CONNECT_SUCCESS_RATE = "p2p_connect_success_rate";
    private static final String EVENT_P2P_CONNECT_TIME = "p2p_connect_time";
    private static final String TAG = "TrackManagerUtils";
    private static String bleSessionId;
    private static String p2pSessionId;

    private TrackManagerUtils() {
    }

    public static void trackBleConnectEndFail(String str) {
        if (bleSessionId != null) {
            StLog.d(TAG, "trackBleConnectEndFail, errorCode = " + str);
            HashMap hashMap = new HashMap();
            hashMap.put("fail", "1");
            hashMap.put("errorCode", str);
            StTracker.getInstance().reportEvent(EVENT_BLE_RECONNECT_SUCCESS_RATE, hashMap);
            bleSessionId = null;
        }
    }

    public static void trackBleConnectEndSuccess() {
        if (bleSessionId != null) {
            StLog.d(TAG, "trackBleConnectEndSuccess, bleSessionId = " + bleSessionId);
            HashMap hashMap = new HashMap();
            hashMap.put("success", "1");
            StTracker.getInstance().reportEvent(EVENT_BLE_RECONNECT_SUCCESS_RATE, hashMap);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("endTime", String.valueOf(System.currentTimeMillis()));
            hashMap2.put("id", bleSessionId);
            StTracker.getInstance().reportEvent(EVENT_BLE_RECONNECT_TIME, hashMap2);
            bleSessionId = null;
        }
    }

    public static void trackBleConnectStart() {
        bleSessionId = Utils.getRandomString(10);
        StLog.d(TAG, "trackBleConnectStart, bleSessionId = " + bleSessionId);
        HashMap hashMap = new HashMap();
        hashMap.put("sum", "1");
        StTracker.getInstance().reportEvent(EVENT_BLE_RECONNECT_SUCCESS_RATE, hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("startTime", String.valueOf(System.currentTimeMillis()));
        hashMap2.put("id", bleSessionId);
        StTracker.getInstance().reportEvent(EVENT_BLE_RECONNECT_TIME, hashMap2);
    }

    public static void trackP2pConnectSuccessRateFail(String str) {
        StLog.d(TAG, "trackP2pConnectSuccessRateFail");
        HashMap hashMap = new HashMap();
        hashMap.put("fail", "1");
        hashMap.put("errorCode", str);
        StTracker.getInstance().reportEvent(EVENT_P2P_CONNECT_SUCCESS_RATE, hashMap);
    }

    public static void trackP2pConnectSuccessRateStart() {
        StLog.d(TAG, "trackP2pConnectSuccessRateStart");
        HashMap hashMap = new HashMap();
        hashMap.put("sum", "1");
        StTracker.getInstance().reportEvent(EVENT_P2P_CONNECT_SUCCESS_RATE, hashMap);
    }

    public static void trackP2pConnectSuccessRateSuccess() {
        StLog.d(TAG, "trackP2pConnectSuccessRateSuccess");
        HashMap hashMap = new HashMap();
        hashMap.put("success", "1");
        StTracker.getInstance().reportEvent(EVENT_P2P_CONNECT_SUCCESS_RATE, hashMap);
    }

    public static void trackP2pConnectTime(boolean z) {
        HashMap hashMap = new HashMap();
        if (z) {
            p2pSessionId = Utils.getRandomString(10);
            hashMap.put("startTime", String.valueOf(System.currentTimeMillis()));
        } else {
            hashMap.put("endTime", String.valueOf(System.currentTimeMillis()));
        }
        StLog.d(TAG, "trackP2pConnectTime, start = " + z + ", p2pSessionId = " + p2pSessionId);
        hashMap.put("id", p2pSessionId);
        StTracker.getInstance().reportEvent(EVENT_P2P_CONNECT_TIME, hashMap);
    }
}
