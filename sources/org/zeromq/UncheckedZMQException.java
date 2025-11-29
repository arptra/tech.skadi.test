package org.zeromq;

public abstract class UncheckedZMQException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public UncheckedZMQException() {
    }

    public UncheckedZMQException(String str) {
        super(str);
    }

    public UncheckedZMQException(Throwable th) {
        super(th);
    }

    public UncheckedZMQException(String str, Throwable th) {
        super(str, th);
    }
}
