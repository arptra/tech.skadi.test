package org.libpag;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import org.extra.tools.a;

class VideoSurface implements SurfaceTexture.OnFrameAvailableListener {
    long nativeContext = 0;

    static {
        a.e("pag");
        nativeInit();
    }

    private VideoSurface(int i, int i2) {
        nativeSetup(i, i2);
    }

    public static VideoSurface a(int i, int i2) {
        VideoSurface videoSurface = new VideoSurface(i, i2);
        if (videoSurface.nativeContext == 0) {
            return null;
        }
        return videoSurface;
    }

    private native void nativeFinalize();

    private static native void nativeInit();

    private native void nativeRelease();

    private native void nativeSetup(int i, int i2);

    private native void notifyFrameAvailable();

    public void finalize() {
        nativeFinalize();
    }

    public native Surface getInputSurface();

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        notifyFrameAvailable();
    }

    public void a() {
        nativeRelease();
    }
}
