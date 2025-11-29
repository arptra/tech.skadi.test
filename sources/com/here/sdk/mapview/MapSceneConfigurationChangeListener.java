package com.here.sdk.mapview;

import androidx.annotation.NonNull;

interface MapSceneConfigurationChangeListener {
    void onMapSceneConfigurationChanged(@NonNull String str);

    void onMapSceneConfigurationRequested(@NonNull String str);
}
