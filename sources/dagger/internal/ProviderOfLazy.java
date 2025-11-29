package dagger.internal;

import dagger.Lazy;

public final class ProviderOfLazy<T> implements Provider<Lazy<T>> {

    /* renamed from: a  reason: collision with root package name */
    public final Provider f8782a;

    /* renamed from: a */
    public Lazy get() {
        return DoubleCheck.a(this.f8782a);
    }
}
