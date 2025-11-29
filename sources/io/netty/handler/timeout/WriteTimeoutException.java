package io.netty.handler.timeout;

import io.netty.util.internal.PlatformDependent;

public final class WriteTimeoutException extends TimeoutException {
    public static final WriteTimeoutException INSTANCE = (PlatformDependent.javaVersion() >= 7 ? new WriteTimeoutException(true) : new WriteTimeoutException());
    private static final long serialVersionUID = -144786655770296065L;

    public WriteTimeoutException() {
    }

    public WriteTimeoutException(String str) {
        super(str, false);
    }

    private WriteTimeoutException(boolean z) {
        super((String) null, z);
    }
}
