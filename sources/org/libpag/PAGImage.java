package org.libpag;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import org.extra.tools.a;

public class PAGImage {
    long nativeContext;

    static {
        a.e("pag");
        nativeInit();
    }

    public PAGImage(long j) {
        this.nativeContext = j;
    }

    public static PAGImage FromAssets(AssetManager assetManager, String str) {
        long LoadFromAssets = LoadFromAssets(assetManager, str);
        if (LoadFromAssets == 0) {
            return null;
        }
        return new PAGImage(LoadFromAssets);
    }

    public static PAGImage FromBitmap(Bitmap bitmap) {
        if (bitmap != null && bitmap.getConfig() == Bitmap.Config.ARGB_4444) {
            bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, false);
        }
        long LoadFromBitmap = LoadFromBitmap(bitmap);
        if (LoadFromBitmap == 0) {
            return null;
        }
        return new PAGImage(LoadFromBitmap);
    }

    public static PAGImage FromBytes(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        long LoadFromBytes = LoadFromBytes(bArr, bArr.length);
        if (LoadFromBytes == 0) {
            return null;
        }
        return new PAGImage(LoadFromBytes);
    }

    public static PAGImage FromPath(String str) {
        long LoadFromPath = LoadFromPath(str);
        if (LoadFromPath == 0) {
            return null;
        }
        return new PAGImage(LoadFromPath);
    }

    public static PAGImage FromTexture(int i, int i2, int i3, int i4) {
        return FromTexture(i, i2, i3, i4, false);
    }

    private static native long LoadFromAssets(AssetManager assetManager, String str);

    private static native long LoadFromBitmap(Bitmap bitmap);

    private static native long LoadFromBytes(byte[] bArr, int i);

    private static native long LoadFromPath(String str);

    private static native long LoadFromTexture(int i, int i2, int i3, int i4, boolean z);

    private native void nativeFinalize();

    private native void nativeGetMatrix(float[] fArr);

    private static final native void nativeInit();

    private final native void nativeRelease();

    private native void nativeSetMatrix(float f, float f2, float f3, float f4, float f5, float f6);

    public void finalize() {
        nativeFinalize();
    }

    public native int height();

    public Matrix matrix() {
        float[] fArr = new float[9];
        nativeGetMatrix(fArr);
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        return matrix;
    }

    public void release() {
        nativeRelease();
    }

    public native int scaleMode();

    public void setMatrix(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        nativeSetMatrix(fArr[0], fArr[3], fArr[1], fArr[4], fArr[2], fArr[5]);
    }

    public native void setScaleMode(int i);

    public native int width();

    public static PAGImage FromTexture(int i, int i2, int i3, int i4, boolean z) {
        long LoadFromTexture = LoadFromTexture(i, i2, i3, i4, z);
        if (LoadFromTexture == 0) {
            return null;
        }
        return new PAGImage(LoadFromTexture);
    }
}
