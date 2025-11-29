package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import androidx.core.view.ViewCompat;

class ViewUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final ViewUtilsBase f1883a = new ViewUtilsApi29();
    public static final Property b = new Property<View, Float>(Float.class, "translationAlpha") {
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(ViewUtils.c(view));
        }

        /* renamed from: b */
        public void set(View view, Float f) {
            ViewUtils.h(view, f.floatValue());
        }
    };
    public static final Property c = new Property<View, Rect>(Rect.class, "clipBounds") {
        /* renamed from: a */
        public Rect get(View view) {
            return ViewCompat.s(view);
        }

        /* renamed from: b */
        public void set(View view, Rect rect) {
            ViewCompat.C0(view, rect);
        }
    };

    public static void a(View view) {
        f1883a.a(view);
    }

    public static ViewOverlayImpl b(View view) {
        return new ViewOverlayApi18(view);
    }

    public static float c(View view) {
        return f1883a.c(view);
    }

    public static WindowIdImpl d(View view) {
        return new WindowIdApi18(view);
    }

    public static void e(View view) {
        f1883a.d(view);
    }

    public static void f(View view, Matrix matrix) {
        f1883a.e(view, matrix);
    }

    public static void g(View view, int i, int i2, int i3, int i4) {
        f1883a.f(view, i, i2, i3, i4);
    }

    public static void h(View view, float f) {
        f1883a.g(view, f);
    }

    public static void i(View view, int i) {
        f1883a.h(view, i);
    }

    public static void j(View view, Matrix matrix) {
        f1883a.i(view, matrix);
    }

    public static void k(View view, Matrix matrix) {
        f1883a.j(view, matrix);
    }
}
