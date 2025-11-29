package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.HashMap;
import java.util.HashSet;

public class KeyTimeCycle extends Key {
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

    public static class Loader {

        /* renamed from: a  reason: collision with root package name */
        public static SparseIntArray f558a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f558a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTimeCycle_android_alpha, 1);
            f558a.append(R.styleable.KeyTimeCycle_android_elevation, 2);
            f558a.append(R.styleable.KeyTimeCycle_android_rotation, 4);
            f558a.append(R.styleable.KeyTimeCycle_android_rotationX, 5);
            f558a.append(R.styleable.KeyTimeCycle_android_rotationY, 6);
            f558a.append(R.styleable.KeyTimeCycle_android_scaleX, 7);
            f558a.append(R.styleable.KeyTimeCycle_transitionPathRotate, 8);
            f558a.append(R.styleable.KeyTimeCycle_transitionEasing, 9);
            f558a.append(R.styleable.KeyTimeCycle_motionTarget, 10);
            f558a.append(R.styleable.KeyTimeCycle_framePosition, 12);
            f558a.append(R.styleable.KeyTimeCycle_curveFit, 13);
            f558a.append(R.styleable.KeyTimeCycle_android_scaleY, 14);
            f558a.append(R.styleable.KeyTimeCycle_android_translationX, 15);
            f558a.append(R.styleable.KeyTimeCycle_android_translationY, 16);
            f558a.append(R.styleable.KeyTimeCycle_android_translationZ, 17);
            f558a.append(R.styleable.KeyTimeCycle_motionProgress, 18);
            f558a.append(R.styleable.KeyTimeCycle_wavePeriod, 20);
            f558a.append(R.styleable.KeyTimeCycle_waveOffset, 21);
            f558a.append(R.styleable.KeyTimeCycle_waveShape, 19);
        }

        public static void a(KeyTimeCycle keyTimeCycle, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (f558a.get(index)) {
                    case 1:
                        float unused = keyTimeCycle.i = typedArray.getFloat(index, keyTimeCycle.i);
                        break;
                    case 2:
                        float unused2 = keyTimeCycle.j = typedArray.getDimension(index, keyTimeCycle.j);
                        break;
                    case 4:
                        float unused3 = keyTimeCycle.k = typedArray.getFloat(index, keyTimeCycle.k);
                        break;
                    case 5:
                        float unused4 = keyTimeCycle.l = typedArray.getFloat(index, keyTimeCycle.l);
                        break;
                    case 6:
                        float unused5 = keyTimeCycle.m = typedArray.getFloat(index, keyTimeCycle.m);
                        break;
                    case 7:
                        float unused6 = keyTimeCycle.o = typedArray.getFloat(index, keyTimeCycle.o);
                        break;
                    case 8:
                        float unused7 = keyTimeCycle.n = typedArray.getFloat(index, keyTimeCycle.n);
                        break;
                    case 9:
                        String unused8 = keyTimeCycle.g = typedArray.getString(index);
                        break;
                    case 10:
                        if (!MotionLayout.K0) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyTimeCycle.b = typedArray.getResourceId(index, keyTimeCycle.b);
                                break;
                            } else {
                                keyTimeCycle.c = typedArray.getString(index);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyTimeCycle.b);
                            keyTimeCycle.b = resourceId;
                            if (resourceId != -1) {
                                break;
                            } else {
                                keyTimeCycle.c = typedArray.getString(index);
                                break;
                            }
                        }
                    case 12:
                        keyTimeCycle.f553a = typedArray.getInt(index, keyTimeCycle.f553a);
                        break;
                    case 13:
                        int unused9 = keyTimeCycle.h = typedArray.getInteger(index, keyTimeCycle.h);
                        break;
                    case 14:
                        float unused10 = keyTimeCycle.p = typedArray.getFloat(index, keyTimeCycle.p);
                        break;
                    case 15:
                        float unused11 = keyTimeCycle.q = typedArray.getDimension(index, keyTimeCycle.q);
                        break;
                    case 16:
                        float unused12 = keyTimeCycle.r = typedArray.getDimension(index, keyTimeCycle.r);
                        break;
                    case 17:
                        float unused13 = keyTimeCycle.s = typedArray.getDimension(index, keyTimeCycle.s);
                        break;
                    case 18:
                        float unused14 = keyTimeCycle.t = typedArray.getFloat(index, keyTimeCycle.t);
                        break;
                    case 19:
                        if (typedArray.peekValue(index).type != 3) {
                            int unused15 = keyTimeCycle.u = typedArray.getInt(index, keyTimeCycle.u);
                            break;
                        } else {
                            String unused16 = keyTimeCycle.v = typedArray.getString(index);
                            int unused17 = keyTimeCycle.u = 7;
                            break;
                        }
                    case 20:
                        float unused18 = keyTimeCycle.w = typedArray.getFloat(index, keyTimeCycle.w);
                        break;
                    case 21:
                        if (typedArray.peekValue(index).type != 5) {
                            float unused19 = keyTimeCycle.x = typedArray.getFloat(index, keyTimeCycle.x);
                            break;
                        } else {
                            float unused20 = keyTimeCycle.x = typedArray.getDimension(index, keyTimeCycle.x);
                            break;
                        }
                    default:
                        Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f558a.get(index));
                        break;
                }
            }
        }
    }

    public KeyTimeCycle() {
        this.d = 3;
        this.e = new HashMap();
    }

    public void U(HashMap hashMap) {
        for (String str : hashMap.keySet()) {
            ViewTimeCycle viewTimeCycle = (ViewTimeCycle) hashMap.get(str);
            if (viewTimeCycle != null) {
                if (!str.startsWith("CUSTOM")) {
                    char c = 65535;
                    switch (str.hashCode()) {
                        case -1249320806:
                            if (str.equals("rotationX")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1249320805:
                            if (str.equals("rotationY")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1225497657:
                            if (str.equals("translationX")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1225497656:
                            if (str.equals("translationY")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -1225497655:
                            if (str.equals("translationZ")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1001078227:
                            if (str.equals(PayloadConstant.PARAMS_KEY_INT_OTA_PROGRESS)) {
                                c = 5;
                                break;
                            }
                            break;
                        case -908189618:
                            if (str.equals("scaleX")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -908189617:
                            if (str.equals("scaleY")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -40300674:
                            if (str.equals("rotation")) {
                                c = 8;
                                break;
                            }
                            break;
                        case -4379043:
                            if (str.equals("elevation")) {
                                c = 9;
                                break;
                            }
                            break;
                        case 37232917:
                            if (str.equals("transitionPathRotate")) {
                                c = 10;
                                break;
                            }
                            break;
                        case 92909918:
                            if (str.equals("alpha")) {
                                c = 11;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            if (Float.isNaN(this.l)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.f553a, this.l, this.w, this.u, this.x);
                                break;
                            }
                        case 1:
                            if (Float.isNaN(this.m)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.f553a, this.m, this.w, this.u, this.x);
                                break;
                            }
                        case 2:
                            if (Float.isNaN(this.q)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.f553a, this.q, this.w, this.u, this.x);
                                break;
                            }
                        case 3:
                            if (Float.isNaN(this.r)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.f553a, this.r, this.w, this.u, this.x);
                                break;
                            }
                        case 4:
                            if (Float.isNaN(this.s)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.f553a, this.s, this.w, this.u, this.x);
                                break;
                            }
                        case 5:
                            if (Float.isNaN(this.t)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.f553a, this.t, this.w, this.u, this.x);
                                break;
                            }
                        case 6:
                            if (Float.isNaN(this.o)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.f553a, this.o, this.w, this.u, this.x);
                                break;
                            }
                        case 7:
                            if (Float.isNaN(this.p)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.f553a, this.p, this.w, this.u, this.x);
                                break;
                            }
                        case 8:
                            if (Float.isNaN(this.k)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.f553a, this.k, this.w, this.u, this.x);
                                break;
                            }
                        case 9:
                            if (Float.isNaN(this.j)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.f553a, this.j, this.w, this.u, this.x);
                                break;
                            }
                        case 10:
                            if (Float.isNaN(this.n)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.f553a, this.n, this.w, this.u, this.x);
                                break;
                            }
                        case 11:
                            if (Float.isNaN(this.i)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.f553a, this.i, this.w, this.u, this.x);
                                break;
                            }
                        default:
                            Log.e("KeyTimeCycles", "UNKNOWN addValues \"" + str + "\"");
                            break;
                    }
                } else {
                    ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.e.get(str.substring(7));
                    if (constraintAttribute != null) {
                        ((ViewTimeCycle.CustomSet) viewTimeCycle).j(this.f553a, constraintAttribute, this.w, this.u, this.x);
                    }
                }
            }
        }
    }

    public void a(HashMap hashMap) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    /* renamed from: b */
    public Key clone() {
        return new KeyTimeCycle().c(this);
    }

    public Key c(Key key) {
        super.c(key);
        KeyTimeCycle keyTimeCycle = (KeyTimeCycle) key;
        this.g = keyTimeCycle.g;
        this.h = keyTimeCycle.h;
        this.u = keyTimeCycle.u;
        this.w = keyTimeCycle.w;
        this.x = keyTimeCycle.x;
        this.t = keyTimeCycle.t;
        this.i = keyTimeCycle.i;
        this.j = keyTimeCycle.j;
        this.k = keyTimeCycle.k;
        this.n = keyTimeCycle.n;
        this.l = keyTimeCycle.l;
        this.m = keyTimeCycle.m;
        this.o = keyTimeCycle.o;
        this.p = keyTimeCycle.p;
        this.q = keyTimeCycle.q;
        this.r = keyTimeCycle.r;
        this.s = keyTimeCycle.s;
        return this;
    }

    public void d(HashSet hashSet) {
        if (!Float.isNaN(this.i)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.j)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.k)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.l)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.m)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.s)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.n)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.p)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.t)) {
            hashSet.add(PayloadConstant.PARAMS_KEY_INT_OTA_PROGRESS);
        }
        if (this.e.size() > 0) {
            for (String str : this.e.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public void e(Context context, AttributeSet attributeSet) {
        Loader.a(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyTimeCycle));
    }

    public void h(HashMap hashMap) {
        if (this.h != -1) {
            if (!Float.isNaN(this.i)) {
                hashMap.put("alpha", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.j)) {
                hashMap.put("elevation", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.k)) {
                hashMap.put("rotation", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.l)) {
                hashMap.put("rotationX", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.m)) {
                hashMap.put("rotationY", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.q)) {
                hashMap.put("translationX", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.r)) {
                hashMap.put("translationY", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.s)) {
                hashMap.put("translationZ", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.n)) {
                hashMap.put("transitionPathRotate", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.o)) {
                hashMap.put("scaleX", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.o)) {
                hashMap.put("scaleY", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.t)) {
                hashMap.put(PayloadConstant.PARAMS_KEY_INT_OTA_PROGRESS, Integer.valueOf(this.h));
            }
            if (this.e.size() > 0) {
                for (String str : this.e.keySet()) {
                    hashMap.put("CUSTOM," + str, Integer.valueOf(this.h));
                }
            }
        }
    }
}
