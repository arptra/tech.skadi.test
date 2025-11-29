package com.here.sdk.mapview;

import com.here.NativeBase;

public final class Style extends NativeBase {
    public Style(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                Style.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);
}
