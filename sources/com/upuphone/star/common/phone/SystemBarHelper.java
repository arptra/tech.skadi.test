package com.upuphone.star.common.phone;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

class SystemBarHelper {

    /* renamed from: a  reason: collision with root package name */
    public boolean f6442a = false;
    public boolean b = false;
    public final Activity c;
    public View d;

    public SystemBarHelper(Activity activity) {
        this.c = activity;
    }

    public void d(boolean z) {
        if (this.b != z) {
            this.b = z;
            if (z) {
                WindowCompat.b(g(), false);
                return;
            }
            if (!this.f6442a) {
                WindowCompat.b(g(), true);
            }
            k();
        }
    }

    public void e(boolean z) {
        if (this.f6442a != z) {
            this.f6442a = z;
            if (z) {
                WindowCompat.b(g(), false);
                return;
            }
            if (!this.b) {
                WindowCompat.b(g(), true);
            }
            k();
        }
    }

    public void f(boolean z) {
        if (this.f6442a != z || this.b != z) {
            WindowCompat.b(g(), !z);
            if (z) {
                this.f6442a = true;
                this.b = true;
                return;
            }
            this.f6442a = false;
            this.b = false;
            k();
        }
    }

    public final Window g() {
        return this.c.getWindow();
    }

    public void h(View view) {
        this.d = view;
        if (view != null) {
            k();
            view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    Window a2 = SystemBarHelper.this.g();
                    WindowInsetsCompat H = ViewCompat.H(a2.getDecorView());
                    if (H != null) {
                        SystemBarHelper systemBarHelper = SystemBarHelper.this;
                        int i = 0;
                        systemBarHelper.j(systemBarHelper.f6442a ? 0 : a2.getStatusBarColor());
                        SystemBarHelper systemBarHelper2 = SystemBarHelper.this;
                        systemBarHelper2.i(systemBarHelper2.b ? 0 : a2.getNavigationBarColor());
                        Insets f = H.f(WindowInsetsCompat.Type.e());
                        Insets f2 = H.f(WindowInsetsCompat.Type.d());
                        int i2 = SystemBarHelper.this.f6442a ? 0 : f.b;
                        if (!SystemBarHelper.this.b) {
                            i = f2.d;
                        }
                        view.setPadding(view.getPaddingLeft(), i2, view.getPaddingRight(), i);
                    }
                    return WindowInsetsCompat.b.w();
                }
            });
        }
    }

    public void i(int i) {
        g().setNavigationBarColor(i);
    }

    public void j(int i) {
        g().setStatusBarColor(i);
    }

    public final void k() {
        View view = this.d;
        if (view != null) {
            Drawable background = view.getBackground();
            int color = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : -1;
            if (!this.f6442a && g().getStatusBarColor() == 0) {
                j(color);
            }
            if (!this.b && g().getNavigationBarColor() == 0) {
                i(color);
            }
        }
    }
}
