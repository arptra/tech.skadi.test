package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CircularProgressDrawable extends Drawable implements Animatable {
    public static final Interpolator g = new LinearInterpolator();
    public static final Interpolator h = new FastOutSlowInInterpolator();
    public static final int[] i = {-16777216};

    /* renamed from: a  reason: collision with root package name */
    public final Ring f1810a;
    public float b;
    public Resources c;
    public Animator d;
    public float e;
    public boolean f;

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressDrawableSize {
    }

    public static class Ring {

        /* renamed from: a  reason: collision with root package name */
        public final RectF f1813a = new RectF();
        public final Paint b;
        public final Paint c;
        public final Paint d;
        public float e;
        public float f;
        public float g;
        public float h;
        public int[] i;
        public int j;
        public float k;
        public float l;
        public float m;
        public boolean n;
        public Path o;
        public float p;
        public float q;
        public int r;
        public int s;
        public int t;
        public int u;

        public Ring() {
            Paint paint = new Paint();
            this.b = paint;
            Paint paint2 = new Paint();
            this.c = paint2;
            Paint paint3 = new Paint();
            this.d = paint3;
            this.e = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 5.0f;
            this.p = 1.0f;
            this.t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        public void A() {
            this.k = this.e;
            this.l = this.f;
            this.m = this.g;
        }

        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f1813a;
            float f2 = this.q;
            float f3 = (this.h / 2.0f) + f2;
            if (f2 <= 0.0f) {
                f3 = (((float) Math.min(rect.width(), rect.height())) / 2.0f) - Math.max((((float) this.r) * this.p) / 2.0f, this.h / 2.0f);
            }
            rectF.set(((float) rect.centerX()) - f3, ((float) rect.centerY()) - f3, ((float) rect.centerX()) + f3, ((float) rect.centerY()) + f3);
            float f4 = this.e;
            float f5 = this.g;
            float f6 = (f4 + f5) * 360.0f;
            float f7 = ((this.f + f5) * 360.0f) - f6;
            this.b.setColor(this.u);
            this.b.setAlpha(this.t);
            float f8 = this.h / 2.0f;
            rectF.inset(f8, f8);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.d);
            float f9 = -f8;
            rectF.inset(f9, f9);
            canvas.drawArc(rectF, f6, f7, false, this.b);
            b(canvas, f6, f7, rectF);
        }

        public void b(Canvas canvas, float f2, float f3, RectF rectF) {
            if (this.n) {
                Path path = this.o;
                if (path == null) {
                    Path path2 = new Path();
                    this.o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                this.o.moveTo(0.0f, 0.0f);
                this.o.lineTo(((float) this.r) * this.p, 0.0f);
                Path path3 = this.o;
                float f4 = this.p;
                path3.lineTo((((float) this.r) * f4) / 2.0f, ((float) this.s) * f4);
                this.o.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((((float) this.r) * this.p) / 2.0f), rectF.centerY() + (this.h / 2.0f));
                this.o.close();
                this.c.setColor(this.u);
                this.c.setAlpha(this.t);
                canvas.save();
                canvas.rotate(f2 + f3, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.o, this.c);
                canvas.restore();
            }
        }

        public int c() {
            return this.t;
        }

        public float d() {
            return this.f;
        }

        public int e() {
            return this.i[f()];
        }

        public int f() {
            return (this.j + 1) % this.i.length;
        }

        public float g() {
            return this.e;
        }

        public int h() {
            return this.i[this.j];
        }

        public float i() {
            return this.l;
        }

        public float j() {
            return this.m;
        }

        public float k() {
            return this.k;
        }

        public void l() {
            t(f());
        }

        public void m() {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            y(0.0f);
            v(0.0f);
            w(0.0f);
        }

        public void n(int i2) {
            this.t = i2;
        }

        public void o(float f2, float f3) {
            this.r = (int) f2;
            this.s = (int) f3;
        }

        public void p(float f2) {
            if (f2 != this.p) {
                this.p = f2;
            }
        }

        public void q(float f2) {
            this.q = f2;
        }

        public void r(int i2) {
            this.u = i2;
        }

        public void s(ColorFilter colorFilter) {
            this.b.setColorFilter(colorFilter);
        }

        public void t(int i2) {
            this.j = i2;
            this.u = this.i[i2];
        }

        public void u(int[] iArr) {
            this.i = iArr;
            t(0);
        }

        public void v(float f2) {
            this.f = f2;
        }

        public void w(float f2) {
            this.g = f2;
        }

        public void x(boolean z) {
            if (this.n != z) {
                this.n = z;
            }
        }

        public void y(float f2) {
            this.e = f2;
        }

        public void z(float f2) {
            this.h = f2;
            this.b.setStrokeWidth(f2);
        }
    }

    public CircularProgressDrawable(Context context) {
        this.c = ((Context) Preconditions.h(context)).getResources();
        Ring ring = new Ring();
        this.f1810a = ring;
        ring.u(i);
        k(2.5f);
        m();
    }

    public final void a(float f2, Ring ring) {
        n(f2, ring);
        float floor = (float) (Math.floor((double) (ring.j() / 0.8f)) + 1.0d);
        ring.y(ring.k() + (((ring.i() - 0.01f) - ring.k()) * f2));
        ring.v(ring.i());
        ring.w(ring.j() + ((floor - ring.j()) * f2));
    }

    public void b(float f2, Ring ring, boolean z) {
        float f3;
        float f4;
        if (this.f) {
            a(f2, ring);
        } else if (f2 != 1.0f || z) {
            float j = ring.j();
            if (f2 < 0.5f) {
                f3 = ring.k();
                f4 = (h.getInterpolation(f2 / 0.5f) * 0.79f) + 0.01f + f3;
            } else {
                float k = ring.k() + 0.79f;
                float f5 = k;
                f3 = k - (((1.0f - h.getInterpolation((f2 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f4 = f5;
            }
            ring.y(f3);
            ring.v(f4);
            ring.w(j + (0.20999998f * f2));
            h((f2 + this.e) * 216.0f);
        }
    }

    public final int c(float f2, int i2, int i3) {
        int i4 = (i2 >> 24) & 255;
        int i5 = (i2 >> 16) & 255;
        int i6 = (i2 >> 8) & 255;
        int i7 = i2 & 255;
        return ((i4 + ((int) (((float) (((i3 >> 24) & 255) - i4)) * f2))) << 24) | ((i5 + ((int) (((float) (((i3 >> 16) & 255) - i5)) * f2))) << 16) | ((i6 + ((int) (((float) (((i3 >> 8) & 255) - i6)) * f2))) << 8) | (i7 + ((int) (f2 * ((float) ((i3 & 255) - i7)))));
    }

    public void d(boolean z) {
        this.f1810a.x(z);
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.b, bounds.exactCenterX(), bounds.exactCenterY());
        this.f1810a.a(canvas, bounds);
        canvas.restore();
    }

    public void e(float f2) {
        this.f1810a.p(f2);
        invalidateSelf();
    }

    public void f(int... iArr) {
        this.f1810a.u(iArr);
        this.f1810a.t(0);
        invalidateSelf();
    }

    public void g(float f2) {
        this.f1810a.w(f2);
        invalidateSelf();
    }

    public int getAlpha() {
        return this.f1810a.c();
    }

    public int getOpacity() {
        return -3;
    }

    public final void h(float f2) {
        this.b = f2;
    }

    public final void i(float f2, float f3, float f4, float f5) {
        Ring ring = this.f1810a;
        float f6 = this.c.getDisplayMetrics().density;
        ring.z(f3 * f6);
        ring.q(f2 * f6);
        ring.t(0);
        ring.o(f4 * f6, f5 * f6);
    }

    public boolean isRunning() {
        return this.d.isRunning();
    }

    public void j(float f2, float f3) {
        this.f1810a.y(f2);
        this.f1810a.v(f3);
        invalidateSelf();
    }

    public void k(float f2) {
        this.f1810a.z(f2);
        invalidateSelf();
    }

    public void l(int i2) {
        if (i2 == 0) {
            i(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            i(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public final void m() {
        final Ring ring = this.f1810a;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressDrawable.this.n(floatValue, ring);
                CircularProgressDrawable.this.b(floatValue, ring, false);
                CircularProgressDrawable.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(g);
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
                CircularProgressDrawable.this.b(1.0f, ring, true);
                ring.A();
                ring.l();
                CircularProgressDrawable circularProgressDrawable = CircularProgressDrawable.this;
                if (circularProgressDrawable.f) {
                    circularProgressDrawable.f = false;
                    animator.cancel();
                    animator.setDuration(1332);
                    animator.start();
                    ring.x(false);
                    return;
                }
                circularProgressDrawable.e += 1.0f;
            }

            public void onAnimationStart(Animator animator) {
                CircularProgressDrawable.this.e = 0.0f;
            }
        });
        this.d = ofFloat;
    }

    public void n(float f2, Ring ring) {
        if (f2 > 0.75f) {
            ring.r(c((f2 - 0.75f) / 0.25f, ring.h(), ring.e()));
        } else {
            ring.r(ring.h());
        }
    }

    public void setAlpha(int i2) {
        this.f1810a.n(i2);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1810a.s(colorFilter);
        invalidateSelf();
    }

    public void start() {
        this.d.cancel();
        this.f1810a.A();
        if (this.f1810a.d() != this.f1810a.g()) {
            this.f = true;
            this.d.setDuration(666);
            this.d.start();
            return;
        }
        this.f1810a.t(0);
        this.f1810a.m();
        this.d.setDuration(1332);
        this.d.start();
    }

    public void stop() {
        this.d.cancel();
        h(0.0f);
        this.f1810a.x(false);
        this.f1810a.t(0);
        this.f1810a.m();
        invalidateSelf();
    }
}
