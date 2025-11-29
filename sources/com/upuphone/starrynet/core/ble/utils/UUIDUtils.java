package com.upuphone.starrynet.core.ble.utils;

import java.util.UUID;

public class UUIDUtils {
    private static final String UUID_BASE = "0000%4s-0000-1000-8000-00805f9b34fb";
    public static final String UUID_FORMAT = "0000%04x-0000-1000-8000-00805f9b34fb";

    private UUIDUtils() {
    }

    private static String digits(long j, int i) {
        long j2 = 1 << (i * 4);
        return Long.toHexString((j & (j2 - 1)) | j2).substring(1);
    }

    public static String getShortUUID(UUID uuid) {
        return digits(uuid.getMostSignificantBits() >> 32, 4);
    }

    public static int getShortUUIDOfInt(UUID uuid) {
        return Integer.parseInt(getShortUUID(uuid), 16);
    }

    public static UUID makeUUID(int i) {
        return UUID.fromString(String.format("0000%04x-0000-1000-8000-00805f9b34fb", new Object[]{Integer.valueOf(i)}));
    }

    public static UUID makeUUID(String str) {
        return UUID.fromString(String.format(UUID_BASE, new Object[]{str}));
    }
}
