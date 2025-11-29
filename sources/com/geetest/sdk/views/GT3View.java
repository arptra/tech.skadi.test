package com.geetest.sdk.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.geetest.sdk.utils.g;

public class GT3View extends View {

    /* renamed from: a  reason: collision with root package name */
    public int f2991a;
    public Paint b;
    public Paint c;
    public Path d;
    public int e;
    public Context f;
    public boolean g = false;
    public int h;
    public ValueAnimator i;
    public b j;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int unused = GT3View.this.f2991a = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        }
    }

    public interface b {
        void a();
    }

    public GT3View(Context context) {
        super(context);
        c(context);
    }

    public void b() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 255});
        this.i = ofInt;
        ofInt.setDuration(700);
        this.i.addUpdateListener(new a());
        this.i.start();
        this.h = 0;
    }

    public final void c(Context context) {
        this.f = context;
        this.d = new Path();
        Paint paint = new Paint(1536);
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setColor(-8333653);
        this.b.setStrokeWidth((float) g.b(context, 2.0f));
        Paint paint2 = this.b;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        this.f2991a = 1;
        Paint paint3 = new Paint(1536);
        this.c = paint3;
        paint3.setAntiAlias(true);
        this.c.setColor(-8333653);
        this.c.setStrokeWidth((float) g.b(context, 3.0f));
        this.c.setStyle(style);
    }

    public void onDraw(Canvas canvas) {
        this.e = g.b(this.f, 12.0f);
        postInvalidate();
        super.onDraw(canvas);
        int i2 = this.h;
        if (i2 <= 100) {
            this.c.setAlpha(this.f2991a);
            this.d.moveTo((float) ((getWidth() / 2) - ((this.e * 13) / 22)), (float) ((getHeight() / 2) - ((this.e * 2) / 22)));
            this.d.lineTo((float) ((getWidth() / 2) - ((this.e * 2) / 22)), (float) ((getHeight() / 2) + ((this.e * 10) / 22)));
            this.d.lineTo((float) ((getWidth() / 2) + ((this.e * 22) / 22)), (float) ((getHeight() / 2) - ((this.e * 16) / 22)));
            canvas.drawPath(this.d, this.c);
            canvas.translate((float) (getWidth() / 2), (float) (getHeight() / 2));
            int i3 = this.e;
            float f2 = (float) (-i3);
            float f3 = (float) i3;
            canvas.drawArc(new RectF(f2, f2, f3, f3), 300.0f, (float) (-this.h), false, this.b);
            this.h += 20;
        } else if (i2 > 100 && i2 <= 200) {
            this.c.setAlpha(this.f2991a);
            this.d.moveTo((float) ((getWidth() / 2) - ((this.e * 13) / 22)), (float) ((getHeight() / 2) - ((this.e * 2) / 22)));
            this.d.lineTo((float) ((getWidth() / 2) - ((this.e * 2) / 22)), (float) ((getHeight() / 2) + ((this.e * 10) / 22)));
            this.d.lineTo((float) ((getWidth() / 2) + ((this.e * 22) / 22)), (float) ((getHeight() / 2) - ((this.e * 16) / 22)));
            canvas.drawPath(this.d, this.c);
            canvas.translate((float) (getWidth() / 2), (float) (getHeight() / 2));
            int i4 = this.e;
            float f4 = (float) (-i4);
            float f5 = (float) i4;
            canvas.drawArc(new RectF(f4, f4, f5, f5), 300.0f, (float) (-this.h), false, this.b);
            this.h += 10;
        } else if (i2 > 200 && i2 <= 300) {
            this.c.setAlpha(this.f2991a);
            this.d.moveTo((float) ((getWidth() / 2) - ((this.e * 13) / 22)), (float) ((getHeight() / 2) - ((this.e * 2) / 22)));
            this.d.lineTo((float) ((getWidth() / 2) - ((this.e * 2) / 22)), (float) ((getHeight() / 2) + ((this.e * 10) / 22)));
            this.d.lineTo((float) ((getWidth() / 2) + ((this.e * 22) / 22)), (float) ((getHeight() / 2) - ((this.e * 16) / 22)));
            canvas.drawPath(this.d, this.c);
            canvas.translate((float) (getWidth() / 2), (float) (getHeight() / 2));
            int i5 = this.e;
            float f6 = (float) (-i5);
            float f7 = (float) i5;
            canvas.drawArc(new RectF(f6, f6, f7, f7), 300.0f, (float) (-this.h), false, this.b);
            this.h += 20;
        } else if (i2 <= 300 || i2 >= 800) {
            this.d.moveTo((float) ((getWidth() / 2) - ((this.e * 13) / 22)), (float) ((getHeight() / 2) - ((this.e * 2) / 22)));
            this.d.lineTo((float) ((getWidth() / 2) - ((this.e * 2) / 22)), (float) ((getHeight() / 2) + ((this.e * 10) / 22)));
            this.d.lineTo((float) ((getWidth() / 2) + ((this.e * 22) / 22)), (float) ((getHeight() / 2) - ((this.e * 16) / 22)));
            canvas.drawPath(this.d, this.c);
            canvas.translate((float) (getWidth() / 2), (float) (getHeight() / 2));
            int i6 = this.e;
            float f8 = (float) (-i6);
            float f9 = (float) i6;
            canvas.drawArc(new RectF(f8, f8, f9, f9), 300.0f, -300.0f, false, this.b);
            b bVar = this.j;
            if (bVar != null && !this.g) {
                bVar.a();
                this.g = true;
            }
        } else {
            this.c.setAlpha(this.f2991a);
            this.d.moveTo((float) ((getWidth() / 2) - ((this.e * 13) / 22)), (float) ((getHeight() / 2) - ((this.e * 2) / 22)));
            this.d.lineTo((float) ((getWidth() / 2) - ((this.e * 2) / 22)), (float) ((getHeight() / 2) + ((this.e * 10) / 22)));
            this.d.lineTo((float) ((getWidth() / 2) + ((this.e * 22) / 22)), (float) ((getHeight() / 2) - ((this.e * 16) / 22)));
            canvas.drawPath(this.d, this.c);
            canvas.translate((float) (getWidth() / 2), (float) (getHeight() / 2));
            int i7 = this.e;
            float f10 = (float) (-i7);
            float f11 = (float) i7;
            canvas.drawArc(new RectF(f10, f10, f11, f11), 300.0f, -300.0f, false, this.b);
            this.h += 10;
        }
    }

    public void setGtListener(b bVar) {
        this.j = bVar;
    }

    public GT3View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public GT3View(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(context);
    }
}
