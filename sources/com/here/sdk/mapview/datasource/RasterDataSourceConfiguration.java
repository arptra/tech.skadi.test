package com.here.sdk.mapview.datasource;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;

public final class RasterDataSourceConfiguration {
    @NonNull
    public Cache cache;
    public boolean ignoreExpiredData;
    @NonNull
    public String name;
    @NonNull
    public Provider provider;

    public RasterDataSourceConfiguration(@NonNull String str, @NonNull Provider provider2, @NonNull Cache cache2) {
        this.name = str;
        this.provider = provider2;
        this.cache = cache2;
        this.ignoreExpiredData = false;
    }

    public static final class Cache {
        public long diskSize;
        @NonNull
        public String path;

        public Cache(@NonNull String str) {
            this.path = str;
            this.diskSize = 33554432;
        }

        public Cache(@NonNull String str, long j) {
            this.path = str;
            this.diskSize = j;
        }
    }

    public static final class Provider {
        public boolean hasAlphaChannel;
        @Nullable
        public Map<String, String> headers;
        @NonNull
        public List<Integer> storageLevels;
        @NonNull
        public TilingScheme tilingScheme;
        @NonNull
        public TileUrlProviderCallback urlProvider;

        public Provider(@NonNull TileUrlProviderCallback tileUrlProviderCallback, @NonNull TilingScheme tilingScheme2, @NonNull List<Integer> list, boolean z, @Nullable Map<String, String> map) {
            this.urlProvider = tileUrlProviderCallback;
            this.tilingScheme = tilingScheme2;
            this.storageLevels = list;
            this.hasAlphaChannel = z;
            this.headers = map;
        }

        public Provider(@NonNull TileUrlProviderCallback tileUrlProviderCallback, @NonNull TilingScheme tilingScheme2, @NonNull List<Integer> list) {
            this.urlProvider = tileUrlProviderCallback;
            this.tilingScheme = tilingScheme2;
            this.storageLevels = list;
            this.hasAlphaChannel = false;
            this.headers = null;
        }
    }

    public RasterDataSourceConfiguration(@NonNull String str, @NonNull Provider provider2, @NonNull Cache cache2, boolean z) {
        this.name = str;
        this.provider = provider2;
        this.cache = cache2;
        this.ignoreExpiredData = z;
    }
}
