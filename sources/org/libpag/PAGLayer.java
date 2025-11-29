package org.libpag;

import android.graphics.Matrix;
import android.graphics.RectF;
import org.extra.tools.a;

public class PAGLayer {
    public static final int LayerTypeImage = 5;
    public static final int LayerTypeNull = 1;
    public static final int LayerTypePreCompose = 6;
    public static final int LayerTypeShape = 4;
    public static final int LayerTypeSolid = 2;
    public static final int LayerTypeText = 3;
    public static final int LayerTypeUnknown = 0;
    protected long nativeContext;

    static {
        a.e("pag");
        nativeInit();
    }

    public PAGLayer(long j) {
        this.nativeContext = j;
    }

    private native void getTotalMatrix(float[] fArr);

    private native void matrix(float[] fArr);

    private native boolean nativeEquals(PAGLayer pAGLayer);

    private static native void nativeInit();

    private native void nativeRelease();

    private native void setMatrix(float[] fArr);

    public native long currentTime();

    public native long duration();

    public native int editableIndex();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PAGLayer)) {
            return false;
        }
        return nativeEquals((PAGLayer) obj);
    }

    public native boolean excludedFromTimeline();

    public void finalize() {
        nativeRelease();
    }

    public native float frameRate();

    public native RectF getBounds();

    public native double getProgress();

    public Matrix getTotalMatrix() {
        float[] fArr = new float[9];
        getTotalMatrix(fArr);
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        return matrix;
    }

    public native long globalToLocalTime(long j);

    public int hashCode() {
        long j = this.nativeContext;
        return ((int) (j ^ (j >>> 32))) + 527;
    }

    public native String layerName();

    public native int layerType();

    public native long localTimeToGlobal(long j);

    public native PAGMarker[] markers();

    public Matrix matrix() {
        float[] fArr = new float[9];
        matrix(fArr);
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        return matrix;
    }

    public native PAGComposition parent();

    public native void resetMatrix();

    public native void setCurrentTime(long j);

    public native void setExcludedFromTimeline(boolean z);

    public void setMatrix(Matrix matrix) {
        if (matrix != null) {
            float[] fArr = new float[9];
            matrix.getValues(fArr);
            setMatrix(fArr);
        }
    }

    public native void setProgress(double d);

    public native void setStartTime(long j);

    public native void setVisible(boolean z);

    public native long startTime();

    public native PAGLayer trackMatteLayer();

    public native boolean visible();
}
