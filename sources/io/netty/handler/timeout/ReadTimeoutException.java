package io.netty.handler.timeout;

import io.netty.util.internal.PlatformDependent;

public final class ReadTimeoutException extends TimeoutException {
    public static final ReadTimeoutException INSTANCE = (PlatformDependent.javaVersion() >= 7 ? new ReadTimeoutException(true) : new ReadTimeoutException());
    private static final long serialVersionUID = 169287984113283421L;

    public ReadTimeoutException() {
    }

    public ReadTimeoutException(String str) {
        super(str, false);
    }

    private ReadTimeoutException(boolean z) {
        super((String) null, z);
    }
}
