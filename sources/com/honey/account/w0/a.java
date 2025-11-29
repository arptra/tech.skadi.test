package com.honey.account.w0;

import com.example.flutter_pag_plugin.DataLoadHelper;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3133a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ long c;
    public final /* synthetic */ int d;

    public /* synthetic */ a(String str, Function1 function1, long j, int i) {
        this.f3133a = str;
        this.b = function1;
        this.c = j;
        this.d = i;
    }

    public final void run() {
        DataLoadHelper.i(this.f3133a, this.b, this.c, this.d);
    }
}
