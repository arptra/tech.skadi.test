package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.cardview.widget.RoundRectDrawableWithShadow;

class CardViewBaseImpl implements CardViewImpl {

    /* renamed from: a  reason: collision with root package name */
    public final RectF f448a;

    public float a(CardViewDelegate cardViewDelegate) {
        return q(cardViewDelegate).g();
    }

    public float b(CardViewDelegate cardViewDelegate) {
        return q(cardViewDelegate).i();
    }

    public float c(CardViewDelegate cardViewDelegate) {
        return q(cardViewDelegate).j();
    }

    public float d(CardViewDelegate cardViewDelegate) {
        return q(cardViewDelegate).l();
    }

    public void e(CardViewDelegate cardViewDelegate) {
        Rect rect = new Rect();
        q(cardViewDelegate).h(rect);
        cardViewDelegate.b((int) Math.ceil((double) f(cardViewDelegate)), (int) Math.ceil((double) c(cardViewDelegate)));
        cardViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    public float f(CardViewDelegate cardViewDelegate) {
        return q(cardViewDelegate).k();
    }

    public void g(CardViewDelegate cardViewDelegate, float f) {
        q(cardViewDelegate).q(f);
        e(cardViewDelegate);
    }

    public void h(CardViewDelegate cardViewDelegate, float f) {
        q(cardViewDelegate).p(f);
        e(cardViewDelegate);
    }

    public void i(CardViewDelegate cardViewDelegate, float f) {
        q(cardViewDelegate).r(f);
    }

    public ColorStateList j(CardViewDelegate cardViewDelegate) {
        return q(cardViewDelegate).f();
    }

    public void k(CardViewDelegate cardViewDelegate) {
        q(cardViewDelegate).m(cardViewDelegate.e());
        e(cardViewDelegate);
    }

    public void l(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        RoundRectDrawableWithShadow p = p(context, colorStateList, f, f2, f3);
        p.m(cardViewDelegate.e());
        cardViewDelegate.c(p);
        e(cardViewDelegate);
    }

    public void m(CardViewDelegate cardViewDelegate) {
    }

    public void n() {
        RoundRectDrawableWithShadow.r = new RoundRectDrawableWithShadow.RoundRectHelper() {
            public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
                Canvas canvas2 = canvas;
                RectF rectF2 = rectF;
                float f2 = 2.0f * f;
                float width = (rectF.width() - f2) - 1.0f;
                float height = (rectF.height() - f2) - 1.0f;
                if (f >= 1.0f) {
                    float f3 = f + 0.5f;
                    float f4 = -f3;
                    CardViewBaseImpl.this.f448a.set(f4, f4, f3, f3);
                    int save = canvas.save();
                    canvas2.translate(rectF2.left + f3, rectF2.top + f3);
                    Paint paint2 = paint;
                    canvas.drawArc(CardViewBaseImpl.this.f448a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(width, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.f448a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(height, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.f448a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(width, 0.0f);
                    canvas2.rotate(90.0f);
                    Paint paint3 = paint;
                    canvas.drawArc(CardViewBaseImpl.this.f448a, 180.0f, 90.0f, true, paint3);
                    canvas2.restoreToCount(save);
                    float f5 = rectF2.top;
                    canvas.drawRect((rectF2.left + f3) - 1.0f, f5, (rectF2.right - f3) + 1.0f, f5 + f3, paint3);
                    float f6 = rectF2.bottom;
                    Canvas canvas3 = canvas;
                    canvas3.drawRect((rectF2.left + f3) - 1.0f, f6 - f3, (rectF2.right - f3) + 1.0f, f6, paint3);
                }
                canvas.drawRect(rectF2.left, rectF2.top + f, rectF2.right, rectF2.bottom - f, paint);
            }
        };
    }

    public void o(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        q(cardViewDelegate).o(colorStateList);
    }

    public final RoundRectDrawableWithShadow p(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new RoundRectDrawableWithShadow(context.getResources(), colorStateList, f, f2, f3);
    }

    public final RoundRectDrawableWithShadow q(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawableWithShadow) cardViewDelegate.d();
    }
}
