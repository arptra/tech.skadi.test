package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.AnimationHandler;
import androidx.dynamicanimation.animation.DynamicAnimation;
import com.geetest.sdk.x;
import java.util.ArrayList;

public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationHandler.AnimationFrameCallback {
    public static final ViewProperty m = new ViewProperty("translationX") {
        /* renamed from: a */
        public float getValue(View view) {
            return view.getTranslationX();
        }

        /* renamed from: b */
        public void setValue(View view, float f) {
            view.setTranslationX(f);
        }
    };
    public static final ViewProperty n = new ViewProperty("translationY") {
        /* renamed from: a */
        public float getValue(View view) {
            return view.getTranslationY();
        }

        /* renamed from: b */
        public void setValue(View view, float f) {
            view.setTranslationY(f);
        }
    };
    public static final ViewProperty o = new ViewProperty("translationZ") {
        /* renamed from: a */
        public float getValue(View view) {
            return ViewCompat.M(view);
        }

        /* renamed from: b */
        public void setValue(View view, float f) {
            ViewCompat.a1(view, f);
        }
    };
    public static final ViewProperty p = new ViewProperty("scaleX") {
        /* renamed from: a */
        public float getValue(View view) {
            return view.getScaleX();
        }

        /* renamed from: b */
        public void setValue(View view, float f) {
            view.setScaleX(f);
        }
    };
    public static final ViewProperty q = new ViewProperty("scaleY") {
        /* renamed from: a */
        public float getValue(View view) {
            return view.getScaleY();
        }

        /* renamed from: b */
        public void setValue(View view, float f) {
            view.setScaleY(f);
        }
    };
    public static final ViewProperty r = new ViewProperty("rotation") {
        /* renamed from: a */
        public float getValue(View view) {
            return view.getRotation();
        }

        /* renamed from: b */
        public void setValue(View view, float f) {
            view.setRotation(f);
        }
    };
    public static final ViewProperty s = new ViewProperty("rotationX") {
        /* renamed from: a */
        public float getValue(View view) {
            return view.getRotationX();
        }

        /* renamed from: b */
        public void setValue(View view, float f) {
            view.setRotationX(f);
        }
    };
    public static final ViewProperty t = new ViewProperty("rotationY") {
        /* renamed from: a */
        public float getValue(View view) {
            return view.getRotationY();
        }

        /* renamed from: b */
        public void setValue(View view, float f) {
            view.setRotationY(f);
        }
    };
    public static final ViewProperty u = new ViewProperty(x.f) {
        /* renamed from: a */
        public float getValue(View view) {
            return view.getX();
        }

        /* renamed from: b */
        public void setValue(View view, float f) {
            view.setX(f);
        }
    };
    public static final ViewProperty v = new ViewProperty("y") {
        /* renamed from: a */
        public float getValue(View view) {
            return view.getY();
        }

        /* renamed from: b */
        public void setValue(View view, float f) {
            view.setY(f);
        }
    };
    public static final ViewProperty w = new ViewProperty("z") {
        /* renamed from: a */
        public float getValue(View view) {
            return ViewCompat.P(view);
        }

        /* renamed from: b */
        public void setValue(View view, float f) {
            ViewCompat.c1(view, f);
        }
    };
    public static final ViewProperty x = new ViewProperty("alpha") {
        /* renamed from: a */
        public float getValue(View view) {
            return view.getAlpha();
        }

        /* renamed from: b */
        public void setValue(View view, float f) {
            view.setAlpha(f);
        }
    };
    public static final ViewProperty y = new ViewProperty("scrollX") {
        /* renamed from: a */
        public float getValue(View view) {
            return (float) view.getScrollX();
        }

        /* renamed from: b */
        public void setValue(View view, float f) {
            view.setScrollX((int) f);
        }
    };
    public static final ViewProperty z = new ViewProperty("scrollY") {
        /* renamed from: a */
        public float getValue(View view) {
            return (float) view.getScrollY();
        }

        /* renamed from: b */
        public void setValue(View view, float f) {
            view.setScrollY((int) f);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public float f1184a;
    public float b;
    public boolean c;
    public final Object d;
    public final FloatPropertyCompat e;
    public boolean f;
    public float g;
    public float h;
    public long i;
    public float j;
    public final ArrayList k;
    public final ArrayList l;

    public static class MassState {

        /* renamed from: a  reason: collision with root package name */
        public float f1186a;
        public float b;
    }

    public interface OnAnimationEndListener {
        void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2);
    }

    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2);
    }

    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
        public ViewProperty(String str) {
            super(str);
        }
    }

    public DynamicAnimation(final FloatValueHolder floatValueHolder) {
        this.f1184a = 0.0f;
        this.b = Float.MAX_VALUE;
        this.c = false;
        this.f = false;
        this.g = Float.MAX_VALUE;
        this.h = -Float.MAX_VALUE;
        this.i = 0;
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.d = null;
        this.e = new FloatPropertyCompat("FloatValueHolder") {
            public float getValue(Object obj) {
                return floatValueHolder.a();
            }

            public void setValue(Object obj, float f) {
                floatValueHolder.b(f);
            }
        };
        this.j = 1.0f;
    }

    public static void j(ArrayList arrayList, Object obj) {
        int indexOf = arrayList.indexOf(obj);
        if (indexOf >= 0) {
            arrayList.set(indexOf, (Object) null);
        }
    }

    public static void k(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public boolean a(long j2) {
        long j3 = this.i;
        if (j3 == 0) {
            this.i = j2;
            m(this.b);
            return false;
        }
        this.i = j2;
        boolean s2 = s(j2 - j3);
        float min = Math.min(this.b, this.g);
        this.b = min;
        float max = Math.max(min, this.h);
        this.b = max;
        m(max);
        if (s2) {
            e(false);
        }
        return s2;
    }

    public DynamicAnimation b(OnAnimationEndListener onAnimationEndListener) {
        if (!this.k.contains(onAnimationEndListener)) {
            this.k.add(onAnimationEndListener);
        }
        return this;
    }

    public DynamicAnimation c(OnAnimationUpdateListener onAnimationUpdateListener) {
        if (!h()) {
            if (!this.l.contains(onAnimationUpdateListener)) {
                this.l.add(onAnimationUpdateListener);
            }
            return this;
        }
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    }

    public void d() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        } else if (this.f) {
            e(true);
        }
    }

    public final void e(boolean z2) {
        this.f = false;
        AnimationHandler.d().g(this);
        this.i = 0;
        this.c = false;
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            if (this.k.get(i2) != null) {
                ((OnAnimationEndListener) this.k.get(i2)).onAnimationEnd(this, z2, this.b, this.f1184a);
            }
        }
        k(this.k);
    }

    public final float f() {
        return this.e.getValue(this.d);
    }

    public float g() {
        return this.j * 0.75f;
    }

    public boolean h() {
        return this.f;
    }

    public void i(OnAnimationEndListener onAnimationEndListener) {
        j(this.k, onAnimationEndListener);
    }

    public DynamicAnimation l(float f2) {
        if (f2 > 0.0f) {
            this.j = f2;
            p(f2 * 0.75f);
            return this;
        }
        throw new IllegalArgumentException("Minimum visible change must be positive.");
    }

    public void m(float f2) {
        this.e.setValue(this.d, f2);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            if (this.l.get(i2) != null) {
                ((OnAnimationUpdateListener) this.l.get(i2)).onAnimationUpdate(this, this.b, this.f1184a);
            }
        }
        k(this.l);
    }

    public DynamicAnimation n(float f2) {
        this.b = f2;
        this.c = true;
        return this;
    }

    public DynamicAnimation o(float f2) {
        this.f1184a = f2;
        return this;
    }

    public abstract void p(float f2);

    public void q() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else if (!this.f) {
            r();
        }
    }

    public final void r() {
        if (!this.f) {
            this.f = true;
            if (!this.c) {
                this.b = f();
            }
            float f2 = this.b;
            if (f2 > this.g || f2 < this.h) {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            }
            AnimationHandler.d().a(this, 0);
        }
    }

    public abstract boolean s(long j2);

    public DynamicAnimation(Object obj, FloatPropertyCompat floatPropertyCompat) {
        this.f1184a = 0.0f;
        this.b = Float.MAX_VALUE;
        this.c = false;
        this.f = false;
        this.g = Float.MAX_VALUE;
        this.h = -Float.MAX_VALUE;
        this.i = 0;
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.d = obj;
        this.e = floatPropertyCompat;
        if (floatPropertyCompat == r || floatPropertyCompat == s || floatPropertyCompat == t) {
            this.j = 0.1f;
        } else if (floatPropertyCompat == x) {
            this.j = 0.00390625f;
        } else if (floatPropertyCompat == p || floatPropertyCompat == q) {
            this.j = 0.00390625f;
        } else {
            this.j = 1.0f;
        }
    }
}
