package com.here.sdk.maploader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public interface DownloadRegionsStatusListener {
    void onDownloadRegionsComplete(@Nullable MapLoaderError mapLoaderError, @Nullable List<RegionId> list);

    void onPause(@Nullable MapLoaderError mapLoaderError);

    void onProgress(@NonNull RegionId regionId, int i);

    void onResume();
}
