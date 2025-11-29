package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.geetest.sdk.x;
import com.meizu.common.datetimepicker.date.MonthView;
import java.util.Arrays;
import java.util.LinkedHashMap;

class MotionPaths implements Comparable<MotionPaths> {
    public static String[] t = {"position", x.f, "y", MonthView.VIEW_PARAMS_WIDTH, MonthView.VIEW_PARAMS_HEIGHT, "pathRotate"};

    /* renamed from: a  reason: collision with root package name */
    public Easing f574a;
    public int b = 0;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i = Float.NaN;
    public float j = Float.NaN;
    public int k;
    public int l;
    public float m;
    public MotionController n;
    public LinkedHashMap o;
    public int p;
    public int q;
    public double[] r;
    public double[] s;

    public MotionPaths() {
        int i2 = Key.f;
        this.k = i2;
        this.l = i2;
        this.m = Float.NaN;
        this.n = null;
        this.o = new LinkedHashMap();
        this.p = 0;
        this.r = new double[18];
        this.s = new double[18];
    }

    public void a(ConstraintSet.Constraint constraint) {
        this.f574a = Easing.c(constraint.d.d);
        ConstraintSet.Motion motion = constraint.d;
        this.k = motion.e;
        this.l = motion.b;
        this.i = motion.i;
        this.b = motion.f;
        this.q = motion.c;
        this.j = constraint.c.e;
        this.m = constraint.e.D;
        for (String str : constraint.g.keySet()) {
            ConstraintAttribute constraintAttribute = (ConstraintAttribute) constraint.g.get(str);
            if (constraintAttribute != null && constraintAttribute.g()) {
                this.o.put(str, constraintAttribute);
            }
        }
    }

