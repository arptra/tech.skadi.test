package com.here.sdk.traffic;

public enum JunctionsTraversability {
    ALL_OPEN(0),
    ALL_CLOSED(1),
    INTERMEDIATE_CLOSED_EDGE_OPEN(2),
    START_OPEN_OTHERS_CLOSED(3),
    END_OPEN_OTHERS_CLOSED(4);
    
    public final int value;

    private JunctionsTraversability(int i) {
        this.value = i;
    }
}
