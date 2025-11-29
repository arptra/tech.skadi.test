package com.upuphone.ar.transcribe.utils;

import com.honey.account.c5.a;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.upuphone.ar.transcribe.phone.listener.RefreshLoadListener;

public class RecycleHelper<T> {

    /* renamed from: a  reason: collision with root package name */
    public final RefreshLoadListener f6191a;
    public RefreshLayout b;
    public boolean c = false;
    public Object d;
    public int e = 20;
    public int f = 1;

    public RecycleHelper(RefreshLoadListener refreshLoadListener, RefreshLayout refreshLayout) {
        this.f6191a = refreshLoadListener;
        if (refreshLayout != null) {
            this.b = refreshLayout;
            refreshLayout.c(new a(this));
        }
    }

    public boolean b() {
        RefreshLayout refreshLayout = this.b;
        if (refreshLayout == null) {
            return false;
        }
        return refreshLayout.b();
    }

    public boolean c() {
        return this.c;
    }

    public int d() {
        return this.e;
    }

    public final /* synthetic */ void e(RefreshLayout refreshLayout) {
        if (!this.c) {
            g();
        } else {
            f();
        }
    }

    public final void f() {
        j(false);
        this.f6191a.noMoreData();
    }

    public void g() {
        if (this.c) {
            f();
            return;
        }
        this.f++;
        j(true);
        this.f6191a.onLoadMoreData(this.d, this.f, this.e);
    }

    public void h() {
        this.d = null;
        this.f = 1;
        this.c = false;
        j(true);
        this.f6191a.onLoadMoreData(this.d, this.f, this.e);
    }

    public void i(boolean z) {
        this.c = z;
    }

    public final void j(boolean z) {
        RefreshLayout refreshLayout = this.b;
        if (refreshLayout != null) {
            refreshLayout.a(z);
        }
    }
}
