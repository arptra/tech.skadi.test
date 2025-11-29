package com.here.sdk.venue.data;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.GeoCoordinates;
import java.util.List;

final class GeoShape extends NativeBase {
    public GeoShape(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                GeoShape.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native List<GeoCoordinates> getPath();

    @NonNull
    public native List<Integer> getSeamIndices();

    @NonNull
    public native List<Integer> getTriangleIndices();
}
