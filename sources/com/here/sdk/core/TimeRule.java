package com.here.sdk.core;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import java.util.Date;

public final class TimeRule extends NativeBase {
    static final SDKLibraryLoader LIBRARY_LOADER = new SDKLibraryLoader("SDK");

    public TimeRule(@NonNull String str, int i, @NonNull String str2) {
        this(make(str, i, str2), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull String str, int i, @NonNull String str2);

    public native boolean appliesTo(@NonNull Date date);

    @NonNull
    public native String asString();

    public TimeRule(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                TimeRule.disposeNativeHandle(j);
            }
        });
    }
}
