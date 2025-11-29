package com.upuphone.starrynet.strategy.discovery.mdns;

import android.text.TextUtils;

public class IPUtils {
    public static String ipIntToString(int i) {
        return String.format("%s.%s.%s.%s", new Object[]{Integer.valueOf((i >> 24) & 255), Integer.valueOf((i >> 16) & 255), Integer.valueOf((i >> 8) & 255), Integer.valueOf(i & 255)});
    }

    public static int ipStringToInt(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            String[] split = str.split("\\.");
            return Integer.parseInt(split[3]) | (Integer.parseInt(split[0]) << 24) | (Integer.parseInt(split[1]) << 16) | (Integer.parseInt(split[2]) << 8);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
