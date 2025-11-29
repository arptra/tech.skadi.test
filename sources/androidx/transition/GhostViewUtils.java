package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;

class GhostViewUtils {
    public static GhostView a(View view, ViewGroup viewGroup, Matrix matrix) {
        return GhostViewPort.b(view, viewGroup, matrix);
    }

    public static void b(View view) {
        GhostViewPort.f(view);
    }
}
