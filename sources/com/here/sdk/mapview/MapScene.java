package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import java.util.List;
import java.util.Map;

public final class MapScene extends NativeBase {

    @FunctionalInterface
    public interface LoadSceneCallback {
        void onLoadScene(@Nullable MapError mapError);
    }

    public static class LoadSceneCallbackImpl extends NativeBase implements LoadSceneCallback {
        public LoadSceneCallbackImpl(long j, Object obj) {
            super(j, new NativeBase.Disposer() {
                public void disposeNative(long j) {
                    LoadSceneCallbackImpl.disposeNativeHandle(j);
                }
            });
        }

        /* access modifiers changed from: private */
        public static native void disposeNativeHandle(long j);

        public native void onLoadScene(@Nullable MapError mapError);
    }

    public MapScene(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapScene.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public static native void setPoiVisibility(@NonNull List<String> list, @NonNull VisibilityState visibilityState);

    public native void addMapArrow(@NonNull MapArrow mapArrow);

    public native void addMapImageOverlay(@NonNull MapImageOverlay mapImageOverlay);

    public native void addMapMarker(@NonNull MapMarker mapMarker);

    public native void addMapMarker3d(@NonNull MapMarker3D mapMarker3D);

    public native void addMapMarkerCluster(@NonNull MapMarkerCluster mapMarkerCluster);

    public native void addMapMarkers(@NonNull List<MapMarker> list);

    public native void addMapPolygon(@NonNull MapPolygon mapPolygon);

    public native void addMapPolyline(@NonNull MapPolyline mapPolyline);

    public native void addMapPolylines(@NonNull List<MapPolyline> list);

    public native void addMapSceneConfigurationChangeListener(@NonNull MapSceneConfigurationChangeListener mapSceneConfigurationChangeListener);

    public native void disableFeatures(@NonNull List<String> list);

    public native void enableFeatures(@NonNull Map<String, String> map);

    @NonNull
    public native Map<String, String> getActiveFeatures();

    @NonNull
    public native Map<String, List<String>> getSupportedFeatures();

    public native void loadScene(@NonNull MapScheme mapScheme, @Nullable LoadSceneCallback loadSceneCallback);

    public native void loadScene(@NonNull String str, @Nullable LoadSceneCallback loadSceneCallback);

    public native void loadScene(@NonNull String str, @NonNull WatermarkStyle watermarkStyle, @Nullable LoadSceneCallback loadSceneCallback);

    public native void reloadScene();

    public native void removeMapArrow(@NonNull MapArrow mapArrow);

    public native void removeMapImageOverlay(@NonNull MapImageOverlay mapImageOverlay);

    public native void removeMapMarker(@NonNull MapMarker mapMarker);

    public native void removeMapMarker3d(@NonNull MapMarker3D mapMarker3D);

    public native void removeMapMarkerCluster(@NonNull MapMarkerCluster mapMarkerCluster);

    public native void removeMapMarkers(@NonNull List<MapMarker> list);

    public native void removeMapPolygon(@NonNull MapPolygon mapPolygon);

    public native void removeMapPolyline(@NonNull MapPolyline mapPolyline);

    public native void removeMapPolylines(@NonNull List<MapPolyline> list);

    public native void removeMapSceneConfigurationChangeListener(@NonNull MapSceneConfigurationChangeListener mapSceneConfigurationChangeListener);

    public native void setLayerVisibility(@NonNull String str, @NonNull VisibilityState visibilityState);
}
