package com.here.sdk.core;

public final class AuthenticationException extends Exception {
    public final AuthenticationError error;

    public AuthenticationException(AuthenticationError authenticationError) {
        super(authenticationError.toString());
        this.error = authenticationError;
    }
}
