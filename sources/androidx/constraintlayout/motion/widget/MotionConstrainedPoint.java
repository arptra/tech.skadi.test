package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.geetest.sdk.x;
import com.meizu.common.datetimepicker.date.MonthView;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    public static String[] D = {"position", x.f, "y", MonthView.VIEW_PARAMS_WIDTH, MonthView.VIEW_PARAMS_HEIGHT, "pathRotate"};
    public int A = 0;
    public double[] B = new double[18];
    public double[] C = new double[18];

    /* renamed from: a  reason: collision with root package name */
    public float f560a = 1.0f;
    public int b = 0;
    public int c;
    public boolean d = false;
    public float e = 0.0f;
    public float f = 0.0f;
    public float g = 0.0f;
    public float h = 0.0f;
    public float i = 1.0f;
    public float j = 1.0f;
    public float k = Float.NaN;
    public float l = Float.NaN;
    public float m = 0.0f;
    public float n = 0.0f;
    public float o = 0.0f;
    public Easing p;
    public int q = 0;
    public float r;
    public float s;
    public float t;
    public float u;
    public float v;
    public float w = Float.NaN;
    public float x = Float.NaN;
    public int y = -1;
    public LinkedHashMap z = new LinkedHashMap();

    public void a(HashMap hashMap, int i2) {
        for (String str : hashMap.keySet()) {
            ViewSpline viewSpline = (ViewSpline) hashMap.get(str);
            str.hashCode();
            float f2 = 1.0f;
            float f3 = 0.0f;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1001078227:
                    if (str.equals(PayloadConstant.PARAMS_KEY_INT_OTA_PROGRESS)) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -760884510:
                    if (str.equals("transformPivotX")) {
                        c2 = 8;
                        break;
                    }
                    break;
                case -760884509:
                    if (str.equals("transformPivotY")) {
                        c2 = 9;
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        c2 = 10;
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        c2 = 12;
                        break;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        c2 = 13;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    if (!Float.isNaN(this.g)) {
                        f3 = this.g;
                    }
                    viewSpline.c(i2, f3);
                    break;
                case 1:
                    if (!Float.isNaN(this.h)) {
                        f3 = this.h;
                    }
                    viewSpline.c(i2, f3);
                    break;
                case 2:
                    if (!Float.isNaN(this.m)) {
                        f3 = this.m;
                    }
                    viewSpline.c(i2, f3);
                    break;
                case 3:
                    if (!Float.isNaN(this.n)) {
                        f3 = this.n;
                    }
                    viewSpline.c(i2, f3);
                    break;
                case 4:
                    if (!Float.isNaN(this.o)) {
                        f3 = this.o;
                    }
                    viewSpline.c(i2, f3);
                    break;
                case 5:
                    if (!Float.isNaN(this.x)) {
                        f3 = this.x;
                    }
                    viewSpline.c(i2, f3);
                    break;
                case 6:
                    if (!Float.isNaN(this.i)) {
                        f2 = this.i;
                    }
                    viewSpline.c(i2, f2);
                    break;
                case 7:
                    if (!Float.isNaN(this.j)) {
                        f2 = this.j;
                    }
                    viewSpline.c(i2, f2);
                    break;
                case 8:
                    if (!Float.isNaN(this.k)) {
                        f3 = this.k;
                    }
                    viewSpline.c(i2, f3);
                    break;
                case 9:
                    if (!Float.isNaN(this.l)) {
                        f3 = this.l;
                    }
                    viewSpline.c(i2, f3);
                    break;
                case 10:
                    if (!Float.isNaN(this.f)) {
                        f3 = this.f;
                    }
                    viewSpline.c(i2, f3);
                    break;
                case 11:
                    if (!Float.isNaN(this.e)) {
                        f3 = this.e;
                    }
                    viewSpline.c(i2, f3);
                    break;
                case 12:
                    if (!Float.isNaN(this.w)) {
                        f3 = this.w;
                    }
                    viewSpline.c(i2, f3);
                    break;
                case 13:
                    if (!Float.isNaN(this.f560a)) {
                        f2 = this.f560a;
                    }
                    viewSpline.c(i2, f2);
                    break;
                default:
                    if (!str.startsWith("CUSTOM")) {
                        Log.e("MotionPaths", "UNKNOWN spline " + str);
                        break;
                    } else {
                        String str2 = str.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA)[1];
                        if (!this.z.containsKey(str2)) {
                            break;
                        } else {
                            ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.z.get(str2);
                            if (!(viewSpline instanceof ViewSpline.CustomSet)) {
                                Log.e("MotionPaths", str + " ViewSpline not a CustomSet frame = " + i2 + ", value" + constraintAttribute.e() + viewSpline);
                                break;
                            } else {
                                ((ViewSpline.CustomSet) viewSpline).i(i2, constraintAttribute);
                                break;
                            }
                        }
                    }
            }
        }
    }

    public void b(View view) {
        this.c = view.getVisibility();
        this.f560a = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.d = false;
        this.e = view.getElevation();
        this.f = view.getRotation();
        this.g = view.getRotationX();
        this.h = view.getRotationY();
        this.i = view.getScaleX();
        this.j = view.getScaleY();
        this.k = view.getPivotX();
        this.l = view.getPivotY();
        this.m = view.getTranslationX();
        this.n = view.getTranslationY();
        this.o = view.getTranslationZ();
    }

    public void d(ConstraintSet.Constraint constraint) {
        ConstraintSet.PropertySet propertySet = constraint.c;
        int i2 = propertySet.c;
        this.b = i2;
        int i3 = propertySet.b;
        this.c = i3;
        this.f560a = (i3 == 0 || i2 != 0) ? propertySet.d : 0.0f;
        ConstraintSet.Transform transform = constraint.f;
        this.d = transform.m;
        this.e = transform.n;
        this.f = transform.b;
        this.g = transform.c;
        this.h = transform.d;
        this.i = transform.e;
        this.j = transform.f;
        this.k = transform.g;
        this.l = transform.h;
        this.m = transform.j;
        this.n = transform.k;
        this.o = transform.l;
        this.p = Easing.c(constraint.d.d);
        ConstraintSet.Motion motion = constraint.d;
        this.w = motion.i;
        this.q = motion.f;
        this.y = motion.b;
        this.x = constraint.c.e;
        for (String str : constraint.g.keySet()) {
            ConstraintAttribute constraintAttribute = (ConstraintAttribute) constraint.g.get(str);
            if (constraintAttribute.g()) {
                this.z.put(str, constraintAttribute);
            }
        }
    }

    /* renamed from: f */
    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.r, motionConstrainedPoint.r);
    }

    public final boolean g(float f2, float f3) {
        return (Float.isNaN(f2) || Float.isNaN(f3)) ? Float.isNaN(f2) != Float.isNaN(f3) : Math.abs(f2 - f3) > 1.0E-6f;
    }

    public void h(MotionConstrainedPoint motionConstrainedPoint, HashSet hashSet) {
        if (g(this.f560a, motionConstrainedPoint.f560a)) {
            hashSet.add("alpha");
        }
        if (g(this.e, motionConstrainedPoint.e)) {
            hashSet.add("elevation");
        }
        int i2 = this.c;
        int i3 = motionConstrainedPoint.c;
        if (i2 != i3 && this.b == 0 && (i2 == 0 || i3 == 0)) {
            hashSet.add("alpha");
        }
        if (g(this.f, motionConstrainedPoint.f)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.w) || !Float.isNaN(motionConstrainedPoint.w)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.x) || !Float.isNaN(motionConstrainedPoint.x)) {
            hashSet.add(PayloadConstant.PARAMS_KEY_INT_OTA_PROGRESS);
        }
        if (g(this.g, motionConstrainedPoint.g)) {
            hashSet.add("rotationX");
        }
        if (g(this.h, motionConstrainedPoint.h)) {
            hashSet.add("rotationY");
        }
        if (g(this.k, motionConstrainedPoint.k)) {
            hashSet.add("transformPivotX");
        }
        if (g(this.l, motionConstrainedPoint.l)) {
            hashSet.add("transformPivotY");
        }
        if (g(this.i, motionConstrainedPoint.i)) {
            hashSet.add("scaleX");
        }
        if (g(this.j, motionConstrainedPoint.j)) {
            hashSet.add("scaleY");
        }
        if (g(this.m, motionConstrainedPoint.m)) {
            hashSet.add("translationX");
        }
        if (g(this.n, motionConstrainedPoint.n)) {
            hashSet.add("translationY");
        }
        if (g(this.o, motionConstrainedPoint.o)) {
            hashSet.add("translationZ");
        }
    }

    public void i(float f2, float f3, float f4, float f5) {
        this.s = f2;
        this.t = f3;
        this.u = f4;
        this.v = f5;
    }

    public void j(Rect rect, View view, int i2, float f2) {
        i((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        b(view);
        this.k = Float.NaN;
        this.l = Float.NaN;
        if (i2 == 1) {
            this.f = f2 - 90.0f;
        } else if (i2 == 2) {
            this.f = f2 + 90.0f;
        }
    }

    public void k(Rect rect, ConstraintSet constraintSet, int i2, int i3) {
        i((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        d(constraintSet.z(i3));
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return;
                    }
                }
            }
            float f2 = this.f + 90.0f;
            this.f = f2;
            if (f2 > 180.0f) {
                this.f = f2 - 360.0f;
                return;
            }
            return;
        }
        this.f -= 90.0f;
    }

    public void l(View view) {
        i(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        b(view);
    }
}
