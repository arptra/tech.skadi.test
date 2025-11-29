package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.R;

public class ImageFilterButton extends AppCompatImageButton {

    /* renamed from: a  reason: collision with root package name */
    public ImageFilterView.ImageMatrix f585a = new ImageFilterView.ImageMatrix();
    public float b = 0.0f;
    public float c = 0.0f;
    public float d = Float.NaN;
    public Path e;
    public ViewOutlineProvider f;
    public RectF g;
    public Drawable[] h = new Drawable[2];
    public LayerDrawable i;
    public boolean j = true;
    public Drawable k = null;
    public Drawable l = null;
    public float m = Float.NaN;
    public float n = Float.NaN;
    public float o = Float.NaN;
    public float p = Float.NaN;

    public ImageFilterButton(Context context) {
        super(context);
        c(context, (AttributeSet) null);
    }

    private void setOverlay(boolean z) {
        this.j = z;
    }

    public final void c(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.k = obtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.b = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.j));
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
            this.l = drawable;
            if (this.k == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.l = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.h;
                    Drawable mutate = drawable2.mutate();
                    this.l = mutate;
                    drawableArr[0] = mutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.h;
            Drawable mutate2 = getDrawable().mutate();
            this.l = mutate2;
            drawableArr2[0] = mutate2;
            this.h[1] = this.k.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.h);
            this.i = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.b * 255.0f));
            if (!this.j) {
                this.i.getDrawable(0).setAlpha((int) ((1.0f - this.b) * 255.0f));
            }
            super.setImageDrawable(this.i);
        }
    }

    public final void d() {
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

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public final void e() {
        if (!Float.isNaN(this.m) || !Float.isNaN(this.n) || !Float.isNaN(this.o) || !Float.isNaN(this.p)) {
            d();
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    public float getContrast() {
        return this.f585a.f;
    }

    public float getCrossfade() {
        return this.b;
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
        return this.d;
    }

    public float getRoundPercent() {
        return this.c;
    }

    public float getSaturation() {
        return this.f585a.e;
    }

    public float getWarmth() {
        return this.f585a.g;
    }

    public void layout(int i2, int i3, int i4, int i5) {
        super.layout(i2, i3, i4, i5);
        d();
    }

    public void setAltImageResource(int i2) {
        Drawable mutate = AppCompatResources.b(getContext(), i2).mutate();
        this.k = mutate;
        Drawable[] drawableArr = this.h;
        drawableArr[0] = this.l;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.h);
        this.i = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.b);
    }

    public void setBrightness(float f2) {
        ImageFilterView.ImageMatrix imageMatrix = this.f585a;
        imageMatrix.d = f2;
        imageMatrix.c(this);
    }

    public void setContrast(float f2) {
        ImageFilterView.ImageMatrix imageMatrix = this.f585a;
        imageMatrix.f = f2;
        imageMatrix.c(this);
    }

    public void setCrossfade(float f2) {
        this.b = f2;
        if (this.h != null) {
            if (!this.j) {
                this.i.getDrawable(0).setAlpha((int) ((1.0f - this.b) * 255.0f));
            }
            this.i.getDrawable(1).setAlpha((int) (this.b * 255.0f));
            super.setImageDrawable(this.i);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.k == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable mutate = drawable.mutate();
        this.l = mutate;
        Drawable[] drawableArr = this.h;
        drawableArr[0] = mutate;
        drawableArr[1] = this.k;
        LayerDrawable layerDrawable = new LayerDrawable(this.h);
        this.i = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.b);
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
        if (this.k != null) {
            Drawable mutate = AppCompatResources.b(getContext(), i2).mutate();
            this.l = mutate;
            Drawable[] drawableArr = this.h;
            drawableArr[0] = mutate;
            drawableArr[1] = this.k;
            LayerDrawable layerDrawable = new LayerDrawable(this.h);
            this.i = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.b);
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
            this.d = f2;
            float f3 = this.c;
            this.c = -1.0f;
            setRoundPercent(f3);
            return;
        }
        boolean z = this.d != f2;
        this.d = f2;
        if (f2 != 0.0f) {
            if (this.e == null) {
                this.e = new Path();
            }
            if (this.g == null) {
                this.g = new RectF();
            }
            if (this.f == null) {
                AnonymousClass2 r5 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.d);
                    }
                };
                this.f = r5;
                setOutlineProvider(r5);
            }
            setClipToOutline(true);
            this.g.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.e.reset();
            Path path = this.e;
            RectF rectF = this.g;
            float f4 = this.d;
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
        boolean z = this.c != f2;
        this.c = f2;
        if (f2 != 0.0f) {
            if (this.e == null) {
                this.e = new Path();
            }
            if (this.g == null) {
                this.g = new RectF();
            }
            if (this.f == null) {
                AnonymousClass1 r6 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        int width = ImageFilterButton.this.getWidth();
                        int height = ImageFilterButton.this.getHeight();
                        outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * ImageFilterButton.this.c) / 2.0f);
                    }
                };
                this.f = r6;
                setOutlineProvider(r6);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.c) / 2.0f;
            this.g.set(0.0f, 0.0f, (float) width, (float) height);
            this.e.reset();
            this.e.addRoundRect(this.g, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f2) {
        ImageFilterView.ImageMatrix imageMatrix = this.f585a;
        imageMatrix.e = f2;
        imageMatrix.c(this);
    }

    public void setWarmth(float f2) {
        ImageFilterView.ImageMatrix imageMatrix = this.f585a;
        imageMatrix.g = f2;
        imageMatrix.c(this);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(context, attributeSet);
    }
}
