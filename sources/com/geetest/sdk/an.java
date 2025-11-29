package com.geetest.sdk;

import android.content.Context;
import com.geetest.sdk.b;
import com.geetest.sdk.model.beans.b;
import com.geetest.sdk.model.beans.c;

public abstract class an {

    /* renamed from: a  reason: collision with root package name */
    public int f2909a = 1;
    public com.geetest.sdk.model.beans.a b;
    public Context c;
    public GT3ConfigBean d;
    public h e;
    public b f;
    public long g;
    public b.C0012b h;
    public int i = 1;
    public c j;
    public a k;

    public enum a {
        SHUTDOWN,
        ONEPASS,
        NORMAL,
        REQUESTING
    }

    public an(int i2) {
        a aVar = a.SHUTDOWN;
        this.f2909a = i2;
        this.g = System.currentTimeMillis();
    }

    public b.C0012b a() {
        return this.h;
    }

    public void b(int i2) {
        this.i = i2;
    }

    public void c(Context context) {
        this.c = context;
    }

    public void d(GT3ConfigBean gT3ConfigBean) {
        this.d = gT3ConfigBean;
    }

    public void e(b.C0012b bVar) {
        this.h = bVar;
    }

    public void f(h hVar) {
        this.e = hVar;
    }

    public void g(com.geetest.sdk.model.beans.a aVar) {
        this.b = aVar;
    }

    public void h(com.geetest.sdk.model.beans.b bVar) {
        this.f = bVar;
    }

    public void i(c cVar) {
        this.j = cVar;
    }

    public GT3ConfigBean j() {
        return this.d;
    }

    public void k(int i2) {
        this.f2909a = i2;
    }

    public Context l() {
        return this.c;
    }

    public com.geetest.sdk.model.beans.b m() {
        return this.f;
    }

    public h n() {
        return this.e;
    }

    public com.geetest.sdk.model.beans.a o() {
        return this.b;
    }

    public int p() {
        return this.i;
    }

    public int q() {
        return this.f2909a;
    }

    public c r() {
        return this.j;
    }

    public long s() {
        return this.g;
    }
}
