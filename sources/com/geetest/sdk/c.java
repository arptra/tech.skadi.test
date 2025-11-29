package com.geetest.sdk;

import android.content.Context;
import com.geetest.sdk.b;
import com.geetest.sdk.h;
import com.geetest.sdk.utils.d;
import com.geetest.sdk.utils.l;

public class c {
    public static final String i = "c";

    /* renamed from: a  reason: collision with root package name */
    public Context f2913a;
    public GT3ConfigBean b;
    public ao c;
    public h d;
    public b.C0012b e;
    public String f;
    public boolean g = false;
    public int h = 1;

    public c(Context context) {
        this.f2913a = context;
    }

    public void a(int i2) {
        this.h = i2;
    }

    public void b(GT3ConfigBean gT3ConfigBean) {
        this.b = gT3ConfigBean;
    }

    public void c(b.C0012b bVar) {
        this.e = bVar;
    }

    public void d(String str) {
        this.f = str;
    }

    public void e(boolean z) {
        this.g = z;
    }

    public void f() {
        ad.c();
        ao aoVar = this.c;
        if (!(aoVar == null || aoVar.n() == null)) {
            this.c.n().r();
        }
        this.f2913a = null;
    }

    public String g() {
        return this.f;
    }

    public GT3ConfigBean h() {
        return this.b;
    }

    public Context i() {
        return this.f2913a;
    }

    public int j() {
        return this.h;
    }

    public boolean k() {
        return this.g;
    }

    public void l() {
        h hVar = new h(this.f2913a, this.b);
        this.d = hVar;
        hVar.b(j());
        this.d.s();
    }

    public void m() {
        ao aoVar = this.c;
        if (aoVar != null && aoVar.n() != null) {
            this.c.n().u();
        }
    }

    public void n() {
        h hVar = this.d;
        if (hVar == null || hVar.p() != h.i.SHOW_WEB || !this.d.m() || j() == 3) {
            d.c = false;
            l.c(i, "startCustomFlow");
            if (j() == 2) {
                b.C0012b bVar = this.e;
                if (bVar != null) {
                    bVar.d();
                    this.e.i();
                }
                if (k()) {
                    this.b.h().onButtonClick();
                    return;
                }
                throw new IllegalArgumentException("Mode configuration error !");
            }
            l();
            this.b.h().onButtonClick();
            return;
        }
        d.c = true;
        try {
            this.d.o().show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void o() {
        ao aoVar = new ao(0);
        this.c = aoVar;
        aoVar.e(this.e);
        this.c.c(i());
        this.c.d(h());
        this.c.b(j());
        this.c.i(new com.geetest.sdk.model.beans.c());
        com.geetest.sdk.model.beans.b bVar = new com.geetest.sdk.model.beans.b();
        bVar.l(h().m());
        bVar.e(h().d());
        bVar.f(false);
        bVar.A(h().g());
        bVar.q(h().k());
        bVar.t(h().n());
        bVar.a(h().b());
        bVar.d(g());
        String g2 = g();
        int indexOf = g2.indexOf("/");
        if (indexOf > 0) {
            bVar.k(g2.substring(0, indexOf));
        } else {
            bVar.k(g());
        }
        this.c.h(bVar);
        q qVar = new q();
        w wVar = new w();
        s sVar = new s();
        x xVar = new x();
        t tVar = new t();
        qVar.b(wVar);
        wVar.b(sVar);
        sVar.b(xVar);
        xVar.b(tVar);
        if (j() != 1) {
            this.d = new h(this.f2913a, this.b);
        } else if (this.d == null) {
            this.d = new h(this.f2913a, this.b);
        }
        this.d.b(j());
        this.d.d(this.e);
        this.d.g(k());
        this.c.f(this.d);
        qVar.d(this.c);
    }
}
