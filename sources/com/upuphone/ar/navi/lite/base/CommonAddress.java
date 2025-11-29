package com.upuphone.ar.navi.lite.base;

import androidx.room.Entity;
import com.upuphone.ar.navi.lite.util.NaviUtil;

@Entity
public class CommonAddress {

    /* renamed from: a  reason: collision with root package name */
    public String f5654a;
    public String b = NaviUtil.t();
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public double j;
    public double k;
    public long l;

    public String a() {
        return this.b;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.f5654a;
    }

    public String e() {
        return this.h;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.i;
    }

    public double h() {
        return this.k;
    }

    public double i() {
        return this.j;
    }

    public String j() {
        return this.c;
    }

    public String k() {
        return this.g;
    }

    public long l() {
        return this.l;
    }

    public void m(String str) {
        this.b = str;
    }

    public void n(String str) {
        this.d = str;
    }

    public void o(String str) {
        this.e = str;
    }

    public void p(String str) {
        this.f5654a = str;
    }

    public void q(String str) {
        this.h = str;
    }

    public void r(String str) {
        this.f = str;
    }

    public void s(String str) {
        this.i = str;
    }

    public void t(double d2) {
        this.k = d2;
    }

    public String toString() {
        return "CommonAddress{alias='" + this.f5654a + '\'' + ", accountId='" + this.b + '\'' + ", name='" + this.c + '\'' + ", acode='" + this.d + '\'' + ", address='" + this.e + '\'' + ", country='" + this.f + '\'' + ", province='" + this.g + '\'' + ", city='" + this.h + '\'' + ", district='" + this.i + '\'' + ", lng=" + this.j + ", lat=" + this.k + ", time=" + this.l + '}';
    }

    public void u(double d2) {
        this.j = d2;
    }

    public void v(String str) {
        this.c = str;
    }

    public void w(String str) {
        this.g = str;
    }

    public void x(long j2) {
        this.l = j2;
    }
}
