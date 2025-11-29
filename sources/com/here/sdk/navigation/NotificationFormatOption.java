package com.here.sdk.navigation;

public enum NotificationFormatOption {
    PLAIN(0),
    SSML(1);
    
    public final int value;

    private NotificationFormatOption(int i) {
        this.value = i;
    }
}
