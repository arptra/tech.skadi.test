package com.here.sdk.mapview.datasource;

import androidx.annotation.NonNull;

@FunctionalInterface
public interface TileUrlProviderCallback {
    @NonNull
    String onTileUrlRequest(int i, int i2, int i3);
}
