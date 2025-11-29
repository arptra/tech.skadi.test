package io.flutter.view;

import android.graphics.SurfaceTexture;
import android.media.Image;
import android.view.Surface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface TextureRegistry {

    @Keep
    public interface GLTextureConsumer {
        @NonNull
        SurfaceTexture getSurfaceTexture();
    }

    @Keep
    public interface ImageConsumer {
        @Nullable
        Image acquireLatestImage();
    }

    @Keep
    public interface ImageTextureEntry extends TextureEntry {
        void pushImage(Image image);
    }

    public interface OnFrameConsumedListener {
        void onFrameConsumed();
    }

    public interface OnTrimMemoryListener {
        void onTrimMemory(int i);
    }

    @Keep
    public interface SurfaceProducer extends TextureEntry {
        int getHeight();

        Surface getSurface();

        int getWidth();

        void scheduleFrame();

        void setSize(int i, int i2);
    }

    @Keep
    public interface SurfaceTextureEntry extends TextureEntry {
        void setOnFrameConsumedListener(@Nullable OnFrameConsumedListener onFrameConsumedListener) {
        }

        void setOnTrimMemoryListener(@Nullable OnTrimMemoryListener onTrimMemoryListener) {
        }

        @NonNull
        SurfaceTexture surfaceTexture();
    }

    public interface TextureEntry {
        long id();

        void release();
    }

    @NonNull
    ImageTextureEntry createImageTexture();

    @NonNull
    SurfaceProducer createSurfaceProducer();

    @NonNull
    SurfaceTextureEntry createSurfaceTexture();

    void onTrimMemory(int i) {
    }

    @NonNull
    SurfaceTextureEntry registerSurfaceTexture(@NonNull SurfaceTexture surfaceTexture);
}
