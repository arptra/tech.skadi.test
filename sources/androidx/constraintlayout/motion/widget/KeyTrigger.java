package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

public class KeyTrigger extends Key {
    public HashMap A;
    public int g = -1;
    public String h = null;
    public int i;
    public String j;
    public String k;
    public int l;
    public int m;
    public View n;
    public float o;
    public boolean p;
    public boolean q;
    public boolean r;
    public float s;
    public float t;
    public boolean u;
    public int v;
    public int w;
    public int x;
    public RectF y;
    public RectF z;

    public static class Loader {

        /* renamed from: a  reason: collision with root package name */
        public static SparseIntArray f559a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f559a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTrigger_framePosition, 8);
            f559a.append(R.styleable.KeyTrigger_onCross, 4);
            f559a.append(R.styleable.KeyTrigger_onNegativeCross, 1);
            f559a.append(R.styleable.KeyTrigger_onPositiveCross, 2);
            f559a.append(R.styleable.KeyTrigger_motionTarget, 7);
            f559a.append(R.styleable.KeyTrigger_triggerId, 6);
            f559a.append(R.styleable.KeyTrigger_triggerSlack, 5);
            f559a.append(R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
            f559a.append(R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
            f559a.append(R.styleable.KeyTrigger_triggerReceiver, 11);
            f559a.append(R.styleable.KeyTrigger_viewTransitionOnCross, 12);
            f559a.append(R.styleable.KeyTrigger_viewTransitionOnNegativeCross, 13);
            f559a.append(R.styleable.KeyTrigger_viewTransitionOnPositiveCross, 14);
        }

        public static void a(KeyTrigger keyTrigger, TypedArray typedArray, Context context) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (f559a.get(index)) {
                    case 1:
                        String unused = keyTrigger.j = typedArray.getString(index);
                        break;
                    case 2:
                        String unused2 = keyTrigger.k = typedArray.getString(index);
                        break;
                    case 4:
                        String unused3 = keyTrigger.h = typedArray.getString(index);
                        break;
                    case 5:
                        keyTrigger.o = typedArray.getFloat(index, keyTrigger.o);
                        break;
                    case 6:
                        int unused4 = keyTrigger.l = typedArray.getResourceId(index, keyTrigger.l);
                        break;
                    case 7:
                        if (!MotionLayout.K0) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyTrigger.b = typedArray.getResourceId(index, keyTrigger.b);
                                break;
                            } else {
                                keyTrigger.c = typedArray.getString(index);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyTrigger.b);
                            keyTrigger.b = resourceId;
                            if (resourceId != -1) {
                                break;
                            } else {
                                keyTrigger.c = typedArray.getString(index);
                                break;
                            }
                        }
                    case 8:
                        int integer = typedArray.getInteger(index, keyTrigger.f553a);
                        keyTrigger.f553a = integer;
                        float unused5 = keyTrigger.s = (((float) integer) + 0.5f) / 100.0f;
                        break;
                    case 9:
                        int unused6 = keyTrigger.m = typedArray.getResourceId(index, keyTrigger.m);
                        break;
                    case 10:
                        boolean unused7 = keyTrigger.u = typedArray.getBoolean(index, keyTrigger.u);
                        break;
                    case 11:
                        int unused8 = keyTrigger.i = typedArray.getResourceId(index, keyTrigger.i);
                        break;
                    case 12:
                        keyTrigger.x = typedArray.getResourceId(index, keyTrigger.x);
                        break;
                    case 13:
                        keyTrigger.v = typedArray.getResourceId(index, keyTrigger.v);
                        break;
                    case 14:
                        keyTrigger.w = typedArray.getResourceId(index, keyTrigger.w);
                        break;
                    default:
                        Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(index) + "   " + f559a.get(index));
                        break;
                }
            }
        }
    }

    public KeyTrigger() {
        int i2 = Key.f;
        this.i = i2;
        this.j = null;
        this.k = null;
        this.l = i2;
        this.m = i2;
        this.n = null;
        this.o = 0.1f;
        this.p = true;
        this.q = true;
        this.r = true;
        this.s = Float.NaN;
        this.u = false;
        this.v = i2;
        this.w = i2;
        this.x = i2;
        this.y = new RectF();
        this.z = new RectF();
        this.A = new HashMap();
        this.d = 5;
        this.e = new HashMap();
    }

    public final void A(String str, View view) {
        ConstraintAttribute constraintAttribute;
        boolean z2 = str.length() == 1;
        if (!z2) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String str2 : this.e.keySet()) {
            String lowerCase = str2.toLowerCase(Locale.ROOT);
            if ((z2 || lowerCase.matches(str)) && (constraintAttribute = (ConstraintAttribute) this.e.get(str2)) != null) {
                constraintAttribute.a(view);
            }
        }
    }

    public final void B(RectF rectF, View view, boolean z2) {
        rectF.top = (float) view.getTop();
        rectF.bottom = (float) view.getBottom();
        rectF.left = (float) view.getLeft();
        rectF.right = (float) view.getRight();
        if (z2) {
            view.getMatrix().mapRect(rectF);
        }
    }

    public void a(HashMap hashMap) {
    }

    /* renamed from: b */
    public Key clone() {
        return new KeyTrigger().c(this);
    }

    public Key c(Key key) {
        super.c(key);
        KeyTrigger keyTrigger = (KeyTrigger) key;
        this.g = keyTrigger.g;
        this.h = keyTrigger.h;
        this.i = keyTrigger.i;
        this.j = keyTrigger.j;
        this.k = keyTrigger.k;
        this.l = keyTrigger.l;
        this.m = keyTrigger.m;
        this.n = keyTrigger.n;
        this.o = keyTrigger.o;
        this.p = keyTrigger.p;
        this.q = keyTrigger.q;
        this.r = keyTrigger.r;
        this.s = keyTrigger.s;
        this.t = keyTrigger.t;
        this.u = keyTrigger.u;
        this.y = keyTrigger.y;
        this.z = keyTrigger.z;
        this.A = keyTrigger.A;
        return this;
    }

    public void d(HashSet hashSet) {
    }

    public void e(Context context, AttributeSet attributeSet) {
        Loader.a(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyTrigger), context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void y(float r10, android.view.View r11) {
        /*
            r9 = this;
            int r0 = r9.m
            int r1 = androidx.constraintlayout.motion.widget.Key.f
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x0063
            android.view.View r0 = r9.n
            if (r0 != 0) goto L_0x001a
            android.view.ViewParent r0 = r11.getParent()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r1 = r9.m
            android.view.View r0 = r0.findViewById(r1)
            r9.n = r0
        L_0x001a:
            android.graphics.RectF r0 = r9.y
            android.view.View r1 = r9.n
            boolean r4 = r9.u
            r9.B(r0, r1, r4)
            android.graphics.RectF r0 = r9.z
            boolean r1 = r9.u
            r9.B(r0, r11, r1)
            android.graphics.RectF r0 = r9.y
            android.graphics.RectF r1 = r9.z
            boolean r0 = r0.intersect(r1)
            if (r0 == 0) goto L_0x004a
            boolean r0 = r9.p
            if (r0 == 0) goto L_0x003c
            r9.p = r3
            r0 = r2
            goto L_0x003d
        L_0x003c:
            r0 = r3
        L_0x003d:
            boolean r1 = r9.r
            if (r1 == 0) goto L_0x0045
            r9.r = r3
            r1 = r2
            goto L_0x0046
        L_0x0045:
            r1 = r3
        L_0x0046:
            r9.q = r2
            goto L_0x00df
        L_0x004a:
            boolean r0 = r9.p
            if (r0 != 0) goto L_0x0052
            r9.p = r2
            r0 = r2
            goto L_0x0053
        L_0x0052:
            r0 = r3
        L_0x0053:
            boolean r1 = r9.q
            if (r1 == 0) goto L_0x005b
            r9.q = r3
            r1 = r2
            goto L_0x005c
        L_0x005b:
            r1 = r3
        L_0x005c:
            r9.r = r2
            r8 = r3
            r3 = r1
            r1 = r8
            goto L_0x00df
        L_0x0063:
            boolean r0 = r9.p
            r1 = 0
            if (r0 == 0) goto L_0x0078
            float r0 = r9.s
            float r4 = r10 - r0
            float r5 = r9.t
            float r5 = r5 - r0
            float r4 = r4 * r5
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0088
            r9.p = r3
            r0 = r2
            goto L_0x0089
        L_0x0078:
            float r0 = r9.s
            float r0 = r10 - r0
            float r0 = java.lang.Math.abs(r0)
            float r4 = r9.o
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0088
            r9.p = r2
        L_0x0088:
            r0 = r3
        L_0x0089:
            boolean r4 = r9.q
            if (r4 == 0) goto L_0x00a1
            float r4 = r9.s
            float r5 = r10 - r4
            float r6 = r9.t
            float r6 = r6 - r4
            float r6 = r6 * r5
            int r4 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b1
            int r4 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b1
            r9.q = r3
            r4 = r2
            goto L_0x00b2
        L_0x00a1:
            float r4 = r9.s
            float r4 = r10 - r4
            float r4 = java.lang.Math.abs(r4)
            float r5 = r9.o
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b1
            r9.q = r2
        L_0x00b1:
            r4 = r3
        L_0x00b2:
            boolean r5 = r9.r
            if (r5 == 0) goto L_0x00cd
            float r5 = r9.s
            float r6 = r10 - r5
            float r7 = r9.t
            float r7 = r7 - r5
            float r7 = r7 * r6
            int r5 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r5 >= 0) goto L_0x00c9
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x00c9
            r9.r = r3
            goto L_0x00ca
        L_0x00c9:
            r2 = r3
        L_0x00ca:
            r1 = r2
        L_0x00cb:
            r3 = r4
            goto L_0x00df
        L_0x00cd:
            float r1 = r9.s
            float r1 = r10 - r1
            float r1 = java.lang.Math.abs(r1)
            float r5 = r9.o
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x00dd
            r9.r = r2
        L_0x00dd:
            r1 = r3
            goto L_0x00cb
        L_0x00df:
            r9.t = r10
            if (r3 != 0) goto L_0x00e7
            if (r0 != 0) goto L_0x00e7
            if (r1 == 0) goto L_0x00f2
        L_0x00e7:
            android.view.ViewParent r2 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r2 = (androidx.constraintlayout.motion.widget.MotionLayout) r2
            int r4 = r9.l
            r2.Q(r4, r1, r10)
        L_0x00f2:
            int r10 = r9.i
            int r2 = androidx.constraintlayout.motion.widget.Key.f
            if (r10 != r2) goto L_0x00fa
            r10 = r11
            goto L_0x0106
        L_0x00fa:
            android.view.ViewParent r10 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r10 = (androidx.constraintlayout.motion.widget.MotionLayout) r10
            int r2 = r9.i
            android.view.View r10 = r10.findViewById(r2)
        L_0x0106:
            if (r3 == 0) goto L_0x0124
            java.lang.String r2 = r9.j
            if (r2 == 0) goto L_0x010f
            r9.z(r2, r10)
        L_0x010f:
            int r2 = r9.v
            int r3 = androidx.constraintlayout.motion.widget.Key.f
            if (r2 == r3) goto L_0x0124
            android.view.ViewParent r2 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r2 = (androidx.constraintlayout.motion.widget.MotionLayout) r2
            int r3 = r9.v
            android.view.View[] r4 = new android.view.View[]{r10}
            r2.r0(r3, r4)
        L_0x0124:
            if (r1 == 0) goto L_0x0142
            java.lang.String r1 = r9.k
            if (r1 == 0) goto L_0x012d
            r9.z(r1, r10)
        L_0x012d:
            int r1 = r9.w
            int r2 = androidx.constraintlayout.motion.widget.Key.f
            if (r1 == r2) goto L_0x0142
            android.view.ViewParent r1 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r1 = (androidx.constraintlayout.motion.widget.MotionLayout) r1
            int r2 = r9.w
            android.view.View[] r3 = new android.view.View[]{r10}
            r1.r0(r2, r3)
        L_0x0142:
            if (r0 == 0) goto L_0x0160
            java.lang.String r0 = r9.h
            if (r0 == 0) goto L_0x014b
            r9.z(r0, r10)
        L_0x014b:
            int r0 = r9.x
            int r1 = androidx.constraintlayout.motion.widget.Key.f
            if (r0 == r1) goto L_0x0160
            android.view.ViewParent r11 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r11 = (androidx.constraintlayout.motion.widget.MotionLayout) r11
            int r9 = r9.x
            android.view.View[] r10 = new android.view.View[]{r10}
            r11.r0(r9, r10)
        L_0x0160:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyTrigger.y(float, android.view.View):void");
    }

    public final void z(String str, View view) {
        Method method;
        if (str != null) {
            if (str.startsWith(".")) {
                A(str, view);
                return;
            }
            if (this.A.containsKey(str)) {
                method = (Method) this.A.get(str);
                if (method == null) {
                    return;
                }
            } else {
                method = null;
            }
            if (method == null) {
                try {
                    method = view.getClass().getMethod(str, (Class[]) null);
                    this.A.put(str, method);
                } catch (NoSuchMethodException unused) {
                    this.A.put(str, (Object) null);
                    Log.e("KeyTrigger", "Could not find method \"" + str + "\"on class " + view.getClass().getSimpleName() + " " + Debug.d(view));
                    return;
                }
            }
            try {
                method.invoke(view, (Object[]) null);
            } catch (Exception unused2) {
                Log.e("KeyTrigger", "Exception in call \"" + this.h + "\"on class " + view.getClass().getSimpleName() + " " + Debug.d(view));
            }
        }
    }
}
