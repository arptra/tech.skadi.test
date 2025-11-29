package com.upuphone.xr.interconnect.util;

public final class ObjectUtil {
    private ObjectUtil() {
    }

    public static String getObjectId(Object obj) {
        return Integer.toHexString(obj.hashCode());
    }
}
