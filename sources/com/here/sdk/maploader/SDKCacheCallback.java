package com.here.sdk.maploader;

import androidx.annotation.Nullable;

@FunctionalInterface
public interface SDKCacheCallback {
    void onCompleted(@Nullable MapLoaderError mapLoaderError);
}
