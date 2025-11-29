package androidx.transition;

import android.graphics.Canvas;

class CanvasUtils {
    public static void a(Canvas canvas, boolean z) {
        if (z) {
            canvas.enableZ();
        } else {
            canvas.disableZ();
        }
    }
}
