package com.here.sdk.navigation;

public enum TollCollectionMethod {
    FIXED_FEE(0),
    OBTAIN_TICKET(1),
    PAY_PER_TICKET(2),
    ELECTRONIC(3);
    
    public final int value;

    private TollCollectionMethod(int i) {
        this.value = i;
    }
}
