package com.here.sdk.venue.style;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.Color;

public final class VenueGeometryStyle extends NativeBase {
    public VenueGeometryStyle(@NonNull Color color, @NonNull Color color2, float f) {
        this(make(color, color2, f), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull Color color, @NonNull Color color2, float f);

    @Nullable
    public native String getLabelStyleName();

    @NonNull
    public native Color getMainColor();

    @NonNull
    public native Color getOutlineColor();

    public native float getOutlineWidth();

    @Nullable
    public native Float getZMin();

    public VenueGeometryStyle(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueGeometryStyle.disposeNativeHandle(j);
            }
        });
    }
}
