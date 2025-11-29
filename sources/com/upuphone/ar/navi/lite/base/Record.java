package com.upuphone.ar.navi.lite.base;

import androidx.databinding.BaseObservable;
import androidx.room.Entity;
import com.upuphone.ar.navi.lite.util.NaviUtil;

@Entity
public class Record extends BaseObservable {

    /* renamed from: a  reason: collision with root package name */
    public int f5658a;
    public String b = NaviUtil.t();
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public int j;
    public double k;
    public double l;
    public String m;
    public int n;
    public String o;

    public void A(int i2) {
        this.f5658a = i2;
    }

    public void B(String str) {
        this.m = str;
    }

    public void C(double d2) {
        this.l = d2;
    }

    public void D(double d2) {
        this.k = d2;
    }

    public void E(String str) {
        this.c = str;
    }

    public void F(String str) {
        this.g = str;
    }

    public String a() {
        return this.b;
    }

    public String c() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.o;
    }

    public String g() {
        return this.h;
    }

    public String getName() {
        return this.c;
    }

    public int h() {
        return this.n;
    }

    public String i() {
        return this.f;
    }

    public int j() {
        return this.j;
    }

    public String k() {
        return this.i;
    }

    public int l() {
        return this.f5658a;
    }

    public String m() {
        return this.m;
    }

    public double n() {
        return this.l;
    }

    public double p() {
        return this.k;
    }

    public String q() {
        return this.g;
    }

    public void r(String str) {
        this.b = str;
    }

    public void s(String str) {
        this.d = str;
    }

    public void t(String str) {
        this.e = str;
    }

    public String toString() {
        return "Record{id=" + this.f5658a + ", accountId=" + this.b + ", name='" + this.c + '\'' + ", acode='" + this.d + '\'' + ", address='" + this.e + '\'' + ", country='" + this.f + '\'' + ", province='" + this.g + '\'' + ", city='" + this.h + '\'' + ", district='" + this.i + '\'' + ", distance=" + this.j + ", lng=" + this.k + ", lat=" + this.l + ", lastUseTime='" + this.m + '\'' + ", count=" + this.n + ", alias='" + this.o + '\'' + '}';
    }

    public void u(String str) {
        this.o = str;
    }

    public void v(String str) {
        this.h = str;
    }

    public void w(int i2) {
        this.n = i2;
    }

    public void x(String str) {
        this.f = str;
    }

    public void y(int i2) {
        this.j = i2;
    }

    public void z(String str) {
        this.i = str;
    }
}
