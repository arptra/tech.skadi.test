package com.upuphone.ar.navi.lite.base;

import androidx.room.Entity;
import com.upuphone.ar.navi.lite.util.NaviUtil;

@Entity
public class NaviRecord {

    /* renamed from: a  reason: collision with root package name */
    public int f5657a;
    public String b = NaviUtil.t();
    public String c;
    public String d;
    public String e;
    public String f;
    public int g;
    public double h;
    public double i;
    public int j;
    public String k;
    public int l;
    public long m;

    public String a() {
        return this.b;
    }

    public String b() {
        return this.e;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.k;
    }

    public String e() {
        return this.f;
    }

    public int f() {
        return this.l;
    }

    public int g() {
        return this.g;
    }

    public int h() {
        return this.f5657a;
    }

    public double i() {
        return this.i;
    }

    public double j() {
        return this.h;
    }

    public int k() {
        return this.j;
    }

    public String l() {
        return this.c;
    }

    public long m() {
        return this.m;
    }

    public void n(String str) {
        this.b = str;
    }

    public void o(String str) {
        this.e = str;
    }

    public void p(String str) {
        this.d = str;
    }

    public void q(String str) {
        this.k = str;
    }

    public void r(String str) {
        this.f = str;
    }

    public void s(int i2) {
        this.l = i2;
    }

    public void t(int i2) {
        this.g = i2;
    }

    public String toString() {
        return "NaviRecord{id=" + this.f5657a + ", accountId=" + this.b + ", name='" + this.c + '\'' + ", address='" + this.d + '\'' + ", acode='" + this.e + '\'' + ", city='" + this.f + '\'' + ", distance=" + this.g + ", lng=" + this.h + ", lat=" + this.i + ", mode=" + this.j + ", alias='" + this.k + '\'' + ", count=" + this.l + ", time=" + this.m + '}';
    }

    public void u(int i2) {
        this.f5657a = i2;
    }

    public void v(double d2) {
        this.i = d2;
    }

    public void w(double d2) {
        this.h = d2;
    }

    public void x(int i2) {
        this.j = i2;
    }

    public void y(String str) {
        this.c = str;
    }

    public void z(long j2) {
        this.m = j2;
    }
}
