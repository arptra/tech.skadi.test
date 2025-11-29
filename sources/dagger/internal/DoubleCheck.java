package dagger.internal;

import dagger.Lazy;

public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {
    public static final Object c = new Object();

    /* renamed from: a  reason: collision with root package name */
    public volatile Provider f8776a;
    public volatile Object b = c;

    public DoubleCheck(Provider provider) {
        this.f8776a = provider;
    }

    public static Lazy a(Provider provider) {
        return provider instanceof Lazy ? (Lazy) provider : new DoubleCheck((Provider) Preconditions.b(provider));
    }

    public static Provider b(Provider provider) {
        Preconditions.b(provider);
        return provider instanceof DoubleCheck ? provider : new DoubleCheck(provider);
    }

    private static Object c(Object obj, Object obj2) {
        if (obj == c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    public Object get() {
        Object obj = this.b;
        Object obj2 = c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.b;
                    if (obj == obj2) {
                        obj = this.f8776a.get();
                        this.b = c(this.b, obj);
                        this.f8776a = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return obj;
    }
}