    /* renamed from: b */
    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.d, motionPaths.d);
    }

    public final boolean d(float f2, float f3) {
        return (Float.isNaN(f2) || Float.isNaN(f3)) ? Float.isNaN(f2) != Float.isNaN(f3) : Math.abs(f2 - f3) > 1.0E-6f;
    }

    public void f(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z) {
        boolean d2 = d(this.e, motionPaths.e);
        boolean d3 = d(this.f, motionPaths.f);
        zArr[0] = zArr[0] | d(this.d, motionPaths.d);
        boolean z2 = d2 | d3 | z;
        zArr[1] = zArr[1] | z2;
        zArr[2] = z2 | zArr[2];
        zArr[3] = zArr[3] | d(this.g, motionPaths.g);
        zArr[4] = d(this.h, motionPaths.h) | zArr[4];
    }

    public void g(double[] dArr, int[] iArr) {
        float[] fArr = {this.d, this.e, this.f, this.g, this.h, this.i};
        int i2 = 0;
        for (int i3 : iArr) {
            if (i3 < 6) {
                dArr[i2] = (double) fArr[i3];
                i2++;
            }
        }
    }

    public void h(double d2, int[] iArr, double[] dArr, float[] fArr, int i2) {
        int[] iArr2 = iArr;
        float f2 = this.e;
        float f3 = this.f;
        float f4 = this.g;
        float f5 = this.h;
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            float f6 = (float) dArr[i3];
            int i4 = iArr2[i3];
            if (i4 == 1) {
                f2 = f6;
            } else if (i4 == 2) {
                f3 = f6;
            } else if (i4 == 3) {
                f4 = f6;
            } else if (i4 == 4) {
                f5 = f6;
            }
        }
        MotionController motionController = this.n;
        if (motionController != null) {
            float[] fArr2 = new float[2];
            motionController.i(d2, fArr2, new float[2]);
            float f7 = fArr2[0];
            double d3 = (double) f2;
            double d4 = (double) f3;
            f3 = (float) ((((double) fArr2[1]) - (d3 * Math.cos(d4))) - ((double) (f5 / 2.0f)));
            f2 = (float) ((((double) f7) + (Math.sin(d4) * d3)) - ((double) (f4 / 2.0f)));
        }
        fArr[i2] = f2 + (f4 / 2.0f) + 0.0f;
        fArr[i2 + 1] = f3 + (f5 / 2.0f) + 0.0f;
    }

    public void i(double d2, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f2;
        float f3;
        int[] iArr2 = iArr;
        float f4 = this.e;
        float f5 = this.f;
        float f6 = this.g;
        float f7 = this.h;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            float f12 = (float) dArr[i2];
            float f13 = (float) dArr2[i2];
            int i3 = iArr2[i2];
            if (i3 == 1) {
                f4 = f12;
                f8 = f13;
            } else if (i3 == 2) {
                f5 = f12;
                f10 = f13;
            } else if (i3 == 3) {
                f6 = f12;
                f9 = f13;
            } else if (i3 == 4) {
                f7 = f12;
                f11 = f13;
            }
        }
        float f14 = (f9 / 2.0f) + f8;
        float f15 = (f11 / 2.0f) + f10;
        MotionController motionController = this.n;
        if (motionController != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motionController.i(d2, fArr3, fArr4);
            float f16 = fArr3[0];
            float f17 = fArr3[1];
            float f18 = fArr4[0];
            float f19 = fArr4[1];
            double d3 = (double) f4;
            double d4 = (double) f5;
            f2 = f6;
            float sin = (float) ((((double) f16) + (Math.sin(d4) * d3)) - ((double) (f6 / 2.0f)));
            double d5 = (double) f8;
            float cos = (float) ((((double) f17) - (d3 * Math.cos(d4))) - ((double) (f7 / 2.0f)));
            double d6 = (double) f10;
            f15 = (float) ((((double) f19) - (d5 * Math.cos(d4))) + (Math.sin(d4) * d6));
            f4 = sin;
            f5 = cos;
            f14 = (float) (((double) f18) + (Math.sin(d4) * d5) + (Math.cos(d4) * d6));
            f3 = 2.0f;
        } else {
            f2 = f6;
            f3 = 2.0f;
        }
        fArr[0] = f4 + (f2 / f3) + 0.0f;
        fArr[1] = f5 + (f7 / f3) + 0.0f;
        fArr2[0] = f14;
        fArr2[1] = f15;
    }

    public int j(String str, double[] dArr, int i2) {
        ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.o.get(str);
        int i3 = 0;
        if (constraintAttribute == null) {
            return 0;
        }
        if (constraintAttribute.h() == 1) {
            dArr[i2] = (double) constraintAttribute.e();
            return 1;
        }
        int h2 = constraintAttribute.h();
        float[] fArr = new float[h2];
        constraintAttribute.f(fArr);
        while (i3 < h2) {
            dArr[i2] = (double) fArr[i3];
            i3++;
            i2++;
        }
        return h2;
    }

    public int k(String str) {
        ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.o.get(str);
        if (constraintAttribute == null) {
            return 0;
        }
        return constraintAttribute.h();
    }

    public void l(int[] iArr, double[] dArr, float[] fArr, int i2) {
        float f2 = this.e;
        float f3 = this.f;
        float f4 = this.g;
        float f5 = this.h;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f6 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 1) {
                f2 = f6;
            } else if (i4 == 2) {
                f3 = f6;
            } else if (i4 == 3) {
                f4 = f6;
            } else if (i4 == 4) {
                f5 = f6;
            }
        }
        MotionController motionController = this.n;
        if (motionController != null) {
            float j2 = motionController.j();
            double d2 = (double) f2;
            double d3 = (double) f3;
            f3 = (float) ((((double) this.n.k()) - (d2 * Math.cos(d3))) - ((double) (f5 / 2.0f)));
            f2 = (float) ((((double) j2) + (Math.sin(d3) * d2)) - ((double) (f4 / 2.0f)));
        }
        float f7 = f4 + f2;
        float f8 = f5 + f3;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i2] = f2 + 0.0f;
        fArr[i2 + 1] = f3 + 0.0f;
        fArr[i2 + 2] = f7 + 0.0f;
        fArr[i2 + 3] = f3 + 0.0f;
        fArr[i2 + 4] = f7 + 0.0f;
        int i5 = i2 + 6;
        fArr[i2 + 5] = f8 + 0.0f;
        fArr[i5] = f2 + 0.0f;
        fArr[i2 + 7] = f8 + 0.0f;
    }

    public boolean m(String str) {
        return this.o.containsKey(str);
    }

    public void n(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        KeyPosition keyPosition2 = keyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f2 = ((float) keyPosition2.f553a) / 100.0f;
        this.c = f2;
        this.b = keyPosition2.j;
        float f3 = Float.isNaN(keyPosition2.k) ? f2 : keyPosition2.k;
        float f4 = Float.isNaN(keyPosition2.l) ? f2 : keyPosition2.l;
        float f5 = motionPaths4.g;
        float f6 = motionPaths3.g;
        float f7 = motionPaths4.h;
        float f8 = motionPaths3.h;
        this.d = this.c;
        float f9 = motionPaths3.e;
        float f10 = motionPaths3.f;
        float f11 = (motionPaths4.e + (f5 / 2.0f)) - ((f6 / 2.0f) + f9);
        float f12 = (motionPaths4.f + (f7 / 2.0f)) - (f10 + (f8 / 2.0f));
        float f13 = (f5 - f6) * f3;
        float f14 = f13 / 2.0f;
        this.e = (float) ((int) ((f9 + (f11 * f2)) - f14));
        float f15 = (f7 - f8) * f4;
        float f16 = f15 / 2.0f;
        this.f = (float) ((int) ((f10 + (f12 * f2)) - f16));
        this.g = (float) ((int) (f6 + f13));
        this.h = (float) ((int) (f8 + f15));
        KeyPosition keyPosition3 = keyPosition;
        float f17 = Float.isNaN(keyPosition3.m) ? f2 : keyPosition3.m;
        float f18 = 0.0f;
        float f19 = Float.isNaN(keyPosition3.p) ? 0.0f : keyPosition3.p;
        if (!Float.isNaN(keyPosition3.n)) {
            f2 = keyPosition3.n;
        }
        if (!Float.isNaN(keyPosition3.o)) {
            f18 = keyPosition3.o;
        }
        this.p = 0;
        MotionPaths motionPaths5 = motionPaths;
        this.e = (float) ((int) (((motionPaths5.e + (f17 * f11)) + (f18 * f12)) - f14));
        this.f = (float) ((int) (((motionPaths5.f + (f11 * f19)) + (f12 * f2)) - f16));
        this.f574a = Easing.c(keyPosition3.h);
        this.k = keyPosition3.i;
    }

    public void o(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        KeyPosition keyPosition2 = keyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f2 = ((float) keyPosition2.f553a) / 100.0f;
        this.c = f2;
        this.b = keyPosition2.j;
        float f3 = Float.isNaN(keyPosition2.k) ? f2 : keyPosition2.k;
        float f4 = Float.isNaN(keyPosition2.l) ? f2 : keyPosition2.l;
        float f5 = motionPaths4.g - motionPaths3.g;
        float f6 = motionPaths4.h - motionPaths3.h;
        this.d = this.c;
        if (!Float.isNaN(keyPosition2.m)) {
            f2 = keyPosition2.m;
        }
        float f7 = motionPaths3.e;
        float f8 = motionPaths3.g;
        float f9 = motionPaths3.f;
        float f10 = motionPaths3.h;
        float f11 = (motionPaths4.e + (motionPaths4.g / 2.0f)) - ((f8 / 2.0f) + f7);
        float f12 = (motionPaths4.f + (motionPaths4.h / 2.0f)) - ((f10 / 2.0f) + f9);
        float f13 = f11 * f2;
        float f14 = f5 * f3;
        float f15 = f14 / 2.0f;
        this.e = (float) ((int) ((f7 + f13) - f15));
        float f16 = f2 * f12;
        float f17 = f6 * f4;
        float f18 = f17 / 2.0f;
        this.f = (float) ((int) ((f9 + f16) - f18));
        this.g = (float) ((int) (f8 + f14));
        this.h = (float) ((int) (f10 + f17));
        KeyPosition keyPosition3 = keyPosition;
        float f19 = Float.isNaN(keyPosition3.n) ? 0.0f : keyPosition3.n;
        float f20 = (-f12) * f19;
        float f21 = f11 * f19;
        this.p = 1;
        MotionPaths motionPaths5 = motionPaths;
        this.e = ((float) ((int) ((motionPaths5.e + f13) - f15))) + f20;
        this.f = ((float) ((int) ((motionPaths5.f + f16) - f18))) + f21;
        this.l = this.l;
        this.f574a = Easing.c(keyPosition3.h);
        this.k = keyPosition3.i;
    }

    public void p(int i2, int i3, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f2;
        float f3;
        float f4 = ((float) keyPosition.f553a) / 100.0f;
        this.c = f4;
        this.b = keyPosition.j;
        this.p = keyPosition.q;
        float f5 = Float.isNaN(keyPosition.k) ? f4 : keyPosition.k;
        float f6 = Float.isNaN(keyPosition.l) ? f4 : keyPosition.l;
        float f7 = motionPaths2.g;
        float f8 = motionPaths.g;
        float f9 = motionPaths2.h;
        float f10 = motionPaths.h;
        this.d = this.c;
        this.g = (float) ((int) (f8 + ((f7 - f8) * f5)));
        this.h = (float) ((int) (f10 + ((f9 - f10) * f6)));
        int i4 = keyPosition.q;
        if (i4 == 1) {
            float f11 = Float.isNaN(keyPosition.m) ? f4 : keyPosition.m;
            float f12 = motionPaths2.e;
            float f13 = motionPaths.e;
            this.e = (f11 * (f12 - f13)) + f13;
            if (!Float.isNaN(keyPosition.n)) {
                f4 = keyPosition.n;
            }
            float f14 = motionPaths2.f;
            float f15 = motionPaths.f;
            this.f = (f4 * (f14 - f15)) + f15;
        } else if (i4 != 2) {
            float f16 = Float.isNaN(keyPosition.m) ? f4 : keyPosition.m;
            float f17 = motionPaths2.e;
            float f18 = motionPaths.e;
            this.e = (f16 * (f17 - f18)) + f18;
            if (!Float.isNaN(keyPosition.n)) {
                f4 = keyPosition.n;
            }
            float f19 = motionPaths2.f;
            float f20 = motionPaths.f;
            this.f = (f4 * (f19 - f20)) + f20;
        } else {
            if (Float.isNaN(keyPosition.m)) {
                float f21 = motionPaths2.e;
                float f22 = motionPaths.e;
                f2 = ((f21 - f22) * f4) + f22;
            } else {
                f2 = Math.min(f6, f5) * keyPosition.m;
            }
            this.e = f2;
            if (Float.isNaN(keyPosition.n)) {
                float f23 = motionPaths2.f;
                float f24 = motionPaths.f;
                f3 = (f4 * (f23 - f24)) + f24;
            } else {
                f3 = keyPosition.n;
            }
            this.f = f3;
        }
        this.l = motionPaths.l;
        this.f574a = Easing.c(keyPosition.h);
        this.k = keyPosition.i;
    }

    public void q(int i2, int i3, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        KeyPosition keyPosition2 = keyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f2 = ((float) keyPosition2.f553a) / 100.0f;
        this.c = f2;
        this.b = keyPosition2.j;
        float f3 = Float.isNaN(keyPosition2.k) ? f2 : keyPosition2.k;
        float f4 = Float.isNaN(keyPosition2.l) ? f2 : keyPosition2.l;
        float f5 = motionPaths4.g;
        float f6 = motionPaths3.g;
        float f7 = motionPaths4.h;
        float f8 = motionPaths3.h;
        this.d = this.c;
        float f9 = motionPaths3.e;
        float f10 = motionPaths3.f;
        float f11 = motionPaths4.e + (f5 / 2.0f);
        float f12 = motionPaths4.f + (f7 / 2.0f);
        float f13 = (f5 - f6) * f3;
        this.e = (float) ((int) ((f9 + ((f11 - ((f6 / 2.0f) + f9)) * f2)) - (f13 / 2.0f)));
        float f14 = (f7 - f8) * f4;
        this.f = (float) ((int) ((f10 + ((f12 - (f10 + (f8 / 2.0f))) * f2)) - (f14 / 2.0f)));
        this.g = (float) ((int) (f6 + f13));
        this.h = (float) ((int) (f8 + f14));
        this.p = 2;
        KeyPosition keyPosition3 = keyPosition;
        if (!Float.isNaN(keyPosition3.m)) {
            this.e = (float) ((int) (keyPosition3.m * ((float) ((int) (((float) i2) - this.g)))));
        }
        if (!Float.isNaN(keyPosition3.n)) {
            this.f = (float) ((int) (keyPosition3.n * ((float) ((int) (((float) i3) - this.h)))));
        }
        this.l = this.l;
        this.f574a = Easing.c(keyPosition3.h);
        this.k = keyPosition3.i;
    }

    public void r(float f2, float f3, float f4, float f5) {
        this.e = f2;
        this.f = f3;
        this.g = f4;
        this.h = f5;
    }

    public void s(float f2, float f3, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        int[] iArr2 = iArr;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            float f8 = (float) dArr[i2];
            double d2 = dArr2[i2];
            int i3 = iArr2[i2];
            if (i3 == 1) {
                f4 = f8;
            } else if (i3 == 2) {
                f6 = f8;
            } else if (i3 == 3) {
                f5 = f8;
            } else if (i3 == 4) {
                f7 = f8;
            }
        }
        float f9 = f4 - ((0.0f * f5) / 2.0f);
        float f10 = f6 - ((0.0f * f7) / 2.0f);
        fArr[0] = (f9 * (1.0f - f2)) + (((f5 * 1.0f) + f9) * f2) + 0.0f;
        fArr[1] = (f10 * (1.0f - f3)) + (((f7 * 1.0f) + f10) * f3) + 0.0f;
    }

    public void t(float f2, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3, boolean z) {
        float f3;
        float f4;
        View view2 = view;
        int[] iArr2 = iArr;
        double[] dArr4 = dArr2;
        float f5 = this.e;
        float f6 = this.f;
        float f7 = this.g;
        float f8 = this.h;
        if (iArr2.length != 0 && this.r.length <= iArr2[iArr2.length - 1]) {
            int i2 = iArr2[iArr2.length - 1] + 1;
            this.r = new double[i2];
            this.s = new double[i2];
        }
        Arrays.fill(this.r, Double.NaN);
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            double[] dArr5 = this.r;
            int i4 = iArr2[i3];
            dArr5[i4] = dArr[i3];
            this.s[i4] = dArr4[i3];
        }
        float f9 = Float.NaN;
        int i5 = 0;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        while (true) {
            double[] dArr6 = this.r;
            if (i5 >= dArr6.length) {
                break;
            }
            double d2 = 0.0d;
            if (!Double.isNaN(dArr6[i5]) || !(dArr3 == null || dArr3[i5] == 0.0d)) {
                if (dArr3 != null) {
                    d2 = dArr3[i5];
                }
                if (!Double.isNaN(this.r[i5])) {
                    d2 = this.r[i5] + d2;
                }
                f4 = f9;
                float f14 = (float) d2;
                float f15 = (float) this.s[i5];
                if (i5 == 1) {
                    f9 = f4;
                    f5 = f14;
                    f10 = f15;
                } else if (i5 == 2) {
                    f9 = f4;
                    f6 = f14;
                    f11 = f15;
                } else if (i5 == 3) {
                    f9 = f4;
                    f7 = f14;
                    f12 = f15;
                } else if (i5 == 4) {
                    f9 = f4;
                    f8 = f14;
                    f13 = f15;
                } else if (i5 == 5) {
                    f9 = f14;
                }
                i5++;
            } else {
                f4 = f9;
            }
            f9 = f4;
            i5++;
        }
        float f16 = f9;
        MotionController motionController = this.n;
        if (motionController != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motionController.i((double) f2, fArr, fArr2);
            float f17 = fArr[0];
            float f18 = fArr[1];
            float f19 = fArr2[0];
            float f20 = fArr2[1];
            double d3 = (double) f5;
            double d4 = (double) f6;
            double cos = ((double) f18) - (Math.cos(d4) * d3);
            f3 = f8;
            float sin = (float) ((((double) f17) + (Math.sin(d4) * d3)) - ((double) (f7 / 2.0f)));
            float f21 = (float) (cos - ((double) (f8 / 2.0f)));
            double d5 = (double) f10;
            double d6 = (double) f11;
            float sin2 = (float) (((double) f19) + (Math.sin(d4) * d5) + (Math.cos(d4) * d3 * d6));
            float f22 = sin;
            float cos2 = (float) ((((double) f20) - (d5 * Math.cos(d4))) + (d3 * Math.sin(d4) * d6));
            double[] dArr7 = dArr2;
            if (dArr7.length >= 2) {
                dArr7[0] = (double) sin2;
                dArr7[1] = (double) cos2;
            }
            if (!Float.isNaN(f16)) {
                view2.setRotation((float) (((double) f16) + Math.toDegrees(Math.atan2((double) cos2, (double) sin2))));
            }
            f5 = f22;
            f6 = f21;
        } else {
            float f23 = f16;
            f3 = f8;
            if (!Float.isNaN(f23)) {
                view2.setRotation((float) (((double) 0.0f) + ((double) f23) + Math.toDegrees(Math.atan2((double) (f11 + (f13 / 2.0f)), (double) (f10 + (f12 / 2.0f))))));
            }
        }
        if (view2 instanceof FloatLayout) {
            ((FloatLayout) view2).a(f5, f6, f7 + f5, f6 + f3);
            return;
        }
        float f24 = f5 + 0.5f;
        int i6 = (int) f24;
        float f25 = f6 + 0.5f;
        int i7 = (int) f25;
        int i8 = (int) (f24 + f7);
        int i9 = (int) (f25 + f3);
        int i10 = i8 - i6;
        int i11 = i9 - i7;
        if (!(i10 == view.getMeasuredWidth() && i11 == view.getMeasuredHeight() && !z)) {
            view2.measure(View.MeasureSpec.makeMeasureSpec(i10, 1073741824), View.MeasureSpec.makeMeasureSpec(i11, 1073741824));
        }
        view2.layout(i6, i7, i8, i9);
    }

    public void u(MotionController motionController, MotionPaths motionPaths) {
        double d2 = (double) (((this.e + (this.g / 2.0f)) - motionPaths.e) - (motionPaths.g / 2.0f));
        double d3 = (double) (((this.f + (this.h / 2.0f)) - motionPaths.f) - (motionPaths.h / 2.0f));
        this.n = motionController;
        this.e = (float) Math.hypot(d3, d2);
        if (Float.isNaN(this.m)) {
            this.f = (float) (Math.atan2(d3, d2) + 1.5707963267948966d);
        } else {
            this.f = (float) Math.toRadians((double) this.m);
        }
    }

    public MotionPaths(int i2, int i3, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        int i4 = Key.f;
        this.k = i4;
        this.l = i4;
        this.m = Float.NaN;
        this.n = null;
        this.o = new LinkedHashMap();
        this.p = 0;
        this.r = new double[18];
        this.s = new double[18];
        if (motionPaths.l != Key.f) {
            p(i2, i3, keyPosition, motionPaths, motionPaths2);
            return;
        }
        int i5 = keyPosition.q;
        if (i5 == 1) {
            o(keyPosition, motionPaths, motionPaths2);
        } else if (i5 != 2) {
            n(keyPosition, motionPaths, motionPaths2);
        } else {
            q(i2, i3, keyPosition, motionPaths, motionPaths2);
        }
    }
}
