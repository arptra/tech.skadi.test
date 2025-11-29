package com.here.sdk.trafficbroadcast;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import java.util.List;

class TMCServiceInterfaceImpl extends NativeBase implements TMCServiceInterface {
    public TMCServiceInterfaceImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                TMCServiceInterfaceImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native List<RDSEncryptionKey> getRDSEncryptionKeys(@NonNull RDSEncryptionKeysRequest rDSEncryptionKeysRequest);

    @NonNull
    public native List<Short> getTMCPreferredSids(@NonNull TMCPreferredSidsRequest tMCPreferredSidsRequest);

    public native void requestTMCService(@NonNull TMCServiceRequest tMCServiceRequest);
}
