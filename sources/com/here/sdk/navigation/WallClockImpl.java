package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import java.util.Date;

class WallClockImpl extends NativeBase implements WallClock {
    public WallClockImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                WallClockImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public static native WallClock getDefault();

    @NonNull
    public native Date now();
}
