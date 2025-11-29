package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R;

public class ImageFilterView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    public ImageMatrix f588a = new ImageMatrix();
    public boolean b = true;
    public Drawable c = null;
    public Drawable d = null;
    public float e = 0.0f;
    public float f = 0.0f;
    public float g = Float.NaN;
    public Path h;
    public ViewOutlineProvider i;
    public RectF j;
    public Drawable[] k = new Drawable[2];
    public LayerDrawable l;
    public float m = Float.NaN;
    public float n = Float.NaN;
    public float o = Float.NaN;
    public float p = Float.NaN;

    public static class ImageMatrix {

        /* renamed from: a  reason: collision with root package name */
        public float[] f591a = new float[20];
        public ColorMatrix b = new ColorMatrix();
        public ColorMatrix c = new ColorMatrix();
        public float d = 1.0f;
        public float e = 1.0f;
        public float f = 1.0f;
        public float g = 1.0f;

        public final void a(float f2) {
            float[] fArr = this.f591a;
            fArr[0] = f2;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f2;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f2;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        public final void b(float f2) {
            float f3 = 1.0f - f2;
            float f4 = 0.2999f * f3;
            float f5 = 0.587f * f3;
            float f6 = f3 * 0.114f;
            float[] fArr = this.f591a;
            fArr[0] = f4 + f2;
            fArr[1] = f5;
            fArr[2] = f6;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f4;
            fArr[6] = f5 + f2;
            fArr[7] = f6;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f4;
            fArr[11] = f5;
            fArr[12] = f6 + f2;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        public void c(ImageView imageView) {
            boolean z;
            this.b.reset();
            float f2 = this.e;
            boolean z2 = true;
            if (f2 != 1.0f) {
                b(f2);
                this.b.set(this.f591a);
                z = true;
            } else {
                z = false;
            }
            float f3 = this.f;
            if (f3 != 1.0f) {
                this.c.setScale(f3, f3, f3, 1.0f);
                this.b.postConcat(this.c);
                z = true;
            }
            float f4 = this.g;
            if (f4 != 1.0f) {
                d(f4);
                this.c.set(this.f591a);
                this.b.postConcat(this.c);
                z = true;
            }
            float f5 = this.d;
            if (f5 != 1.0f) {
                a(f5);
                this.c.set(this.f591a);
                this.b.postConcat(this.c);
            } else {
                z2 = z;
            }
            if (z2) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.b));
            } else {
                imageView.clearColorFilter();
            }
        }

        public final void d(float f2) {
            float f3;
            float f4;
            if (f2 <= 0.0f) {
                f2 = 0.01f;
            }
            float f5 = (5000.0f / f2) / 100.0f;
            if (f5 > 66.0f) {
                double d2 = (double) (f5 - 60.0f);
                f4 = ((float) Math.pow(d2, -0.13320475816726685d)) * 329.69873f;
                f3 = ((float) Math.pow(d2, 0.07551484555006027d)) * 288.12216f;
            } else {
                f3 = (((float) Math.log((double) f5)) * 99.4708f) - 161.11957f;
                f4 = 255.0f;
            }
            float log = f5 < 66.0f ? f5 > 19.0f ? (((float) Math.log((double) (f5 - 10.0f))) * 138.51773f) - 305.0448f : 0.0f : 255.0f;
            float min = Math.min(255.0f, Math.max(f4, 0.0f));
            float min2 = Math.min(255.0f, Math.max(f3, 0.0f));
            float min3 = Math.min(255.0f, Math.max(log, 0.0f));
            float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float min5 = Math.min(255.0f, Math.max((((float) Math.log((double) 50.0f)) * 99.4708f) - 161.11957f, 0.0f));
            float[] fArr = this.f591a;
            fArr[0] = min / min4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = min2 / min5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = min3 / Math.min(255.0f, Math.max((((float) Math.log((double) 40.0f)) * 138.51773f) - 305.0448f, 0.0f));
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }
    }

    public ImageFilterView(Context context) {
        super(context);
        c(context, (AttributeSet) null);
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.c = obtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.e = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_brightness) {
                    setBrightness(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.b));
                } else if (index == R.styleable.ImageFilterView_imagePanX) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.m));
                } else if (index == R.styleable.ImageFilterView_imagePanY) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.n));
                } else if (index == R.styleable.ImageFilterView_imageRotate) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.p));
                } else if (index == R.styleable.ImageFilterView_imageZoom) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.o));
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.d = drawable;
            if (this.c == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.d = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.k;
                    Drawable mutate = drawable2.mutate();
                    this.d = mutate;
                    drawableArr[0] = mutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.k;
            Drawable mutate2 = getDrawable().mutate();
            this.d = mutate2;
            drawableArr2[0] = mutate2;
            this.k[1] = this.c.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.k);
            this.l = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.e * 255.0f));
            if (!this.b) {
                this.l.getDrawable(0).setAlpha((int) ((1.0f - this.e) * 255.0f));
            }
            super.setImageDrawable(this.l);
        }
    }

    private void d() {
        if (!Float.isNaN(this.m) || !Float.isNaN(this.n) || !Float.isNaN(this.o) || !Float.isNaN(this.p)) {
            float f2 = 0.0f;
            float f3 = Float.isNaN(this.m) ? 0.0f : this.m;
            float f4 = Float.isNaN(this.n) ? 0.0f : this.n;
            float f5 = Float.isNaN(this.o) ? 1.0f : this.o;
            if (!Float.isNaN(this.p)) {
                f2 = this.p;
            }
            Matrix matrix = new Matrix();
            matrix.reset();
            float intrinsicWidth = (float) getDrawable().getIntrinsicWidth();
            float intrinsicHeight = (float) getDrawable().getIntrinsicHeight();
            float width = (float) getWidth();
            float height = (float) getHeight();
            float f6 = f5 * (intrinsicWidth * height < intrinsicHeight * width ? width / intrinsicWidth : height / intrinsicHeight);
            matrix.postScale(f6, f6);
            float f7 = intrinsicWidth * f6;
            float f8 = f6 * intrinsicHeight;
            matrix.postTranslate((((f3 * (width - f7)) + width) - f7) * 0.5f, (((f4 * (height - f8)) + height) - f8) * 0.5f);
            matrix.postRotate(f2, width / 2.0f, height / 2.0f);
            setImageMatrix(matrix);
            setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    private void e() {
        if (!Float.isNaN(this.m) || !Float.isNaN(this.n) || !Float.isNaN(this.o) || !Float.isNaN(this.p)) {
            d();
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    private void setOverlay(boolean z) {
        this.b = z;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getBrightness() {
        return this.f588a.d;
    }

    public float getContrast() {
        return this.f588a.f;
    }

    public float getCrossfade() {
        return this.e;
    }

    public float getImagePanX() {
        return this.m;
    }

    public float getImagePanY() {
        return this.n;
    }

    public float getImageRotate() {
        return this.p;
    }

    public float getImageZoom() {
        return this.o;
    }

    public float getRound() {
        return this.g;
    }

    public float getRoundPercent() {
        return this.f;
    }

    public float getSaturation() {
        return this.f588a.e;
    }

    public float getWarmth() {
        return this.f588a.g;
    }

    public void layout(int i2, int i3, int i4, int i5) {
        super.layout(i2, i3, i4, i5);
        d();
    }

    public void setAltImageResource(int i2) {
        Drawable mutate = AppCompatResources.b(getContext(), i2).mutate();
        this.c = mutate;
        Drawable[] drawableArr = this.k;
        drawableArr[0] = this.d;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.k);
        this.l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.e);
    }

    public void setBrightness(float f2) {
        ImageMatrix imageMatrix = this.f588a;
        imageMatrix.d = f2;
        imageMatrix.c(this);
    }

    public void setContrast(float f2) {
        ImageMatrix imageMatrix = this.f588a;
        imageMatrix.f = f2;
        imageMatrix.c(this);
    }

    public void setCrossfade(float f2) {
        this.e = f2;
        if (this.k != null) {
            if (!this.b) {
                this.l.getDrawable(0).setAlpha((int) ((1.0f - this.e) * 255.0f));
            }
            this.l.getDrawable(1).setAlpha((int) (this.e * 255.0f));
            super.setImageDrawable(this.l);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.c == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable mutate = drawable.mutate();
        this.d = mutate;
        Drawable[] drawableArr = this.k;
        drawableArr[0] = mutate;
        drawableArr[1] = this.c;
        LayerDrawable layerDrawable = new LayerDrawable(this.k);
        this.l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.e);
    }

    public void setImagePanX(float f2) {
        this.m = f2;
        e();
    }

    public void setImagePanY(float f2) {
        this.n = f2;
        e();
    }

    public void setImageResource(int i2) {
        if (this.c != null) {
            Drawable mutate = AppCompatResources.b(getContext(), i2).mutate();
            this.d = mutate;
            Drawable[] drawableArr = this.k;
            drawableArr[0] = mutate;
            drawableArr[1] = this.c;
            LayerDrawable layerDrawable = new LayerDrawable(this.k);
            this.l = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.e);
            return;
        }
        super.setImageResource(i2);
    }

    public void setImageRotate(float f2) {
        this.p = f2;
        e();
    }

    public void setImageZoom(float f2) {
        this.o = f2;
        e();
    }

    @RequiresApi
    public void setRound(float f2) {
        if (Float.isNaN(f2)) {
            this.g = f2;
            float f3 = this.f;
            this.f = -1.0f;
            setRoundPercent(f3);
            return;
        }
        boolean z = this.g != f2;
        this.g = f2;
        if (f2 != 0.0f) {
            if (this.h == null) {
                this.h = new Path();
            }
            if (this.j == null) {
                this.j = new RectF();
            }
            if (this.i == null) {
                AnonymousClass2 r5 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.g);
                    }
                };
                this.i = r5;
                setOutlineProvider(r5);
            }
            setClipToOutline(true);
            this.j.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.h.reset();
            Path path = this.h;
            RectF rectF = this.j;
            float f4 = this.g;
            path.addRoundRect(rectF, f4, f4, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    @RequiresApi
    public void setRoundPercent(float f2) {
        boolean z = this.f != f2;
        this.f = f2;
        if (f2 != 0.0f) {
            if (this.h == null) {
                this.h = new Path();
            }
            if (this.j == null) {
                this.j = new RectF();
            }
            if (this.i == null) {
                AnonymousClass1 r6 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        int width = ImageFilterView.this.getWidth();
                        int height = ImageFilterView.this.getHeight();
                        outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * ImageFilterView.this.f) / 2.0f);
                    }
                };
                this.i = r6;
                setOutlineProvider(r6);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.f) / 2.0f;
            this.j.set(0.0f, 0.0f, (float) width, (float) height);
            this.h.reset();
            this.h.addRoundRect(this.j, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f2) {
        ImageMatrix imageMatrix = this.f588a;
        imageMatrix.e = f2;
        imageMatrix.c(this);
    }

    public void setWarmth(float f2) {
        ImageMatrix imageMatrix = this.f588a;
        imageMatrix.g = f2;
        imageMatrix.c(this);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(context, attributeSet);
    }
}
