package org.apache.commons.lang3.concurrent;

import com.honey.account.x.c;
import java.util.concurrent.atomic.AtomicReference;

public abstract class AtomicInitializer<T> implements ConcurrentInitializer<T> {
    private final AtomicReference<T> reference = new AtomicReference<>();

    public T get() throws ConcurrentException {
        T t = this.reference.get();
        if (t != null) {
            return t;
        }
        T initialize = initialize();
        return !c.a(this.reference, (Object) null, initialize) ? this.reference.get() : initialize;
    }

    public abstract T initialize() throws ConcurrentException;
}
