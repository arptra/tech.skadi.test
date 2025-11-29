package dagger.internal;

public final class DelegateFactory<T> implements Factory<T> {

    /* renamed from: a  reason: collision with root package name */
    public Provider f8775a;

    public Object get() {
        Provider provider = this.f8775a;
        if (provider != null) {
            return provider.get();
        }
        throw new IllegalStateException();
    }
}
