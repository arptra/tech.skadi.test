package com.honey.account.x;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleController;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlinx.coroutines.Job;

public final /* synthetic */ class b implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LifecycleController f3136a;
    public final /* synthetic */ Job b;

    public /* synthetic */ b(LifecycleController lifecycleController, Job job) {
        this.f3136a = lifecycleController;
        this.b = job;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        LifecycleController.c(this.f3136a, this.b, lifecycleOwner, event);
    }
}
