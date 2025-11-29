package org.apache.tika.exception;

public class CorruptedFileException extends TikaException {
    public CorruptedFileException(String str) {
        super(str);
    }

    public CorruptedFileException(String str, Throwable th) {
        super(str, th);
    }
}
