package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

class AppCompatBackgroundHelper {

    /* renamed from: a  reason: collision with root package name */
    public final View f278a;
    public final AppCompatDrawableManager b;
    public int c = -1;
    public TintInfo d;
    public TintInfo e;
    public TintInfo f;

    public AppCompatBackgroundHelper(View view) {
        this.f278a = view;
        this.b = AppCompatDrawableManager.b();
    }

    public final boolean a(Drawable drawable) {
        if (this.f == null) {
            this.f = new TintInfo();
        }
        TintInfo tintInfo = this.f;
        tintInfo.a();
        ColorStateList q = ViewCompat.q(this.f278a);
        if (q != null) {
            tintInfo.d = true;
            tintInfo.f364a = q;
        }
        PorterDuff.Mode r = ViewCompat.r(this.f278a);
        if (r != null) {
            tintInfo.c = true;
            tintInfo.b = r;
        }
        if (!tintInfo.d && !tintInfo.c) {
            return false;
        }
        AppCompatDrawableManager.i(drawable, tintInfo, this.f278a.getDrawableState());
        return true;
    }

    public void b() {
        Drawable background = this.f278a.getBackground();
        if (background == null) {
            return;
        }
        if (!k() || !a(background)) {
            TintInfo tintInfo = this.e;
            if (tintInfo != null) {
                AppCompatDrawableManager.i(background, tintInfo, this.f278a.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.d;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.i(background, tintInfo2, this.f278a.getDrawableState());
            }
        }
    }

    public ColorStateList c() {
        TintInfo tintInfo = this.e;
        if (tintInfo != null) {
            return tintInfo.f364a;
        }
        return null;
    }

    public PorterDuff.Mode d() {
        TintInfo tintInfo = this.e;
        if (tintInfo != null) {
            return tintInfo.b;
        }
        return null;
    }

    public void e(AttributeSet attributeSet, int i) {
        TintTypedArray v = TintTypedArray.v(this.f278a.getContext(), attributeSet, R.styleable.ViewBackgroundHelper, i, 0);
        View view = this.f278a;
        ViewCompat.s0(view, view.getContext(), R.styleable.ViewBackgroundHelper, attributeSet, v.r(), i, 0);
        try {
            if (v.s(R.styleable.ViewBackgroundHelper_android_background)) {
                this.c = v.n(R.styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList f2 = this.b.f(this.f278a.getContext(), this.c);
                if (f2 != null) {
                    h(f2);
                }
            }
            if (v.s(R.styleable.ViewBackgroundHelper_backgroundTint)) {
                ViewCompat.A0(this.f278a, v.c(R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (v.s(R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                ViewCompat.B0(this.f278a, DrawableUtils.e(v.k(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), (PorterDuff.Mode) null));
            }
            v.w();
        } catch (Throwable th) {
            v.w();
            throw th;
        }
    }

    public void f(Drawable drawable) {
        this.c = -1;
        h((ColorStateList) null);
        b();
    }

    public void g(int i) {
        this.c = i;
        AppCompatDrawableManager appCompatDrawableManager = this.b;
        h(appCompatDrawableManager != null ? appCompatDrawableManager.f(this.f278a.getContext(), i) : null);
        b();
    }

    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new TintInfo();
            }
            TintInfo tintInfo = this.d;
            tintInfo.f364a = colorStateList;
            tintInfo.d = true;
        } else {
            this.d = null;
        }
        b();
    }

    public void i(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new TintInfo();
        }
        TintInfo tintInfo = this.e;
        tintInfo.f364a = colorStateList;
        tintInfo.d = true;
        b();
    }

    public void j(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new TintInfo();
        }
        TintInfo tintInfo = this.e;
        tintInfo.b = mode;
        tintInfo.c = true;
        b();
    }

    public final boolean k() {
        return this.d != null;
    }
}
