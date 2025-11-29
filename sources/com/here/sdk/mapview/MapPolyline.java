package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.animation.AnimationListener;
import com.here.sdk.animation.MapPolylineAnimation;
import com.here.sdk.core.Color;
import com.here.sdk.core.GeoPolyline;
import com.here.sdk.core.Metadata;
import java.util.List;
import java.util.Map;

public final class MapPolyline extends NativeBase {

    public static class Representation extends MapItemRepresentation {

        public enum InstantiationErrorCode {
            ILLEGAL_ARGUMENTS(1);
            
            public final int value;

            private InstantiationErrorCode(int i) {
                this.value = i;
            }
        }

        public static final class InstantiationException extends Exception {
            public final InstantiationErrorCode error;

            public InstantiationException(InstantiationErrorCode instantiationErrorCode) {
                super(instantiationErrorCode.toString());
                this.error = instantiationErrorCode;
            }
        }

        public Representation(long j, Object obj) {
            super(j, obj);
        }
    }

    @Deprecated
    public MapPolyline(@NonNull GeoPolyline geoPolyline, double d, @NonNull Color color) {
        this(make(geoPolyline, d, color), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull GeoPolyline geoPolyline, double d, @NonNull Color color);

    private static native long make(@NonNull GeoPolyline geoPolyline, double d, @NonNull Color color, double d2, @NonNull Color color2);

    private static native long make(@NonNull GeoPolyline geoPolyline, @NonNull Representation representation);

    public native void cancelAnimation(@NonNull MapPolylineAnimation mapPolylineAnimation);

    @Deprecated
    @Nullable
    public native Color getDashFillColor();

    @Deprecated
    @Nullable
    public native DashPattern getDashPattern();

    public native int getDrawOrder();

    @NonNull
    public native GeoPolyline getGeometry();

    @NonNull
    @Deprecated
    public native LineCap getLineCap();

    @NonNull
    @Deprecated
    public native Color getLineColor();

    @Deprecated
    public native double getLineWidth();

    @NonNull
    public native List<MapContentCategory> getMapContentCategoriesToBlock();

    @NonNull
    @Deprecated
    public native Map<MapMeasure, Double> getMeasureDependentLineWidth();

    @NonNull
    @Deprecated
    public native Map<MapMeasure, Double> getMeasureDependentOutlineWidth();

    @Nullable
    public native Metadata getMetadata();

    @NonNull
    @Deprecated
    public native Color getOutlineColor();

    @Deprecated
    public native double getOutlineWidth();

    public native double getProgress();

    @NonNull
    public native Color getProgressColor();

    @NonNull
    public native Color getProgressOutlineColor();

    @NonNull
    public native List<MapMeasureRange> getVisibilityRanges();

    @Deprecated
    public native void setDashFillColor(@Nullable Color color);

    @Deprecated
    public native void setDashPattern(@Nullable DashPattern dashPattern);

    public native void setDrawOrder(int i);

    public native void setGeometry(@NonNull GeoPolyline geoPolyline);

    @Deprecated
    public native void setLineCap(@NonNull LineCap lineCap);

    @Deprecated
    public native void setLineColor(@NonNull Color color);

    @Deprecated
    public native void setLineWidth(double d);

    public native void setMapContentCategoriesToBlock(@NonNull List<MapContentCategory> list);

    @Deprecated
    public native void setMeasureDependentLineWidth(@NonNull Map<MapMeasure, Double> map);

    @Deprecated
    public native void setMeasureDependentOutlineWidth(@NonNull Map<MapMeasure, Double> map);

    public native void setMetadata(@Nullable Metadata metadata);

    @Deprecated
    public native void setOutlineColor(@NonNull Color color);

    @Deprecated
    public native void setOutlineWidth(double d);

    public native void setProgress(double d);

    public native void setProgressColor(@NonNull Color color);

    public native void setProgressOutlineColor(@NonNull Color color);

    public native void setRepresentation(@NonNull Representation representation);

    public native void setVisibilityRanges(@NonNull List<MapMeasureRange> list);

    public native void startAnimation(@NonNull MapPolylineAnimation mapPolylineAnimation, @NonNull AnimationListener animationListener);

    public static final class DashImageRepresentation extends Representation {
        public DashImageRepresentation(@NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize, @NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize2, @NonNull MapImage mapImage) throws Representation.InstantiationException {
            this(make(mapMeasureDependentRenderSize, mapMeasureDependentRenderSize2, mapImage), (Object) null);
            cacheThisInstance();
        }

        private native void cacheThisInstance();

        private static native long make(@NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize, @NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize2, @NonNull MapImage mapImage) throws Representation.InstantiationException;

        private static native long make(@NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize, @NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize2, @NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize3, @NonNull MapImage mapImage) throws Representation.InstantiationException;

        @NonNull
        public native MapImage getDashImage();

        @NonNull
        public native MapMeasureDependentRenderSize getDashLength();

        @NonNull
        public native MapMeasureDependentRenderSize getDashWidth();

        @NonNull
        public native MapMeasureDependentRenderSize getGapLength();

        public DashImageRepresentation(@NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize, @NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize2, @NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize3, @NonNull MapImage mapImage) throws Representation.InstantiationException {
            this(make(mapMeasureDependentRenderSize, mapMeasureDependentRenderSize2, mapMeasureDependentRenderSize3, mapImage), (Object) null);
            cacheThisInstance();
        }

        public DashImageRepresentation(long j, Object obj) {
            super(j, obj);
        }
    }

    public static final class DashRepresentation extends Representation {
        public DashRepresentation(@NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize, @NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize2, @NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize3, @NonNull Color color) throws Representation.InstantiationException {
            this(make(mapMeasureDependentRenderSize, mapMeasureDependentRenderSize2, mapMeasureDependentRenderSize3, color), (Object) null);
            cacheThisInstance();
        }

        private native void cacheThisInstance();

        private static native long make(@NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize, @NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize2, @NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize3, @NonNull Color color) throws Representation.InstantiationException;

        private static native long make(@NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize, @NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize2, @NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize3, @NonNull Color color, @NonNull Color color2) throws Representation.InstantiationException;

        @NonNull
        public native Color getDashColor();

        @NonNull
        public native MapMeasureDependentRenderSize getDashLength();

        @Nullable
        public native Color getGapColor();

        @NonNull
        public native MapMeasureDependentRenderSize getGapLength();

        @NonNull
        public native MapMeasureDependentRenderSize getLineWidth();

        public DashRepresentation(@NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize, @NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize2, @NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize3, @NonNull Color color, @NonNull Color color2) throws Representation.InstantiationException {
            this(make(mapMeasureDependentRenderSize, mapMeasureDependentRenderSize2, mapMeasureDependentRenderSize3, color, color2), (Object) null);
            cacheThisInstance();
        }

        public DashRepresentation(long j, Object obj) {
            super(j, obj);
        }
    }

    public static final class SolidRepresentation extends Representation {
        public SolidRepresentation(@NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize, @NonNull Color color, @NonNull LineCap lineCap) throws Representation.InstantiationException {
            this(make(mapMeasureDependentRenderSize, color, lineCap), (Object) null);
            cacheThisInstance();
        }

        private native void cacheThisInstance();

        private static native long make(@NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize, @NonNull Color color, @NonNull LineCap lineCap) throws Representation.InstantiationException;

        private static native long make(@NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize, @NonNull Color color, @NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize2, @NonNull Color color2, @NonNull LineCap lineCap) throws Representation.InstantiationException;

        @NonNull
        public native LineCap getCapShape();

        @NonNull
        public native Color getLineColor();

        @NonNull
        public native MapMeasureDependentRenderSize getLineWidth();

        @NonNull
        public native Color getOutlineColor();

        @NonNull
        public native MapMeasureDependentRenderSize getOutlineWidth();

        public SolidRepresentation(@NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize, @NonNull Color color, @NonNull MapMeasureDependentRenderSize mapMeasureDependentRenderSize2, @NonNull Color color2, @NonNull LineCap lineCap) throws Representation.InstantiationException {
            this(make(mapMeasureDependentRenderSize, color, mapMeasureDependentRenderSize2, color2, lineCap), (Object) null);
            cacheThisInstance();
        }

        public SolidRepresentation(long j, Object obj) {
            super(j, obj);
        }
    }

    @Deprecated
    public MapPolyline(@NonNull GeoPolyline geoPolyline, double d, @NonNull Color color, double d2, @NonNull Color color2) {
        this(make(geoPolyline, d, color, d2, color2), (Object) null);
        cacheThisInstance();
    }

    public MapPolyline(@NonNull GeoPolyline geoPolyline, @NonNull Representation representation) {
        this(make(geoPolyline, representation), (Object) null);
        cacheThisInstance();
    }

    public MapPolyline(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapPolyline.disposeNativeHandle(j);
            }
        });
    }
}
