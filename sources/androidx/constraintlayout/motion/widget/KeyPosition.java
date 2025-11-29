package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

public class KeyPosition extends KeyPositionBase {
    public String h = null;
    public int i = Key.f;
    public int j = 0;
    public float k = Float.NaN;
    public float l = Float.NaN;
    public float m = Float.NaN;
    public float n = Float.NaN;
    public float o = Float.NaN;
    public float p = Float.NaN;
    public int q = 0;
    public float r = Float.NaN;
    public float s = Float.NaN;

    public static class Loader {

        /* renamed from: a  reason: collision with root package name */
        public static SparseIntArray f557a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f557a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyPosition_motionTarget, 1);
            f557a.append(R.styleable.KeyPosition_framePosition, 2);
            f557a.append(R.styleable.KeyPosition_transitionEasing, 3);
            f557a.append(R.styleable.KeyPosition_curveFit, 4);
            f557a.append(R.styleable.KeyPosition_drawPath, 5);
            f557a.append(R.styleable.KeyPosition_percentX, 6);
            f557a.append(R.styleable.KeyPosition_percentY, 7);
            f557a.append(R.styleable.KeyPosition_keyPositionType, 9);
            f557a.append(R.styleable.KeyPosition_sizePercent, 8);
            f557a.append(R.styleable.KeyPosition_percentWidth, 11);
            f557a.append(R.styleable.KeyPosition_percentHeight, 12);
            f557a.append(R.styleable.KeyPosition_pathMotionArc, 10);
        }

        public static void b(KeyPosition keyPosition, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (f557a.get(index)) {
                    case 1:
                        if (!MotionLayout.K0) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyPosition.b = typedArray.getResourceId(index, keyPosition.b);
                                break;
                            } else {
                                keyPosition.c = typedArray.getString(index);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyPosition.b);
                            keyPosition.b = resourceId;
                            if (resourceId != -1) {
                                break;
                            } else {
                                keyPosition.c = typedArray.getString(index);
                                break;
                            }
                        }
                    case 2:
                        keyPosition.f553a = typedArray.getInt(index, keyPosition.f553a);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type != 3) {
                            keyPosition.h = Easing.c[typedArray.getInteger(index, 0)];
                            break;
                        } else {
                            keyPosition.h = typedArray.getString(index);
                            break;
                        }
                    case 4:
                        keyPosition.g = typedArray.getInteger(index, keyPosition.g);
                        break;
                    case 5:
                        keyPosition.j = typedArray.getInt(index, keyPosition.j);
                        break;
                    case 6:
                        keyPosition.m = typedArray.getFloat(index, keyPosition.m);
                        break;
                    case 7:
                        keyPosition.n = typedArray.getFloat(index, keyPosition.n);
                        break;
                    case 8:
                        float f = typedArray.getFloat(index, keyPosition.l);
                        keyPosition.k = f;
                        keyPosition.l = f;
                        break;
                    case 9:
                        keyPosition.q = typedArray.getInt(index, keyPosition.q);
                        break;
                    case 10:
                        keyPosition.i = typedArray.getInt(index, keyPosition.i);
                        break;
                    case 11:
                        keyPosition.k = typedArray.getFloat(index, keyPosition.k);
                        break;
                    case 12:
                        keyPosition.l = typedArray.getFloat(index, keyPosition.l);
                        break;
                    default:
                        Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + f557a.get(index));
                        break;
                }
            }
            if (keyPosition.f553a == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }

    public KeyPosition() {
        this.d = 2;
    }

    public void a(HashMap hashMap) {
    }

    /* renamed from: b */
    public Key clone() {
        return new KeyPosition().c(this);
    }

    public Key c(Key key) {
        super.c(key);
        KeyPosition keyPosition = (KeyPosition) key;
        this.h = keyPosition.h;
        this.i = keyPosition.i;
        this.j = keyPosition.j;
        this.k = keyPosition.k;
        this.l = Float.NaN;
        this.m = keyPosition.m;
        this.n = keyPosition.n;
        this.o = keyPosition.o;
        this.p = keyPosition.p;
        this.r = keyPosition.r;
        this.s = keyPosition.s;
        return this;
    }

    public void e(Context context, AttributeSet attributeSet) {
        Loader.b(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyPosition));
    }

    public void m(int i2) {
        this.q = i2;
    }

    public void n(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c = 0;
                    break;
                }
                break;
            case -1127236479:
                if (str.equals("percentWidth")) {
                    c = 1;
                    break;
                }
                break;
            case -1017587252:
                if (str.equals("percentHeight")) {
                    c = 2;
                    break;
                }
                break;
            case -827014263:
                if (str.equals("drawPath")) {
                    c = 3;
                    break;
                }
                break;
            case -200259324:
                if (str.equals("sizePercent")) {
                    c = 4;
                    break;
                }
                break;
            case 428090547:
                if (str.equals("percentX")) {
                    c = 5;
                    break;
                }
                break;
            case 428090548:
                if (str.equals("percentY")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.h = obj.toString();
                return;
            case 1:
                this.k = k(obj);
                return;
            case 2:
                this.l = k(obj);
                return;
            case 3:
                this.j = l(obj);
                return;
            case 4:
                float k2 = k(obj);
                this.k = k2;
                this.l = k2;
                return;
            case 5:
                this.m = k(obj);
                return;
            case 6:
                this.n = k(obj);
                return;
            default:
                return;
        }
    }
}
