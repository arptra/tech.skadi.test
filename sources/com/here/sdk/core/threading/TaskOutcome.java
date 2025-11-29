package com.here.sdk.core.threading;

public enum TaskOutcome {
    COMPLETED(0),
    CANCELLED(1);
    
    public final int value;

    private TaskOutcome(int i) {
        this.value = i;
    }
}
