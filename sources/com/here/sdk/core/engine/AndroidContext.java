package com.here.sdk.core.engine;

import androidx.annotation.NonNull;

final class AndroidContext {
    @NonNull
    public AndroidContextHolder contextHolder;

    public AndroidContext(@NonNull AndroidContextHolder androidContextHolder) {
        this.contextHolder = androidContextHolder;
    }
}
