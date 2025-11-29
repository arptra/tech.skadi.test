package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.RequiresApi;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SoftwareKeyboardControllerCompat {

    /* renamed from: a  reason: collision with root package name */
    public final Impl f881a;

    public static class Impl {
        public void a() {
        }

        public void b() {
        }
    }

    @RequiresApi
    public static class Impl20 extends Impl {

        /* renamed from: a  reason: collision with root package name */
        public final View f882a;

        public Impl20(View view) {
            this.f882a = view;
        }

        public void a() {
            View view = this.f882a;
            if (view != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f882a.getWindowToken(), 0);
            }
        }

        public void b() {
            View view = this.f882a;
            if (view != null) {
                if (view.isInEditMode() || view.onCheckIsTextEditor()) {
                    view.requestFocus();
                } else {
                    view = view.getRootView().findFocus();
                }
                if (view == null) {
                    view = this.f882a.getRootView().findViewById(16908290);
                }
                if (view != null && view.hasWindowFocus()) {
                    view.post(new c(view));
                }
            }
        }
    }

    public SoftwareKeyboardControllerCompat(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f881a = new Impl30(view);
        } else {
            this.f881a = new Impl20(view);
        }
    }

    public void a() {
        this.f881a.a();
    }

    public void b() {
        this.f881a.b();
    }

    @RequiresApi
    public static class Impl30 extends Impl20 {
        public View b;
        public WindowInsetsController c;

        public Impl30(View view) {
            super(view);
            this.b = view;
        }

        public static /* synthetic */ void f(AtomicBoolean atomicBoolean, WindowInsetsController windowInsetsController, int i) {
            atomicBoolean.set((i & 8) != 0);
        }

        public void a() {
            View view;
            WindowInsetsController windowInsetsController = this.c;
            if (windowInsetsController == null) {
                View view2 = this.b;
                windowInsetsController = view2 != null ? view2.getWindowInsetsController() : null;
            }
            if (windowInsetsController != null) {
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                d dVar = new d(atomicBoolean);
                windowInsetsController.addOnControllableInsetsChangedListener(dVar);
                if (!atomicBoolean.get() && (view = this.b) != null) {
                    ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.b.getWindowToken(), 0);
                }
                windowInsetsController.removeOnControllableInsetsChangedListener(dVar);
                windowInsetsController.hide(WindowInsets.Type.ime());
                return;
            }
            super.a();
        }

        public void b() {
            View view = this.b;
            if (view != null && Build.VERSION.SDK_INT < 33) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).isActive();
            }
            WindowInsetsController windowInsetsController = this.c;
            if (windowInsetsController == null) {
                View view2 = this.b;
                windowInsetsController = view2 != null ? view2.getWindowInsetsController() : null;
            }
            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsets.Type.ime());
            }
            super.b();
        }

        public Impl30(WindowInsetsController windowInsetsController) {
            super((View) null);
            this.c = windowInsetsController;
        }
    }

    public SoftwareKeyboardControllerCompat(WindowInsetsController windowInsetsController) {
        this.f881a = new Impl30(windowInsetsController);
    }
}
