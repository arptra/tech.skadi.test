package com.here.sdk.search;

public enum HighlightType {
    TITLE(0),
    ADDRESS_LABEL(1);
    
    public final int value;

    private HighlightType(int i) {
        this.value = i;
    }
}
