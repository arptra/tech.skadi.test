package org.apache.tika.exception;

public class TikaTimeoutException extends RuntimeException {
    public TikaTimeoutException(String str) {
        super(str);
    }
}
