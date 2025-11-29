package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.DynamicAnimation;

public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    public final DragForce A;

    public static final class DragForce implements Force {

        /* renamed from: a  reason: collision with root package name */
        public float f1187a;
        public float b;
        public final DynamicAnimation.MassState c;

        public boolean a(float f, float f2) {
            return Math.abs(f2) < this.b;
        }

        public void b(float f) {
            this.b = f * 62.5f;
        }

        public DynamicAnimation.MassState c(float f, float f2, long j) {
            float f3 = (float) j;
            this.c.b = (float) (((double) f2) * Math.exp((double) ((f3 / 1000.0f) * this.f1187a)));
            DynamicAnimation.MassState massState = this.c;
            float f4 = this.f1187a;
            massState.f1186a = (float) (((double) (f - (f2 / f4))) + (((double) (f2 / f4)) * Math.exp((double) ((f4 * f3) / 1000.0f))));
            DynamicAnimation.MassState massState2 = this.c;
            if (a(massState2.f1186a, massState2.b)) {
                this.c.b = 0.0f;
            }
            return this.c;
        }
    }

    public void p(float f) {
        this.A.b(f);
    }

    public boolean s(long j) {
        DynamicAnimation.MassState c = this.A.c(this.b, this.f1184a, j);
        float f = c.f1186a;
        this.b = f;
        float f2 = c.b;
        this.f1184a = f2;
        float f3 = this.h;
        if (f < f3) {
            this.b = f3;
            return true;
        }
        float f4 = this.g;
        if (f <= f4) {
            return t(f, f2);
        }
        this.b = f4;
        return true;
    }

    public boolean t(float f, float f2) {
        return f >= this.g || f <= this.h || this.A.a(f, f2);
    }
}
