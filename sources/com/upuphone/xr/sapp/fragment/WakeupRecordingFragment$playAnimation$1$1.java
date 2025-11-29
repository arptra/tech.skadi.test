package com.upuphone.xr.sapp.fragment;

import android.view.animation.Animation;
import com.upuphone.ar.tici.phone.widget.SimpleAnimationListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/xr/sapp/fragment/WakeupRecordingFragment$playAnimation$1$1", "Lcom/upuphone/ar/tici/phone/widget/SimpleAnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WakeupRecordingFragment$playAnimation$1$1 extends SimpleAnimationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0 f7023a;

    public WakeupRecordingFragment$playAnimation$1$1(Function0 function0) {
        this.f7023a = function0;
    }

    public void onAnimationEnd(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Function0 function0 = this.f7023a;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
