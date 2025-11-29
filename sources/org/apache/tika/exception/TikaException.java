package org.apache.tika.exception;

public class TikaException extends Exception {
    public TikaException(String str) {
        super(str);
    }

    public TikaException(String str, Throwable th) {
        super(str, th);
    }
}
