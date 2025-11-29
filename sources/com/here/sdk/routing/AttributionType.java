package com.here.sdk.routing;

public enum AttributionType {
    DISCLAIMER(0),
    TARIFF(1);
    
    public final int value;

    private AttributionType(int i) {
        this.value = i;
    }
}
