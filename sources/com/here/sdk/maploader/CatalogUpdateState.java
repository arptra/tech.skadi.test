package com.here.sdk.maploader;

public enum CatalogUpdateState {
    UPDATE_AVAILABLE(0),
    PENDING_UPDATE(1),
    UPDATE_BLOCKED_AS_ANOTHER_PENDING(2),
    UNKNOWN_STATE(3);
    
    public final int value;

    private CatalogUpdateState(int i) {
        this.value = i;
    }
}
