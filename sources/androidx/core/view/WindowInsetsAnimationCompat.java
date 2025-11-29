package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import com.honey.account.q.d0;
import com.honey.account.q.e0;
import com.honey.account.q.f0;
import com.honey.account.q.g0;
import com.honey.account.q.h0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public final class WindowInsetsAnimationCompat {

    /* renamed from: a  reason: collision with root package name */
    public Impl f903a;

    public static abstract class Callback {
        public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
        public static final int DISPATCH_MODE_STOP = 0;
        WindowInsets mDispachedInsets;
        private final int mDispatchMode;

        @RestrictTo
        @Retention(RetentionPolicy.SOURCE)
        public @interface DispatchMode {
        }

        public Callback(int i) {
            this.mDispatchMode = i;
        }

        public final int getDispatchMode() {
            return this.mDispatchMode;
        }

        public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        public void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        public abstract WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List list);

        public BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat) {
            return boundsCompat;
        }
    }

    public static class Impl {

        /* renamed from: a  reason: collision with root package name */
        public final int f905a;
        public float b;
        public final Interpolator c;
        public final long d;

        public Impl(int i, Interpolator interpolator, long j) {
            this.f905a = i;
            this.c = interpolator;
            this.d = j;
        }

        public long a() {
            return this.d;
        }

        public float b() {
            Interpolator interpolator = this.c;
            return interpolator != null ? interpolator.getInterpolation(this.b) : this.b;
        }

        public int c() {
            return this.f905a;
        }

        public void d(float f) {
            this.b = f;
        }
    }

    @RequiresApi
    public static class Impl21 extends Impl {
        public static final Interpolator e = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);
        public static final Interpolator f = new FastOutLinearInInterpolator();
        public static final Interpolator g = new DecelerateInterpolator();

        @RequiresApi
        public static class Impl21OnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {

            /* renamed from: a  reason: collision with root package name */
            public final Callback f906a;
            public WindowInsetsCompat b;

            public Impl21OnApplyWindowInsetsListener(View view, Callback callback) {
                this.f906a = callback;
                WindowInsetsCompat H = ViewCompat.H(view);
                this.b = H != null ? new WindowInsetsCompat.Builder(H).a() : null;
            }

            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                final View view2 = view;
                WindowInsets windowInsets2 = windowInsets;
                if (!view.isLaidOut()) {
                    this.b = WindowInsetsCompat.y(windowInsets2, view2);
                    return Impl21.m(view, windowInsets);
                }
                WindowInsetsCompat y = WindowInsetsCompat.y(windowInsets2, view2);
                if (this.b == null) {
                    this.b = ViewCompat.H(view);
                }
                if (this.b == null) {
                    this.b = y;
                    return Impl21.m(view, windowInsets);
                }
                Callback n = Impl21.n(view);
                if (n != null && Objects.equals(n.mDispachedInsets, windowInsets2)) {
                    return Impl21.m(view, windowInsets);
                }
                final int e = Impl21.e(y, this.b);
                if (e == 0) {
                    return Impl21.m(view, windowInsets);
                }
                final WindowInsetsCompat windowInsetsCompat = this.b;
                final WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(e, Impl21.g(e, y, windowInsetsCompat), 160);
                windowInsetsAnimationCompat.e(0.0f);
                ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(windowInsetsAnimationCompat.a());
                BoundsCompat f = Impl21.f(y, windowInsetsCompat, e);
                Impl21.j(view2, windowInsetsAnimationCompat, windowInsets2, false);
                final WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = windowInsetsAnimationCompat;
                final WindowInsetsCompat windowInsetsCompat2 = y;
                final View view3 = view;
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        windowInsetsAnimationCompat2.e(valueAnimator.getAnimatedFraction());
                        Impl21.k(view3, Impl21.o(windowInsetsCompat2, windowInsetsCompat, windowInsetsAnimationCompat2.b(), e), Collections.singletonList(windowInsetsAnimationCompat2));
                    }
                });
                duration.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        windowInsetsAnimationCompat.e(1.0f);
                        Impl21.i(view2, windowInsetsAnimationCompat);
                    }
                });
                final View view4 = view;
                final WindowInsetsAnimationCompat windowInsetsAnimationCompat3 = windowInsetsAnimationCompat;
                final BoundsCompat boundsCompat = f;
                final ValueAnimator valueAnimator = duration;
                OneShotPreDrawListener.a(view2, new Runnable() {
                    public void run() {
                        Impl21.l(view4, windowInsetsAnimationCompat3, boundsCompat);
                        valueAnimator.start();
                    }
                });
                this.b = y;
                return Impl21.m(view, windowInsets);
            }
        }

        public Impl21(int i, Interpolator interpolator, long j) {
            super(i, interpolator, j);
        }

        public static int e(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2) {
            int i = 0;
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if (!windowInsetsCompat.f(i2).equals(windowInsetsCompat2.f(i2))) {
                    i |= i2;
                }
            }
            return i;
        }

        public static BoundsCompat f(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, int i) {
            Insets f2 = windowInsetsCompat.f(i);
            Insets f3 = windowInsetsCompat2.f(i);
            return new BoundsCompat(Insets.b(Math.min(f2.f712a, f3.f712a), Math.min(f2.b, f3.b), Math.min(f2.c, f3.c), Math.min(f2.d, f3.d)), Insets.b(Math.max(f2.f712a, f3.f712a), Math.max(f2.b, f3.b), Math.max(f2.c, f3.c), Math.max(f2.d, f3.d)));
        }

        public static Interpolator g(int i, WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2) {
            return (i & 8) != 0 ? windowInsetsCompat.f(WindowInsetsCompat.Type.a()).d > windowInsetsCompat2.f(WindowInsetsCompat.Type.a()).d ? e : f : g;
        }

        public static View.OnApplyWindowInsetsListener h(View view, Callback callback) {
            return new Impl21OnApplyWindowInsetsListener(view, callback);
        }

        public static void i(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            Callback n = n(view);
            if (n != null) {
                n.onEnd(windowInsetsAnimationCompat);
                if (n.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    i(viewGroup.getChildAt(i), windowInsetsAnimationCompat);
                }
            }
        }

        public static void j(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsets windowInsets, boolean z) {
            Callback n = n(view);
            if (n != null) {
                n.mDispachedInsets = windowInsets;
                if (!z) {
                    n.onPrepare(windowInsetsAnimationCompat);
                    z = n.getDispatchMode() == 0;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    j(viewGroup.getChildAt(i), windowInsetsAnimationCompat, windowInsets, z);
                }
            }
        }

        public static void k(View view, WindowInsetsCompat windowInsetsCompat, List list) {
            Callback n = n(view);
            if (n != null) {
                windowInsetsCompat = n.onProgress(windowInsetsCompat, list);
                if (n.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    k(viewGroup.getChildAt(i), windowInsetsCompat, list);
                }
            }
        }

        public static void l(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat) {
            Callback n = n(view);
            if (n != null) {
                n.onStart(windowInsetsAnimationCompat, boundsCompat);
                if (n.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    l(viewGroup.getChildAt(i), windowInsetsAnimationCompat, boundsCompat);
                }
            }
        }

        public static WindowInsets m(View view, WindowInsets windowInsets) {
            return view.getTag(R.id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
        }

        public static Callback n(View view) {
            Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
            if (tag instanceof Impl21OnApplyWindowInsetsListener) {
                return ((Impl21OnApplyWindowInsetsListener) tag).f906a;
            }
            return null;
        }

        public static WindowInsetsCompat o(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, float f2, int i) {
            WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(windowInsetsCompat);
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) == 0) {
                    builder.b(i2, windowInsetsCompat.f(i2));
                } else {
                    Insets f3 = windowInsetsCompat.f(i2);
                    Insets f4 = windowInsetsCompat2.f(i2);
                    float f5 = 1.0f - f2;
                    builder.b(i2, WindowInsetsCompat.o(f3, (int) (((double) (((float) (f3.f712a - f4.f712a)) * f5)) + 0.5d), (int) (((double) (((float) (f3.b - f4.b)) * f5)) + 0.5d), (int) (((double) (((float) (f3.c - f4.c)) * f5)) + 0.5d), (int) (((double) (((float) (f3.d - f4.d)) * f5)) + 0.5d)));
                }
            }
            return builder.a();
        }

        public static void p(View view, Callback callback) {
            Object tag = view.getTag(R.id.tag_on_apply_window_listener);
            if (callback == null) {
                view.setTag(R.id.tag_window_insets_animation_callback, (Object) null);
                if (tag == null) {
                    view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) null);
                    return;
                }
                return;
            }
            View.OnApplyWindowInsetsListener h = h(view, callback);
            view.setTag(R.id.tag_window_insets_animation_callback, h);
            if (tag == null) {
                view.setOnApplyWindowInsetsListener(h);
            }
        }
    }

    public WindowInsetsAnimationCompat(int i, Interpolator interpolator, long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f903a = new Impl30(i, interpolator, j);
        } else {
            this.f903a = new Impl21(i, interpolator, j);
        }
    }

    public static void d(View view, Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            Impl30.h(view, callback);
        } else {
            Impl21.p(view, callback);
        }
    }

    public static WindowInsetsAnimationCompat f(WindowInsetsAnimation windowInsetsAnimation) {
        return new WindowInsetsAnimationCompat(windowInsetsAnimation);
    }

    public long a() {
        return this.f903a.a();
    }

    public float b() {
        return this.f903a.b();
    }

    public int c() {
        return this.f903a.c();
    }

    public void e(float f) {
        this.f903a.d(f);
    }

    @RequiresApi
    public static class Impl30 extends Impl {
        public final WindowInsetsAnimation e;

        @RequiresApi
        public static class ProxyCallback extends WindowInsetsAnimation$Callback {

            /* renamed from: a  reason: collision with root package name */
            public final Callback f910a;
            public List b;
            public ArrayList c;
            public final HashMap d = new HashMap();

            public ProxyCallback(Callback callback) {
                super(callback.getDispatchMode());
                this.f910a = callback;
            }

            public final WindowInsetsAnimationCompat a(WindowInsetsAnimation windowInsetsAnimation) {
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = (WindowInsetsAnimationCompat) this.d.get(windowInsetsAnimation);
                if (windowInsetsAnimationCompat != null) {
                    return windowInsetsAnimationCompat;
                }
                WindowInsetsAnimationCompat f = WindowInsetsAnimationCompat.f(windowInsetsAnimation);
                this.d.put(windowInsetsAnimation, f);
                return f;
            }

            public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.f910a.onEnd(a(windowInsetsAnimation));
                this.d.remove(windowInsetsAnimation);
            }

            public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.f910a.onPrepare(a(windowInsetsAnimation));
            }

            public WindowInsets onProgress(WindowInsets windowInsets, List list) {
                ArrayList arrayList = this.c;
                if (arrayList == null) {
                    ArrayList arrayList2 = new ArrayList(list.size());
                    this.c = arrayList2;
                    this.b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation a2 = g0.a(list.get(size));
                    WindowInsetsAnimationCompat a3 = a(a2);
                    a3.e(h0.a(a2));
                    this.c.add(a3);
                }
                return this.f910a.onProgress(WindowInsetsCompat.x(windowInsets), this.b).w();
            }

            public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                return this.f910a.onStart(a(windowInsetsAnimation), BoundsCompat.d(bounds)).c();
            }
        }

        public Impl30(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, (Interpolator) null, 0);
            this.e = windowInsetsAnimation;
        }

        public static WindowInsetsAnimation.Bounds e(BoundsCompat boundsCompat) {
            f0.a();
            return e0.a(boundsCompat.a().e(), boundsCompat.b().e());
        }

        public static Insets f(WindowInsetsAnimation.Bounds bounds) {
            return Insets.d(bounds.getUpperBound());
        }

        public static Insets g(WindowInsetsAnimation.Bounds bounds) {
            return Insets.d(bounds.getLowerBound());
        }

        public static void h(View view, Callback callback) {
            view.setWindowInsetsAnimationCallback(callback != null ? new ProxyCallback(callback) : null);
        }

        public long a() {
            return this.e.getDurationMillis();
        }

        public float b() {
            return this.e.getInterpolatedFraction();
        }

        public int c() {
            return this.e.getTypeMask();
        }

        public void d(float f) {
            this.e.setFraction(f);
        }

        public Impl30(int i, Interpolator interpolator, long j) {
            this(d0.a(i, interpolator, j));
        }
    }

    public static final class BoundsCompat {

        /* renamed from: a  reason: collision with root package name */
        public final Insets f904a;
        public final Insets b;

        public BoundsCompat(Insets insets, Insets insets2) {
            this.f904a = insets;
            this.b = insets2;
        }

        public static BoundsCompat d(WindowInsetsAnimation.Bounds bounds) {
            return new BoundsCompat(bounds);
        }

        public Insets a() {
            return this.f904a;
        }

        public Insets b() {
            return this.b;
        }

        public WindowInsetsAnimation.Bounds c() {
            return Impl30.e(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.f904a + " upper=" + this.b + "}";
        }

        public BoundsCompat(WindowInsetsAnimation.Bounds bounds) {
            this.f904a = Impl30.g(bounds);
            this.b = Impl30.f(bounds);
        }
    }

    public WindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, (Interpolator) null, 0);
        if (Build.VERSION.SDK_INT >= 30) {
            this.f903a = new Impl30(windowInsetsAnimation);
        }
    }
}
