package io.netty.util.internal;

public final class OutOfDirectMemoryError extends OutOfMemoryError {
    private static final long serialVersionUID = 4228264016184011555L;

    public OutOfDirectMemoryError(String str) {
        super(str);
    }
}
