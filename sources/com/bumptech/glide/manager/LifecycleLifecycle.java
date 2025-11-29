package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bumptech.glide.util.Util;
import java.util.HashSet;
import java.util.Set;

final class LifecycleLifecycle implements Lifecycle, LifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    public final Set f2678a = new HashSet();
    public final Lifecycle b;

    public LifecycleLifecycle(Lifecycle lifecycle) {
        this.b = lifecycle;
        lifecycle.a(this);
    }

    public void a(LifecycleListener lifecycleListener) {
        this.f2678a.remove(lifecycleListener);
    }

    public void b(LifecycleListener lifecycleListener) {
        this.f2678a.add(lifecycleListener);
        if (this.b.b() == Lifecycle.State.DESTROYED) {
            lifecycleListener.onDestroy();
        } else if (this.b.b().isAtLeast(Lifecycle.State.STARTED)) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
        for (LifecycleListener onDestroy : Util.k(this.f2678a)) {
            onDestroy.onDestroy();
        }
        lifecycleOwner.getLifecycle().d(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(@NonNull LifecycleOwner lifecycleOwner) {
        for (LifecycleListener onStart : Util.k(this.f2678a)) {
            onStart.onStart();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(@NonNull LifecycleOwner lifecycleOwner) {
        for (LifecycleListener onStop : Util.k(this.f2678a)) {
            onStop.onStop();
        }
    }
}
