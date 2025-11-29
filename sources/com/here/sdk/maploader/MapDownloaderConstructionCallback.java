package com.here.sdk.maploader;

import androidx.annotation.NonNull;

@FunctionalInterface
public interface MapDownloaderConstructionCallback {
    void onMapDownloaderConstructedCompleted(@NonNull MapDownloader mapDownloader);
}
