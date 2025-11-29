package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class WindowInsetsCompat {
    public static final WindowInsetsCompat b;

    /* renamed from: a  reason: collision with root package name */
    public final Impl f913a;

    @RequiresApi
    @SuppressLint({"SoonBlockedPrivateApi"})
    public static class Api21ReflectionHolder {

        /* renamed from: a  reason: collision with root package name */
        public static Field f914a;
        public static Field b;
        public static Field c;
        public static boolean d = true;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f914a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                c = declaredField3;
                declaredField3.setAccessible(true);
            } catch (ReflectiveOperationException e) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
            }
        }

        public static WindowInsetsCompat a(View view) {
            if (d && view.isAttachedToWindow()) {
                try {
                    Object obj = f914a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) b.get(obj);
                        Rect rect2 = (Rect) c.get(obj);
                        if (!(rect == null || rect2 == null)) {
                            WindowInsetsCompat a2 = new Builder().c(Insets.c(rect)).d(Insets.c(rect2)).a();
                            a2.u(a2);
                            a2.d(view.getRootView());
                            return a2;
                        }
                    }
                } catch (IllegalAccessException e) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
                }
            }
            return null;
        }
    }

    public static class BuilderImpl {

        /* renamed from: a  reason: collision with root package name */
        public final WindowInsetsCompat f916a;
        public Insets[] b;

        public BuilderImpl() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
        }

        public final void a() {
            Insets[] insetsArr = this.b;
            if (insetsArr != null) {
                Insets insets = insetsArr[Type.b(1)];
                Insets insets2 = this.b[Type.b(2)];
                if (insets2 == null) {
                    insets2 = this.f916a.f(2);
                }
                if (insets == null) {
                    insets = this.f916a.f(1);
                }
                g(Insets.a(insets, insets2));
                Insets insets3 = this.b[Type.b(16)];
                if (insets3 != null) {
                    f(insets3);
                }
                Insets insets4 = this.b[Type.b(32)];
                if (insets4 != null) {
                    d(insets4);
                }
                Insets insets5 = this.b[Type.b(64)];
                if (insets5 != null) {
                    h(insets5);
                }
            }
        }

        @NonNull
        public WindowInsetsCompat b() {
            a();
            return this.f916a;
        }

        public void c(int i, @NonNull Insets insets) {
            if (this.b == null) {
                this.b = new Insets[9];
            }
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    this.b[Type.b(i2)] = insets;
                }
            }
        }

        public void d(@NonNull Insets insets) {
        }

        public void e(@NonNull Insets insets) {
        }

        public void f(@NonNull Insets insets) {
        }

        public void g(@NonNull Insets insets) {
        }

        public void h(@NonNull Insets insets) {
        }

        public BuilderImpl(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.f916a = windowInsetsCompat;
        }
    }

    @RequiresApi
    public static class BuilderImpl20 extends BuilderImpl {
        public WindowInsets c;
        public Insets d;

        @NonNull
        public WindowInsetsCompat b() {
            a();
            WindowInsetsCompat x = WindowInsetsCompat.x(this.c);
            x.s(this.b);
            x.v(this.d);
            return x;
        }

        public void e(@Nullable Insets insets) {
            this.d = insets;
        }

        public void g(@NonNull Insets insets) {
            WindowInsets windowInsets = this.c;
            if (windowInsets != null) {
                this.c = windowInsets.replaceSystemWindowInsets(insets.f712a, insets.b, insets.c, insets.d);
            }
        }
    }

    @RequiresApi
    public static class BuilderImpl30 extends BuilderImpl29 {
        public BuilderImpl30() {
        }

        public void c(int i, @NonNull Insets insets) {
            WindowInsets.Builder unused = this.c.setInsets(TypeImpl30.a(i), insets.e());
        }

        public BuilderImpl30(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }
    }

    public static class Impl {
        public static final WindowInsetsCompat b = new Builder().a().a().b().c();

        /* renamed from: a  reason: collision with root package name */
        public final WindowInsetsCompat f917a;

        public Impl(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.f917a = windowInsetsCompat;
        }

        @NonNull
        public WindowInsetsCompat a() {
            return this.f917a;
        }

        @NonNull
        public WindowInsetsCompat b() {
            return this.f917a;
        }

        @NonNull
        public WindowInsetsCompat c() {
            return this.f917a;
        }

        public void d(@NonNull View view) {
        }

        public void e(@NonNull WindowInsetsCompat windowInsetsCompat) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl)) {
                return false;
            }
            Impl impl = (Impl) obj;
            return o() == impl.o() && n() == impl.n() && ObjectsCompat.a(k(), impl.k()) && ObjectsCompat.a(i(), impl.i()) && ObjectsCompat.a(f(), impl.f());
        }

        @Nullable
        public DisplayCutoutCompat f() {
            return null;
        }

        @NonNull
        public Insets g(int i) {
            return Insets.e;
        }

        @NonNull
        public Insets h() {
            return k();
        }

        public int hashCode() {
            return ObjectsCompat.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        @NonNull
        public Insets i() {
            return Insets.e;
        }

        @NonNull
        public Insets j() {
            return k();
        }

        @NonNull
        public Insets k() {
            return Insets.e;
        }

        @NonNull
        public Insets l() {
            return k();
        }

        @NonNull
        public WindowInsetsCompat m(int i, int i2, int i3, int i4) {
            return b;
        }

        public boolean n() {
            return false;
        }

        public boolean o() {
            return false;
        }

        public boolean p(int i) {
            return true;
        }

        public void q(Insets[] insetsArr) {
        }

        public void r(@NonNull Insets insets) {
        }

        public void s(@Nullable WindowInsetsCompat windowInsetsCompat) {
        }

        public void t(Insets insets) {
        }
    }

    @RequiresApi
    public static class Impl28 extends Impl21 {
        public Impl28(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @NonNull
        public WindowInsetsCompat a() {
            return WindowInsetsCompat.x(this.c.consumeDisplayCutout());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl28)) {
                return false;
            }
            Impl28 impl28 = (Impl28) obj;
            return Objects.equals(this.c, impl28.c) && Objects.equals(this.g, impl28.g);
        }

        @Nullable
        public DisplayCutoutCompat f() {
            return DisplayCutoutCompat.e(this.c.getDisplayCutout());
        }

        public int hashCode() {
            return this.c.hashCode();
        }

        public Impl28(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl28 impl28) {
            super(windowInsetsCompat, (Impl21) impl28);
        }
    }

    @RequiresApi
    public static class Impl30 extends Impl29 {
        public static final WindowInsetsCompat q = WindowInsetsCompat.x(WindowInsets.CONSUMED);

        public Impl30(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        public final void d(@NonNull View view) {
        }

        @NonNull
        public Insets g(int i) {
            return Insets.d(this.c.getInsets(TypeImpl30.a(i)));
        }

        public boolean p(int i) {
            return this.c.isVisible(TypeImpl30.a(i));
        }

        public Impl30(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl30 impl30) {
            super(windowInsetsCompat, (Impl29) impl30);
        }
    }

    public static final class Type {

        @RestrictTo
        @Retention(RetentionPolicy.SOURCE)
        public @interface InsetsType {
        }

        public static int a() {
            return 8;
        }

        public static int b(int i) {
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 1;
            }
            if (i == 4) {
                return 2;
            }
            if (i == 8) {
                return 3;
            }
            if (i == 16) {
                return 4;
            }
            if (i == 32) {
                return 5;
            }
            if (i == 64) {
                return 6;
            }
            if (i == 128) {
                return 7;
            }
            if (i == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i);
        }

        public static int c() {
            return 32;
        }

        public static int d() {
            return 2;
        }

        public static int e() {
            return 1;
        }

        public static int f() {
            return 7;
        }
    }

    @RequiresApi
    public static final class TypeImpl30 {
        public static int a(int i) {
            int a2;
            int i2 = 0;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i & i3) != 0) {
                    if (i3 == 1) {
                        a2 = WindowInsets.Type.statusBars();
                    } else if (i3 == 2) {
                        a2 = WindowInsets.Type.navigationBars();
                    } else if (i3 == 4) {
                        a2 = WindowInsets.Type.captionBar();
                    } else if (i3 == 8) {
                        a2 = WindowInsets.Type.ime();
                    } else if (i3 == 16) {
                        a2 = WindowInsets.Type.systemGestures();
                    } else if (i3 == 32) {
                        a2 = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i3 == 64) {
                        a2 = WindowInsets.Type.tappableElement();
                    } else if (i3 == 128) {
                        a2 = WindowInsets.Type.displayCutout();
                    }
                    i2 |= a2;
                }
            }
            return i2;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            b = Impl30.q;
        } else {
            b = Impl.b;
        }
    }

    public WindowInsetsCompat(WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f913a = new Impl30(this, windowInsets);
        } else {
            this.f913a = new Impl29(this, windowInsets);
        }
    }

    public static Insets o(Insets insets, int i, int i2, int i3, int i4) {
        int max = Math.max(0, insets.f712a - i);
        int max2 = Math.max(0, insets.b - i2);
        int max3 = Math.max(0, insets.c - i3);
        int max4 = Math.max(0, insets.d - i4);
        return (max == i && max2 == i2 && max3 == i3 && max4 == i4) ? insets : Insets.b(max, max2, max3, max4);
    }

    public static WindowInsetsCompat x(WindowInsets windowInsets) {
        return y(windowInsets, (View) null);
    }

    public static WindowInsetsCompat y(WindowInsets windowInsets, View view) {
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets) Preconditions.h(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            windowInsetsCompat.u(ViewCompat.H(view));
            windowInsetsCompat.d(view.getRootView());
        }
        return windowInsetsCompat;
    }

    public WindowInsetsCompat a() {
        return this.f913a.a();
    }

    public WindowInsetsCompat b() {
        return this.f913a.b();
    }

    public WindowInsetsCompat c() {
        return this.f913a.c();
    }

    public void d(View view) {
        this.f913a.d(view);
    }

    public DisplayCutoutCompat e() {
        return this.f913a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowInsetsCompat)) {
            return false;
        }
        return ObjectsCompat.a(this.f913a, ((WindowInsetsCompat) obj).f913a);
    }

    public Insets f(int i) {
        return this.f913a.g(i);
    }

    public Insets g() {
        return this.f913a.i();
    }

    public Insets h() {
        return this.f913a.j();
    }

    public int hashCode() {
        Impl impl = this.f913a;
        if (impl == null) {
            return 0;
        }
        return impl.hashCode();
    }

    public int i() {
        return this.f913a.k().d;
    }

    public int j() {
        return this.f913a.k().f712a;
    }

    public int k() {
        return this.f913a.k().c;
    }

    public int l() {
        return this.f913a.k().b;
    }

    public boolean m() {
        return !this.f913a.k().equals(Insets.e);
    }

    public WindowInsetsCompat n(int i, int i2, int i3, int i4) {
        return this.f913a.m(i, i2, i3, i4);
    }

    public boolean p() {
        return this.f913a.n();
    }

    public boolean q(int i) {
        return this.f913a.p(i);
    }

    public WindowInsetsCompat r(int i, int i2, int i3, int i4) {
        return new Builder(this).d(Insets.b(i, i2, i3, i4)).a();
    }

    public void s(Insets[] insetsArr) {
        this.f913a.q(insetsArr);
    }

    public void t(Insets insets) {
        this.f913a.r(insets);
    }

    public void u(WindowInsetsCompat windowInsetsCompat) {
        this.f913a.s(windowInsetsCompat);
    }

    public void v(Insets insets) {
        this.f913a.t(insets);
    }

    public WindowInsets w() {
        Impl impl = this.f913a;
        if (impl instanceof Impl20) {
            return ((Impl20) impl).c;
        }
        return null;
    }

    @RequiresApi
    public static class BuilderImpl29 extends BuilderImpl {
        public final WindowInsets.Builder c;

        public BuilderImpl29() {
            this.c = new WindowInsets.Builder();
        }

        @NonNull
        public WindowInsetsCompat b() {
            a();
            WindowInsetsCompat x = WindowInsetsCompat.x(this.c.build());
            x.s(this.b);
            return x;
        }

        public void d(@NonNull Insets insets) {
            this.c.setMandatorySystemGestureInsets(insets.e());
        }

        public void e(@NonNull Insets insets) {
            this.c.setStableInsets(insets.e());
        }

        public void f(@NonNull Insets insets) {
            this.c.setSystemGestureInsets(insets.e());
        }

        public void g(@NonNull Insets insets) {
            this.c.setSystemWindowInsets(insets.e());
        }

        public void h(@NonNull Insets insets) {
            this.c.setTappableElementInsets(insets.e());
        }

        public BuilderImpl29(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            WindowInsets.Builder builder;
            WindowInsets w = windowInsetsCompat.w();
            if (w != null) {
                builder = new WindowInsets.Builder(w);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.c = builder;
        }
    }

    @RequiresApi
    public static class Impl21 extends Impl20 {
        public Insets m = null;

        public Impl21(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @NonNull
        public WindowInsetsCompat b() {
            return WindowInsetsCompat.x(this.c.consumeStableInsets());
        }

        @NonNull
        public WindowInsetsCompat c() {
            return WindowInsetsCompat.x(this.c.consumeSystemWindowInsets());
        }

        @NonNull
        public final Insets i() {
            if (this.m == null) {
                this.m = Insets.b(this.c.getStableInsetLeft(), this.c.getStableInsetTop(), this.c.getStableInsetRight(), this.c.getStableInsetBottom());
            }
            return this.m;
        }

        public boolean n() {
            return this.c.isConsumed();
        }

        public void t(@Nullable Insets insets) {
            this.m = insets;
        }

        public Impl21(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl21 impl21) {
            super(windowInsetsCompat, (Impl20) impl21);
            this.m = impl21.m;
        }
    }

    @RequiresApi
    public static class Impl20 extends Impl {
        public static boolean h = false;
        public static Method i;
        public static Class j;
        public static Field k;
        public static Field l;
        public final WindowInsets c;
        public Insets[] d;
        public Insets e;
        public WindowInsetsCompat f;
        public Insets g;

        public Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.e = null;
            this.c = windowInsets;
        }

        @SuppressLint({"WrongConstant"})
        @NonNull
        private Insets u(int i2, boolean z) {
            Insets insets = Insets.e;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    insets = Insets.a(insets, v(i3, z));
                }
            }
            return insets;
        }

        private Insets w() {
            WindowInsetsCompat windowInsetsCompat = this.f;
            return windowInsetsCompat != null ? windowInsetsCompat.g() : Insets.e;
        }

        @Nullable
        private Insets x(@NonNull View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!h) {
                    z();
                }
                Method method = i;
                if (!(method == null || j == null || k == null)) {
                    try {
                        Object invoke = method.invoke(view, (Object[]) null);
                        if (invoke == null) {
                            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) k.get(l.get(invoke));
                        if (rect != null) {
                            return Insets.c(rect);
                        }
                        return null;
                    } catch (ReflectiveOperationException e2) {
                        Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @SuppressLint({"PrivateApi"})
        private static void z() {
            try {
                i = View.class.getDeclaredMethod("getViewRootImpl", (Class[]) null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                j = cls;
                k = cls.getDeclaredField("mVisibleInsets");
                l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                k.setAccessible(true);
                l.setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
            }
            h = true;
        }

        public void d(@NonNull View view) {
            Insets x = x(view);
            if (x == null) {
                x = Insets.e;
            }
            r(x);
        }

        public void e(@NonNull WindowInsetsCompat windowInsetsCompat) {
            windowInsetsCompat.u(this.f);
            windowInsetsCompat.t(this.g);
        }

        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.g, ((Impl20) obj).g);
        }

        @NonNull
        public Insets g(int i2) {
            return u(i2, false);
        }

        @NonNull
        public final Insets k() {
            if (this.e == null) {
                this.e = Insets.b(this.c.getSystemWindowInsetLeft(), this.c.getSystemWindowInsetTop(), this.c.getSystemWindowInsetRight(), this.c.getSystemWindowInsetBottom());
            }
            return this.e;
        }

        @NonNull
        public WindowInsetsCompat m(int i2, int i3, int i4, int i5) {
            Builder builder = new Builder(WindowInsetsCompat.x(this.c));
            builder.d(WindowInsetsCompat.o(k(), i2, i3, i4, i5));
            builder.c(WindowInsetsCompat.o(i(), i2, i3, i4, i5));
            return builder.a();
        }

        public boolean o() {
            return this.c.isRound();
        }

        @SuppressLint({"WrongConstant"})
        public boolean p(int i2) {
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0 && !y(i3)) {
                    return false;
                }
            }
            return true;
        }

        public void q(Insets[] insetsArr) {
            this.d = insetsArr;
        }

        public void r(@NonNull Insets insets) {
            this.g = insets;
        }

        public void s(@Nullable WindowInsetsCompat windowInsetsCompat) {
            this.f = windowInsetsCompat;
        }

        @NonNull
        public Insets v(int i2, boolean z) {
            int i3;
            if (i2 == 1) {
                return z ? Insets.b(0, Math.max(w().b, k().b), 0, 0) : Insets.b(0, k().b, 0, 0);
            }
            Insets insets = null;
            if (i2 != 2) {
                if (i2 == 8) {
                    Insets[] insetsArr = this.d;
                    if (insetsArr != null) {
                        insets = insetsArr[Type.b(8)];
                    }
                    if (insets != null) {
                        return insets;
                    }
                    Insets k2 = k();
                    Insets w = w();
                    int i4 = k2.d;
                    if (i4 > w.d) {
                        return Insets.b(0, 0, 0, i4);
                    }
                    Insets insets2 = this.g;
                    return (insets2 == null || insets2.equals(Insets.e) || (i3 = this.g.d) <= w.d) ? Insets.e : Insets.b(0, 0, 0, i3);
                } else if (i2 == 16) {
                    return j();
                } else {
                    if (i2 == 32) {
                        return h();
                    }
                    if (i2 == 64) {
                        return l();
                    }
                    if (i2 != 128) {
                        return Insets.e;
                    }
                    WindowInsetsCompat windowInsetsCompat = this.f;
                    DisplayCutoutCompat e2 = windowInsetsCompat != null ? windowInsetsCompat.e() : f();
                    return e2 != null ? Insets.b(e2.b(), e2.d(), e2.c(), e2.a()) : Insets.e;
                }
            } else if (z) {
                Insets w2 = w();
                Insets i5 = i();
                return Insets.b(Math.max(w2.f712a, i5.f712a), 0, Math.max(w2.c, i5.c), Math.max(w2.d, i5.d));
            } else {
                Insets k3 = k();
                WindowInsetsCompat windowInsetsCompat2 = this.f;
                if (windowInsetsCompat2 != null) {
                    insets = windowInsetsCompat2.g();
                }
                int i6 = k3.d;
                if (insets != null) {
                    i6 = Math.min(i6, insets.d);
                }
                return Insets.b(k3.f712a, 0, k3.c, i6);
            }
        }

        public boolean y(int i2) {
            if (!(i2 == 1 || i2 == 2)) {
                if (i2 == 4) {
                    return false;
                }
                if (!(i2 == 8 || i2 == 128)) {
                    return true;
                }
            }
            return !v(i2, false).equals(Insets.e);
        }

        public Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl20 impl20) {
            this(windowInsetsCompat, new WindowInsets(impl20.c));
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public final BuilderImpl f915a;

        public Builder() {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f915a = new BuilderImpl30();
            } else {
                this.f915a = new BuilderImpl29();
            }
        }

        public WindowInsetsCompat a() {
            return this.f915a.b();
        }

        public Builder b(int i, Insets insets) {
            this.f915a.c(i, insets);
            return this;
        }

        public Builder c(Insets insets) {
            this.f915a.e(insets);
            return this;
        }

        public Builder d(Insets insets) {
            this.f915a.g(insets);
            return this;
        }

        public Builder(WindowInsetsCompat windowInsetsCompat) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f915a = new BuilderImpl30(windowInsetsCompat);
            } else {
                this.f915a = new BuilderImpl29(windowInsetsCompat);
            }
        }
    }

    @RequiresApi
    public static class Impl29 extends Impl28 {
        public Insets n = null;
        public Insets o = null;
        public Insets p = null;

        public Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @NonNull
        public Insets h() {
            if (this.o == null) {
                this.o = Insets.d(this.c.getMandatorySystemGestureInsets());
            }
            return this.o;
        }

        @NonNull
        public Insets j() {
            if (this.n == null) {
                this.n = Insets.d(this.c.getSystemGestureInsets());
            }
            return this.n;
        }

        @NonNull
        public Insets l() {
            if (this.p == null) {
                this.p = Insets.d(this.c.getTappableElementInsets());
            }
            return this.p;
        }

        @NonNull
        public WindowInsetsCompat m(int i, int i2, int i3, int i4) {
            return WindowInsetsCompat.x(this.c.inset(i, i2, i3, i4));
        }

        public void t(@Nullable Insets insets) {
        }

        public Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl29 impl29) {
            super(windowInsetsCompat, (Impl28) impl29);
        }
    }

    public WindowInsetsCompat(WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            Impl impl = windowInsetsCompat.f913a;
            if (Build.VERSION.SDK_INT >= 30 && (impl instanceof Impl30)) {
                this.f913a = new Impl30(this, (Impl30) impl);
            } else if (impl instanceof Impl29) {
                this.f913a = new Impl29(this, (Impl29) impl);
            } else if (impl instanceof Impl28) {
                this.f913a = new Impl28(this, (Impl28) impl);
            } else if (impl instanceof Impl21) {
                this.f913a = new Impl21(this, (Impl21) impl);
            } else if (impl instanceof Impl20) {
                this.f913a = new Impl20(this, (Impl20) impl);
            } else {
                this.f913a = new Impl(this);
            }
            impl.e(this);
            return;
        }
        this.f913a = new Impl(this);
    }
}
