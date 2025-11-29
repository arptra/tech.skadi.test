package com.here.sdk.maploader;

import androidx.annotation.NonNull;

@FunctionalInterface
public interface MapUpdaterConstructionCallback {
    void onMapUpdaterConstructe(@NonNull MapUpdater mapUpdater);
}
