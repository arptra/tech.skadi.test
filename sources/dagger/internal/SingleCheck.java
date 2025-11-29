package dagger.internal;

public final class SingleCheck<T> implements Provider<T> {
    public static final Object c = new Object();

    /* renamed from: a  reason: collision with root package name */
    public volatile Provider f8785a;
    public volatile Object b = c;

    public SingleCheck(Provider provider) {
        this.f8785a = provider;
    }

    public static Provider a(Provider provider) {
        return ((provider instanceof SingleCheck) || (provider instanceof DoubleCheck)) ? provider : new SingleCheck((Provider) Preconditions.b(provider));
    }

    public Object get() {
        Object obj = this.b;
        if (obj != c) {
            return obj;
        }
        Provider provider = this.f8785a;
        if (provider == null) {
            return this.b;
        }
        Object obj2 = provider.get();
        this.b = obj2;
        this.f8785a = null;
        return obj2;
    }
}
