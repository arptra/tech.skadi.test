package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import androidx.dynamicanimation.animation.DynamicAnimation;

public final class SpringAnimation extends DynamicAnimation<SpringAnimation> {
    public SpringForce A = null;
    public float B = Float.MAX_VALUE;
    public boolean C = false;

    public SpringAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
    }

    public void p(float f) {
    }

    public void q() {
        x();
        this.A.g((double) g());
        super.q();
    }

    public boolean s(long j) {
        if (this.C) {
            float f = this.B;
            if (f != Float.MAX_VALUE) {
                this.A.e(f);
                this.B = Float.MAX_VALUE;
            }
            this.b = this.A.a();
            this.f1184a = 0.0f;
            this.C = false;
            return true;
        }
        if (this.B != Float.MAX_VALUE) {
            this.A.a();
            long j2 = j / 2;
            DynamicAnimation.MassState h = this.A.h((double) this.b, (double) this.f1184a, j2);
            this.A.e(this.B);
            this.B = Float.MAX_VALUE;
            DynamicAnimation.MassState h2 = this.A.h((double) h.f1186a, (double) h.b, j2);
            this.b = h2.f1186a;
            this.f1184a = h2.b;
        } else {
            DynamicAnimation.MassState h3 = this.A.h((double) this.b, (double) this.f1184a, j);
            this.b = h3.f1186a;
            this.f1184a = h3.b;
        }
        float max = Math.max(this.b, this.h);
        this.b = max;
        float min = Math.min(max, this.g);
        this.b = min;
        if (!w(min, this.f1184a)) {
            return false;
        }
        this.b = this.A.a();
        this.f1184a = 0.0f;
        return true;
    }

    public void t(float f) {
        if (h()) {
            this.B = f;
            return;
        }
        if (this.A == null) {
            this.A = new SpringForce(f);
        }
        this.A.e(f);
        q();
    }

    public boolean u() {
        return this.A.b > 0.0d;
    }

    public SpringForce v() {
        return this.A;
    }

    public boolean w(float f, float f2) {
        return this.A.c(f, f2);
    }

    public final void x() {
        SpringForce springForce = this.A;
        if (springForce != null) {
            double a2 = (double) springForce.a();
            if (a2 > ((double) this.g)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
            } else if (a2 < ((double) this.h)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
            }
        } else {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
    }

    public SpringAnimation y(SpringForce springForce) {
        this.A = springForce;
        return this;
    }

    public void z() {
        if (!u()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else if (this.f) {
            this.C = true;
        }
    }

    public SpringAnimation(Object obj, FloatPropertyCompat floatPropertyCompat) {
        super(obj, floatPropertyCompat);
    }
}
