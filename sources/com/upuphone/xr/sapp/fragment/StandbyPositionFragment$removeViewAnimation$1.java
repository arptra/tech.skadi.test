package com.upuphone.xr.sapp.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.honey.account.h8.s9;
import com.upuphone.xr.sapp.databinding.FragmentStandbyPositionBinding;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/xr/sapp/fragment/StandbyPositionFragment$removeViewAnimation$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StandbyPositionFragment$removeViewAnimation$1 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StandbyPositionFragment f7008a;
    public final /* synthetic */ LinkedHashMap b;

    public StandbyPositionFragment$removeViewAnimation$1(StandbyPositionFragment standbyPositionFragment, LinkedHashMap linkedHashMap) {
        this.f7008a = standbyPositionFragment;
        this.b = linkedHashMap;
    }

    public static final void b(Function2 function2, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(function2, "$tmp0");
        function2.invoke(obj, obj2);
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        super.onAnimationEnd(animator);
        FragmentStandbyPositionBinding M0 = this.f7008a.l;
        if (M0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            M0 = null;
        }
        M0.m.removeAllViews();
        this.b.forEach(new s9(new StandbyPositionFragment$removeViewAnimation$1$onAnimationEnd$1(this.f7008a)));
    }
}
