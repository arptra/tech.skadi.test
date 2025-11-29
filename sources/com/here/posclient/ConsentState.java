package com.here.posclient;

public enum ConsentState {
    Unknown(0),
    Denied(1),
    Granted(2);
    
    public final int stateCode;

    private ConsentState(int i) {
        this.stateCode = i;
    }

    public static ConsentState fromInt(int i) {
        return i != 1 ? i != 2 ? Unknown : Granted : Denied;
    }
}
