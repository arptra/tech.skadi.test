package com.here.posclient.analytics;

public enum Tracker {
    Positioning(1),
    RadioMap(2),
    ActiveStorage(4);
    
    public final long mValue;

    private Tracker(int i) {
        this.mValue = (long) i;
    }
}
