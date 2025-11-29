package com.here.sdk.mapview.datasource;

public enum TilingScheme {
    HALF_QUAD_TREE_IDENTITY(0),
    HALF_QUAD_TREE_MERCATOR(1),
    HALF_QUAD_TREE_EQUIRECTANGULAR(2),
    QUAD_TREE_IDENTITY(3),
    QUAD_TREE_MERCATOR(4),
    QUAD_TREE_EQUIRECTANGULAR(5);
    
    public final int value;

    private TilingScheme(int i) {
        this.value = i;
    }
}
