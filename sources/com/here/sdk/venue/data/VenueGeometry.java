package com.here.sdk.venue.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.GeoBox;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.venue.style.VenueGeometryStyle;
import com.here.sdk.venue.style.VenueLabelStyle;
import java.util.List;
import java.util.Map;

public final class VenueGeometry extends NativeBase {

    public enum GeometryType {
        POINT(0),
        LINESTRING(1),
        POLYGON(2),
        MULTIPOINT(3),
        MULTIPOLYGON(4);
        
        public final int value;

        private GeometryType(int i) {
            this.value = i;
        }
    }

    public static final class InternalAddress extends NativeBase {
        public InternalAddress(long j, Object obj) {
            super(j, new NativeBase.Disposer() {
                public void disposeNative(long j) {
                    InternalAddress.disposeNativeHandle(j);
                }
            });
        }

        /* access modifiers changed from: private */
        public static native void disposeNativeHandle(long j);

        @NonNull
        public native String getAddress();

        @NonNull
        public native String getKey();
    }

    public enum LookupType {
        NONE(0),
        TEXT(1),
        ICON(2),
        IMAGE(3);
        
        public final int value;

        private LookupType(int i) {
            this.value = i;
        }
    }

    public VenueGeometry(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueGeometry.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void addEntity(@NonNull EntityInfo entityInfo);

    public native boolean contains(@NonNull VenueGeometry venueGeometry);

    @NonNull
    public native GeoBox getBoundingBox();

    @NonNull
    public native GeoCoordinates getCenter();

    @NonNull
    public native List<EntityInfo> getEntities();

    @NonNull
    public native GeometryType getGeometryType();

    @NonNull
    public native String getIdentifier();

    @Nullable
    public native InternalAddress getInternalAddress();

    @NonNull
    public native LabelInfo getLabelInfo();

    @NonNull
    public native String getLabelName();

    @Nullable
    public native VenueLabelStyle getLabelStyle();

    @NonNull
    public native VenueLevel getLevel();

    @NonNull
    public native String getLevelID();

    @NonNull
    public native LookupType getLookupType();

    @NonNull
    public native String getName();

    public native int getNestingDepth();

    @NonNull
    public native VenueGeometry getParentGeometry();

    @NonNull
    public native Map<String, Property> getProperties();

    @NonNull
    public native Shapes getShape();

    @NonNull
    public native GeometryShapeType getShapeType();

    @NonNull
    public native List<GeoShape> getShapes();

    @Nullable
    public native VenueGeometryStyle getStyle();

    @NonNull
    public native String getStyleName();

    public native void setCustomStyle(@Nullable VenueGeometryStyle venueGeometryStyle, @Nullable VenueLabelStyle venueLabelStyle);
}
