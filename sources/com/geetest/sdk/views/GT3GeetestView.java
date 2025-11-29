package com.geetest.sdk.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.geetest.sdk.model.beans.GT3ViewColor;
import com.geetest.sdk.model.beans.d;
import com.geetest.sdk.utils.g;

public class GT3GeetestView extends View {
    public double A;
    public double B;
    public int C;
    public int D;
    public int E;
    public ValueAnimator F;
    public ValueAnimator G;
    public int H;
    public AnimatorSet I;

    /* renamed from: a  reason: collision with root package name */
    public Paint f2987a;
    public Paint b;
    public Paint c;
    public Paint d;
    public Paint e;
    public Paint f;
    public Paint g;
    public Paint h;
    public Paint i;
    public Paint j;
    public Paint k;
    public Paint l;
    public float m;
    public Path n;
    public c o;
    public int p;
    public int q;
    public Context r;
    public boolean s = false;
    public boolean t = false;
    public boolean u = false;
    public boolean v = false;
    public boolean w = false;
    public boolean x = false;
    public boolean y = false;
    public boolean z = false;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int unused = GT3GeetestView.this.D = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int unused = GT3GeetestView.this.H = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        }
    }

    public interface c {
        float a();
    }

    public GT3GeetestView(Context context) {
        super(context);
        c(context);
    }

    public void b() {
        this.y = true;
        this.z = false;
        this.x = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
    }

    public final void c(Context context) {
        this.r = context;
    }

    public void e() {
        this.t = false;
        this.s = false;
        this.u = false;
        this.x = false;
        this.v = false;
        this.y = false;
        this.z = true;
        this.w = false;
    }

    public void f() {
        this.x = true;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.y = false;
        this.z = false;
    }

    public void g() {
        this.t = true;
        this.s = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
    }

    public void h() {
        this.A = 0.0d;
        this.s = true;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
    }

    public void i() {
        this.t = false;
        this.s = false;
        this.u = false;
        this.x = false;
        this.v = true;
        this.w = false;
        this.y = false;
        this.z = false;
        this.E = this.p;
    }

    public void j() {
        this.B = 0.0d;
        this.C = this.q;
        this.E = this.p;
        this.t = false;
        this.s = false;
        this.u = true;
        this.x = false;
        this.v = false;
        this.w = false;
        this.y = false;
        this.z = false;
    }

    public void k() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 300});
        this.F = ofInt;
        ofInt.setDuration(700);
        this.F.addUpdateListener(new a());
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{0, 255});
        this.G = ofInt2;
        ofInt2.setDuration(700);
        this.G.addUpdateListener(new b());
        AnimatorSet animatorSet = new AnimatorSet();
        this.I = animatorSet;
        animatorSet.playTogether(new Animator[]{this.F, this.G});
        this.I.start();
        this.t = false;
        this.s = false;
        this.u = false;
        this.x = false;
        this.v = false;
        this.y = false;
        this.z = false;
        this.w = true;
    }

    public void onDraw(Canvas canvas) {
        int i2;
        int i3;
        Canvas canvas2 = canvas;
        this.q = g.b(this.r, (float) new d().f());
        this.p = g.b(this.r, (float) new d().c());
        int b2 = g.b(this.r, (float) new d().a());
        int b3 = g.b(this.r, (float) new d().h());
        int b4 = g.b(this.r, (float) new d().g());
        int b5 = g.b(this.r, (float) new d().e());
        int b6 = g.b(this.r, (float) new d().d());
        this.n = new Path();
        Paint paint = new Paint(1536);
        this.f2987a = paint;
        paint.setAntiAlias(true);
        this.f2987a.setColor(new GT3ViewColor().e());
        this.f2987a.setStrokeWidth(1.0f);
        Paint paint2 = this.f2987a;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        Paint paint3 = new Paint(1536);
        this.k = paint3;
        paint3.setAntiAlias(true);
        this.k.setColor(new GT3ViewColor().c());
        this.k.setStrokeWidth(1.0f);
        this.k.setStyle(style);
        Paint paint4 = new Paint(1536);
        this.b = paint4;
        paint4.setAntiAlias(true);
        this.b.setColor(new GT3ViewColor().a());
        this.b.setStrokeWidth((float) g.b(this.r, 1.0f));
        Paint paint5 = this.b;
        Paint.Style style2 = Paint.Style.STROKE;
        paint5.setStyle(style2);
        Paint paint6 = new Paint(1536);
        this.c = paint6;
        paint6.setAntiAlias(true);
        this.c.setColor(new GT3ViewColor().a());
        this.c.setStrokeWidth((float) g.b(this.r, 2.0f));
        this.c.setStyle(style2);
        Paint paint7 = new Paint(1536);
        this.d = paint7;
        paint7.setAntiAlias(true);
        this.d.setColor(new GT3ViewColor().a());
        this.d.setStrokeWidth(1.0f);
        this.d.setStyle(style);
        Paint paint8 = new Paint(1536);
        this.e = paint8;
        paint8.setAntiAlias(true);
        this.e.setColor(new GT3ViewColor().a());
        this.e.setStrokeWidth(1.0f);
        this.e.setStyle(style);
        this.e.setAlpha(25);
        Paint paint9 = new Paint(1536);
        this.h = paint9;
        paint9.setAntiAlias(true);
        this.h.setColor(new GT3ViewColor().f());
        this.h.setStrokeWidth((float) g.b(this.r, 2.0f));
        this.h.setStyle(style);
        Paint paint10 = new Paint(1536);
        this.f = paint10;
        paint10.setAntiAlias(true);
        this.f.setColor(new GT3ViewColor().a());
        this.f.setStrokeWidth((float) g.b(this.r, 1.0f));
        this.f.setStyle(style);
        this.f.setAlpha(50);
        Paint paint11 = new Paint(1536);
        this.g = paint11;
        paint11.setAntiAlias(true);
        this.g.setColor(new GT3ViewColor().h());
        this.g.setStrokeWidth((float) g.b(this.r, 4.0f));
        this.g.setStyle(style);
        Paint paint12 = new Paint(1536);
        this.l = paint12;
        paint12.setAntiAlias(true);
        this.l.setColor(new GT3ViewColor().h());
        this.l.setStrokeWidth((float) g.b(this.r, 2.0f));
        this.l.setStyle(style);
        Paint paint13 = new Paint(1536);
        this.i = paint13;
        paint13.setAntiAlias(true);
        this.i.setColor(new GT3ViewColor().g());
        this.i.setStrokeWidth((float) g.b(this.r, 2.0f));
        this.i.setStyle(style2);
        Paint paint14 = new Paint(1536);
        this.j = paint14;
        paint14.setAntiAlias(true);
        this.j.setColor(new GT3ViewColor().d());
        this.j.setStrokeWidth((float) g.b(this.r, 3.0f));
        this.j.setStyle(style2);
        postInvalidate();
        super.onDraw(canvas);
        c cVar = this.o;
        if (cVar != null) {
            this.m = cVar.a();
        }
        if (this.y) {
            canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.q, this.f2987a);
        }
        if (this.x) {
            canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.q, this.d);
        }
        if (this.s) {
            double abs = ((double) b2) + (((double) (this.p - b2)) * Math.abs(Math.sin(this.A)));
            canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.q, this.d);
            float f2 = (float) abs;
            canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), f2, this.b);
            canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), f2, this.e);
            this.A += 0.05d;
        }
        if (this.t) {
            canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.q, this.d);
            canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.p, this.b);
            canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.p, this.e);
            canvas2.translate((float) (getWidth() / 2), (float) (getHeight() / 2));
            int i4 = this.p;
            float f3 = (float) (-i4);
            float f4 = (float) i4;
            canvas.drawArc(new RectF(f3, f3, f4, f4), this.m - 90.0f, 45.0f, true, this.f);
        }
        if (this.u) {
            if (this.E > 0) {
                canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.q, this.d);
                canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.E, this.b);
            } else {
                int i5 = this.C;
                if (i5 < this.q || i5 > this.p) {
                    double abs2 = (((double) (this.p * 2)) * Math.abs(Math.sin(this.B))) + 0.0d;
                    canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.q, this.d);
                    canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.p, this.c);
                    canvas2.drawPoint(((float) getWidth()) / 2.0f, (float) ((getHeight() / 2) - this.p), this.g);
                    canvas2.drawPoint((float) ((getWidth() / 2) - this.p), (float) (getHeight() / 2), this.g);
                    canvas2.drawPoint((((float) getWidth()) / 2.0f) + ((float) this.p), (float) (getHeight() / 2), this.g);
                    canvas2.drawPoint(((float) getWidth()) / 2.0f, (float) ((getHeight() / 2) + this.p), this.g);
                    if (abs2 <= ((double) this.p)) {
                        i3 = b5;
                        i2 = b6;
                        canvas.drawLine((float) (((double) (getWidth() / 2)) - Math.sqrt(Math.pow((double) this.p, 2.0d) - Math.pow(((double) this.p) - abs2, 2.0d))), (float) (((double) (getHeight() / 2)) - (((double) this.p) - abs2)), (float) (((double) (getWidth() / 2)) + Math.sqrt(Math.pow((double) this.p, 2.0d) - Math.pow(((double) this.p) - abs2, 2.0d))), (float) (((double) (getHeight() / 2)) - (((double) this.p) - abs2)), this.h);
                    } else {
                        i3 = b5;
                        i2 = b6;
                        canvas.drawLine((float) (((double) (getWidth() / 2)) - Math.sqrt(Math.pow((double) this.p, 2.0d) - Math.pow(abs2 - ((double) this.p), 2.0d))), (float) (((double) (getHeight() / 2)) - (((double) this.p) - abs2)), (float) (((double) (getWidth() / 2)) + Math.sqrt(Math.pow((double) this.p, 2.0d) - Math.pow(abs2 - ((double) this.p), 2.0d))), (float) (((double) (getHeight() / 2)) - (((double) this.p) - abs2)), this.h);
                    }
                    this.B += 0.05d;
                    this.E -= 2;
                } else {
                    canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.q, this.d);
                    canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.C, this.b);
                    this.C += 2;
                }
            }
            i3 = b5;
            i2 = b6;
            this.E -= 2;
        } else {
            i3 = b5;
            i2 = b6;
        }
        if (this.v) {
            if (this.E >= 0) {
                canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.E, this.b);
                canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.q, this.d);
            } else {
                float f5 = (float) b3;
                canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), f5, this.f2987a);
                canvas2.drawCircle((float) ((getWidth() / 2) - this.q), (float) (getHeight() / 2), f5, this.f2987a);
                canvas2.drawCircle((float) ((getWidth() / 2) + this.q), (float) (getHeight() / 2), f5, this.f2987a);
            }
            this.E -= 5;
        }
        if (this.w) {
            this.j.setAlpha(this.H);
            int i6 = (b4 * 2) / 22;
            this.n.moveTo((float) ((getWidth() / 2) - ((b4 * 13) / 22)), (float) ((getHeight() / 2) - i6));
            this.n.lineTo((float) ((getWidth() / 2) - i6), (float) ((getHeight() / 2) + ((b4 * 10) / 22)));
            this.n.lineTo((float) ((getWidth() / 2) + ((b4 * 22) / 22)), (float) ((getHeight() / 2) - ((b4 * 16) / 22)));
            canvas2.drawPath(this.n, this.j);
            canvas2.translate((float) (getWidth() / 2), (float) (getHeight() / 2));
            float f6 = (float) (-b4);
            float f7 = (float) b4;
            canvas.drawArc(new RectF(f6, f6, f7, f7), 300.0f, (float) (-this.D), false, this.i);
        }
        if (this.z) {
            canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) i3, this.k);
            canvas.drawLine((float) ((getWidth() / 2) - i2), (float) (getHeight() / 2), (float) ((getWidth() / 2) + i2), (float) (getHeight() / 2), this.l);
        }
    }

    public void setGtListener(c cVar) {
        this.o = cVar;
    }

    public GT3GeetestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public GT3GeetestView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(context);
    }
}
