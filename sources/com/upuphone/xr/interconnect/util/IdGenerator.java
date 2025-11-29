package com.upuphone.xr.interconnect.util;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private static final AtomicLong GENERATOR = new AtomicLong(0);

    private IdGenerator() {
    }

    public static Long generateId() {
        return Long.valueOf(GENERATOR.getAndIncrement());
    }

    public static String generateIdStr() {
        return String.valueOf(GENERATOR.getAndIncrement());
    }
}
