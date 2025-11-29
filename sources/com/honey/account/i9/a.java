package com.honey.account.i9;

import com.xingin.xhssharesdk.callback.XhsShareCallback;
import com.xingin.xhssharesdk.core.XhsShareSdk;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XhsShareCallback f7447a;
    public final /* synthetic */ com.xingin.xhssharesdk.i.a b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;

    public /* synthetic */ a(XhsShareCallback xhsShareCallback, com.xingin.xhssharesdk.i.a aVar, int i, String str) {
        this.f7447a = xhsShareCallback;
        this.b = aVar;
        this.c = i;
        this.d = str;
    }

    public final void run() {
        XhsShareSdk.a(this.f7447a, this.b, this.c, this.d);
    }
}
