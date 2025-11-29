package com.upuphone.ar.tici.phone;

import android.animation.Animator;
import com.airbnb.lottie.LottieAnimationView;
import com.upuphone.ar.tici.phone.utils.LottieExtKt;
import com.upuphone.ar.tici.phone.widget.SampleAnimatorListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/ar/tici/phone/TiciSettingActivity$initView$5$1", "Lcom/upuphone/ar/tici/phone/widget/SampleAnimatorListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TiciSettingActivity$initView$5$1 extends SampleAnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TiciSettingActivity f5908a;

    public TiciSettingActivity$initView$5$1(TiciSettingActivity ticiSettingActivity) {
        this.f5908a = ticiSettingActivity;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        this.f5908a.N0().g.g.f();
        LottieAnimationView lottieAnimationView = this.f5908a.N0().g.d;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "lottieSpeedClock");
        LottieExtKt.c(lottieAnimationView);
    }
}
