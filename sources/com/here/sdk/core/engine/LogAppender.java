package com.here.sdk.core.engine;

import androidx.annotation.NonNull;

public interface LogAppender {
    void log(@NonNull LogLevel logLevel, @NonNull String str);
}
