package com.upuphone.hub;

public class HubException extends RuntimeException {
    public HubException(String str) {
        super(str);
    }

    public HubException(Throwable th) {
        super(th);
    }
}
