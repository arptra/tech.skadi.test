package com.here.sdk.location;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import java.util.List;

class LocationStatusListenerImpl extends NativeBase implements LocationStatusListener {
    public LocationStatusListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                LocationStatusListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onFeaturesNotAvailable(@NonNull List<LocationFeature> list);

    public native void onStatusChanged(@NonNull LocationEngineStatus locationEngineStatus);
}
