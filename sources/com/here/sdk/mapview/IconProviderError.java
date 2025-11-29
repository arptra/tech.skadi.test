package com.here.sdk.mapview;

public enum IconProviderError {
    INVALID_STATE(0),
    ICON_NOT_FOUND(1),
    ICON_HANDLING_FAILED(2);
    
    public final int value;

    private IconProviderError(int i) {
        this.value = i;
    }
}
