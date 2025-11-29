package com.here.sdk.gestures;

import com.here.NativeBase;

public final class ScrollHandler extends NativeBase {
    public ScrollHandler(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                ScrollHandler.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onScroll(float f, float f2);
}
