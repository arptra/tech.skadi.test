package com.here.sdk.core.engine;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class OptionalModulesInitializerImpl extends NativeBase implements OptionalModulesInitializer {
    public OptionalModulesInitializerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                OptionalModulesInitializerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native boolean initOptionalModules(@NonNull SDKNativeEngine sDKNativeEngine);
}
