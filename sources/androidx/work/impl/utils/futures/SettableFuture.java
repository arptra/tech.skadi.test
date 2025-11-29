package androidx.work.impl.utils.futures;

import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.ListenableFuture;

@RestrictTo
public final class SettableFuture<V> extends AbstractFuture<V> {
    public static SettableFuture s() {
        return new SettableFuture();
    }

    public boolean o(Object obj) {
        return super.o(obj);
    }

    public boolean p(Throwable th) {
        return super.p(th);
    }

    public boolean q(ListenableFuture listenableFuture) {
        return super.q(listenableFuture);
    }
}
