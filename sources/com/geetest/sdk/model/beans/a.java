package com.geetest.sdk.model.beans;

import com.geetest.sdk.GT3ErrorBean;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f2944a;
    public String b;
    public long c;
    public String d;
    public String e = "Sensebot";
    public String f = "4.4.2.1";
    public boolean g = false;

    public String a() {
        return this.f2944a;
    }

    public void b(long j) {
        this.c = j;
    }

    public void c(String str) {
        this.d = str;
    }

    public void d(boolean z) {
        this.g = z;
    }

    public String e() {
        return this.b;
    }

    public void f(String str) {
        this.f2944a = str;
    }

    public void g(String str) {
        this.b = str;
    }

    /* renamed from: h */
    public GT3ErrorBean clone() {
        GT3ErrorBean gT3ErrorBean = new GT3ErrorBean(this.f2944a, this.b, this.c, this.d, this.e, this.f);
        gT3ErrorBean.a(this.g);
        return gT3ErrorBean;
    }

    public String toString() {
        return "ErrorBean{errorCode='" + this.f2944a + '\'' + ", errorDesc='" + this.b + '\'' + ", duration=" + this.c + ", challenge='" + this.d + '\'' + ", type='" + this.e + '\'' + ", sdkVersion='" + this.f + '\'' + ", isChangeDesc=" + this.g + '}';
    }
}
