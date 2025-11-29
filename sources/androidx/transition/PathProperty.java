package androidx.transition;

import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

class PathProperty<T> extends Property<T, Float> {

    /* renamed from: a  reason: collision with root package name */
    public final Property f1857a;
    public final PathMeasure b;
    public final float c;
    public final float[] d;
    public final PointF e;
    public float f;

    /* renamed from: a */
    public Float get(Object obj) {
        return Float.valueOf(this.f);
    }

    /* renamed from: b */
    public void set(Object obj, Float f2) {
        this.f = f2.floatValue();
        this.b.getPosTan(this.c * f2.floatValue(), this.d, (float[]) null);
        PointF pointF = this.e;
        float[] fArr = this.d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f1857a.set(obj, pointF);
    }
}
