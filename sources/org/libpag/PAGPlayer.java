package org.libpag;

import android.graphics.Matrix;
import android.graphics.RectF;
import org.extra.tools.a;
import org.extra.tools.e;

public class PAGPlayer {

    /* renamed from: a  reason: collision with root package name */
    private PAGSurface f3421a = null;
    private long nativeContext = 0;

    static {
        a.e("ffavc");
        a.e("pag");
        nativeInit();
    }

    public PAGPlayer() {
        nativeSetup();
        e.e();
    }

    private native void nativeFinalize();

    private native void nativeGetMatrix(float[] fArr);

    private static final native void nativeInit();

    private final native void nativeRelease();

    private native void nativeSetMatrix(float f, float f2, float f3, float f4, float f5, float f6);

    private native void nativeSetSurface(long j);

    private final native void nativeSetup();

    public native boolean cacheEnabled();

    public native float cacheScale();

    public native long currentFrame();

    public native long duration();

    public void finalize() {
        nativeFinalize();
    }

    public boolean flush() {
        return flushAndFenceSync((long[]) null);
    }

    public native boolean flushAndFenceSync(long[] jArr);

    public native RectF getBounds(PAGLayer pAGLayer);

    public native PAGComposition getComposition();

    public native PAGLayer[] getLayersUnderPoint(float f, float f2);

    public native double getProgress();

    public PAGSurface getSurface() {
        return this.f3421a;
    }

    public native boolean hitTestPoint(PAGLayer pAGLayer, float f, float f2, boolean z);

    public Matrix matrix() {
        float[] fArr = new float[9];
        nativeGetMatrix(fArr);
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        return matrix;
    }

    public native float maxFrameRate();

    public native void prepare();

    public void release() {
        nativeRelease();
    }

    public native int scaleMode();

    public native void setCacheEnabled(boolean z);

    public native void setCacheScale(float f);

    public native void setComposition(PAGComposition pAGComposition);

    public void setMatrix(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        nativeSetMatrix(fArr[0], fArr[3], fArr[1], fArr[4], fArr[2], fArr[5]);
    }

    public native void setMaxFrameRate(float f);

    public native void setProgress(double d);

    public native void setScaleMode(int i);

    public void setSurface(PAGSurface pAGSurface) {
        this.f3421a = pAGSurface;
        if (pAGSurface == null) {
            nativeSetSurface(0);
        } else {
            nativeSetSurface(pAGSurface.nativeSurface);
        }
    }

    public native void setUseDiskCache(boolean z);

    public native void setVideoEnabled(boolean z);

    public native boolean useDiskCache();

    public native boolean videoEnabled();

    public native boolean waitSync(long j);
}
