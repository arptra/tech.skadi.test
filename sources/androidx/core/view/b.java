package androidx.core.view;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.core.view.DifferentialMotionFlingController;

public final /* synthetic */ class b implements DifferentialMotionFlingController.DifferentialVelocityProvider {
    public final float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i) {
        return DifferentialMotionFlingController.f(velocityTracker, motionEvent, i);
    }
}
