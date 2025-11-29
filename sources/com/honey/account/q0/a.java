package com.honey.account.q0;

import androidx.work.impl.workers.ConstraintTrackingWorker;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConstraintTrackingWorker f3083a;

    public /* synthetic */ a(ConstraintTrackingWorker constraintTrackingWorker) {
        this.f3083a = constraintTrackingWorker;
    }

    public final void run() {
        ConstraintTrackingWorker.v(this.f3083a);
    }
}
