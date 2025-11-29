package androidx.core.view;

import android.view.MotionEvent;

public final class MotionEventCompat {
    public static int a(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    public static int b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public static boolean c(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
