package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.Anchor2D;
import com.here.sdk.core.Point2D;

public final class MapImageOverlay extends NativeBase {
    public MapImageOverlay(@NonNull Point2D point2D, @NonNull MapImage mapImage) {
        this(make(point2D, mapImage), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull Point2D point2D, @NonNull MapImage mapImage);

    private static native long make(@NonNull Point2D point2D, @NonNull MapImage mapImage, @NonNull Anchor2D anchor2D);

    @NonNull
    public native Anchor2D getAnchor();

    public native int getDrawOrder();

    @NonNull
    public native MapImage getImage();

    @NonNull
    public native Point2D getViewCoordinates();

    public native void setAnchor(@NonNull Anchor2D anchor2D);

    public native void setDrawOrder(int i);

    public native void setImage(@NonNull MapImage mapImage);

    public native void setViewCoordinates(@NonNull Point2D point2D);

    public MapImageOverlay(@NonNull Point2D point2D, @NonNull MapImage mapImage, @NonNull Anchor2D anchor2D) {
        this(make(point2D, mapImage, anchor2D), (Object) null);
        cacheThisInstance();
    }

    public MapImageOverlay(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapImageOverlay.disposeNativeHandle(j);
            }
        });
    }
}
