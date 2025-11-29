package com.here.sdk.maploader;

public enum PersistentMapRepairError {
    PARTIALLY_RESTORED(0),
    INVALID_PATH(1),
    BROKEN_DB(2),
    NO_OFFLINE_VERSION(3),
    NO_JOURNAL(4),
    BROKEN_UPDATE(5),
    OPERATION_AFTER_DISPOSE(6),
    UNKNOWN(7);
    
    public final int value;

    private PersistentMapRepairError(int i) {
        this.value = i;
    }
}
