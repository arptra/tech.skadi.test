package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"androidx/fragment/app/DefaultSpecialEffectsController$AnimatorEffect$onStart$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "anim", "Landroid/animation/Animator;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultSpecialEffectsController$AnimatorEffect$onStart$1 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1249a;
    public final /* synthetic */ View b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ SpecialEffectsController.Operation d;
    public final /* synthetic */ DefaultSpecialEffectsController.AnimatorEffect e;

    public DefaultSpecialEffectsController$AnimatorEffect$onStart$1(ViewGroup viewGroup, View view, boolean z, SpecialEffectsController.Operation operation, DefaultSpecialEffectsController.AnimatorEffect animatorEffect) {
        this.f1249a = viewGroup;
        this.b = view;
        this.c = z;
        this.d = operation;
        this.e = animatorEffect;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "anim");
        this.f1249a.endViewTransition(this.b);
        if (this.c) {
            SpecialEffectsController.Operation.State g = this.d.g();
            View view = this.b;
            Intrinsics.checkNotNullExpressionValue(view, "viewToAnimate");
            g.applyState(view, this.f1249a);
        }
        this.e.h().a().e(this.e);
        if (FragmentManager.T0(2)) {
            Log.v("FragmentManager", "Animator from operation " + this.d + " has ended.");
        }
    }
}
