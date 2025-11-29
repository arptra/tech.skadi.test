package org.apache.tika.mime;

import org.apache.tika.exception.TikaException;

public class MimeTypeException extends TikaException {
    public MimeTypeException(String str) {
        super(str);
    }

    public MimeTypeException(String str, Throwable th) {
        super(str, th);
    }
}
