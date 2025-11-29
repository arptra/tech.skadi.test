package com.here.sdk.gestures;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import java.util.Map;

public final class InternalGestureDetector extends NativeBase {
    public InternalGestureDetector(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                InternalGestureDetector.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native Gestures getGestures();

    public native void processTouchEvent(@NonNull Map<Long, TouchPoint> map, long j, @NonNull TouchPhase touchPhase);

    public native void setPixelScale(float f);
}
