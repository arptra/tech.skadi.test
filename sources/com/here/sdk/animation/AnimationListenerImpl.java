package com.here.sdk.animation;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class AnimationListenerImpl extends NativeBase implements AnimationListener {
    public AnimationListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                AnimationListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onAnimationStateChanged(@NonNull AnimationState animationState);
}
