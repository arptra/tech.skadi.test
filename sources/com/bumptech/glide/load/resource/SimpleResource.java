package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public class SimpleResource<T> implements Resource<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Object f2611a;

    public SimpleResource(Object obj) {
        this.f2611a = Preconditions.d(obj);
    }

    public void a() {
    }

    public final int b() {
        return 1;
    }

    public Class c() {
        return this.f2611a.getClass();
    }

    public final Object get() {
        return this.f2611a;
    }
}
