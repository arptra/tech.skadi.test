package com.honey.account.j0;

import androidx.work.Configuration;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.List;
import java.util.concurrent.Executor;

public final /* synthetic */ class d implements ExecutionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Executor f3061a;
    public final /* synthetic */ List b;
    public final /* synthetic */ Configuration c;
    public final /* synthetic */ WorkDatabase d;

    public /* synthetic */ d(Executor executor, List list, Configuration configuration, WorkDatabase workDatabase) {
        this.f3061a = executor;
        this.b = list;
        this.c = configuration;
        this.d = workDatabase;
    }

    public final void c(WorkGenerationalId workGenerationalId, boolean z) {
        this.f3061a.execute(new e(this.b, workGenerationalId, this.c, this.d));
    }
}
