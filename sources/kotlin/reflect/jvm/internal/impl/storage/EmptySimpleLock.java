package kotlin.reflect.jvm.internal.impl.storage;

import org.jetbrains.annotations.NotNull;

public final class EmptySimpleLock implements SimpleLock {
    @NotNull
    public static final EmptySimpleLock INSTANCE = new EmptySimpleLock();

    private EmptySimpleLock() {
    }

    public void lock() {
    }

    public void unlock() {
    }
}
