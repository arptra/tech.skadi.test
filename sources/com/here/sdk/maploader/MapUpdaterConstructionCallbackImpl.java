package com.here.sdk.maploader;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class MapUpdaterConstructionCallbackImpl extends NativeBase implements MapUpdaterConstructionCallback {
    public MapUpdaterConstructionCallbackImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapUpdaterConstructionCallbackImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onMapUpdaterConstructe(@NonNull MapUpdater mapUpdater);
}
