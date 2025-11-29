package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.DynamicAnimation;

public final class SpringForce implements Force {

    /* renamed from: a  reason: collision with root package name */
    public double f1190a = Math.sqrt(1500.0d);
    public double b = 0.5d;
    public boolean c = false;
    public double d;
    public double e;
    public double f;
    public double g;
    public double h;
    public double i = Double.MAX_VALUE;
    public final DynamicAnimation.MassState j = new DynamicAnimation.MassState();

    public SpringForce() {
    }

    public float a() {
        return (float) this.i;
    }

    public final void b() {
        if (!this.c) {
            if (this.i != Double.MAX_VALUE) {
                double d2 = this.b;
                if (d2 > 1.0d) {
                    double d3 = this.f1190a;
                    this.f = ((-d2) * d3) + (d3 * Math.sqrt((d2 * d2) - 1.0d));
                    double d4 = this.b;
                    double d5 = this.f1190a;
                    this.g = ((-d4) * d5) - (d5 * Math.sqrt((d4 * d4) - 1.0d));
                } else if (d2 >= 0.0d && d2 < 1.0d) {
                    this.h = this.f1190a * Math.sqrt(1.0d - (d2 * d2));
                }
                this.c = true;
                return;
            }
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
    }

    public boolean c(float f2, float f3) {
        return ((double) Math.abs(f3)) < this.e && ((double) Math.abs(f2 - a())) < this.d;
    }

    public SpringForce d(float f2) {
        if (f2 >= 0.0f) {
            this.b = (double) f2;
            this.c = false;
            return this;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public SpringForce e(float f2) {
        this.i = (double) f2;
        return this;
    }

    public SpringForce f(float f2) {
        if (f2 > 0.0f) {
            this.f1190a = Math.sqrt((double) f2);
            this.c = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public void g(double d2) {
        double abs = Math.abs(d2);
        this.d = abs;
        this.e = abs * 62.5d;
    }

    public DynamicAnimation.MassState h(double d2, double d3, long j2) {
        double d4;
        double d5;
        b();
        double d6 = ((double) j2) / 1000.0d;
        double d7 = d2 - this.i;
        double d8 = this.b;
        if (d8 > 1.0d) {
            double d9 = this.g;
            double d10 = this.f;
            double d11 = d7 - (((d9 * d7) - d3) / (d9 - d10));
            double d12 = ((d7 * d9) - d3) / (d9 - d10);
            d5 = (Math.pow(2.718281828459045d, d9 * d6) * d11) + (Math.pow(2.718281828459045d, this.f * d6) * d12);
            double d13 = this.g;
            double pow = d11 * d13 * Math.pow(2.718281828459045d, d13 * d6);
            double d14 = this.f;
            d4 = pow + (d12 * d14 * Math.pow(2.718281828459045d, d14 * d6));
        } else if (d8 == 1.0d) {
            double d15 = this.f1190a;
            double d16 = d3 + (d15 * d7);
            double d17 = d7 + (d16 * d6);
            d5 = Math.pow(2.718281828459045d, (-d15) * d6) * d17;
            double pow2 = d17 * Math.pow(2.718281828459045d, (-this.f1190a) * d6);
            double d18 = this.f1190a;
            d4 = (d16 * Math.pow(2.718281828459045d, (-d18) * d6)) + (pow2 * (-d18));
        } else {
            double d19 = 1.0d / this.h;
            double d20 = this.f1190a;
            double d21 = d19 * ((d8 * d20 * d7) + d3);
            double pow3 = Math.pow(2.718281828459045d, (-d8) * d20 * d6) * ((Math.cos(this.h * d6) * d7) + (Math.sin(this.h * d6) * d21));
            double d22 = this.f1190a;
            double d23 = this.b;
            double pow4 = Math.pow(2.718281828459045d, (-d23) * d22 * d6);
            double d24 = this.h;
            double d25 = pow3;
            double sin = (-d24) * d7 * Math.sin(d24 * d6);
            double d26 = this.h;
            d4 = ((-d22) * pow3 * d23) + (pow4 * (sin + (d21 * d26 * Math.cos(d26 * d6))));
            d5 = d25;
        }
        DynamicAnimation.MassState massState = this.j;
        massState.f1186a = (float) (d5 + this.i);
        massState.b = (float) d4;
        return massState;
    }

    public SpringForce(float f2) {
        this.i = (double) f2;
    }
}
