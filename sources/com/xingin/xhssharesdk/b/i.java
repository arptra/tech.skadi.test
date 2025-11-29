package com.xingin.xhssharesdk.b;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public final class i {
    public static final AtomicInteger h = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    public final String f8157a = UUID.randomUUID().toString();
    public final long b = System.currentTimeMillis();
    public int c;
    public final int d = h.getAndIncrement();
    public int e;
    public int f;
    public HashMap g = new HashMap();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f8158a;
        public int b;
        public int c;
        public final HashMap d = new HashMap();

        public final a a(String str, String str2) {
            this.d.put(str, str2);
            return this;
        }
    }

    public final String toString() {
        return "TrackerEventDetail{eventId='" + this.f8157a + "', eventTime=" + this.b + ", eventType=" + j.b(this.c) + ", eventSeq=" + this.d + ", pointId=" + this.e + ", eventKey='null', bizPageName='null', bizModule='null', bizAction=" + com.xingin.xhssharesdk.r.a.b(this.f) + ", dataMap=" + this.g + '}';
    }
}
