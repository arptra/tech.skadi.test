package com.geetest.sdk;

import com.geetest.sdk.utils.GT3Protocol;
import com.geetest.sdk.utils.GT3ServiceNode;
import java.util.Map;
import org.json.JSONObject;

public class GT3ConfigBean implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public int f2896a = 10000;
    public int b = 10000;
    public String c;
    public GT3Listener d;
    public boolean e;
    public JSONObject f;
    public int g = 1;
    public Map h;
    public GT3LoadImageView i;
    public GT3ServiceNode j;
    public String[] k;
    public GT3Protocol l;
    public boolean m;
    public Map n;
    public int o;
    public int p;
    public boolean q = false;

    public void A(int i2) {
        this.f2896a = i2;
    }

    public void B(int i2) {
        this.b = i2;
    }

    public JSONObject a() {
        return this.f;
    }

    public int b() {
        return this.o;
    }

    public int c() {
        return this.p;
    }

    public Map d() {
        return this.n;
    }

    public GT3Protocol e() {
        return this.l;
    }

    public GT3ServiceNode f() {
        return this.j;
    }

    public String g() {
        return this.c;
    }

    public GT3Listener h() {
        return this.d;
    }

    public GT3LoadImageView i() {
        return this.i;
    }

    public int j() {
        return this.g;
    }

    public int k() {
        return this.f2896a;
    }

    public String[] l() {
        return this.k;
    }

    public Map m() {
        return this.h;
    }

    public int n() {
        return this.b;
    }

    public boolean o() {
        return this.e;
    }

    public boolean p() {
        return this.q;
    }

    public boolean q() {
        return this.m;
    }

    public void r(JSONObject jSONObject) {
        this.f = jSONObject;
    }

    public void s(boolean z) {
        this.e = z;
    }

    public void t(int i2) {
        this.o = i2;
    }

    public void u(int i2) {
        this.p = i2;
    }

    public void v(GT3ServiceNode gT3ServiceNode) {
        this.j = gT3ServiceNode;
    }

    public void w(String str) {
        this.c = str;
    }

    public void x(GT3Listener gT3Listener) {
        this.d = gT3Listener;
    }

    public void y(int i2) {
        this.g = i2;
    }

    public void z(boolean z) {
        this.q = z;
    }
}
