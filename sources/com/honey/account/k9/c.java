package com.honey.account.k9;

import com.xingin.xhssharesdk.o.b;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b.c f7457a;
    public final /* synthetic */ Exception b;

    public /* synthetic */ c(b.c cVar, Exception exc) {
        this.f7457a = cVar;
        this.b = exc;
    }

    public final void run() {
        this.f7457a.e(this.b);
    }
}
