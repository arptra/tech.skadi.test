package com.here.sdk.venue.style;

import androidx.annotation.NonNull;
import com.here.NativeBase;

final class NavName extends NativeBase {
    public NavName(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                NavName.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native String getName();

    public native boolean isTranslatable();
}
