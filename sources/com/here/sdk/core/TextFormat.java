package com.here.sdk.core;

@Deprecated
public enum TextFormat {
    HTML(0),
    PLAIN(1);
    
    public final int value;

    private TextFormat(int i) {
        this.value = i;
    }
}
