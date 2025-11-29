package com.here.sdk.core.errors;

public final class InstantiationErrorException extends Exception {
    public final InstantiationErrorCode error;

    public InstantiationErrorException(InstantiationErrorCode instantiationErrorCode) {
        super(instantiationErrorCode.toString());
        this.error = instantiationErrorCode;
    }
}
