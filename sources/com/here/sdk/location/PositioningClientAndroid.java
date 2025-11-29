package com.here.sdk.location;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.engine.SDKNativeEngine;

interface PositioningClientAndroid {

    @FunctionalInterface
    public interface PositionClientFactory {
        @NonNull
        PositioningClientAndroid apply(@NonNull Context context, @NonNull FeatureChecker featureChecker, @NonNull NetworkHolder networkHolder, @NonNull String str);
    }

    public static class PositionClientFactoryImpl extends NativeBase implements PositionClientFactory {
        public PositionClientFactoryImpl(long j, Object obj) {
            super(j, new NativeBase.Disposer() {
                public void disposeNative(long j) {
                    PositionClientFactoryImpl.disposeNativeHandle(j);
                }
            });
        }

        /* access modifiers changed from: private */
        public static native void disposeNativeHandle(long j);

        @NonNull
        public native PositioningClientAndroid apply(@NonNull Context context, @NonNull FeatureChecker featureChecker, @NonNull NetworkHolder networkHolder, @NonNull String str);
    }

    @NonNull
    static PositioningClientAndroid fromSdkNativeEngine(@NonNull SDKNativeEngine sDKNativeEngine, @NonNull PositionClientFactory positionClientFactory) {
        return PositioningClientAndroidImpl.fromSdkNativeEngine(sDKNativeEngine, positionClientFactory);
    }

    @NonNull
    FeatureChecker getFeatureChecker();

    @Nullable
    LocationAccuracy getLocationAccuracy();

    @Nullable
    LocationOptions getLocationOptions();

    boolean isReady();

    void setCallListenerFromMainThreadEnabled(boolean z);

    void setOfflineMode(boolean z);
}
