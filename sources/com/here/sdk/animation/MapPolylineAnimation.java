package com.here.sdk.animation;

import androidx.annotation.NonNull;
import com.here.NativeBase;

public final class MapPolylineAnimation extends NativeBase {

    public enum InstantiationErrorCode {
        INCOMPATIBLE_TRACK(0);
        
        public final int value;

        private InstantiationErrorCode(int i) {
            this.value = i;
        }
    }

    public static final class InstantiationException extends Exception {
        public final InstantiationErrorCode error;

        public InstantiationException(InstantiationErrorCode instantiationErrorCode) {
            super(instantiationErrorCode.toString());
            this.error = instantiationErrorCode;
        }
    }

    public MapPolylineAnimation(@NonNull MapItemKeyFrameTrack mapItemKeyFrameTrack) throws InstantiationException {
        this(make(mapItemKeyFrameTrack), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull MapItemKeyFrameTrack mapItemKeyFrameTrack) throws InstantiationException;

    public MapPolylineAnimation(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapPolylineAnimation.disposeNativeHandle(j);
            }
        });
    }
}
