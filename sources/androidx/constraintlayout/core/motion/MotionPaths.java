package androidx.constraintlayout.core.motion;

import com.geetest.sdk.x;
import com.meizu.common.datetimepicker.date.MonthView;

public class MotionPaths implements Comparable<MotionPaths> {
    public static String[] d = {"position", x.f, "y", MonthView.VIEW_PARAMS_WIDTH, MonthView.VIEW_PARAMS_HEIGHT, "pathRotate"};

    /* renamed from: a  reason: collision with root package name */
    public float f492a;
    public float b;
    public float c;

    /* renamed from: a */
    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.f492a, motionPaths.f492a);
    }
}
