package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.utils.FloatRect;
import java.util.HashMap;

public class MotionKeyTrigger extends MotionKey {
    public int g = -1;
    public String h = null;
    public int i;
    public String j;
    public String k;
    public int l;
    public int m;
    public float n;
    public boolean o;
    public boolean p;
    public boolean q;
    public float r;
    public float s;
    public boolean t;
    public int u;
    public int v;
    public int w;
    public FloatRect x;
    public FloatRect y;

    public MotionKeyTrigger() {
        int i2 = MotionKey.f;
        this.i = i2;
        this.j = null;
        this.k = null;
        this.l = i2;
        this.m = i2;
        this.n = 0.1f;
        this.o = true;
        this.p = true;
        this.q = true;
        this.r = Float.NaN;
        this.t = false;
        this.u = i2;
        this.v = i2;
        this.w = i2;
        this.x = new FloatRect();
        this.y = new FloatRect();
        this.d = 5;
        this.e = new HashMap();
    }

    /* renamed from: a */
    public MotionKey clone() {
        return new MotionKeyTrigger().c(this);
    }

    public MotionKeyTrigger c(MotionKey motionKey) {
        super.b(motionKey);
        MotionKeyTrigger motionKeyTrigger = (MotionKeyTrigger) motionKey;
        this.g = motionKeyTrigger.g;
        this.h = motionKeyTrigger.h;
        this.i = motionKeyTrigger.i;
        this.j = motionKeyTrigger.j;
        this.k = motionKeyTrigger.k;
        this.l = motionKeyTrigger.l;
        this.m = motionKeyTrigger.m;
        this.n = motionKeyTrigger.n;
        this.o = motionKeyTrigger.o;
        this.p = motionKeyTrigger.p;
        this.q = motionKeyTrigger.q;
        this.r = motionKeyTrigger.r;
        this.s = motionKeyTrigger.s;
        this.t = motionKeyTrigger.t;
        this.x = motionKeyTrigger.x;
        this.y = motionKeyTrigger.y;
        return this;
    }
}
