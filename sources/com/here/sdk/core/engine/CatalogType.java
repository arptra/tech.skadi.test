package com.here.sdk.core.engine;

public enum CatalogType {
    OPTIMIZED_CLIENT_MAP(0),
    OPTIMIZED_CLIENT_MAP_JAPAN(1);
    
    public final int value;

    private CatalogType(int i) {
        this.value = i;
    }
}
