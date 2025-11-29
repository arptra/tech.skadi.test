package com.upuphone.starrynet.strategy.protocol;

import android.text.TextUtils;
import com.upuphone.starrynet.common.StLog;
import java.util.HashMap;
import java.util.Map;

public class ProtocolVersionsCache {
    private static final String TAG = "ProtocolVersionsCache";
    private static Map<String, ProtocolVersions> cache = new HashMap();

    public static ProtocolVersions getProtocolVersionsByIdentifier(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return cache.get(str);
    }

    public static boolean isSupportBleVersionV2Plus(String str) {
        if (TextUtils.isEmpty(str)) {
            StLog.w(TAG, "isSupportBleVersionV2Plus identifier is empty!");
            return false;
        }
        ProtocolVersions protocolVersions = cache.get(str);
        return protocolVersions != null && protocolVersions.getBleVersion() >= 2;
    }

    public static void remove(String str) {
        cache.remove(str);
    }

    public static void updateProtocolVersion(String str, ProtocolVersions protocolVersions) {
        cache.put(str, protocolVersions);
    }
}
