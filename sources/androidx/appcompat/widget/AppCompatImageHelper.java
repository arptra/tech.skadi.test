package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

@RestrictTo
public class AppCompatImageHelper {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f287a;
    public TintInfo b;
    public TintInfo c;
    public TintInfo d;
    public int e = 0;

    public AppCompatImageHelper(ImageView imageView) {
        this.f287a = imageView;
    }

    public final boolean a(Drawable drawable) {
        if (this.d == null) {
            this.d = new TintInfo();
        }
        TintInfo tintInfo = this.d;
        tintInfo.a();
        ColorStateList a2 = ImageViewCompat.a(this.f287a);
        if (a2 != null) {
            tintInfo.d = true;
            tintInfo.f364a = a2;
        }
        PorterDuff.Mode b2 = ImageViewCompat.b(this.f287a);
        if (b2 != null) {
            tintInfo.c = true;
            tintInfo.b = b2;
        }
        if (!tintInfo.d && !tintInfo.c) {
            return false;
        }
        AppCompatDrawableManager.i(drawable, tintInfo, this.f287a.getDrawableState());
        return true;
    }

    public void b() {
        if (this.f287a.getDrawable() != null) {
            this.f287a.getDrawable().setLevel(this.e);
        }
    }

    public void c() {
        Drawable drawable = this.f287a.getDrawable();
        if (drawable != null) {
            DrawableUtils.b(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!l() || !a(drawable)) {
            TintInfo tintInfo = this.c;
            if (tintInfo != null) {
                AppCompatDrawableManager.i(drawable, tintInfo, this.f287a.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.b;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.i(drawable, tintInfo2, this.f287a.getDrawableState());
            }
        }
    }

    public ColorStateList d() {
        TintInfo tintInfo = this.c;
        if (tintInfo != null) {
            return tintInfo.f364a;
        }
        return null;
    }

    public PorterDuff.Mode e() {
        TintInfo tintInfo = this.c;
        if (tintInfo != null) {
            return tintInfo.b;
        }
        return null;
    }

    public boolean f() {
        return !(this.f287a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i) {
        int n;
        TintTypedArray v = TintTypedArray.v(this.f287a.getContext(), attributeSet, R.styleable.AppCompatImageView, i, 0);
        ImageView imageView = this.f287a;
        ViewCompat.s0(imageView, imageView.getContext(), R.styleable.AppCompatImageView, attributeSet, v.r(), i, 0);
        try {
            Drawable drawable = this.f287a.getDrawable();
            if (!(drawable != null || (n = v.n(R.styleable.AppCompatImageView_srcCompat, -1)) == -1 || (drawable = AppCompatResources.b(this.f287a.getContext(), n)) == null)) {
                this.f287a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                DrawableUtils.b(drawable);
            }
            if (v.s(R.styleable.AppCompatImageView_tint)) {
                ImageViewCompat.c(this.f287a, v.c(R.styleable.AppCompatImageView_tint));
            }
            if (v.s(R.styleable.AppCompatImageView_tintMode)) {
                ImageViewCompat.d(this.f287a, DrawableUtils.e(v.k(R.styleable.AppCompatImageView_tintMode, -1), (PorterDuff.Mode) null));
            }
            v.w();
        } catch (Throwable th) {
            v.w();
            throw th;
        }
    }

    public void h(Drawable drawable) {
        this.e = drawable.getLevel();
    }

    public void i(int i) {
        if (i != 0) {
            Drawable b2 = AppCompatResources.b(this.f287a.getContext(), i);
            if (b2 != null) {
                DrawableUtils.b(b2);
            }
            this.f287a.setImageDrawable(b2);
        } else {
            this.f287a.setImageDrawable((Drawable) null);
        }
        c();
    }

    public void j(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new TintInfo();
        }
        TintInfo tintInfo = this.c;
        tintInfo.f364a = colorStateList;
        tintInfo.d = true;
        c();
    }

    public void k(PorterDuff.Mode mode) {
        if (this.c == null) {
            this.c = new TintInfo();
        }
        TintInfo tintInfo = this.c;
        tintInfo.b = mode;
        tintInfo.c = true;
        c();
    }

    public final boolean l() {
        return this.b != null;
    }
}
