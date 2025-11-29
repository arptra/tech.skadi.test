package com.here.sdk.venue.style;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.Color;

public final class VenueLabelStyle extends NativeBase {
    public VenueLabelStyle(@NonNull Color color, @NonNull Color color2, float f, int i) {
        this(make(color, color2, f, i), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull Color color, @NonNull Color color2, float f, int i);

    @NonNull
    public native Color getFillColor();

    @Nullable
    public native String getFont();

    public native int getMaxFont();

    public native int getMinFont();

    @Nullable
    public native Color getOutlineColor();

    public native float getOutlineWidth();

    @Nullable
    public native Float getZMin();

    public VenueLabelStyle(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueLabelStyle.disposeNativeHandle(j);
            }
        });
    }
}
