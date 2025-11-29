package com.here.sdk.gestures;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.Angle;
import com.here.sdk.core.Point2D;

class PinchRotateListenerImpl extends NativeBase implements PinchRotateListener {
    public PinchRotateListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                PinchRotateListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onPinchRotate(@NonNull GestureState gestureState, @NonNull Point2D point2D, @NonNull Point2D point2D2, double d, @NonNull Angle angle);
}
