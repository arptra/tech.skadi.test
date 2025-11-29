package androidx.core.splashscreen;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.splashscreen.SplashScreen;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"androidx/core/splashscreen/SplashScreen$Impl$setKeepOnScreenCondition$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplashScreen$Impl$setKeepOnScreenCondition$1 implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SplashScreen.Impl f811a;
    public final /* synthetic */ View b;

    public SplashScreen$Impl$setKeepOnScreenCondition$1(SplashScreen.Impl impl, View view) {
        this.f811a = impl;
        this.b = view;
    }

    public boolean onPreDraw() {
        if (this.f811a.h().a()) {
            return false;
        }
        this.b.getViewTreeObserver().removeOnPreDrawListener(this);
        SplashScreenViewProvider c = this.f811a.i;
        if (c == null) {
            return true;
        }
        this.f811a.e(c);
        return true;
    }
}
