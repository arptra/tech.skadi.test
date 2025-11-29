package androidx.constraintlayout.core.motion.key;

public class MotionKeyPosition extends MotionKey {
    public int g;
    public String h = null;
    public int i;
    public int j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public int q;
    public float r;
    public float s;

    public MotionKeyPosition() {
        int i2 = MotionKey.f;
        this.g = i2;
        this.i = i2;
        this.j = 0;
        this.k = Float.NaN;
        this.l = Float.NaN;
        this.m = Float.NaN;
        this.n = Float.NaN;
        this.o = Float.NaN;
        this.p = Float.NaN;
        this.q = 0;
        this.r = Float.NaN;
        this.s = Float.NaN;
        this.d = 2;
    }

    /* renamed from: a */
    public MotionKey clone() {
        return new MotionKeyPosition().b(this);
    }

    public MotionKey b(MotionKey motionKey) {
        super.b(motionKey);
        MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
        this.h = motionKeyPosition.h;
        this.i = motionKeyPosition.i;
        this.j = motionKeyPosition.j;
        this.k = motionKeyPosition.k;
        this.l = Float.NaN;
        this.m = motionKeyPosition.m;
        this.n = motionKeyPosition.n;
        this.o = motionKeyPosition.o;
        this.p = motionKeyPosition.p;
        this.r = motionKeyPosition.r;
        this.s = motionKeyPosition.s;
        return this;
    }
}
