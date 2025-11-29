package com.geetest.sdk;

@ProguardKeepClassMembers
public class GT3ErrorBean implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public String f2897a;
    public String b;
    public long c;
    public String d;
    public String e;
    public String f;
    public boolean g = false;

    public GT3ErrorBean(String str, String str2, long j, String str3, String str4, String str5) {
        this.f2897a = str;
        this.b = str2;
        this.c = j;
        this.d = str3;
        this.e = str4;
        this.f = str5;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public String toString() {
        return "GT3ErrorBean{errorCode='" + this.f2897a + '\'' + ", errorDesc='" + this.b + '\'' + ", duration=" + this.c + ", challenge='" + this.d + '\'' + ", type='" + this.e + '\'' + ", sdkVersion='" + this.f + '\'' + ", isChangeDesc=" + this.g + '}';
    }
}
