package androidx.core.splashscreen;

import androidx.core.splashscreen.SplashScreen;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SplashScreenViewProvider f819a;
    public final /* synthetic */ SplashScreen.OnExitAnimationListener b;

    public /* synthetic */ a(SplashScreenViewProvider splashScreenViewProvider, SplashScreen.OnExitAnimationListener onExitAnimationListener) {
        this.f819a = splashScreenViewProvider;
        this.b = onExitAnimationListener;
    }

    public final void run() {
        SplashScreen.Impl.f(this.f819a, this.b);
    }
}
