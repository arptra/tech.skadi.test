package com.honey.account.j0;

import androidx.work.Configuration;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.List;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f3062a;
    public final /* synthetic */ WorkGenerationalId b;
    public final /* synthetic */ Configuration c;
    public final /* synthetic */ WorkDatabase d;

    public /* synthetic */ e(List list, WorkGenerationalId workGenerationalId, Configuration configuration, WorkDatabase workDatabase) {
        this.f3062a = list;
        this.b = workGenerationalId;
        this.c = configuration;
        this.d = workDatabase;
    }

    public final void run() {
        Schedulers.d(this.f3062a, this.b, this.c, this.d);
    }
}
