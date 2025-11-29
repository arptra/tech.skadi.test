package com.here.sdk.core;

import androidx.annotation.Nullable;

@FunctionalInterface
public interface AuthenticationCallback {
    void onTokenReceived(@Nullable AuthenticationError authenticationError, @Nullable AuthenticationData authenticationData);
}
