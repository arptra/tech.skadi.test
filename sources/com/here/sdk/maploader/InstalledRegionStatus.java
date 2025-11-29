package com.here.sdk.maploader;

public enum InstalledRegionStatus {
    INSTALLED(1),
    PENDING(2);
    
    public final int value;

    private InstalledRegionStatus(int i) {
        this.value = i;
    }
}
