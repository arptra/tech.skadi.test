package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.animation.AnimationListener;
import com.here.sdk.animation.MapMarkerAnimation;
import com.here.sdk.core.Anchor2D;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.Metadata;
import com.here.time.Duration;
import java.util.List;

public final class MapMarker extends NativeBase {
    public MapMarker(@NonNull GeoCoordinates geoCoordinates, @NonNull MapImage mapImage) {
        this(make(geoCoordinates, mapImage), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull GeoCoordinates geoCoordinates, @NonNull MapImage mapImage);

    private static native long make(@NonNull GeoCoordinates geoCoordinates, @NonNull MapImage mapImage, @NonNull Anchor2D anchor2D);

    public native void cancelAnimation(@NonNull MapMarkerAnimation mapMarkerAnimation);

    @NonNull
    public native Anchor2D getAnchor();

    @NonNull
    public native GeoCoordinates getCoordinates();

    public native int getDrawOrder();

    @NonNull
    public native Duration getFadeDuration();

    @NonNull
    public native MapImage getImage();

    @Nullable
    public native Metadata getMetadata();

    public native double getOpacity();

    @NonNull
    public native List<MapMeasureRange> getVisibilityRanges();

    public native boolean isOverlapAllowed();

    public native void setAnchor(@NonNull Anchor2D anchor2D);

    public native void setCoordinates(@NonNull GeoCoordinates geoCoordinates);

    public native void setDrawOrder(int i);

    public native void setFadeDuration(@NonNull Duration duration);

    public native void setImage(@NonNull MapImage mapImage);

    public native void setMetadata(@Nullable Metadata metadata);

    public native void setOpacity(double d);

    public native void setOverlapAllowed(boolean z);

    public native void setVisibilityRanges(@NonNull List<MapMeasureRange> list);

    public native void startAnimation(@NonNull MapMarkerAnimation mapMarkerAnimation, @Nullable AnimationListener animationListener);

    public MapMarker(@NonNull GeoCoordinates geoCoordinates, @NonNull MapImage mapImage, @NonNull Anchor2D anchor2D) {
        this(make(geoCoordinates, mapImage, anchor2D), (Object) null);
        cacheThisInstance();
    }

    public MapMarker(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapMarker.disposeNativeHandle(j);
            }
        });
    }
}
