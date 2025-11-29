package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import io.flutter.view.TextureRegistry;

@TargetApi(26)
public class SurfaceTexturePlatformViewRenderTarget implements PlatformViewRenderTarget {
    private static final String TAG = "SurfaceTexturePlatformViewRenderTarget";
    private int bufferHeight = 0;
    private int bufferWidth = 0;
    /* access modifiers changed from: private */
    public boolean shouldRecreateSurfaceForLowMemory = false;
    private Surface surface;
    private SurfaceTexture surfaceTexture;
    private final TextureRegistry.SurfaceTextureEntry surfaceTextureEntry;
    private final TextureRegistry.OnTrimMemoryListener trimMemoryListener;

    public SurfaceTexturePlatformViewRenderTarget(TextureRegistry.SurfaceTextureEntry surfaceTextureEntry2) {
        AnonymousClass1 r0 = new TextureRegistry.OnTrimMemoryListener() {
            public void onTrimMemory(int i) {
                if (i == 80) {
                    boolean unused = SurfaceTexturePlatformViewRenderTarget.this.shouldRecreateSurfaceForLowMemory = true;
                }
            }
        };
        this.trimMemoryListener = r0;
        this.surfaceTextureEntry = surfaceTextureEntry2;
        this.surfaceTexture = surfaceTextureEntry2.surfaceTexture();
        surfaceTextureEntry2.setOnTrimMemoryListener(r0);
    }

    private void recreateSurfaceIfNeeded() {
        Surface surface2 = this.surface;
        if (surface2 == null || this.shouldRecreateSurfaceForLowMemory) {
            if (surface2 != null) {
                surface2.release();
                this.surface = null;
            }
            this.surface = createSurface();
            this.shouldRecreateSurfaceForLowMemory = false;
        }
    }

    public Surface createSurface() {
        return new Surface(this.surfaceTexture);
    }

    public int getHeight() {
        return this.bufferHeight;
    }

    public long getId() {
        return this.surfaceTextureEntry.id();
    }

    public Surface getSurface() {
        recreateSurfaceIfNeeded();
        SurfaceTexture surfaceTexture2 = this.surfaceTexture;
        if (surfaceTexture2 == null || surfaceTexture2.isReleased()) {
            return null;
        }
        return this.surface;
    }

    public int getWidth() {
        return this.bufferWidth;
    }

    public boolean isReleased() {
        return this.surfaceTexture == null;
    }

    public void release() {
        this.surfaceTexture = null;
        Surface surface2 = this.surface;
        if (surface2 != null) {
            surface2.release();
            this.surface = null;
        }
    }

    public void resize(int i, int i2) {
        this.bufferWidth = i;
        this.bufferHeight = i2;
        SurfaceTexture surfaceTexture2 = this.surfaceTexture;
        if (surfaceTexture2 != null) {
            surfaceTexture2.setDefaultBufferSize(i, i2);
        }
    }
}
