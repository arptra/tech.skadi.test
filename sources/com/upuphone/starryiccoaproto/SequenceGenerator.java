package com.upuphone.starryiccoaproto;

import java.util.concurrent.atomic.AtomicInteger;

public class SequenceGenerator {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicInteger f6516a = new AtomicInteger(1);

    public static int a() {
        return f6516a.getAndIncrement();
    }
}
