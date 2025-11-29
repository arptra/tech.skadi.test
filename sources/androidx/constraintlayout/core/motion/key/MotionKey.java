package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;

public abstract class MotionKey implements TypedValues {
    public static int f = -1;

    /* renamed from: a  reason: collision with root package name */
    public int f494a;
    public int b;
    public String c = null;
    public int d;
    public HashMap e;

    public MotionKey() {
        int i = f;
        this.f494a = i;
        this.b = i;
    }

    /* renamed from: a */
    public abstract MotionKey clone();

    public MotionKey b(MotionKey motionKey) {
        this.f494a = motionKey.f494a;
        this.b = motionKey.b;
        this.c = motionKey.c;
        this.d = motionKey.d;
        return this;
    }
}
