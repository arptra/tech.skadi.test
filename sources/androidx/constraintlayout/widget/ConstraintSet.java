package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.asm.Opcodes;
import com.meizu.common.widget.MzContactsContract;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.upuphone.runasone.uupcast.CastEventCode;
import com.upuphone.runasone.uupcast.VirtualDeviceEventCode;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintSet {
    public static final int[] h = {0, 4, 8};
    public static SparseIntArray i = new SparseIntArray();
    public static SparseIntArray j = new SparseIntArray();

    /* renamed from: a  reason: collision with root package name */
    public boolean f609a;
    public String b;
    public String c = "";
    public int d = 0;
    public HashMap e = new HashMap();
    public boolean f = true;
    public HashMap g = new HashMap();

    public static class Constraint {

        /* renamed from: a  reason: collision with root package name */
        public int f610a;
        public String b;
        public final PropertySet c = new PropertySet();
        public final Motion d = new Motion();
        public final Layout e = new Layout();
        public final Transform f = new Transform();
        public HashMap g = new HashMap();
        public Delta h;

        public static class Delta {

            /* renamed from: a  reason: collision with root package name */
            public int[] f611a = new int[10];
            public int[] b = new int[10];
            public int c = 0;
            public int[] d = new int[10];
            public float[] e = new float[10];
            public int f = 0;
            public int[] g = new int[5];
            public String[] h = new String[5];
            public int i = 0;
            public int[] j = new int[4];
            public boolean[] k = new boolean[4];
            public int l = 0;

            public void a(int i2, float f2) {
                int i3 = this.f;
                int[] iArr = this.d;
                if (i3 >= iArr.length) {
                    this.d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.e;
                    this.e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.d;
                int i4 = this.f;
                iArr2[i4] = i2;
                float[] fArr2 = this.e;
                this.f = i4 + 1;
                fArr2[i4] = f2;
            }

            public void b(int i2, int i3) {
                int i4 = this.c;
                int[] iArr = this.f611a;
                if (i4 >= iArr.length) {
                    this.f611a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.b;
                    this.b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f611a;
                int i5 = this.c;
                iArr3[i5] = i2;
                int[] iArr4 = this.b;
                this.c = i5 + 1;
                iArr4[i5] = i3;
            }

            public void c(int i2, String str) {
                int i3 = this.i;
                int[] iArr = this.g;
                if (i3 >= iArr.length) {
                    this.g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.h;
                    this.h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.g;
                int i4 = this.i;
                iArr2[i4] = i2;
                String[] strArr2 = this.h;
                this.i = i4 + 1;
                strArr2[i4] = str;
            }

            public void d(int i2, boolean z) {
                int i3 = this.l;
                int[] iArr = this.j;
                if (i3 >= iArr.length) {
                    this.j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.k;
                    this.k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.j;
                int i4 = this.l;
                iArr2[i4] = i2;
                boolean[] zArr2 = this.k;
                this.l = i4 + 1;
                zArr2[i4] = z;
            }

            public void e(Constraint constraint) {
                for (int i2 = 0; i2 < this.c; i2++) {
                    ConstraintSet.O(constraint, this.f611a[i2], this.b[i2]);
                }
                for (int i3 = 0; i3 < this.f; i3++) {
                    ConstraintSet.N(constraint, this.d[i3], this.e[i3]);
                }
                for (int i4 = 0; i4 < this.i; i4++) {
                    ConstraintSet.P(constraint, this.g[i4], this.h[i4]);
                }
                for (int i5 = 0; i5 < this.l; i5++) {
                    ConstraintSet.Q(constraint, this.j[i5], this.k[i5]);
                }
            }
        }

        public void d(Constraint constraint) {
            Delta delta = this.h;
            if (delta != null) {
                delta.e(constraint);
            }
        }

        public void e(ConstraintLayout.LayoutParams layoutParams) {
            Layout layout = this.e;
            layoutParams.e = layout.j;
            layoutParams.f = layout.k;
            layoutParams.g = layout.l;
            layoutParams.h = layout.m;
            layoutParams.i = layout.n;
            layoutParams.j = layout.o;
            layoutParams.k = layout.p;
            layoutParams.l = layout.q;
            layoutParams.m = layout.r;
            layoutParams.n = layout.s;
            layoutParams.o = layout.t;
            layoutParams.s = layout.u;
            layoutParams.t = layout.v;
            layoutParams.u = layout.w;
            layoutParams.v = layout.x;
            layoutParams.leftMargin = layout.H;
            layoutParams.rightMargin = layout.I;
            layoutParams.topMargin = layout.J;
            layoutParams.bottomMargin = layout.K;
            layoutParams.A = layout.T;
            layoutParams.B = layout.S;
            layoutParams.x = layout.P;
            layoutParams.z = layout.R;
            layoutParams.G = layout.y;
            layoutParams.H = layout.z;
            layoutParams.p = layout.B;
            layoutParams.q = layout.C;
            layoutParams.r = layout.D;
            layoutParams.I = layout.A;
            layoutParams.X = layout.E;
            layoutParams.Y = layout.F;
            layoutParams.M = layout.V;
            layoutParams.L = layout.W;
            layoutParams.O = layout.Y;
            layoutParams.N = layout.X;
            layoutParams.a0 = layout.n0;
            layoutParams.b0 = layout.o0;
            layoutParams.P = layout.Z;
            layoutParams.Q = layout.a0;
            layoutParams.T = layout.b0;
            layoutParams.U = layout.c0;
            layoutParams.R = layout.d0;
            layoutParams.S = layout.e0;
            layoutParams.V = layout.f0;
            layoutParams.W = layout.g0;
            layoutParams.Z = layout.G;
            layoutParams.c = layout.h;
            layoutParams.f603a = layout.f;
            layoutParams.b = layout.g;
            layoutParams.width = layout.d;
            layoutParams.height = layout.e;
            String str = layout.m0;
            if (str != null) {
                layoutParams.c0 = str;
            }
            layoutParams.d0 = layout.q0;
            layoutParams.setMarginStart(layout.M);
            layoutParams.setMarginEnd(this.e.L);
            layoutParams.c();
        }

        /* renamed from: f */
        public Constraint clone() {
            Constraint constraint = new Constraint();
            constraint.e.a(this.e);
            constraint.d.a(this.d);
            constraint.c.a(this.c);
            constraint.f.a(this.f);
            constraint.f610a = this.f610a;
            constraint.h = this.h;
            return constraint;
        }

        public final void g(int i, ConstraintLayout.LayoutParams layoutParams) {
            this.f610a = i;
            Layout layout = this.e;
            layout.j = layoutParams.e;
            layout.k = layoutParams.f;
            layout.l = layoutParams.g;
            layout.m = layoutParams.h;
            layout.n = layoutParams.i;
            layout.o = layoutParams.j;
            layout.p = layoutParams.k;
            layout.q = layoutParams.l;
            layout.r = layoutParams.m;
            layout.s = layoutParams.n;
            layout.t = layoutParams.o;
            layout.u = layoutParams.s;
            layout.v = layoutParams.t;
            layout.w = layoutParams.u;
            layout.x = layoutParams.v;
            layout.y = layoutParams.G;
            layout.z = layoutParams.H;
            layout.A = layoutParams.I;
            layout.B = layoutParams.p;
            layout.C = layoutParams.q;
            layout.D = layoutParams.r;
            layout.E = layoutParams.X;
            layout.F = layoutParams.Y;
            layout.G = layoutParams.Z;
            layout.h = layoutParams.c;
            layout.f = layoutParams.f603a;
            layout.g = layoutParams.b;
            layout.d = layoutParams.width;
            layout.e = layoutParams.height;
            layout.H = layoutParams.leftMargin;
            layout.I = layoutParams.rightMargin;
            layout.J = layoutParams.topMargin;
            layout.K = layoutParams.bottomMargin;
            layout.N = layoutParams.D;
            layout.V = layoutParams.M;
            layout.W = layoutParams.L;
            layout.Y = layoutParams.O;
            layout.X = layoutParams.N;
            layout.n0 = layoutParams.a0;
            layout.o0 = layoutParams.b0;
            layout.Z = layoutParams.P;
            layout.a0 = layoutParams.Q;
            layout.b0 = layoutParams.T;
            layout.c0 = layoutParams.U;
            layout.d0 = layoutParams.R;
            layout.e0 = layoutParams.S;
            layout.f0 = layoutParams.V;
            layout.g0 = layoutParams.W;
            layout.m0 = layoutParams.c0;
            layout.P = layoutParams.x;
            layout.R = layoutParams.z;
            layout.O = layoutParams.w;
            layout.Q = layoutParams.y;
            layout.T = layoutParams.A;
            layout.S = layoutParams.B;
            layout.U = layoutParams.C;
            layout.q0 = layoutParams.d0;
            layout.L = layoutParams.getMarginEnd();
            this.e.M = layoutParams.getMarginStart();
        }

        public final void h(int i, Constraints.LayoutParams layoutParams) {
            g(i, layoutParams);
            this.c.d = layoutParams.x0;
            Transform transform = this.f;
            transform.b = layoutParams.A0;
            transform.c = layoutParams.B0;
            transform.d = layoutParams.C0;
            transform.e = layoutParams.D0;
            transform.f = layoutParams.E0;
            transform.g = layoutParams.F0;
            transform.h = layoutParams.G0;
            transform.j = layoutParams.H0;
            transform.k = layoutParams.I0;
            transform.l = layoutParams.J0;
            transform.n = layoutParams.z0;
            transform.m = layoutParams.y0;
        }

        public final void i(ConstraintHelper constraintHelper, int i, Constraints.LayoutParams layoutParams) {
            h(i, layoutParams);
            if (constraintHelper instanceof Barrier) {
                Layout layout = this.e;
                layout.j0 = 1;
                Barrier barrier = (Barrier) constraintHelper;
                layout.h0 = barrier.getType();
                this.e.k0 = barrier.getReferencedIds();
                this.e.i0 = barrier.getMargin();
            }
        }
    }

    public static class Layout {
        public static SparseIntArray r0;
        public String A = null;
        public int B = -1;
        public int C = 0;
        public float D = 0.0f;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = 0;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public int T = Integer.MIN_VALUE;
        public int U = Integer.MIN_VALUE;
        public float V = -1.0f;
        public float W = -1.0f;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;

        /* renamed from: a  reason: collision with root package name */
        public boolean f612a = false;
        public int a0 = 0;
        public boolean b = false;
        public int b0 = 0;
        public boolean c = false;
        public int c0 = 0;
        public int d;
        public int d0 = 0;
        public int e;
        public int e0 = 0;
        public int f = -1;
        public float f0 = 1.0f;
        public int g = -1;
        public float g0 = 1.0f;
        public float h = -1.0f;
        public int h0 = -1;
        public boolean i = true;
        public int i0 = 0;
        public int j = -1;
        public int j0 = -1;
        public int k = -1;
        public int[] k0;
        public int l = -1;
        public String l0;
        public int m = -1;
        public String m0;
        public int n = -1;
        public boolean n0 = false;
        public int o = -1;
        public boolean o0 = false;
        public int p = -1;
        public boolean p0 = true;
        public int q = -1;
        public int q0 = 0;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = -1;
        public int v = -1;
        public int w = -1;
        public int x = -1;
        public float y = 0.5f;
        public float z = 0.5f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            r0 = sparseIntArray;
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            r0.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            r0.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            r0.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            r0.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            r0.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            r0.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            r0.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            r0.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            r0.append(R.styleable.Layout_layout_editor_absoluteX, 6);
            r0.append(R.styleable.Layout_layout_editor_absoluteY, 7);
            r0.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
            r0.append(R.styleable.Layout_layout_constraintGuide_end, 18);
            r0.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
            r0.append(R.styleable.Layout_guidelineUseRtl, 90);
            r0.append(R.styleable.Layout_android_orientation, 26);
            r0.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            r0.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            r0.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            r0.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            r0.append(R.styleable.Layout_layout_goneMarginLeft, 13);
            r0.append(R.styleable.Layout_layout_goneMarginTop, 16);
            r0.append(R.styleable.Layout_layout_goneMarginRight, 14);
            r0.append(R.styleable.Layout_layout_goneMarginBottom, 11);
            r0.append(R.styleable.Layout_layout_goneMarginStart, 15);
            r0.append(R.styleable.Layout_layout_goneMarginEnd, 12);
            r0.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
            r0.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            r0.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            r0.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            r0.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            r0.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
            r0.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
            r0.append(R.styleable.Layout_layout_constraintLeft_creator, 91);
            r0.append(R.styleable.Layout_layout_constraintTop_creator, 91);
            r0.append(R.styleable.Layout_layout_constraintRight_creator, 91);
            r0.append(R.styleable.Layout_layout_constraintBottom_creator, 91);
            r0.append(R.styleable.Layout_layout_constraintBaseline_creator, 91);
            r0.append(R.styleable.Layout_android_layout_marginLeft, 23);
            r0.append(R.styleable.Layout_android_layout_marginRight, 27);
            r0.append(R.styleable.Layout_android_layout_marginStart, 30);
            r0.append(R.styleable.Layout_android_layout_marginEnd, 8);
            r0.append(R.styleable.Layout_android_layout_marginTop, 33);
            r0.append(R.styleable.Layout_android_layout_marginBottom, 2);
            r0.append(R.styleable.Layout_android_layout_width, 22);
            r0.append(R.styleable.Layout_android_layout_height, 21);
            r0.append(R.styleable.Layout_layout_constraintWidth, 41);
            r0.append(R.styleable.Layout_layout_constraintHeight, 42);
            r0.append(R.styleable.Layout_layout_constrainedWidth, 41);
            r0.append(R.styleable.Layout_layout_constrainedHeight, 42);
            r0.append(R.styleable.Layout_layout_wrapBehaviorInParent, 76);
            r0.append(R.styleable.Layout_layout_constraintCircle, 61);
            r0.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
            r0.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
            r0.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
            r0.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
            r0.append(R.styleable.Layout_chainUseRtl, 71);
            r0.append(R.styleable.Layout_barrierDirection, 72);
            r0.append(R.styleable.Layout_barrierMargin, 73);
            r0.append(R.styleable.Layout_constraint_referenced_ids, 74);
            r0.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        public void a(Layout layout) {
            this.f612a = layout.f612a;
            this.d = layout.d;
            this.b = layout.b;
            this.e = layout.e;
            this.f = layout.f;
            this.g = layout.g;
            this.h = layout.h;
            this.i = layout.i;
            this.j = layout.j;
            this.k = layout.k;
            this.l = layout.l;
            this.m = layout.m;
            this.n = layout.n;
            this.o = layout.o;
            this.p = layout.p;
            this.q = layout.q;
            this.r = layout.r;
            this.s = layout.s;
            this.t = layout.t;
            this.u = layout.u;
            this.v = layout.v;
            this.w = layout.w;
            this.x = layout.x;
            this.y = layout.y;
            this.z = layout.z;
            this.A = layout.A;
            this.B = layout.B;
            this.C = layout.C;
            this.D = layout.D;
            this.E = layout.E;
            this.F = layout.F;
            this.G = layout.G;
            this.H = layout.H;
            this.I = layout.I;
            this.J = layout.J;
            this.K = layout.K;
            this.L = layout.L;
            this.M = layout.M;
            this.N = layout.N;
            this.O = layout.O;
            this.P = layout.P;
            this.Q = layout.Q;
            this.R = layout.R;
            this.S = layout.S;
            this.T = layout.T;
            this.U = layout.U;
            this.V = layout.V;
            this.W = layout.W;
            this.X = layout.X;
            this.Y = layout.Y;
            this.Z = layout.Z;
            this.a0 = layout.a0;
            this.b0 = layout.b0;
            this.c0 = layout.c0;
            this.d0 = layout.d0;
            this.e0 = layout.e0;
            this.f0 = layout.f0;
            this.g0 = layout.g0;
            this.h0 = layout.h0;
            this.i0 = layout.i0;
            this.j0 = layout.j0;
            this.m0 = layout.m0;
            int[] iArr = layout.k0;
            if (iArr == null || layout.l0 != null) {
                this.k0 = null;
            } else {
                this.k0 = Arrays.copyOf(iArr, iArr.length);
            }
            this.l0 = layout.l0;
            this.n0 = layout.n0;
            this.o0 = layout.o0;
            this.p0 = layout.p0;
            this.q0 = layout.q0;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Layout);
            this.b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                int i3 = r0.get(index);
                switch (i3) {
                    case 1:
                        this.r = ConstraintSet.F(obtainStyledAttributes, index, this.r);
                        break;
                    case 2:
                        this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        break;
                    case 3:
                        this.q = ConstraintSet.F(obtainStyledAttributes, index, this.q);
                        break;
                    case 4:
                        this.p = ConstraintSet.F(obtainStyledAttributes, index, this.p);
                        break;
                    case 5:
                        this.A = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.E = obtainStyledAttributes.getDimensionPixelOffset(index, this.E);
                        break;
                    case 7:
                        this.F = obtainStyledAttributes.getDimensionPixelOffset(index, this.F);
                        break;
                    case 8:
                        this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                        break;
                    case 9:
                        this.x = ConstraintSet.F(obtainStyledAttributes, index, this.x);
                        break;
                    case 10:
                        this.w = ConstraintSet.F(obtainStyledAttributes, index, this.w);
                        break;
                    case 11:
                        this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    case 12:
                        this.S = obtainStyledAttributes.getDimensionPixelSize(index, this.S);
                        break;
                    case 13:
                        this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case 14:
                        this.Q = obtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case 15:
                        this.T = obtainStyledAttributes.getDimensionPixelSize(index, this.T);
                        break;
                    case 16:
                        this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case 17:
                        this.f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f);
                        break;
                    case 18:
                        this.g = obtainStyledAttributes.getDimensionPixelOffset(index, this.g);
                        break;
                    case 19:
                        this.h = obtainStyledAttributes.getFloat(index, this.h);
                        break;
                    case 20:
                        this.y = obtainStyledAttributes.getFloat(index, this.y);
                        break;
                    case 21:
                        this.e = obtainStyledAttributes.getLayoutDimension(index, this.e);
                        break;
                    case 22:
                        this.d = obtainStyledAttributes.getLayoutDimension(index, this.d);
                        break;
                    case 23:
                        this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 24:
                        this.j = ConstraintSet.F(obtainStyledAttributes, index, this.j);
                        break;
                    case 25:
                        this.k = ConstraintSet.F(obtainStyledAttributes, index, this.k);
                        break;
                    case 26:
                        this.G = obtainStyledAttributes.getInt(index, this.G);
                        break;
                    case 27:
                        this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 28:
                        this.l = ConstraintSet.F(obtainStyledAttributes, index, this.l);
                        break;
                    case 29:
                        this.m = ConstraintSet.F(obtainStyledAttributes, index, this.m);
                        break;
                    case 30:
                        this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        break;
                    case 31:
                        this.u = ConstraintSet.F(obtainStyledAttributes, index, this.u);
                        break;
                    case 32:
                        this.v = ConstraintSet.F(obtainStyledAttributes, index, this.v);
                        break;
                    case 33:
                        this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case 34:
                        this.o = ConstraintSet.F(obtainStyledAttributes, index, this.o);
                        break;
                    case 35:
                        this.n = ConstraintSet.F(obtainStyledAttributes, index, this.n);
                        break;
                    case 36:
                        this.z = obtainStyledAttributes.getFloat(index, this.z);
                        break;
                    case 37:
                        this.W = obtainStyledAttributes.getFloat(index, this.W);
                        break;
                    case 38:
                        this.V = obtainStyledAttributes.getFloat(index, this.V);
                        break;
                    case 39:
                        this.X = obtainStyledAttributes.getInt(index, this.X);
                        break;
                    case 40:
                        this.Y = obtainStyledAttributes.getInt(index, this.Y);
                        break;
                    case 41:
                        ConstraintSet.G(this, obtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        ConstraintSet.G(this, obtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i3) {
                            case 61:
                                this.B = ConstraintSet.F(obtainStyledAttributes, index, this.B);
                                break;
                            case 62:
                                this.C = obtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            case 63:
                                this.D = obtainStyledAttributes.getFloat(index, this.D);
                                break;
                            default:
                                switch (i3) {
                                    case 69:
                                        this.f0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.g0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        break;
                                    case 72:
                                        this.h0 = obtainStyledAttributes.getInt(index, this.h0);
                                        break;
                                    case 73:
                                        this.i0 = obtainStyledAttributes.getDimensionPixelSize(index, this.i0);
                                        break;
                                    case 74:
                                        this.l0 = obtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.p0 = obtainStyledAttributes.getBoolean(index, this.p0);
                                        break;
                                    case 76:
                                        this.q0 = obtainStyledAttributes.getInt(index, this.q0);
                                        break;
                                    case CastEventCode.SINK_VIDEO_SIZE_DETERMINED /*77*/:
                                        this.s = ConstraintSet.F(obtainStyledAttributes, index, this.s);
                                        break;
                                    case CastEventCode.SINK_AUDIO_FOCUS_REQUEST_FAILED /*78*/:
                                        this.t = ConstraintSet.F(obtainStyledAttributes, index, this.t);
                                        break;
                                    case 79:
                                        this.U = obtainStyledAttributes.getDimensionPixelSize(index, this.U);
                                        break;
                                    case 80:
                                        this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                                        break;
                                    case CastEventCode.SINK_AUDIO_FOCUS_LOST /*81*/:
                                        this.Z = obtainStyledAttributes.getInt(index, this.Z);
                                        break;
                                    case 82:
                                        this.a0 = obtainStyledAttributes.getInt(index, this.a0);
                                        break;
                                    case CastEventCode.SOURCE_PAUSE_VIRTUAL_DISPLAY_SUCCESS /*83*/:
                                        this.c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.c0);
                                        break;
                                    case CastEventCode.SOURCE_RESUME_VIRTUAL_DISPLAY_SUCCESS /*84*/:
                                        this.b0 = obtainStyledAttributes.getDimensionPixelSize(index, this.b0);
                                        break;
                                    case CastEventCode.SINK_VIDEO_SURFACE_CONFIGURABLE /*85*/:
                                        this.e0 = obtainStyledAttributes.getDimensionPixelSize(index, this.e0);
                                        break;
                                    case 86:
                                        this.d0 = obtainStyledAttributes.getDimensionPixelSize(index, this.d0);
                                        break;
                                    case Opcodes.POP /*87*/:
                                        this.n0 = obtainStyledAttributes.getBoolean(index, this.n0);
                                        break;
                                    case 88:
                                        this.o0 = obtainStyledAttributes.getBoolean(index, this.o0);
                                        break;
                                    case Opcodes.DUP /*89*/:
                                        this.m0 = obtainStyledAttributes.getString(index);
                                        break;
                                    case ORIENTATION_90_VALUE:
                                        this.i = obtainStyledAttributes.getBoolean(index, this.i);
                                        break;
                                    case 91:
                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + r0.get(index));
                                        break;
                                    default:
                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + r0.get(index));
                                        break;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class Motion {
        public static SparseIntArray o;

        /* renamed from: a  reason: collision with root package name */
        public boolean f613a = false;
        public int b = -1;
        public int c = 0;
        public String d = null;
        public int e = -1;
        public int f = 0;
        public float g = Float.NaN;
        public int h = -1;
        public float i = Float.NaN;
        public float j = Float.NaN;
        public int k = -1;
        public String l = null;
        public int m = -3;
        public int n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            o = sparseIntArray;
            sparseIntArray.append(R.styleable.Motion_motionPathRotate, 1);
            o.append(R.styleable.Motion_pathMotionArc, 2);
            o.append(R.styleable.Motion_transitionEasing, 3);
            o.append(R.styleable.Motion_drawPath, 4);
            o.append(R.styleable.Motion_animateRelativeTo, 5);
            o.append(R.styleable.Motion_animateCircleAngleTo, 6);
            o.append(R.styleable.Motion_motionStagger, 7);
            o.append(R.styleable.Motion_quantizeMotionSteps, 8);
            o.append(R.styleable.Motion_quantizeMotionPhase, 9);
            o.append(R.styleable.Motion_quantizeMotionInterpolator, 10);
        }

        public void a(Motion motion) {
            this.f613a = motion.f613a;
            this.b = motion.b;
            this.d = motion.d;
            this.e = motion.e;
            this.f = motion.f;
            this.i = motion.i;
            this.g = motion.g;
            this.h = motion.h;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Motion);
            this.f613a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (o.get(index)) {
                    case 1:
                        this.i = obtainStyledAttributes.getFloat(index, this.i);
                        break;
                    case 2:
                        this.e = obtainStyledAttributes.getInt(index, this.e);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type != 3) {
                            this.d = Easing.c[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        } else {
                            this.d = obtainStyledAttributes.getString(index);
                            break;
                        }
                    case 4:
                        this.f = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.b = ConstraintSet.F(obtainStyledAttributes, index, this.b);
                        break;
                    case 6:
                        this.c = obtainStyledAttributes.getInteger(index, this.c);
                        break;
                    case 7:
                        this.g = obtainStyledAttributes.getFloat(index, this.g);
                        break;
                    case 8:
                        this.k = obtainStyledAttributes.getInteger(index, this.k);
                        break;
                    case 9:
                        this.j = obtainStyledAttributes.getFloat(index, this.j);
                        break;
                    case 10:
                        int i3 = obtainStyledAttributes.peekValue(index).type;
                        if (i3 != 1) {
                            if (i3 != 3) {
                                this.m = obtainStyledAttributes.getInteger(index, this.n);
                                break;
                            } else {
                                String string = obtainStyledAttributes.getString(index);
                                this.l = string;
                                if (string.indexOf("/") <= 0) {
                                    this.m = -1;
                                    break;
                                } else {
                                    this.n = obtainStyledAttributes.getResourceId(index, -1);
                                    this.m = -2;
                                    break;
                                }
                            }
                        } else {
                            int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            this.n = resourceId;
                            if (resourceId == -1) {
                                break;
                            } else {
                                this.m = -2;
                                break;
                            }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class PropertySet {

        /* renamed from: a  reason: collision with root package name */
        public boolean f614a = false;
        public int b = 0;
        public int c = 0;
        public float d = 1.0f;
        public float e = Float.NaN;

        public void a(PropertySet propertySet) {
            this.f614a = propertySet.f614a;
            this.b = propertySet.b;
            this.d = propertySet.d;
            this.e = propertySet.e;
            this.c = propertySet.c;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PropertySet);
            this.f614a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.PropertySet_android_alpha) {
                    this.d = obtainStyledAttributes.getFloat(index, this.d);
                } else if (index == R.styleable.PropertySet_android_visibility) {
                    this.b = obtainStyledAttributes.getInt(index, this.b);
                    this.b = ConstraintSet.h[this.b];
                } else if (index == R.styleable.PropertySet_visibilityMode) {
                    this.c = obtainStyledAttributes.getInt(index, this.c);
                } else if (index == R.styleable.PropertySet_motionProgress) {
                    this.e = obtainStyledAttributes.getFloat(index, this.e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class Transform {
        public static SparseIntArray o;

        /* renamed from: a  reason: collision with root package name */
        public boolean f615a = false;
        public float b = 0.0f;
        public float c = 0.0f;
        public float d = 0.0f;
        public float e = 1.0f;
        public float f = 1.0f;
        public float g = Float.NaN;
        public float h = Float.NaN;
        public int i = -1;
        public float j = 0.0f;
        public float k = 0.0f;
        public float l = 0.0f;
        public boolean m = false;
        public float n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            o = sparseIntArray;
            sparseIntArray.append(R.styleable.Transform_android_rotation, 1);
            o.append(R.styleable.Transform_android_rotationX, 2);
            o.append(R.styleable.Transform_android_rotationY, 3);
            o.append(R.styleable.Transform_android_scaleX, 4);
            o.append(R.styleable.Transform_android_scaleY, 5);
            o.append(R.styleable.Transform_android_transformPivotX, 6);
            o.append(R.styleable.Transform_android_transformPivotY, 7);
            o.append(R.styleable.Transform_android_translationX, 8);
            o.append(R.styleable.Transform_android_translationY, 9);
            o.append(R.styleable.Transform_android_translationZ, 10);
            o.append(R.styleable.Transform_android_elevation, 11);
            o.append(R.styleable.Transform_transformPivotTarget, 12);
        }

        public void a(Transform transform) {
            this.f615a = transform.f615a;
            this.b = transform.b;
            this.c = transform.c;
            this.d = transform.d;
            this.e = transform.e;
            this.f = transform.f;
            this.g = transform.g;
            this.h = transform.h;
            this.i = transform.i;
            this.j = transform.j;
            this.k = transform.k;
            this.l = transform.l;
            this.m = transform.m;
            this.n = transform.n;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transform);
            this.f615a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (o.get(index)) {
                    case 1:
                        this.b = obtainStyledAttributes.getFloat(index, this.b);
                        break;
                    case 2:
                        this.c = obtainStyledAttributes.getFloat(index, this.c);
                        break;
                    case 3:
                        this.d = obtainStyledAttributes.getFloat(index, this.d);
                        break;
                    case 4:
                        this.e = obtainStyledAttributes.getFloat(index, this.e);
                        break;
                    case 5:
                        this.f = obtainStyledAttributes.getFloat(index, this.f);
                        break;
                    case 6:
                        this.g = obtainStyledAttributes.getDimension(index, this.g);
                        break;
                    case 7:
                        this.h = obtainStyledAttributes.getDimension(index, this.h);
                        break;
                    case 8:
                        this.j = obtainStyledAttributes.getDimension(index, this.j);
                        break;
                    case 9:
                        this.k = obtainStyledAttributes.getDimension(index, this.k);
                        break;
                    case 10:
                        this.l = obtainStyledAttributes.getDimension(index, this.l);
                        break;
                    case 11:
                        this.m = true;
                        this.n = obtainStyledAttributes.getDimension(index, this.n);
                        break;
                    case 12:
                        this.i = ConstraintSet.F(obtainStyledAttributes, index, this.i);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public class WriteJsonEngine {
    }

    public class WriteXmlEngine {
    }

    static {
        i.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        i.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        i.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        i.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        i.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        i.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        i.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        i.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        i.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        i.append(R.styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        i.append(R.styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        i.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        i.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        i.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        i.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        i.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        i.append(R.styleable.Constraint_guidelineUseRtl, 99);
        i.append(R.styleable.Constraint_android_orientation, 27);
        i.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        i.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        i.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        i.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        i.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        i.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        i.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        i.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        i.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        i.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        i.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        i.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        i.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        i.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        i.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        i.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        i.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        i.append(R.styleable.Constraint_layout_constraintLeft_creator, 87);
        i.append(R.styleable.Constraint_layout_constraintTop_creator, 87);
        i.append(R.styleable.Constraint_layout_constraintRight_creator, 87);
        i.append(R.styleable.Constraint_layout_constraintBottom_creator, 87);
        i.append(R.styleable.Constraint_layout_constraintBaseline_creator, 87);
        i.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        i.append(R.styleable.Constraint_android_layout_marginRight, 28);
        i.append(R.styleable.Constraint_android_layout_marginStart, 31);
        i.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        i.append(R.styleable.Constraint_android_layout_marginTop, 34);
        i.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        i.append(R.styleable.Constraint_android_layout_width, 23);
        i.append(R.styleable.Constraint_android_layout_height, 21);
        i.append(R.styleable.Constraint_layout_constraintWidth, 95);
        i.append(R.styleable.Constraint_layout_constraintHeight, 96);
        i.append(R.styleable.Constraint_android_visibility, 22);
        i.append(R.styleable.Constraint_android_alpha, 43);
        i.append(R.styleable.Constraint_android_elevation, 44);
        i.append(R.styleable.Constraint_android_rotationX, 45);
        i.append(R.styleable.Constraint_android_rotationY, 46);
        i.append(R.styleable.Constraint_android_rotation, 60);
        i.append(R.styleable.Constraint_android_scaleX, 47);
        i.append(R.styleable.Constraint_android_scaleY, 48);
        i.append(R.styleable.Constraint_android_transformPivotX, 49);
        i.append(R.styleable.Constraint_android_transformPivotY, 50);
        i.append(R.styleable.Constraint_android_translationX, 51);
        i.append(R.styleable.Constraint_android_translationY, 52);
        i.append(R.styleable.Constraint_android_translationZ, 53);
        i.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        i.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        i.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
        i.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
        i.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
        i.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
        i.append(R.styleable.Constraint_layout_constraintCircle, 61);
        i.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
        i.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        i.append(R.styleable.Constraint_animateRelativeTo, 64);
        i.append(R.styleable.Constraint_transitionEasing, 65);
        i.append(R.styleable.Constraint_drawPath, 66);
        i.append(R.styleable.Constraint_transitionPathRotate, 67);
        i.append(R.styleable.Constraint_motionStagger, 79);
        i.append(R.styleable.Constraint_android_id, 38);
        i.append(R.styleable.Constraint_motionProgress, 68);
        i.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        i.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        i.append(R.styleable.Constraint_layout_wrapBehaviorInParent, 97);
        i.append(R.styleable.Constraint_chainUseRtl, 71);
        i.append(R.styleable.Constraint_barrierDirection, 72);
        i.append(R.styleable.Constraint_barrierMargin, 73);
        i.append(R.styleable.Constraint_constraint_referenced_ids, 74);
        i.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        i.append(R.styleable.Constraint_pathMotionArc, 76);
        i.append(R.styleable.Constraint_layout_constraintTag, 77);
        i.append(R.styleable.Constraint_visibilityMode, 78);
        i.append(R.styleable.Constraint_layout_constrainedWidth, 80);
        i.append(R.styleable.Constraint_layout_constrainedHeight, 81);
        i.append(R.styleable.Constraint_polarRelativeTo, 82);
        i.append(R.styleable.Constraint_transformPivotTarget, 83);
        i.append(R.styleable.Constraint_quantizeMotionSteps, 84);
        i.append(R.styleable.Constraint_quantizeMotionPhase, 85);
        i.append(R.styleable.Constraint_quantizeMotionInterpolator, 86);
        j.append(R.styleable.ConstraintOverride_layout_editor_absoluteY, 6);
        j.append(R.styleable.ConstraintOverride_layout_editor_absoluteY, 7);
        j.append(R.styleable.ConstraintOverride_android_orientation, 27);
        j.append(R.styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        j.append(R.styleable.ConstraintOverride_layout_goneMarginTop, 16);
        j.append(R.styleable.ConstraintOverride_layout_goneMarginRight, 14);
        j.append(R.styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        j.append(R.styleable.ConstraintOverride_layout_goneMarginStart, 15);
        j.append(R.styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        j.append(R.styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        j.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        j.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        j.append(R.styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        j.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        j.append(R.styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        j.append(R.styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        j.append(R.styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        j.append(R.styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        j.append(R.styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        j.append(R.styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        j.append(R.styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        j.append(R.styleable.ConstraintOverride_android_layout_marginLeft, 24);
        j.append(R.styleable.ConstraintOverride_android_layout_marginRight, 28);
        j.append(R.styleable.ConstraintOverride_android_layout_marginStart, 31);
        j.append(R.styleable.ConstraintOverride_android_layout_marginEnd, 8);
        j.append(R.styleable.ConstraintOverride_android_layout_marginTop, 34);
        j.append(R.styleable.ConstraintOverride_android_layout_marginBottom, 2);
        j.append(R.styleable.ConstraintOverride_android_layout_width, 23);
        j.append(R.styleable.ConstraintOverride_android_layout_height, 21);
        j.append(R.styleable.ConstraintOverride_layout_constraintWidth, 95);
        j.append(R.styleable.ConstraintOverride_layout_constraintHeight, 96);
        j.append(R.styleable.ConstraintOverride_android_visibility, 22);
        j.append(R.styleable.ConstraintOverride_android_alpha, 43);
        j.append(R.styleable.ConstraintOverride_android_elevation, 44);
        j.append(R.styleable.ConstraintOverride_android_rotationX, 45);
        j.append(R.styleable.ConstraintOverride_android_rotationY, 46);
        j.append(R.styleable.ConstraintOverride_android_rotation, 60);
        j.append(R.styleable.ConstraintOverride_android_scaleX, 47);
        j.append(R.styleable.ConstraintOverride_android_scaleY, 48);
        j.append(R.styleable.ConstraintOverride_android_transformPivotX, 49);
        j.append(R.styleable.ConstraintOverride_android_transformPivotY, 50);
        j.append(R.styleable.ConstraintOverride_android_translationX, 51);
        j.append(R.styleable.ConstraintOverride_android_translationY, 52);
        j.append(R.styleable.ConstraintOverride_android_translationZ, 53);
        j.append(R.styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        j.append(R.styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        j.append(R.styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        j.append(R.styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        j.append(R.styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        j.append(R.styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        j.append(R.styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        j.append(R.styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        j.append(R.styleable.ConstraintOverride_animateRelativeTo, 64);
        j.append(R.styleable.ConstraintOverride_transitionEasing, 65);
        j.append(R.styleable.ConstraintOverride_drawPath, 66);
        j.append(R.styleable.ConstraintOverride_transitionPathRotate, 67);
        j.append(R.styleable.ConstraintOverride_motionStagger, 79);
        j.append(R.styleable.ConstraintOverride_android_id, 38);
        j.append(R.styleable.ConstraintOverride_motionTarget, 98);
        j.append(R.styleable.ConstraintOverride_motionProgress, 68);
        j.append(R.styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        j.append(R.styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        j.append(R.styleable.ConstraintOverride_chainUseRtl, 71);
        j.append(R.styleable.ConstraintOverride_barrierDirection, 72);
        j.append(R.styleable.ConstraintOverride_barrierMargin, 73);
        j.append(R.styleable.ConstraintOverride_constraint_referenced_ids, 74);
        j.append(R.styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        j.append(R.styleable.ConstraintOverride_pathMotionArc, 76);
        j.append(R.styleable.ConstraintOverride_layout_constraintTag, 77);
        j.append(R.styleable.ConstraintOverride_visibilityMode, 78);
        j.append(R.styleable.ConstraintOverride_layout_constrainedWidth, 80);
        j.append(R.styleable.ConstraintOverride_layout_constrainedHeight, 81);
        j.append(R.styleable.ConstraintOverride_polarRelativeTo, 82);
        j.append(R.styleable.ConstraintOverride_transformPivotTarget, 83);
        j.append(R.styleable.ConstraintOverride_quantizeMotionSteps, 84);
        j.append(R.styleable.ConstraintOverride_quantizeMotionPhase, 85);
        j.append(R.styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        j.append(R.styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    public static int F(TypedArray typedArray, int i2, int i3) {
        int resourceId = typedArray.getResourceId(i2, i3);
        return resourceId == -1 ? typedArray.getInt(i2, -1) : resourceId;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void G(java.lang.Object r4, android.content.res.TypedArray r5, int r6, int r7) {
        /*
            if (r4 != 0) goto L_0x0003
            return
        L_0x0003:
            android.util.TypedValue r0 = r5.peekValue(r6)
            int r0 = r0.type
            r1 = 3
            if (r0 == r1) goto L_0x0071
            r1 = 5
            r2 = 0
            if (r0 == r1) goto L_0x002a
            int r5 = r5.getInt(r6, r2)
            r6 = -4
            r0 = -2
            if (r5 == r6) goto L_0x0026
            r6 = -3
            if (r5 == r6) goto L_0x0020
            if (r5 == r0) goto L_0x0022
            r6 = -1
            if (r5 == r6) goto L_0x0022
        L_0x0020:
            r5 = r2
            goto L_0x002f
        L_0x0022:
            r3 = r2
            r2 = r5
            r5 = r3
            goto L_0x002f
        L_0x0026:
            r2 = 1
            r5 = r2
            r2 = r0
            goto L_0x002f
        L_0x002a:
            int r5 = r5.getDimensionPixelSize(r6, r2)
            goto L_0x0022
        L_0x002f:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r6 == 0) goto L_0x0041
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r4 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r4
            if (r7 != 0) goto L_0x003c
            r4.width = r2
            r4.a0 = r5
            goto L_0x0070
        L_0x003c:
            r4.height = r2
            r4.b0 = r5
            goto L_0x0070
        L_0x0041:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.ConstraintSet.Layout
            if (r6 == 0) goto L_0x0053
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = (androidx.constraintlayout.widget.ConstraintSet.Layout) r4
            if (r7 != 0) goto L_0x004e
            r4.d = r2
            r4.n0 = r5
            goto L_0x0070
        L_0x004e:
            r4.e = r2
            r4.o0 = r5
            goto L_0x0070
        L_0x0053:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.ConstraintSet.Constraint.Delta
            if (r6 == 0) goto L_0x0070
            androidx.constraintlayout.widget.ConstraintSet$Constraint$Delta r4 = (androidx.constraintlayout.widget.ConstraintSet.Constraint.Delta) r4
            if (r7 != 0) goto L_0x0066
            r6 = 23
            r4.b(r6, r2)
            r6 = 80
            r4.d(r6, r5)
            goto L_0x0070
        L_0x0066:
            r6 = 21
            r4.b(r6, r2)
            r6 = 81
            r4.d(r6, r5)
        L_0x0070:
            return
        L_0x0071:
            java.lang.String r5 = r5.getString(r6)
            H(r4, r5, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.G(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void H(Object obj, String str, int i2) {
        if (str != null) {
            int indexOf = str.indexOf(61);
            int length = str.length();
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                String substring2 = str.substring(indexOf + 1);
                if (substring2.length() > 0) {
                    String trim = substring.trim();
                    String trim2 = substring2.trim();
                    if ("ratio".equalsIgnoreCase(trim)) {
                        if (obj instanceof ConstraintLayout.LayoutParams) {
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) obj;
                            if (i2 == 0) {
                                layoutParams.width = 0;
                            } else {
                                layoutParams.height = 0;
                            }
                            I(layoutParams, trim2);
                        } else if (obj instanceof Layout) {
                            ((Layout) obj).A = trim2;
                        } else if (obj instanceof Constraint.Delta) {
                            ((Constraint.Delta) obj).c(5, trim2);
                        }
                    } else if ("weight".equalsIgnoreCase(trim)) {
                        try {
                            float parseFloat = Float.parseFloat(trim2);
                            if (obj instanceof ConstraintLayout.LayoutParams) {
                                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) obj;
                                if (i2 == 0) {
                                    layoutParams2.width = 0;
                                    layoutParams2.L = parseFloat;
                                    return;
                                }
                                layoutParams2.height = 0;
                                layoutParams2.M = parseFloat;
                            } else if (obj instanceof Layout) {
                                Layout layout = (Layout) obj;
                                if (i2 == 0) {
                                    layout.d = 0;
                                    layout.W = parseFloat;
                                    return;
                                }
                                layout.e = 0;
                                layout.V = parseFloat;
                            } else if (obj instanceof Constraint.Delta) {
                                Constraint.Delta delta = (Constraint.Delta) obj;
                                if (i2 == 0) {
                                    delta.b(23, 0);
                                    delta.a(39, parseFloat);
                                    return;
                                }
                                delta.b(21, 0);
                                delta.a(40, parseFloat);
                            }
                        } catch (NumberFormatException unused) {
                        }
                    } else if ("parent".equalsIgnoreCase(trim)) {
                        float max = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(trim2)));
                        if (obj instanceof ConstraintLayout.LayoutParams) {
                            ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) obj;
                            if (i2 == 0) {
                                layoutParams3.width = 0;
                                layoutParams3.V = max;
                                layoutParams3.P = 2;
                                return;
                            }
                            layoutParams3.height = 0;
                            layoutParams3.W = max;
                            layoutParams3.Q = 2;
                        } else if (obj instanceof Layout) {
                            Layout layout2 = (Layout) obj;
                            if (i2 == 0) {
                                layout2.d = 0;
                                layout2.f0 = max;
                                layout2.Z = 2;
                                return;
                            }
                            layout2.e = 0;
                            layout2.g0 = max;
                            layout2.a0 = 2;
                        } else if (obj instanceof Constraint.Delta) {
                            Constraint.Delta delta2 = (Constraint.Delta) obj;
                            if (i2 == 0) {
                                delta2.b(23, 0);
                                delta2.b(54, 2);
                                return;
                            }
                            delta2.b(21, 0);
                            delta2.b(55, 2);
                        }
                    }
                }
            }
        }
    }

    public static void I(ConstraintLayout.LayoutParams layoutParams, String str) {
        float f2 = Float.NaN;
        int i2 = -1;
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i3 = 0;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (substring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                    i2 = 0;
                } else if (substring.equalsIgnoreCase("H")) {
                    i2 = 1;
                }
                i3 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 < 0 || indexOf2 >= length - 1) {
                String substring2 = str.substring(i3);
                if (substring2.length() > 0) {
                    f2 = Float.parseFloat(substring2);
                }
            } else {
                String substring3 = str.substring(i3, indexOf2);
                String substring4 = str.substring(indexOf2 + 1);
                if (substring3.length() > 0 && substring4.length() > 0) {
                    try {
                        float parseFloat = Float.parseFloat(substring3);
                        float parseFloat2 = Float.parseFloat(substring4);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            f2 = i2 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
        layoutParams.I = str;
        layoutParams.J = f2;
        layoutParams.K = i2;
    }

    public static void K(Context context, Constraint constraint, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        Constraint.Delta delta = new Constraint.Delta();
        constraint.h = delta;
        constraint.d.f613a = false;
        constraint.e.b = false;
        constraint.c.f614a = false;
        constraint.f.f615a = false;
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            switch (j.get(index)) {
                case 2:
                    delta.b(2, typedArray.getDimensionPixelSize(index, constraint.e.K));
                    break;
                case 5:
                    delta.c(5, typedArray.getString(index));
                    break;
                case 6:
                    delta.b(6, typedArray.getDimensionPixelOffset(index, constraint.e.E));
                    break;
                case 7:
                    delta.b(7, typedArray.getDimensionPixelOffset(index, constraint.e.F));
                    break;
                case 8:
                    delta.b(8, typedArray.getDimensionPixelSize(index, constraint.e.L));
                    break;
                case 11:
                    delta.b(11, typedArray.getDimensionPixelSize(index, constraint.e.R));
                    break;
                case 12:
                    delta.b(12, typedArray.getDimensionPixelSize(index, constraint.e.S));
                    break;
                case 13:
                    delta.b(13, typedArray.getDimensionPixelSize(index, constraint.e.O));
                    break;
                case 14:
                    delta.b(14, typedArray.getDimensionPixelSize(index, constraint.e.Q));
                    break;
                case 15:
                    delta.b(15, typedArray.getDimensionPixelSize(index, constraint.e.T));
                    break;
                case 16:
                    delta.b(16, typedArray.getDimensionPixelSize(index, constraint.e.P));
                    break;
                case 17:
                    delta.b(17, typedArray.getDimensionPixelOffset(index, constraint.e.f));
                    break;
                case 18:
                    delta.b(18, typedArray.getDimensionPixelOffset(index, constraint.e.g));
                    break;
                case 19:
                    delta.a(19, typedArray.getFloat(index, constraint.e.h));
                    break;
                case 20:
                    delta.a(20, typedArray.getFloat(index, constraint.e.y));
                    break;
                case 21:
                    delta.b(21, typedArray.getLayoutDimension(index, constraint.e.e));
                    break;
                case 22:
                    delta.b(22, h[typedArray.getInt(index, constraint.c.b)]);
                    break;
                case 23:
                    delta.b(23, typedArray.getLayoutDimension(index, constraint.e.d));
                    break;
                case 24:
                    delta.b(24, typedArray.getDimensionPixelSize(index, constraint.e.H));
                    break;
                case 27:
                    delta.b(27, typedArray.getInt(index, constraint.e.G));
                    break;
                case 28:
                    delta.b(28, typedArray.getDimensionPixelSize(index, constraint.e.I));
                    break;
                case 31:
                    delta.b(31, typedArray.getDimensionPixelSize(index, constraint.e.M));
                    break;
                case 34:
                    delta.b(34, typedArray.getDimensionPixelSize(index, constraint.e.J));
                    break;
                case 37:
                    delta.a(37, typedArray.getFloat(index, constraint.e.z));
                    break;
                case 38:
                    int resourceId = typedArray.getResourceId(index, constraint.f610a);
                    constraint.f610a = resourceId;
                    delta.b(38, resourceId);
                    break;
                case 39:
                    delta.a(39, typedArray.getFloat(index, constraint.e.W));
                    break;
                case 40:
                    delta.a(40, typedArray.getFloat(index, constraint.e.V));
                    break;
                case 41:
                    delta.b(41, typedArray.getInt(index, constraint.e.X));
                    break;
                case 42:
                    delta.b(42, typedArray.getInt(index, constraint.e.Y));
                    break;
                case 43:
                    delta.a(43, typedArray.getFloat(index, constraint.c.d));
                    break;
                case 44:
                    delta.d(44, true);
                    delta.a(44, typedArray.getDimension(index, constraint.f.n));
                    break;
                case 45:
                    delta.a(45, typedArray.getFloat(index, constraint.f.c));
                    break;
                case WXMediaMessage.IMediaObject.TYPE_OPENSDK_APPBRAND_WEISHIVIDEO /*46*/:
                    delta.a(46, typedArray.getFloat(index, constraint.f.d));
                    break;
                case 47:
                    delta.a(47, typedArray.getFloat(index, constraint.f.e));
                    break;
                case 48:
                    delta.a(48, typedArray.getFloat(index, constraint.f.f));
                    break;
                case 49:
                    delta.a(49, typedArray.getDimension(index, constraint.f.g));
                    break;
                case 50:
                    delta.a(50, typedArray.getDimension(index, constraint.f.h));
                    break;
                case 51:
                    delta.a(51, typedArray.getDimension(index, constraint.f.j));
                    break;
                case 52:
                    delta.a(52, typedArray.getDimension(index, constraint.f.k));
                    break;
                case 53:
                    delta.a(53, typedArray.getDimension(index, constraint.f.l));
                    break;
                case 54:
                    delta.b(54, typedArray.getInt(index, constraint.e.Z));
                    break;
                case 55:
                    delta.b(55, typedArray.getInt(index, constraint.e.a0));
                    break;
                case 56:
                    delta.b(56, typedArray.getDimensionPixelSize(index, constraint.e.b0));
                    break;
                case 57:
                    delta.b(57, typedArray.getDimensionPixelSize(index, constraint.e.c0));
                    break;
                case 58:
                    delta.b(58, typedArray.getDimensionPixelSize(index, constraint.e.d0));
                    break;
                case 59:
                    delta.b(59, typedArray.getDimensionPixelSize(index, constraint.e.e0));
                    break;
                case 60:
                    delta.a(60, typedArray.getFloat(index, constraint.f.b));
                    break;
                case 62:
                    delta.b(62, typedArray.getDimensionPixelSize(index, constraint.e.C));
                    break;
                case 63:
                    delta.a(63, typedArray.getFloat(index, constraint.e.D));
                    break;
                case 64:
                    delta.b(64, F(typedArray, index, constraint.d.b));
                    break;
                case 65:
                    if (typedArray.peekValue(index).type != 3) {
                        delta.c(65, Easing.c[typedArray.getInteger(index, 0)]);
                        break;
                    } else {
                        delta.c(65, typedArray.getString(index));
                        break;
                    }
                case 66:
                    delta.b(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    delta.a(67, typedArray.getFloat(index, constraint.d.i));
                    break;
                case 68:
                    delta.a(68, typedArray.getFloat(index, constraint.c.e));
                    break;
                case 69:
                    delta.a(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    delta.a(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    delta.b(72, typedArray.getInt(index, constraint.e.h0));
                    break;
                case 73:
                    delta.b(73, typedArray.getDimensionPixelSize(index, constraint.e.i0));
                    break;
                case 74:
                    delta.c(74, typedArray.getString(index));
                    break;
                case 75:
                    delta.d(75, typedArray.getBoolean(index, constraint.e.p0));
                    break;
                case 76:
                    delta.b(76, typedArray.getInt(index, constraint.d.e));
                    break;
                case CastEventCode.SINK_VIDEO_SIZE_DETERMINED /*77*/:
                    delta.c(77, typedArray.getString(index));
                    break;
                case CastEventCode.SINK_AUDIO_FOCUS_REQUEST_FAILED /*78*/:
                    delta.b(78, typedArray.getInt(index, constraint.c.c));
                    break;
                case 79:
                    delta.a(79, typedArray.getFloat(index, constraint.d.g));
                    break;
                case 80:
                    delta.d(80, typedArray.getBoolean(index, constraint.e.n0));
                    break;
                case CastEventCode.SINK_AUDIO_FOCUS_LOST /*81*/:
                    delta.d(81, typedArray.getBoolean(index, constraint.e.o0));
                    break;
                case 82:
                    delta.b(82, typedArray.getInteger(index, constraint.d.c));
                    break;
                case CastEventCode.SOURCE_PAUSE_VIRTUAL_DISPLAY_SUCCESS /*83*/:
                    delta.b(83, F(typedArray, index, constraint.f.i));
                    break;
                case CastEventCode.SOURCE_RESUME_VIRTUAL_DISPLAY_SUCCESS /*84*/:
                    delta.b(84, typedArray.getInteger(index, constraint.d.k));
                    break;
                case CastEventCode.SINK_VIDEO_SURFACE_CONFIGURABLE /*85*/:
                    delta.a(85, typedArray.getFloat(index, constraint.d.j));
                    break;
                case 86:
                    int i3 = typedArray.peekValue(index).type;
                    if (i3 != 1) {
                        if (i3 != 3) {
                            Motion motion = constraint.d;
                            motion.m = typedArray.getInteger(index, motion.n);
                            delta.b(88, constraint.d.m);
                            break;
                        } else {
                            constraint.d.l = typedArray.getString(index);
                            delta.c(90, constraint.d.l);
                            if (constraint.d.l.indexOf("/") <= 0) {
                                constraint.d.m = -1;
                                delta.b(88, -1);
                                break;
                            } else {
                                constraint.d.n = typedArray.getResourceId(index, -1);
                                delta.b(89, constraint.d.n);
                                constraint.d.m = -2;
                                delta.b(88, -2);
                                break;
                            }
                        }
                    } else {
                        constraint.d.n = typedArray.getResourceId(index, -1);
                        delta.b(89, constraint.d.n);
                        Motion motion2 = constraint.d;
                        if (motion2.n == -1) {
                            break;
                        } else {
                            motion2.m = -2;
                            delta.b(88, -2);
                            break;
                        }
                    }
                case Opcodes.POP /*87*/:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + i.get(index));
                    break;
                case VirtualDeviceEventCode.SOURCE_VIRTUAL_MODEM_OPENED /*93*/:
                    delta.b(93, typedArray.getDimensionPixelSize(index, constraint.e.N));
                    break;
                case VirtualDeviceEventCode.SOURCE_VIRTUAL_MODEM_STOPPED /*94*/:
                    delta.b(94, typedArray.getDimensionPixelSize(index, constraint.e.U));
                    break;
                case VirtualDeviceEventCode.EVENT_CAMERA_IN_USE /*95*/:
                    G(delta, typedArray, index, 0);
                    break;
                case 96:
                    G(delta, typedArray, index, 1);
                    break;
                case VirtualDeviceEventCode.EVENT_CAMERA_DISABLED /*97*/:
                    delta.b(97, typedArray.getInt(index, constraint.e.q0));
                    break;
                case VirtualDeviceEventCode.EVENT_CAMERA_DEVICE /*98*/:
                    if (!MotionLayout.K0) {
                        if (typedArray.peekValue(index).type != 3) {
                            constraint.f610a = typedArray.getResourceId(index, constraint.f610a);
                            break;
                        } else {
                            constraint.b = typedArray.getString(index);
                            break;
                        }
                    } else {
                        int resourceId2 = typedArray.getResourceId(index, constraint.f610a);
                        constraint.f610a = resourceId2;
                        if (resourceId2 != -1) {
                            break;
                        } else {
                            constraint.b = typedArray.getString(index);
                            break;
                        }
                    }
                case VirtualDeviceEventCode.EVENT_CAMERA_SERVICE /*99*/:
                    delta.d(99, typedArray.getBoolean(index, constraint.e.i));
                    break;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + i.get(index));
                    break;
            }
        }
    }

    public static void N(Constraint constraint, int i2, float f2) {
        if (i2 == 19) {
            constraint.e.h = f2;
        } else if (i2 == 20) {
            constraint.e.y = f2;
        } else if (i2 == 37) {
            constraint.e.z = f2;
        } else if (i2 == 60) {
            constraint.f.b = f2;
        } else if (i2 == 63) {
            constraint.e.D = f2;
        } else if (i2 == 79) {
            constraint.d.g = f2;
        } else if (i2 == 85) {
            constraint.d.j = f2;
        } else if (i2 == 87) {
        } else {
            if (i2 == 39) {
                constraint.e.W = f2;
            } else if (i2 != 40) {
                switch (i2) {
                    case 43:
                        constraint.c.d = f2;
                        return;
                    case 44:
                        Transform transform = constraint.f;
                        transform.n = f2;
                        transform.m = true;
                        return;
                    case 45:
                        constraint.f.c = f2;
                        return;
                    case WXMediaMessage.IMediaObject.TYPE_OPENSDK_APPBRAND_WEISHIVIDEO /*46*/:
                        constraint.f.d = f2;
                        return;
                    case 47:
                        constraint.f.e = f2;
                        return;
                    case 48:
                        constraint.f.f = f2;
                        return;
                    case 49:
                        constraint.f.g = f2;
                        return;
                    case 50:
                        constraint.f.h = f2;
                        return;
                    case 51:
                        constraint.f.j = f2;
                        return;
                    case 52:
                        constraint.f.k = f2;
                        return;
                    case 53:
                        constraint.f.l = f2;
                        return;
                    default:
                        switch (i2) {
                            case 67:
                                constraint.d.i = f2;
                                return;
                            case 68:
                                constraint.c.e = f2;
                                return;
                            case 69:
                                constraint.e.f0 = f2;
                                return;
                            case 70:
                                constraint.e.g0 = f2;
                                return;
                            default:
                                Log.w("ConstraintSet", "Unknown attribute 0x");
                                return;
                        }
                }
            } else {
                constraint.e.V = f2;
            }
        }
    }

    public static void O(Constraint constraint, int i2, int i3) {
        if (i2 == 6) {
            constraint.e.E = i3;
        } else if (i2 == 7) {
            constraint.e.F = i3;
        } else if (i2 == 8) {
            constraint.e.L = i3;
        } else if (i2 == 27) {
            constraint.e.G = i3;
        } else if (i2 == 28) {
            constraint.e.I = i3;
        } else if (i2 == 41) {
            constraint.e.X = i3;
        } else if (i2 == 42) {
            constraint.e.Y = i3;
        } else if (i2 == 61) {
            constraint.e.B = i3;
        } else if (i2 == 62) {
            constraint.e.C = i3;
        } else if (i2 == 72) {
            constraint.e.h0 = i3;
        } else if (i2 != 73) {
            switch (i2) {
                case 2:
                    constraint.e.K = i3;
                    return;
                case 11:
                    constraint.e.R = i3;
                    return;
                case 12:
                    constraint.e.S = i3;
                    return;
                case 13:
                    constraint.e.O = i3;
                    return;
                case 14:
                    constraint.e.Q = i3;
                    return;
                case 15:
                    constraint.e.T = i3;
                    return;
                case 16:
                    constraint.e.P = i3;
                    return;
                case 17:
                    constraint.e.f = i3;
                    return;
                case 18:
                    constraint.e.g = i3;
                    return;
                case 31:
                    constraint.e.M = i3;
                    return;
                case 34:
                    constraint.e.J = i3;
                    return;
                case 38:
                    constraint.f610a = i3;
                    return;
                case 64:
                    constraint.d.b = i3;
                    return;
                case 66:
                    constraint.d.f = i3;
                    return;
                case 76:
                    constraint.d.e = i3;
                    return;
                case CastEventCode.SINK_AUDIO_FOCUS_REQUEST_FAILED /*78*/:
                    constraint.c.c = i3;
                    return;
                case VirtualDeviceEventCode.SOURCE_VIRTUAL_MODEM_OPENED /*93*/:
                    constraint.e.N = i3;
                    return;
                case VirtualDeviceEventCode.SOURCE_VIRTUAL_MODEM_STOPPED /*94*/:
                    constraint.e.U = i3;
                    return;
                case VirtualDeviceEventCode.EVENT_CAMERA_DISABLED /*97*/:
                    constraint.e.q0 = i3;
                    return;
                default:
                    switch (i2) {
                        case 21:
                            constraint.e.e = i3;
                            return;
                        case 22:
                            constraint.c.b = i3;
                            return;
                        case 23:
                            constraint.e.d = i3;
                            return;
                        case 24:
                            constraint.e.H = i3;
                            return;
                        default:
                            switch (i2) {
                                case 54:
                                    constraint.e.Z = i3;
                                    return;
                                case 55:
                                    constraint.e.a0 = i3;
                                    return;
                                case 56:
                                    constraint.e.b0 = i3;
                                    return;
                                case 57:
                                    constraint.e.c0 = i3;
                                    return;
                                case 58:
                                    constraint.e.d0 = i3;
                                    return;
                                case 59:
                                    constraint.e.e0 = i3;
                                    return;
                                default:
                                    switch (i2) {
                                        case 82:
                                            constraint.d.c = i3;
                                            return;
                                        case CastEventCode.SOURCE_PAUSE_VIRTUAL_DISPLAY_SUCCESS /*83*/:
                                            constraint.f.i = i3;
                                            return;
                                        case CastEventCode.SOURCE_RESUME_VIRTUAL_DISPLAY_SUCCESS /*84*/:
                                            constraint.d.k = i3;
                                            return;
                                        default:
                                            switch (i2) {
                                                case Opcodes.POP /*87*/:
                                                    return;
                                                case 88:
                                                    constraint.d.m = i3;
                                                    return;
                                                case Opcodes.DUP /*89*/:
                                                    constraint.d.n = i3;
                                                    return;
                                                default:
                                                    Log.w("ConstraintSet", "Unknown attribute 0x");
                                                    return;
                                            }
                                    }
                            }
                    }
            }
        } else {
            constraint.e.i0 = i3;
        }
    }

    public static void P(Constraint constraint, int i2, String str) {
        if (i2 == 5) {
            constraint.e.A = str;
        } else if (i2 == 65) {
            constraint.d.d = str;
        } else if (i2 == 74) {
            Layout layout = constraint.e;
            layout.l0 = str;
            layout.k0 = null;
        } else if (i2 == 77) {
            constraint.e.m0 = str;
        } else if (i2 == 87) {
        } else {
            if (i2 != 90) {
                Log.w("ConstraintSet", "Unknown attribute 0x");
            } else {
                constraint.d.l = str;
            }
        }
    }

    public static void Q(Constraint constraint, int i2, boolean z) {
        if (i2 == 44) {
            constraint.f.m = z;
        } else if (i2 == 75) {
            constraint.e.p0 = z;
        } else if (i2 == 87) {
        } else {
            if (i2 == 80) {
                constraint.e.n0 = z;
            } else if (i2 != 81) {
                Log.w("ConstraintSet", "Unknown attribute 0x");
            } else {
                constraint.e.o0 = z;
            }
        }
    }

    public static Constraint m(Context context, XmlPullParser xmlPullParser) {
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(asAttributeSet, R.styleable.ConstraintOverride);
        K(context, constraint, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    public int A(int i2) {
        return v(i2).c.b;
    }

    public int B(int i2) {
        return v(i2).c.c;
    }

    public int C(int i2) {
        return v(i2).e.d;
    }

    public void D(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    Constraint u = u(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        u.e.f612a = true;
                    }
                    this.g.put(Integer.valueOf(u.f610a), u);
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01cf, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void E(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            r9 = this;
            int r0 = r11.getEventType()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r1 = 0
            r2 = r1
        L_0x0006:
            r3 = 1
            if (r0 == r3) goto L_0x01dc
            if (r0 == 0) goto L_0x01cc
            r4 = -1
            r5 = 3
            r6 = 2
            r7 = 0
            if (r0 == r6) goto L_0x006d
            if (r0 == r5) goto L_0x0015
            goto L_0x01cf
        L_0x0015:
            java.lang.String r0 = r11.getName()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.util.Locale r8 = java.util.Locale.ROOT     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.String r0 = r0.toLowerCase(r8)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            int r8 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            switch(r8) {
                case -2075718416: goto L_0x004b;
                case -190376483: goto L_0x0041;
                case 426575017: goto L_0x0037;
                case 2146106725: goto L_0x0027;
                default: goto L_0x0026;
            }     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
        L_0x0026:
            goto L_0x0054
        L_0x0027:
            java.lang.String r8 = "constraintset"
            boolean r0 = r0.equals(r8)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x0054
            r4 = r7
            goto L_0x0054
        L_0x0031:
            r9 = move-exception
            goto L_0x01d5
        L_0x0034:
            r9 = move-exception
            goto L_0x01d9
        L_0x0037:
            java.lang.String r7 = "constraintoverride"
            boolean r0 = r0.equals(r7)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x0054
            r4 = r6
            goto L_0x0054
        L_0x0041:
            java.lang.String r7 = "constraint"
            boolean r0 = r0.equals(r7)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x0054
            r4 = r3
            goto L_0x0054
        L_0x004b:
            java.lang.String r7 = "guideline"
            boolean r0 = r0.equals(r7)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x0054
            r4 = r5
        L_0x0054:
            if (r4 == 0) goto L_0x006c
            if (r4 == r3) goto L_0x005e
            if (r4 == r6) goto L_0x005e
            if (r4 == r5) goto L_0x005e
            goto L_0x01cf
        L_0x005e:
            java.util.HashMap r0 = r9.g     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            int r3 = r2.f610a     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r0.put(r3, r2)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r2 = r1
            goto L_0x01cf
        L_0x006c:
            return
        L_0x006d:
            java.lang.String r0 = r11.getName()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            int r8 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            switch(r8) {
                case -2025855158: goto L_0x00d6;
                case -1984451626: goto L_0x00cc;
                case -1962203927: goto L_0x00c2;
                case -1269513683: goto L_0x00b8;
                case -1238332596: goto L_0x00ae;
                case -71750448: goto L_0x00a4;
                case 366511058: goto L_0x0099;
                case 1331510167: goto L_0x008f;
                case 1791837707: goto L_0x0084;
                case 1803088381: goto L_0x007a;
                default: goto L_0x0078;
            }     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
        L_0x0078:
            goto L_0x00df
        L_0x007a:
            java.lang.String r5 = "Constraint"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x00df
            r4 = r7
            goto L_0x00df
        L_0x0084:
            java.lang.String r5 = "CustomAttribute"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x00df
            r4 = 8
            goto L_0x00df
        L_0x008f:
            java.lang.String r6 = "Barrier"
            boolean r0 = r0.equals(r6)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x00df
            r4 = r5
            goto L_0x00df
        L_0x0099:
            java.lang.String r5 = "CustomMethod"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x00df
            r4 = 9
            goto L_0x00df
        L_0x00a4:
            java.lang.String r5 = "Guideline"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x00df
            r4 = r6
            goto L_0x00df
        L_0x00ae:
            java.lang.String r5 = "Transform"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x00df
            r4 = 5
            goto L_0x00df
        L_0x00b8:
            java.lang.String r5 = "PropertySet"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x00df
            r4 = 4
            goto L_0x00df
        L_0x00c2:
            java.lang.String r5 = "ConstraintOverride"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x00df
            r4 = r3
            goto L_0x00df
        L_0x00cc:
            java.lang.String r5 = "Motion"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x00df
            r4 = 7
            goto L_0x00df
        L_0x00d6:
            java.lang.String r5 = "Layout"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x00df
            r4 = 6
        L_0x00df:
            java.lang.String r0 = "XML parser error must be within a Constraint "
            switch(r4) {
                case 0: goto L_0x01c3;
                case 1: goto L_0x01ba;
                case 2: goto L_0x01ab;
                case 3: goto L_0x019e;
                case 4: goto L_0x0179;
                case 5: goto L_0x0154;
                case 6: goto L_0x012e;
                case 7: goto L_0x0108;
                case 8: goto L_0x00e6;
                case 9: goto L_0x00e6;
                default: goto L_0x00e4;
            }
        L_0x00e4:
            goto L_0x01cf
        L_0x00e6:
            if (r2 == 0) goto L_0x00ef
            java.util.HashMap r0 = r2.g     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            androidx.constraintlayout.widget.ConstraintAttribute.i(r10, r11, r0)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            goto L_0x01cf
        L_0x00ef:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r10.<init>()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r10.append(r0)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r10.append(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.String r10 = r10.toString()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r9.<init>(r10)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            throw r9     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
        L_0x0108:
            if (r2 == 0) goto L_0x0115
            androidx.constraintlayout.widget.ConstraintSet$Motion r0 = r2.d     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r0.b(r10, r3)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            goto L_0x01cf
        L_0x0115:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r10.<init>()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r10.append(r0)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r10.append(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.String r10 = r10.toString()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r9.<init>(r10)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            throw r9     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
        L_0x012e:
            if (r2 == 0) goto L_0x013b
            androidx.constraintlayout.widget.ConstraintSet$Layout r0 = r2.e     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r0.b(r10, r3)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            goto L_0x01cf
        L_0x013b:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r10.<init>()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r10.append(r0)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r10.append(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.String r10 = r10.toString()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r9.<init>(r10)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            throw r9     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
        L_0x0154:
            if (r2 == 0) goto L_0x0160
            androidx.constraintlayout.widget.ConstraintSet$Transform r0 = r2.f     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r0.b(r10, r3)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            goto L_0x01cf
        L_0x0160:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r10.<init>()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r10.append(r0)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r10.append(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.String r10 = r10.toString()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r9.<init>(r10)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            throw r9     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
        L_0x0179:
            if (r2 == 0) goto L_0x0185
            androidx.constraintlayout.widget.ConstraintSet$PropertySet r0 = r2.c     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r0.b(r10, r3)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            goto L_0x01cf
        L_0x0185:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r10.<init>()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r10.append(r0)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r10.append(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.String r10 = r10.toString()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r9.<init>(r10)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            throw r9     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
        L_0x019e:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r2 = r9.u(r10, r0, r7)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            androidx.constraintlayout.widget.ConstraintSet$Layout r0 = r2.e     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r0.j0 = r3     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            goto L_0x01cf
        L_0x01ab:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r2 = r9.u(r10, r0, r7)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            androidx.constraintlayout.widget.ConstraintSet$Layout r0 = r2.e     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r0.f612a = r3     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r0.b = r3     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            goto L_0x01cf
        L_0x01ba:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r2 = r9.u(r10, r0, r3)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            goto L_0x01cf
        L_0x01c3:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r2 = r9.u(r10, r0, r7)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            goto L_0x01cf
        L_0x01cc:
            r11.getName()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
        L_0x01cf:
            int r0 = r11.next()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            goto L_0x0006
        L_0x01d5:
            r9.printStackTrace()
            goto L_0x01dc
        L_0x01d9:
            r9.printStackTrace()
        L_0x01dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.E(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public final void J(Context context, Constraint constraint, TypedArray typedArray, boolean z) {
        if (z) {
            K(context, constraint, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            if (!(index == R.styleable.Constraint_android_id || R.styleable.Constraint_android_layout_marginStart == index || R.styleable.Constraint_android_layout_marginEnd == index)) {
                constraint.d.f613a = true;
                constraint.e.b = true;
                constraint.c.f614a = true;
                constraint.f.f615a = true;
            }
            switch (i.get(index)) {
                case 1:
                    Layout layout = constraint.e;
                    layout.r = F(typedArray, index, layout.r);
                    break;
                case 2:
                    Layout layout2 = constraint.e;
                    layout2.K = typedArray.getDimensionPixelSize(index, layout2.K);
                    break;
                case 3:
                    Layout layout3 = constraint.e;
                    layout3.q = F(typedArray, index, layout3.q);
                    break;
                case 4:
                    Layout layout4 = constraint.e;
                    layout4.p = F(typedArray, index, layout4.p);
                    break;
                case 5:
                    constraint.e.A = typedArray.getString(index);
                    break;
                case 6:
                    Layout layout5 = constraint.e;
                    layout5.E = typedArray.getDimensionPixelOffset(index, layout5.E);
                    break;
                case 7:
                    Layout layout6 = constraint.e;
                    layout6.F = typedArray.getDimensionPixelOffset(index, layout6.F);
                    break;
                case 8:
                    Layout layout7 = constraint.e;
                    layout7.L = typedArray.getDimensionPixelSize(index, layout7.L);
                    break;
                case 9:
                    Layout layout8 = constraint.e;
                    layout8.x = F(typedArray, index, layout8.x);
                    break;
                case 10:
                    Layout layout9 = constraint.e;
                    layout9.w = F(typedArray, index, layout9.w);
                    break;
                case 11:
                    Layout layout10 = constraint.e;
                    layout10.R = typedArray.getDimensionPixelSize(index, layout10.R);
                    break;
                case 12:
                    Layout layout11 = constraint.e;
                    layout11.S = typedArray.getDimensionPixelSize(index, layout11.S);
                    break;
                case 13:
                    Layout layout12 = constraint.e;
                    layout12.O = typedArray.getDimensionPixelSize(index, layout12.O);
                    break;
                case 14:
                    Layout layout13 = constraint.e;
                    layout13.Q = typedArray.getDimensionPixelSize(index, layout13.Q);
                    break;
                case 15:
                    Layout layout14 = constraint.e;
                    layout14.T = typedArray.getDimensionPixelSize(index, layout14.T);
                    break;
                case 16:
                    Layout layout15 = constraint.e;
                    layout15.P = typedArray.getDimensionPixelSize(index, layout15.P);
                    break;
                case 17:
                    Layout layout16 = constraint.e;
                    layout16.f = typedArray.getDimensionPixelOffset(index, layout16.f);
                    break;
                case 18:
                    Layout layout17 = constraint.e;
                    layout17.g = typedArray.getDimensionPixelOffset(index, layout17.g);
                    break;
                case 19:
                    Layout layout18 = constraint.e;
                    layout18.h = typedArray.getFloat(index, layout18.h);
                    break;
                case 20:
                    Layout layout19 = constraint.e;
                    layout19.y = typedArray.getFloat(index, layout19.y);
                    break;
                case 21:
                    Layout layout20 = constraint.e;
                    layout20.e = typedArray.getLayoutDimension(index, layout20.e);
                    break;
                case 22:
                    PropertySet propertySet = constraint.c;
                    propertySet.b = typedArray.getInt(index, propertySet.b);
                    PropertySet propertySet2 = constraint.c;
                    propertySet2.b = h[propertySet2.b];
                    break;
                case 23:
                    Layout layout21 = constraint.e;
                    layout21.d = typedArray.getLayoutDimension(index, layout21.d);
                    break;
                case 24:
                    Layout layout22 = constraint.e;
                    layout22.H = typedArray.getDimensionPixelSize(index, layout22.H);
                    break;
                case 25:
                    Layout layout23 = constraint.e;
                    layout23.j = F(typedArray, index, layout23.j);
                    break;
                case 26:
                    Layout layout24 = constraint.e;
                    layout24.k = F(typedArray, index, layout24.k);
                    break;
                case 27:
                    Layout layout25 = constraint.e;
                    layout25.G = typedArray.getInt(index, layout25.G);
                    break;
                case 28:
                    Layout layout26 = constraint.e;
                    layout26.I = typedArray.getDimensionPixelSize(index, layout26.I);
                    break;
                case 29:
                    Layout layout27 = constraint.e;
                    layout27.l = F(typedArray, index, layout27.l);
                    break;
                case 30:
                    Layout layout28 = constraint.e;
                    layout28.m = F(typedArray, index, layout28.m);
                    break;
                case 31:
                    Layout layout29 = constraint.e;
                    layout29.M = typedArray.getDimensionPixelSize(index, layout29.M);
                    break;
                case 32:
                    Layout layout30 = constraint.e;
                    layout30.u = F(typedArray, index, layout30.u);
                    break;
                case 33:
                    Layout layout31 = constraint.e;
                    layout31.v = F(typedArray, index, layout31.v);
                    break;
                case 34:
                    Layout layout32 = constraint.e;
                    layout32.J = typedArray.getDimensionPixelSize(index, layout32.J);
                    break;
                case 35:
                    Layout layout33 = constraint.e;
                    layout33.o = F(typedArray, index, layout33.o);
                    break;
                case 36:
                    Layout layout34 = constraint.e;
                    layout34.n = F(typedArray, index, layout34.n);
                    break;
                case 37:
                    Layout layout35 = constraint.e;
                    layout35.z = typedArray.getFloat(index, layout35.z);
                    break;
                case 38:
                    constraint.f610a = typedArray.getResourceId(index, constraint.f610a);
                    break;
                case 39:
                    Layout layout36 = constraint.e;
                    layout36.W = typedArray.getFloat(index, layout36.W);
                    break;
                case 40:
                    Layout layout37 = constraint.e;
                    layout37.V = typedArray.getFloat(index, layout37.V);
                    break;
                case 41:
                    Layout layout38 = constraint.e;
                    layout38.X = typedArray.getInt(index, layout38.X);
                    break;
                case 42:
                    Layout layout39 = constraint.e;
                    layout39.Y = typedArray.getInt(index, layout39.Y);
                    break;
                case 43:
                    PropertySet propertySet3 = constraint.c;
                    propertySet3.d = typedArray.getFloat(index, propertySet3.d);
                    break;
                case 44:
                    Transform transform = constraint.f;
                    transform.m = true;
                    transform.n = typedArray.getDimension(index, transform.n);
                    break;
                case 45:
                    Transform transform2 = constraint.f;
                    transform2.c = typedArray.getFloat(index, transform2.c);
                    break;
                case WXMediaMessage.IMediaObject.TYPE_OPENSDK_APPBRAND_WEISHIVIDEO /*46*/:
                    Transform transform3 = constraint.f;
                    transform3.d = typedArray.getFloat(index, transform3.d);
                    break;
                case 47:
                    Transform transform4 = constraint.f;
                    transform4.e = typedArray.getFloat(index, transform4.e);
                    break;
                case 48:
                    Transform transform5 = constraint.f;
                    transform5.f = typedArray.getFloat(index, transform5.f);
                    break;
                case 49:
                    Transform transform6 = constraint.f;
                    transform6.g = typedArray.getDimension(index, transform6.g);
                    break;
                case 50:
                    Transform transform7 = constraint.f;
                    transform7.h = typedArray.getDimension(index, transform7.h);
                    break;
                case 51:
                    Transform transform8 = constraint.f;
                    transform8.j = typedArray.getDimension(index, transform8.j);
                    break;
                case 52:
                    Transform transform9 = constraint.f;
                    transform9.k = typedArray.getDimension(index, transform9.k);
                    break;
                case 53:
                    Transform transform10 = constraint.f;
                    transform10.l = typedArray.getDimension(index, transform10.l);
                    break;
                case 54:
                    Layout layout40 = constraint.e;
                    layout40.Z = typedArray.getInt(index, layout40.Z);
                    break;
                case 55:
                    Layout layout41 = constraint.e;
                    layout41.a0 = typedArray.getInt(index, layout41.a0);
                    break;
                case 56:
                    Layout layout42 = constraint.e;
                    layout42.b0 = typedArray.getDimensionPixelSize(index, layout42.b0);
                    break;
                case 57:
                    Layout layout43 = constraint.e;
                    layout43.c0 = typedArray.getDimensionPixelSize(index, layout43.c0);
                    break;
                case 58:
                    Layout layout44 = constraint.e;
                    layout44.d0 = typedArray.getDimensionPixelSize(index, layout44.d0);
                    break;
                case 59:
                    Layout layout45 = constraint.e;
                    layout45.e0 = typedArray.getDimensionPixelSize(index, layout45.e0);
                    break;
                case 60:
                    Transform transform11 = constraint.f;
                    transform11.b = typedArray.getFloat(index, transform11.b);
                    break;
                case 61:
                    Layout layout46 = constraint.e;
                    layout46.B = F(typedArray, index, layout46.B);
                    break;
                case 62:
                    Layout layout47 = constraint.e;
                    layout47.C = typedArray.getDimensionPixelSize(index, layout47.C);
                    break;
                case 63:
                    Layout layout48 = constraint.e;
                    layout48.D = typedArray.getFloat(index, layout48.D);
                    break;
                case 64:
                    Motion motion = constraint.d;
                    motion.b = F(typedArray, index, motion.b);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type != 3) {
                        constraint.d.d = Easing.c[typedArray.getInteger(index, 0)];
                        break;
                    } else {
                        constraint.d.d = typedArray.getString(index);
                        break;
                    }
                case 66:
                    constraint.d.f = typedArray.getInt(index, 0);
                    break;
                case 67:
                    Motion motion2 = constraint.d;
                    motion2.i = typedArray.getFloat(index, motion2.i);
                    break;
                case 68:
                    PropertySet propertySet4 = constraint.c;
                    propertySet4.e = typedArray.getFloat(index, propertySet4.e);
                    break;
                case 69:
                    constraint.e.f0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    constraint.e.g0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    Layout layout49 = constraint.e;
                    layout49.h0 = typedArray.getInt(index, layout49.h0);
                    break;
                case 73:
                    Layout layout50 = constraint.e;
                    layout50.i0 = typedArray.getDimensionPixelSize(index, layout50.i0);
                    break;
                case 74:
                    constraint.e.l0 = typedArray.getString(index);
                    break;
                case 75:
                    Layout layout51 = constraint.e;
                    layout51.p0 = typedArray.getBoolean(index, layout51.p0);
                    break;
                case 76:
                    Motion motion3 = constraint.d;
                    motion3.e = typedArray.getInt(index, motion3.e);
                    break;
                case CastEventCode.SINK_VIDEO_SIZE_DETERMINED /*77*/:
                    constraint.e.m0 = typedArray.getString(index);
                    break;
                case CastEventCode.SINK_AUDIO_FOCUS_REQUEST_FAILED /*78*/:
                    PropertySet propertySet5 = constraint.c;
                    propertySet5.c = typedArray.getInt(index, propertySet5.c);
                    break;
                case 79:
                    Motion motion4 = constraint.d;
                    motion4.g = typedArray.getFloat(index, motion4.g);
                    break;
                case 80:
                    Layout layout52 = constraint.e;
                    layout52.n0 = typedArray.getBoolean(index, layout52.n0);
                    break;
                case CastEventCode.SINK_AUDIO_FOCUS_LOST /*81*/:
                    Layout layout53 = constraint.e;
                    layout53.o0 = typedArray.getBoolean(index, layout53.o0);
                    break;
                case 82:
                    Motion motion5 = constraint.d;
                    motion5.c = typedArray.getInteger(index, motion5.c);
                    break;
                case CastEventCode.SOURCE_PAUSE_VIRTUAL_DISPLAY_SUCCESS /*83*/:
                    Transform transform12 = constraint.f;
                    transform12.i = F(typedArray, index, transform12.i);
                    break;
                case CastEventCode.SOURCE_RESUME_VIRTUAL_DISPLAY_SUCCESS /*84*/:
                    Motion motion6 = constraint.d;
                    motion6.k = typedArray.getInteger(index, motion6.k);
                    break;
                case CastEventCode.SINK_VIDEO_SURFACE_CONFIGURABLE /*85*/:
                    Motion motion7 = constraint.d;
                    motion7.j = typedArray.getFloat(index, motion7.j);
                    break;
                case 86:
                    int i3 = typedArray.peekValue(index).type;
                    if (i3 != 1) {
                        if (i3 != 3) {
                            Motion motion8 = constraint.d;
                            motion8.m = typedArray.getInteger(index, motion8.n);
                            break;
                        } else {
                            constraint.d.l = typedArray.getString(index);
                            if (constraint.d.l.indexOf("/") <= 0) {
                                constraint.d.m = -1;
                                break;
                            } else {
                                constraint.d.n = typedArray.getResourceId(index, -1);
                                constraint.d.m = -2;
                                break;
                            }
                        }
                    } else {
                        constraint.d.n = typedArray.getResourceId(index, -1);
                        Motion motion9 = constraint.d;
                        if (motion9.n == -1) {
                            break;
                        } else {
                            motion9.m = -2;
                            break;
                        }
                    }
                case Opcodes.POP /*87*/:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + i.get(index));
                    break;
                case 91:
                    Layout layout54 = constraint.e;
                    layout54.s = F(typedArray, index, layout54.s);
                    break;
                case 92:
                    Layout layout55 = constraint.e;
                    layout55.t = F(typedArray, index, layout55.t);
                    break;
                case VirtualDeviceEventCode.SOURCE_VIRTUAL_MODEM_OPENED /*93*/:
                    Layout layout56 = constraint.e;
                    layout56.N = typedArray.getDimensionPixelSize(index, layout56.N);
                    break;
                case VirtualDeviceEventCode.SOURCE_VIRTUAL_MODEM_STOPPED /*94*/:
                    Layout layout57 = constraint.e;
                    layout57.U = typedArray.getDimensionPixelSize(index, layout57.U);
                    break;
                case VirtualDeviceEventCode.EVENT_CAMERA_IN_USE /*95*/:
                    G(constraint.e, typedArray, index, 0);
                    break;
                case 96:
                    G(constraint.e, typedArray, index, 1);
                    break;
                case VirtualDeviceEventCode.EVENT_CAMERA_DISABLED /*97*/:
                    Layout layout58 = constraint.e;
                    layout58.q0 = typedArray.getInt(index, layout58.q0);
                    break;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + i.get(index));
                    break;
            }
        }
        Layout layout59 = constraint.e;
        if (layout59.l0 != null) {
            layout59.k0 = null;
        }
    }

    public void L(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = constraintLayout.getChildAt(i2);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!this.f || id != -1) {
                if (!this.g.containsKey(Integer.valueOf(id))) {
                    this.g.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = (Constraint) this.g.get(Integer.valueOf(id));
                if (constraint != null) {
                    if (!constraint.e.b) {
                        constraint.g(id, layoutParams);
                        if (childAt instanceof ConstraintHelper) {
                            constraint.e.k0 = ((ConstraintHelper) childAt).getReferencedIds();
                            if (childAt instanceof Barrier) {
                                Barrier barrier = (Barrier) childAt;
                                constraint.e.p0 = barrier.getAllowsGoneWidget();
                                constraint.e.h0 = barrier.getType();
                                constraint.e.i0 = barrier.getMargin();
                            }
                        }
                        constraint.e.b = true;
                    }
                    PropertySet propertySet = constraint.c;
                    if (!propertySet.f614a) {
                        propertySet.b = childAt.getVisibility();
                        constraint.c.d = childAt.getAlpha();
                        constraint.c.f614a = true;
                    }
                    Transform transform = constraint.f;
                    if (!transform.f615a) {
                        transform.f615a = true;
                        transform.b = childAt.getRotation();
                        constraint.f.c = childAt.getRotationX();
                        constraint.f.d = childAt.getRotationY();
                        constraint.f.e = childAt.getScaleX();
                        constraint.f.f = childAt.getScaleY();
                        float pivotX = childAt.getPivotX();
                        float pivotY = childAt.getPivotY();
                        if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                            Transform transform2 = constraint.f;
                            transform2.g = pivotX;
                            transform2.h = pivotY;
                        }
                        constraint.f.j = childAt.getTranslationX();
                        constraint.f.k = childAt.getTranslationY();
                        constraint.f.l = childAt.getTranslationZ();
                        Transform transform3 = constraint.f;
                        if (transform3.m) {
                            transform3.n = childAt.getElevation();
                        }
                    }
                }
                i2++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void M(ConstraintSet constraintSet) {
        for (Integer num : constraintSet.g.keySet()) {
            num.intValue();
            Constraint constraint = (Constraint) constraintSet.g.get(num);
            if (!this.g.containsKey(num)) {
                this.g.put(num, new Constraint());
            }
            Constraint constraint2 = (Constraint) this.g.get(num);
            if (constraint2 != null) {
                Layout layout = constraint2.e;
                if (!layout.b) {
                    layout.a(constraint.e);
                }
                PropertySet propertySet = constraint2.c;
                if (!propertySet.f614a) {
                    propertySet.a(constraint.c);
                }
                Transform transform = constraint2.f;
                if (!transform.f615a) {
                    transform.a(constraint.f);
                }
                Motion motion = constraint2.d;
                if (!motion.f613a) {
                    motion.a(constraint.d);
                }
                for (String str : constraint.g.keySet()) {
                    if (!constraint2.g.containsKey(str)) {
                        constraint2.g.put(str, (ConstraintAttribute) constraint.g.get(str));
                    }
                }
            }
        }
    }

    public void R(boolean z) {
        this.f = z;
    }

    public void S(boolean z) {
        this.f609a = z;
    }

    public final String T(int i2) {
        switch (i2) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return MzContactsContract.START_PARAM_KEY;
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public void g(ConstraintLayout constraintLayout) {
        Constraint constraint;
        int childCount = constraintLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (!this.g.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + Debug.d(childAt));
            } else if (this.f && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (this.g.containsKey(Integer.valueOf(id)) && (constraint = (Constraint) this.g.get(Integer.valueOf(id))) != null) {
                ConstraintAttribute.j(childAt, constraint.g);
            }
        }
    }

    public void h(ConstraintSet constraintSet) {
        for (Constraint constraint : constraintSet.g.values()) {
            if (constraint.h != null) {
                if (constraint.b != null) {
                    for (Integer intValue : this.g.keySet()) {
                        Constraint w = w(intValue.intValue());
                        String str = w.e.m0;
                        if (str != null && constraint.b.matches(str)) {
                            constraint.h.e(w);
                            w.g.putAll((HashMap) constraint.g.clone());
                        }
                    }
                } else {
                    constraint.h.e(w(constraint.f610a));
                }
            }
        }
    }

    public void i(ConstraintLayout constraintLayout) {
        k(constraintLayout, true);
        constraintLayout.setConstraintSet((ConstraintSet) null);
        constraintLayout.requestLayout();
    }

    public void j(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray sparseArray) {
        Constraint constraint;
        int id = constraintHelper.getId();
        if (this.g.containsKey(Integer.valueOf(id)) && (constraint = (Constraint) this.g.get(Integer.valueOf(id))) != null && (constraintWidget instanceof HelperWidget)) {
            constraintHelper.p(constraint, (HelperWidget) constraintWidget, layoutParams, sparseArray);
        }
    }

    public void k(ConstraintLayout constraintLayout, boolean z) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.g.keySet());
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (!this.g.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + Debug.d(childAt));
            } else if (this.f && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id != -1) {
                if (this.g.containsKey(Integer.valueOf(id))) {
                    hashSet.remove(Integer.valueOf(id));
                    Constraint constraint = (Constraint) this.g.get(Integer.valueOf(id));
                    if (constraint != null) {
                        if (childAt instanceof Barrier) {
                            constraint.e.j0 = 1;
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            barrier.setType(constraint.e.h0);
                            barrier.setMargin(constraint.e.i0);
                            barrier.setAllowsGoneWidget(constraint.e.p0);
                            Layout layout = constraint.e;
                            int[] iArr = layout.k0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = layout.l0;
                                if (str != null) {
                                    layout.k0 = t(barrier, str);
                                    barrier.setReferencedIds(constraint.e.k0);
                                }
                            }
                        }
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.c();
                        constraint.e(layoutParams);
                        if (z) {
                            ConstraintAttribute.j(childAt, constraint.g);
                        }
                        childAt.setLayoutParams(layoutParams);
                        PropertySet propertySet = constraint.c;
                        if (propertySet.c == 0) {
                            childAt.setVisibility(propertySet.b);
                        }
                        childAt.setAlpha(constraint.c.d);
                        childAt.setRotation(constraint.f.b);
                        childAt.setRotationX(constraint.f.c);
                        childAt.setRotationY(constraint.f.d);
                        childAt.setScaleX(constraint.f.e);
                        childAt.setScaleY(constraint.f.f);
                        Transform transform = constraint.f;
                        if (transform.i != -1) {
                            View findViewById = ((View) childAt.getParent()).findViewById(constraint.f.i);
                            if (findViewById != null) {
                                float top2 = ((float) (findViewById.getTop() + findViewById.getBottom())) / 2.0f;
                                float left = ((float) (findViewById.getLeft() + findViewById.getRight())) / 2.0f;
                                if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                    childAt.setPivotX(left - ((float) childAt.getLeft()));
                                    childAt.setPivotY(top2 - ((float) childAt.getTop()));
                                }
                            }
                        } else {
                            if (!Float.isNaN(transform.g)) {
                                childAt.setPivotX(constraint.f.g);
                            }
                            if (!Float.isNaN(constraint.f.h)) {
                                childAt.setPivotY(constraint.f.h);
                            }
                        }
                        childAt.setTranslationX(constraint.f.j);
                        childAt.setTranslationY(constraint.f.k);
                        childAt.setTranslationZ(constraint.f.l);
                        Transform transform2 = constraint.f;
                        if (transform2.m) {
                            childAt.setElevation(transform2.n);
                        }
                    }
                } else {
                    Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Constraint constraint2 = (Constraint) this.g.get(num);
            if (constraint2 != null) {
                if (constraint2.e.j0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    Layout layout2 = constraint2.e;
                    int[] iArr2 = layout2.k0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = layout2.l0;
                        if (str2 != null) {
                            layout2.k0 = t(barrier2, str2);
                            barrier2.setReferencedIds(constraint2.e.k0);
                        }
                    }
                    barrier2.setType(constraint2.e.h0);
                    barrier2.setMargin(constraint2.e.i0);
                    ConstraintLayout.LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.w();
                    constraint2.e(generateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, generateDefaultLayoutParams);
                }
                if (constraint2.e.f612a) {
                    Guideline guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    constraint2.e(generateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, generateDefaultLayoutParams2);
                }
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = constraintLayout.getChildAt(i3);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).j(constraintLayout);
            }
        }
    }

    public void l(int i2, ConstraintLayout.LayoutParams layoutParams) {
        Constraint constraint;
        if (this.g.containsKey(Integer.valueOf(i2)) && (constraint = (Constraint) this.g.get(Integer.valueOf(i2))) != null) {
            constraint.e(layoutParams);
        }
    }

    public void n(Context context, int i2) {
        o((ConstraintLayout) LayoutInflater.from(context).inflate(i2, (ViewGroup) null));
    }

    public void o(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.g.clear();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = constraintLayout.getChildAt(i2);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!this.f || id != -1) {
                if (!this.g.containsKey(Integer.valueOf(id))) {
                    this.g.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = (Constraint) this.g.get(Integer.valueOf(id));
                if (constraint != null) {
                    constraint.g = ConstraintAttribute.b(this.e, childAt);
                    constraint.g(id, layoutParams);
                    constraint.c.b = childAt.getVisibility();
                    constraint.c.d = childAt.getAlpha();
                    constraint.f.b = childAt.getRotation();
                    constraint.f.c = childAt.getRotationX();
                    constraint.f.d = childAt.getRotationY();
                    constraint.f.e = childAt.getScaleX();
                    constraint.f.f = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                        Transform transform = constraint.f;
                        transform.g = pivotX;
                        transform.h = pivotY;
                    }
                    constraint.f.j = childAt.getTranslationX();
                    constraint.f.k = childAt.getTranslationY();
                    constraint.f.l = childAt.getTranslationZ();
                    Transform transform2 = constraint.f;
                    if (transform2.m) {
                        transform2.n = childAt.getElevation();
                    }
                    if (childAt instanceof Barrier) {
                        Barrier barrier = (Barrier) childAt;
                        constraint.e.p0 = barrier.getAllowsGoneWidget();
                        constraint.e.k0 = barrier.getReferencedIds();
                        constraint.e.h0 = barrier.getType();
                        constraint.e.i0 = barrier.getMargin();
                    }
                }
                i2++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void p(ConstraintSet constraintSet) {
        this.g.clear();
        for (Integer num : constraintSet.g.keySet()) {
            Constraint constraint = (Constraint) constraintSet.g.get(num);
            if (constraint != null) {
                this.g.put(num, constraint.clone());
            }
        }
    }

    public void q(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.g.clear();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = constraints.getChildAt(i2);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!this.f || id != -1) {
                if (!this.g.containsKey(Integer.valueOf(id))) {
                    this.g.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = (Constraint) this.g.get(Integer.valueOf(id));
                if (constraint != null) {
                    if (childAt instanceof ConstraintHelper) {
                        constraint.i((ConstraintHelper) childAt, id, layoutParams);
                    }
                    constraint.h(id, layoutParams);
                }
                i2++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void r(int i2, int i3, int i4, int i5) {
        if (!this.g.containsKey(Integer.valueOf(i2))) {
            this.g.put(Integer.valueOf(i2), new Constraint());
        }
        Constraint constraint = (Constraint) this.g.get(Integer.valueOf(i2));
        if (constraint != null) {
            switch (i3) {
                case 1:
                    if (i5 == 1) {
                        Layout layout = constraint.e;
                        layout.j = i4;
                        layout.k = -1;
                        return;
                    } else if (i5 == 2) {
                        Layout layout2 = constraint.e;
                        layout2.k = i4;
                        layout2.j = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("left to " + T(i5) + " undefined");
                    }
                case 2:
                    if (i5 == 1) {
                        Layout layout3 = constraint.e;
                        layout3.l = i4;
                        layout3.m = -1;
                        return;
                    } else if (i5 == 2) {
                        Layout layout4 = constraint.e;
                        layout4.m = i4;
                        layout4.l = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + T(i5) + " undefined");
                    }
                case 3:
                    if (i5 == 3) {
                        Layout layout5 = constraint.e;
                        layout5.n = i4;
                        layout5.o = -1;
                        layout5.r = -1;
                        layout5.s = -1;
                        layout5.t = -1;
                        return;
                    } else if (i5 == 4) {
                        Layout layout6 = constraint.e;
                        layout6.o = i4;
                        layout6.n = -1;
                        layout6.r = -1;
                        layout6.s = -1;
                        layout6.t = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + T(i5) + " undefined");
                    }
                case 4:
                    if (i5 == 4) {
                        Layout layout7 = constraint.e;
                        layout7.q = i4;
                        layout7.p = -1;
                        layout7.r = -1;
                        layout7.s = -1;
                        layout7.t = -1;
                        return;
                    } else if (i5 == 3) {
                        Layout layout8 = constraint.e;
                        layout8.p = i4;
                        layout8.q = -1;
                        layout8.r = -1;
                        layout8.s = -1;
                        layout8.t = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + T(i5) + " undefined");
                    }
                case 5:
                    if (i5 == 5) {
                        Layout layout9 = constraint.e;
                        layout9.r = i4;
                        layout9.q = -1;
                        layout9.p = -1;
                        layout9.n = -1;
                        layout9.o = -1;
                        return;
                    } else if (i5 == 3) {
                        Layout layout10 = constraint.e;
                        layout10.s = i4;
                        layout10.q = -1;
                        layout10.p = -1;
                        layout10.n = -1;
                        layout10.o = -1;
                        return;
                    } else if (i5 == 4) {
                        Layout layout11 = constraint.e;
                        layout11.t = i4;
                        layout11.q = -1;
                        layout11.p = -1;
                        layout11.n = -1;
                        layout11.o = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + T(i5) + " undefined");
                    }
                case 6:
                    if (i5 == 6) {
                        Layout layout12 = constraint.e;
                        layout12.v = i4;
                        layout12.u = -1;
                        return;
                    } else if (i5 == 7) {
                        Layout layout13 = constraint.e;
                        layout13.u = i4;
                        layout13.v = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + T(i5) + " undefined");
                    }
                case 7:
                    if (i5 == 7) {
                        Layout layout14 = constraint.e;
                        layout14.x = i4;
                        layout14.w = -1;
                        return;
                    } else if (i5 == 6) {
                        Layout layout15 = constraint.e;
                        layout15.w = i4;
                        layout15.x = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + T(i5) + " undefined");
                    }
                default:
                    throw new IllegalArgumentException(T(i3) + " to " + T(i5) + " unknown");
            }
        }
    }

    public void s(int i2, int i3, int i4, float f2) {
        Layout layout = v(i2).e;
        layout.B = i3;
        layout.C = i4;
        layout.D = f2;
    }

    public final int[] t(View view, String str) {
        int i2;
        Object designInformation;
        String[] split = str.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i3 = 0;
        int i4 = 0;
        while (i3 < split.length) {
            String trim = split[i3].trim();
            try {
                i2 = R.id.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i2 = 0;
            }
            if (i2 == 0) {
                i2 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i2 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
                i2 = ((Integer) designInformation).intValue();
            }
            iArr[i4] = i2;
            i3++;
            i4++;
        }
        return i4 != split.length ? Arrays.copyOf(iArr, i4) : iArr;
    }

    public final Constraint u(Context context, AttributeSet attributeSet, boolean z) {
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z ? R.styleable.ConstraintOverride : R.styleable.Constraint);
        J(context, constraint, obtainStyledAttributes, z);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    public final Constraint v(int i2) {
        if (!this.g.containsKey(Integer.valueOf(i2))) {
            this.g.put(Integer.valueOf(i2), new Constraint());
        }
        return (Constraint) this.g.get(Integer.valueOf(i2));
    }

    public Constraint w(int i2) {
        if (this.g.containsKey(Integer.valueOf(i2))) {
            return (Constraint) this.g.get(Integer.valueOf(i2));
        }
        return null;
    }

    public int x(int i2) {
        return v(i2).e.e;
    }

    public int[] y() {
        Integer[] numArr = (Integer[]) this.g.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = numArr[i2].intValue();
        }
        return iArr;
    }

    public Constraint z(int i2) {
        return v(i2);
    }
}
