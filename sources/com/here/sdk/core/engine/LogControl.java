package com.here.sdk.core.engine;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.SDKLibraryLoader;

public final class LogControl extends NativeBase {
    static final SDKLibraryLoader LIBRARY_LOADER = new SDKLibraryLoader("SDK");

    public static final class InvalidPathException extends Exception {
        public final String error;

        public InvalidPathException(String str) {
            super(str.toString());
            this.error = str;
        }
    }

    public LogControl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                LogControl.disposeNativeHandle(j);
            }
        });
    }

    public static native void disableLoggingToConsole();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public static native void enableLoggingToConsole(@NonNull LogLevel logLevel);

    public static native void removeAppender();

    public static native void setAppender(@NonNull LogLevel logLevel, @NonNull LogAppender logAppender);

    public static native void setAppender(@NonNull LogLevel logLevel, @NonNull String str) throws InvalidPathException;
}
