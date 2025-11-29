package com.honey.account.e6;

import com.upuphone.runasone.ArrayData;
import com.upuphone.runasone.relay.api.BypassCallbackAdapter;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BypassCallbackAdapter f4351a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;
    public final /* synthetic */ ArrayData f;

    public /* synthetic */ a(BypassCallbackAdapter bypassCallbackAdapter, String str, String str2, String str3, int i, ArrayData arrayData) {
        this.f4351a = bypassCallbackAdapter;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = i;
        this.f = arrayData;
    }

    public final void run() {
        this.f4351a.lambda$adapt$0(this.b, this.c, this.d, this.e, this.f);
    }
}
