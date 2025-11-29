package com.here.sdk.prefetcher;

import androidx.annotation.Nullable;
import com.here.sdk.maploader.MapLoaderError;

public interface PrefetchStatusListener {
    void onComplete(@Nullable MapLoaderError mapLoaderError);

    void onProgress(int i);
}
