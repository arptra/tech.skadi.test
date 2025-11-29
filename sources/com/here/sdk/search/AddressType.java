package com.here.sdk.search;

public enum AddressType {
    BLOCK(0),
    SUBBLOCK(1),
    HOUSE_NUMBER(2);
    
    public final int value;

    private AddressType(int i) {
        this.value = i;
    }
}
