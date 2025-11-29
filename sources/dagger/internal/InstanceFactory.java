package dagger.internal;

import dagger.Lazy;

public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {
    public static final InstanceFactory b = new InstanceFactory((Object) null);

    /* renamed from: a  reason: collision with root package name */
    public final Object f8777a;

    public InstanceFactory(Object obj) {
        this.f8777a = obj;
    }

    public static Factory a(Object obj) {
        return new InstanceFactory(Preconditions.c(obj, "instance cannot be null"));
    }

    public Object get() {
        return this.f8777a;
    }
}
