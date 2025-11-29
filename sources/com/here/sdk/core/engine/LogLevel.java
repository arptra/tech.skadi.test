package com.here.sdk.core.engine;

public enum LogLevel {
    LOG_LEVEL_INFO(0),
    LOG_LEVEL_WARNING(1),
    LOG_LEVEL_ERROR(2),
    LOG_LEVEL_FATAL(3),
    LOG_LEVEL_OFF(4);
    
    public final int value;

    private LogLevel(int i) {
        this.value = i;
    }
}
