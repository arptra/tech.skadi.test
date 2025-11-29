package com.upuphone.runasone.utils;

import com.upuphone.starrynet.tracker.StTracker;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.HashMap;

public class TrackHelper {
    public static final int AUTH_FAIL = -1;
    public static final int AUTH_SUCCEED = 1;
    public static final int AUTH_TIMEOUT = 2;
    public static final String CONNECT_TIME = "virtual_channel_connect";
    public static final String RUNASONE_AUTH = "runasone_channel_auth";
    private static final String TAG = "TrackHelper";

    public static void recordConnectTime(String str, long j, int i) {
        String str2 = TAG;
        LogUtil.d(str2, (Object) "type:" + str + ", time:" + j + ", result:" + i);
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put(RtspHeaders.Values.TIME, String.valueOf(j));
        hashMap.put("result", String.valueOf(i));
        StTracker.getInstance().reportEvent(CONNECT_TIME, hashMap);
    }

    public static void runAsOneAuthState(String str, String str2, byte b, boolean z) {
        String str3 = TAG;
        LogUtil.d(str3, (Object) "result:" + z);
        HashMap hashMap = new HashMap();
        hashMap.put("selfId", str);
        hashMap.put("content", str2);
        hashMap.put("type", String.valueOf(b));
        hashMap.put("auth_result", String.valueOf(z ? 0 : -1));
        StTracker.getInstance().reportEvent(RUNASONE_AUTH, hashMap);
    }
}
