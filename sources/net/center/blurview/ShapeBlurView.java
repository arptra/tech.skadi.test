package net.center.blurview;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import io.netty.handler.codec.http2.Http2CodecUtil;
import net.center.blurview.impl.AndroidStockBlurImpl;
import net.center.blurview.impl.AndroidXBlurImpl;
import net.center.blurview.impl.BlurImpl;
import net.center.blurview.impl.EmptyBlurImpl;
import net.center.blurview.impl.SupportLibraryBlurImpl;

public class ShapeBlurView extends View {
    public static int D;
    public static int E;
    public static StopException F = new StopException();
    public Matrix A;
    public BitmapShader B;
    public final ViewTreeObserver.OnPreDrawListener C;

    /* renamed from: a  reason: collision with root package name */
    public Context f4125a;
    public float b;
    public int c;
    public float d;
    public final BlurImpl e;
    public boolean f;
    public Bitmap g;
    public Bitmap h;
    public Canvas i;
    public boolean j;
    public final Rect k = new Rect();
    public final RectF l = new RectF();
    public View m;
    public boolean n;
    public int o = 0;
    public final Paint p;
    public float q = 0.0f;
    public float r = 0.0f;
    public float s = 0.0f;
    public final float[] t;
    public final Path u;
    public float[] v;
    public final RectF w;
    public final Paint x;
    public float y;
    public ColorStateList z;

    public static class Builder {
    }

    public static class StopException extends RuntimeException {
        private StopException() {
        }
    }

