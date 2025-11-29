package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.view.Surface;
import io.flutter.view.TextureRegistry;

@TargetApi(29)
public class SurfaceProducerPlatformViewRenderTarget implements PlatformViewRenderTarget {
    private static final String TAG = "SurfaceProducerRenderTarget";
    private TextureRegistry.SurfaceProducer producer;

    public SurfaceProducerPlatformViewRenderTarget(TextureRegistry.SurfaceProducer surfaceProducer) {
        this.producer = surfaceProducer;
    }

    public int getHeight() {
        return this.producer.getHeight();
    }

    public long getId() {
        return this.producer.id();
    }

    public Surface getSurface() {
        return this.producer.getSurface();
    }

    public int getWidth() {
        return this.producer.getWidth();
    }

    public boolean isReleased() {
        return this.producer == null;
    }

    public void release() {
        this.producer.release();
        this.producer = null;
    }

    public void resize(int i, int i2) {
        this.producer.setSize(i, i2);
    }

    public void scheduleFrame() {
        this.producer.scheduleFrame();
    }
}
