package com.here.sdk.prefetcher;

import androidx.annotation.Nullable;
import com.here.sdk.maploader.MapLoaderError;

public interface MapDataSizeListener {
    void onSizeEstimated(@Nullable MapLoaderError mapLoaderError, @Nullable MapDataSize mapDataSize);
}
