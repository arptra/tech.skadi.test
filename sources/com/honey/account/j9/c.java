package com.honey.account.j9;

import android.net.Uri;
import com.xingin.xhssharesdk.i.c;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c.C0031c f7451a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Uri c;

    public /* synthetic */ c(c.C0031c cVar, String str, Uri uri) {
        this.f7451a = cVar;
        this.b = str;
        this.c = uri;
    }

    public final void run() {
        this.f7451a.f(this.b, this.c);
    }
}
