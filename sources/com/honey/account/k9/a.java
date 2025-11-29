package com.honey.account.k9;

import com.xingin.xhssharesdk.o.b;
import java.util.Map;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f7455a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ b.C0032b c;
    public final /* synthetic */ b.c d;

    public /* synthetic */ a(String str, Map map, b.C0032b bVar, b.c cVar) {
        this.f7455a = str;
        this.b = map;
        this.c = bVar;
        this.d = cVar;
    }

    public final void run() {
        b.b(this.f7455a, this.b, this.c, this.d);
    }
}
