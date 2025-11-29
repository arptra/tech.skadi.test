package org.apache.tika.exception;

public class TikaConfigException extends TikaException {
    public TikaConfigException(String str) {
        super(str);
    }

    public TikaConfigException(String str, Throwable th) {
        super(str, th);
    }
}