    public ShapeBlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        this.t = fArr;
        this.u = new Path();
        this.w = new RectF();
        this.y = 0.0f;
        this.z = ColorStateList.valueOf(-1);
        this.A = new Matrix();
        this.C = new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                int[] iArr = new int[2];
                Bitmap a2 = ShapeBlurView.this.h;
                View b = ShapeBlurView.this.m;
                if (b != null && ShapeBlurView.this.isShown() && ShapeBlurView.this.q()) {
                    boolean z = ShapeBlurView.this.h != a2;
                    b.getLocationOnScreen(iArr);
                    ShapeBlurView.this.getLocationOnScreen(iArr);
                    int i = (-iArr[0]) + iArr[0];
                    int i2 = (-iArr[1]) + iArr[1];
                    ShapeBlurView.this.g.eraseColor(ShapeBlurView.this.c & Http2CodecUtil.MAX_FRAME_SIZE_UPPER_BOUND);
                    int save = ShapeBlurView.this.i.save();
                    boolean unused = ShapeBlurView.this.j = true;
                    ShapeBlurView.g();
                    try {
                        ShapeBlurView.this.i.scale((((float) ShapeBlurView.this.g.getWidth()) * 1.0f) / ((float) ShapeBlurView.this.getWidth()), (((float) ShapeBlurView.this.g.getHeight()) * 1.0f) / ((float) ShapeBlurView.this.getHeight()));
                        ShapeBlurView.this.i.translate((float) (-i), (float) (-i2));
                        if (b.getBackground() != null) {
                            b.getBackground().draw(ShapeBlurView.this.i);
                        }
                        b.draw(ShapeBlurView.this.i);
                    } catch (StopException unused2) {
                    } catch (Throwable th) {
                        boolean unused3 = ShapeBlurView.this.j = false;
                        ShapeBlurView.h();
                        ShapeBlurView.this.i.restoreToCount(save);
                        throw th;
                    }
                    boolean unused4 = ShapeBlurView.this.j = false;
                    ShapeBlurView.h();
                    ShapeBlurView.this.i.restoreToCount(save);
                    ShapeBlurView shapeBlurView = ShapeBlurView.this;
                    shapeBlurView.j(shapeBlurView.g, ShapeBlurView.this.h);
                    if (z || ShapeBlurView.this.n) {
                        ShapeBlurView.this.invalidate();
                    }
                }
                return true;
            }
        };
        this.f4125a = context;
        this.e = getBlurImpl();
        try {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShapeBlurView);
            this.d = obtainStyledAttributes.getDimension(R.styleable.ShapeBlurView_blur_radius, TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics()));
            this.b = obtainStyledAttributes.getFloat(R.styleable.ShapeBlurView_blur_down_sample, 4.0f);
            this.c = obtainStyledAttributes.getColor(R.styleable.ShapeBlurView_blur_overlay_color, 0);
            fArr[0] = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeBlurView_blur_corner_radius_top_left, -1);
            fArr[1] = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeBlurView_blur_corner_radius_top_right, -1);
            fArr[2] = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeBlurView_blur_corner_radius_bottom_right, -1);
            fArr[3] = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeBlurView_blur_corner_radius_bottom_left, -1);
            o((float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeBlurView_blur_corner_radius, -1));
            this.o = obtainStyledAttributes.getInt(R.styleable.ShapeBlurView_blur_mode, 0);
            float dimensionPixelSize = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeBlurView_blur_border_width, -1);
            this.y = dimensionPixelSize;
            if (dimensionPixelSize < 0.0f) {
                this.y = 0.0f;
            }
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.ShapeBlurView_blur_border_color);
            this.z = colorStateList;
            if (colorStateList == null) {
                this.z = ColorStateList.valueOf(-1);
            }
            obtainStyledAttributes.recycle();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Paint paint = new Paint();
        this.p = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.x = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.z.getColorForState(getState(), -1));
        paint2.setStrokeWidth(this.y);
    }

    public static /* synthetic */ int g() {
        int i2 = D;
        D = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int h() {
        int i2 = D;
        D = i2 - 1;
        return i2;
    }

    public void draw(Canvas canvas) {
        if (this.j) {
            throw F;
        } else if (D <= 0) {
            super.draw(canvas);
        }
    }

    public View getActivityDecorView() {
        Context context = getContext();
        for (int i2 = 0; i2 < 4 && !(context instanceof Activity) && (context instanceof ContextWrapper); i2++) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getDecorView();
        }
        return null;
    }

    public BlurImpl getBlurImpl() {
        if (E == 0) {
            try {
                AndroidStockBlurImpl androidStockBlurImpl = new AndroidStockBlurImpl();
                Bitmap createBitmap = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
                androidStockBlurImpl.b(getContext(), createBitmap, 4.0f);
                androidStockBlurImpl.release();
                createBitmap.recycle();
                E = 3;
            } catch (Throwable unused) {
            }
        }
        if (E == 0) {
            try {
                getClass().getClassLoader().loadClass("androidx.renderscript.RenderScript");
                AndroidXBlurImpl androidXBlurImpl = new AndroidXBlurImpl();
                Bitmap createBitmap2 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
                androidXBlurImpl.b(getContext(), createBitmap2, 4.0f);
                androidXBlurImpl.release();
                createBitmap2.recycle();
                E = 1;
            } catch (Throwable unused2) {
            }
        }
        if (E == 0) {
            try {
                getClass().getClassLoader().loadClass("android.support.v8.renderscript.RenderScript");
                SupportLibraryBlurImpl supportLibraryBlurImpl = new SupportLibraryBlurImpl();
                Bitmap createBitmap3 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
                supportLibraryBlurImpl.b(getContext(), createBitmap3, 4.0f);
                supportLibraryBlurImpl.release();
                createBitmap3.recycle();
                E = 2;
            } catch (Throwable unused3) {
            }
        }
        if (E == 0) {
            E = -1;
        }
        int i2 = E;
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? new EmptyBlurImpl() : new AndroidStockBlurImpl() : new SupportLibraryBlurImpl() : new AndroidXBlurImpl();
    }

    public int getBlurMode() {
        return this.o;
    }

    @ColorInt
    public int getBorderColor() {
        return this.z.getDefaultColor();
    }

    public float getBorderWidth() {
        return this.y;
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float f2 = 0.0f;
        for (float max : this.t) {
            f2 = Math.max(max, f2);
        }
        return f2;
    }

    @NonNull
    public int[] getState() {
        return StateSet.WILD_CARD;
    }

    public void j(Bitmap bitmap, Bitmap bitmap2) {
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.B = new BitmapShader(bitmap2, tileMode, tileMode);
        this.e.a(bitmap, bitmap2);
    }

    public void k(Canvas canvas, Bitmap bitmap, int i2) {
        if (bitmap != null) {
            int i3 = this.o;
            if (i3 == 1) {
                l(canvas, bitmap, i2);
            } else if (i3 == 2) {
                m(canvas, bitmap, i2);
            } else {
                n(canvas, bitmap, i2);
            }
        }
    }

    public final void l(Canvas canvas, Bitmap bitmap, int i2) {
        try {
            this.l.right = (float) getMeasuredWidth();
            this.l.bottom = (float) getMeasuredHeight();
            this.k.right = bitmap.getWidth();
            this.k.bottom = bitmap.getHeight();
            this.p.reset();
            this.p.setAntiAlias(true);
            if (this.B == null) {
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.B = new BitmapShader(bitmap, tileMode, tileMode);
            }
            if (this.A == null) {
                Matrix matrix = new Matrix();
                this.A = matrix;
                matrix.postScale(this.l.width() / ((float) this.k.width()), this.l.height() / ((float) this.k.height()));
            }
            this.B.setLocalMatrix(this.A);
            this.p.setShader(this.B);
            if (this.l.width() >= ((float) this.k.width())) {
                this.q = this.l.width() / 2.0f;
                this.r = this.l.height() / 2.0f;
                this.s = Math.min(this.l.width(), this.l.height()) / 2.0f;
                this.w.set(this.l);
            } else {
                this.q = ((float) this.k.width()) / 2.0f;
                this.r = ((float) this.k.height()) / 2.0f;
                this.s = ((float) Math.min(this.k.width(), this.k.height())) / 2.0f;
                this.w.set(this.k);
            }
            canvas.drawCircle(this.q, this.r, this.s, this.p);
            this.p.reset();
            this.p.setAntiAlias(true);
            this.p.setColor(i2);
            canvas.drawCircle(this.q, this.r, this.s, this.p);
            if (this.y > 0.0f) {
                if (this.w.width() > this.w.height()) {
                    float abs = Math.abs(this.w.height() - this.w.width()) / 2.0f;
                    RectF rectF = this.w;
                    rectF.left = abs;
                    rectF.right = Math.min(rectF.width(), this.w.height()) + abs;
                    RectF rectF2 = this.w;
                    rectF2.bottom = Math.min(rectF2.width(), this.w.height());
                } else if (this.w.width() < this.w.height()) {
                    float abs2 = Math.abs(this.w.height() - this.w.width()) / 2.0f;
                    RectF rectF3 = this.w;
                    rectF3.top = abs2;
                    rectF3.right = Math.min(rectF3.width(), this.w.height());
                    RectF rectF4 = this.w;
                    rectF4.bottom = Math.min(rectF4.width(), this.w.height()) + abs2;
                } else {
                    RectF rectF5 = this.w;
                    rectF5.right = Math.min(rectF5.width(), this.w.height());
                    RectF rectF6 = this.w;
                    rectF6.bottom = Math.min(rectF6.width(), this.w.height());
                }
                RectF rectF7 = this.w;
                float f2 = this.y;
                rectF7.inset(f2 / 2.0f, f2 / 2.0f);
                canvas.drawOval(this.w, this.x);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void m(Canvas canvas, Bitmap bitmap, int i2) {
        try {
            this.l.right = (float) getWidth();
            this.l.bottom = (float) getHeight();
            this.p.reset();
            this.p.setAntiAlias(true);
            if (this.B == null) {
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.B = new BitmapShader(bitmap, tileMode, tileMode);
            }
            if (this.A == null) {
                Matrix matrix = new Matrix();
                this.A = matrix;
                matrix.postScale(this.l.width() / ((float) bitmap.getWidth()), this.l.height() / ((float) bitmap.getHeight()));
            }
            this.B.setLocalMatrix(this.A);
            this.p.setShader(this.B);
            canvas.drawOval(this.l, this.p);
            this.p.reset();
            this.p.setAntiAlias(true);
            this.p.setColor(i2);
            canvas.drawOval(this.l, this.p);
            if (this.y > 0.0f) {
                this.w.set(this.l);
                RectF rectF = this.w;
                float f2 = this.y;
                rectF.inset(f2 / 2.0f, f2 / 2.0f);
                canvas.drawOval(this.w, this.x);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void n(Canvas canvas, Bitmap bitmap, int i2) {
        try {
            this.l.right = (float) getWidth();
            this.l.bottom = (float) getHeight();
            this.u.addRoundRect(this.l, this.v, Path.Direction.CW);
            this.u.close();
            canvas.clipPath(this.u);
            this.k.right = bitmap.getWidth();
            this.k.bottom = bitmap.getHeight();
            canvas.drawBitmap(bitmap, this.k, this.l, (Paint) null);
            this.p.setColor(i2);
            canvas.drawRect(this.l, this.p);
            float f2 = this.y;
            if (f2 > 0.0f) {
                this.x.setStrokeWidth(f2 * 2.0f);
                canvas.drawPath(this.u, this.x);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void o(float f2) {
        int length = this.t.length;
        boolean z2 = false;
        for (int i2 = 0; i2 < length; i2++) {
            float[] fArr = this.t;
            if (fArr[i2] < 0.0f) {
                fArr[i2] = 0.0f;
            } else {
                z2 = true;
            }
        }
        if (!z2) {
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            int length2 = this.t.length;
            for (int i3 = 0; i3 < length2; i3++) {
                this.t[i3] = f2;
            }
        }
        p();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View activityDecorView = getActivityDecorView();
        this.m = activityDecorView;
        boolean z2 = false;
        if (activityDecorView != null) {
            activityDecorView.getViewTreeObserver().addOnPreDrawListener(this.C);
            if (this.m.getRootView() != getRootView()) {
                z2 = true;
            }
            this.n = z2;
            if (z2) {
                this.m.postInvalidate();
                return;
            }
            return;
        }
        this.n = false;
    }

    public void onDetachedFromWindow() {
        View view = this.m;
        if (view != null) {
            view.getViewTreeObserver().removeOnPreDrawListener(this.C);
        }
        r();
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        k(canvas, this.h, this.c);
    }

    public final void p() {
        float[] fArr = this.v;
        if (fArr == null) {
            float[] fArr2 = this.t;
            float f2 = fArr2[0];
            float f3 = fArr2[1];
            float f4 = fArr2[2];
            float f5 = fArr2[3];
            this.v = new float[]{f2, f2, f3, f3, f4, f4, f5, f5};
            return;
        }
        float[] fArr3 = this.t;
        fArr[0] = fArr3[0];
        fArr[1] = fArr3[0];
        float f6 = fArr3[1];
        fArr[2] = f6;
        fArr[3] = f6;
        float f7 = fArr3[2];
        fArr[4] = f7;
        fArr[5] = f7;
        float f8 = fArr3[3];
        fArr[6] = f8;
        fArr[7] = f8;
    }

    public boolean q() {
        Bitmap bitmap;
        float f2 = this.d;
        if (f2 == 0.0f) {
            r();
            return false;
        }
        float f3 = this.b;
        float f4 = f2 / f3;
        if (f4 > 25.0f) {
            f3 = (f3 * f4) / 25.0f;
            f4 = 25.0f;
        }
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(1, (int) (((float) width) / f3));
        int max2 = Math.max(1, (int) (((float) height) / f3));
        boolean z2 = this.f;
        if (this.i == null || (bitmap = this.h) == null || bitmap.getWidth() != max || this.h.getHeight() != max2) {
            s();
            try {
                Bitmap.Config config = Bitmap.Config.ARGB_8888;
                Bitmap createBitmap = Bitmap.createBitmap(max, max2, config);
                this.g = createBitmap;
                if (createBitmap == null) {
                    r();
                    return false;
                }
                this.i = new Canvas(this.g);
                Bitmap createBitmap2 = Bitmap.createBitmap(max, max2, config);
                this.h = createBitmap2;
                if (createBitmap2 == null) {
                    r();
                    return false;
                }
                z2 = true;
            } catch (OutOfMemoryError unused) {
                r();
                return false;
            } catch (Throwable unused2) {
                r();
                return false;
            }
        }
        if (z2) {
            if (!this.e.b(getContext(), this.g, f4)) {
                return false;
            }
            this.f = false;
        }
        return true;
    }

    public void r() {
        s();
        this.e.release();
    }

    public final void s() {
        Bitmap bitmap = this.g;
        if (bitmap != null) {
            bitmap.recycle();
            this.g = null;
        }
        Bitmap bitmap2 = this.h;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.h = null;
        }
        if (this.A != null) {
            this.A = null;
        }
        if (this.B != null) {
            this.B = null;
        }
        this.f4125a = null;
    }
}
