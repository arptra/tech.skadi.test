package com.ucar.protocol;

public class ProtocolException extends RuntimeException {
    public ProtocolException(String str) {
        super(str);
    }

    public ProtocolException(String str, Throwable th) {
        super(str, th);
    }
}
