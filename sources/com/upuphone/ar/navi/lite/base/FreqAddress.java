package com.upuphone.ar.navi.lite.base;

public class FreqAddress {

    /* renamed from: a  reason: collision with root package name */
    public String f5655a;
    public int b;
    public String c;
    public double d;
    public double e;
    public String f;
    public int g;

    public FreqAddress() {
    }

    public String a() {
        return this.c;
    }

    public int b() {
        return this.g;
    }

    public int c() {
        return this.b;
    }

    public double d() {
        return this.d;
    }

    public double e() {
        return this.e;
    }

    public String f() {
        return this.f5655a;
    }

    public String g() {
        return this.f;
    }

    public String toString() {
        return "FreqNaviAddress{name='" + this.f5655a + ", distance=" + this.b + ", address='" + this.c + ", latitude=" + this.d + ", longitude=" + this.e + ", poiId='" + this.f + ", alias='" + this.g + '}';
    }

    public FreqAddress(String str, int i, String str2, double d2, double d3, String str3, int i2) {
        this.f5655a = str;
        this.b = i;
        this.c = str2;
        this.d = d2;
        this.e = d3;
        this.f = str3;
        this.g = i2;
    }
}
