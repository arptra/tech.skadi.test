package com.upuphone.ar.tici.phone.utils;

import com.airbnb.lottie.LottieAnimationView;
import com.honey.account.s4.a;
import com.honey.account.s4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/airbnb/lottie/LottieAnimationView;", "", "animDuration", "", "e", "(Lcom/airbnb/lottie/LottieAnimationView;J)V", "c", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "ar-tici_release"}, k = 2, mv = {1, 9, 0})
public final class LottieExtKt {
    public static final void c(LottieAnimationView lottieAnimationView) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "<this>");
        lottieAnimationView.post(new a(lottieAnimationView));
    }

    public static final void d(LottieAnimationView lottieAnimationView) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "$this_restartAnimation");
        lottieAnimationView.setProgress(0.0f);
        lottieAnimationView.playAnimation();
    }

    public static final void e(LottieAnimationView lottieAnimationView, long j) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "<this>");
        lottieAnimationView.post(new b(lottieAnimationView, j));
    }

    public static final void f(LottieAnimationView lottieAnimationView, long j) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "$this_setAnimationDuration");
        lottieAnimationView.setSpeed(((float) lottieAnimationView.getDuration()) / ((float) j));
        lottieAnimationView.playAnimation();
    }
}
