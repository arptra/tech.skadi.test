package com.here.sdk.mapview.datasource;

import androidx.annotation.NonNull;

public interface RasterDataSourceListener {
    void onRasterDataSourceError(@NonNull RasterDataSourceError rasterDataSourceError);

    void onRasterDataSourceReady();
}
