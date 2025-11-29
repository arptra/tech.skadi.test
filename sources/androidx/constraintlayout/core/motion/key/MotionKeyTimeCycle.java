package androidx.constraintlayout.core.motion.key;

import java.util.HashMap;

public class MotionKeyTimeCycle extends MotionKey {
    public String g;
    public int h = -1;
    public float i = Float.NaN;
    public float j = Float.NaN;
    public float k = Float.NaN;
    public float l = Float.NaN;
    public float m = Float.NaN;
    public float n = Float.NaN;
    public float o = Float.NaN;
    public float p = Float.NaN;
    public float q = Float.NaN;
    public float r = Float.NaN;
    public float s = Float.NaN;
    public float t = Float.NaN;
    public int u = 0;
    public String v = null;
    public float w = Float.NaN;
    public float x = 0.0f;

    public MotionKeyTimeCycle() {
        this.d = 3;
        this.e = new HashMap();
    }

    /* renamed from: a */
    public MotionKey clone() {
        return new MotionKeyTimeCycle().c(this);
    }

    public MotionKeyTimeCycle c(MotionKey motionKey) {
        super.b(motionKey);
        MotionKeyTimeCycle motionKeyTimeCycle = (MotionKeyTimeCycle) motionKey;
        this.g = motionKeyTimeCycle.g;
        this.h = motionKeyTimeCycle.h;
        this.u = motionKeyTimeCycle.u;
        this.w = motionKeyTimeCycle.w;
        this.x = motionKeyTimeCycle.x;
        this.t = motionKeyTimeCycle.t;
        this.i = motionKeyTimeCycle.i;
        this.j = motionKeyTimeCycle.j;
        this.k = motionKeyTimeCycle.k;
        this.n = motionKeyTimeCycle.n;
        this.l = motionKeyTimeCycle.l;
        this.m = motionKeyTimeCycle.m;
        this.o = motionKeyTimeCycle.o;
        this.p = motionKeyTimeCycle.p;
        this.q = motionKeyTimeCycle.q;
        this.r = motionKeyTimeCycle.r;
        this.s = motionKeyTimeCycle.s;
        return this;
    }
}
