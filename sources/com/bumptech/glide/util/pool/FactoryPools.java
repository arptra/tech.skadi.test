package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

public final class FactoryPools {

    /* renamed from: a  reason: collision with root package name */
    public static final Resetter f2752a = new Resetter<Object>() {
        public void a(Object obj) {
        }
    };

    public interface Factory<T> {
        Object create();
    }

    public static final class FactoryPool<T> implements Pools.Pool<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Factory f2753a;
        public final Resetter b;
        public final Pools.Pool c;

        public FactoryPool(Pools.Pool pool, Factory factory, Resetter resetter) {
            this.c = pool;
            this.f2753a = factory;
            this.b = resetter;
        }

        public boolean a(Object obj) {
            if (obj instanceof Poolable) {
                ((Poolable) obj).f().b(true);
            }
            this.b.a(obj);
            return this.c.a(obj);
        }

        public Object acquire() {
            Object acquire = this.c.acquire();
            if (acquire == null) {
                acquire = this.f2753a.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + acquire.getClass());
                }
            }
            if (acquire instanceof Poolable) {
                ((Poolable) acquire).f().b(false);
            }
            return acquire;
        }
    }

    public interface Poolable {
        StateVerifier f();
    }

    public interface Resetter<T> {
        void a(Object obj);
    }

    public static Pools.Pool a(Pools.Pool pool, Factory factory) {
        return b(pool, factory, c());
    }

    public static Pools.Pool b(Pools.Pool pool, Factory factory, Resetter resetter) {
        return new FactoryPool(pool, factory, resetter);
    }

    public static Resetter c() {
        return f2752a;
    }

    public static Pools.Pool d(int i, Factory factory) {
        return a(new Pools.SynchronizedPool(i), factory);
    }

    public static Pools.Pool e() {
        return f(20);
    }

    public static Pools.Pool f(int i) {
        return b(new Pools.SynchronizedPool(i), new Factory<List<Object>>() {
            /* renamed from: a */
            public List create() {
                return new ArrayList();
            }
        }, new Resetter<List<Object>>() {
            /* renamed from: b */
            public void a(List list) {
                list.clear();
            }
        });
    }
}
