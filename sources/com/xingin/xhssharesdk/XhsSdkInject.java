package com.xingin.xhssharesdk;

import androidx.annotation.Keep;

@Keep
public class XhsSdkInject {
    private static String checkTokenRequestPath = "https://edith.xiaohongshu.com/api/sns/v1/ext/share/token";
    private static boolean debugTracker = false;
    private static String shareNoteMaxXhsVersionName = "";
    private static String shareNoteMinXhsVersionName = "7.81.0";
    private static String uid;

    public static String getCheckTokenRequestPath() {
        return checkTokenRequestPath;
    }

    public static String getShareNoteMaxXhsVersionName() {
        return shareNoteMaxXhsVersionName;
    }

    public static String getShareNoteMinXhsVersionName() {
        return shareNoteMinXhsVersionName;
    }

    public static String getUid() {
        return uid;
    }

    public static boolean isDebugTracker() {
        return debugTracker;
    }
}
