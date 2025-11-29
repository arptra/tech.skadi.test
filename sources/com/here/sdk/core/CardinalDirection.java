package com.here.sdk.core;

public enum CardinalDirection {
    NORTH(0),
    SOUTH(1),
    EAST(2),
    WEST(3);
    
    public final int value;

    private CardinalDirection(int i) {
        this.value = i;
    }
}
