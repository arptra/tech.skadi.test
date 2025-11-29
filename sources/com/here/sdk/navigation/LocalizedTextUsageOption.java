package com.here.sdk.navigation;

public enum LocalizedTextUsageOption {
    NEVER(0),
    ALWAYS(1),
    IF_LANGUAGE_IS_COMPATIBLE(2);
    
    public final int value;

    private LocalizedTextUsageOption(int i) {
        this.value = i;
    }
}
