package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.AttributeSet;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.task.BitmapCropTask;
import com.yalantis.ucrop.util.CubicEasing;
import com.yalantis.ucrop.util.RectUtils;
import com.yalantis.ucrop.view.TransformImageView;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class CropImageView extends TransformImageView {
    public int A;
    public int B;
    public long C;
    public final RectF r;
    public final Matrix s;
    public float t;
    public float u;
    public CropBoundsChangeListener v;
    public Runnable w;
    public Runnable x;
    public float y;
    public float z;

    public static class WrapCropBoundsRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference f8758a;
        public final long b;
        public final long c = System.currentTimeMillis();
        public final float d;
        public final float e;
        public final float f;
        public final float g;
        public final float h;
        public final float i;
        public final boolean j;

        public WrapCropBoundsRunnable(CropImageView cropImageView, long j2, float f2, float f3, float f4, float f5, float f6, float f7, boolean z) {
            this.f8758a = new WeakReference(cropImageView);
            this.b = j2;
            this.d = f2;
            this.e = f3;
            this.f = f4;
            this.g = f5;
            this.h = f6;
            this.i = f7;
            this.j = z;
        }

        public void run() {
            CropImageView cropImageView = (CropImageView) this.f8758a.get();
            if (cropImageView != null) {
                float min = (float) Math.min(this.b, System.currentTimeMillis() - this.c);
                float b2 = CubicEasing.b(min, 0.0f, this.f, (float) this.b);
                float b3 = CubicEasing.b(min, 0.0f, this.g, (float) this.b);
                float a2 = CubicEasing.a(min, 0.0f, this.i, (float) this.b);
                if (min < ((float) this.b)) {
                    float[] fArr = cropImageView.b;
                    cropImageView.h(b2 - (fArr[0] - this.d), b3 - (fArr[1] - this.e));
                    if (!this.j) {
                        cropImageView.B(this.h + a2, cropImageView.r.centerX(), cropImageView.r.centerY());
                    }
                    if (!cropImageView.t()) {
                        cropImageView.post(this);
                    }
                }
            }
        }
    }

    public static class ZoomImageToPosition implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference f8759a;
        public final long b;
        public final long c = System.currentTimeMillis();
        public final float d;
        public final float e;
        public final float f;
        public final float g;

        public ZoomImageToPosition(CropImageView cropImageView, long j, float f2, float f3, float f4, float f5) {
            this.f8759a = new WeakReference(cropImageView);
            this.b = j;
            this.d = f2;
            this.e = f3;
            this.f = f4;
            this.g = f5;
        }

        public void run() {
            CropImageView cropImageView = (CropImageView) this.f8759a.get();
            if (cropImageView != null) {
                float min = (float) Math.min(this.b, System.currentTimeMillis() - this.c);
                float a2 = CubicEasing.a(min, 0.0f, this.e, (float) this.b);
                if (min < ((float) this.b)) {
                    cropImageView.B(this.d + a2, this.f, this.g);
                    cropImageView.post(this);
                    return;
                }
                cropImageView.x();
            }
        }
    }

    public CropImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void A(float f) {
        B(f, this.r.centerX(), this.r.centerY());
    }

    public void B(float f, float f2, float f3) {
        if (f <= getMaxScale()) {
            g(f / getCurrentScale(), f2, f3);
        }
    }

    public void C(float f) {
        D(f, this.r.centerX(), this.r.centerY());
    }

    public void D(float f, float f2, float f3) {
        if (f >= getMinScale()) {
            g(f / getCurrentScale(), f2, f3);
        }
    }

    public void e() {
        super.e();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            float intrinsicWidth = (float) drawable.getIntrinsicWidth();
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            if (this.t == 0.0f) {
                this.t = intrinsicWidth / intrinsicHeight;
            }
            int i = this.e;
            float f = this.t;
            int i2 = (int) (((float) i) / f);
            int i3 = this.f;
            if (i2 > i3) {
                int i4 = (int) (((float) i3) * f);
                int i5 = (i - i4) / 2;
                this.r.set((float) i5, 0.0f, (float) (i4 + i5), (float) i3);
            } else {
                int i6 = (i3 - i2) / 2;
                this.r.set(0.0f, (float) i6, (float) i, (float) (i2 + i6));
            }
            q(intrinsicWidth, intrinsicHeight);
            y(intrinsicWidth, intrinsicHeight);
            CropBoundsChangeListener cropBoundsChangeListener = this.v;
            if (cropBoundsChangeListener != null) {
                cropBoundsChangeListener.a(this.t);
            }
            TransformImageView.TransformImageListener transformImageListener = this.g;
            if (transformImageListener != null) {
                transformImageListener.c(getCurrentScale());
                this.g.d(getCurrentAngle());
            }
        }
    }

    public void g(float f, float f2, float f3) {
        if (f > 1.0f && getCurrentScale() * f <= getMaxScale()) {
            super.g(f, f2, f3);
        } else if (f < 1.0f && getCurrentScale() * f >= getMinScale()) {
            super.g(f, f2, f3);
        }
    }

    @Nullable
    public CropBoundsChangeListener getCropBoundsChangeListener() {
        return this.v;
    }

    public float getMaxScale() {
        return this.y;
    }

    public float getMinScale() {
        return this.z;
    }

    public float getTargetAspectRatio() {
        return this.t;
    }

    public final float[] o() {
        this.s.reset();
        this.s.setRotate(-getCurrentAngle());
        float[] fArr = this.f8766a;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        float[] b = RectUtils.b(this.r);
        this.s.mapPoints(copyOf);
        this.s.mapPoints(b);
        RectF d = RectUtils.d(copyOf);
        RectF d2 = RectUtils.d(b);
        float f = d.left - d2.left;
        float f2 = d.top - d2.top;
        float f3 = d.right - d2.right;
        float f4 = d.bottom - d2.bottom;
        if (f <= 0.0f) {
            f = 0.0f;
        }
        if (f2 <= 0.0f) {
            f2 = 0.0f;
        }
        if (f3 >= 0.0f) {
            f3 = 0.0f;
        }
        if (f4 >= 0.0f) {
            f4 = 0.0f;
        }
        float[] fArr2 = {f, f2, f3, f4};
        this.s.reset();
        this.s.setRotate(getCurrentAngle());
        this.s.mapPoints(fArr2);
        return fArr2;
    }

    public final void p() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            q((float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        }
    }

    public final void q(float f, float f2) {
        float min = Math.min(Math.min(this.r.width() / f, this.r.width() / f2), Math.min(this.r.height() / f2, this.r.height() / f));
        this.z = min;
        this.y = min * this.u;
    }

    public void r() {
        removeCallbacks(this.w);
        removeCallbacks(this.x);
    }

    public void s(Bitmap.CompressFormat compressFormat, int i, BitmapCropCallback bitmapCropCallback) {
        r();
        setImageToWrapCropBounds(false);
        ImageState imageState = new ImageState(this.r, RectUtils.d(this.f8766a), getCurrentScale(), getCurrentAngle());
        CropParameters cropParameters = new CropParameters(this.A, this.B, compressFormat, i, getImageInputPath(), getImageOutputPath(), getExifInfo());
        cropParameters.j(getImageInputUri());
        cropParameters.k(getImageOutputUri());
        new BitmapCropTask(getContext(), getViewBitmap(), imageState, cropParameters, bitmapCropCallback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void setCropBoundsChangeListener(@Nullable CropBoundsChangeListener cropBoundsChangeListener) {
        this.v = cropBoundsChangeListener;
    }

    public void setCropRect(RectF rectF) {
        this.t = rectF.width() / rectF.height();
        this.r.set(rectF.left - ((float) getPaddingLeft()), rectF.top - ((float) getPaddingTop()), rectF.right - ((float) getPaddingRight()), rectF.bottom - ((float) getPaddingBottom()));
        p();
        x();
    }

    public void setImageToWrapCropBounds(boolean z2) {
        float f;
        float f2;
        float f3;
        if (this.k && !t()) {
            float[] fArr = this.b;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float currentScale = getCurrentScale();
            float centerX = this.r.centerX() - f4;
            float centerY = this.r.centerY() - f5;
            this.s.reset();
            this.s.setTranslate(centerX, centerY);
            float[] fArr2 = this.f8766a;
            float[] copyOf = Arrays.copyOf(fArr2, fArr2.length);
            this.s.mapPoints(copyOf);
            boolean u2 = u(copyOf);
            if (u2) {
                float[] o = o();
                f2 = -(o[1] + o[3]);
                f3 = -(o[0] + o[2]);
                f = 0.0f;
            } else {
                RectF rectF = new RectF(this.r);
                this.s.reset();
                this.s.setRotate(getCurrentAngle());
                this.s.mapRect(rectF);
                float[] c = RectUtils.c(this.f8766a);
                f3 = centerX;
                f = (Math.max(rectF.width() / c[0], rectF.height() / c[1]) * currentScale) - currentScale;
                f2 = centerY;
            }
            if (z2) {
                WrapCropBoundsRunnable wrapCropBoundsRunnable = new WrapCropBoundsRunnable(this, this.C, f4, f5, f3, f2, currentScale, f, u2);
                this.w = wrapCropBoundsRunnable;
                post(wrapCropBoundsRunnable);
                return;
            }
            h(f3, f2);
            if (!u2) {
                B(currentScale + f, this.r.centerX(), this.r.centerY());
            }
        }
    }

    public void setImageToWrapCropBoundsAnimDuration(@IntRange long j) {
        if (j > 0) {
            this.C = j;
            return;
        }
        throw new IllegalArgumentException("Animation duration cannot be negative value.");
    }

    public void setMaxResultImageSizeX(@IntRange int i) {
        this.A = i;
    }

    public void setMaxResultImageSizeY(@IntRange int i) {
        this.B = i;
    }

    public void setMaxScaleMultiplier(float f) {
        this.u = f;
    }

    public void setTargetAspectRatio(float f) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            this.t = f;
            return;
        }
        if (f == 0.0f) {
            this.t = ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
        } else {
            this.t = f;
        }
        CropBoundsChangeListener cropBoundsChangeListener = this.v;
        if (cropBoundsChangeListener != null) {
            cropBoundsChangeListener.a(this.t);
        }
    }

    public boolean t() {
        return u(this.f8766a);
    }

    public boolean u(float[] fArr) {
        this.s.reset();
        this.s.setRotate(-getCurrentAngle());
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        this.s.mapPoints(copyOf);
        float[] b = RectUtils.b(this.r);
        this.s.mapPoints(b);
        return RectUtils.d(copyOf).contains(RectUtils.d(b));
    }

    public void v(float f) {
        f(f, this.r.centerX(), this.r.centerY());
    }

    public void w(TypedArray typedArray) {
        float abs = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_x, 0.0f));
        float abs2 = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_y, 0.0f));
        if (abs == 0.0f || abs2 == 0.0f) {
            this.t = 0.0f;
        } else {
            this.t = abs / abs2;
        }
    }

    public void x() {
        setImageToWrapCropBounds(true);
    }

    public final void y(float f, float f2) {
        float width = this.r.width();
        float height = this.r.height();
        float max = Math.max(this.r.width() / f, this.r.height() / f2);
        RectF rectF = this.r;
        float f3 = ((height - (f2 * max)) / 2.0f) + rectF.top;
        this.d.reset();
        this.d.postScale(max, max);
        this.d.postTranslate(((width - (f * max)) / 2.0f) + rectF.left, f3);
        setImageMatrix(this.d);
    }

    public void z(float f, float f2, float f3, long j) {
        if (f > getMaxScale()) {
            f = getMaxScale();
        }
        float currentScale = getCurrentScale();
        ZoomImageToPosition zoomImageToPosition = new ZoomImageToPosition(this, j, currentScale, f - currentScale, f2, f3);
        this.x = zoomImageToPosition;
        post(zoomImageToPosition);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.r = new RectF();
        this.s = new Matrix();
        this.u = 10.0f;
        this.x = null;
        this.A = 0;
        this.B = 0;
        this.C = 500;
    }
}
