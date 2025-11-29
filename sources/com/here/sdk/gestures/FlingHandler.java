package com.here.sdk.gestures;

import com.here.NativeBase;

public final class FlingHandler extends NativeBase {
    public FlingHandler(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                FlingHandler.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onFling(float f, float f2);
}
