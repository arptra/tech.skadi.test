package com.yalantis.ucrop.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;
import com.yalantis.ucrop.util.DensityUtil;
import com.yalantis.ucrop.util.RectUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class OverlayView extends View {
    public boolean A;
    public OverlayViewChangeListener B;
    public ValueAnimator C;
    public boolean D;

    /* renamed from: a  reason: collision with root package name */
    public final RectF f8763a;
    public final RectF b;
    public int c;
    public int d;
    public float[] e;
    public float[] f;
    public int g;
    public int h;
    public float i;
    public float[] j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public Path o;
    public Paint p;
    public Paint q;
    public Paint r;
    public Paint s;
    public int t;
    public float u;
    public float v;
    public int w;
    public int x;
    public int y;
    public int z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FreestyleMode {
    }

    public OverlayView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void d(Canvas canvas) {
        if (this.l) {
            if (this.j == null && !this.f8763a.isEmpty()) {
                this.j = new float[((this.g * 4) + (this.h * 4))];
                int i2 = 0;
                for (int i3 = 0; i3 < this.g; i3++) {
                    float[] fArr = this.j;
                    RectF rectF = this.f8763a;
                    fArr[i2] = rectF.left;
                    float f2 = ((float) i3) + 1.0f;
                    float height = rectF.height() * (f2 / ((float) (this.g + 1)));
                    RectF rectF2 = this.f8763a;
                    fArr[i2 + 1] = height + rectF2.top;
                    float[] fArr2 = this.j;
                    int i4 = i2 + 3;
                    fArr2[i2 + 2] = rectF2.right;
                    i2 += 4;
                    fArr2[i4] = (rectF2.height() * (f2 / ((float) (this.g + 1)))) + this.f8763a.top;
                }
                for (int i5 = 0; i5 < this.h; i5++) {
                    float[] fArr3 = this.j;
                    float f3 = ((float) i5) + 1.0f;
                    float width = this.f8763a.width() * (f3 / ((float) (this.h + 1)));
                    RectF rectF3 = this.f8763a;
                    fArr3[i2] = width + rectF3.left;
                    float[] fArr4 = this.j;
                    fArr4[i2 + 1] = rectF3.top;
                    int i6 = i2 + 3;
                    float width2 = rectF3.width() * (f3 / ((float) (this.h + 1)));
                    RectF rectF4 = this.f8763a;
                    fArr4[i2 + 2] = width2 + rectF4.left;
                    i2 += 4;
                    this.j[i6] = rectF4.bottom;
                }
            }
            float[] fArr5 = this.j;
            if (fArr5 != null) {
                canvas.drawLines(fArr5, this.q);
            }
        }
        if (this.k) {
            canvas.drawRect(this.f8763a, this.r);
        }
        if (this.t != 0) {
            canvas.save();
            this.b.set(this.f8763a);
            RectF rectF5 = this.b;
            int i7 = this.z;
            rectF5.inset((float) i7, (float) (-i7));
            RectF rectF6 = this.b;
            Region.Op op = Region.Op.DIFFERENCE;
            canvas.clipRect(rectF6, op);
            this.b.set(this.f8763a);
            RectF rectF7 = this.b;
            int i8 = this.z;
            rectF7.inset((float) (-i8), (float) i8);
            canvas.clipRect(this.b, op);
            canvas.drawRect(this.f8763a, this.s);
            canvas.restore();
        }
    }

    public void e(Canvas canvas) {
        canvas.save();
        if (this.m) {
            canvas.clipPath(this.o, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.f8763a, Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.n);
        canvas.restore();
        if (this.m) {
            canvas.drawCircle(this.f8763a.centerX(), this.f8763a.centerY(), Math.min(this.f8763a.width(), this.f8763a.height()) / 2.0f, this.p);
        }
    }

    public final int f(float f2, float f3) {
        double d2 = (double) this.x;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3 += 2) {
            double sqrt = Math.sqrt(Math.pow((double) (f2 - this.e[i3]), 2.0d) + Math.pow((double) (f3 - this.e[i3 + 1]), 2.0d));
            if (sqrt < d2) {
                i2 = i3 / 2;
                d2 = sqrt;
            }
        }
        if (this.t != 1 || i2 >= 0 || !this.f8763a.contains(f2, f3)) {
            return i2;
        }
        return 4;
    }

    public void g() {
    }

    @NonNull
    public RectF getCropViewRect() {
        return this.f8763a;
    }

    public int getFreestyleCropMode() {
        return this.t;
    }

    public OverlayViewChangeListener getOverlayViewChangeListener() {
        return this.B;
    }

    public final void h(TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_frame_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width));
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_frame_color, getResources().getColor(R.color.ucrop_color_default_crop_frame));
        this.r.setStrokeWidth((float) dimensionPixelSize);
        this.r.setColor(color);
        Paint paint = this.r;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.s.setStrokeWidth((float) (dimensionPixelSize * 3));
        this.s.setColor(color);
        this.s.setStyle(style);
    }

    public final void i(TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_grid_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width));
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_grid_color, getResources().getColor(R.color.ucrop_color_default_crop_grid));
        this.q.setStrokeWidth((float) dimensionPixelSize);
        this.q.setColor(color);
        this.g = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_row_count, 2);
        this.h = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_column_count, 2);
    }

    public void j(TypedArray typedArray) {
        this.m = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_circle_dimmed_layer, false);
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_dimmed_color, getResources().getColor(R.color.ucrop_color_default_dimmed));
        this.n = color;
        this.p.setColor(color);
        this.p.setStyle(Paint.Style.STROKE);
        this.p.setStrokeWidth((float) DensityUtil.a(getContext(), 1.0f));
        h(typedArray);
        this.k = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_frame, true);
        i(typedArray);
        this.l = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_grid, true);
    }

    public void k() {
        int i2 = this.c;
        float f2 = this.i;
        int i3 = (int) (((float) i2) / f2);
        int i4 = this.d;
        if (i3 > i4) {
            int i5 = (int) (((float) i4) * f2);
            int i6 = (i2 - i5) / 2;
            this.f8763a.set((float) (getPaddingLeft() + i6), (float) getPaddingTop(), (float) (getPaddingLeft() + i5 + i6), (float) (getPaddingTop() + this.d));
        } else {
            int i7 = (i4 - i3) / 2;
            this.f8763a.set((float) getPaddingLeft(), (float) (getPaddingTop() + i7), (float) (getPaddingLeft() + this.c), (float) (getPaddingTop() + i3 + i7));
        }
        OverlayViewChangeListener overlayViewChangeListener = this.B;
        if (overlayViewChangeListener != null) {
            overlayViewChangeListener.b(this.f8763a);
        }
        n();
    }

    public final void l() {
        Point point = new Point((getRight() + getLeft()) / 2, (getTop() + getBottom()) / 2);
        final int centerY = (int) (((float) point.y) - this.f8763a.centerY());
        final int centerX = (int) (((float) point.x) - this.f8763a.centerX());
        final RectF rectF = new RectF(this.f8763a);
        new RectF(this.f8763a).offset((float) centerX, (float) centerY);
        ValueAnimator valueAnimator = this.C;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.C = ofFloat;
        ofFloat.setDuration(1000);
        this.C.setInterpolator(new OvershootInterpolator(1.0f));
        this.C.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (OverlayView.this.B != null) {
                    OverlayView.this.B.b(OverlayView.this.f8763a);
                }
            }
        });
        this.C.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            /* renamed from: a  reason: collision with root package name */
            public float f8765a = 0.0f;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((float) centerX) * ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float floatValue2 = ((float) centerY) * ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RectF b2 = OverlayView.this.f8763a;
                RectF rectF = rectF;
                b2.set(new RectF(rectF.left + floatValue, rectF.top + floatValue2, rectF.right + floatValue, rectF.bottom + floatValue2));
                OverlayView.this.n();
                OverlayView.this.postInvalidate();
                if (OverlayView.this.B != null) {
                    OverlayView.this.B.a(((float) centerX) * (((Float) valueAnimator.getAnimatedValue()).floatValue() - this.f8765a), ((float) centerY) * (((Float) valueAnimator.getAnimatedValue()).floatValue() - this.f8765a));
                }
                this.f8765a = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.C.start();
    }

    public final void m(float f2, float f3) {
        this.b.set(this.f8763a);
        int i2 = this.w;
        boolean z2 = true;
        if (i2 == 0) {
            RectF rectF = this.b;
            RectF rectF2 = this.f8763a;
            rectF.set(f2, f3, rectF2.right, rectF2.bottom);
        } else if (i2 == 1) {
            RectF rectF3 = this.b;
            RectF rectF4 = this.f8763a;
            rectF3.set(rectF4.left, f3, f2, rectF4.bottom);
        } else if (i2 == 2) {
            RectF rectF5 = this.b;
            RectF rectF6 = this.f8763a;
            rectF5.set(rectF6.left, rectF6.top, f2, f3);
        } else if (i2 == 3) {
            RectF rectF7 = this.b;
            RectF rectF8 = this.f8763a;
            rectF7.set(f2, rectF8.top, rectF8.right, f3);
        } else if (i2 == 4) {
            this.b.offset(f2 - this.u, f3 - this.v);
            if (this.b.left > ((float) getLeft()) && this.b.top > ((float) getTop()) && this.b.right < ((float) getRight()) && this.b.bottom < ((float) getBottom())) {
                this.f8763a.set(this.b);
                n();
                postInvalidate();
                return;
            }
            return;
        }
        boolean z3 = this.b.height() >= ((float) this.y);
        if (this.b.width() < ((float) this.y)) {
            z2 = false;
        }
        RectF rectF9 = this.f8763a;
        rectF9.set(z2 ? this.b.left : rectF9.left, z3 ? this.b.top : rectF9.top, z2 ? this.b.right : rectF9.right, z3 ? this.b.bottom : rectF9.bottom);
        if (z3 || z2) {
            n();
            postInvalidate();
        }
    }

    public final void n() {
        this.e = RectUtils.b(this.f8763a);
        this.f = RectUtils.a(this.f8763a);
        this.j = null;
        this.o.reset();
        this.o.addCircle(this.f8763a.centerX(), this.f8763a.centerY(), Math.min(this.f8763a.width(), this.f8763a.height()) / 2.0f, Path.Direction.CW);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        e(canvas);
        d(canvas);
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (z2) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.c = (getWidth() - getPaddingRight()) - paddingLeft;
            this.d = (getHeight() - getPaddingBottom()) - paddingTop;
            if (this.D) {
                this.D = false;
                setTargetAspectRatio(this.i);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2 = false;
        if (!this.f8763a.isEmpty() && this.t != 0) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if ((motionEvent.getAction() & 255) == 0) {
                int f2 = f(x2, y2);
                this.w = f2;
                if (f2 != -1) {
                    z2 = true;
                }
                if (!z2) {
                    this.u = -1.0f;
                    this.v = -1.0f;
                } else if (this.u < 0.0f) {
                    this.u = x2;
                    this.v = y2;
                }
                return z2;
            } else if ((motionEvent.getAction() & 255) == 2 && motionEvent.getPointerCount() == 1 && this.w != -1) {
                float min = Math.min(Math.max(x2, (float) getPaddingLeft()), (float) (getWidth() - getPaddingRight()));
                float min2 = Math.min(Math.max(y2, (float) getPaddingTop()), (float) (getHeight() - getPaddingBottom()));
                m(min, min2);
                this.u = min;
                this.v = min2;
                return true;
            } else if ((motionEvent.getAction() & 255) == 1) {
                this.u = -1.0f;
                this.v = -1.0f;
                this.w = -1;
                OverlayViewChangeListener overlayViewChangeListener = this.B;
                if (overlayViewChangeListener != null) {
                    overlayViewChangeListener.b(this.f8763a);
                }
                if (this.A) {
                    l();
                }
            }
        }
        return false;
    }

    public void setCircleDimmedLayer(boolean z2) {
        this.m = z2;
    }

    public void setCircleStrokeColor(@ColorInt int i2) {
        this.p.setColor(i2);
    }

    public void setCropFrameColor(@ColorInt int i2) {
        this.r.setColor(i2);
    }

    public void setCropFrameStrokeWidth(@IntRange int i2) {
        this.r.setStrokeWidth((float) i2);
    }

    public void setCropGridColor(@ColorInt int i2) {
        this.q.setColor(i2);
    }

    public void setCropGridColumnCount(@IntRange int i2) {
        this.h = i2;
        this.j = null;
    }

    public void setCropGridRowCount(@IntRange int i2) {
        this.g = i2;
        this.j = null;
    }

    public void setCropGridStrokeWidth(@IntRange int i2) {
        this.q.setStrokeWidth((float) i2);
    }

    public void setDimmedColor(@ColorInt int i2) {
        this.n = i2;
    }

    public void setDimmedStrokeWidth(@IntRange int i2) {
        this.p.setStrokeWidth((float) i2);
    }

    public void setDragSmoothToCenter(boolean z2) {
        this.A = z2;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean z2) {
        this.t = z2 ? 1 : 0;
    }

    public void setFreestyleCropMode(int i2) {
        this.t = i2;
        postInvalidate();
    }

    public void setOverlayViewChangeListener(OverlayViewChangeListener overlayViewChangeListener) {
        this.B = overlayViewChangeListener;
    }

    public void setShowCropFrame(boolean z2) {
        this.k = z2;
    }

    public void setShowCropGrid(boolean z2) {
        this.l = z2;
    }

    public void setTargetAspectRatio(float f2) {
        this.i = f2;
        if (this.c > 0) {
            k();
            postInvalidate();
            return;
        }
        this.D = true;
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8763a = new RectF();
        this.b = new RectF();
        this.j = null;
        this.o = new Path();
        this.p = new Paint(1);
        this.q = new Paint(1);
        this.r = new Paint(1);
        this.s = new Paint(1);
        this.t = 0;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1;
        this.x = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_threshold);
        this.y = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_min_size);
        this.z = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
        g();
    }
}
