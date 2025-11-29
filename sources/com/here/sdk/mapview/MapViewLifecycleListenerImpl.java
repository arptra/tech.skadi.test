package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class MapViewLifecycleListenerImpl extends NativeBase implements MapViewLifecycleListener {
    public MapViewLifecycleListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapViewLifecycleListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onAttach(@NonNull MapViewBase mapViewBase);

    public native void onDestroy();

    public native void onDetach(@NonNull MapViewBase mapViewBase);

    public native void onPause();

    public native void onResume();
}
