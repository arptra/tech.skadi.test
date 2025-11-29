package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.core.motion.utils.SpringStopEngine;
import androidx.constraintlayout.core.motion.utils.StopEngine;
import androidx.constraintlayout.core.motion.utils.StopLogicEngine;
import androidx.constraintlayout.motion.widget.MotionInterpolator;

public class StopLogic extends MotionInterpolator {

    /* renamed from: a  reason: collision with root package name */
    public StopLogicEngine f550a;
    public SpringStopEngine b;
    public StopEngine c;

    public StopLogic() {
        StopLogicEngine stopLogicEngine = new StopLogicEngine();
        this.f550a = stopLogicEngine;
        this.c = stopLogicEngine;
    }

    public float a() {
        return this.c.a();
    }

    public void b(float f, float f2, float f3, float f4, float f5, float f6) {
        StopLogicEngine stopLogicEngine = this.f550a;
        this.c = stopLogicEngine;
        stopLogicEngine.c(f, f2, f3, f4, f5, f6);
    }

    public boolean c() {
        return this.c.isStopped();
    }

    public void d(float f, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        if (this.b == null) {
            this.b = new SpringStopEngine();
        }
        SpringStopEngine springStopEngine = this.b;
        this.c = springStopEngine;
        springStopEngine.c(f, f2, f3, f4, f5, f6, f7, i);
    }

    public float getInterpolation(float f) {
        return this.c.getInterpolation(f);
    }
}
