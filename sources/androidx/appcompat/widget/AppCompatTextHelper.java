package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.widget.TextViewCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

class AppCompatTextHelper {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f303a;
    public TintInfo b;
    public TintInfo c;
    public TintInfo d;
    public TintInfo e;
    public TintInfo f;
    public TintInfo g;
    public TintInfo h;
    public final AppCompatTextViewAutoSizeHelper i;
    public int j = 0;
    public int k = -1;
    public Typeface l;
    public boolean m;

    @RequiresApi
    public static class Api17Impl {
        @DoNotInline
        public static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        @DoNotInline
        public static void b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        @DoNotInline
        public static void c(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }
    }

    @RequiresApi
    public static class Api21Impl {
        @DoNotInline
        public static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        @DoNotInline
        public static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    @RequiresApi
    public static class Api26Impl {
        @DoNotInline
        public static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        @DoNotInline
        public static void b(TextView textView, int i, int i2, int i3, int i4) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }

        @DoNotInline
        public static void c(TextView textView, int[] iArr, int i) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }

        @DoNotInline
        public static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    @RequiresApi
    public static class Api28Impl {
        @DoNotInline
        public static Typeface a(Typeface typeface, int i, boolean z) {
            return Typeface.create(typeface, i, z);
        }
    }

    public AppCompatTextHelper(TextView textView) {
        this.f303a = textView;
        this.i = new AppCompatTextViewAutoSizeHelper(textView);
    }

    public static TintInfo d(Context context, AppCompatDrawableManager appCompatDrawableManager, int i2) {
        ColorStateList f2 = appCompatDrawableManager.f(context, i2);
        if (f2 == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.d = true;
        tintInfo.f364a = f2;
        return tintInfo;
    }

    public void A(int i2, float f2) {
        if (!ViewUtils.b && !l()) {
            B(i2, f2);
        }
    }

    public final void B(int i2, float f2) {
        this.i.t(i2, f2);
    }

    public final void C(Context context, TintTypedArray tintTypedArray) {
        String o;
        this.j = tintTypedArray.k(R.styleable.TextAppearance_android_textStyle, this.j);
        int k2 = tintTypedArray.k(R.styleable.TextAppearance_android_textFontWeight, -1);
        this.k = k2;
        if (k2 != -1) {
            this.j &= 2;
        }
        boolean z = true;
        if (tintTypedArray.s(R.styleable.TextAppearance_android_fontFamily) || tintTypedArray.s(R.styleable.TextAppearance_fontFamily)) {
            this.l = null;
            int i2 = tintTypedArray.s(R.styleable.TextAppearance_fontFamily) ? R.styleable.TextAppearance_fontFamily : R.styleable.TextAppearance_android_fontFamily;
            final int i3 = this.k;
            final int i4 = this.j;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.f303a);
                try {
                    Typeface j2 = tintTypedArray.j(i2, this.j, new ResourcesCompat.FontCallback() {
                        public void onFontRetrievalFailed(int i) {
                        }

                        public void onFontRetrieved(Typeface typeface) {
                            int i = i3;
                            if (i != -1) {
                                typeface = Api28Impl.a(typeface, i, (i4 & 2) != 0);
                            }
                            AppCompatTextHelper.this.n(weakReference, typeface);
                        }
                    });
                    if (j2 != null) {
                        if (this.k != -1) {
                            this.l = Api28Impl.a(Typeface.create(j2, 0), this.k, (this.j & 2) != 0);
                        } else {
                            this.l = j2;
                        }
                    }
                    this.m = this.l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.l == null && (o = tintTypedArray.o(i2)) != null) {
                if (this.k != -1) {
                    Typeface create = Typeface.create(o, 0);
                    int i5 = this.k;
                    if ((this.j & 2) == 0) {
                        z = false;
                    }
                    this.l = Api28Impl.a(create, i5, z);
                    return;
                }
                this.l = Typeface.create(o, this.j);
            }
        } else if (tintTypedArray.s(R.styleable.TextAppearance_android_typeface)) {
            this.m = false;
            int k3 = tintTypedArray.k(R.styleable.TextAppearance_android_typeface, 1);
            if (k3 == 1) {
                this.l = Typeface.SANS_SERIF;
            } else if (k3 == 2) {
                this.l = Typeface.SERIF;
            } else if (k3 == 3) {
                this.l = Typeface.MONOSPACE;
            }
        }
    }

