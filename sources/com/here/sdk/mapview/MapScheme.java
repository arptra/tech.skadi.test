package com.here.sdk.mapview;

public enum MapScheme {
    NORMAL_DAY(0),
    NORMAL_NIGHT(1),
    SATELLITE(2),
    HYBRID_DAY(3),
    HYBRID_NIGHT(4),
    LITE_DAY(5),
    LITE_NIGHT(6),
    LITE_HYBRID_DAY(7),
    LITE_HYBRID_NIGHT(8),
    LOGISTICS_DAY(9),
    ROAD_NETWORK_DAY(10),
    ROAD_NETWORK_NIGHT(11);
    
    public final int value;

    private MapScheme(int i) {
        this.value = i;
    }
}
