package org.apache.tika.pipes;

public class FailedToStartClientException extends RuntimeException {
    public FailedToStartClientException(Throwable th) {
        super(th);
    }
}
