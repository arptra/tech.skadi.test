package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.Anchor2D;
import com.here.sdk.core.GeoBox;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.GeoCoordinatesUpdate;
import com.here.sdk.core.GeoOrientationUpdate;
import com.here.sdk.core.Point2D;
import com.here.sdk.core.Rectangle2D;
import com.here.sdk.mapview.MapCameraUpdate;
import java.util.List;

public final class MapCameraUpdateFactory extends NativeBase {
    public MapCameraUpdateFactory(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapCameraUpdateFactory.disposeNativeHandle(j);
            }
        });
    }

    @NonNull
    public static native MapCameraUpdate compositeUpdate(@NonNull List<MapCameraUpdate> list) throws MapCameraUpdate.InstantiationException;

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public static native MapCameraUpdate lookAt(@NonNull GeoBox geoBox);

    @NonNull
    public static native MapCameraUpdate lookAt(@NonNull GeoBox geoBox, @NonNull GeoOrientationUpdate geoOrientationUpdate, @NonNull Rectangle2D rectangle2D);

    @NonNull
    public static native MapCameraUpdate lookAt(@NonNull GeoBox geoBox, @NonNull Rectangle2D rectangle2D);

    @NonNull
    public static native MapCameraUpdate lookAt(@NonNull GeoCoordinatesUpdate geoCoordinatesUpdate);

    @NonNull
    public static native MapCameraUpdate lookAt(@NonNull GeoCoordinatesUpdate geoCoordinatesUpdate, @NonNull GeoOrientationUpdate geoOrientationUpdate);

    @NonNull
    public static native MapCameraUpdate lookAt(@NonNull GeoCoordinatesUpdate geoCoordinatesUpdate, @NonNull GeoOrientationUpdate geoOrientationUpdate, @NonNull MapMeasure mapMeasure);

    @NonNull
    public static native MapCameraUpdate lookAt(@NonNull GeoCoordinatesUpdate geoCoordinatesUpdate, @NonNull GeoOrientationUpdate geoOrientationUpdate, @NonNull List<GeoCoordinates> list, @NonNull Rectangle2D rectangle2D, @NonNull MapMeasure mapMeasure, @NonNull MapMeasure mapMeasure2);

    @NonNull
    public static native MapCameraUpdate lookAt(@NonNull GeoCoordinatesUpdate geoCoordinatesUpdate, @NonNull MapMeasure mapMeasure);

    @NonNull
    public static native MapCameraUpdate lookAt(@NonNull List<GeoCoordinates> list, @NonNull Rectangle2D rectangle2D, @NonNull GeoOrientationUpdate geoOrientationUpdate, @NonNull MapMeasure mapMeasure);

    @NonNull
    public static native MapCameraUpdate lookToMatch(@NonNull GeoCoordinates geoCoordinates, @NonNull Point2D point2D);

    @NonNull
    public static native MapCameraUpdate lookToMatch(@NonNull GeoCoordinates geoCoordinates, @NonNull Point2D point2D, @NonNull GeoOrientationUpdate geoOrientationUpdate, @NonNull MapMeasure mapMeasure);

    @NonNull
    public static native MapCameraUpdate orbitBy(@NonNull GeoOrientationUpdate geoOrientationUpdate, @NonNull Point2D point2D);

    @NonNull
    public static native MapCameraUpdate panBy(double d, double d2);

    @NonNull
    public static native MapCameraUpdate rotateBy(@NonNull GeoOrientationUpdate geoOrientationUpdate);

    @NonNull
    public static native MapCameraUpdate setNormalizedPrincipalPoint(@NonNull Anchor2D anchor2D);

    @NonNull
    public static native MapCameraUpdate setPrincipalPoint(@NonNull Point2D point2D);

    @NonNull
    public static native MapCameraUpdate setVerticalFieldOfView(double d);

    @NonNull
    public static native MapCameraUpdate zoomBy(double d, @NonNull Point2D point2D);

    @NonNull
    public static native MapCameraUpdate zoomTo(double d);
}
