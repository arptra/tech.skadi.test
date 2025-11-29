package com.here.services.internal;

public class ServiceNotFoundException extends Exception {
    private static final long serialVersionUID = -6265575365512798617L;

    public ServiceNotFoundException() {
    }

    public ServiceNotFoundException(String str) {
        super(str);
    }

    public ServiceNotFoundException(Throwable th) {
        super(th);
    }

    public ServiceNotFoundException(String str, Throwable th) {
        super(str, th);
    }
}
