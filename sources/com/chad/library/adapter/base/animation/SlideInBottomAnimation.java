package com.chad.library.adapter.base.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/chad/library/adapter/base/animation/SlideInBottomAnimation;", "Lcom/chad/library/adapter/base/animation/BaseAnimation;", "Landroid/view/View;", "view", "", "Landroid/animation/Animator;", "a", "(Landroid/view/View;)[Landroid/animation/Animator;", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public final class SlideInBottomAnimation implements BaseAnimation {
    public Animator[] a(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", new float[]{(float) view.getMeasuredHeight(), 0.0f});
        Intrinsics.checkExpressionValueIsNotNull(ofFloat, "animator");
        ofFloat.setDuration(400);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.3f));
        return new Animator[]{ofFloat};
    }
}
