package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import java.util.List;

class TruckRestrictionsWarningListenerImpl extends NativeBase implements TruckRestrictionsWarningListener {
    public TruckRestrictionsWarningListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                TruckRestrictionsWarningListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onTruckRestrictionsWarningUpdated(@NonNull List<TruckRestrictionWarning> list);
}
