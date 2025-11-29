package androidx.constraintlayout.core.motion;

import com.geetest.sdk.x;
import com.meizu.common.datetimepicker.date.MonthView;

class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    public static String[] b = {"position", x.f, "y", MonthView.VIEW_PARAMS_WIDTH, MonthView.VIEW_PARAMS_HEIGHT, "pathRotate"};

    /* renamed from: a  reason: collision with root package name */
    public float f491a;

    /* renamed from: a */
    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.f491a, motionConstrainedPoint.f491a);
    }
}
