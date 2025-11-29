package io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.view.TextureRegistry;

final class SurfaceTextureSurfaceProducer implements TextureRegistry.SurfaceProducer, TextureRegistry.GLTextureConsumer {
    @NonNull
    private final FlutterJNI flutterJNI;
    @NonNull
    private final Handler handler;
    private final long id;
    private boolean released;
    private int requestBufferWidth;
    private int requestedBufferHeight;
    @Nullable
    private Surface surface;
    @NonNull
    private final TextureRegistry.SurfaceTextureEntry texture;

    public SurfaceTextureSurfaceProducer(long j, @NonNull Handler handler2, @NonNull FlutterJNI flutterJNI2, @NonNull TextureRegistry.SurfaceTextureEntry surfaceTextureEntry) {
        this.id = j;
        this.handler = handler2;
        this.flutterJNI = flutterJNI2;
        this.texture = surfaceTextureEntry;
    }

    public void finalize() throws Throwable {
        try {
            if (!this.released) {
                release();
                this.handler.post(new FlutterRenderer.TextureFinalizerRunnable(this.id, this.flutterJNI));
                super.finalize();
            }
        } finally {
            super.finalize();
        }
    }

    public int getHeight() {
        return this.requestedBufferHeight;
    }

    public Surface getSurface() {
        if (this.surface == null) {
            this.surface = new Surface(this.texture.surfaceTexture());
        }
        return this.surface;
    }

    @NonNull
    public SurfaceTexture getSurfaceTexture() {
        return this.texture.surfaceTexture();
    }

    public int getWidth() {
        return this.requestBufferWidth;
    }

    public long id() {
        return this.id;
    }

    public void release() {
        this.texture.release();
        this.released = true;
    }

    public void scheduleFrame() {
        this.flutterJNI.markTextureFrameAvailable(this.id);
    }

    public void setSize(int i, int i2) {
        this.requestBufferWidth = i;
        this.requestedBufferHeight = i2;
        getSurfaceTexture().setDefaultBufferSize(i, i2);
    }
}
