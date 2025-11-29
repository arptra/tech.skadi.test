package com.here.sdk.core.engine;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class LogAppenderImpl extends NativeBase implements LogAppender {
    public LogAppenderImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                LogAppenderImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void log(@NonNull LogLevel logLevel, @NonNull String str);
}
