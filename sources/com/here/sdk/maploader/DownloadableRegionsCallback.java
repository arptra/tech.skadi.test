package com.here.sdk.maploader;

import androidx.annotation.Nullable;
import java.util.List;

@FunctionalInterface
public interface DownloadableRegionsCallback {
    void onCompleted(@Nullable MapLoaderError mapLoaderError, @Nullable List<Region> list);
}
