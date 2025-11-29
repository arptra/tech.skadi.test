package org.libpag;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.HardwareBuffer;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.util.Pair;
import android.view.Surface;
import org.extra.tools.a;

public class PAGSurface {

    /* renamed from: a  reason: collision with root package name */
    private Surface f3422a = null;
    private boolean b = false;
    private int c = 0;
    long nativeSurface;

    static {
        a.e("pag");
        nativeInit();
    }

    private PAGSurface(long j) {
        this.nativeSurface = j;
    }

    public static PAGSurface FromSurface(Surface surface) {
        return FromSurface(surface, EGL14.EGL_NO_CONTEXT);
    }

    public static PAGSurface FromSurfaceTexture(SurfaceTexture surfaceTexture) {
        return FromSurfaceTexture(surfaceTexture, EGL14.EGL_NO_CONTEXT);
    }

    public static PAGSurface FromTexture(int i, int i2, int i3) {
        return FromTexture(i, i2, i3, false);
    }

    public static PAGSurface FromTextureForAsyncThread(int i, int i2, int i3) {
        return FromTextureForAsyncThread(i, i2, i3, false);
    }

    public static PAGSurface MakeOffscreen(int i, int i2) {
        long SetupOffscreen = SetupOffscreen(i, i2);
        if (SetupOffscreen == 0) {
            return null;
        }
        return new PAGSurface(SetupOffscreen);
    }

    private static native long SetupFromSurfaceWithGLContext(Surface surface, long j);

    public static native long SetupFromTexture(int i, int i2, int i3, boolean z, boolean z2);

    private static native long SetupOffscreen(int i, int i2);

    private native void nativeFinalize();

    private static native void nativeInit();

    private native void nativeRelease();

    public native boolean clearAll();

    public native boolean copyPixelsTo(Bitmap bitmap);

    public void finalize() {
        nativeFinalize();
    }

    public native void freeCache();

    public native int height();

    public Bitmap makeSnapshot() {
        Pair a2 = a.a(width(), height(), true);
        if (a2.first == null) {
            return null;
        }
        Object obj = a2.second;
        if (obj != null) {
            ((HardwareBuffer) obj).close();
        }
        if (copyPixelsTo((Bitmap) a2.first)) {
            return (Bitmap) a2.first;
        }
        return null;
    }

    public void release() {
        Surface surface;
        freeCache();
        if (this.b && (surface = this.f3422a) != null) {
            surface.release();
        }
        nativeRelease();
    }

    public native void updateSize();

    public native int width();

    public static PAGSurface FromSurface(Surface surface, EGLContext eGLContext) {
        if (surface == null) {
            return null;
        }
        long SetupFromSurfaceWithGLContext = SetupFromSurfaceWithGLContext(surface, (eGLContext == null || eGLContext == EGL14.EGL_NO_CONTEXT) ? 0 : eGLContext.getNativeHandle());
        if (SetupFromSurfaceWithGLContext == 0) {
            return null;
        }
        PAGSurface pAGSurface = new PAGSurface(SetupFromSurfaceWithGLContext);
        pAGSurface.f3422a = surface;
        return pAGSurface;
    }

    public static PAGSurface FromSurfaceTexture(SurfaceTexture surfaceTexture, EGLContext eGLContext) {
        if (surfaceTexture == null) {
            return null;
        }
        PAGSurface FromSurface = FromSurface(new Surface(surfaceTexture), eGLContext);
        if (FromSurface != null) {
            FromSurface.b = true;
        }
        return FromSurface;
    }

    public static PAGSurface FromTexture(int i, int i2, int i3, boolean z) {
        long SetupFromTexture = SetupFromTexture(i, i2, i3, z, false);
        if (SetupFromTexture == 0) {
            return null;
        }
        PAGSurface pAGSurface = new PAGSurface(SetupFromTexture);
        pAGSurface.c = i;
        return pAGSurface;
    }

    public static PAGSurface FromTextureForAsyncThread(int i, int i2, int i3, boolean z) {
        long SetupFromTexture = SetupFromTexture(i, i2, i3, z, true);
        if (SetupFromTexture == 0) {
            return null;
        }
        PAGSurface pAGSurface = new PAGSurface(SetupFromTexture);
        pAGSurface.c = i;
        return pAGSurface;
    }
}
