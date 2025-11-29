package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.annotation.RequiresApi;

@RequiresApi
class CardViewApi21Impl implements CardViewImpl {
    public float a(CardViewDelegate cardViewDelegate) {
        return p(cardViewDelegate).d();
    }

    public float b(CardViewDelegate cardViewDelegate) {
        return p(cardViewDelegate).c();
    }

    public float c(CardViewDelegate cardViewDelegate) {
        return a(cardViewDelegate) * 2.0f;
    }

    public float d(CardViewDelegate cardViewDelegate) {
        return cardViewDelegate.f().getElevation();
    }

    public void e(CardViewDelegate cardViewDelegate) {
        if (!cardViewDelegate.a()) {
            cardViewDelegate.setShadowPadding(0, 0, 0, 0);
            return;
        }
        float b = b(cardViewDelegate);
        float a2 = a(cardViewDelegate);
        int ceil = (int) Math.ceil((double) RoundRectDrawableWithShadow.c(b, a2, cardViewDelegate.e()));
        int ceil2 = (int) Math.ceil((double) RoundRectDrawableWithShadow.d(b, a2, cardViewDelegate.e()));
        cardViewDelegate.setShadowPadding(ceil, ceil2, ceil, ceil2);
    }

    public float f(CardViewDelegate cardViewDelegate) {
        return a(cardViewDelegate) * 2.0f;
    }

    public void g(CardViewDelegate cardViewDelegate, float f) {
        p(cardViewDelegate).g(f, cardViewDelegate.a(), cardViewDelegate.e());
        e(cardViewDelegate);
    }

    public void h(CardViewDelegate cardViewDelegate, float f) {
        p(cardViewDelegate).h(f);
    }

    public void i(CardViewDelegate cardViewDelegate, float f) {
        cardViewDelegate.f().setElevation(f);
    }

    public ColorStateList j(CardViewDelegate cardViewDelegate) {
        return p(cardViewDelegate).b();
    }

    public void k(CardViewDelegate cardViewDelegate) {
        g(cardViewDelegate, b(cardViewDelegate));
    }

    public void l(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        cardViewDelegate.c(new RoundRectDrawable(colorStateList, f));
        View f4 = cardViewDelegate.f();
        f4.setClipToOutline(true);
        f4.setElevation(f2);
        g(cardViewDelegate, f3);
    }

    public void m(CardViewDelegate cardViewDelegate) {
        g(cardViewDelegate, b(cardViewDelegate));
    }

    public void n() {
    }

    public void o(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        p(cardViewDelegate).f(colorStateList);
    }

    public final RoundRectDrawable p(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawable) cardViewDelegate.d();
    }
}
