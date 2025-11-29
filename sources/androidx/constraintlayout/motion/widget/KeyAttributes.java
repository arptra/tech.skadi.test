package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.HashMap;
import java.util.HashSet;

public class KeyAttributes extends Key {
    public String g;
    public int h = -1;
    public boolean i = false;
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
    public float u = Float.NaN;
    public float v = Float.NaN;
    public float w = Float.NaN;

    public static class Loader {

        /* renamed from: a  reason: collision with root package name */
        public static SparseIntArray f554a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f554a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyAttribute_android_alpha, 1);
            f554a.append(R.styleable.KeyAttribute_android_elevation, 2);
            f554a.append(R.styleable.KeyAttribute_android_rotation, 4);
            f554a.append(R.styleable.KeyAttribute_android_rotationX, 5);
            f554a.append(R.styleable.KeyAttribute_android_rotationY, 6);
            f554a.append(R.styleable.KeyAttribute_android_transformPivotX, 19);
            f554a.append(R.styleable.KeyAttribute_android_transformPivotY, 20);
            f554a.append(R.styleable.KeyAttribute_android_scaleX, 7);
            f554a.append(R.styleable.KeyAttribute_transitionPathRotate, 8);
            f554a.append(R.styleable.KeyAttribute_transitionEasing, 9);
            f554a.append(R.styleable.KeyAttribute_motionTarget, 10);
            f554a.append(R.styleable.KeyAttribute_framePosition, 12);
            f554a.append(R.styleable.KeyAttribute_curveFit, 13);
            f554a.append(R.styleable.KeyAttribute_android_scaleY, 14);
            f554a.append(R.styleable.KeyAttribute_android_translationX, 15);
            f554a.append(R.styleable.KeyAttribute_android_translationY, 16);
            f554a.append(R.styleable.KeyAttribute_android_translationZ, 17);
            f554a.append(R.styleable.KeyAttribute_motionProgress, 18);
        }

        public static void a(KeyAttributes keyAttributes, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (f554a.get(index)) {
                    case 1:
                        float unused = keyAttributes.j = typedArray.getFloat(index, keyAttributes.j);
                        break;
                    case 2:
                        float unused2 = keyAttributes.k = typedArray.getDimension(index, keyAttributes.k);
                        break;
                    case 4:
                        float unused3 = keyAttributes.l = typedArray.getFloat(index, keyAttributes.l);
                        break;
                    case 5:
                        float unused4 = keyAttributes.m = typedArray.getFloat(index, keyAttributes.m);
                        break;
                    case 6:
                        float unused5 = keyAttributes.n = typedArray.getFloat(index, keyAttributes.n);
                        break;
                    case 7:
                        float unused6 = keyAttributes.r = typedArray.getFloat(index, keyAttributes.r);
                        break;
                    case 8:
                        float unused7 = keyAttributes.q = typedArray.getFloat(index, keyAttributes.q);
                        break;
                    case 9:
                        String unused8 = keyAttributes.g = typedArray.getString(index);
                        break;
                    case 10:
                        if (!MotionLayout.K0) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyAttributes.b = typedArray.getResourceId(index, keyAttributes.b);
                                break;
                            } else {
                                keyAttributes.c = typedArray.getString(index);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyAttributes.b);
                            keyAttributes.b = resourceId;
                            if (resourceId != -1) {
                                break;
                            } else {
                                keyAttributes.c = typedArray.getString(index);
                                break;
                            }
                        }
                    case 12:
                        keyAttributes.f553a = typedArray.getInt(index, keyAttributes.f553a);
                        break;
                    case 13:
                        int unused9 = keyAttributes.h = typedArray.getInteger(index, keyAttributes.h);
                        break;
                    case 14:
                        float unused10 = keyAttributes.s = typedArray.getFloat(index, keyAttributes.s);
                        break;
                    case 15:
                        float unused11 = keyAttributes.t = typedArray.getDimension(index, keyAttributes.t);
                        break;
                    case 16:
                        float unused12 = keyAttributes.u = typedArray.getDimension(index, keyAttributes.u);
                        break;
                    case 17:
                        float unused13 = keyAttributes.v = typedArray.getDimension(index, keyAttributes.v);
                        break;
                    case 18:
                        float unused14 = keyAttributes.w = typedArray.getFloat(index, keyAttributes.w);
                        break;
                    case 19:
                        float unused15 = keyAttributes.o = typedArray.getDimension(index, keyAttributes.o);
                        break;
                    case 20:
                        float unused16 = keyAttributes.p = typedArray.getDimension(index, keyAttributes.p);
                        break;
                    default:
                        Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(index) + "   " + f554a.get(index));
                        break;
                }
            }
        }
    }

    public KeyAttributes() {
        this.d = 1;
        this.e = new HashMap();
    }

    public void R(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1913008125:
                if (str.equals("motionProgress")) {
                    c = 0;
                    break;
                }
                break;
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c = 1;
                    break;
                }
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 2;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 3;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 4;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 5;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = 6;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 7;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = 8;
                    break;
                }
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    c = 9;
                    break;
                }
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    c = 10;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = 12;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = 13;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 14;
                    break;
                }
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    c = 15;
                    break;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c = 16;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.w = k(obj);
                return;
            case 1:
                this.g = obj.toString();
                return;
            case 2:
                this.m = k(obj);
                return;
            case 3:
                this.n = k(obj);
                return;
            case 4:
                this.t = k(obj);
                return;
            case 5:
                this.u = k(obj);
                return;
            case 6:
                this.v = k(obj);
                return;
            case 7:
                this.r = k(obj);
                return;
            case 8:
                this.s = k(obj);
                return;
            case 9:
                this.o = k(obj);
                return;
            case 10:
                this.p = k(obj);
                return;
            case 11:
                this.l = k(obj);
                return;
            case 12:
                this.k = k(obj);
                return;
            case 13:
                this.q = k(obj);
                return;
            case 14:
                this.j = k(obj);
                return;
            case 15:
                this.h = l(obj);
                return;
            case 16:
                this.i = j(obj);
                return;
            default:
                return;
        }
    }

    public void a(HashMap hashMap) {
        for (String str : hashMap.keySet()) {
            SplineSet splineSet = (SplineSet) hashMap.get(str);
            if (splineSet != null) {
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
                        case -760884510:
                            if (str.equals("transformPivotX")) {
                                c = 8;
                                break;
                            }
                            break;
                        case -760884509:
                            if (str.equals("transformPivotY")) {
                                c = 9;
                                break;
                            }
                            break;
                        case -40300674:
                            if (str.equals("rotation")) {
                                c = 10;
                                break;
                            }
                            break;
                        case -4379043:
                            if (str.equals("elevation")) {
                                c = 11;
                                break;
                            }
                            break;
                        case 37232917:
                            if (str.equals("transitionPathRotate")) {
                                c = 12;
                                break;
                            }
                            break;
                        case 92909918:
                            if (str.equals("alpha")) {
                                c = 13;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            if (Float.isNaN(this.m)) {
                                break;
                            } else {
                                splineSet.c(this.f553a, this.m);
                                break;
                            }
                        case 1:
                            if (Float.isNaN(this.n)) {
                                break;
                            } else {
                                splineSet.c(this.f553a, this.n);
                                break;
                            }
                        case 2:
                            if (Float.isNaN(this.t)) {
                                break;
                            } else {
                                splineSet.c(this.f553a, this.t);
                                break;
                            }
                        case 3:
                            if (Float.isNaN(this.u)) {
                                break;
                            } else {
                                splineSet.c(this.f553a, this.u);
                                break;
                            }
                        case 4:
                            if (Float.isNaN(this.v)) {
                                break;
                            } else {
                                splineSet.c(this.f553a, this.v);
                                break;
                            }
                        case 5:
                            if (Float.isNaN(this.w)) {
                                break;
                            } else {
                                splineSet.c(this.f553a, this.w);
                                break;
                            }
                        case 6:
                            if (Float.isNaN(this.r)) {
                                break;
                            } else {
                                splineSet.c(this.f553a, this.r);
                                break;
                            }
                        case 7:
                            if (Float.isNaN(this.s)) {
                                break;
                            } else {
                                splineSet.c(this.f553a, this.s);
                                break;
                            }
                        case 8:
                            if (Float.isNaN(this.m)) {
                                break;
                            } else {
                                splineSet.c(this.f553a, this.o);
                                break;
                            }
                        case 9:
                            if (Float.isNaN(this.n)) {
                                break;
                            } else {
                                splineSet.c(this.f553a, this.p);
                                break;
                            }
                        case 10:
                            if (Float.isNaN(this.l)) {
                                break;
                            } else {
                                splineSet.c(this.f553a, this.l);
                                break;
                            }
                        case 11:
                            if (Float.isNaN(this.k)) {
                                break;
                            } else {
                                splineSet.c(this.f553a, this.k);
                                break;
                            }
                        case 12:
                            if (Float.isNaN(this.q)) {
                                break;
                            } else {
                                splineSet.c(this.f553a, this.q);
                                break;
                            }
                        case 13:
                            if (Float.isNaN(this.j)) {
                                break;
                            } else {
                                splineSet.c(this.f553a, this.j);
                                break;
                            }
                    }
                } else {
                    ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.e.get(str.substring(7));
                    if (constraintAttribute != null) {
                        ((ViewSpline.CustomSet) splineSet).i(this.f553a, constraintAttribute);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public Key clone() {
        return new KeyAttributes().c(this);
    }

    public Key c(Key key) {
        super.c(key);
        KeyAttributes keyAttributes = (KeyAttributes) key;
        this.h = keyAttributes.h;
        this.i = keyAttributes.i;
        this.j = keyAttributes.j;
        this.k = keyAttributes.k;
        this.l = keyAttributes.l;
        this.m = keyAttributes.m;
        this.n = keyAttributes.n;
        this.o = keyAttributes.o;
        this.p = keyAttributes.p;
        this.q = keyAttributes.q;
        this.r = keyAttributes.r;
        this.s = keyAttributes.s;
        this.t = keyAttributes.t;
        this.u = keyAttributes.u;
        this.v = keyAttributes.v;
        this.w = keyAttributes.w;
        return this;
    }

    public void d(HashSet hashSet) {
        if (!Float.isNaN(this.j)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.k)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.l)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.m)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.n)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.p)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.t)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.u)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.v)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.s)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.w)) {
            hashSet.add(PayloadConstant.PARAMS_KEY_INT_OTA_PROGRESS);
        }
        if (this.e.size() > 0) {
            for (String str : this.e.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public void e(Context context, AttributeSet attributeSet) {
        Loader.a(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyAttribute));
    }

    public void h(HashMap hashMap) {
        if (this.h != -1) {
            if (!Float.isNaN(this.j)) {
                hashMap.put("alpha", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.k)) {
                hashMap.put("elevation", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.l)) {
                hashMap.put("rotation", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.m)) {
                hashMap.put("rotationX", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.n)) {
                hashMap.put("rotationY", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.o)) {
                hashMap.put("transformPivotX", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.p)) {
                hashMap.put("transformPivotY", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.t)) {
                hashMap.put("translationX", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.u)) {
                hashMap.put("translationY", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.v)) {
                hashMap.put("translationZ", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.q)) {
                hashMap.put("transitionPathRotate", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.r)) {
                hashMap.put("scaleX", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.s)) {
                hashMap.put("scaleY", Integer.valueOf(this.h));
            }
            if (!Float.isNaN(this.w)) {
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
