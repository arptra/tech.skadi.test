package com.here.sdk.mapview;

import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.Point2D;
import java.lang.ref.WeakReference;

class GeoConverter implements Function<GeoCoordinates, Point2D> {
    private WeakReference<MapView> mWeakMapView;

    public GeoConverter(MapView mapView) {
        this.mWeakMapView = new WeakReference<>(mapView);
    }

    public Point2D apply(GeoCoordinates geoCoordinates) {
        MapView mapView = this.mWeakMapView.get();
        if (mapView == null) {
            return null;
        }
        return mapView.geoToViewCoordinates(geoCoordinates);
    }
}
