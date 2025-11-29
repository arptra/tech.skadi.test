package com.honey.account.q1;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.sidesheet.SideSheetBehavior;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SideSheetBehavior f9798a;
    public final /* synthetic */ ViewGroup.MarginLayoutParams b;
    public final /* synthetic */ int c;
    public final /* synthetic */ View d;

    public /* synthetic */ c(SideSheetBehavior sideSheetBehavior, ViewGroup.MarginLayoutParams marginLayoutParams, int i, View view) {
        this.f9798a = sideSheetBehavior;
        this.b = marginLayoutParams;
        this.c = i;
        this.d = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9798a.lambda$getCoplanarFinishAnimatorUpdateListener$1(this.b, this.c, this.d, valueAnimator);
    }
}
