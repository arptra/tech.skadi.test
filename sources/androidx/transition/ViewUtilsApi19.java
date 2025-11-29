package androidx.transition;

import android.view.View;
import androidx.annotation.RequiresApi;

@RequiresApi
class ViewUtilsApi19 extends ViewUtilsBase {
    public static boolean f = true;

    public void a(View view) {
    }

    public float c(View view) {
        if (f) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f = false;
            }
        }
        return view.getAlpha();
    }

    public void d(View view) {
    }

    public void g(View view, float f2) {
        if (f) {
            try {
                view.setTransitionAlpha(f2);
                return;
            } catch (NoSuchMethodError unused) {
                f = false;
            }
        }
        view.setAlpha(f2);
    }
}
