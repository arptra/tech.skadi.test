package com.here.sdk.mapdata;

public enum LocalRoadCharacteristic {
    FRONTAGE(0),
    PARKING_LOT_ROAD(1),
    POI_ACCESS(2);
    
    public final int value;

    private LocalRoadCharacteristic(int i) {
        this.value = i;
    }
}
