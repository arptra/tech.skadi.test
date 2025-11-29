package com.honey.account.c1;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.shape.MaterialShapeDrawable;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f9707a;
    public final /* synthetic */ ColorStateList b;
    public final /* synthetic */ ColorStateList c;
    public final /* synthetic */ MaterialShapeDrawable d;
    public final /* synthetic */ Integer e;

    public /* synthetic */ a(AppBarLayout appBarLayout, ColorStateList colorStateList, ColorStateList colorStateList2, MaterialShapeDrawable materialShapeDrawable, Integer num) {
        this.f9707a = appBarLayout;
        this.b = colorStateList;
        this.c = colorStateList2;
        this.d = materialShapeDrawable;
        this.e = num;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9707a.lambda$initializeLiftOnScrollWithColor$0(this.b, this.c, this.d, this.e, valueAnimator);
    }
}
