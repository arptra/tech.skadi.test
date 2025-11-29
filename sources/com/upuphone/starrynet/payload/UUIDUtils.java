package com.upuphone.starrynet.payload;

import java.util.UUID;

public final class UUIDUtils {
    private static final String UUID_BASE = "0000%4s-0000-1000-8000-00805f9b34fb";
    public static final String UUID_FORMAT = "0000%04x-0000-1000-8000-00805f9b34fb";

    private UUIDUtils() {
    }

    public static UUID makeUUID(int i) {
        return UUID.fromString(String.format("0000%04x-0000-1000-8000-00805f9b34fb", new Object[]{Integer.valueOf(i)}));
    }

    public static UUID makeUUID(String str) {
        return UUID.fromString(String.format(UUID_BASE, new Object[]{str}));
    }
}
