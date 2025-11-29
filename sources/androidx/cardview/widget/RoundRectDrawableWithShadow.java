package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.cardview.R;

class RoundRectDrawableWithShadow extends Drawable {
    public static final double q = Math.cos(Math.toRadians(45.0d));
    public static RoundRectHelper r;

    /* renamed from: a  reason: collision with root package name */
    public final int f451a;
    public Paint b;
    public Paint c;
    public Paint d;
    public final RectF e;
    public float f;
    public Path g;
    public float h;
    public float i;
    public float j;
    public ColorStateList k;
    public boolean l = true;
    public final int m;
    public final int n;
    public boolean o = true;
    public boolean p = false;

    public interface RoundRectHelper {
        void a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    public RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f2, float f3, float f4) {
        this.m = resources.getColor(R.color.cardview_shadow_start_color);
        this.n = resources.getColor(R.color.cardview_shadow_end_color);
        this.f451a = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        this.b = new Paint(5);
        n(colorStateList);
        Paint paint = new Paint(5);
        this.c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f = (float) ((int) (f2 + 0.5f));
        this.e = new RectF();
        Paint paint2 = new Paint(this.c);
        this.d = paint2;
        paint2.setAntiAlias(false);
        s(f3, f4);
    }

    public static float c(float f2, float f3, boolean z) {
        return z ? (float) (((double) f2) + ((1.0d - q) * ((double) f3))) : f2;
    }

    public static float d(float f2, float f3, boolean z) {
        return z ? (float) (((double) (f2 * 1.5f)) + ((1.0d - q) * ((double) f3))) : f2 * 1.5f;
    }

    public final void a(Rect rect) {
        float f2 = this.h;
        float f3 = 1.5f * f2;
        this.e.set(((float) rect.left) + f2, ((float) rect.top) + f3, ((float) rect.right) - f2, ((float) rect.bottom) - f3);
        b();
    }

    public final void b() {
        float f2 = this.f;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        RectF rectF2 = new RectF(rectF);
        float f3 = this.i;
        rectF2.inset(-f3, -f3);
        Path path = this.g;
        if (path == null) {
            this.g = new Path();
        } else {
            path.reset();
        }
        this.g.setFillType(Path.FillType.EVEN_ODD);
        this.g.moveTo(-this.f, 0.0f);
        this.g.rLineTo(-this.i, 0.0f);
        this.g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.g.arcTo(rectF, 270.0f, -90.0f, false);
        this.g.close();
        float f4 = this.f;
        float f5 = f4 / (this.i + f4);
        Paint paint = this.c;
        float f6 = this.f + this.i;
        int i2 = this.m;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f6, new int[]{i2, i2, this.n}, new float[]{0.0f, f5, 1.0f}, tileMode));
        Paint paint2 = this.d;
        float f7 = this.f;
        float f8 = this.i;
        float f9 = (-f7) - f8;
        int i3 = this.m;
        paint2.setShader(new LinearGradient(0.0f, (-f7) + f8, 0.0f, f9, new int[]{i3, i3, this.n}, new float[]{0.0f, 0.5f, 1.0f}, tileMode));
        this.d.setAntiAlias(false);
    }

    public void draw(Canvas canvas) {
        if (this.l) {
            a(getBounds());
            this.l = false;
        }
        canvas.translate(0.0f, this.j / 2.0f);
        e(canvas);
        canvas.translate(0.0f, (-this.j) / 2.0f);
        r.a(canvas, this.e, this.f, this.b);
    }

    public final void e(Canvas canvas) {
        float f2 = this.f;
        float f3 = (-f2) - this.i;
        float f4 = f2 + ((float) this.f451a) + (this.j / 2.0f);
        float f5 = f4 * 2.0f;
        boolean z = this.e.width() - f5 > 0.0f;
        boolean z2 = this.e.height() - f5 > 0.0f;
        int save = canvas.save();
        RectF rectF = this.e;
        canvas.translate(rectF.left + f4, rectF.top + f4);
        canvas.drawPath(this.g, this.c);
        if (z) {
            canvas.drawRect(0.0f, f3, this.e.width() - f5, -this.f, this.d);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        RectF rectF2 = this.e;
        canvas.translate(rectF2.right - f4, rectF2.bottom - f4);
        canvas.rotate(180.0f);
        canvas.drawPath(this.g, this.c);
        if (z) {
            canvas.drawRect(0.0f, f3, this.e.width() - f5, (-this.f) + this.i, this.d);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        RectF rectF3 = this.e;
        canvas.translate(rectF3.left + f4, rectF3.bottom - f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.g, this.c);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.e.height() - f5, -this.f, this.d);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF4 = this.e;
        canvas.translate(rectF4.right - f4, rectF4.top + f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.g, this.c);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.e.height() - f5, -this.f, this.d);
        }
        canvas.restoreToCount(save4);
    }

    public ColorStateList f() {
        return this.k;
    }

    public float g() {
        return this.f;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) d(this.h, this.f, this.o));
        int ceil2 = (int) Math.ceil((double) c(this.h, this.f, this.o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public void h(Rect rect) {
        getPadding(rect);
    }

    public float i() {
        return this.h;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.k;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    public float j() {
        float f2 = this.h;
        return (Math.max(f2, this.f + ((float) this.f451a) + ((f2 * 1.5f) / 2.0f)) * 2.0f) + (((this.h * 1.5f) + ((float) this.f451a)) * 2.0f);
    }

    public float k() {
        float f2 = this.h;
        return (Math.max(f2, this.f + ((float) this.f451a) + (f2 / 2.0f)) * 2.0f) + ((this.h + ((float) this.f451a)) * 2.0f);
    }

    public float l() {
        return this.j;
    }

    public void m(boolean z) {
        this.o = z;
        invalidateSelf();
    }

    public final void n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.k = colorStateList;
        this.b.setColor(colorStateList.getColorForState(getState(), this.k.getDefaultColor()));
    }

    public void o(ColorStateList colorStateList) {
        n(colorStateList);
        invalidateSelf();
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.l = true;
    }

    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.k;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.b.getColor() == colorForState) {
            return false;
        }
        this.b.setColor(colorForState);
        this.l = true;
        invalidateSelf();
        return true;
    }

    public void p(float f2) {
        if (f2 >= 0.0f) {
            float f3 = (float) ((int) (f2 + 0.5f));
            if (this.f != f3) {
                this.f = f3;
                this.l = true;
                invalidateSelf();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f2 + ". Must be >= 0");
    }

    public void q(float f2) {
        s(this.j, f2);
    }

    public void r(float f2) {
        s(f2, this.h);
    }

    public final void s(float f2, float f3) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f2 + ". Must be >= 0");
        } else if (f3 >= 0.0f) {
            float t = (float) t(f2);
            float t2 = (float) t(f3);
            if (t > t2) {
                if (!this.p) {
                    this.p = true;
                }
                t = t2;
            }
            if (this.j != t || this.h != t2) {
                this.j = t;
                this.h = t2;
                this.i = (float) ((int) ((t * 1.5f) + ((float) this.f451a) + 0.5f));
                this.l = true;
                invalidateSelf();
            }
        } else {
            throw new IllegalArgumentException("Invalid max shadow size " + f3 + ". Must be >= 0");
        }
    }

    public void setAlpha(int i2) {
        this.b.setAlpha(i2);
        this.c.setAlpha(i2);
        this.d.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }

    public final int t(float f2) {
        int i2 = (int) (f2 + 0.5f);
        return i2 % 2 == 1 ? i2 - 1 : i2;
    }
}
