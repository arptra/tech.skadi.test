package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;

class EngineResource<Z> implements Resource<Z> {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f2494a;
    public final boolean b;
    public final Resource c;
    public final ResourceListener d;
    public final Key e;
    public int f;
    public boolean g;

    public interface ResourceListener {
        void c(Key key, EngineResource engineResource);
    }

    public EngineResource(Resource resource, boolean z, boolean z2, Key key, ResourceListener resourceListener) {
        this.c = (Resource) Preconditions.d(resource);
        this.f2494a = z;
        this.b = z2;
        this.e = key;
        this.d = (ResourceListener) Preconditions.d(resourceListener);
    }

    public synchronized void a() {
        if (this.f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.g) {
            this.g = true;
            if (this.b) {
                this.c.a();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    public int b() {
        return this.c.b();
    }

    public Class c() {
        return this.c.c();
    }

    public synchronized void d() {
        if (!this.g) {
            this.f++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    public Resource e() {
        return this.c;
    }

    public boolean f() {
        return this.f2494a;
    }

    public void g() {
        boolean z;
        synchronized (this) {
            int i = this.f;
            if (i > 0) {
                z = true;
                int i2 = i - 1;
                this.f = i2;
                if (i2 != 0) {
                    z = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z) {
            this.d.c(this.e, this);
        }
    }

    public Object get() {
        return this.c.get();
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f2494a + ", listener=" + this.d + ", key=" + this.e + ", acquired=" + this.f + ", isRecycled=" + this.g + ", resource=" + this.c + '}';
    }
}
