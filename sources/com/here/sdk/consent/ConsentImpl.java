package com.here.sdk.consent;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.consent.Consent;

class ConsentImpl extends NativeBase implements Consent {
    public ConsentImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                ConsentImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native ConsentStatus denyUserConsent();

    @NonNull
    public native Consent.UserReply getUserConsentState();

    @NonNull
    public native ConsentStatus grantUserConsent();

    @NonNull
    public native ConsentStatus requestUserConsent();
}
