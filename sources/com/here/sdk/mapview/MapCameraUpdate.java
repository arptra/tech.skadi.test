package com.here.sdk.mapview;

import com.here.NativeBase;

public final class MapCameraUpdate extends NativeBase {

    public enum InstantiationErrorCode {
        EMPTY_COMPOSITE_CAMERA_UPDATE_LIST(1);
        
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

    public MapCameraUpdate(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapCameraUpdate.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);
}