    public final void a(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.i(drawable, tintInfo, this.f303a.getDrawableState());
        }
    }

    public void b() {
        if (!(this.b == null && this.c == null && this.d == null && this.e == null)) {
            Drawable[] compoundDrawables = this.f303a.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (this.f != null || this.g != null) {
            Drawable[] a2 = Api17Impl.a(this.f303a);
            a(a2[0], this.f);
            a(a2[2], this.g);
        }
    }

    public void c() {
        this.i.a();
    }

    public int e() {
        return this.i.f();
    }

    public int f() {
        return this.i.g();
    }

    public int g() {
        return this.i.h();
    }

    public int[] h() {
        return this.i.i();
    }

    public int i() {
        return this.i.j();
    }

    public ColorStateList j() {
        TintInfo tintInfo = this.h;
        if (tintInfo != null) {
            return tintInfo.f364a;
        }
        return null;
    }

    public PorterDuff.Mode k() {
        TintInfo tintInfo = this.h;
        if (tintInfo != null) {
            return tintInfo.b;
        }
        return null;
    }

    public boolean l() {
        return this.i.n();
    }

    public void m(AttributeSet attributeSet, int i2) {
        String str;
        String str2;
        boolean z;
        boolean z2;
        AttributeSet attributeSet2 = attributeSet;
        int i3 = i2;
        Context context = this.f303a.getContext();
        AppCompatDrawableManager b2 = AppCompatDrawableManager.b();
        TintTypedArray v = TintTypedArray.v(context, attributeSet2, R.styleable.AppCompatTextHelper, i3, 0);
        TextView textView = this.f303a;
        ViewCompat.s0(textView, textView.getContext(), R.styleable.AppCompatTextHelper, attributeSet, v.r(), i2, 0);
        int n = v.n(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (v.s(R.styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.b = d(context, b2, v.n(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (v.s(R.styleable.AppCompatTextHelper_android_drawableTop)) {
            this.c = d(context, b2, v.n(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (v.s(R.styleable.AppCompatTextHelper_android_drawableRight)) {
            this.d = d(context, b2, v.n(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (v.s(R.styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.e = d(context, b2, v.n(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (v.s(R.styleable.AppCompatTextHelper_android_drawableStart)) {
            this.f = d(context, b2, v.n(R.styleable.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (v.s(R.styleable.AppCompatTextHelper_android_drawableEnd)) {
            this.g = d(context, b2, v.n(R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
        }
        v.w();
        boolean z3 = this.f303a.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z4 = true;
        if (n != -1) {
            TintTypedArray t = TintTypedArray.t(context, n, R.styleable.TextAppearance);
            if (z3 || !t.s(R.styleable.TextAppearance_textAllCaps)) {
                z2 = false;
                z = false;
            } else {
                z2 = t.a(R.styleable.TextAppearance_textAllCaps, false);
                z = true;
            }
            C(context, t);
            str2 = t.s(R.styleable.TextAppearance_textLocale) ? t.o(R.styleable.TextAppearance_textLocale) : null;
            str = t.s(R.styleable.TextAppearance_fontVariationSettings) ? t.o(R.styleable.TextAppearance_fontVariationSettings) : null;
            t.w();
        } else {
            z2 = false;
            z = false;
            str2 = null;
            str = null;
        }
        TintTypedArray v2 = TintTypedArray.v(context, attributeSet2, R.styleable.TextAppearance, i3, 0);
        if (z3 || !v2.s(R.styleable.TextAppearance_textAllCaps)) {
            z4 = z;
        } else {
            z2 = v2.a(R.styleable.TextAppearance_textAllCaps, false);
        }
        if (v2.s(R.styleable.TextAppearance_textLocale)) {
            str2 = v2.o(R.styleable.TextAppearance_textLocale);
        }
        if (v2.s(R.styleable.TextAppearance_fontVariationSettings)) {
            str = v2.o(R.styleable.TextAppearance_fontVariationSettings);
        }
        if (v2.s(R.styleable.TextAppearance_android_textSize) && v2.f(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f303a.setTextSize(0, 0.0f);
        }
        C(context, v2);
        v2.w();
        if (!z3 && z4) {
            s(z2);
        }
        Typeface typeface = this.l;
        if (typeface != null) {
            if (this.k == -1) {
                this.f303a.setTypeface(typeface, this.j);
            } else {
                this.f303a.setTypeface(typeface);
            }
        }
        if (str != null) {
            Api26Impl.d(this.f303a, str);
        }
        if (str2 != null) {
            Api24Impl.b(this.f303a, Api24Impl.a(str2));
        }
        this.i.o(attributeSet2, i3);
        if (ViewUtils.b && this.i.j() != 0) {
            int[] i4 = this.i.i();
            if (i4.length > 0) {
                if (((float) Api26Impl.a(this.f303a)) != -1.0f) {
                    Api26Impl.b(this.f303a, this.i.g(), this.i.f(), this.i.h(), 0);
                } else {
                    Api26Impl.c(this.f303a, i4, 0);
                }
            }
        }
        TintTypedArray u = TintTypedArray.u(context, attributeSet2, R.styleable.AppCompatTextView);
        int n2 = u.n(R.styleable.AppCompatTextView_drawableLeftCompat, -1);
        Drawable c2 = n2 != -1 ? b2.c(context, n2) : null;
        int n3 = u.n(R.styleable.AppCompatTextView_drawableTopCompat, -1);
        Drawable c3 = n3 != -1 ? b2.c(context, n3) : null;
        int n4 = u.n(R.styleable.AppCompatTextView_drawableRightCompat, -1);
        Drawable c4 = n4 != -1 ? b2.c(context, n4) : null;
        int n5 = u.n(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
        Drawable c5 = n5 != -1 ? b2.c(context, n5) : null;
        int n6 = u.n(R.styleable.AppCompatTextView_drawableStartCompat, -1);
        Drawable c6 = n6 != -1 ? b2.c(context, n6) : null;
        int n7 = u.n(R.styleable.AppCompatTextView_drawableEndCompat, -1);
        y(c2, c3, c4, c5, c6, n7 != -1 ? b2.c(context, n7) : null);
        if (u.s(R.styleable.AppCompatTextView_drawableTint)) {
            TextViewCompat.g(this.f303a, u.c(R.styleable.AppCompatTextView_drawableTint));
        }
        if (u.s(R.styleable.AppCompatTextView_drawableTintMode)) {
            TextViewCompat.h(this.f303a, DrawableUtils.e(u.k(R.styleable.AppCompatTextView_drawableTintMode, -1), (PorterDuff.Mode) null));
        }
        int f2 = u.f(R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
        int f3 = u.f(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int f4 = u.f(R.styleable.AppCompatTextView_lineHeight, -1);
        u.w();
        if (f2 != -1) {
            TextViewCompat.j(this.f303a, f2);
        }
        if (f3 != -1) {
            TextViewCompat.k(this.f303a, f3);
        }
        if (f4 != -1) {
            TextViewCompat.l(this.f303a, f4);
        }
    }

    public void n(WeakReference weakReference, final Typeface typeface) {
        if (this.m) {
            this.l = typeface;
            final TextView textView = (TextView) weakReference.get();
            if (textView == null) {
                return;
            }
            if (ViewCompat.V(textView)) {
                final int i2 = this.j;
                textView.post(new Runnable() {
                    public void run() {
                        textView.setTypeface(typeface, i2);
                    }
                });
                return;
            }
            textView.setTypeface(typeface, this.j);
        }
    }

    public void o(boolean z, int i2, int i3, int i4, int i5) {
        if (!ViewUtils.b) {
            c();
        }
    }

    public void p() {
        b();
    }

    public void q(Context context, int i2) {
        String o;
        TintTypedArray t = TintTypedArray.t(context, i2, R.styleable.TextAppearance);
        if (t.s(R.styleable.TextAppearance_textAllCaps)) {
            s(t.a(R.styleable.TextAppearance_textAllCaps, false));
        }
        if (t.s(R.styleable.TextAppearance_android_textSize) && t.f(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f303a.setTextSize(0, 0.0f);
        }
        C(context, t);
        if (t.s(R.styleable.TextAppearance_fontVariationSettings) && (o = t.o(R.styleable.TextAppearance_fontVariationSettings)) != null) {
            Api26Impl.d(this.f303a, o);
        }
        t.w();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.f303a.setTypeface(typeface, this.j);
        }
    }

    public void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT < 30 && inputConnection != null) {
            EditorInfoCompat.e(editorInfo, textView.getText());
        }
    }

    public void s(boolean z) {
        this.f303a.setAllCaps(z);
    }

    public void t(int i2, int i3, int i4, int i5) {
        this.i.p(i2, i3, i4, i5);
    }

    public void u(int[] iArr, int i2) {
        this.i.q(iArr, i2);
    }

    public void v(int i2) {
        this.i.r(i2);
    }

    public void w(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new TintInfo();
        }
        TintInfo tintInfo = this.h;
        tintInfo.f364a = colorStateList;
        tintInfo.d = colorStateList != null;
        z();
    }

    public void x(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new TintInfo();
        }
        TintInfo tintInfo = this.h;
        tintInfo.b = mode;
        tintInfo.c = mode != null;
        z();
    }

    public final void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] a2 = Api17Impl.a(this.f303a);
            TextView textView = this.f303a;
            if (drawable5 == null) {
                drawable5 = a2[0];
            }
            if (drawable2 == null) {
                drawable2 = a2[1];
            }
            if (drawable6 == null) {
                drawable6 = a2[2];
            }
            if (drawable4 == null) {
                drawable4 = a2[3];
            }
            Api17Impl.b(textView, drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            Drawable[] a3 = Api17Impl.a(this.f303a);
            Drawable drawable7 = a3[0];
            if (drawable7 == null && a3[2] == null) {
                Drawable[] compoundDrawables = this.f303a.getCompoundDrawables();
                TextView textView2 = this.f303a;
                if (drawable == null) {
                    drawable = compoundDrawables[0];
                }
                if (drawable2 == null) {
                    drawable2 = compoundDrawables[1];
                }
                if (drawable3 == null) {
                    drawable3 = compoundDrawables[2];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawables[3];
                }
                textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                return;
            }
            TextView textView3 = this.f303a;
            if (drawable2 == null) {
                drawable2 = a3[1];
            }
            Drawable drawable8 = a3[2];
            if (drawable4 == null) {
                drawable4 = a3[3];
            }
            Api17Impl.b(textView3, drawable7, drawable2, drawable8, drawable4);
        }
    }

    public final void z() {
        TintInfo tintInfo = this.h;
        this.b = tintInfo;
        this.c = tintInfo;
        this.d = tintInfo;
        this.e = tintInfo;
        this.f = tintInfo;
        this.g = tintInfo;
    }
}
