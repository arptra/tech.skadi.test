package com.here.sdk.gestures;

import com.here.NativeBase;

public final class ScaleHandler extends NativeBase {
    public ScaleHandler(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                ScaleHandler.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onScale(float f, float f2, float f3);
}
