package androidx.transition;

import android.graphics.Matrix;
import android.graphics.RectF;

class MatrixUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Matrix f1856a = new Matrix() {
        public void a() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        public boolean postConcat(Matrix matrix) {
            a();
            return false;
        }

        public boolean postRotate(float f, float f2, float f3) {
            a();
            return false;
        }

        public boolean postScale(float f, float f2, float f3, float f4) {
            a();
            return false;
        }

        public boolean postSkew(float f, float f2, float f3, float f4) {
            a();
            return false;
        }

        public boolean postTranslate(float f, float f2) {
            a();
            return false;
        }

        public boolean preConcat(Matrix matrix) {
            a();
            return false;
        }

        public boolean preRotate(float f, float f2, float f3) {
            a();
            return false;
        }

        public boolean preScale(float f, float f2, float f3, float f4) {
            a();
            return false;
        }

        public boolean preSkew(float f, float f2, float f3, float f4) {
            a();
            return false;
        }

        public boolean preTranslate(float f, float f2) {
            a();
            return false;
        }

        public void reset() {
            a();
        }

        public void set(Matrix matrix) {
            a();
        }

        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            a();
            return false;
        }

        public boolean setPolyToPoly(float[] fArr, int i, float[] fArr2, int i2, int i3) {
            a();
            return false;
        }

        public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
            a();
            return false;
        }

        public void setRotate(float f, float f2, float f3) {
            a();
        }

        public void setScale(float f, float f2, float f3, float f4) {
            a();
        }

        public void setSinCos(float f, float f2, float f3, float f4) {
            a();
        }

        public void setSkew(float f, float f2, float f3, float f4) {
            a();
        }

        public void setTranslate(float f, float f2) {
            a();
        }

        public void setValues(float[] fArr) {
            a();
        }

        public boolean postRotate(float f) {
            a();
            return false;
        }

        public boolean postScale(float f, float f2) {
            a();
            return false;
        }

        public boolean postSkew(float f, float f2) {
            a();
            return false;
        }

        public boolean preRotate(float f) {
            a();
            return false;
        }

        public boolean preScale(float f, float f2) {
            a();
            return false;
        }

        public boolean preSkew(float f, float f2) {
            a();
            return false;
        }

        public void setRotate(float f) {
            a();
        }

        public void setScale(float f, float f2) {
            a();
        }

        public void setSinCos(float f, float f2) {
            a();
        }

        public void setSkew(float f, float f2) {
            a();
        }
    };
}
