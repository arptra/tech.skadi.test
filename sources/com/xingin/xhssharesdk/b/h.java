package com.xingin.xhssharesdk.b;

import java.util.UUID;

public final class h implements Cloneable {
    public static final h e = new h();

    /* renamed from: a  reason: collision with root package name */
    public final String f8156a = UUID.randomUUID().toString();
    public int b;
    public String c;
    public int d;

    public static h b() {
        return e;
    }

    public final String toString() {
        return "TrackerEventApp{appIdBiz=" + this.b + ", appVersionName='" + this.c + "', appVersionCode=" + this.d + ", channel='null', appAbi='null', startId='" + this.f8156a + "'}";
    }
}
