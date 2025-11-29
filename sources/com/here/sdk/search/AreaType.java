package com.here.sdk.search;

public enum AreaType {
    COUNTRY(0),
    STATE(1),
    COUNTY(2),
    CITY(3),
    POSTAL_CODE(4),
    DISTRICT(5),
    SUB_DISTRICT(6);
    
    public final int value;

    private AreaType(int i) {
        this.value = i;
    }
}
