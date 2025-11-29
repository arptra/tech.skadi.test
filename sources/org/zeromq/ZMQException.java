package org.zeromq;

import zmq.ZError;

public class ZMQException extends UncheckedZMQException {
    private static final long serialVersionUID = -978820750094924644L;
    private final int code;

    public ZMQException(int i) {
        super("Errno " + i);
        this.code = i;
    }

    public int getErrorCode() {
        return this.code;
    }

    public String toString() {
        return super.toString() + " : " + ZError.b(this.code);
    }

    public ZMQException(String str, int i) {
        super(str);
        this.code = i;
    }

    public ZMQException(String str, int i, Throwable th) {
        super(str, th);
        this.code = i;
    }
}
