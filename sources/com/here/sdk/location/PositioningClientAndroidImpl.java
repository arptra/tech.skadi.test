package com.here.sdk.location;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.location.PositioningClientAndroid;

class PositioningClientAndroidImpl extends NativeBase implements PositioningClientAndroid {
    public PositioningClientAndroidImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                PositioningClientAndroidImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public static native PositioningClientAndroid fromSdkNativeEngine(@NonNull SDKNativeEngine sDKNativeEngine, @NonNull PositioningClientAndroid.PositionClientFactory positionClientFactory);

    @NonNull
    public native FeatureChecker getFeatureChecker();

    @Nullable
    public native LocationAccuracy getLocationAccuracy();

    @Nullable
    public native LocationOptions getLocationOptions();

    public native boolean isReady();

    public native void setCallListenerFromMainThreadEnabled(boolean z);

    public native void setOfflineMode(boolean z);
}
