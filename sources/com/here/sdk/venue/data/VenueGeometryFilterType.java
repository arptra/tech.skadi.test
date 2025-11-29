package com.here.sdk.venue.data;

public enum VenueGeometryFilterType {
    NAME(0),
    ADDRESS(1),
    NAME_OR_ADDRESS(2),
    ICON_NAME(3);
    
    public final int value;

    private VenueGeometryFilterType(int i) {
        this.value = i;
    }
}
