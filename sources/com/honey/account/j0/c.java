package com.honey.account.j0;

import androidx.work.impl.Processor;
import androidx.work.impl.model.WorkGenerationalId;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Processor f3060a;
    public final /* synthetic */ WorkGenerationalId b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ c(Processor processor, WorkGenerationalId workGenerationalId, boolean z) {
        this.f3060a = processor;
        this.b = workGenerationalId;
        this.c = z;
    }

    public final void run() {
        this.f3060a.l(this.b, this.c);
    }
}
