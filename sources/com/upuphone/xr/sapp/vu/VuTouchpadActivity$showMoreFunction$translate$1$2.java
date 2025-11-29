package com.upuphone.xr.sapp.vu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentVuTouchpadBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nVuTouchpadActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VuTouchpadActivity.kt\ncom/upuphone/xr/sapp/vu/VuTouchpadActivity$showMoreFunction$translate$1$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,838:1\n256#2,2:839\n*S KotlinDebug\n*F\n+ 1 VuTouchpadActivity.kt\ncom/upuphone/xr/sapp/vu/VuTouchpadActivity$showMoreFunction$translate$1$2\n*L\n451#1:839,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/xr/sapp/vu/VuTouchpadActivity$showMoreFunction$translate$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VuTouchpadActivity$showMoreFunction$translate$1$2 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VuTouchpadActivity f8039a;

    public VuTouchpadActivity$showMoreFunction$translate$1$2(VuTouchpadActivity vuTouchpadActivity) {
        this.f8039a = vuTouchpadActivity;
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        FragmentVuTouchpadBinding I0 = this.f8039a.c;
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding = null;
        if (I0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            I0 = null;
        }
        ConstraintLayout constraintLayout = I0.h;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "moreFunctionLayout");
        constraintLayout.setVisibility(0);
        FragmentVuTouchpadBinding I02 = this.f8039a.c;
        if (I02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentVuTouchpadBinding = I02;
        }
        fragmentVuTouchpadBinding.g.setImageResource(R.drawable.icon_vu_touchpad_close);
    }
}
