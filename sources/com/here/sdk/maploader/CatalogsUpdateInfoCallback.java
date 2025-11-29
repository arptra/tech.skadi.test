package com.here.sdk.maploader;

import androidx.annotation.Nullable;
import java.util.List;

@FunctionalInterface
public interface CatalogsUpdateInfoCallback {
    void apply(@Nullable MapLoaderError mapLoaderError, @Nullable List<CatalogUpdateInfo> list);
}
