package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class MotionController {
    public ArrayList A = new ArrayList();
    public HashMap B;
    public HashMap C;
    public HashMap D;
    public KeyTrigger[] E;
    public int F;
    public int G;
    public View H;
    public int I;
    public float J;
    public Interpolator K;
    public boolean L;

    /* renamed from: a  reason: collision with root package name */
    public Rect f561a = new Rect();
    public View b;
    public int c;
    public boolean d = false;
    public String e;
    public int f = -1;
    public MotionPaths g = new MotionPaths();
    public MotionPaths h = new MotionPaths();
    public MotionConstrainedPoint i = new MotionConstrainedPoint();
    public MotionConstrainedPoint j = new MotionConstrainedPoint();
    public CurveFit[] k;
    public CurveFit l;
    public float m = Float.NaN;
    public float n = 0.0f;
    public float o = 1.0f;
    public float p;
    public float q;
    public int[] r;
    public double[] s;
    public double[] t;
    public String[] u;
    public int[] v;
    public int w = 4;
    public float[] x = new float[4];
    public ArrayList y = new ArrayList();
    public float[] z = new float[1];

    public MotionController(View view) {
        int i2 = Key.f;
        this.F = i2;
        this.G = i2;
        this.H = null;
        this.I = i2;
        this.J = Float.NaN;
        this.K = null;
        this.L = false;
        H(view);
    }

    public static Interpolator p(Context context, int i2, String str, int i3) {
        if (i2 == -2) {
            return AnimationUtils.loadInterpolator(context, i3);
        }
        if (i2 == -1) {
            final Easing c2 = Easing.c(str);
            return new Interpolator() {
                public float getInterpolation(float f) {
                    return (float) Easing.this.a((double) f);
                }
            };
        } else if (i2 == 0) {
            return new AccelerateDecelerateInterpolator();
        } else {
            if (i2 == 1) {
                return new AccelerateInterpolator();
            }
            if (i2 == 2) {
                return new DecelerateInterpolator();
            }
            if (i2 == 4) {
                return new BounceInterpolator();
            }
            if (i2 != 5) {
                return null;
            }
            return new OvershootInterpolator();
        }
    }

    public void A(Rect rect, Rect rect2, int i2, int i3, int i4) {
        if (i2 == 1) {
            int i5 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i4 - ((i5 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i2 == 2) {
            int i6 = rect.left + rect.right;
            rect2.left = i3 - (((rect.top + rect.bottom) + rect.width()) / 2);
            rect2.top = (i6 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i2 == 3) {
            int i7 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i7 / 2);
            rect2.top = i4 - ((i7 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i2 == 4) {
            int i8 = rect.left + rect.right;
            rect2.left = i3 - (((rect.bottom + rect.top) + rect.width()) / 2);
            rect2.top = (i8 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        }
    }

    public void B(View view) {
        MotionPaths motionPaths = this.g;
        motionPaths.c = 0.0f;
        motionPaths.d = 0.0f;
        this.L = true;
        motionPaths.r(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.h.r(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.i.l(view);
        this.j.l(view);
    }

    public void C(Rect rect, ConstraintSet constraintSet, int i2, int i3) {
        int i4 = constraintSet.d;
        if (i4 != 0) {
            A(rect, this.f561a, i4, i2, i3);
            rect = this.f561a;
        }
        MotionPaths motionPaths = this.h;
        motionPaths.c = 1.0f;
        motionPaths.d = 1.0f;
        y(motionPaths);
        this.h.r((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        this.h.a(constraintSet.z(this.c));
        this.j.k(rect, constraintSet, i4, this.c);
    }

    public void D(int i2) {
        this.F = i2;
    }

    public void E(View view) {
        MotionPaths motionPaths = this.g;
        motionPaths.c = 0.0f;
        motionPaths.d = 0.0f;
        motionPaths.r(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.i.l(view);
    }

    public void F(Rect rect, ConstraintSet constraintSet, int i2, int i3) {
        int i4 = constraintSet.d;
        if (i4 != 0) {
            A(rect, this.f561a, i4, i2, i3);
        }
        MotionPaths motionPaths = this.g;
        motionPaths.c = 0.0f;
        motionPaths.d = 0.0f;
        y(motionPaths);
        this.g.r((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        ConstraintSet.Constraint z2 = constraintSet.z(this.c);
        this.g.a(z2);
        this.m = z2.d.g;
        this.i.k(rect, constraintSet, i4, this.c);
        this.G = z2.f.i;
        ConstraintSet.Motion motion = z2.d;
        this.I = motion.k;
        this.J = motion.j;
        Context context = this.b.getContext();
        ConstraintSet.Motion motion2 = z2.d;
        this.K = p(context, motion2.m, motion2.l, motion2.n);
    }

    public void G(ViewState viewState, View view, int i2, int i3, int i4) {
        MotionPaths motionPaths = this.g;
        motionPaths.c = 0.0f;
        motionPaths.d = 0.0f;
        Rect rect = new Rect();
        if (i2 == 1) {
            int i5 = viewState.b + viewState.d;
            rect.left = ((viewState.c + viewState.e) - viewState.b()) / 2;
            rect.top = i3 - ((i5 + viewState.a()) / 2);
            rect.right = rect.left + viewState.b();
            rect.bottom = rect.top + viewState.a();
        } else if (i2 == 2) {
            int i6 = viewState.b + viewState.d;
            rect.left = i4 - (((viewState.c + viewState.e) + viewState.b()) / 2);
            rect.top = (i6 - viewState.a()) / 2;
            rect.right = rect.left + viewState.b();
            rect.bottom = rect.top + viewState.a();
        }
        this.g.r((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        this.i.j(rect, view, i2, viewState.f551a);
    }

    public void H(View view) {
        this.b = view;
        this.c = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.e = ((ConstraintLayout.LayoutParams) layoutParams).a();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x014f, code lost:
        r11 = (java.lang.Integer) r4.get(r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void I(int r17, int r18, float r19, long r20) {
        /*
            r16 = this;
            r0 = r16
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            int r5 = r0.F
            int r6 = androidx.constraintlayout.motion.widget.Key.f
            if (r5 == r6) goto L_0x0025
            androidx.constraintlayout.motion.widget.MotionPaths r6 = r0.g
            r6.k = r5
        L_0x0025:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r5 = r0.i
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r6 = r0.j
            r5.h(r6, r2)
            java.util.ArrayList r5 = r0.A
            if (r5 == 0) goto L_0x008a
            java.util.Iterator r5 = r5.iterator()
            r7 = 0
        L_0x0035:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x008b
            java.lang.Object r8 = r5.next()
            androidx.constraintlayout.motion.widget.Key r8 = (androidx.constraintlayout.motion.widget.Key) r8
            boolean r9 = r8 instanceof androidx.constraintlayout.motion.widget.KeyPosition
            if (r9 == 0) goto L_0x0062
            androidx.constraintlayout.motion.widget.KeyPosition r8 = (androidx.constraintlayout.motion.widget.KeyPosition) r8
            androidx.constraintlayout.motion.widget.MotionPaths r9 = new androidx.constraintlayout.motion.widget.MotionPaths
            androidx.constraintlayout.motion.widget.MotionPaths r14 = r0.g
            androidx.constraintlayout.motion.widget.MotionPaths r15 = r0.h
            r10 = r9
            r11 = r17
            r12 = r18
            r13 = r8
            r10.<init>(r11, r12, r13, r14, r15)
            r0.w(r9)
            int r8 = r8.g
            int r9 = androidx.constraintlayout.motion.widget.Key.f
            if (r8 == r9) goto L_0x0035
            r0.f = r8
            goto L_0x0035
        L_0x0062:
            boolean r9 = r8 instanceof androidx.constraintlayout.motion.widget.KeyCycle
            if (r9 == 0) goto L_0x006a
            r8.d(r3)
            goto L_0x0035
        L_0x006a:
            boolean r9 = r8 instanceof androidx.constraintlayout.motion.widget.KeyTimeCycle
            if (r9 == 0) goto L_0x0072
            r8.d(r1)
            goto L_0x0035
        L_0x0072:
            boolean r9 = r8 instanceof androidx.constraintlayout.motion.widget.KeyTrigger
            if (r9 == 0) goto L_0x0083
            if (r7 != 0) goto L_0x007d
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L_0x007d:
            androidx.constraintlayout.motion.widget.KeyTrigger r8 = (androidx.constraintlayout.motion.widget.KeyTrigger) r8
            r7.add(r8)
            goto L_0x0035
        L_0x0083:
            r8.h(r4)
            r8.d(r2)
            goto L_0x0035
        L_0x008a:
            r7 = 0
        L_0x008b:
            r5 = 0
            if (r7 == 0) goto L_0x0098
            androidx.constraintlayout.motion.widget.KeyTrigger[] r8 = new androidx.constraintlayout.motion.widget.KeyTrigger[r5]
            java.lang.Object[] r7 = r7.toArray(r8)
            androidx.constraintlayout.motion.widget.KeyTrigger[] r7 = (androidx.constraintlayout.motion.widget.KeyTrigger[]) r7
            r0.E = r7
        L_0x0098:
            boolean r7 = r2.isEmpty()
            java.lang.String r8 = ","
            java.lang.String r9 = "CUSTOM,"
            r10 = 1
            if (r7 != 0) goto L_0x016b
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r0.C = r7
            java.util.Iterator r7 = r2.iterator()
        L_0x00ae:
            boolean r11 = r7.hasNext()
            if (r11 == 0) goto L_0x0105
            java.lang.Object r11 = r7.next()
            java.lang.String r11 = (java.lang.String) r11
            boolean r12 = r11.startsWith(r9)
            if (r12 == 0) goto L_0x00f5
            android.util.SparseArray r12 = new android.util.SparseArray
            r12.<init>()
            java.lang.String[] r13 = r11.split(r8)
            r13 = r13[r10]
            java.util.ArrayList r14 = r0.A
            java.util.Iterator r14 = r14.iterator()
        L_0x00d1:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x00f0
            java.lang.Object r15 = r14.next()
            androidx.constraintlayout.motion.widget.Key r15 = (androidx.constraintlayout.motion.widget.Key) r15
            java.util.HashMap r6 = r15.e
            if (r6 != 0) goto L_0x00e2
            goto L_0x00d1
        L_0x00e2:
            java.lang.Object r6 = r6.get(r13)
            androidx.constraintlayout.widget.ConstraintAttribute r6 = (androidx.constraintlayout.widget.ConstraintAttribute) r6
            if (r6 == 0) goto L_0x00d1
            int r15 = r15.f553a
            r12.append(r15, r6)
            goto L_0x00d1
        L_0x00f0:
            androidx.constraintlayout.motion.utils.ViewSpline r6 = androidx.constraintlayout.motion.utils.ViewSpline.f(r11, r12)
            goto L_0x00f9
        L_0x00f5:
            androidx.constraintlayout.motion.utils.ViewSpline r6 = androidx.constraintlayout.motion.utils.ViewSpline.g(r11)
        L_0x00f9:
            if (r6 != 0) goto L_0x00fc
            goto L_0x00ae
        L_0x00fc:
            r6.d(r11)
            java.util.HashMap r12 = r0.C
            r12.put(r11, r6)
            goto L_0x00ae
        L_0x0105:
            java.util.ArrayList r6 = r0.A
            if (r6 == 0) goto L_0x0123
            java.util.Iterator r6 = r6.iterator()
        L_0x010d:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0123
            java.lang.Object r7 = r6.next()
            androidx.constraintlayout.motion.widget.Key r7 = (androidx.constraintlayout.motion.widget.Key) r7
            boolean r11 = r7 instanceof androidx.constraintlayout.motion.widget.KeyAttributes
            if (r11 == 0) goto L_0x010d
            java.util.HashMap r11 = r0.C
            r7.a(r11)
            goto L_0x010d
        L_0x0123:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r6 = r0.i
            java.util.HashMap r7 = r0.C
            r6.a(r7, r5)
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r6 = r0.j
            java.util.HashMap r7 = r0.C
            r11 = 100
            r6.a(r7, r11)
            java.util.HashMap r6 = r0.C
            java.util.Set r6 = r6.keySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x013d:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x016b
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            boolean r11 = r4.containsKey(r7)
            if (r11 == 0) goto L_0x015c
            java.lang.Object r11 = r4.get(r7)
            java.lang.Integer r11 = (java.lang.Integer) r11
            if (r11 == 0) goto L_0x015c
            int r11 = r11.intValue()
            goto L_0x015d
        L_0x015c:
            r11 = r5
        L_0x015d:
            java.util.HashMap r12 = r0.C
            java.lang.Object r7 = r12.get(r7)
            androidx.constraintlayout.core.motion.utils.SplineSet r7 = (androidx.constraintlayout.core.motion.utils.SplineSet) r7
            if (r7 == 0) goto L_0x013d
            r7.e(r11)
            goto L_0x013d
        L_0x016b:
            boolean r6 = r1.isEmpty()
            if (r6 != 0) goto L_0x0238
            java.util.HashMap r6 = r0.B
            if (r6 != 0) goto L_0x017c
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            r0.B = r6
        L_0x017c:
            java.util.Iterator r1 = r1.iterator()
        L_0x0180:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x01e4
            java.lang.Object r6 = r1.next()
            java.lang.String r6 = (java.lang.String) r6
            java.util.HashMap r7 = r0.B
            boolean r7 = r7.containsKey(r6)
            if (r7 == 0) goto L_0x0195
            goto L_0x0180
        L_0x0195:
            boolean r7 = r6.startsWith(r9)
            if (r7 == 0) goto L_0x01d2
            android.util.SparseArray r7 = new android.util.SparseArray
            r7.<init>()
            java.lang.String[] r11 = r6.split(r8)
            r11 = r11[r10]
            java.util.ArrayList r12 = r0.A
            java.util.Iterator r12 = r12.iterator()
        L_0x01ac:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x01cb
            java.lang.Object r13 = r12.next()
            androidx.constraintlayout.motion.widget.Key r13 = (androidx.constraintlayout.motion.widget.Key) r13
            java.util.HashMap r14 = r13.e
            if (r14 != 0) goto L_0x01bd
            goto L_0x01ac
        L_0x01bd:
            java.lang.Object r14 = r14.get(r11)
            androidx.constraintlayout.widget.ConstraintAttribute r14 = (androidx.constraintlayout.widget.ConstraintAttribute) r14
            if (r14 == 0) goto L_0x01ac
            int r13 = r13.f553a
            r7.append(r13, r14)
            goto L_0x01ac
        L_0x01cb:
            androidx.constraintlayout.motion.utils.ViewTimeCycle r7 = androidx.constraintlayout.motion.utils.ViewTimeCycle.g(r6, r7)
            r11 = r20
            goto L_0x01d8
        L_0x01d2:
            r11 = r20
            androidx.constraintlayout.motion.utils.ViewTimeCycle r7 = androidx.constraintlayout.motion.utils.ViewTimeCycle.h(r6, r11)
        L_0x01d8:
            if (r7 != 0) goto L_0x01db
            goto L_0x0180
        L_0x01db:
            r7.d(r6)
            java.util.HashMap r13 = r0.B
            r13.put(r6, r7)
            goto L_0x0180
        L_0x01e4:
            java.util.ArrayList r1 = r0.A
            if (r1 == 0) goto L_0x0204
            java.util.Iterator r1 = r1.iterator()
        L_0x01ec:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0204
            java.lang.Object r6 = r1.next()
            androidx.constraintlayout.motion.widget.Key r6 = (androidx.constraintlayout.motion.widget.Key) r6
            boolean r7 = r6 instanceof androidx.constraintlayout.motion.widget.KeyTimeCycle
            if (r7 == 0) goto L_0x01ec
            androidx.constraintlayout.motion.widget.KeyTimeCycle r6 = (androidx.constraintlayout.motion.widget.KeyTimeCycle) r6
            java.util.HashMap r7 = r0.B
            r6.U(r7)
            goto L_0x01ec
        L_0x0204:
            java.util.HashMap r1 = r0.B
            java.util.Set r1 = r1.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x020e:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0238
            java.lang.Object r6 = r1.next()
            java.lang.String r6 = (java.lang.String) r6
            boolean r7 = r4.containsKey(r6)
            if (r7 == 0) goto L_0x022b
            java.lang.Object r7 = r4.get(r6)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            goto L_0x022c
        L_0x022b:
            r7 = r5
        L_0x022c:
            java.util.HashMap r8 = r0.B
            java.lang.Object r6 = r8.get(r6)
            androidx.constraintlayout.motion.utils.ViewTimeCycle r6 = (androidx.constraintlayout.motion.utils.ViewTimeCycle) r6
            r6.e(r7)
            goto L_0x020e
        L_0x0238:
            java.util.ArrayList r1 = r0.y
            int r1 = r1.size()
            int r4 = r1 + 2
            androidx.constraintlayout.motion.widget.MotionPaths[] r6 = new androidx.constraintlayout.motion.widget.MotionPaths[r4]
            androidx.constraintlayout.motion.widget.MotionPaths r7 = r0.g
            r6[r5] = r7
            int r1 = r1 + r10
            androidx.constraintlayout.motion.widget.MotionPaths r7 = r0.h
            r6[r1] = r7
            java.util.ArrayList r1 = r0.y
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x025a
            int r1 = r0.f
            r7 = -1
            if (r1 != r7) goto L_0x025a
            r0.f = r5
        L_0x025a:
            java.util.ArrayList r1 = r0.y
            java.util.Iterator r1 = r1.iterator()
            r7 = r10
        L_0x0261:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L_0x0273
            java.lang.Object r8 = r1.next()
            androidx.constraintlayout.motion.widget.MotionPaths r8 = (androidx.constraintlayout.motion.widget.MotionPaths) r8
            int r11 = r7 + 1
            r6[r7] = r8
            r7 = r11
            goto L_0x0261
        L_0x0273:
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            androidx.constraintlayout.motion.widget.MotionPaths r7 = r0.h
            java.util.LinkedHashMap r7 = r7.o
            java.util.Set r7 = r7.keySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x0284:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x02b3
            java.lang.Object r8 = r7.next()
            java.lang.String r8 = (java.lang.String) r8
            androidx.constraintlayout.motion.widget.MotionPaths r11 = r0.g
            java.util.LinkedHashMap r11 = r11.o
            boolean r11 = r11.containsKey(r8)
            if (r11 == 0) goto L_0x0284
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            r11.append(r8)
            java.lang.String r11 = r11.toString()
            boolean r11 = r2.contains(r11)
            if (r11 != 0) goto L_0x0284
            r1.add(r8)
            goto L_0x0284
        L_0x02b3:
            java.lang.String[] r2 = new java.lang.String[r5]
            java.lang.Object[] r1 = r1.toArray(r2)
            java.lang.String[] r1 = (java.lang.String[]) r1
            r0.u = r1
            int r1 = r1.length
            int[] r1 = new int[r1]
            r0.v = r1
            r1 = r5
        L_0x02c3:
            java.lang.String[] r2 = r0.u
            int r7 = r2.length
            if (r1 >= r7) goto L_0x02f9
            r2 = r2[r1]
            int[] r7 = r0.v
            r7[r1] = r5
            r7 = r5
        L_0x02cf:
            if (r7 >= r4) goto L_0x02f6
            r8 = r6[r7]
            java.util.LinkedHashMap r8 = r8.o
            boolean r8 = r8.containsKey(r2)
            if (r8 == 0) goto L_0x02f3
            r8 = r6[r7]
            java.util.LinkedHashMap r8 = r8.o
            java.lang.Object r8 = r8.get(r2)
            androidx.constraintlayout.widget.ConstraintAttribute r8 = (androidx.constraintlayout.widget.ConstraintAttribute) r8
            if (r8 == 0) goto L_0x02f3
            int[] r2 = r0.v
            r7 = r2[r1]
            int r8 = r8.h()
            int r7 = r7 + r8
            r2[r1] = r7
            goto L_0x02f6
        L_0x02f3:
            int r7 = r7 + 1
            goto L_0x02cf
        L_0x02f6:
            int r1 = r1 + 1
            goto L_0x02c3
        L_0x02f9:
            r1 = r6[r5]
            int r1 = r1.k
            int r7 = androidx.constraintlayout.motion.widget.Key.f
            if (r1 == r7) goto L_0x0303
            r1 = r10
            goto L_0x0304
        L_0x0303:
            r1 = r5
        L_0x0304:
            int r2 = r2.length
            r7 = 18
            int r7 = r7 + r2
            boolean[] r2 = new boolean[r7]
            r8 = r10
        L_0x030b:
            if (r8 >= r4) goto L_0x031b
            r9 = r6[r8]
            int r11 = r8 + -1
            r11 = r6[r11]
            java.lang.String[] r12 = r0.u
            r9.f(r11, r2, r12, r1)
            int r8 = r8 + 1
            goto L_0x030b
        L_0x031b:
            r8 = r5
            r1 = r10
        L_0x031d:
            if (r1 >= r7) goto L_0x0328
            boolean r9 = r2[r1]
            if (r9 == 0) goto L_0x0325
            int r8 = r8 + 1
        L_0x0325:
            int r1 = r1 + 1
            goto L_0x031d
        L_0x0328:
            int[] r1 = new int[r8]
            r0.r = r1
            r1 = 2
            int r8 = java.lang.Math.max(r1, r8)
            double[] r9 = new double[r8]
            r0.s = r9
            double[] r8 = new double[r8]
            r0.t = r8
            r9 = r5
            r8 = r10
        L_0x033b:
            if (r8 >= r7) goto L_0x034b
            boolean r11 = r2[r8]
            if (r11 == 0) goto L_0x0348
            int[] r11 = r0.r
            int r12 = r9 + 1
            r11[r9] = r8
            r9 = r12
        L_0x0348:
            int r8 = r8 + 1
            goto L_0x033b
        L_0x034b:
            int[] r2 = r0.r
            int r2 = r2.length
            int[] r7 = new int[r1]
            r7[r10] = r2
            r7[r5] = r4
            java.lang.Class r2 = java.lang.Double.TYPE
            java.lang.Object r2 = java.lang.reflect.Array.newInstance(r2, r7)
            double[][] r2 = (double[][]) r2
            double[] r7 = new double[r4]
            r8 = r5
        L_0x035f:
            if (r8 >= r4) goto L_0x0374
            r9 = r6[r8]
            r11 = r2[r8]
            int[] r12 = r0.r
            r9.g(r11, r12)
            r9 = r6[r8]
            float r9 = r9.c
            double r11 = (double) r9
            r7[r8] = r11
            int r8 = r8 + 1
            goto L_0x035f
        L_0x0374:
            r8 = r5
        L_0x0375:
            int[] r9 = r0.r
            int r11 = r9.length
            if (r8 >= r11) goto L_0x03b6
            r9 = r9[r8]
            java.lang.String[] r11 = androidx.constraintlayout.motion.widget.MotionPaths.t
            int r11 = r11.length
            if (r9 >= r11) goto L_0x03b3
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String[] r11 = androidx.constraintlayout.motion.widget.MotionPaths.t
            int[] r12 = r0.r
            r12 = r12[r8]
            r11 = r11[r12]
            r9.append(r11)
            java.lang.String r11 = " ["
            r9.append(r11)
            java.lang.String r9 = r9.toString()
            r11 = r5
        L_0x039b:
            if (r11 >= r4) goto L_0x03b3
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r9)
            r9 = r2[r11]
            r13 = r9[r8]
            r12.append(r13)
            java.lang.String r9 = r12.toString()
            int r11 = r11 + 1
            goto L_0x039b
        L_0x03b3:
            int r8 = r8 + 1
            goto L_0x0375
        L_0x03b6:
            java.lang.String[] r8 = r0.u
            int r8 = r8.length
            int r8 = r8 + r10
            androidx.constraintlayout.core.motion.utils.CurveFit[] r8 = new androidx.constraintlayout.core.motion.utils.CurveFit[r8]
            r0.k = r8
            r8 = r5
        L_0x03bf:
            java.lang.String[] r9 = r0.u
            int r11 = r9.length
            if (r8 >= r11) goto L_0x0423
            r9 = r9[r8]
            r11 = r5
            r13 = r11
            r12 = 0
            r14 = 0
        L_0x03ca:
            if (r11 >= r4) goto L_0x0406
            r15 = r6[r11]
            boolean r15 = r15.m(r9)
            if (r15 == 0) goto L_0x03fd
            if (r14 != 0) goto L_0x03ec
            double[] r12 = new double[r4]
            r14 = r6[r11]
            int r14 = r14.k(r9)
            int[] r15 = new int[r1]
            r15[r10] = r14
            r15[r5] = r4
            java.lang.Class r14 = java.lang.Double.TYPE
            java.lang.Object r14 = java.lang.reflect.Array.newInstance(r14, r15)
            double[][] r14 = (double[][]) r14
        L_0x03ec:
            r15 = r6[r11]
            float r10 = r15.c
            r20 = r2
            double r1 = (double) r10
            r12[r13] = r1
            r1 = r14[r13]
            r15.j(r9, r1, r5)
            int r13 = r13 + 1
            goto L_0x03ff
        L_0x03fd:
            r20 = r2
        L_0x03ff:
            int r11 = r11 + 1
            r2 = r20
            r1 = 2
            r10 = 1
            goto L_0x03ca
        L_0x0406:
            r20 = r2
            double[] r1 = java.util.Arrays.copyOf(r12, r13)
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r14, r13)
            double[][] r2 = (double[][]) r2
            androidx.constraintlayout.core.motion.utils.CurveFit[] r9 = r0.k
            int r8 = r8 + 1
            int r10 = r0.f
            androidx.constraintlayout.core.motion.utils.CurveFit r1 = androidx.constraintlayout.core.motion.utils.CurveFit.a(r10, r1, r2)
            r9[r8] = r1
            r2 = r20
            r1 = 2
            r10 = 1
            goto L_0x03bf
        L_0x0423:
            r20 = r2
            androidx.constraintlayout.core.motion.utils.CurveFit[] r1 = r0.k
            int r2 = r0.f
            r8 = r20
            androidx.constraintlayout.core.motion.utils.CurveFit r2 = androidx.constraintlayout.core.motion.utils.CurveFit.a(r2, r7, r8)
            r1[r5] = r2
            r1 = r6[r5]
            int r1 = r1.k
            int r2 = androidx.constraintlayout.motion.widget.Key.f
            if (r1 == r2) goto L_0x0471
            int[] r1 = new int[r4]
            double[] r2 = new double[r4]
            r7 = 2
            int[] r8 = new int[r7]
            r9 = 1
            r8[r9] = r7
            r8[r5] = r4
            java.lang.Class r7 = java.lang.Double.TYPE
            java.lang.Object r7 = java.lang.reflect.Array.newInstance(r7, r8)
            double[][] r7 = (double[][]) r7
            r8 = r5
        L_0x044e:
            if (r8 >= r4) goto L_0x046b
            r9 = r6[r8]
            int r10 = r9.k
            r1[r8] = r10
            float r10 = r9.c
            double r10 = (double) r10
            r2[r8] = r10
            r10 = r7[r8]
            float r11 = r9.e
            double r11 = (double) r11
            r10[r5] = r11
            float r9 = r9.f
            double r11 = (double) r9
            r9 = 1
            r10[r9] = r11
            int r8 = r8 + 1
            goto L_0x044e
        L_0x046b:
            androidx.constraintlayout.core.motion.utils.CurveFit r1 = androidx.constraintlayout.core.motion.utils.CurveFit.b(r1, r2, r7)
            r0.l = r1
        L_0x0471:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r0.D = r1
            java.util.ArrayList r1 = r0.A
            if (r1 == 0) goto L_0x04e6
            java.util.Iterator r1 = r3.iterator()
            r2 = 2143289344(0x7fc00000, float:NaN)
        L_0x0482:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x04ae
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            androidx.constraintlayout.motion.utils.ViewOscillator r4 = androidx.constraintlayout.motion.utils.ViewOscillator.i(r3)
            if (r4 != 0) goto L_0x0495
            goto L_0x0482
        L_0x0495:
            boolean r5 = r4.h()
            if (r5 == 0) goto L_0x04a5
            boolean r5 = java.lang.Float.isNaN(r2)
            if (r5 == 0) goto L_0x04a5
            float r2 = r16.s()
        L_0x04a5:
            r4.f(r3)
            java.util.HashMap r5 = r0.D
            r5.put(r3, r4)
            goto L_0x0482
        L_0x04ae:
            java.util.ArrayList r1 = r0.A
            java.util.Iterator r1 = r1.iterator()
        L_0x04b4:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x04cc
            java.lang.Object r3 = r1.next()
            androidx.constraintlayout.motion.widget.Key r3 = (androidx.constraintlayout.motion.widget.Key) r3
            boolean r4 = r3 instanceof androidx.constraintlayout.motion.widget.KeyCycle
            if (r4 == 0) goto L_0x04b4
            androidx.constraintlayout.motion.widget.KeyCycle r3 = (androidx.constraintlayout.motion.widget.KeyCycle) r3
            java.util.HashMap r4 = r0.D
            r3.Y(r4)
            goto L_0x04b4
        L_0x04cc:
            java.util.HashMap r0 = r0.D
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L_0x04d6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x04e6
            java.lang.Object r1 = r0.next()
            androidx.constraintlayout.motion.utils.ViewOscillator r1 = (androidx.constraintlayout.motion.utils.ViewOscillator) r1
            r1.g(r2)
            goto L_0x04d6
        L_0x04e6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionController.I(int, int, float, long):void");
    }

    public void J(MotionController motionController) {
        this.g.u(motionController, motionController.g);
        this.h.u(motionController, motionController.h);
    }

    public void a(Key key) {
        this.A.add(key);
    }

    public void b(ArrayList arrayList) {
        this.A.addAll(arrayList);
    }

    public int c(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] h2 = this.k[0].h();
        if (iArr != null) {
            Iterator it = this.y.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                iArr[i2] = ((MotionPaths) it.next()).p;
                i2++;
            }
        }
        int i3 = 0;
        for (int i4 = 0; i4 < h2.length; i4++) {
            this.k[0].d(h2[i4], this.s);
            this.g.h(h2[i4], this.r, this.s, fArr, i3);
            i3 += 2;
        }
        return i3 / 2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: androidx.constraintlayout.motion.utils.ViewOscillator} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(float[] r21, int r22) {
        /*
            r20 = this;
            r0 = r20
            r8 = r22
            int r1 = r8 + -1
            float r1 = (float) r1
            r9 = 1065353216(0x3f800000, float:1.0)
            float r10 = r9 / r1
            java.util.HashMap r1 = r0.C
            java.lang.String r2 = "translationX"
            r3 = 0
            if (r1 != 0) goto L_0x0014
            r11 = r3
            goto L_0x001b
        L_0x0014:
            java.lang.Object r1 = r1.get(r2)
            androidx.constraintlayout.core.motion.utils.SplineSet r1 = (androidx.constraintlayout.core.motion.utils.SplineSet) r1
            r11 = r1
        L_0x001b:
            java.util.HashMap r1 = r0.C
            java.lang.String r4 = "translationY"
            if (r1 != 0) goto L_0x0023
            r12 = r3
            goto L_0x002a
        L_0x0023:
            java.lang.Object r1 = r1.get(r4)
            androidx.constraintlayout.core.motion.utils.SplineSet r1 = (androidx.constraintlayout.core.motion.utils.SplineSet) r1
            r12 = r1
        L_0x002a:
            java.util.HashMap r1 = r0.D
            if (r1 != 0) goto L_0x0030
            r13 = r3
            goto L_0x0037
        L_0x0030:
            java.lang.Object r1 = r1.get(r2)
            androidx.constraintlayout.motion.utils.ViewOscillator r1 = (androidx.constraintlayout.motion.utils.ViewOscillator) r1
            r13 = r1
        L_0x0037:
            java.util.HashMap r1 = r0.D
            if (r1 != 0) goto L_0x003d
        L_0x003b:
            r14 = r3
            goto L_0x0045
        L_0x003d:
            java.lang.Object r1 = r1.get(r4)
            r3 = r1
            androidx.constraintlayout.motion.utils.ViewOscillator r3 = (androidx.constraintlayout.motion.utils.ViewOscillator) r3
            goto L_0x003b
        L_0x0045:
            r7 = 0
        L_0x0046:
            if (r7 >= r8) goto L_0x0122
            float r1 = (float) r7
            float r1 = r1 * r10
            float r2 = r0.o
            int r3 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            r4 = 0
            if (r3 == 0) goto L_0x0069
            float r3 = r0.n
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0058
            r1 = r4
        L_0x0058:
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0069
            double r5 = (double) r1
            r16 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r5 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r5 >= 0) goto L_0x0069
            float r1 = r1 - r3
            float r1 = r1 * r2
            float r1 = java.lang.Math.min(r1, r9)
        L_0x0069:
            r6 = r1
            double r1 = (double) r6
            androidx.constraintlayout.motion.widget.MotionPaths r3 = r0.g
            androidx.constraintlayout.core.motion.utils.Easing r3 = r3.f574a
            java.util.ArrayList r5 = r0.y
            java.util.Iterator r5 = r5.iterator()
            r16 = 2143289344(0x7fc00000, float:NaN)
        L_0x0077:
            boolean r17 = r5.hasNext()
            if (r17 == 0) goto L_0x00a3
            java.lang.Object r17 = r5.next()
            r9 = r17
            androidx.constraintlayout.motion.widget.MotionPaths r9 = (androidx.constraintlayout.motion.widget.MotionPaths) r9
            androidx.constraintlayout.core.motion.utils.Easing r15 = r9.f574a
            r18 = r1
            if (r15 == 0) goto L_0x009e
            float r1 = r9.c
            int r2 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x0094
            r4 = r1
            r3 = r15
            goto L_0x009e
        L_0x0094:
            boolean r1 = java.lang.Float.isNaN(r16)
            if (r1 == 0) goto L_0x009e
            float r1 = r9.c
            r16 = r1
        L_0x009e:
            r1 = r18
            r9 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0077
        L_0x00a3:
            r18 = r1
            if (r3 == 0) goto L_0x00c1
            boolean r1 = java.lang.Float.isNaN(r16)
            if (r1 == 0) goto L_0x00af
            r16 = 1065353216(0x3f800000, float:1.0)
        L_0x00af:
            float r1 = r6 - r4
            float r16 = r16 - r4
            float r1 = r1 / r16
            double r1 = (double) r1
            double r1 = r3.a(r1)
            float r1 = (float) r1
            float r1 = r1 * r16
            float r1 = r1 + r4
            double r1 = (double) r1
            r2 = r1
            goto L_0x00c3
        L_0x00c1:
            r2 = r18
        L_0x00c3:
            androidx.constraintlayout.core.motion.utils.CurveFit[] r1 = r0.k
            r9 = 0
            r1 = r1[r9]
            double[] r4 = r0.s
            r1.d(r2, r4)
            androidx.constraintlayout.core.motion.utils.CurveFit r1 = r0.l
            if (r1 == 0) goto L_0x00d9
            double[] r4 = r0.s
            int r5 = r4.length
            if (r5 <= 0) goto L_0x00d9
            r1.d(r2, r4)
        L_0x00d9:
            androidx.constraintlayout.motion.widget.MotionPaths r1 = r0.g
            int[] r4 = r0.r
            double[] r5 = r0.s
            int r15 = r7 * 2
            r9 = r6
            r6 = r21
            r16 = r7
            r7 = r15
            r1.h(r2, r4, r5, r6, r7)
            if (r13 == 0) goto L_0x00f6
            r1 = r21[r15]
            float r2 = r13.a(r9)
            float r1 = r1 + r2
            r21[r15] = r1
            goto L_0x0101
        L_0x00f6:
            if (r11 == 0) goto L_0x0101
            r1 = r21[r15]
            float r2 = r11.a(r9)
            float r1 = r1 + r2
            r21[r15] = r1
        L_0x0101:
            if (r14 == 0) goto L_0x010f
            int r15 = r15 + 1
            r1 = r21[r15]
            float r2 = r14.a(r9)
            float r1 = r1 + r2
            r21[r15] = r1
            goto L_0x011c
        L_0x010f:
            if (r12 == 0) goto L_0x011c
            int r15 = r15 + 1
            r1 = r21[r15]
            float r2 = r12.a(r9)
            float r1 = r1 + r2
            r21[r15] = r1
        L_0x011c:
            int r7 = r16 + 1
            r9 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0046
        L_0x0122:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionController.d(float[], int):void");
    }

    public void e(float f2, float[] fArr, int i2) {
        this.k[0].d((double) g(f2, (float[]) null), this.s);
        this.g.l(this.r, this.s, fArr, i2);
    }

    public void f(boolean z2) {
        if ("button".equals(Debug.d(this.b)) && this.E != null) {
            int i2 = 0;
            while (true) {
                KeyTrigger[] keyTriggerArr = this.E;
                if (i2 < keyTriggerArr.length) {
                    keyTriggerArr[i2].y(z2 ? -100.0f : 100.0f, this.b);
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public final float g(float f2, float[] fArr) {
        float f3 = 0.0f;
        float f4 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f5 = this.o;
            if (((double) f5) != 1.0d) {
                float f6 = this.n;
                if (f2 < f6) {
                    f2 = 0.0f;
                }
                if (f2 > f6 && ((double) f2) < 1.0d) {
                    f2 = Math.min((f2 - f6) * f5, 1.0f);
                }
            }
        }
        Easing easing = this.g.f574a;
        Iterator it = this.y.iterator();
        float f7 = Float.NaN;
        while (it.hasNext()) {
            MotionPaths motionPaths = (MotionPaths) it.next();
            Easing easing2 = motionPaths.f574a;
            if (easing2 != null) {
                float f8 = motionPaths.c;
                if (f8 < f2) {
                    easing = easing2;
                    f3 = f8;
                } else if (Float.isNaN(f7)) {
                    f7 = motionPaths.c;
                }
            }
        }
        if (easing == null) {
            return f2;
        }
        if (!Float.isNaN(f7)) {
            f4 = f7;
        }
        float f9 = f4 - f3;
        double d2 = (double) ((f2 - f3) / f9);
        float a2 = f3 + (((float) easing.a(d2)) * f9);
        if (fArr != null) {
            fArr[0] = (float) easing.b(d2);
        }
        return a2;
    }

    public int h() {
        return this.g.l;
    }

    public void i(double d2, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.k[0].d(d2, dArr);
        this.k[0].g(d2, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.g.i(d2, this.r, dArr, fArr, dArr2, fArr2);
    }

    public float j() {
        return this.p;
    }

    public float k() {
        return this.q;
    }

    public void l(float f2, float f3, float f4, float[] fArr) {
        double[] dArr;
        float g2 = g(f2, this.z);
        CurveFit[] curveFitArr = this.k;
        int i2 = 0;
        if (curveFitArr != null) {
            double d2 = (double) g2;
            curveFitArr[0].g(d2, this.t);
            this.k[0].d(d2, this.s);
            float f5 = this.z[0];
            while (true) {
                dArr = this.t;
                if (i2 >= dArr.length) {
                    break;
                }
                dArr[i2] = dArr[i2] * ((double) f5);
                i2++;
            }
            CurveFit curveFit = this.l;
            if (curveFit != null) {
                double[] dArr2 = this.s;
                if (dArr2.length > 0) {
                    curveFit.d(d2, dArr2);
                    this.l.g(d2, this.t);
                    this.g.s(f3, f4, fArr, this.r, this.t, this.s);
                    return;
                }
                return;
            }
            this.g.s(f3, f4, fArr, this.r, dArr, this.s);
            return;
        }
        MotionPaths motionPaths = this.h;
        float f6 = motionPaths.e;
        MotionPaths motionPaths2 = this.g;
        float f7 = f6 - motionPaths2.e;
        float f8 = motionPaths.f - motionPaths2.f;
        float f9 = (motionPaths.g - motionPaths2.g) + f7;
        float f10 = (motionPaths.h - motionPaths2.h) + f8;
        fArr[0] = (f7 * (1.0f - f3)) + (f9 * f3);
        fArr[1] = (f8 * (1.0f - f4)) + (f10 * f4);
    }

    public int m() {
        int i2 = this.g.b;
        Iterator it = this.y.iterator();
        while (it.hasNext()) {
            i2 = Math.max(i2, ((MotionPaths) it.next()).b);
        }
        return Math.max(i2, this.h.b);
    }

    public float n() {
        return this.h.e;
    }

    public float o() {
        return this.h.f;
    }

    public MotionPaths q(int i2) {
        return (MotionPaths) this.y.get(i2);
    }

    public void r(float f2, int i2, int i3, float f3, float f4, float[] fArr) {
        float g2 = g(f2, this.z);
        HashMap hashMap = this.C;
        ViewOscillator viewOscillator = null;
        SplineSet splineSet = hashMap == null ? null : (SplineSet) hashMap.get("translationX");
        HashMap hashMap2 = this.C;
        SplineSet splineSet2 = hashMap2 == null ? null : (SplineSet) hashMap2.get("translationY");
        HashMap hashMap3 = this.C;
        SplineSet splineSet3 = hashMap3 == null ? null : (SplineSet) hashMap3.get("rotation");
        HashMap hashMap4 = this.C;
        SplineSet splineSet4 = hashMap4 == null ? null : (SplineSet) hashMap4.get("scaleX");
        HashMap hashMap5 = this.C;
        SplineSet splineSet5 = hashMap5 == null ? null : (SplineSet) hashMap5.get("scaleY");
        HashMap hashMap6 = this.D;
        ViewOscillator viewOscillator2 = hashMap6 == null ? null : (ViewOscillator) hashMap6.get("translationX");
        HashMap hashMap7 = this.D;
        ViewOscillator viewOscillator3 = hashMap7 == null ? null : (ViewOscillator) hashMap7.get("translationY");
        HashMap hashMap8 = this.D;
        ViewOscillator viewOscillator4 = hashMap8 == null ? null : (ViewOscillator) hashMap8.get("rotation");
        HashMap hashMap9 = this.D;
        ViewOscillator viewOscillator5 = hashMap9 == null ? null : (ViewOscillator) hashMap9.get("scaleX");
        HashMap hashMap10 = this.D;
        if (hashMap10 != null) {
            viewOscillator = (ViewOscillator) hashMap10.get("scaleY");
        }
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.b();
        velocityMatrix.d(splineSet3, g2);
        velocityMatrix.h(splineSet, splineSet2, g2);
        velocityMatrix.f(splineSet4, splineSet5, g2);
        velocityMatrix.c(viewOscillator4, g2);
        velocityMatrix.g(viewOscillator2, viewOscillator3, g2);
        velocityMatrix.e(viewOscillator5, viewOscillator, g2);
        CurveFit curveFit = this.l;
        if (curveFit != null) {
            double[] dArr = this.s;
            if (dArr.length > 0) {
                double d2 = (double) g2;
                curveFit.d(d2, dArr);
                this.l.g(d2, this.t);
                this.g.s(f3, f4, fArr, this.r, this.t, this.s);
            }
            velocityMatrix.a(f3, f4, i2, i3, fArr);
            return;
        }
        int i4 = 0;
        if (this.k != null) {
            double g3 = (double) g(g2, this.z);
            this.k[0].g(g3, this.t);
            this.k[0].d(g3, this.s);
            float f5 = this.z[0];
            while (true) {
                double[] dArr2 = this.t;
                if (i4 < dArr2.length) {
                    dArr2[i4] = dArr2[i4] * ((double) f5);
                    i4++;
                } else {
                    MotionPaths motionPaths = this.g;
                    int[] iArr = this.r;
                    double[] dArr3 = this.s;
                    MotionPaths motionPaths2 = motionPaths;
                    float f6 = f3;
                    float f7 = f4;
                    motionPaths2.s(f6, f7, fArr, iArr, dArr2, dArr3);
                    velocityMatrix.a(f6, f7, i2, i3, fArr);
                    return;
                }
            }
        } else {
            MotionPaths motionPaths3 = this.h;
            float f8 = motionPaths3.e;
            MotionPaths motionPaths4 = this.g;
            float f9 = f8 - motionPaths4.e;
            float f10 = motionPaths3.f - motionPaths4.f;
            ViewOscillator viewOscillator6 = viewOscillator5;
            float f11 = (motionPaths3.h - motionPaths4.h) + f10;
            fArr[0] = (f9 * (1.0f - f3)) + (((motionPaths3.g - motionPaths4.g) + f9) * f3);
            fArr[1] = (f10 * (1.0f - f4)) + (f11 * f4);
            velocityMatrix.b();
            velocityMatrix.d(splineSet3, g2);
            velocityMatrix.h(splineSet, splineSet2, g2);
            velocityMatrix.f(splineSet4, splineSet5, g2);
            velocityMatrix.c(viewOscillator4, g2);
            velocityMatrix.g(viewOscillator2, viewOscillator3, g2);
            velocityMatrix.e(viewOscillator6, viewOscillator, g2);
            velocityMatrix.a(f3, f4, i2, i3, fArr);
        }
    }

    public final float s() {
        char c2;
        float f2;
        float[] fArr = new float[2];
        float f3 = 1.0f / ((float) 99);
        double d2 = 0.0d;
        double d3 = 0.0d;
        float f4 = 0.0f;
        int i2 = 0;
        while (i2 < 100) {
            float f5 = ((float) i2) * f3;
            double d4 = (double) f5;
            Easing easing = this.g.f574a;
            Iterator it = this.y.iterator();
            float f6 = Float.NaN;
            float f7 = 0.0f;
            while (it.hasNext()) {
                MotionPaths motionPaths = (MotionPaths) it.next();
                Easing easing2 = motionPaths.f574a;
                if (easing2 != null) {
                    float f8 = motionPaths.c;
                    if (f8 < f5) {
                        easing = easing2;
                        f7 = f8;
                    } else if (Float.isNaN(f6)) {
                        f6 = motionPaths.c;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f6)) {
                    f6 = 1.0f;
                }
                float f9 = f6 - f7;
                d4 = (double) ((((float) easing.a((double) ((f5 - f7) / f9))) * f9) + f7);
            }
            this.k[0].d(d4, this.s);
            float f10 = f4;
            int i3 = i2;
            this.g.h(d4, this.r, this.s, fArr, 0);
            if (i3 > 0) {
                c2 = 0;
                f2 = (float) (((double) f10) + Math.hypot(d3 - ((double) fArr[1]), d2 - ((double) fArr[0])));
            } else {
                c2 = 0;
                f2 = f10;
            }
            d2 = (double) fArr[c2];
            i2 = i3 + 1;
            f4 = f2;
            d3 = (double) fArr[1];
        }
        return f4;
    }

    public float t() {
        return this.g.e;
    }

    public String toString() {
        return " start: x: " + this.g.e + " y: " + this.g.f + " end: x: " + this.h.e + " y: " + this.h.f;
    }

    public float u() {
        return this.g.f;
    }

    public View v() {
        return this.b;
    }

    public final void w(MotionPaths motionPaths) {
        int binarySearch = Collections.binarySearch(this.y, motionPaths);
        if (binarySearch == 0) {
            Log.e("MotionController", " KeyPath position \"" + motionPaths.d + "\" outside of range");
        }
        this.y.add((-binarySearch) - 1, motionPaths);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v58, resolved type: androidx.constraintlayout.motion.utils.ViewTimeCycle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: androidx.constraintlayout.motion.utils.ViewTimeCycle$PathRotate} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean x(android.view.View r21, float r22, long r23, androidx.constraintlayout.core.motion.utils.KeyCache r25) {
        /*
            r20 = this;
            r0 = r20
            r11 = r21
            r1 = 0
            r2 = r22
            float r2 = r0.g(r2, r1)
            int r3 = r0.I
            int r4 = androidx.constraintlayout.motion.widget.Key.f
            r13 = 1065353216(0x3f800000, float:1.0)
            if (r3 == r4) goto L_0x0042
            float r3 = (float) r3
            float r3 = r13 / r3
            float r4 = r2 / r3
            double r4 = (double) r4
            double r4 = java.lang.Math.floor(r4)
            float r4 = (float) r4
            float r4 = r4 * r3
            float r2 = r2 % r3
            float r2 = r2 / r3
            float r5 = r0.J
            boolean r5 = java.lang.Float.isNaN(r5)
            if (r5 != 0) goto L_0x002d
            float r5 = r0.J
            float r2 = r2 + r5
            float r2 = r2 % r13
        L_0x002d:
            android.view.animation.Interpolator r5 = r0.K
            if (r5 == 0) goto L_0x0036
            float r2 = r5.getInterpolation(r2)
            goto L_0x0040
        L_0x0036:
            double r5 = (double) r2
            r7 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x003f
            r2 = r13
            goto L_0x0040
        L_0x003f:
            r2 = 0
        L_0x0040:
            float r2 = r2 * r3
            float r2 = r2 + r4
        L_0x0042:
            r14 = r2
            java.util.HashMap r2 = r0.C
            if (r2 == 0) goto L_0x005f
            java.util.Collection r2 = r2.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x004f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x005f
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.motion.utils.ViewSpline r3 = (androidx.constraintlayout.motion.utils.ViewSpline) r3
            r3.h(r11, r14)
            goto L_0x004f
        L_0x005f:
            java.util.HashMap r2 = r0.B
            r15 = 0
            if (r2 == 0) goto L_0x0093
            java.util.Collection r2 = r2.values()
            java.util.Iterator r7 = r2.iterator()
            r8 = r1
            r9 = r15
        L_0x006e:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x008f
            java.lang.Object r1 = r7.next()
            androidx.constraintlayout.motion.utils.ViewTimeCycle r1 = (androidx.constraintlayout.motion.utils.ViewTimeCycle) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.utils.ViewTimeCycle.PathRotate
            if (r2 == 0) goto L_0x0082
            r8 = r1
            androidx.constraintlayout.motion.utils.ViewTimeCycle$PathRotate r8 = (androidx.constraintlayout.motion.utils.ViewTimeCycle.PathRotate) r8
            goto L_0x006e
        L_0x0082:
            r2 = r21
            r3 = r14
            r4 = r23
            r6 = r25
            boolean r1 = r1.i(r2, r3, r4, r6)
            r9 = r9 | r1
            goto L_0x006e
        L_0x008f:
            r16 = r9
            r9 = r8
            goto L_0x0096
        L_0x0093:
            r9 = r1
            r16 = r15
        L_0x0096:
            androidx.constraintlayout.core.motion.utils.CurveFit[] r1 = r0.k
            r10 = 1
            if (r1 == 0) goto L_0x01ef
            r1 = r1[r15]
            double r7 = (double) r14
            double[] r2 = r0.s
            r1.d(r7, r2)
            androidx.constraintlayout.core.motion.utils.CurveFit[] r1 = r0.k
            r1 = r1[r15]
            double[] r2 = r0.t
            r1.g(r7, r2)
            androidx.constraintlayout.core.motion.utils.CurveFit r1 = r0.l
            if (r1 == 0) goto L_0x00bf
            double[] r2 = r0.s
            int r3 = r2.length
            if (r3 <= 0) goto L_0x00bf
            r1.d(r7, r2)
            androidx.constraintlayout.core.motion.utils.CurveFit r1 = r0.l
            double[] r2 = r0.t
            r1.g(r7, r2)
        L_0x00bf:
            boolean r1 = r0.L
            if (r1 != 0) goto L_0x00df
            androidx.constraintlayout.motion.widget.MotionPaths r1 = r0.g
            int[] r4 = r0.r
            double[] r5 = r0.s
            double[] r6 = r0.t
            r17 = 0
            boolean r3 = r0.d
            r2 = r14
            r18 = r3
            r3 = r21
            r12 = r7
            r7 = r17
            r8 = r18
            r1.t(r2, r3, r4, r5, r6, r7, r8)
            r0.d = r15
            goto L_0x00e0
        L_0x00df:
            r12 = r7
        L_0x00e0:
            int r1 = r0.G
            int r2 = androidx.constraintlayout.motion.widget.Key.f
            if (r1 == r2) goto L_0x0142
            android.view.View r1 = r0.H
            if (r1 != 0) goto L_0x00f8
            android.view.ViewParent r1 = r21.getParent()
            android.view.View r1 = (android.view.View) r1
            int r2 = r0.G
            android.view.View r1 = r1.findViewById(r2)
            r0.H = r1
        L_0x00f8:
            android.view.View r1 = r0.H
            if (r1 == 0) goto L_0x0142
            int r1 = r1.getTop()
            android.view.View r2 = r0.H
            int r2 = r2.getBottom()
            int r1 = r1 + r2
            float r1 = (float) r1
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            android.view.View r3 = r0.H
            int r3 = r3.getLeft()
            android.view.View r4 = r0.H
            int r4 = r4.getRight()
            int r3 = r3 + r4
            float r3 = (float) r3
            float r3 = r3 / r2
            int r2 = r21.getRight()
            int r4 = r21.getLeft()
            int r2 = r2 - r4
            if (r2 <= 0) goto L_0x0142
            int r2 = r21.getBottom()
            int r4 = r21.getTop()
            int r2 = r2 - r4
            if (r2 <= 0) goto L_0x0142
            int r2 = r21.getLeft()
            float r2 = (float) r2
            float r3 = r3 - r2
            int r2 = r21.getTop()
            float r2 = (float) r2
            float r1 = r1 - r2
            r11.setPivotX(r3)
            r11.setPivotY(r1)
        L_0x0142:
            java.util.HashMap r1 = r0.C
            if (r1 == 0) goto L_0x0170
            java.util.Collection r1 = r1.values()
            java.util.Iterator r8 = r1.iterator()
        L_0x014e:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0170
            java.lang.Object r1 = r8.next()
            androidx.constraintlayout.core.motion.utils.SplineSet r1 = (androidx.constraintlayout.core.motion.utils.SplineSet) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.utils.ViewSpline.PathRotate
            if (r2 == 0) goto L_0x014e
            double[] r2 = r0.t
            int r3 = r2.length
            if (r3 <= r10) goto L_0x014e
            androidx.constraintlayout.motion.utils.ViewSpline$PathRotate r1 = (androidx.constraintlayout.motion.utils.ViewSpline.PathRotate) r1
            r4 = r2[r15]
            r6 = r2[r10]
            r2 = r21
            r3 = r14
            r1.i(r2, r3, r4, r6)
            goto L_0x014e
        L_0x0170:
            if (r9 == 0) goto L_0x018b
            double[] r1 = r0.t
            r7 = r1[r15]
            r17 = r1[r10]
            r1 = r9
            r2 = r21
            r3 = r25
            r4 = r14
            r5 = r23
            r19 = r10
            r9 = r17
            boolean r1 = r1.j(r2, r3, r4, r5, r7, r9)
            r16 = r16 | r1
            goto L_0x018d
        L_0x018b:
            r19 = r10
        L_0x018d:
            r10 = r19
        L_0x018f:
            androidx.constraintlayout.core.motion.utils.CurveFit[] r1 = r0.k
            int r2 = r1.length
            if (r10 >= r2) goto L_0x01b3
            r1 = r1[r10]
            float[] r2 = r0.x
            r1.e(r12, r2)
            androidx.constraintlayout.motion.widget.MotionPaths r1 = r0.g
            java.util.LinkedHashMap r1 = r1.o
            java.lang.String[] r2 = r0.u
            int r3 = r10 + -1
            r2 = r2[r3]
            java.lang.Object r1 = r1.get(r2)
            androidx.constraintlayout.widget.ConstraintAttribute r1 = (androidx.constraintlayout.widget.ConstraintAttribute) r1
            float[] r2 = r0.x
            androidx.constraintlayout.motion.utils.CustomSupport.b(r1, r11, r2)
            int r10 = r10 + 1
            goto L_0x018f
        L_0x01b3:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r1 = r0.i
            int r2 = r1.b
            if (r2 != 0) goto L_0x01dd
            r2 = 0
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x01c4
            int r1 = r1.c
            r11.setVisibility(r1)
            goto L_0x01dd
        L_0x01c4:
            r2 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x01d2
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r1 = r0.j
            int r1 = r1.c
            r11.setVisibility(r1)
            goto L_0x01dd
        L_0x01d2:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r2 = r0.j
            int r2 = r2.c
            int r1 = r1.c
            if (r2 == r1) goto L_0x01dd
            r11.setVisibility(r15)
        L_0x01dd:
            androidx.constraintlayout.motion.widget.KeyTrigger[] r1 = r0.E
            if (r1 == 0) goto L_0x023f
            r1 = r15
        L_0x01e2:
            androidx.constraintlayout.motion.widget.KeyTrigger[] r2 = r0.E
            int r3 = r2.length
            if (r1 >= r3) goto L_0x023f
            r2 = r2[r1]
            r2.y(r14, r11)
            int r1 = r1 + 1
            goto L_0x01e2
        L_0x01ef:
            r19 = r10
            androidx.constraintlayout.motion.widget.MotionPaths r1 = r0.g
            float r2 = r1.e
            androidx.constraintlayout.motion.widget.MotionPaths r3 = r0.h
            float r4 = r3.e
            float r4 = r4 - r2
            float r4 = r4 * r14
            float r2 = r2 + r4
            float r4 = r1.f
            float r5 = r3.f
            float r5 = r5 - r4
            float r5 = r5 * r14
            float r4 = r4 + r5
            float r5 = r1.g
            float r6 = r3.g
            float r7 = r6 - r5
            float r7 = r7 * r14
            float r7 = r7 + r5
            float r1 = r1.h
            float r3 = r3.h
            float r8 = r3 - r1
            float r8 = r8 * r14
            float r8 = r8 + r1
            r9 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r9
            int r10 = (int) r2
            float r4 = r4 + r9
            int r9 = (int) r4
            float r2 = r2 + r7
            int r2 = (int) r2
            float r4 = r4 + r8
            int r4 = (int) r4
            int r7 = r2 - r10
            int r8 = r4 - r9
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x022d
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x022d
            boolean r1 = r0.d
            if (r1 == 0) goto L_0x023c
        L_0x022d:
            r1 = 1073741824(0x40000000, float:2.0)
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r1)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r1)
            r11.measure(r3, r1)
            r0.d = r15
        L_0x023c:
            r11.layout(r10, r9, r2, r4)
        L_0x023f:
            java.util.HashMap r1 = r0.D
            if (r1 == 0) goto L_0x026e
            java.util.Collection r1 = r1.values()
            java.util.Iterator r8 = r1.iterator()
        L_0x024b:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x026e
            java.lang.Object r1 = r8.next()
            androidx.constraintlayout.motion.utils.ViewOscillator r1 = (androidx.constraintlayout.motion.utils.ViewOscillator) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.utils.ViewOscillator.PathRotateSet
            if (r2 == 0) goto L_0x026a
            androidx.constraintlayout.motion.utils.ViewOscillator$PathRotateSet r1 = (androidx.constraintlayout.motion.utils.ViewOscillator.PathRotateSet) r1
            double[] r2 = r0.t
            r4 = r2[r15]
            r6 = r2[r19]
            r2 = r21
            r3 = r14
            r1.k(r2, r3, r4, r6)
            goto L_0x024b
        L_0x026a:
            r1.j(r11, r14)
            goto L_0x024b
        L_0x026e:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionController.x(android.view.View, float, long, androidx.constraintlayout.core.motion.utils.KeyCache):boolean");
    }

    public final void y(MotionPaths motionPaths) {
        motionPaths.r((float) ((int) this.b.getX()), (float) ((int) this.b.getY()), (float) this.b.getWidth(), (float) this.b.getHeight());
    }

    public void z() {
        this.d = true;
    }
}
