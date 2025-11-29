package com.here.sdk.maploader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface MapUpdateProgressListener {
    void onComplete(@Nullable MapLoaderError mapLoaderError);

    void onPause(@Nullable MapLoaderError mapLoaderError);

    void onProgress(@NonNull RegionId regionId, int i);

    void onResume();
}
