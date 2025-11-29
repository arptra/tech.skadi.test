package com.honey.account.q0;

import androidx.work.impl.workers.ConstraintTrackingWorker;
import kotlinx.coroutines.Job;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Job f3084a;

    public /* synthetic */ b(Job job) {
        this.f3084a = job;
    }

    public final void run() {
        ConstraintTrackingWorker.t(this.f3084a);
    }
}
