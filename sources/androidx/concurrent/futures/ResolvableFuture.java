package androidx.concurrent.futures;

import androidx.annotation.RestrictTo;

@RestrictTo
public final class ResolvableFuture<V> extends AbstractResolvableFuture<V> {
    public static ResolvableFuture r() {
        return new ResolvableFuture();
    }

    public boolean o(Object obj) {
        return super.o(obj);
    }

    public boolean p(Throwable th) {
        return super.p(th);
    }
}
