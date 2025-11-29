package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import java.util.List;

class SchoolZoneWarningListenerImpl extends NativeBase implements SchoolZoneWarningListener {
    public SchoolZoneWarningListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                SchoolZoneWarningListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onSchoolZoneWarningUpdated(@NonNull List<SchoolZoneWarning> list);
}
