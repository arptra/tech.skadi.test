package androidx.core.view;

import android.view.WindowInsetsAnimationController;
import androidx.annotation.RequiresApi;

public final class WindowInsetsAnimationControllerCompat {

    /* renamed from: a  reason: collision with root package name */
    public final Impl f911a;

    public static class Impl {
    }

    @RequiresApi
    public static class Impl30 extends Impl {

        /* renamed from: a  reason: collision with root package name */
        public final WindowInsetsAnimationController f912a;

        public Impl30(WindowInsetsAnimationController windowInsetsAnimationController) {
            this.f912a = windowInsetsAnimationController;
        }
    }

    public WindowInsetsAnimationControllerCompat(WindowInsetsAnimationController windowInsetsAnimationController) {
        this.f911a = new Impl30(windowInsetsAnimationController);
    }
}
