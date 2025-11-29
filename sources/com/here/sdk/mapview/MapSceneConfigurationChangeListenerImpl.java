package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class MapSceneConfigurationChangeListenerImpl extends NativeBase implements MapSceneConfigurationChangeListener {
    public MapSceneConfigurationChangeListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapSceneConfigurationChangeListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onMapSceneConfigurationChanged(@NonNull String str);

    public native void onMapSceneConfigurationRequested(@NonNull String str);
}
