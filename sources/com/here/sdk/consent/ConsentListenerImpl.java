package com.here.sdk.consent;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class ConsentListenerImpl extends NativeBase implements ConsentListener {
    public ConsentListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                ConsentListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onConsentUpdated(@NonNull ConsentFeature consentFeature, @NonNull ConsentState consentState);
}
