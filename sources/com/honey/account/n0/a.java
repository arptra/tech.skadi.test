package com.honey.account.n0;

import androidx.work.impl.constraints.trackers.ConstraintTracker;
import java.util.List;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f3072a;
    public final /* synthetic */ ConstraintTracker b;

    public /* synthetic */ a(List list, ConstraintTracker constraintTracker) {
        this.f3072a = list;
        this.b = constraintTracker;
    }

    public final void run() {
        ConstraintTracker.b(this.f3072a, this.b);
    }
}
