package com.here.sdk.routing;

public enum ChargingSupplyType {
    AC_SINGLE(0),
    AC_THREE(1),
    DC(2);
    
    public final int value;

    private ChargingSupplyType(int i) {
        this.value = i;
    }
}
