package com.here.sdk.mapview.datasource;

import androidx.annotation.Nullable;
import java.util.Map;

public final class RasterDataSourceConfigurationUpdate {
    @Nullable
    public Long cacheDiskSize;
    @Nullable
    public Boolean ignoreExpiredData;
    @Nullable
    public Map<String, String> providerHeaders;

    public RasterDataSourceConfigurationUpdate(@Nullable Map<String, String> map, @Nullable Boolean bool, @Nullable Long l) {
        this.providerHeaders = map;
        this.ignoreExpiredData = bool;
        this.cacheDiskSize = l;
    }
}
