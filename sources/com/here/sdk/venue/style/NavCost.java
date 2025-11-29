package com.here.sdk.venue.style;

import com.here.NativeBase;

final class NavCost extends NativeBase {
    public NavCost(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                NavCost.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native float getMultiplier();

    public native float getOffset();

    public native float getZLevelMultiplier();
}
