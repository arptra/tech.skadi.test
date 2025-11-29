package com.here.sdk.consent;

import android.content.Context;
import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.errors.InstantiationErrorException;

public final class ConsentInternal extends NativeBase {
    public static final /* synthetic */ int $r8$clinit = 0;

    public ConsentInternal(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                ConsentInternal.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public static native ConsentInternal fromSdkNativeEngine(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException;

    @NonNull
    public static native ConsentInternal fromSharedSdkNativeEngine() throws InstantiationErrorException;

    public native boolean addListener(@NonNull ConsentFeature consentFeature, @NonNull ConsentListener consentListener);

    @NonNull
    public native ConsentStatus denyUserConsent();

    @NonNull
    public native Context getAndroidContext();

    @NonNull
    public native ConsentState getConsentState();

    @NonNull
    public native ConsentStatus grantUserConsent();

    public native boolean isUserConsentHandled();

    public native void removeListener(@NonNull ConsentFeature consentFeature);

    public native void setConsentState(@NonNull ConsentState consentState);

    public native void start();
}
