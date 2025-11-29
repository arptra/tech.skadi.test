package com.here.sdk.location;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import java.util.List;

class LocationIssueListenerImpl extends NativeBase implements LocationIssueListener {
    public LocationIssueListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                LocationIssueListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onLocationIssueChanged(@NonNull List<LocationIssueType> list);
}
