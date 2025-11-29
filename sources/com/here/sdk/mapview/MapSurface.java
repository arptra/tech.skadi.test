package com.here.sdk.mapview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.Anchor2D;
import com.here.sdk.core.Color;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.Point2D;
import com.here.sdk.core.Rectangle2D;
import com.here.sdk.core.Size2D;
import com.here.sdk.gestures.Gestures;
import com.here.sdk.mapview.HereMap;
import com.here.sdk.mapview.MapView;
import com.here.sdk.mapview.MapViewBase;
import com.here.sdk.mapview.MapViewInternalHsdk;
import com.honey.account.b2.a;
import com.honey.account.b2.b;
import com.honey.account.b2.c;
import com.honey.account.b2.d;
import java.lang.ref.WeakReference;

public class MapSurface implements MapViewBase {
    /* access modifiers changed from: private */
    public static final boolean EXTRA_LOGGING_ENABLED = MapLogConfig.extraLoggingEnabled();
    private static final String LOG_TAG = "MapSurface";
    private final MapViewOptions mInitializationOptions;
    private MapEventsListener mMapEventListener;
    private MapViewInternalHsdk mMapViewInternal;
    private long mNativeSurface;
    private RenderListenerProxy mRenderListenerProxy;

    public static class MapEventsListener implements RenderTargetUpdatedListener {
        private boolean mHasRenderTarget;
        private boolean mIsSceneLoaded;
        private MapView.OnReadyListener mReadyListener;

        private MapEventsListener() {
            this.mIsSceneLoaded = false;
            this.mHasRenderTarget = false;
        }

        private void handleReadyStateChanged() {
            if (this.mIsSceneLoaded && this.mHasRenderTarget) {
                if (MapSurface.EXTRA_LOGGING_ENABLED) {
                    Log.d(MapSurface.LOG_TAG, "#**L onMapSurfaceReady()");
                }
                MapView.OnReadyListener onReadyListener = this.mReadyListener;
                if (onReadyListener != null) {
                    onReadyListener.onMapViewReady();
                }
            }
        }

        public void onMapSceneConfigurationSet() {
            if (!this.mIsSceneLoaded) {
                this.mIsSceneLoaded = true;
                handleReadyStateChanged();
            }
        }

        public void onRenderTargetAttached() {
        }

        public void onRenderTargetDetached() {
            this.mHasRenderTarget = false;
        }

        public void onRenderTargetUpdated() {
            if (!this.mHasRenderTarget) {
                this.mHasRenderTarget = true;
                handleReadyStateChanged();
            }
        }

        public void reset() {
            this.mIsSceneLoaded = false;
            this.mHasRenderTarget = false;
            this.mReadyListener = null;
        }

        public void setOnReadyListener(MapView.OnReadyListener onReadyListener) {
            this.mReadyListener = onReadyListener;
            if (this.mIsSceneLoaded && this.mHasRenderTarget && onReadyListener != null) {
                onReadyListener.onMapViewReady();
            }
        }
    }

    public interface RenderListener {
        void onFramePrepared();

        void onRenderTargetReleased();
    }

    public static class RenderListenerProxy implements HereMap.RenderListener {
        RenderListener mListener;

        public RenderListenerProxy(@NonNull RenderListener renderListener) {
            this.mListener = renderListener;
        }

        public void onFramePrepared() {
            this.mListener.onFramePrepared();
        }

        public void onRenderTargetReleased() {
            this.mListener.onRenderTargetReleased();
        }

        public void setListener(RenderListener renderListener) {
            this.mListener = renderListener;
        }
    }

    public MapSurface() {
        this((Context) null, (MapViewOptions) null);
    }

    private void checkMapViewInternalInitialized() {
        if (this.mNativeSurface == 0) {
            throw new IllegalStateException("Please make sure to call MapSurface methods only after calling setSurface() and before calling destroySurface().");
        }
    }

