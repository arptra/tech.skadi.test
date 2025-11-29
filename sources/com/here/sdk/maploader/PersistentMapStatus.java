package com.here.sdk.maploader;

public enum PersistentMapStatus {
    OK(0),
    CORRUPTED(1),
    BROKEN_UPDATE(2),
    MIGRATION_NEEDED(3),
    PENDING_UPDATE(4),
    INVALID_PATH(5),
    INVALID_STATE(6),
    STORAGE_CLOSED(7);
    
    public final int value;

    private PersistentMapStatus(int i) {
        this.value = i;
    }
}
