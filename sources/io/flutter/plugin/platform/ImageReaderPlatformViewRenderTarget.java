package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import com.honey.account.ab.g;
import com.honey.account.ab.h;
import io.flutter.Log;
import io.flutter.view.TextureRegistry;

@TargetApi(29)
public class ImageReaderPlatformViewRenderTarget implements PlatformViewRenderTarget {
    private static final int MAX_IMAGES = 4;
    private static final String TAG = "ImageReaderPlatformViewRenderTarget";
    private int bufferHeight = 0;
    private int bufferWidth = 0;
    private final Handler onImageAvailableHandler = new Handler();
    private final ImageReader.OnImageAvailableListener onImageAvailableListener = new ImageReader.OnImageAvailableListener() {
        public void onImageAvailable(ImageReader imageReader) {
            Image image;
            try {
                image = imageReader.acquireLatestImage();
            } catch (IllegalStateException e) {
                Log.e(ImageReaderPlatformViewRenderTarget.TAG, "onImageAvailable acquireLatestImage failed: " + e.toString());
                image = null;
            }
            if (image != null) {
                ImageReaderPlatformViewRenderTarget.this.textureEntry.pushImage(image);
            }
        }
    };
    private ImageReader reader;
    /* access modifiers changed from: private */
    public TextureRegistry.ImageTextureEntry textureEntry;

    public ImageReaderPlatformViewRenderTarget(TextureRegistry.ImageTextureEntry imageTextureEntry) {
        this.textureEntry = imageTextureEntry;
    }

    private void closeReader() {
        if (this.reader != null) {
            this.textureEntry.pushImage((Image) null);
            this.reader.close();
            this.reader = null;
        }
    }

    public ImageReader createImageReader() {
        return Build.VERSION.SDK_INT >= 33 ? createImageReader33() : createImageReader29();
    }

    @TargetApi(29)
    public ImageReader createImageReader29() {
        ImageReader newInstance = ImageReader.newInstance(this.bufferWidth, this.bufferHeight, 34, 4, 256);
        newInstance.setOnImageAvailableListener(this.onImageAvailableListener, this.onImageAvailableHandler);
        return newInstance;
    }

    @TargetApi(33)
    public ImageReader createImageReader33() {
        h.a();
        ImageReader.Builder a2 = g.a(this.bufferWidth, this.bufferHeight);
        ImageReader.Builder unused = a2.setMaxImages(4);
        ImageReader.Builder unused2 = a2.setImageFormat(34);
        ImageReader.Builder unused3 = a2.setUsage(256);
        ImageReader a3 = a2.build();
        a3.setOnImageAvailableListener(this.onImageAvailableListener, this.onImageAvailableHandler);
        return a3;
    }

    public int getHeight() {
        return this.bufferHeight;
    }

    public long getId() {
        return this.textureEntry.id();
    }

    public Surface getSurface() {
        return this.reader.getSurface();
    }

    public int getWidth() {
        return this.bufferWidth;
    }

    public boolean isReleased() {
        return this.textureEntry == null;
    }

    public void release() {
        closeReader();
        this.textureEntry = null;
    }

    public void resize(int i, int i2) {
        if (this.reader == null || this.bufferWidth != i || this.bufferHeight != i2) {
            closeReader();
            this.bufferWidth = i;
            this.bufferHeight = i2;
            this.reader = createImageReader();
        }
    }
}
