package org.apache.tika.exception;

public class EncryptedDocumentException extends TikaException {
    public EncryptedDocumentException() {
        super("Unable to process: document is encrypted");
    }

    public EncryptedDocumentException(Throwable th) {
        super("Unable to process: document is encrypted", th);
    }

    public EncryptedDocumentException(String str) {
        super(str);
    }

    public EncryptedDocumentException(String str, Throwable th) {
        super(str, th);
    }
}
