package com.here.sdk.venue.style;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.venue.data.VenueGeometry;

final class IconGeometry extends NativeBase {
    public IconGeometry(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                IconGeometry.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native VenueGeometry.GeometryType getGeometryType();

    public native float getGeometryWidth();

    @NonNull
    public native VenueGeometryStyle getStyle();
}
