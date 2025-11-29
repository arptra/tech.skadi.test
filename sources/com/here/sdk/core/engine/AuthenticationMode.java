package com.here.sdk.core.engine;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.SDKLibraryLoader;

public final class AuthenticationMode extends NativeBase {
    static final SDKLibraryLoader LIBRARY_LOADER = new SDKLibraryLoader("SDK");

    public AuthenticationMode(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                AuthenticationMode.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public static native AuthenticationMode withExternal();

    @NonNull
    public static native AuthenticationMode withKeySecret(@NonNull String str, @NonNull String str2);

    @NonNull
    public static native AuthenticationMode withToken(@NonNull String str);
}
