package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import com.honey.account.q.t0;
import com.upuphone.runasone.uupcast.CaptureType;

public final class WindowInsetsControllerCompat {

    /* renamed from: a  reason: collision with root package name */
    public final Impl f918a;

    public static class Impl {
        public void a(int i) {
        }

        public boolean b() {
            return false;
        }

        public void c(boolean z) {
        }

        public void d(boolean z) {
        }

        public void e(int i) {
        }

        public void f(int i) {
        }
    }

    @RequiresApi
    public static class Impl20 extends Impl {

        /* renamed from: a  reason: collision with root package name */
        public final Window f919a;
        public final SoftwareKeyboardControllerCompat b;

        public Impl20(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this.f919a = window;
            this.b = softwareKeyboardControllerCompat;
        }

        public void a(int i) {
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    g(i2);
                }
            }
        }

        public void e(int i) {
            if (i == 0) {
                k(6144);
            } else if (i == 1) {
                k(4096);
                h(2048);
            } else if (i == 2) {
                k(2048);
                h(4096);
            }
        }

        public void f(int i) {
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    j(i2);
                }
            }
        }

        public final void g(int i) {
            if (i == 1) {
                h(4);
            } else if (i == 2) {
                h(2);
            } else if (i == 8) {
                this.b.a();
            }
        }

        public void h(int i) {
            View decorView = this.f919a.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }

        public void i(int i) {
            this.f919a.addFlags(i);
        }

        public final void j(int i) {
            if (i == 1) {
                k(4);
                l(1024);
            } else if (i == 2) {
                k(2);
            } else if (i == 8) {
                this.b.b();
            }
        }

        public void k(int i) {
            View decorView = this.f919a.getDecorView();
            decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
        }

        public void l(int i) {
            this.f919a.clearFlags(i);
        }
    }

    @RequiresApi
    public static class Impl23 extends Impl20 {
        public Impl23(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, softwareKeyboardControllerCompat);
        }

        public boolean b() {
            return (this.f919a.getDecorView().getSystemUiVisibility() & 8192) != 0;
        }

        public void d(boolean z) {
            if (z) {
                l(CaptureType.CAPTURE_TYPE_ICCOA);
                i(Integer.MIN_VALUE);
                h(8192);
                return;
            }
            k(8192);
        }
    }

    @RequiresApi
    public static class Impl26 extends Impl23 {
        public Impl26(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, softwareKeyboardControllerCompat);
        }

        public void c(boolean z) {
            if (z) {
                l(CaptureType.CAPTURE_VIRTUAL_DISPLAY_ENABLE_MAGIC_WINDOW);
                i(Integer.MIN_VALUE);
                h(16);
                return;
            }
            k(16);
        }
    }

    public interface OnControllableInsetsChangedListener {
    }

    public WindowInsetsControllerCompat(WindowInsetsController windowInsetsController) {
        this.f918a = new Impl30(windowInsetsController, this, new SoftwareKeyboardControllerCompat(windowInsetsController));
    }

    public static WindowInsetsControllerCompat g(WindowInsetsController windowInsetsController) {
        return new WindowInsetsControllerCompat(windowInsetsController);
    }

    public void a(int i) {
        this.f918a.a(i);
    }

    public boolean b() {
        return this.f918a.b();
    }

    public void c(boolean z) {
        this.f918a.c(z);
    }

    public void d(boolean z) {
        this.f918a.d(z);
    }

    public void e(int i) {
        this.f918a.e(i);
    }

    public void f(int i) {
        this.f918a.f(i);
    }

    @RequiresApi
    public static class Impl30 extends Impl {

        /* renamed from: a  reason: collision with root package name */
        public final WindowInsetsControllerCompat f920a;
        public final WindowInsetsController b;
        public final SoftwareKeyboardControllerCompat c;
        public final SimpleArrayMap d;
        public Window e;

        /* renamed from: androidx.core.view.WindowInsetsControllerCompat$Impl30$1  reason: invalid class name */
        class AnonymousClass1 implements WindowInsetsAnimationControlListener {

            /* renamed from: a  reason: collision with root package name */
            public WindowInsetsAnimationControllerCompat f921a;
            public final /* synthetic */ WindowInsetsAnimationControlListenerCompat b;

            public void onCancelled(WindowInsetsAnimationController windowInsetsAnimationController) {
                this.b.a(windowInsetsAnimationController == null ? null : this.f921a);
            }

            public void onFinished(WindowInsetsAnimationController windowInsetsAnimationController) {
                this.b.c(this.f921a);
            }

            public void onReady(WindowInsetsAnimationController windowInsetsAnimationController, int i) {
                WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = new WindowInsetsAnimationControllerCompat(windowInsetsAnimationController);
                this.f921a = windowInsetsAnimationControllerCompat;
                this.b.b(windowInsetsAnimationControllerCompat, i);
            }
        }

        public Impl30(Window window, WindowInsetsControllerCompat windowInsetsControllerCompat, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this(window.getInsetsController(), windowInsetsControllerCompat, softwareKeyboardControllerCompat);
            this.e = window;
        }

        public void a(int i) {
            if ((i & 8) != 0) {
                this.c.a();
            }
            this.b.hide(i & -9);
        }

        public boolean b() {
            this.b.setSystemBarsAppearance(0, 0);
            return (t0.a(this.b) & 8) != 0;
        }

        public void c(boolean z) {
            if (z) {
                if (this.e != null) {
                    g(16);
                }
                this.b.setSystemBarsAppearance(16, 16);
                return;
            }
            if (this.e != null) {
                h(16);
            }
            this.b.setSystemBarsAppearance(0, 16);
        }

        public void d(boolean z) {
            if (z) {
                if (this.e != null) {
                    g(8192);
                }
                this.b.setSystemBarsAppearance(8, 8);
                return;
            }
            if (this.e != null) {
                h(8192);
            }
            this.b.setSystemBarsAppearance(0, 8);
        }

        public void e(int i) {
            this.b.setSystemBarsBehavior(i);
        }

        public void f(int i) {
            if ((i & 8) != 0) {
                this.c.b();
            }
            this.b.show(i & -9);
        }

        public void g(int i) {
            View decorView = this.e.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }

        public void h(int i) {
            View decorView = this.e.getDecorView();
            decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
        }

        public Impl30(WindowInsetsController windowInsetsController, WindowInsetsControllerCompat windowInsetsControllerCompat, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this.d = new SimpleArrayMap();
            this.b = windowInsetsController;
            this.f920a = windowInsetsControllerCompat;
            this.c = softwareKeyboardControllerCompat;
        }
    }

    public WindowInsetsControllerCompat(Window window, View view) {
        SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(view);
        if (Build.VERSION.SDK_INT >= 30) {
            this.f918a = new Impl30(window, this, softwareKeyboardControllerCompat);
        } else {
            this.f918a = new Impl26(window, softwareKeyboardControllerCompat);
        }
    }
}
