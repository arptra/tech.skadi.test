package com.here.sdk.gestures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;

public final class Gestures extends NativeBase {
    public Gestures(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                Gestures.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void disableDefaultAction(@NonNull GestureType gestureType);

    public native void enableDefaultAction(@NonNull GestureType gestureType);

    @Nullable
    public native DoubleTapListener getDoubleTapListener();

    @NonNull
    public native FlingHandler getFlingHandler();

    @Nullable
    public native LongPressListener getLongPressListener();

    @Nullable
    public native PanListener getPanListener();

    @Nullable
    public native PinchRotateListener getPinchRotateListener();

    @NonNull
    public native ScaleHandler getScaleHandler();

    @NonNull
    public native ScrollHandler getScrollHandler();

    @Nullable
    public native TapListener getTapListener();

    @Nullable
    public native TwoFingerPanListener getTwoFingerPanListener();

    @Nullable
    public native TwoFingerTapListener getTwoFingerTapListener();

    public native void setDoubleTapListener(@Nullable DoubleTapListener doubleTapListener);

    public native void setLongPressListener(@Nullable LongPressListener longPressListener);

    public native void setPanListener(@Nullable PanListener panListener);

    public native void setPinchRotateListener(@Nullable PinchRotateListener pinchRotateListener);

    public native void setTapListener(@Nullable TapListener tapListener);

    public native void setTwoFingerPanListener(@Nullable TwoFingerPanListener twoFingerPanListener);

    public native void setTwoFingerTapListener(@Nullable TwoFingerTapListener twoFingerTapListener);
}
