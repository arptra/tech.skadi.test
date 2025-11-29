package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.bumptech.glide.util.Util;
import java.util.Queue;

abstract class BaseKeyPool<T extends Poolable> {

    /* renamed from: a  reason: collision with root package name */
    public final Queue f2505a = Util.g(20);

    public abstract Poolable a();

    public Poolable b() {
        Poolable poolable = (Poolable) this.f2505a.poll();
        return poolable == null ? a() : poolable;
    }

    public void c(Poolable poolable) {
        if (this.f2505a.size() < 20) {
            this.f2505a.offer(poolable);
        }
    }
}
