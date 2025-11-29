package com.bumptech.glide.manager;

import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class TargetTracker implements LifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final Set f2696a = Collections.newSetFromMap(new WeakHashMap());

    public void b() {
        this.f2696a.clear();
    }

    public List f() {
        return Util.k(this.f2696a);
    }

    public void k(Target target) {
        this.f2696a.add(target);
    }

    public void l(Target target) {
        this.f2696a.remove(target);
    }

    public void onDestroy() {
        for (Target onDestroy : Util.k(this.f2696a)) {
            onDestroy.onDestroy();
        }
    }

    public void onStart() {
        for (Target onStart : Util.k(this.f2696a)) {
            onStart.onStart();
        }
    }

    public void onStop() {
        for (Target onStop : Util.k(this.f2696a)) {
            onStop.onStop();
        }
    }
}
