package com.here.sdk.venue.style;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.venue.data.VenueGeometry;

final class LabelName extends NativeBase {
    public LabelName(@NonNull VenueGeometry.LookupType lookupType, @NonNull String str) {
        this(make(lookupType, str), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull VenueGeometry.LookupType lookupType, @NonNull String str);

    @NonNull
    public native VenueGeometry.LookupType getLookupType();

    @NonNull
    public native String getReference();

    public LabelName(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                LabelName.disposeNativeHandle(j);
            }
        });
    }
}
