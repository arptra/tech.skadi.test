package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;

final class LockedResource<Z> implements Resource<Z>, FactoryPools.Poolable {
    public static final Pools.Pool e = FactoryPools.d(20, new FactoryPools.Factory<LockedResource<?>>() {
        /* renamed from: a */
        public LockedResource create() {
            return new LockedResource();
        }
    });

    /* renamed from: a  reason: collision with root package name */
    public final StateVerifier f2498a = StateVerifier.a();
    public Resource b;
    public boolean c;
    public boolean d;

    public static LockedResource e(Resource resource) {
        LockedResource lockedResource = (LockedResource) Preconditions.d((LockedResource) e.acquire());
        lockedResource.d(resource);
        return lockedResource;
    }

    private void g() {
        this.b = null;
        e.a(this);
    }

    public synchronized void a() {
        this.f2498a.c();
        this.d = true;
        if (!this.c) {
            this.b.a();
            g();
        }
    }

    public int b() {
        return this.b.b();
    }

    public Class c() {
        return this.b.c();
    }

    public final void d(Resource resource) {
        this.d = false;
        this.c = true;
        this.b = resource;
    }

    public StateVerifier f() {
        return this.f2498a;
    }

    public Object get() {
        return this.b.get();
    }

    public synchronized void h() {
        this.f2498a.c();
        if (this.c) {
            this.c = false;
            if (this.d) {
                a();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }
}
