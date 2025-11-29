package io.netty.handler.codec.http;

import io.netty.handler.codec.TooLongFrameException;

public final class TooLongHttpContentException extends TooLongFrameException {
    private static final long serialVersionUID = 3238341182129476117L;

    public TooLongHttpContentException() {
    }

    public TooLongHttpContentException(String str, Throwable th) {
        super(str, th);
    }

    public TooLongHttpContentException(String str) {
        super(str);
    }

    public TooLongHttpContentException(Throwable th) {
        super(th);
    }
}
