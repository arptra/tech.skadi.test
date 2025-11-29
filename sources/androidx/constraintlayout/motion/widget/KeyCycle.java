package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.HashMap;
import java.util.HashSet;

public class KeyCycle extends Key {
    public String g = null;
    public int h = 0;
    public int i = -1;
    public String j = null;
    public float k = Float.NaN;
    public float l = 0.0f;
    public float m = 0.0f;
    public float n = Float.NaN;
    public int o = -1;
    public float p = Float.NaN;
    public float q = Float.NaN;
    public float r = Float.NaN;
    public float s = Float.NaN;
    public float t = Float.NaN;
    public float u = Float.NaN;
    public float v = Float.NaN;
    public float w = Float.NaN;
    public float x = Float.NaN;
    public float y = Float.NaN;
    public float z = Float.NaN;

    public static class Loader {

        /* renamed from: a  reason: collision with root package name */
        public static SparseIntArray f555a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f555a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyCycle_motionTarget, 1);
            f555a.append(R.styleable.KeyCycle_framePosition, 2);
            f555a.append(R.styleable.KeyCycle_transitionEasing, 3);
            f555a.append(R.styleable.KeyCycle_curveFit, 4);
            f555a.append(R.styleable.KeyCycle_waveShape, 5);
            f555a.append(R.styleable.KeyCycle_wavePeriod, 6);
            f555a.append(R.styleable.KeyCycle_waveOffset, 7);
            f555a.append(R.styleable.KeyCycle_waveVariesBy, 8);
            f555a.append(R.styleable.KeyCycle_android_alpha, 9);
            f555a.append(R.styleable.KeyCycle_android_elevation, 10);
            f555a.append(R.styleable.KeyCycle_android_rotation, 11);
            f555a.append(R.styleable.KeyCycle_android_rotationX, 12);
            f555a.append(R.styleable.KeyCycle_android_rotationY, 13);
            f555a.append(R.styleable.KeyCycle_transitionPathRotate, 14);
            f555a.append(R.styleable.KeyCycle_android_scaleX, 15);
            f555a.append(R.styleable.KeyCycle_android_scaleY, 16);
            f555a.append(R.styleable.KeyCycle_android_translationX, 17);
            f555a.append(R.styleable.KeyCycle_android_translationY, 18);
            f555a.append(R.styleable.KeyCycle_android_translationZ, 19);
            f555a.append(R.styleable.KeyCycle_motionProgress, 20);
            f555a.append(R.styleable.KeyCycle_wavePhase, 21);
        }

        public static void b(KeyCycle keyCycle, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (f555a.get(index)) {
                    case 1:
                        if (!MotionLayout.K0) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyCycle.b = typedArray.getResourceId(index, keyCycle.b);
                                break;
                            } else {
                                keyCycle.c = typedArray.getString(index);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyCycle.b);
                            keyCycle.b = resourceId;
                            if (resourceId != -1) {
                                break;
                            } else {
                                keyCycle.c = typedArray.getString(index);
                                break;
                            }
                        }
                    case 2:
                        keyCycle.f553a = typedArray.getInt(index, keyCycle.f553a);
                        break;
                    case 3:
                        String unused = keyCycle.g = typedArray.getString(index);
                        break;
                    case 4:
                        int unused2 = keyCycle.h = typedArray.getInteger(index, keyCycle.h);
                        break;
                    case 5:
                        if (typedArray.peekValue(index).type != 3) {
                            int unused3 = keyCycle.i = typedArray.getInt(index, keyCycle.i);
                            break;
                        } else {
                            String unused4 = keyCycle.j = typedArray.getString(index);
                            int unused5 = keyCycle.i = 7;
                            break;
                        }
                    case 6:
                        float unused6 = keyCycle.k = typedArray.getFloat(index, keyCycle.k);
                        break;
                    case 7:
                        if (typedArray.peekValue(index).type != 5) {
                            float unused7 = keyCycle.l = typedArray.getFloat(index, keyCycle.l);
                            break;
                        } else {
                            float unused8 = keyCycle.l = typedArray.getDimension(index, keyCycle.l);
                            break;
                        }
                    case 8:
                        int unused9 = keyCycle.o = typedArray.getInt(index, keyCycle.o);
                        break;
                    case 9:
                        float unused10 = keyCycle.p = typedArray.getFloat(index, keyCycle.p);
                        break;
                    case 10:
                        float unused11 = keyCycle.q = typedArray.getDimension(index, keyCycle.q);
                        break;
                    case 11:
                        float unused12 = keyCycle.r = typedArray.getFloat(index, keyCycle.r);
                        break;
                    case 12:
                        float unused13 = keyCycle.t = typedArray.getFloat(index, keyCycle.t);
                        break;
                    case 13:
                        float unused14 = keyCycle.u = typedArray.getFloat(index, keyCycle.u);
                        break;
                    case 14:
                        float unused15 = keyCycle.s = typedArray.getFloat(index, keyCycle.s);
                        break;
                    case 15:
                        float unused16 = keyCycle.v = typedArray.getFloat(index, keyCycle.v);
                        break;
                    case 16:
                        float unused17 = keyCycle.w = typedArray.getFloat(index, keyCycle.w);
                        break;
                    case 17:
                        float unused18 = keyCycle.x = typedArray.getDimension(index, keyCycle.x);
                        break;
                    case 18:
                        float unused19 = keyCycle.y = typedArray.getDimension(index, keyCycle.y);
                        break;
                    case 19:
                        float unused20 = keyCycle.z = typedArray.getDimension(index, keyCycle.z);
                        break;
                    case 20:
                        float unused21 = keyCycle.n = typedArray.getFloat(index, keyCycle.n);
                        break;
                    case 21:
                        float unused22 = keyCycle.m = typedArray.getFloat(index, keyCycle.m) / 360.0f;
                        break;
                    default:
                        Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f555a.get(index));
                        break;
                }
            }
        }
    }

    public KeyCycle() {
        this.d = 4;
        this.e = new HashMap();
    }

    public void Y(HashMap hashMap) {
        ViewOscillator viewOscillator;
        ViewOscillator viewOscillator2;
        HashMap hashMap2 = hashMap;
        for (String str : hashMap.keySet()) {
            if (str.startsWith("CUSTOM")) {
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.e.get(str.substring(7));
                if (!(constraintAttribute == null || constraintAttribute.d() != ConstraintAttribute.AttributeType.FLOAT_TYPE || (viewOscillator2 = (ViewOscillator) hashMap2.get(str)) == null)) {
                    viewOscillator2.e(this.f553a, this.i, this.j, this.o, this.k, this.l, this.m, constraintAttribute.e(), constraintAttribute);
                }
            } else {
                float Z = Z(str);
                if (!Float.isNaN(Z) && (viewOscillator = (ViewOscillator) hashMap2.get(str)) != null) {
                    viewOscillator.d(this.f553a, this.i, this.j, this.o, this.k, this.l, this.m, Z);
                }
            }
        }
    }

    public float Z(String str) {
        str.hashCode();
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
            case 156108012:
                if (str.equals("waveOffset")) {
                    c = 12;
                    break;
                }
                break;
            case 1530034690:
                if (str.equals("wavePhase")) {
                    c = 13;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.t;
            case 1:
                return this.u;
            case 2:
                return this.x;
            case 3:
                return this.y;
            case 4:
                return this.z;
            case 5:
                return this.n;
            case 6:
                return this.v;
            case 7:
                return this.w;
            case 8:
                return this.r;
            case 9:
                return this.q;
            case 10:
                return this.s;
            case 11:
                return this.p;
            case 12:
                return this.l;
            case 13:
                return this.m;
            default:
                if (str.startsWith("CUSTOM")) {
                    return Float.NaN;
                }
                Log.v("WARNING! KeyCycle", "  UNKNOWN  " + str);
                return Float.NaN;
        }
    }

    public void a(HashMap hashMap) {
        Debug.g("KeyCycle", "add " + hashMap.size() + " values", 2);
        for (String str : hashMap.keySet()) {
            SplineSet splineSet = (SplineSet) hashMap.get(str);
            if (splineSet != null) {
                str.hashCode();
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
                    case 156108012:
                        if (str.equals("waveOffset")) {
                            c = 12;
                            break;
                        }
                        break;
                    case 1530034690:
                        if (str.equals("wavePhase")) {
                            c = 13;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        splineSet.c(this.f553a, this.t);
                        break;
                    case 1:
                        splineSet.c(this.f553a, this.u);
                        break;
                    case 2:
                        splineSet.c(this.f553a, this.x);
                        break;
                    case 3:
                        splineSet.c(this.f553a, this.y);
                        break;
                    case 4:
                        splineSet.c(this.f553a, this.z);
                        break;
                    case 5:
                        splineSet.c(this.f553a, this.n);
                        break;
                    case 6:
                        splineSet.c(this.f553a, this.v);
                        break;
                    case 7:
                        splineSet.c(this.f553a, this.w);
                        break;
                    case 8:
                        splineSet.c(this.f553a, this.r);
                        break;
                    case 9:
                        splineSet.c(this.f553a, this.q);
                        break;
                    case 10:
                        splineSet.c(this.f553a, this.s);
                        break;
                    case 11:
                        splineSet.c(this.f553a, this.p);
                        break;
                    case 12:
                        splineSet.c(this.f553a, this.l);
                        break;
                    case 13:
                        splineSet.c(this.f553a, this.m);
                        break;
                    default:
                        if (str.startsWith("CUSTOM")) {
                            break;
                        } else {
                            Log.v("WARNING KeyCycle", "  UNKNOWN  " + str);
                            break;
                        }
                }
            }
        }
    }

    /* renamed from: b */
    public Key clone() {
        return new KeyCycle().c(this);
    }

    public Key c(Key key) {
        super.c(key);
        KeyCycle keyCycle = (KeyCycle) key;
        this.g = keyCycle.g;
        this.h = keyCycle.h;
        this.i = keyCycle.i;
        this.j = keyCycle.j;
        this.k = keyCycle.k;
        this.l = keyCycle.l;
        this.m = keyCycle.m;
        this.n = keyCycle.n;
        this.o = keyCycle.o;
        this.p = keyCycle.p;
        this.q = keyCycle.q;
        this.r = keyCycle.r;
        this.s = keyCycle.s;
        this.t = keyCycle.t;
        this.u = keyCycle.u;
        this.v = keyCycle.v;
        this.w = keyCycle.w;
        this.x = keyCycle.x;
        this.y = keyCycle.y;
        this.z = keyCycle.z;
        return this;
    }

    public void d(HashSet hashSet) {
        if (!Float.isNaN(this.p)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.t)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.u)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.v)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.w)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.s)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.x)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.y)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.z)) {
            hashSet.add("translationZ");
        }
        if (this.e.size() > 0) {
            for (String str : this.e.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public void e(Context context, AttributeSet attributeSet) {
        Loader.b(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyCycle));
    }
}
