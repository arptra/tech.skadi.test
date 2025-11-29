package com.honey.account.j0;

import androidx.work.impl.Processor;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Processor f3058a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ String c;

    public /* synthetic */ a(Processor processor, ArrayList arrayList, String str) {
        this.f3058a = processor;
        this.b = arrayList;
        this.c = str;
    }

    public final Object call() {
        return this.f3058a.m(this.b, this.c);
    }
}
