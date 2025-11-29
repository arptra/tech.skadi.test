package com.here.posclient;

public enum GnssStatus {
    Unknown(0),
    Disabled(1),
    Acquiring(2),
    Active(3);
    
    private final int mCode;

    private GnssStatus(int i) {
        this.mCode = i;
    }

    public int toInt() {
        return this.mCode;
    }
}
