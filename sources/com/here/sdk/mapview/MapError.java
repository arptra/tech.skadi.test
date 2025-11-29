package com.here.sdk.mapview;

public enum MapError {
    OPERATION_IN_PROGRESS(1),
    INVALID_SCENE(4),
    INVALID_STATE(6),
    INVALID_RENDER_TARGET(8);
    
    public final int value;

    private MapError(int i) {
        this.value = i;
    }
}
