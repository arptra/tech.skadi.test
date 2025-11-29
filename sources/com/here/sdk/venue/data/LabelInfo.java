package com.here.sdk.venue.data;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.GeoBox;

final class LabelInfo extends NativeBase {
    public LabelInfo(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                LabelInfo.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native float getAngle();

    @NonNull
    public native GeoBox getBoundingBox();
}
