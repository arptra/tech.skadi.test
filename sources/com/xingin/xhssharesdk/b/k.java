package com.xingin.xhssharesdk.b;

import android.os.Build;

public final class k implements Cloneable {
    public static final k f = new k();

    /* renamed from: a  reason: collision with root package name */
    public String f8159a;
    public String b;
    public int c;
    public String d = Build.BRAND;
    public String e = Build.MODEL;

    public static k b() {
        return f;
    }

    public final String toString() {
        return "TrackerEventDevice{deviceId='" + this.f8159a + "', platform='Android', osVersionName='" + this.b + "', osVersionCode=" + this.c + ", deviceAbi='null', deviceLevel=0, deviceBrand='" + this.d + "', deviceModel='" + this.e + "'}";
    }
}
