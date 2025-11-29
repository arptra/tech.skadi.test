package androidx.core.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.VisibleForTesting;

public class DifferentialMotionFlingController {

    /* renamed from: a  reason: collision with root package name */
    public final Context f868a;
    public final DifferentialMotionFlingTarget b;
    public final FlingVelocityThresholdCalculator c;
    public final DifferentialVelocityProvider d;
    public VelocityTracker e;
    public float f;
    public int g;
    public int h;
    public int i;
    public final int[] j;

    @VisibleForTesting
    public interface DifferentialVelocityProvider {
        float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i);
    }

    @VisibleForTesting
    public interface FlingVelocityThresholdCalculator {
        void a(Context context, int[] iArr, MotionEvent motionEvent, int i);
    }

    public DifferentialMotionFlingController(Context context, DifferentialMotionFlingTarget differentialMotionFlingTarget) {
        this(context, differentialMotionFlingTarget, new a(), new b());
    }

    public static void c(Context context, int[] iArr, MotionEvent motionEvent, int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        iArr[0] = ViewConfigurationCompat.g(context, viewConfiguration, motionEvent.getDeviceId(), i2, motionEvent.getSource());
        iArr[1] = ViewConfigurationCompat.f(context, viewConfiguration, motionEvent.getDeviceId(), i2, motionEvent.getSource());
    }

    public static float f(VelocityTracker velocityTracker, MotionEvent motionEvent, int i2) {
        VelocityTrackerCompat.a(velocityTracker, motionEvent);
        VelocityTrackerCompat.b(velocityTracker, 1000);
        return VelocityTrackerCompat.d(velocityTracker, i2);
    }

    public final boolean d(MotionEvent motionEvent, int i2) {
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        if (this.h == source && this.i == deviceId && this.g == i2) {
            return false;
        }
        this.c.a(this.f868a, this.j, motionEvent, i2);
        this.h = source;
        this.i = deviceId;
        this.g = i2;
        return true;
    }

    public final float e(MotionEvent motionEvent, int i2) {
        if (this.e == null) {
            this.e = VelocityTracker.obtain();
        }
        return this.d.a(this.e, motionEvent, i2);
    }

    public void g(MotionEvent motionEvent, int i2) {
        boolean d2 = d(motionEvent, i2);
        if (this.j[0] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.e = null;
                return;
            }
            return;
        }
        float e2 = e(motionEvent, i2) * this.b.a();
        float signum = Math.signum(e2);
        float f2 = 0.0f;
        if (d2 || !(signum == Math.signum(this.f) || signum == 0.0f)) {
            this.b.c();
        }
        float abs = Math.abs(e2);
        int[] iArr = this.j;
        if (abs >= ((float) iArr[0])) {
            int i3 = iArr[1];
            float max = Math.max((float) (-i3), Math.min(e2, (float) i3));
            if (this.b.b(max)) {
                f2 = max;
            }
            this.f = f2;
        }
    }

    public DifferentialMotionFlingController(Context context, DifferentialMotionFlingTarget differentialMotionFlingTarget, FlingVelocityThresholdCalculator flingVelocityThresholdCalculator, DifferentialVelocityProvider differentialVelocityProvider) {
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = new int[]{Integer.MAX_VALUE, 0};
        this.f868a = context;
        this.b = differentialMotionFlingTarget;
        this.c = flingVelocityThresholdCalculator;
        this.d = differentialVelocityProvider;
    }
}
