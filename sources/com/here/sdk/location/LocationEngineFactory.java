package com.here.sdk.location;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.engine.SDKNativeEngine;

final class LocationEngineFactory extends NativeBase {

    @FunctionalInterface
    public interface Factory {
        @Nullable
        LocationEngineBase apply(@NonNull SDKNativeEngine sDKNativeEngine);
    }

    public static class FactoryImpl extends NativeBase implements Factory {
        public FactoryImpl(long j, Object obj) {
            super(j, new NativeBase.Disposer() {
                public void disposeNative(long j) {
                    FactoryImpl.disposeNativeHandle(j);
                }
            });
        }

        /* access modifiers changed from: private */
        public static native void disposeNativeHandle(long j);

        @Nullable
        public native LocationEngineBase apply(@NonNull SDKNativeEngine sDKNativeEngine);
    }

    public LocationEngineFactory(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                LocationEngineFactory.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public static native void setup(@NonNull Factory factory);
}
