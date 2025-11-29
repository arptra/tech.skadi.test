package io.netty.handler.codec.http;

import io.netty.handler.codec.TooLongFrameException;

public final class TooLongHttpLineException extends TooLongFrameException {
    private static final long serialVersionUID = 1614751125592211890L;

    public TooLongHttpLineException() {
    }

    public TooLongHttpLineException(String str, Throwable th) {
        super(str, th);
    }

    public TooLongHttpLineException(String str) {
        super(str);
    }

    public TooLongHttpLineException(Throwable th) {
        super(th);
    }
}
