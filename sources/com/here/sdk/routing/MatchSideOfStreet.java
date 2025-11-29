package com.here.sdk.routing;

public enum MatchSideOfStreet {
    ALWAYS(0),
    ONLY_IF_DIVIDED(1);
    
    public final int value;

    private MatchSideOfStreet(int i) {
        this.value = i;
    }
}