    @Nullable
    public static ShadowQuality getShadowQuality() {
        return MapContextProvider.getShadowQuality();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(WeakReference weakReference, boolean z) {
        MapEventsListener mapEventsListener = (MapEventsListener) weakReference.get();
        if (mapEventsListener != null) {
            mapEventsListener.onMapSceneConfigurationSet();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$redraw$2(Runnable runnable) {
        if (EXTRA_LOGGING_ENABLED) {
            Log.d(LOG_TAG, "#**L redraw completed");
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$setSurface$1(WeakReference weakReference, boolean z) {
        MapEventsListener mapEventsListener = (MapEventsListener) weakReference.get();
        if (mapEventsListener != null) {
            mapEventsListener.onMapSceneConfigurationSet();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$takeScreenshot$3(MapView.TakeScreenshotCallback takeScreenshotCallback, byte[] bArr) {
        takeScreenshotCallback.onScreenshotTaken(bArr != null ? BitmapFactory.decodeByteArray(bArr, 0, bArr.length) : null);
    }

    public static void setShadowQuality(@Nullable ShadowQuality shadowQuality) {
        MapContextProvider.setShadowQuality(shadowQuality);
    }

    public void addLifecycleListener(@NonNull MapViewLifecycleListener mapViewLifecycleListener) {
        checkMapViewInternalInitialized();
        this.mMapViewInternal.addLifecycleListener(mapViewLifecycleListener);
    }

    public void destroy() {
        destroySurface();
        this.mMapEventListener.reset();
        MapViewInternalHsdk mapViewInternalHsdk = this.mMapViewInternal;
        if (mapViewInternalHsdk != null) {
            mapViewInternalHsdk.destroy();
            this.mMapViewInternal = null;
        }
    }

    public void destroySurface() {
        if (this.mNativeSurface != 0) {
            this.mMapViewInternal.setRenderTargetUpdatedListener((RenderTargetUpdatedListener) null);
            this.mMapEventListener.onRenderTargetDetached();
            this.mMapViewInternal.detachHarpFromRenderTarget();
            NativeSurface.releaseNativeSurface(this.mNativeSurface);
            this.mNativeSurface = 0;
            RenderListenerProxy renderListenerProxy = this.mRenderListenerProxy;
            if (renderListenerProxy != null) {
                renderListenerProxy.setListener((RenderListener) null);
                this.mRenderListenerProxy = null;
                this.mMapViewInternal.getHereMap().setRenderListener(this.mRenderListenerProxy);
            }
        }
    }

    @Nullable
    public Point2D geoToViewCoordinates(@NonNull GeoCoordinates geoCoordinates) {
        checkMapViewInternalInitialized();
        return this.mMapViewInternal.geoToViewCoordinates(geoCoordinates);
    }

    @NonNull
    public MapCamera getCamera() {
        checkMapViewInternalInitialized();
        return this.mMapViewInternal.getCamera();
    }

    public int getFrameRate() {
        checkMapViewInternalInitialized();
        return this.mMapViewInternal.getFrameRate();
    }

    @NonNull
    public Gestures getGestures() {
        checkMapViewInternalInitialized();
        return this.mMapViewInternal.getGestures();
    }

    @NonNull
    public HereMap getHereMap() {
        checkMapViewInternalInitialized();
        return this.mMapViewInternal.getHereMap();
    }

    @NonNull
    public MapContext getMapContext() {
        checkMapViewInternalInitialized();
        return this.mMapViewInternal.getMapContext();
    }

    @NonNull
    public MapScene getMapScene() {
        checkMapViewInternalInitialized();
        return this.mMapViewInternal.getMapScene();
    }

    public double getPixelScale() {
        checkMapViewInternalInitialized();
        return this.mMapViewInternal.getPixelScale();
    }

    public Size2D getViewportSize() {
        checkMapViewInternalInitialized();
        return this.mMapViewInternal.getViewportSize();
    }

    @NonNull
    public Size2D getWatermarkSize() {
        checkMapViewInternalInitialized();
        return this.mMapViewInternal.getWatermarkSize();
    }

    public boolean isValid() {
        MapViewInternalHsdk mapViewInternalHsdk = this.mMapViewInternal;
        if (mapViewInternalHsdk == null) {
            return false;
        }
        return mapViewInternalHsdk.isValid();
    }

    public void onPause() {
        MapViewInternalHsdk mapViewInternalHsdk = this.mMapViewInternal;
        if (mapViewInternalHsdk != null) {
            mapViewInternalHsdk.pause();
        }
    }

    public void onResume() {
        MapViewInternalHsdk mapViewInternalHsdk = this.mMapViewInternal;
        if (mapViewInternalHsdk != null) {
            mapViewInternalHsdk.resume();
        }
    }

    public void pickMapContent(@NonNull Rectangle2D rectangle2D, @NonNull MapViewBase.PickMapContentCallback pickMapContentCallback) {
        MapViewInternalHsdk mapViewInternalHsdk = this.mMapViewInternal;
        if (mapViewInternalHsdk == null) {
            pickMapContentCallback.onPickMapContent((PickMapContentResult) null);
        } else {
            mapViewInternalHsdk.pickMapContent(rectangle2D, pickMapContentCallback);
        }
    }

    public void pickMapItems(@NonNull Point2D point2D, double d, @NonNull MapViewBase.PickMapItemsCallback pickMapItemsCallback) {
        MapViewInternalHsdk mapViewInternalHsdk = this.mMapViewInternal;
        if (mapViewInternalHsdk == null) {
            pickMapItemsCallback.onPickMapItems((PickMapItemsResult) null);
        } else {
            mapViewInternalHsdk.pickMapItems(point2D, d, pickMapItemsCallback);
        }
    }

    public void redraw(Runnable runnable) {
        boolean z = EXTRA_LOGGING_ENABLED;
        if (z) {
            Log.d(LOG_TAG, "#**L redraw");
        }
        MapViewInternalHsdk mapViewInternalHsdk = this.mMapViewInternal;
        if (mapViewInternalHsdk != null) {
            mapViewInternalHsdk.redraw(new d(runnable));
        } else if (runnable != null) {
            if (z) {
                Log.d(LOG_TAG, "#**L redraw - invalid MapSurface");
            }
            runnable.run();
        }
    }

    public void removeLifecycleListener(@NonNull MapViewLifecycleListener mapViewLifecycleListener) {
        checkMapViewInternalInitialized();
        this.mMapViewInternal.removeLifecycleListener(mapViewLifecycleListener);
    }

    public void setFrameRate(int i) {
        checkMapViewInternalInitialized();
        this.mMapViewInternal.setFrameRate(i);
    }

    public void setOnReadyListener(MapView.OnReadyListener onReadyListener) {
        this.mMapEventListener.setOnReadyListener(onReadyListener);
    }

    public void setSurface(Context context, Surface surface, int i, int i2) {
        setSurface(context, surface, i, i2, (RenderListener) null);
    }

    public void setWatermarkLocation(@NonNull Anchor2D anchor2D, @NonNull Point2D point2D) {
        checkMapViewInternalInitialized();
        this.mMapViewInternal.setWatermarkLocation(anchor2D, point2D);
    }

    public void takeScreenshot(MapView.TakeScreenshotCallback takeScreenshotCallback) {
        checkMapViewInternalInitialized();
        this.mMapViewInternal.takeScreenshot(new b(takeScreenshotCallback));
    }

    @Nullable
    public GeoCoordinates viewToGeoCoordinates(@NonNull Point2D point2D) {
        checkMapViewInternalInitialized();
        return this.mMapViewInternal.viewToGeoCoordinates(point2D);
    }

    public MapSurface(MapViewOptions mapViewOptions) {
        this((Context) null, mapViewOptions);
    }

    public void setSurface(Context context, Surface surface, int i, int i2, @NonNull RenderListener renderListener) {
        if (this.mMapViewInternal == null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            this.mMapViewInternal = new MapViewInternalHsdk(this.mInitializationOptions, (double) displayMetrics.density, DisplayMetricsUtils.extractDpi(displayMetrics), Double.valueOf((double) Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels)));
            this.mMapViewInternal.notifyOnSceneConfigurationSet(new a(new WeakReference(this.mMapEventListener)));
        }
        if (this.mNativeSurface != 0) {
            destroySurface();
        }
        if (surface != null) {
            this.mNativeSurface = NativeSurface.getNativeSurface(surface);
            this.mMapViewInternal.setRenderTargetUpdatedListener(this.mMapEventListener);
            if (renderListener != null) {
                this.mRenderListenerProxy = new RenderListenerProxy(renderListener);
                this.mMapViewInternal.getHereMap().setRenderListener(this.mRenderListenerProxy);
            }
            this.mMapViewInternal.attachHarpToWindowRenderTarget(this.mNativeSurface);
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            this.mMapViewInternal.setDisplayMetrics((double) displayMetrics2.density, DisplayMetricsUtils.extractDpi(displayMetrics2), Double.valueOf((double) Math.max(displayMetrics2.widthPixels, displayMetrics2.heightPixels)));
            this.mMapViewInternal.setViewSize((long) i, (long) i2);
            this.mMapViewInternal.redraw((MapViewInternalHsdk.RedrawCallback) null);
        }
    }

    public MapSurface(Context context) {
        this(context, (MapViewOptions) null);
    }

    public MapSurface(Context context, MapViewOptions mapViewOptions) {
        this.mNativeSurface = 0;
        MapViewOptions mapViewOptions2 = new MapViewOptions();
        this.mInitializationOptions = mapViewOptions2;
        if (mapViewOptions != null) {
            mapViewOptions2.projection = mapViewOptions.projection;
            Color color = mapViewOptions.initialBackgroundColor;
            if (color != null) {
                mapViewOptions2.initialBackgroundColor = Color.valueOf(color.red(), color.green(), color.blue());
            }
        } else {
            mapViewOptions2.projection = MapProjection.GLOBE;
            mapViewOptions2.initialBackgroundColor = MapView.DEFAULT_BACKGROUND_COLOR;
        }
        this.mMapEventListener = new MapEventsListener();
        if (context != null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            this.mMapViewInternal = new MapViewInternalHsdk(mapViewOptions2, (double) displayMetrics.density, DisplayMetricsUtils.extractDpi(displayMetrics), Double.valueOf((double) Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels)));
            this.mMapViewInternal.notifyOnSceneConfigurationSet(new c(new WeakReference(this.mMapEventListener)));
        }
    }
}
