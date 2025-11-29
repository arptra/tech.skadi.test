package com.here.sdk.animation;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.Point2D;
import java.util.List;

public final class Easing extends NativeBase {

    public enum InstantiationErrorCode {
        SAMPLED_DATA_POINT_COUNT_TOO_SMALL(1),
        SAMPLED_DATA_POINTS_FIRST_X_VALUE_INVALID(2),
        SAMPLED_DATA_POINTS_LAST_X_VALUE_INVALID(3),
        SAMPLED_DATA_X_VALUE_OUT_OF_RANGE(4),
        SAMPLED_DATA_X_VALUES_NON_MONOTONIC(5);
        
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

    public Easing(@NonNull EasingFunction easingFunction) {
        this(make(easingFunction), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull EasingFunction easingFunction);

    private static native long make(@NonNull List<Point2D> list) throws InstantiationException;

    public Easing(@NonNull List<Point2D> list) throws InstantiationException {
        this(make(list), (Object) null);
        cacheThisInstance();
    }

    public Easing(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                Easing.disposeNativeHandle(j);
            }
        });
    }
}
