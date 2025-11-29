package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.Anchor2D;
import com.here.sdk.core.Color;
import com.here.sdk.core.NamedColor;
import java.util.List;

public final class MapMarkerCluster extends NativeBase {

    public static final class CounterStyle {
        @NonNull
        public String aboveMaxText = "+99";
        public double fontSize = 20.0d;
        public int maxCountNumber = 99;
        @NonNull
        public Anchor2D textAnchor = new Anchor2D();
        @NonNull
        public Color textColor = NamedColor.WHITE;
    }

    public static final class Grouping {
        @NonNull
        public List<MapMarker> markers;
        @NonNull
        public MapMarkerCluster parent;

        public Grouping(@NonNull List<MapMarker> list, @NonNull MapMarkerCluster mapMarkerCluster) {
            this.markers = list;
            this.parent = mapMarkerCluster;
        }
    }

    public MapMarkerCluster(@NonNull ImageStyle imageStyle) {
        this(make(imageStyle), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull ImageStyle imageStyle);

    private static native long make(@NonNull ImageStyle imageStyle, @NonNull CounterStyle counterStyle);

    public native void addMapMarker(@NonNull MapMarker mapMarker);

    public native void addMapMarkers(@NonNull List<MapMarker> list);

    @NonNull
    public native List<MapMarker> getMarkers();

    public native double getOpacity();

    public native void removeAllMapMarkers();

    public native void removeMapMarker(@NonNull MapMarker mapMarker);

    public native void removeMapMarkers(@NonNull List<MapMarker> list);

    public native void setOpacity(double d);

    public MapMarkerCluster(@NonNull ImageStyle imageStyle, @NonNull CounterStyle counterStyle) {
        this(make(imageStyle, counterStyle), (Object) null);
        cacheThisInstance();
    }

    public static final class ImageStyle {
        @NonNull
        public final Anchor2D anchor;
        @NonNull
        public final MapImage image;

        public ImageStyle(@NonNull MapImage mapImage, @NonNull Anchor2D anchor2D) {
            ImageStyle make = make(mapImage, anchor2D);
            this.image = make.image;
            this.anchor = make.anchor;
        }

        private static native ImageStyle make(@NonNull MapImage mapImage);

        private static native ImageStyle make(@NonNull MapImage mapImage, @NonNull Anchor2D anchor2D);

        public ImageStyle(@NonNull MapImage mapImage) {
            ImageStyle make = make(mapImage);
            this.image = make.image;
            this.anchor = make.anchor;
        }
    }

    public MapMarkerCluster(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapMarkerCluster.disposeNativeHandle(j);
            }
        });
    }
}
