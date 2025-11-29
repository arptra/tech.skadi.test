package com.honey.account.p4;

import com.airbnb.lottie.LottieAnimationView;
import com.upuphone.ar.tici.phone.TiciSettingActivity;

public final /* synthetic */ class h1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f5045a;
    public final /* synthetic */ long b;

    public /* synthetic */ h1(LottieAnimationView lottieAnimationView, long j) {
        this.f5045a = lottieAnimationView;
        this.b = j;
    }

    public final void run() {
        TiciSettingActivity.Z0(this.f5045a, this.b);
    }
}
