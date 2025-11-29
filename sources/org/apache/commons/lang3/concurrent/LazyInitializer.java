package org.apache.commons.lang3.concurrent;

public abstract class LazyInitializer<T> implements ConcurrentInitializer<T> {
    private static final Object NO_INIT = new Object();
    private volatile T object = NO_INIT;

    public T get() throws ConcurrentException {
        T t = this.object;
        T t2 = NO_INIT;
        if (t == t2) {
            synchronized (this) {
                try {
                    t = this.object;
                    if (t == t2) {
                        t = initialize();
                        this.object = t;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return t;
    }

    public abstract T initialize() throws ConcurrentException;
}
