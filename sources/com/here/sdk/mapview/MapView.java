package com.here.sdk.mapview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.geetest.sdk.x;
import com.here.sdk.core.Anchor2D;
import com.here.sdk.core.Color;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.LanguageCode;
import com.here.sdk.core.Point2D;
import com.here.sdk.core.Rectangle2D;
import com.here.sdk.core.Size2D;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.gestures.GestureDetector;
import com.here.sdk.gestures.Gestures;
import com.here.sdk.mapview.MapContextProvider;
import com.here.sdk.mapview.MapScene;
import com.here.sdk.mapview.MapViewBase;
import com.here.sdk.mapview.MapViewInternalHsdk;
import com.here.sdk.mapview.NetworkChangesObserver;
import com.honey.account.b2.e;
import com.honey.account.b2.f;
import com.honey.account.b2.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapView extends FrameLayout implements MapViewBase {
    private static final String BUNDLE_KEY_MAP_VIEW_ID = "com.here.sdk.bundle_key_map_view_id";
    static final Color DEFAULT_BACKGROUND_COLOR = Color.valueOf(android.graphics.Color.parseColor("#D3D3D3"));
    /* access modifiers changed from: private */
    public static final boolean EXTRA_LOGGING_ENABLED = MapLogConfig.extraLoggingEnabled();
    private static final String LOG_TAG = "MapView";
    private static final long NO_MAP_VIEW_ID = -1;
    private static long sNextId = 0;
    private static Map<Long, MapViewInternalHsdk> sStoredInstances = new HashMap();
    private boolean forceRedrawOnChange;
    private GestureDetector mGestureDetector;
    private MapScene.LoadSceneCallback mInitialLoadSceneCallback;
    private MapScheme mInitialScheme;
    private final MapViewOptions mInitializationOptions;
    /* access modifiers changed from: private */
    public boolean mIsPaused;
    /* access modifiers changed from: private */
    public MapEventsListener mMapEventListener;
    private long mMapViewId;
    /* access modifiers changed from: private */
    public MapViewInternalHsdk mMapViewInternal;
    /* access modifiers changed from: private */
    public long mNativeSurface;
    private RenderSurfaceHandler mSurfaceHandler;
    private SurfaceView mSurfaceView;
    private TextureView mTextureView;
    /* access modifiers changed from: private */
    public ViewPinsManager mViewPinsManager;

    public static class MapEventsListener implements RenderTargetUpdatedListener {
        private boolean mHasRenderTarget = false;
        private int mHeight;
        private boolean mIsSceneLoaded = false;
        private OnReadyListener mReadyListener;
        private final WeakReference<MapView> mWeakMapView;
        private int mWidth;

        public MapEventsListener(WeakReference<MapView> weakReference) {
            this.mWeakMapView = weakReference;
        }

        private void handleReadyStateChanged() {
            if (this.mIsSceneLoaded && this.mHasRenderTarget) {
                if (MapView.EXTRA_LOGGING_ENABLED) {
                    Log.d(MapView.LOG_TAG, "#**L onMapViewReady()");
                }
                MapView mapView = this.mWeakMapView.get();
                if (mapView != null) {
                    mapView.mViewPinsManager.updatePositions();
                }
                OnReadyListener onReadyListener = this.mReadyListener;
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
            if (MapView.EXTRA_LOGGING_ENABLED) {
                Log.e(MapView.LOG_TAG, "#**L onRenderTargetDetached()");
            }
            this.mHasRenderTarget = false;
        }

        public void onRenderTargetUpdated() {
            MapView mapView = this.mWeakMapView.get();
            if (mapView != null) {
                mapView.mViewPinsManager.setup(new GeoConverter(mapView), this.mWidth, this.mHeight);
            }
            if (!this.mHasRenderTarget) {
                this.mHasRenderTarget = true;
                handleReadyStateChanged();
            }
        }

        public void setOnReadyListener(OnReadyListener onReadyListener) {
            this.mReadyListener = onReadyListener;
            if (this.mIsSceneLoaded && this.mHasRenderTarget && onReadyListener != null) {
                onReadyListener.onMapViewReady();
            }
        }

        public void setViewSize(int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
        }
    }

    @FunctionalInterface
    public interface OnReadyListener {
        void onMapViewReady();
    }

    public class RenderSurfaceHandler implements SurfaceHolder.Callback2, TextureView.SurfaceTextureListener {
        private Runnable mRedrawFinishedCallback;
        /* access modifiers changed from: private */
        public Surface mSurface;

        private RenderSurfaceHandler() {
        }

        private void initNativeSurface(Surface surface) {
            this.mSurface = surface;
            long unused = MapView.this.mNativeSurface = NativeSurface.getNativeSurface(surface);
            MapView.this.mMapViewInternal.setRenderTargetUpdatedListener(MapView.this.mMapEventListener);
            MapView.this.mMapViewInternal.attachHarpToWindowRenderTarget(MapView.this.mNativeSurface);
            Log.i(MapView.LOG_TAG, String.format("NativeSurface 0x%x created and attached", new Object[]{Long.valueOf(MapView.this.mNativeSurface)}));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$surfaceRedrawNeededAsync$0(Runnable runnable, Runnable runnable2) {
            if (runnable != null) {
                runnable.run();
            }
            if (runnable2 != null) {
                runnable2.run();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$surfaceRedrawNeededAsync$1() {
            if (MapView.EXTRA_LOGGING_ENABLED) {
                Log.d(MapView.LOG_TAG, "#**L redraw completed");
            }
            Runnable runnable = this.mRedrawFinishedCallback;
            if (runnable != null) {
                runnable.run();
                this.mRedrawFinishedCallback = null;
            }
        }

        public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surfaceTexture, int i, int i2) {
            if (MapView.EXTRA_LOGGING_ENABLED) {
                Log.d(MapView.LOG_TAG, "#**L onSurfaceTextureAvailable(): size " + i + x.f + i2);
            }
            initNativeSurface(new Surface(surfaceTexture));
            MapView.this.onViewSizeChanged(i, i2);
        }

        public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surfaceTexture) {
            if (MapView.EXTRA_LOGGING_ENABLED) {
                Log.d(MapView.LOG_TAG, "#**L onSurfaceTextureDestroyed()");
            }
            MapView.this.mMapEventListener.onRenderTargetDetached();
            MapView.this.destroyNativeSurface();
            this.mSurface.release();
            this.mSurface = null;
            return false;
        }

        public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surfaceTexture, int i, int i2) {
            if (MapView.EXTRA_LOGGING_ENABLED) {
                Log.d(MapView.LOG_TAG, "#**L onSurfaceTextureSizeChanged(): new size " + i + x.f + i2);
            }
            MapView.this.onViewSizeChanged(i, i2);
            MapView.this.forceRedraw();
            MapView.this.bruteForceRedrawIfEnabled();
        }

        public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surfaceTexture) {
        }

        public void reset() {
            Runnable runnable = this.mRedrawFinishedCallback;
            if (runnable != null) {
                runnable.run();
                this.mRedrawFinishedCallback = null;
            }
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            if (MapView.EXTRA_LOGGING_ENABLED) {
                Log.d(MapView.LOG_TAG, "#**L surfaceChanged(): new size " + i2 + x.f + i3);
            }
            MapView.this.onViewSizeChanged(i2, i3);
            MapView.this.forceRedraw();
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (MapView.EXTRA_LOGGING_ENABLED) {
                Log.d(MapView.LOG_TAG, "#**L surfaceCreated()");
            }
            initNativeSurface(surfaceHolder.getSurface());
            MapView.this.onViewSizeChanged(surfaceHolder.getSurfaceFrame().width(), surfaceHolder.getSurfaceFrame().height());
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (MapView.EXTRA_LOGGING_ENABLED) {
                Log.d(MapView.LOG_TAG, "#**L surfaceDestroyed()");
            }
            Runnable runnable = this.mRedrawFinishedCallback;
            if (runnable != null) {
                runnable.run();
                this.mRedrawFinishedCallback = null;
            }
            MapView.this.mMapEventListener.onRenderTargetDetached();
            MapView.this.destroyNativeSurface();
        }

        public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
            if (MapView.EXTRA_LOGGING_ENABLED) {
                Log.e(MapView.LOG_TAG, "#**L surfaceRedrawNeeded() - not supported");
            }
        }

        public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
            if (MapView.EXTRA_LOGGING_ENABLED) {
                Log.d(MapView.LOG_TAG, "#**L surfaceRedrawNeededAsync()");
            }
            if (MapView.this.mMapViewInternal != null && !MapView.this.mIsPaused) {
                this.mRedrawFinishedCallback = new c(this.mRedrawFinishedCallback, runnable);
                MapView.this.mMapViewInternal.redraw(new d(this));
            } else if (runnable != null) {
                if (MapView.this.mIsPaused) {
                    Log.e(MapView.LOG_TAG, "#**L surfaceRedrawNeededAsync called on a paused MapView");
                } else if (MapView.EXTRA_LOGGING_ENABLED) {
                    Log.d(MapView.LOG_TAG, "#**L surfaceRedrawNeededAsync - invalid MapView");
                }
                runnable.run();
            }
        }
    }

    @FunctionalInterface
    public interface TakeScreenshotCallback {
        void onScreenshotTaken(@Nullable Bitmap bitmap);
    }

    public interface ViewPin {
        Anchor2D getAnchorPoint();

        GeoCoordinates getGeoCoordinates();

        void setAnchorPoint(@NonNull Anchor2D anchor2D);

        void setGeoCoordinates(@NonNull GeoCoordinates geoCoordinates);

        void unpin();
    }

    public MapView(Context context, MapViewOptions mapViewOptions) {
        this((SDKNativeEngine) null, mapViewOptions, context, (AttributeSet) null, 0);
    }

    private static void activateNetworkObservation(final Context context) {
        NetworkChangesObserver.startObserving(context, new NetworkChangesObserver.Listener() {
            public void onConnected() {
                new Handler(context.getMainLooper()).post(new b());
            }

            public void onDisconnected() {
            }
        });
    }

    /* access modifiers changed from: private */
    public void bruteForceRedrawIfEnabled() {
        if (this.forceRedrawOnChange) {
            postDelayed(new g(this), 10);
            postDelayed(new g(this), 60);
            postDelayed(new g(this), 200);
        }
    }

    private void checkMapViewInternalInitialized() {
        MapViewInternalHsdk mapViewInternalHsdk = this.mMapViewInternal;
        if (mapViewInternalHsdk == null || mapViewInternalHsdk.isDestroyed()) {
            throw new IllegalStateException("Please call MapView.onCreate() before calling any other MapView methods.");
        }
    }

    /* access modifiers changed from: private */
    public void destroyNativeSurface() {
        if (this.mNativeSurface != 0) {
            this.mMapViewInternal.setRenderTargetUpdatedListener((RenderTargetUpdatedListener) null);
            this.mViewPinsManager.setup((GeoConverter) null, 0, 0);
            this.mMapViewInternal.detachHarpFromRenderTarget();
            NativeSurface.releaseNativeSurface(this.mNativeSurface);
            Log.i(LOG_TAG, String.format("NativeSurface 0x%x is destroyed", new Object[]{Long.valueOf(this.mNativeSurface)}));
            this.mNativeSurface = 0;
        }
    }

    /* access modifiers changed from: private */
    public void forceRedraw() {
        MapViewInternalHsdk mapViewInternalHsdk = this.mMapViewInternal;
        if (mapViewInternalHsdk != null) {
            mapViewInternalHsdk.redraw((MapViewInternalHsdk.RedrawCallback) null);
        }
    }

    @Nullable
    public static LanguageCode getPrimaryLanguage() {
        return MapContextProvider.getLanguageOptions().primary;
    }

    @Nullable
    public static LanguageCode getSecondaryLanguage() {
        return MapContextProvider.getLanguageOptions().secondary;
    }

    @Nullable
    public static ShadowQuality getShadowQuality() {
        return MapContextProvider.getShadowQuality();
    }

    private boolean isContinuousRendering() {
        return this.mMapViewInternal.isContinuousRendering();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCreate$0(WeakReference weakReference, boolean z) {
        MapEventsListener mapEventsListener = (MapEventsListener) weakReference.get();
        if (mapEventsListener != null) {
            mapEventsListener.onMapSceneConfigurationSet();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$takeScreenshot$1(TakeScreenshotCallback takeScreenshotCallback, byte[] bArr) {
        takeScreenshotCallback.onScreenshotTaken(bArr != null ? BitmapFactory.decodeByteArray(bArr, 0, bArr.length) : null);
    }

    /* access modifiers changed from: private */
    public void onViewSizeChanged(int i, int i2) {
        this.mMapEventListener.setViewSize(i, i2);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mMapViewInternal.setDisplayMetrics((double) displayMetrics.density, DisplayMetricsUtils.extractDpi(displayMetrics), Double.valueOf((double) Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels)));
        this.mMapViewInternal.setViewSize((long) i, (long) i2);
    }

    private void setContinuousRendering(boolean z) {
        this.mMapViewInternal.setContinuousRendering(z);
    }

    public static void setPrimaryLanguage(@Nullable LanguageCode languageCode) {
        MapContextProvider.LanguageOptions languageOptions = MapContextProvider.getLanguageOptions();
        languageOptions.primary = languageCode;
        MapContextProvider.setLanguageOptions(languageOptions);
    }

    public static void setSecondaryLanguage(@Nullable LanguageCode languageCode) {
        MapContextProvider.LanguageOptions languageOptions = MapContextProvider.getLanguageOptions();
        languageOptions.secondary = languageCode;
        MapContextProvider.setLanguageOptions(languageOptions);
    }

    public static void setShadowQuality(@Nullable ShadowQuality shadowQuality) {
        MapContextProvider.setShadowQuality(shadowQuality);
    }

    public void addLifecycleListener(@NonNull MapViewLifecycleListener mapViewLifecycleListener) {
        checkMapViewInternalInitialized();
        this.mMapViewInternal.addLifecycleListener(mapViewLifecycleListener);
    }

    public void createSurface() {
        if (EXTRA_LOGGING_ENABLED) {
            Log.d(LOG_TAG, "#**L createSurface()");
        }
        this.mViewPinsManager = new ViewPinsManager(getContext());
        this.mSurfaceHandler = new RenderSurfaceHandler();
        MapRenderMode mapRenderMode = this.mInitializationOptions.renderMode;
        if (mapRenderMode == MapRenderMode.TEXTURE) {
            TextureView textureView = new TextureView(getContext());
            this.mTextureView = textureView;
            textureView.setSurfaceTextureListener(this.mSurfaceHandler);
            addView(this.mTextureView);
        } else if (mapRenderMode == MapRenderMode.SURFACE) {
            SurfaceView surfaceView = new SurfaceView(getContext());
            this.mSurfaceView = surfaceView;
            surfaceView.getHolder().addCallback(this.mSurfaceHandler);
            this.mSurfaceView.setWillNotDraw(false);
            addView(this.mSurfaceView);
        }
        addView(this.mViewPinsManager);
    }

    public void destroySurface() {
        if (EXTRA_LOGGING_ENABLED) {
            Log.d(LOG_TAG, "#**L destroySurface()");
        }
        removeAllViews();
        destroyNativeSurface();
    }

    public void enableForceRedrawOnChange() {
        this.forceRedrawOnChange = true;
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

    public Surface getSurface() {
        RenderSurfaceHandler renderSurfaceHandler = this.mSurfaceHandler;
        if (renderSurfaceHandler != null) {
            return renderSurfaceHandler.mSurface;
        }
        return null;
    }

    public SurfaceView getSurfaceView() {
        return this.mSurfaceView;
    }

    public List<ViewPin> getViewPins() {
        return new ArrayList(this.mViewPinsManager.getViewPins());
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

    public void onCreate(Bundle bundle) {
        onCreate(bundle, "");
    }

    public void onDestroy() {
        if (EXTRA_LOGGING_ENABLED) {
            Log.d(LOG_TAG, "#**L onDestroy()");
        }
        this.mMapViewInternal.getCamera().removeListener(this.mViewPinsManager);
        this.mMapEventListener.setOnReadyListener((OnReadyListener) null);
        if (!sStoredInstances.containsValue(this.mMapViewInternal)) {
            this.mMapViewInternal.destroy();
        } else {
            destroyNativeSurface();
        }
        SurfaceView surfaceView = this.mSurfaceView;
        if (surfaceView != null) {
            surfaceView.getHolder().removeCallback(this.mSurfaceHandler);
        }
        this.mSurfaceHandler.reset();
        removeAllViews();
        long liveInstanceCount = MapViewInternalHsdk.getLiveInstanceCount();
        boolean z = sStoredInstances.containsValue(this.mMapViewInternal) && liveInstanceCount == 1;
        if (liveInstanceCount == 0 || z) {
            NetworkChangesObserver.stopObserving(getContext());
        }
    }

    public void onPause() {
        if (EXTRA_LOGGING_ENABLED) {
            Log.d(LOG_TAG, "#**L onPause()");
        }
        this.mMapViewInternal.pause();
        this.mIsPaused = true;
    }

    public void onResume() {
        if (EXTRA_LOGGING_ENABLED) {
            Log.d(LOG_TAG, "#**L onResume()");
        }
        this.mMapViewInternal.resume();
        this.mIsPaused = false;
        bruteForceRedrawIfEnabled();
        long j = this.mMapViewId;
        if (j != -1 && sStoredInstances.containsKey(Long.valueOf(j))) {
            sStoredInstances.remove(Long.valueOf(this.mMapViewId));
            this.mMapViewId = -1;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle, "");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mGestureDetector.processMotionEvent(motionEvent);
        return true;
    }

    public void pickMapContent(@NonNull Rectangle2D rectangle2D, @NonNull MapViewBase.PickMapContentCallback pickMapContentCallback) {
        this.mMapViewInternal.pickMapContent(rectangle2D, pickMapContentCallback);
    }

    public void pickMapItems(@NonNull Point2D point2D, double d, @NonNull MapViewBase.PickMapItemsCallback pickMapItemsCallback) {
        this.mMapViewInternal.pickMapItems(point2D, d, pickMapItemsCallback);
    }

    @Nullable
    public ViewPin pinView(@NonNull View view, GeoCoordinates geoCoordinates) {
        return this.mViewPinsManager.pinView(view, geoCoordinates);
    }

    public void removeLifecycleListener(@NonNull MapViewLifecycleListener mapViewLifecycleListener) {
        checkMapViewInternalInitialized();
        this.mMapViewInternal.removeLifecycleListener(mapViewLifecycleListener);
    }

    public void setFrameRate(int i) {
        this.mMapViewInternal.setFrameRate(i);
    }

    public void setInitialBackgroundColor(@NonNull Color color) {
        this.mInitializationOptions.initialBackgroundColor = Color.valueOf(color.red(), color.green(), color.blue());
    }

    public void setOnReadyListener(OnReadyListener onReadyListener) {
        checkMapViewInternalInitialized();
        this.mMapEventListener.setOnReadyListener(onReadyListener);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        SurfaceView surfaceView = this.mSurfaceView;
        if (surfaceView != null) {
            surfaceView.setVisibility(i);
        }
    }

    public void setWatermarkLocation(@NonNull Anchor2D anchor2D, @NonNull Point2D point2D) {
        checkMapViewInternalInitialized();
        this.mMapViewInternal.setWatermarkLocation(anchor2D, point2D);
    }

    public void takeScreenshot(TakeScreenshotCallback takeScreenshotCallback) {
        checkMapViewInternalInitialized();
        this.mMapViewInternal.takeScreenshot(new f(takeScreenshotCallback));
    }

    public void unpinView(@NonNull View view) {
        this.mViewPinsManager.unpinView(view);
    }

    @Nullable
    public GeoCoordinates viewToGeoCoordinates(@NonNull Point2D point2D) {
        checkMapViewInternalInitialized();
        return this.mMapViewInternal.viewToGeoCoordinates(point2D);
    }

    public MapView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public void onCreate(Bundle bundle, String str) {
        if (EXTRA_LOGGING_ENABLED) {
            Log.d(LOG_TAG, "#**L onCreate(): id='" + str + "'");
        }
        long j = -1;
        if (bundle != null) {
            j = bundle.getLong(BUNDLE_KEY_MAP_VIEW_ID + str, -1);
        }
        if (sStoredInstances.containsKey(Long.valueOf(j))) {
            this.mMapViewInternal = sStoredInstances.remove(Long.valueOf(j));
        } else {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.mMapViewInternal = new MapViewInternalHsdk(this.mInitializationOptions, (double) displayMetrics.density, DisplayMetricsUtils.extractDpi(displayMetrics), Double.valueOf((double) Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels)));
        }
        this.mMapViewInternal.getCamera().addListener(this.mViewPinsManager);
        this.mMapEventListener = new MapEventsListener(new WeakReference(this));
        this.mMapViewInternal.notifyOnSceneConfigurationSet(new e(new WeakReference(this.mMapEventListener)));
        this.mGestureDetector = new GestureDetector(this.mMapViewInternal.getInternalGestureDetector());
        if (this.mInitialScheme != null) {
            getMapScene().loadScene(this.mInitialScheme, this.mInitialLoadSceneCallback);
            this.mInitialScheme = null;
        }
    }

    public void onSaveInstanceState(Bundle bundle, String str) {
        if (EXTRA_LOGGING_ENABLED) {
            Log.d(LOG_TAG, "#**L onSaveInstanceState(): id='" + str + "'");
        }
        if (this.mMapViewInternal != null) {
            sStoredInstances.put(Long.valueOf(sNextId), this.mMapViewInternal);
            long j = sNextId;
            this.mMapViewId = j;
            sNextId = j + 1;
            bundle.putLong(BUNDLE_KEY_MAP_VIEW_ID + str, this.mMapViewId);
        }
    }

    public MapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        this((SDKNativeEngine) null, (MapViewOptions) null, context, attributeSet, i);
    }

    public MapView(SDKNativeEngine sDKNativeEngine, Context context, AttributeSet attributeSet, int i) {
        this(sDKNativeEngine, (MapViewOptions) null, context, attributeSet, i);
    }

    public MapView(SDKNativeEngine sDKNativeEngine, MapViewOptions mapViewOptions, Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mNativeSurface = 0;
        this.mMapViewId = -1;
        this.mIsPaused = false;
        MapViewOptions mapViewOptions2 = new MapViewOptions();
        this.mInitializationOptions = mapViewOptions2;
        this.forceRedrawOnChange = false;
        mapViewOptions = mapViewOptions == null ? AttributeUtils.getOptions(context, attributeSet) : mapViewOptions;
        if (mapViewOptions != null) {
            mapViewOptions2.projection = mapViewOptions.projection;
            Color color = mapViewOptions.initialBackgroundColor;
            if (color != null) {
                mapViewOptions2.initialBackgroundColor = Color.valueOf(color.red(), color.green(), color.blue());
            }
            mapViewOptions2.renderMode = mapViewOptions.renderMode;
        } else {
            mapViewOptions2.projection = MapProjection.GLOBE;
            mapViewOptions2.initialBackgroundColor = DEFAULT_BACKGROUND_COLOR;
        }
        activateNetworkObservation(context);
        createSurface();
        MapScheme mapScheme = AttributeUtils.getMapScheme(context, attributeSet);
        this.mInitialScheme = mapScheme;
        if (mapScheme != null) {
            this.mInitialLoadSceneCallback = AttributeUtils.getCallback(context, attributeSet);
        }
    }
}
