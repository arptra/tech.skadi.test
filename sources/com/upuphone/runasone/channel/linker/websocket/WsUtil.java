package com.upuphone.runasone.channel.linker.websocket;

import com.upuphone.runasone.utils.LogUtil;
import java.io.IOException;
import java.net.InetAddress;

public class WsUtil {
    public static final int CHANNEL_HEART_BEAT_TIME_OUT = 30;
    public static final int GROUP_ID = 65278;
    public static final String HTTP_REQUEST_DEVICE = "Device";
    public static final String HTTP_REQUEST_GROUP = "Group";
    public static final int MAX_CONTENT_LENGTH = 10000000;
    public static final int MAX_FRAME_PAYLOAD_LENGTH = 10000000;
    public static final int MAX_UNREACHABLE = 3;
    private static final int THRESHOLD_LAGGING = 20;
    public static final int THRESHOLD_QOS_CHECK = 3000;
    public static final int TIMEOUT_ACK = 3000;
    private static final int TIMEOUT_CHECK_LAGGING = 2000;
    private static final int TIMEOUT_PING = 200;
    public static final int TIMEOUT_TEARDOWN_ACK = 300;
    public static final int UNREACHABLE = -1;
    public static final String WEB_SOCKET_PATH = "websocket";

    public static int detectLink(String str) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            z = InetAddress.getByName(str).isReachable(2000);
        } catch (IOException e) {
            e.printStackTrace();
            LogUtil.e("target is unReachable...");
            z = false;
        }
        return (int) (z ? System.currentTimeMillis() - currentTimeMillis : -1);
    }

    public static boolean pingServer(String str) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            z = InetAddress.getByName(str).isReachable(200);
        } catch (IOException e) {
            e.printStackTrace();
            LogUtil.e("target is unReachable...");
            z = false;
        }
        if (z) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis2 < 20) {
                LogUtil.d("ping <" + str + "> cost: " + currentTimeMillis2 + "ms");
            } else {
                LogUtil.e("ping <" + str + "> cost: " + currentTimeMillis2 + "ms, lagging !!!");
            }
        } else {
            LogUtil.e("ping <" + str + "> ... it's not reachable !!!");
        }
        return z;
    }
}
