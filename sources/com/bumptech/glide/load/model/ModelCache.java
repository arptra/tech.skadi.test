package com.bumptech.glide.load.model;

import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

public class ModelCache<A, B> {

    /* renamed from: a  reason: collision with root package name */
    public final LruCache f2570a;

    @VisibleForTesting
    public static final class ModelKey<A> {
        public static final Queue d = Util.g(0);

        /* renamed from: a  reason: collision with root package name */
        public int f2571a;
        public int b;
        public Object c;

        public static ModelKey a(Object obj, int i, int i2) {
            ModelKey modelKey;
            Queue queue = d;
            synchronized (queue) {
                modelKey = (ModelKey) queue.poll();
            }
            if (modelKey == null) {
                modelKey = new ModelKey();
            }
            modelKey.b(obj, i, i2);
            return modelKey;
        }

        public final void b(Object obj, int i, int i2) {
            this.c = obj;
            this.b = i;
            this.f2571a = i2;
        }

        public void c() {
            Queue queue = d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ModelKey)) {
                return false;
            }
            ModelKey modelKey = (ModelKey) obj;
            return this.b == modelKey.b && this.f2571a == modelKey.f2571a && this.c.equals(modelKey.c);
        }

        public int hashCode() {
            return (((this.f2571a * 31) + this.b) * 31) + this.c.hashCode();
        }
    }

    public ModelCache(long j) {
        this.f2570a = new LruCache<ModelKey<A>, B>(j) {
            /* renamed from: n */
            public void j(ModelKey modelKey, Object obj) {
                modelKey.c();
            }
        };
    }

    public Object a(Object obj, int i, int i2) {
        ModelKey a2 = ModelKey.a(obj, i, i2);
        Object h = this.f2570a.h(a2);
        a2.c();
        return h;
    }

    public void b(Object obj, int i, int i2, Object obj2) {
        this.f2570a.k(ModelKey.a(obj, i, i2), obj2);
    }
}
