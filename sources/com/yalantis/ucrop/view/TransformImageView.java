package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.yalantis.ucrop.UCropDevelopConfig;
import com.yalantis.ucrop.UCropImageEngine;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FastBitmapDrawable;
import com.yalantis.ucrop.util.FileUtils;
import com.yalantis.ucrop.util.RectUtils;

public class TransformImageView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f8766a;
    public final float[] b;
    public final float[] c;
    public Matrix d;
    public int e;
    public int f;
    public TransformImageListener g;
    public float[] h;
    public float[] i;
    public boolean j;
    public boolean k;
    public int l;
    public String m;
    public String n;
    public Uri o;
    public Uri p;
    public ExifInfo q;

    public interface TransformImageListener {
        void a();

        void b(Exception exc);

        void c(float f);

        void d(float f);
    }

    public TransformImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public float a(Matrix matrix) {
        return (float) (-(Math.atan2((double) c(matrix, 1), (double) c(matrix, 0)) * 57.29577951308232d));
    }

    public float b(Matrix matrix) {
        return (float) Math.sqrt(Math.pow((double) c(matrix, 0), 2.0d) + Math.pow((double) c(matrix, 3), 2.0d));
    }

    public float c(Matrix matrix, int i2) {
        matrix.getValues(this.c);
        return this.c[i2];
    }

    public void d() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void e() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            float intrinsicWidth = (float) drawable.getIntrinsicWidth();
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            Log.d("TransformImageView", String.format("Image size: [%d:%d]", new Object[]{Integer.valueOf((int) intrinsicWidth), Integer.valueOf((int) intrinsicHeight)}));
            RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
            this.h = RectUtils.b(rectF);
            this.i = RectUtils.a(rectF);
            this.k = true;
            TransformImageListener transformImageListener = this.g;
            if (transformImageListener != null) {
                transformImageListener.a();
            }
        }
    }

    public void f(float f2, float f3, float f4) {
        if (f2 != 0.0f) {
            this.d.postRotate(f2, f3, f4);
            setImageMatrix(this.d);
            TransformImageListener transformImageListener = this.g;
            if (transformImageListener != null) {
                transformImageListener.d(a(this.d));
            }
        }
    }

    public void g(float f2, float f3, float f4) {
        if (f2 != 0.0f) {
            this.d.postScale(f2, f2, f3, f4);
            setImageMatrix(this.d);
            TransformImageListener transformImageListener = this.g;
            if (transformImageListener != null) {
                transformImageListener.c(b(this.d));
            }
        }
    }

    public float getCurrentAngle() {
        return a(this.d);
    }

    public float getCurrentScale() {
        return b(this.d);
    }

    public ExifInfo getExifInfo() {
        return this.q;
    }

    public String getImageInputPath() {
        return this.m;
    }

    public Uri getImageInputUri() {
        return this.o;
    }

    public String getImageOutputPath() {
        return this.n;
    }

    public Uri getImageOutputUri() {
        return this.p;
    }

    public int getMaxBitmapSize() {
        if (this.l <= 0) {
            this.l = BitmapLoadUtils.a(getContext());
        }
        return this.l;
    }

    @Nullable
    public Bitmap getViewBitmap() {
        if (getDrawable() == null || !(getDrawable() instanceof FastBitmapDrawable)) {
            return null;
        }
        return ((FastBitmapDrawable) getDrawable()).a();
    }

    public void h(float f2, float f3) {
        if (f2 != 0.0f || f3 != 0.0f) {
            this.d.postTranslate(f2, f3);
            setImageMatrix(this.d);
        }
    }

    public void i(Bitmap bitmap, ExifInfo exifInfo, Uri uri, Uri uri2) {
        this.o = uri;
        this.p = uri2;
        this.m = FileUtils.j(uri.toString()) ? uri.toString() : uri.getPath();
        this.n = uri2 != null ? FileUtils.j(uri2.toString()) ? uri2.toString() : uri2.getPath() : null;
        this.q = exifInfo;
        this.j = true;
        setImageBitmap(bitmap);
    }

    public void j(Uri uri, Uri uri2, boolean z) {
        if (UCropDevelopConfig.f8727a == null || !z) {
            m(uri, uri2);
        } else {
            l(uri, uri2);
        }
    }

    public final void k() {
        this.d.mapPoints(this.f8766a, this.h);
        this.d.mapPoints(this.b, this.i);
    }

    public final void l(final Uri uri, final Uri uri2) {
        int[] i2 = BitmapLoadUtils.i(getContext(), uri);
        if (i2[0] <= 0 || i2[1] <= 0) {
            m(uri, uri2);
            return;
        }
        UCropDevelopConfig.f8727a.b(getContext(), uri, i2[0], i2[1], new UCropImageEngine.OnCallbackListener<Bitmap>() {
        });
    }

    public final void m(Uri uri, Uri uri2) {
        int maxBitmapSize = getMaxBitmapSize();
        BitmapLoadUtils.e(getContext(), uri, uri2, maxBitmapSize, maxBitmapSize, new BitmapLoadCallback() {
            public void a(Bitmap bitmap, ExifInfo exifInfo, Uri uri, Uri uri2) {
                TransformImageView.this.i(bitmap, exifInfo, uri, uri2);
            }

            public void onFailure(Exception exc) {
                Log.e("TransformImageView", "onFailure: setImageUri", exc);
                TransformImageListener transformImageListener = TransformImageView.this.g;
                if (transformImageListener != null) {
                    transformImageListener.b(exc);
                }
            }
        });
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z || (this.j && !this.k)) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.e = (getWidth() - getPaddingRight()) - paddingLeft;
            this.f = (getHeight() - getPaddingBottom()) - paddingTop;
            e();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new FastBitmapDrawable(bitmap));
    }

    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.d.set(matrix);
        k();
    }

    public void setMaxBitmapSize(int i2) {
        this.l = i2;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        } else {
            Log.w("TransformImageView", "Invalid ScaleType. Only ScaleType.MATRIX can be used");
        }
    }

    public void setTransformImageListener(TransformImageListener transformImageListener) {
        this.g = transformImageListener;
    }

    public TransformImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TransformImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8766a = new float[8];
        this.b = new float[2];
        this.c = new float[9];
        this.d = new Matrix();
        this.j = false;
        this.k = false;
        this.l = 0;
        d();
    }
}
