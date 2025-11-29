package com.upuphone.xr.sapp.view;

import android.animation.Animator;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.upuphone.xr.sapp.view.popup.GenericWindowViewContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/upuphone/xr/sapp/view/SuperGenericWindowView$removeAll$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SuperGenericWindowView$removeAll$1$1 implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperGenericWindowView f7990a;
    public final /* synthetic */ GenericWindowViewContainer b;

    public SuperGenericWindowView$removeAll$1$1(SuperGenericWindowView superGenericWindowView, GenericWindowViewContainer genericWindowViewContainer) {
        this.f7990a = superGenericWindowView;
        this.b = genericWindowViewContainer;
    }

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        this.f7990a.e = false;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        this.f7990a.removeView(this.b);
        ViewParent parent = this.f7990a.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).removeView(this.f7990a);
        this.f7990a.e = false;
    }

    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        this.f7990a.e = true;
    }
}
