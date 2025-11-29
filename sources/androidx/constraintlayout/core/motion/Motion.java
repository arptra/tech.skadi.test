package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.DifferentialInterpolator;
import androidx.constraintlayout.core.motion.utils.TypedValues;

public class Motion implements TypedValues {

    /* renamed from: a  reason: collision with root package name */
    public MotionPaths f490a;
    public MotionPaths b;

    /* renamed from: androidx.constraintlayout.core.motion.Motion$1  reason: invalid class name */
    final class AnonymousClass1 implements DifferentialInterpolator {
    }

    public String toString() {
        return " start: x: " + this.f490a.b + " y: " + this.f490a.c + " end: x: " + this.b.b + " y: " + this.b.c;
    }
}
