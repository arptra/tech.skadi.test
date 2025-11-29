package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.Placeholder;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import androidx.core.view.NestedScrollingParent3;
import com.honey.account.constant.AccountConstantKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    public static boolean K0;
    public StopLogic A = new StopLogic();
    public int A0;
    public DecelerateInterpolator B = new DecelerateInterpolator();
    public Rect B0 = new Rect();
    public DesignTool C;
    public boolean C0 = false;
    public boolean D = true;
    public TransitionState D0 = TransitionState.UNDEFINED;
    public int E;
    public Model E0 = new Model();
    public int F;
    public boolean F0 = false;
    public int G;
    public RectF G0 = new RectF();
    public int H;
    public View H0 = null;
    public boolean I = false;
    public Matrix I0 = null;
    public float J;
    public ArrayList J0 = new ArrayList();
    public float K;
    public long L;
    public float M;
    public boolean N = false;
    public ArrayList O = null;
    public ArrayList P = null;
    public ArrayList Q = null;
    public CopyOnWriteArrayList R = null;
    public int S = 0;
    public long T = -1;
    public float U = 0.0f;
    public int V = 0;
    public float W = 0.0f;

    /* renamed from: a  reason: collision with root package name */
    public MotionScene f563a;
    public Interpolator b;
    public Interpolator c = null;
    public float d = 0.0f;
    public int e = -1;
    public int f = -1;
    public int g = -1;
    public boolean g0 = false;
    public int h = 0;
    public boolean h0 = false;
    public int i = 0;
    public int i0;
    public boolean j = true;
    public int j0;
    public HashMap k = new HashMap();
    public int k0;
    public long l = 0;
    public int l0;
    public float m = 1.0f;
    public int m0;
    public float n = 0.0f;
    public int n0;
    public float o = 0.0f;
    public float o0;
    public long p;
    public KeyCache p0 = new KeyCache();
    public float q = 0.0f;
    public boolean q0 = false;
    public boolean r;
    public StateCache r0;
    public boolean s = false;
    public Runnable s0 = null;
    public boolean t = false;
    public int[] t0 = null;
    public TransitionListener u;
    public int u0 = 0;
    public float v;
    public boolean v0 = false;
    public float w;
    public int w0 = 0;
    public int x = 0;
    public HashMap x0 = new HashMap();
    public DevModeDraw y;
    public int y0;
    public boolean z = false;
    public int z0;

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$2  reason: invalid class name */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MotionLayout f565a;

        public void run() {
            boolean unused = this.f565a.v0 = false;
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f568a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState[] r0 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f568a = r0
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f568a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.SETUP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f568a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f568a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.AnonymousClass5.<clinit>():void");
        }
    }

    public class DecelerateInterpolator extends MotionInterpolator {

        /* renamed from: a  reason: collision with root package name */
        public float f569a = 0.0f;
        public float b = 0.0f;
        public float c;

        public DecelerateInterpolator() {
        }

        public float a() {
            return MotionLayout.this.d;
        }

        public void b(float f, float f2, float f3) {
            this.f569a = f;
            this.b = f2;
            this.c = f3;
        }

        public float getInterpolation(float f) {
            float f2;
            float f3;
            float f4 = this.f569a;
            if (f4 > 0.0f) {
                float f5 = this.c;
                if (f4 / f5 < f) {
                    f = f4 / f5;
                }
                MotionLayout.this.d = f4 - (f5 * f);
                f2 = (f4 * f) - (((f5 * f) * f) / 2.0f);
                f3 = this.b;
            } else {
                float f6 = this.c;
                if ((-f4) / f6 < f) {
                    f = (-f4) / f6;
                }
                MotionLayout.this.d = (f6 * f) + f4;
                f2 = (f4 * f) + (((f6 * f) * f) / 2.0f);
                f3 = this.b;
            }
            return f2 + f3;
        }
    }

    public class DevModeDraw {

        /* renamed from: a  reason: collision with root package name */
        public float[] f570a;
        public int[] b;
        public float[] c;
        public Path d;
        public Paint e;
        public Paint f;
        public Paint g;
        public Paint h;
        public Paint i;
        public float[] j;
        public final int k = -21965;
        public final int l = -2067046;
        public final int m = -13391360;
        public final int n = 1996488704;
        public final int o = 10;
        public DashPathEffect p;
        public int q;
        public Rect r = new Rect();
        public boolean s = false;
        public int t = 1;

        public DevModeDraw() {
            Paint paint = new Paint();
            this.e = paint;
            paint.setAntiAlias(true);
            this.e.setColor(-21965);
            this.e.setStrokeWidth(2.0f);
            Paint paint2 = this.e;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            Paint paint3 = new Paint();
            this.f = paint3;
            paint3.setAntiAlias(true);
            this.f.setColor(-2067046);
            this.f.setStrokeWidth(2.0f);
            this.f.setStyle(style);
            Paint paint4 = new Paint();
            this.g = paint4;
            paint4.setAntiAlias(true);
            this.g.setColor(-13391360);
            this.g.setStrokeWidth(2.0f);
            this.g.setStyle(style);
            Paint paint5 = new Paint();
            this.h = paint5;
            paint5.setAntiAlias(true);
            this.h.setColor(-13391360);
            this.h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.j = new float[8];
            Paint paint6 = new Paint();
            this.i = paint6;
            paint6.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.p = dashPathEffect;
            this.g.setPathEffect(dashPathEffect);
            this.c = new float[100];
            this.b = new int[50];
            if (this.s) {
                this.e.setStrokeWidth(8.0f);
                this.i.setStrokeWidth(8.0f);
                this.f.setStrokeWidth(8.0f);
                this.t = 4;
            }
        }

        public void a(Canvas canvas, HashMap hashMap, int i2, int i3) {
            if (hashMap != null && hashMap.size() != 0) {
                canvas.save();
                if (!MotionLayout.this.isInEditMode() && (i3 & 1) == 2) {
                    String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.g) + AccountConstantKt.CODE_SEPARTOR + MotionLayout.this.getProgress();
                    canvas.drawText(str, 10.0f, (float) (MotionLayout.this.getHeight() - 30), this.h);
                    canvas.drawText(str, 11.0f, (float) (MotionLayout.this.getHeight() - 29), this.e);
                }
                for (MotionController motionController : hashMap.values()) {
                    int m2 = motionController.m();
                    if (i3 > 0 && m2 == 0) {
                        m2 = 1;
                    }
                    if (m2 != 0) {
                        this.q = motionController.c(this.c, this.b);
                        if (m2 >= 1) {
                            int i4 = i2 / 16;
                            float[] fArr = this.f570a;
                            if (fArr == null || fArr.length != i4 * 2) {
                                this.f570a = new float[(i4 * 2)];
                                this.d = new Path();
                            }
                            int i5 = this.t;
                            canvas.translate((float) i5, (float) i5);
                            this.e.setColor(1996488704);
                            this.i.setColor(1996488704);
                            this.f.setColor(1996488704);
                            this.g.setColor(1996488704);
                            motionController.d(this.f570a, i4);
                            b(canvas, m2, this.q, motionController);
                            this.e.setColor(-21965);
                            this.f.setColor(-2067046);
                            this.i.setColor(-2067046);
                            this.g.setColor(-13391360);
                            int i6 = this.t;
                            canvas.translate((float) (-i6), (float) (-i6));
                            b(canvas, m2, this.q, motionController);
                            if (m2 == 5) {
                                j(canvas, motionController);
                            }
                        }
                    }
                }
                canvas.restore();
            }
        }

        public void b(Canvas canvas, int i2, int i3, MotionController motionController) {
            if (i2 == 4) {
                d(canvas);
            }
            if (i2 == 2) {
                g(canvas);
            }
            if (i2 == 3) {
                e(canvas);
            }
            c(canvas);
            k(canvas, i2, i3, motionController);
        }

        public final void c(Canvas canvas) {
            canvas.drawLines(this.f570a, this.e);
        }

        public final void d(Canvas canvas) {
            boolean z = false;
            boolean z2 = false;
            for (int i2 = 0; i2 < this.q; i2++) {
                int i3 = this.b[i2];
                if (i3 == 1) {
                    z = true;
                }
                if (i3 == 0) {
                    z2 = true;
                }
            }
            if (z) {
                g(canvas);
            }
            if (z2) {
                e(canvas);
            }
        }

        public final void e(Canvas canvas) {
            float[] fArr = this.f570a;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[fArr.length - 2];
            float f5 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f2, f4), Math.max(f3, f5), Math.max(f2, f4), Math.max(f3, f5), this.g);
            canvas.drawLine(Math.min(f2, f4), Math.min(f3, f5), Math.min(f2, f4), Math.max(f3, f5), this.g);
        }

        public final void f(Canvas canvas, float f2, float f3) {
            Canvas canvas2 = canvas;
            float[] fArr = this.f570a;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[fArr.length - 2];
            float f7 = fArr[fArr.length - 1];
            float min = Math.min(f4, f6);
            float max = Math.max(f5, f7);
            float min2 = f2 - Math.min(f4, f6);
            float max2 = Math.max(f5, f7) - f3;
            String str = "" + (((float) ((int) (((double) ((min2 * 100.0f) / Math.abs(f6 - f4))) + 0.5d))) / 100.0f);
            l(str, this.h);
            canvas2.drawText(str, ((min2 / 2.0f) - ((float) (this.r.width() / 2))) + min, f3 - 20.0f, this.h);
            canvas.drawLine(f2, f3, Math.min(f4, f6), f3, this.g);
            String str2 = "" + (((float) ((int) (((double) ((max2 * 100.0f) / Math.abs(f7 - f5))) + 0.5d))) / 100.0f);
            l(str2, this.h);
            canvas2.drawText(str2, f2 + 5.0f, max - ((max2 / 2.0f) - ((float) (this.r.height() / 2))), this.h);
            canvas.drawLine(f2, f3, f2, Math.max(f5, f7), this.g);
        }

        public final void g(Canvas canvas) {
            float[] fArr = this.f570a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.g);
        }

        public final void h(Canvas canvas, float f2, float f3) {
            float[] fArr = this.f570a;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[fArr.length - 2];
            float f7 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot((double) (f4 - f6), (double) (f5 - f7));
            float f8 = f6 - f4;
            float f9 = f7 - f5;
            float f10 = (((f2 - f4) * f8) + ((f3 - f5) * f9)) / (hypot * hypot);
            float f11 = f4 + (f8 * f10);
            float f12 = f5 + (f10 * f9);
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f11, f12);
            float hypot2 = (float) Math.hypot((double) (f11 - f2), (double) (f12 - f3));
            String str = "" + (((float) ((int) ((hypot2 * 100.0f) / hypot))) / 100.0f);
            l(str, this.h);
            canvas.drawTextOnPath(str, path, (hypot2 / 2.0f) - ((float) (this.r.width() / 2)), -20.0f, this.h);
            canvas.drawLine(f2, f3, f11, f12, this.g);
        }

        public final void i(Canvas canvas, float f2, float f3, int i2, int i3) {
            Canvas canvas2 = canvas;
            String str = "" + (((float) ((int) (((double) (((f2 - ((float) (i2 / 2))) * 100.0f) / ((float) (MotionLayout.this.getWidth() - i2)))) + 0.5d))) / 100.0f);
            l(str, this.h);
            canvas2.drawText(str, ((f2 / 2.0f) - ((float) (this.r.width() / 2))) + 0.0f, f3 - 20.0f, this.h);
            canvas.drawLine(f2, f3, Math.min(0.0f, 1.0f), f3, this.g);
            String str2 = "" + (((float) ((int) (((double) (((f3 - ((float) (i3 / 2))) * 100.0f) / ((float) (MotionLayout.this.getHeight() - i3)))) + 0.5d))) / 100.0f);
            l(str2, this.h);
            canvas2.drawText(str2, f2 + 5.0f, 0.0f - ((f3 / 2.0f) - ((float) (this.r.height() / 2))), this.h);
            canvas.drawLine(f2, f3, f2, Math.max(0.0f, 1.0f), this.g);
        }

        public final void j(Canvas canvas, MotionController motionController) {
            this.d.reset();
            for (int i2 = 0; i2 <= 50; i2++) {
                motionController.e(((float) i2) / ((float) 50), this.j, 0);
                Path path = this.d;
                float[] fArr = this.j;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.d;
                float[] fArr2 = this.j;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.d;
                float[] fArr3 = this.j;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.d;
                float[] fArr4 = this.j;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.d.close();
            }
            this.e.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.d, this.e);
            canvas.translate(-2.0f, -2.0f);
            this.e.setColor(-65536);
            canvas.drawPath(this.d, this.e);
        }

        public final void k(Canvas canvas, int i2, int i3, MotionController motionController) {
            int i4;
            int i5;
            float f2;
            float f3;
            Canvas canvas2 = canvas;
            int i6 = i2;
            MotionController motionController2 = motionController;
            View view = motionController2.b;
            if (view != null) {
                i5 = view.getWidth();
                i4 = motionController2.b.getHeight();
            } else {
                i5 = 0;
                i4 = 0;
            }
            for (int i7 = 1; i7 < i3 - 1; i7++) {
                if (i6 != 4 || this.b[i7 - 1] != 0) {
                    float[] fArr = this.c;
                    int i8 = i7 * 2;
                    float f4 = fArr[i8];
                    float f5 = fArr[i8 + 1];
                    this.d.reset();
                    this.d.moveTo(f4, f5 + 10.0f);
                    this.d.lineTo(f4 + 10.0f, f5);
                    this.d.lineTo(f4, f5 - 10.0f);
                    this.d.lineTo(f4 - 10.0f, f5);
                    this.d.close();
                    int i9 = i7 - 1;
                    motionController2.q(i9);
                    if (i6 == 4) {
                        int i10 = this.b[i9];
                        if (i10 == 1) {
                            h(canvas2, f4 - 0.0f, f5 - 0.0f);
                        } else if (i10 == 0) {
                            f(canvas2, f4 - 0.0f, f5 - 0.0f);
                        } else if (i10 == 2) {
                            f3 = f5;
                            f2 = f4;
                            i(canvas, f4 - 0.0f, f5 - 0.0f, i5, i4);
                            canvas2.drawPath(this.d, this.i);
                        }
                        f3 = f5;
                        f2 = f4;
                        canvas2.drawPath(this.d, this.i);
                    } else {
                        f3 = f5;
                        f2 = f4;
                    }
                    if (i6 == 2) {
                        h(canvas2, f2 - 0.0f, f3 - 0.0f);
                    }
                    if (i6 == 3) {
                        f(canvas2, f2 - 0.0f, f3 - 0.0f);
                    }
                    if (i6 == 6) {
                        i(canvas, f2 - 0.0f, f3 - 0.0f, i5, i4);
                    }
                    canvas2.drawPath(this.d, this.i);
                }
            }
            float[] fArr2 = this.f570a;
            if (fArr2.length > 1) {
                canvas2.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f);
                float[] fArr3 = this.f570a;
                canvas2.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f);
            }
        }

        public void l(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.r);
        }
    }

    public class Model {

        /* renamed from: a  reason: collision with root package name */
        public ConstraintWidgetContainer f571a = new ConstraintWidgetContainer();
        public ConstraintWidgetContainer b = new ConstraintWidgetContainer();
        public ConstraintSet c = null;
        public ConstraintSet d = null;
        public int e;
        public int f;

        public Model() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x00e8  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x013c A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r18 = this;
                r0 = r18
                androidx.constraintlayout.motion.widget.MotionLayout r1 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r1 = r1.getChildCount()
                androidx.constraintlayout.motion.widget.MotionLayout r2 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap r2 = r2.k
                r2.clear()
                android.util.SparseArray r2 = new android.util.SparseArray
                r2.<init>()
                int[] r3 = new int[r1]
                r5 = 0
            L_0x0017:
                if (r5 >= r1) goto L_0x0037
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.view.View r6 = r6.getChildAt(r5)
                androidx.constraintlayout.motion.widget.MotionController r7 = new androidx.constraintlayout.motion.widget.MotionController
                r7.<init>(r6)
                int r8 = r6.getId()
                r3[r5] = r8
                r2.put(r8, r7)
                androidx.constraintlayout.motion.widget.MotionLayout r8 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap r8 = r8.k
                r8.put(r6, r7)
                int r5 = r5 + 1
                goto L_0x0017
            L_0x0037:
                r5 = 0
            L_0x0038:
                if (r5 >= r1) goto L_0x0142
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.view.View r6 = r6.getChildAt(r5)
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap r7 = r7.k
                java.lang.Object r7 = r7.get(r6)
                r13 = r7
                androidx.constraintlayout.motion.widget.MotionController r13 = (androidx.constraintlayout.motion.widget.MotionController) r13
                if (r13 != 0) goto L_0x0051
                r16 = r2
                goto L_0x013c
            L_0x0051:
                androidx.constraintlayout.widget.ConstraintSet r7 = r0.c
                java.lang.String r14 = ")"
                java.lang.String r15 = " ("
                java.lang.String r12 = "no widget for  "
                java.lang.String r11 = "MotionLayout"
                if (r7 == 0) goto L_0x00b6
                androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r7 = r0.f571a
                androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r0.d(r7, r6)
                if (r7 == 0) goto L_0x007d
                androidx.constraintlayout.motion.widget.MotionLayout r8 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.graphics.Rect r7 = r8.g0(r7)
                androidx.constraintlayout.widget.ConstraintSet r8 = r0.c
                androidx.constraintlayout.motion.widget.MotionLayout r9 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r9 = r9.getWidth()
                androidx.constraintlayout.motion.widget.MotionLayout r10 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r10 = r10.getHeight()
                r13.F(r7, r8, r9, r10)
                goto L_0x00b1
            L_0x007d:
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r7 = r7.x
                if (r7 == 0) goto L_0x00b1
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = androidx.constraintlayout.motion.widget.Debug.b()
                r7.append(r8)
                r7.append(r12)
                java.lang.String r8 = androidx.constraintlayout.motion.widget.Debug.d(r6)
                r7.append(r8)
                r7.append(r15)
                java.lang.Class r8 = r6.getClass()
                java.lang.String r8 = r8.getName()
                r7.append(r8)
                r7.append(r14)
                java.lang.String r7 = r7.toString()
                android.util.Log.e(r11, r7)
            L_0x00b1:
                r16 = r2
                r4 = r11
                r2 = r12
                goto L_0x00e4
            L_0x00b6:
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                boolean r7 = r7.v0
                if (r7 == 0) goto L_0x00b1
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap r7 = r7.x0
                java.lang.Object r7 = r7.get(r6)
                r8 = r7
                androidx.constraintlayout.motion.utils.ViewState r8 = (androidx.constraintlayout.motion.utils.ViewState) r8
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r10 = r7.w0
                int r16 = r7.y0
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r17 = r7.z0
                r7 = r13
                r9 = r6
                r4 = r11
                r11 = r16
                r16 = r2
                r2 = r12
                r12 = r17
                r7.G(r8, r9, r10, r11, r12)
            L_0x00e4:
                androidx.constraintlayout.widget.ConstraintSet r7 = r0.d
                if (r7 == 0) goto L_0x013c
                androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r7 = r0.b
                androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r0.d(r7, r6)
                if (r7 == 0) goto L_0x0108
                androidx.constraintlayout.motion.widget.MotionLayout r2 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.graphics.Rect r2 = r2.g0(r7)
                androidx.constraintlayout.widget.ConstraintSet r4 = r0.d
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r6 = r6.getWidth()
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r7 = r7.getHeight()
                r13.C(r2, r4, r6, r7)
                goto L_0x013c
            L_0x0108:
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r7 = r7.x
                if (r7 == 0) goto L_0x013c
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = androidx.constraintlayout.motion.widget.Debug.b()
                r7.append(r8)
                r7.append(r2)
                java.lang.String r2 = androidx.constraintlayout.motion.widget.Debug.d(r6)
                r7.append(r2)
                r7.append(r15)
                java.lang.Class r2 = r6.getClass()
                java.lang.String r2 = r2.getName()
                r7.append(r2)
                r7.append(r14)
                java.lang.String r2 = r7.toString()
                android.util.Log.e(r4, r2)
            L_0x013c:
                int r5 = r5 + 1
                r2 = r16
                goto L_0x0038
            L_0x0142:
                r16 = r2
                r4 = 0
            L_0x0145:
                if (r4 >= r1) goto L_0x0166
                r0 = r3[r4]
                r2 = r16
                java.lang.Object r0 = r2.get(r0)
                androidx.constraintlayout.motion.widget.MotionController r0 = (androidx.constraintlayout.motion.widget.MotionController) r0
                int r5 = r0.h()
                r6 = -1
                if (r5 == r6) goto L_0x0161
                java.lang.Object r5 = r2.get(r5)
                androidx.constraintlayout.motion.widget.MotionController r5 = (androidx.constraintlayout.motion.widget.MotionController) r5
                r0.J(r5)
            L_0x0161:
                int r4 = r4 + 1
                r16 = r2
                goto L_0x0145
            L_0x0166:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.Model.a():void");
        }

        public final void b(int i, int i2) {
            int optimizationLevel = MotionLayout.this.getOptimizationLevel();
            MotionLayout motionLayout = MotionLayout.this;
            if (motionLayout.f == motionLayout.getStartState()) {
                MotionLayout motionLayout2 = MotionLayout.this;
                ConstraintWidgetContainer constraintWidgetContainer = this.b;
                ConstraintSet constraintSet = this.d;
                motionLayout2.resolveSystem(constraintWidgetContainer, optimizationLevel, (constraintSet == null || constraintSet.d == 0) ? i : i2, (constraintSet == null || constraintSet.d == 0) ? i2 : i);
                ConstraintSet constraintSet2 = this.c;
                if (constraintSet2 != null) {
                    MotionLayout motionLayout3 = MotionLayout.this;
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.f571a;
                    int i3 = constraintSet2.d;
                    int i4 = i3 == 0 ? i : i2;
                    if (i3 == 0) {
                        i = i2;
                    }
                    motionLayout3.resolveSystem(constraintWidgetContainer2, optimizationLevel, i4, i);
                    return;
                }
                return;
            }
            ConstraintSet constraintSet3 = this.c;
            if (constraintSet3 != null) {
                MotionLayout motionLayout4 = MotionLayout.this;
                ConstraintWidgetContainer constraintWidgetContainer3 = this.f571a;
                int i5 = constraintSet3.d;
                motionLayout4.resolveSystem(constraintWidgetContainer3, optimizationLevel, i5 == 0 ? i : i2, i5 == 0 ? i2 : i);
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            ConstraintWidgetContainer constraintWidgetContainer4 = this.b;
            ConstraintSet constraintSet4 = this.d;
            int i6 = (constraintSet4 == null || constraintSet4.d == 0) ? i : i2;
            if (constraintSet4 == null || constraintSet4.d == 0) {
                i = i2;
            }
            motionLayout5.resolveSystem(constraintWidgetContainer4, optimizationLevel, i6, i);
        }

        public void c(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidgetContainer constraintWidgetContainer2) {
            ArrayList v1 = constraintWidgetContainer.v1();
            HashMap hashMap = new HashMap();
            hashMap.put(constraintWidgetContainer, constraintWidgetContainer2);
            constraintWidgetContainer2.v1().clear();
            constraintWidgetContainer2.n(constraintWidgetContainer, hashMap);
            Iterator it = v1.iterator();
            while (it.hasNext()) {
                ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
                ConstraintWidget barrier = constraintWidget instanceof Barrier ? new Barrier() : constraintWidget instanceof Guideline ? new Guideline() : constraintWidget instanceof Flow ? new Flow() : constraintWidget instanceof Placeholder ? new Placeholder() : constraintWidget instanceof Helper ? new HelperWidget() : new ConstraintWidget();
                constraintWidgetContainer2.a(barrier);
                hashMap.put(constraintWidget, barrier);
            }
            Iterator it2 = v1.iterator();
            while (it2.hasNext()) {
                ConstraintWidget constraintWidget2 = (ConstraintWidget) it2.next();
                ((ConstraintWidget) hashMap.get(constraintWidget2)).n(constraintWidget2, hashMap);
            }
        }

        public ConstraintWidget d(ConstraintWidgetContainer constraintWidgetContainer, View view) {
            if (constraintWidgetContainer.u() == view) {
                return constraintWidgetContainer;
            }
            ArrayList v1 = constraintWidgetContainer.v1();
            int size = v1.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = (ConstraintWidget) v1.get(i);
                if (constraintWidget.u() == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        public void e(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
            this.c = constraintSet;
            this.d = constraintSet2;
            this.f571a = new ConstraintWidgetContainer();
            this.b = new ConstraintWidgetContainer();
            this.f571a.a2(MotionLayout.this.mLayoutWidget.N1());
            this.b.a2(MotionLayout.this.mLayoutWidget.N1());
            this.f571a.y1();
            this.b.y1();
            c(MotionLayout.this.mLayoutWidget, this.f571a);
            c(MotionLayout.this.mLayoutWidget, this.b);
            if (((double) MotionLayout.this.o) > 0.5d) {
                if (constraintSet != null) {
                    j(this.f571a, constraintSet);
                }
                j(this.b, constraintSet2);
            } else {
                j(this.b, constraintSet2);
                if (constraintSet != null) {
                    j(this.f571a, constraintSet);
                }
            }
            this.f571a.d2(MotionLayout.this.isRtl());
            this.f571a.f2();
            this.b.d2(MotionLayout.this.isRtl());
            this.b.f2();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.f571a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer2.T0(dimensionBehaviour);
                    this.b.T0(dimensionBehaviour);
                }
                if (layoutParams.height == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer3 = this.f571a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer3.k1(dimensionBehaviour2);
                    this.b.k1(dimensionBehaviour2);
                }
            }
        }

        public boolean f(int i, int i2) {
            return (i == this.e && i2 == this.f) ? false : true;
        }

        public void g(int i, int i2) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.m0 = mode;
            motionLayout.n0 = mode2;
            motionLayout.getOptimizationLevel();
            b(i, i2);
            if (!((MotionLayout.this.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824)) {
                b(i, i2);
                MotionLayout.this.i0 = this.f571a.Y();
                MotionLayout.this.j0 = this.f571a.z();
                MotionLayout.this.k0 = this.b.Y();
                MotionLayout.this.l0 = this.b.z();
                MotionLayout motionLayout2 = MotionLayout.this;
                motionLayout2.h0 = (motionLayout2.i0 == motionLayout2.k0 && motionLayout2.j0 == motionLayout2.l0) ? false : true;
            }
            MotionLayout motionLayout3 = MotionLayout.this;
            int i3 = motionLayout3.i0;
            int i4 = motionLayout3.j0;
            int i5 = motionLayout3.m0;
            if (i5 == Integer.MIN_VALUE || i5 == 0) {
                i3 = (int) (((float) i3) + (motionLayout3.o0 * ((float) (motionLayout3.k0 - i3))));
            }
            int i6 = i3;
            int i7 = motionLayout3.n0;
            if (i7 == Integer.MIN_VALUE || i7 == 0) {
                i4 = (int) (((float) i4) + (motionLayout3.o0 * ((float) (motionLayout3.l0 - i4))));
            }
            MotionLayout.this.resolveMeasuredDimension(i, i2, i6, i4, this.f571a.V1() || this.b.V1(), this.f571a.T1() || this.b.T1());
        }

        public void h() {
            g(MotionLayout.this.h, MotionLayout.this.i);
            MotionLayout.this.f0();
        }

        public void i(int i, int i2) {
            this.e = i;
            this.f = i2;
        }

        public final void j(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet) {
            SparseArray sparseArray = new SparseArray();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, constraintWidgetContainer);
            sparseArray.put(MotionLayout.this.getId(), constraintWidgetContainer);
            if (!(constraintSet == null || constraintSet.d == 0)) {
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.resolveSystem(this.b, motionLayout.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), 1073741824));
            }
            Iterator it = constraintWidgetContainer.v1().iterator();
            while (it.hasNext()) {
                ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
                constraintWidget.D0(true);
                sparseArray.put(((View) constraintWidget.u()).getId(), constraintWidget);
            }
            Iterator it2 = constraintWidgetContainer.v1().iterator();
            while (it2.hasNext()) {
                ConstraintWidget constraintWidget2 = (ConstraintWidget) it2.next();
                View view = (View) constraintWidget2.u();
                constraintSet.l(view.getId(), layoutParams);
                constraintWidget2.o1(constraintSet.C(view.getId()));
                constraintWidget2.P0(constraintSet.x(view.getId()));
                if (view instanceof ConstraintHelper) {
                    constraintSet.j((ConstraintHelper) view, constraintWidget2, layoutParams, sparseArray);
                    if (view instanceof androidx.constraintlayout.widget.Barrier) {
                        ((androidx.constraintlayout.widget.Barrier) view).w();
                    }
                }
                layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, constraintWidget2, layoutParams, sparseArray);
                if (constraintSet.B(view.getId()) == 1) {
                    constraintWidget2.n1(view.getVisibility());
                } else {
                    constraintWidget2.n1(constraintSet.A(view.getId()));
                }
            }
            Iterator it3 = constraintWidgetContainer.v1().iterator();
            while (it3.hasNext()) {
                ConstraintWidget constraintWidget3 = (ConstraintWidget) it3.next();
                if (constraintWidget3 instanceof VirtualLayout) {
                    Helper helper = (Helper) constraintWidget3;
                    ((ConstraintHelper) constraintWidget3.u()).u(constraintWidgetContainer, helper, sparseArray);
                    ((VirtualLayout) helper).y1();
                }
            }
        }
    }

    public interface MotionTracker {
        void a();

        void b(MotionEvent motionEvent);

        float c();

        void d(int i);

        float e();
    }

    public static class MyTracker implements MotionTracker {
        public static MyTracker b = new MyTracker();

        /* renamed from: a  reason: collision with root package name */
        public VelocityTracker f572a;

        public static MyTracker f() {
            b.f572a = VelocityTracker.obtain();
            return b;
        }

        public void a() {
            VelocityTracker velocityTracker = this.f572a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f572a = null;
            }
        }

        public void b(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.f572a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        public float c() {
            VelocityTracker velocityTracker = this.f572a;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        public void d(int i) {
            VelocityTracker velocityTracker = this.f572a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i);
            }
        }

        public float e() {
            VelocityTracker velocityTracker = this.f572a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }
    }

    public class StateCache {

        /* renamed from: a  reason: collision with root package name */
        public float f573a = Float.NaN;
        public float b = Float.NaN;
        public int c = -1;
        public int d = -1;
        public final String e = "motion.progress";
        public final String f = "motion.velocity";
        public final String g = "motion.StartState";
        public final String h = "motion.EndState";

        public StateCache() {
        }

        public void a() {
            int i2 = this.c;
            if (!(i2 == -1 && this.d == -1)) {
                if (i2 == -1) {
                    MotionLayout.this.l0(this.d);
                } else {
                    int i3 = this.d;
                    if (i3 == -1) {
                        MotionLayout.this.setState(i2, -1, -1);
                    } else {
                        MotionLayout.this.e0(i2, i3);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (!Float.isNaN(this.b)) {
                MotionLayout.this.d0(this.f573a, this.b);
                this.f573a = Float.NaN;
                this.b = Float.NaN;
                this.c = -1;
                this.d = -1;
            } else if (!Float.isNaN(this.f573a)) {
                MotionLayout.this.setProgress(this.f573a);
            }
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f573a);
            bundle.putFloat("motion.velocity", this.b);
            bundle.putInt("motion.StartState", this.c);
            bundle.putInt("motion.EndState", this.d);
            return bundle;
        }

        public void c() {
            this.d = MotionLayout.this.g;
            this.c = MotionLayout.this.e;
            this.b = MotionLayout.this.getVelocity();
            this.f573a = MotionLayout.this.getProgress();
        }

        public void d(int i2) {
            this.d = i2;
        }

        public void e(float f2) {
            this.f573a = f2;
        }

        public void f(int i2) {
            this.c = i2;
        }

        public void g(Bundle bundle) {
            this.f573a = bundle.getFloat("motion.progress");
            this.b = bundle.getFloat("motion.velocity");
            this.c = bundle.getInt("motion.StartState");
            this.d = bundle.getInt("motion.EndState");
        }

        public void h(float f2) {
            this.b = f2;
        }
    }

    public interface TransitionListener {
        void a(MotionLayout motionLayout, int i, int i2, float f);

        void b(MotionLayout motionLayout, int i);

        void c(MotionLayout motionLayout, int i, int i2);

        void d(MotionLayout motionLayout, int i, boolean z, float f);
    }

    public enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(@NonNull Context context) {
        super(context);
        X((AttributeSet) null);
    }

    public static boolean s0(float f2, float f3, float f4) {
        if (f2 > 0.0f) {
            float f5 = f2 / f4;
            return f3 + ((f2 * f5) - (((f4 * f5) * f5) / 2.0f)) > 1.0f;
        }
        float f6 = (-f2) / f4;
        return f3 + ((f2 * f6) + (((f4 * f6) * f6) / 2.0f)) < 0.0f;
    }

    public void E(float f2) {
        MotionScene motionScene = this.f563a;
        if (motionScene != null) {
            float f3 = this.o;
            float f4 = this.n;
            if (f3 != f4 && this.r) {
                this.o = f4;
            }
            float f5 = this.o;
            if (f5 != f2) {
                this.z = false;
                this.q = f2;
                this.m = ((float) motionScene.p()) / 1000.0f;
                setProgress(this.q);
                this.b = null;
                this.c = this.f563a.s();
                this.r = false;
                this.l = getNanoTime();
                this.s = true;
                this.n = f5;
                this.o = f5;
                invalidate();
            }
        }
    }

    public boolean F(int i2, MotionController motionController) {
        MotionScene motionScene = this.f563a;
        if (motionScene != null) {
            return motionScene.g(i2, motionController);
        }
        return false;
    }

    public final boolean G(View view, MotionEvent motionEvent, float f2, float f3) {
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            motionEvent.offsetLocation(f2, f3);
            boolean onTouchEvent = view.onTouchEvent(motionEvent);
            motionEvent.offsetLocation(-f2, -f3);
            return onTouchEvent;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(f2, f3);
        if (this.I0 == null) {
            this.I0 = new Matrix();
        }
        matrix.invert(this.I0);
        obtain.transform(this.I0);
        boolean onTouchEvent2 = view.onTouchEvent(obtain);
        obtain.recycle();
        return onTouchEvent2;
    }

    public final void H() {
        MotionScene motionScene = this.f563a;
        if (motionScene == null) {
            Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int F2 = motionScene.F();
        MotionScene motionScene2 = this.f563a;
        I(F2, motionScene2.l(motionScene2.F()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        Iterator it = this.f563a.o().iterator();
        while (it.hasNext()) {
            MotionScene.Transition transition = (MotionScene.Transition) it.next();
            if (transition == this.f563a.c) {
                Log.v("MotionLayout", "CHECK: CURRENT");
            }
            J(transition);
            int A2 = transition.A();
            int y2 = transition.y();
            String c2 = Debug.c(getContext(), A2);
            String c3 = Debug.c(getContext(), y2);
            if (sparseIntArray.get(A2) == y2) {
                Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + c2 + "->" + c3);
            }
            if (sparseIntArray2.get(y2) == A2) {
                Log.e("MotionLayout", "CHECK: you can't have reverse transitions" + c2 + "->" + c3);
            }
            sparseIntArray.put(A2, y2);
            sparseIntArray2.put(y2, A2);
            if (this.f563a.l(A2) == null) {
                Log.e("MotionLayout", " no such constraintSetStart " + c2);
            }
            if (this.f563a.l(y2) == null) {
                Log.e("MotionLayout", " no such constraintSetEnd " + c2);
            }
        }
    }

    public final void I(int i2, ConstraintSet constraintSet) {
        String c2 = Debug.c(getContext(), i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int id = childAt.getId();
            if (id == -1) {
                Log.w("MotionLayout", "CHECK: " + c2 + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
            }
            if (constraintSet.w(id) == null) {
                Log.w("MotionLayout", "CHECK: " + c2 + " NO CONSTRAINTS for " + Debug.d(childAt));
            }
        }
        int[] y2 = constraintSet.y();
        for (int i4 = 0; i4 < y2.length; i4++) {
            int i5 = y2[i4];
            String c3 = Debug.c(getContext(), i5);
            if (findViewById(y2[i4]) == null) {
                Log.w("MotionLayout", "CHECK: " + c2 + " NO View matches id " + c3);
            }
            if (constraintSet.x(i5) == -1) {
                Log.w("MotionLayout", "CHECK: " + c2 + "(" + c3 + ") no LAYOUT_HEIGHT");
            }
            if (constraintSet.C(i5) == -1) {
                Log.w("MotionLayout", "CHECK: " + c2 + "(" + c3 + ") no LAYOUT_HEIGHT");
            }
        }
    }

    public final void J(MotionScene.Transition transition) {
        if (transition.A() == transition.y()) {
            Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
        }
    }

    public final void K() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            MotionController motionController = (MotionController) this.k.get(childAt);
            if (motionController != null) {
                motionController.E(childAt);
            }
        }
    }

    public void L(boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            MotionController motionController = (MotionController) this.k.get(getChildAt(i2));
            if (motionController != null) {
                motionController.f(z2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x020c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0118 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0170  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void M(boolean r23) {
        /*
            r22 = this;
            r0 = r22
            long r1 = r0.p
            r3 = -1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0010
            long r1 = r22.getNanoTime()
            r0.p = r1
        L_0x0010:
            float r1 = r0.o
            r2 = 0
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r4 = -1
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r3 <= 0) goto L_0x0020
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x0020
            r0.f = r4
        L_0x0020:
            boolean r3 = r0.N
            r6 = 1
            r7 = 0
            if (r3 != 0) goto L_0x0032
            boolean r3 = r0.s
            if (r3 == 0) goto L_0x0240
            if (r23 != 0) goto L_0x0032
            float r3 = r0.q
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0240
        L_0x0032:
            float r3 = r0.q
            float r3 = r3 - r1
            float r1 = java.lang.Math.signum(r3)
            long r8 = r22.getNanoTime()
            android.view.animation.Interpolator r3 = r0.b
            boolean r10 = r3 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator
            r11 = 814313567(0x3089705f, float:1.0E-9)
            if (r10 != 0) goto L_0x0051
            long r12 = r0.p
            long r12 = r8 - r12
            float r10 = (float) r12
            float r10 = r10 * r1
            float r10 = r10 * r11
            float r12 = r0.m
            float r10 = r10 / r12
            goto L_0x0052
        L_0x0051:
            r10 = r2
        L_0x0052:
            float r12 = r0.o
            float r12 = r12 + r10
            boolean r13 = r0.r
            if (r13 == 0) goto L_0x005b
            float r12 = r0.q
        L_0x005b:
            int r13 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r13 <= 0) goto L_0x0065
            float r14 = r0.q
            int r14 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r14 >= 0) goto L_0x006f
        L_0x0065:
            int r14 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r14 > 0) goto L_0x0075
            float r14 = r0.q
            int r14 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r14 > 0) goto L_0x0075
        L_0x006f:
            float r12 = r0.q
            r0.s = r7
            r14 = r6
            goto L_0x0076
        L_0x0075:
            r14 = r7
        L_0x0076:
            r0.o = r12
            r0.n = r12
            r0.p = r8
            r15 = 925353388(0x3727c5ac, float:1.0E-5)
            if (r3 == 0) goto L_0x0104
            if (r14 != 0) goto L_0x0104
            boolean r14 = r0.z
            if (r14 == 0) goto L_0x00e4
            long r4 = r0.l
            long r4 = r8 - r4
            float r4 = (float) r4
            float r4 = r4 * r11
            float r3 = r3.getInterpolation(r4)
            android.view.animation.Interpolator r4 = r0.b
            androidx.constraintlayout.motion.utils.StopLogic r5 = r0.A
            r10 = 2
            if (r4 != r5) goto L_0x00a2
            boolean r4 = r5.c()
            if (r4 == 0) goto L_0x00a0
            r4 = r10
            goto L_0x00a3
        L_0x00a0:
            r4 = r6
            goto L_0x00a3
        L_0x00a2:
            r4 = r7
        L_0x00a3:
            r0.o = r3
            r0.p = r8
            android.view.animation.Interpolator r5 = r0.b
            boolean r8 = r5 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator
            if (r8 == 0) goto L_0x00e2
            androidx.constraintlayout.motion.widget.MotionInterpolator r5 = (androidx.constraintlayout.motion.widget.MotionInterpolator) r5
            float r5 = r5.a()
            r0.d = r5
            float r8 = java.lang.Math.abs(r5)
            float r9 = r0.m
            float r8 = r8 * r9
            int r8 = (r8 > r15 ? 1 : (r8 == r15 ? 0 : -1))
            if (r8 > 0) goto L_0x00c4
            if (r4 != r10) goto L_0x00c4
            r0.s = r7
        L_0x00c4:
            int r8 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x00d4
            r8 = 1065353216(0x3f800000, float:1.0)
            int r9 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r9 < 0) goto L_0x00d4
            r0.o = r8
            r0.s = r7
            r3 = 1065353216(0x3f800000, float:1.0)
        L_0x00d4:
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 >= 0) goto L_0x00e2
            int r5 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r5 > 0) goto L_0x00e2
            r0.o = r2
            r0.s = r7
            r12 = r2
            goto L_0x0107
        L_0x00e2:
            r12 = r3
            goto L_0x0107
        L_0x00e4:
            float r3 = r3.getInterpolation(r12)
            android.view.animation.Interpolator r4 = r0.b
            boolean r5 = r4 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator
            if (r5 == 0) goto L_0x00f7
            androidx.constraintlayout.motion.widget.MotionInterpolator r4 = (androidx.constraintlayout.motion.widget.MotionInterpolator) r4
            float r4 = r4.a()
            r0.d = r4
            goto L_0x0101
        L_0x00f7:
            float r12 = r12 + r10
            float r4 = r4.getInterpolation(r12)
            float r4 = r4 - r3
            float r4 = r4 * r1
            float r4 = r4 / r10
            r0.d = r4
        L_0x0101:
            r12 = r3
        L_0x0102:
            r4 = r7
            goto L_0x0107
        L_0x0104:
            r0.d = r10
            goto L_0x0102
        L_0x0107:
            float r3 = r0.d
            float r3 = java.lang.Math.abs(r3)
            int r3 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r3 <= 0) goto L_0x0116
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r3 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING
            r0.setState(r3)
        L_0x0116:
            if (r4 == r6) goto L_0x013f
            if (r13 <= 0) goto L_0x0120
            float r3 = r0.q
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x012a
        L_0x0120:
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x012e
            float r3 = r0.q
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x012e
        L_0x012a:
            float r12 = r0.q
            r0.s = r7
        L_0x012e:
            r3 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x0138
            int r3 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x013f
        L_0x0138:
            r0.s = r7
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r3 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r3)
        L_0x013f:
            int r3 = r22.getChildCount()
            r0.N = r7
            long r4 = r22.getNanoTime()
            r0.o0 = r12
            android.view.animation.Interpolator r8 = r0.c
            if (r8 != 0) goto L_0x0151
            r8 = r12
            goto L_0x0155
        L_0x0151:
            float r8 = r8.getInterpolation(r12)
        L_0x0155:
            android.view.animation.Interpolator r9 = r0.c
            if (r9 == 0) goto L_0x016d
            float r10 = r0.m
            float r10 = r1 / r10
            float r10 = r10 + r12
            float r9 = r9.getInterpolation(r10)
            r0.d = r9
            android.view.animation.Interpolator r10 = r0.c
            float r10 = r10.getInterpolation(r12)
            float r9 = r9 - r10
            r0.d = r9
        L_0x016d:
            r9 = r7
        L_0x016e:
            if (r9 >= r3) goto L_0x0196
            android.view.View r10 = r0.getChildAt(r9)
            java.util.HashMap r11 = r0.k
            java.lang.Object r11 = r11.get(r10)
            r16 = r11
            androidx.constraintlayout.motion.widget.MotionController r16 = (androidx.constraintlayout.motion.widget.MotionController) r16
            if (r16 == 0) goto L_0x0193
            boolean r11 = r0.N
            androidx.constraintlayout.core.motion.utils.KeyCache r15 = r0.p0
            r17 = r10
            r18 = r8
            r19 = r4
            r21 = r15
            boolean r10 = r16.x(r17, r18, r19, r21)
            r10 = r10 | r11
            r0.N = r10
        L_0x0193:
            int r9 = r9 + 1
            goto L_0x016e
        L_0x0196:
            if (r13 <= 0) goto L_0x019e
            float r3 = r0.q
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x01a8
        L_0x019e:
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x01aa
            float r3 = r0.q
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x01aa
        L_0x01a8:
            r3 = r6
            goto L_0x01ab
        L_0x01aa:
            r3 = r7
        L_0x01ab:
            boolean r4 = r0.N
            if (r4 != 0) goto L_0x01ba
            boolean r4 = r0.s
            if (r4 != 0) goto L_0x01ba
            if (r3 == 0) goto L_0x01ba
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r4 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r4)
        L_0x01ba:
            boolean r4 = r0.h0
            if (r4 == 0) goto L_0x01c1
            r22.requestLayout()
        L_0x01c1:
            boolean r4 = r0.N
            r3 = r3 ^ r6
            r3 = r3 | r4
            r0.N = r3
            int r3 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x01e5
            int r3 = r0.e
            r4 = -1
            if (r3 == r4) goto L_0x01e5
            int r4 = r0.f
            if (r4 == r3) goto L_0x01e5
            r0.f = r3
            androidx.constraintlayout.motion.widget.MotionScene r4 = r0.f563a
            androidx.constraintlayout.widget.ConstraintSet r3 = r4.l(r3)
            r3.g(r0)
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r3 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r3)
            r7 = r6
        L_0x01e5:
            double r3 = (double) r12
            r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x0203
            int r3 = r0.f
            int r4 = r0.g
            if (r3 == r4) goto L_0x0203
            r0.f = r4
            androidx.constraintlayout.motion.widget.MotionScene r3 = r0.f563a
            androidx.constraintlayout.widget.ConstraintSet r3 = r3.l(r4)
            r3.g(r0)
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r3 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r3)
            r7 = r6
        L_0x0203:
            boolean r3 = r0.N
            if (r3 != 0) goto L_0x0222
            boolean r3 = r0.s
            if (r3 == 0) goto L_0x020c
            goto L_0x0222
        L_0x020c:
            if (r13 <= 0) goto L_0x0214
            r3 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x021c
        L_0x0214:
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0225
            int r3 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r3 != 0) goto L_0x0225
        L_0x021c:
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r3 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r3)
            goto L_0x0225
        L_0x0222:
            r22.invalidate()
        L_0x0225:
            boolean r3 = r0.N
            if (r3 != 0) goto L_0x0240
            boolean r3 = r0.s
            if (r3 != 0) goto L_0x0240
            if (r13 <= 0) goto L_0x0235
            r3 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x023d
        L_0x0235:
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x0240
            int r1 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x0240
        L_0x023d:
            r22.a0()
        L_0x0240:
            float r1 = r0.o
            r3 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x0254
            int r1 = r0.f
            int r2 = r0.g
            if (r1 == r2) goto L_0x024f
            goto L_0x0250
        L_0x024f:
            r6 = r7
        L_0x0250:
            r0.f = r2
        L_0x0252:
            r7 = r6
            goto L_0x0263
        L_0x0254:
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x0263
            int r1 = r0.f
            int r2 = r0.e
            if (r1 == r2) goto L_0x025f
            goto L_0x0260
        L_0x025f:
            r6 = r7
        L_0x0260:
            r0.f = r2
            goto L_0x0252
        L_0x0263:
            boolean r1 = r0.F0
            r1 = r1 | r7
            r0.F0 = r1
            if (r7 == 0) goto L_0x0271
            boolean r1 = r0.q0
            if (r1 != 0) goto L_0x0271
            r22.requestLayout()
        L_0x0271:
            float r1 = r0.o
            r0.n = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.M(boolean):void");
    }

    public final void N() {
        boolean z2;
        float signum = Math.signum(this.q - this.o);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.b;
        float f2 = this.o + (!(interpolator instanceof StopLogic) ? ((((float) (nanoTime - this.p)) * signum) * 1.0E-9f) / this.m : 0.0f);
        if (this.r) {
            f2 = this.q;
        }
        int i2 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
        if ((i2 <= 0 || f2 < this.q) && (signum > 0.0f || f2 > this.q)) {
            z2 = false;
        } else {
            f2 = this.q;
            z2 = true;
        }
        if (interpolator != null && !z2) {
            f2 = this.z ? interpolator.getInterpolation(((float) (nanoTime - this.l)) * 1.0E-9f) : interpolator.getInterpolation(f2);
        }
        if ((i2 > 0 && f2 >= this.q) || (signum <= 0.0f && f2 <= this.q)) {
            f2 = this.q;
        }
        this.o0 = f2;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator2 = this.c;
        if (interpolator2 != null) {
            f2 = interpolator2.getInterpolation(f2);
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            MotionController motionController = (MotionController) this.k.get(childAt);
            if (motionController != null) {
                motionController.x(childAt, f2, nanoTime2, this.p0);
            }
        }
        if (this.h0) {
            requestLayout();
        }
    }

    public final void O() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if ((this.u != null || ((copyOnWriteArrayList = this.R) != null && !copyOnWriteArrayList.isEmpty())) && this.W != this.n) {
            if (this.V != -1) {
                TransitionListener transitionListener = this.u;
                if (transitionListener != null) {
                    transitionListener.c(this, this.e, this.g);
                }
                CopyOnWriteArrayList copyOnWriteArrayList2 = this.R;
                if (copyOnWriteArrayList2 != null) {
                    Iterator it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        ((TransitionListener) it.next()).c(this, this.e, this.g);
                    }
                }
                this.g0 = true;
            }
            this.V = -1;
            float f2 = this.n;
            this.W = f2;
            TransitionListener transitionListener2 = this.u;
            if (transitionListener2 != null) {
                transitionListener2.a(this, this.e, this.g, f2);
            }
            CopyOnWriteArrayList copyOnWriteArrayList3 = this.R;
            if (copyOnWriteArrayList3 != null) {
                Iterator it2 = copyOnWriteArrayList3.iterator();
                while (it2.hasNext()) {
                    ((TransitionListener) it2.next()).a(this, this.e, this.g, this.n);
                }
            }
            this.g0 = true;
        }
    }

    public void P() {
        int i2;
        CopyOnWriteArrayList copyOnWriteArrayList;
        if ((this.u != null || ((copyOnWriteArrayList = this.R) != null && !copyOnWriteArrayList.isEmpty())) && this.V == -1) {
            this.V = this.f;
            if (!this.J0.isEmpty()) {
                ArrayList arrayList = this.J0;
                i2 = ((Integer) arrayList.get(arrayList.size() - 1)).intValue();
            } else {
                i2 = -1;
            }
            int i3 = this.f;
            if (!(i2 == i3 || i3 == -1)) {
                this.J0.add(Integer.valueOf(i3));
            }
        }
        b0();
        Runnable runnable = this.s0;
        if (runnable != null) {
            runnable.run();
        }
        int[] iArr = this.t0;
        if (iArr != null && this.u0 > 0) {
            l0(iArr[0]);
            int[] iArr2 = this.t0;
            System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
            this.u0--;
        }
    }

    public void Q(int i2, boolean z2, float f2) {
        TransitionListener transitionListener = this.u;
        if (transitionListener != null) {
            transitionListener.d(this, i2, z2, f2);
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.R;
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((TransitionListener) it.next()).d(this, i2, z2, f2);
            }
        }
    }

    public void R(int i2, float f2, float f3, float f4, float[] fArr) {
        String str;
        HashMap hashMap = this.k;
        View viewById = getViewById(i2);
        MotionController motionController = (MotionController) hashMap.get(viewById);
        if (motionController != null) {
            motionController.l(f2, f3, f4, fArr);
            float y2 = viewById.getY();
            this.v = f2;
            this.w = y2;
            return;
        }
        if (viewById == null) {
            str = "" + i2;
        } else {
            str = viewById.getContext().getResources().getResourceName(i2);
        }
        Log.w("MotionLayout", "WARNING could not find view id " + str);
    }

    public ConstraintSet S(int i2) {
        MotionScene motionScene = this.f563a;
        if (motionScene == null) {
            return null;
        }
        return motionScene.l(i2);
    }

    public MotionController T(int i2) {
        return (MotionController) this.k.get(findViewById(i2));
    }

    public MotionScene.Transition U(int i2) {
        return this.f563a.G(i2);
    }

    public void V(View view, float f2, float f3, float[] fArr, int i2) {
        float f4;
        float f5 = this.d;
        float f6 = this.o;
        if (this.b != null) {
            float signum = Math.signum(this.q - f6);
            float interpolation = this.b.getInterpolation(this.o + 1.0E-5f);
            f4 = this.b.getInterpolation(this.o);
            f5 = (signum * ((interpolation - f4) / 1.0E-5f)) / this.m;
        } else {
            f4 = f6;
        }
        Interpolator interpolator = this.b;
        if (interpolator instanceof MotionInterpolator) {
            f5 = ((MotionInterpolator) interpolator).a();
        }
        MotionController motionController = (MotionController) this.k.get(view);
        if ((i2 & 1) == 0) {
            motionController.r(f4, view.getWidth(), view.getHeight(), f2, f3, fArr);
        } else {
            motionController.l(f4, f2, f3, fArr);
        }
        if (i2 < 2) {
            fArr[0] = fArr[0] * f5;
            fArr[1] = fArr[1] * f5;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean W(float r8, float r9, android.view.View r10, android.view.MotionEvent r11) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof android.view.ViewGroup
            r1 = 1
            if (r0 == 0) goto L_0x0036
            r0 = r10
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r2 = r0.getChildCount()
            int r2 = r2 - r1
        L_0x000d:
            if (r2 < 0) goto L_0x0036
            android.view.View r3 = r0.getChildAt(r2)
            int r4 = r3.getLeft()
            float r4 = (float) r4
            float r4 = r4 + r8
            int r5 = r10.getScrollX()
            float r5 = (float) r5
            float r4 = r4 - r5
            int r5 = r3.getTop()
            float r5 = (float) r5
            float r5 = r5 + r9
            int r6 = r10.getScrollY()
            float r6 = (float) r6
            float r5 = r5 - r6
            boolean r3 = r7.W(r4, r5, r3, r11)
            if (r3 == 0) goto L_0x0033
            r0 = r1
            goto L_0x0037
        L_0x0033:
            int r2 = r2 + -1
            goto L_0x000d
        L_0x0036:
            r0 = 0
        L_0x0037:
            if (r0 != 0) goto L_0x0075
            android.graphics.RectF r2 = r7.G0
            int r3 = r10.getRight()
            float r3 = (float) r3
            float r3 = r3 + r8
            int r4 = r10.getLeft()
            float r4 = (float) r4
            float r3 = r3 - r4
            int r4 = r10.getBottom()
            float r4 = (float) r4
            float r4 = r4 + r9
            int r5 = r10.getTop()
            float r5 = (float) r5
            float r4 = r4 - r5
            r2.set(r8, r9, r3, r4)
            int r2 = r11.getAction()
            if (r2 != 0) goto L_0x006c
            android.graphics.RectF r2 = r7.G0
            float r3 = r11.getX()
            float r4 = r11.getY()
            boolean r2 = r2.contains(r3, r4)
            if (r2 == 0) goto L_0x0075
        L_0x006c:
            float r8 = -r8
            float r9 = -r9
            boolean r7 = r7.G(r10, r11, r8, r9)
            if (r7 == 0) goto L_0x0075
            goto L_0x0076
        L_0x0075:
            r1 = r0
        L_0x0076:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.W(float, float, android.view.View, android.view.MotionEvent):boolean");
    }

    public final void X(AttributeSet attributeSet) {
        MotionScene motionScene;
        K0 = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z2 = true;
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MotionLayout_layoutDescription) {
                    this.f563a = new MotionScene(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R.styleable.MotionLayout_currentState) {
                    this.f = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R.styleable.MotionLayout_motionProgress) {
                    this.q = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.s = true;
                } else if (index == R.styleable.MotionLayout_applyMotionScene) {
                    z2 = obtainStyledAttributes.getBoolean(index, z2);
                } else if (index == R.styleable.MotionLayout_showPaths) {
                    if (this.x == 0) {
                        this.x = obtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == R.styleable.MotionLayout_motionDebug) {
                    this.x = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            if (this.f563a == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }
            if (!z2) {
                this.f563a = null;
            }
        }
        if (this.x != 0) {
            H();
        }
        if (this.f == -1 && (motionScene = this.f563a) != null) {
            this.f = motionScene.F();
            this.e = this.f563a.F();
            this.g = this.f563a.q();
        }
    }

    public boolean Y() {
        return this.j;
    }

    public MotionTracker Z() {
        return MyTracker.f();
    }

    public void a0() {
        MotionScene motionScene = this.f563a;
        if (motionScene != null) {
            if (motionScene.h(this, this.f)) {
                requestLayout();
                return;
            }
            int i2 = this.f;
            if (i2 != -1) {
                this.f563a.f(this, i2);
            }
            if (this.f563a.b0()) {
                this.f563a.Z();
            }
        }
    }

    public final void b0() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (this.u != null || ((copyOnWriteArrayList = this.R) != null && !copyOnWriteArrayList.isEmpty())) {
            this.g0 = false;
            Iterator it = this.J0.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                TransitionListener transitionListener = this.u;
                if (transitionListener != null) {
                    transitionListener.b(this, num.intValue());
                }
                CopyOnWriteArrayList copyOnWriteArrayList2 = this.R;
                if (copyOnWriteArrayList2 != null) {
                    Iterator it2 = copyOnWriteArrayList2.iterator();
                    while (it2.hasNext()) {
                        ((TransitionListener) it2.next()).b(this, num.intValue());
                    }
                }
            }
            this.J0.clear();
        }
    }

    public void c0() {
        this.E0.h();
        invalidate();
    }

    public void d0(float f2, float f3) {
        if (!isAttachedToWindow()) {
            if (this.r0 == null) {
                this.r0 = new StateCache();
            }
            this.r0.e(f2);
            this.r0.h(f3);
            return;
        }
        setProgress(f2);
        setState(TransitionState.MOVING);
        this.d = f3;
        float f4 = 0.0f;
        int i2 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            if (i2 > 0) {
                f4 = 1.0f;
            }
            E(f4);
        } else if (f2 != 0.0f && f2 != 1.0f) {
            if (f2 > 0.5f) {
                f4 = 1.0f;
            }
            E(f4);
        }
    }

    public void dispatchDraw(Canvas canvas) {
        ViewTransitionController viewTransitionController;
        ArrayList arrayList = this.Q;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((MotionHelper) it.next()).C(canvas);
            }
        }
        M(false);
        MotionScene motionScene = this.f563a;
        if (!(motionScene == null || (viewTransitionController = motionScene.s) == null)) {
            viewTransitionController.c();
        }
        super.dispatchDraw(canvas);
        if (this.f563a != null) {
            if ((this.x & 1) == 1 && !isInEditMode()) {
                this.S++;
                long nanoTime = getNanoTime();
                long j2 = this.T;
                if (j2 != -1) {
                    long j3 = nanoTime - j2;
                    if (j3 > 200000000) {
                        this.U = ((float) ((int) ((((float) this.S) / (((float) j3) * 1.0E-9f)) * 100.0f))) / 100.0f;
                        this.S = 0;
                        this.T = nanoTime;
                    }
                } else {
                    this.T = nanoTime;
                }
                Paint paint = new Paint();
                paint.setTextSize(42.0f);
                StringBuilder sb = new StringBuilder();
                sb.append(this.U + " fps " + Debug.e(this, this.e) + " -> ");
                sb.append(Debug.e(this, this.g));
                sb.append(" (progress: ");
                sb.append(((float) ((int) (getProgress() * 1000.0f))) / 10.0f);
                sb.append(" ) state=");
                int i2 = this.f;
                sb.append(i2 == -1 ? "undefined" : Debug.e(this, i2));
                String sb2 = sb.toString();
                paint.setColor(-16777216);
                canvas.drawText(sb2, 11.0f, (float) (getHeight() - 29), paint);
                paint.setColor(-7864184);
                canvas.drawText(sb2, 10.0f, (float) (getHeight() - 30), paint);
            }
            if (this.x > 1) {
                if (this.y == null) {
                    this.y = new DevModeDraw();
                }
                this.y.a(canvas, this.k, this.f563a.p(), this.x);
            }
            ArrayList arrayList2 = this.Q;
            if (arrayList2 != null) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((MotionHelper) it2.next()).B(canvas);
                }
            }
        }
    }

    public void e0(int i2, int i3) {
        if (!isAttachedToWindow()) {
            if (this.r0 == null) {
                this.r0 = new StateCache();
            }
            this.r0.f(i2);
            this.r0.d(i3);
            return;
        }
        MotionScene motionScene = this.f563a;
        if (motionScene != null) {
            this.e = i2;
            this.g = i3;
            motionScene.X(i2, i3);
            this.E0.e(this.mLayoutWidget, this.f563a.l(i2), this.f563a.l(i3));
            c0();
            this.o = 0.0f;
            k0();
        }
    }

    public final void f0() {
        int childCount = getChildCount();
        this.E0.a();
        boolean z2 = true;
        this.s = true;
        SparseArray sparseArray = new SparseArray();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            sparseArray.put(childAt.getId(), (MotionController) this.k.get(childAt));
        }
        int width = getWidth();
        int height = getHeight();
        int j2 = this.f563a.j();
        if (j2 != -1) {
            for (int i4 = 0; i4 < childCount; i4++) {
                MotionController motionController = (MotionController) this.k.get(getChildAt(i4));
                if (motionController != null) {
                    motionController.D(j2);
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[this.k.size()];
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            MotionController motionController2 = (MotionController) this.k.get(getChildAt(i6));
            if (motionController2.h() != -1) {
                sparseBooleanArray.put(motionController2.h(), true);
                iArr[i5] = motionController2.h();
                i5++;
            }
        }
        if (this.Q != null) {
            for (int i7 = 0; i7 < i5; i7++) {
                MotionController motionController3 = (MotionController) this.k.get(findViewById(iArr[i7]));
                if (motionController3 != null) {
                    this.f563a.t(motionController3);
                }
            }
            Iterator it = this.Q.iterator();
            while (it.hasNext()) {
                ((MotionHelper) it.next()).D(this, this.k);
            }
            for (int i8 = 0; i8 < i5; i8++) {
                MotionController motionController4 = (MotionController) this.k.get(findViewById(iArr[i8]));
                if (motionController4 != null) {
                    motionController4.I(width, height, this.m, getNanoTime());
                }
            }
        } else {
            for (int i9 = 0; i9 < i5; i9++) {
                MotionController motionController5 = (MotionController) this.k.get(findViewById(iArr[i9]));
                if (motionController5 != null) {
                    this.f563a.t(motionController5);
                    motionController5.I(width, height, this.m, getNanoTime());
                }
            }
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt2 = getChildAt(i10);
            MotionController motionController6 = (MotionController) this.k.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && motionController6 != null) {
                this.f563a.t(motionController6);
                motionController6.I(width, height, this.m, getNanoTime());
            }
        }
        float E2 = this.f563a.E();
        if (E2 != 0.0f) {
            if (((double) E2) >= 0.0d) {
                z2 = false;
            }
            float abs = Math.abs(E2);
            float f2 = -3.4028235E38f;
            float f3 = Float.MAX_VALUE;
            float f4 = -3.4028235E38f;
            float f5 = Float.MAX_VALUE;
            for (int i11 = 0; i11 < childCount; i11++) {
                MotionController motionController7 = (MotionController) this.k.get(getChildAt(i11));
                if (!Float.isNaN(motionController7.m)) {
                    for (int i12 = 0; i12 < childCount; i12++) {
                        MotionController motionController8 = (MotionController) this.k.get(getChildAt(i12));
                        if (!Float.isNaN(motionController8.m)) {
                            f3 = Math.min(f3, motionController8.m);
                            f2 = Math.max(f2, motionController8.m);
                        }
                    }
                    while (i2 < childCount) {
                        MotionController motionController9 = (MotionController) this.k.get(getChildAt(i2));
                        if (!Float.isNaN(motionController9.m)) {
                            motionController9.o = 1.0f / (1.0f - abs);
                            if (z2) {
                                motionController9.n = abs - (((f2 - motionController9.m) / (f2 - f3)) * abs);
                            } else {
                                motionController9.n = abs - (((motionController9.m - f3) * abs) / (f2 - f3));
                            }
                        }
                        i2++;
                    }
                    return;
                }
                float n2 = motionController7.n();
                float o2 = motionController7.o();
                float f6 = z2 ? o2 - n2 : o2 + n2;
                f5 = Math.min(f5, f6);
                f4 = Math.max(f4, f6);
            }
            while (i2 < childCount) {
                MotionController motionController10 = (MotionController) this.k.get(getChildAt(i2));
                float n3 = motionController10.n();
                float o3 = motionController10.o();
                float f7 = z2 ? o3 - n3 : o3 + n3;
                motionController10.o = 1.0f / (1.0f - abs);
                motionController10.n = abs - (((f7 - f5) * abs) / (f4 - f5));
                i2++;
            }
        }
    }

    public final Rect g0(ConstraintWidget constraintWidget) {
        this.B0.top = constraintWidget.a0();
        this.B0.left = constraintWidget.Z();
        Rect rect = this.B0;
        int Y = constraintWidget.Y();
        Rect rect2 = this.B0;
        rect.right = Y + rect2.left;
        int z2 = constraintWidget.z();
        Rect rect3 = this.B0;
        rect2.bottom = z2 + rect3.top;
        return rect3;
    }

    public int[] getConstraintSetIds() {
        MotionScene motionScene = this.f563a;
        if (motionScene == null) {
            return null;
        }
        return motionScene.n();
    }

    public int getCurrentState() {
        return this.f;
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene motionScene = this.f563a;
        if (motionScene == null) {
            return null;
        }
        return motionScene.o();
    }

    public DesignTool getDesignTool() {
        if (this.C == null) {
            this.C = new DesignTool(this);
        }
        return this.C;
    }

    public int getEndState() {
        return this.g;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.o;
    }

    public MotionScene getScene() {
        return this.f563a;
    }

    public int getStartState() {
        return this.e;
    }

    public float getTargetPosition() {
        return this.q;
    }

    public Bundle getTransitionState() {
        if (this.r0 == null) {
            this.r0 = new StateCache();
        }
        this.r0.c();
        return this.r0.b();
    }

    public long getTransitionTimeMs() {
        MotionScene motionScene = this.f563a;
        if (motionScene != null) {
            this.m = ((float) motionScene.p()) / 1000.0f;
        }
        return (long) (this.m * 1000.0f);
    }

    public float getVelocity() {
        return this.d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0037, code lost:
        if (r10 != 7) goto L_0x00f1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h0(int r10, float r11, float r12) {
        /*
            r9 = this;
            androidx.constraintlayout.motion.widget.MotionScene r0 = r9.f563a
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            float r0 = r9.o
            int r0 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            r0 = 1
            r9.z = r0
            long r1 = r9.getNanoTime()
            r9.l = r1
            androidx.constraintlayout.motion.widget.MotionScene r1 = r9.f563a
            int r1 = r1.p()
            float r1 = (float) r1
            r2 = 1148846080(0x447a0000, float:1000.0)
            float r1 = r1 / r2
            r9.m = r1
            r9.q = r11
            r9.s = r0
            r1 = 0
            r2 = 7
            r3 = 6
            r4 = 2
            if (r10 == 0) goto L_0x0093
            if (r10 == r0) goto L_0x0093
            if (r10 == r4) goto L_0x0093
            r5 = 4
            if (r10 == r5) goto L_0x0081
            r5 = 5
            if (r10 == r5) goto L_0x003b
            if (r10 == r3) goto L_0x0093
            if (r10 == r2) goto L_0x0093
            goto L_0x00f1
        L_0x003b:
            float r10 = r9.o
            androidx.constraintlayout.motion.widget.MotionScene r0 = r9.f563a
            float r0 = r0.u()
            boolean r10 = s0(r12, r10, r0)
            if (r10 == 0) goto L_0x005c
            androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator r10 = r9.B
            float r11 = r9.o
            androidx.constraintlayout.motion.widget.MotionScene r0 = r9.f563a
            float r0 = r0.u()
            r10.b(r12, r11, r0)
            androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator r10 = r9.B
            r9.b = r10
            goto L_0x00f1
        L_0x005c:
            androidx.constraintlayout.motion.utils.StopLogic r2 = r9.A
            float r3 = r9.o
            float r6 = r9.m
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.f563a
            float r7 = r10.u()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.f563a
            float r8 = r10.v()
            r4 = r11
            r5 = r12
            r2.b(r3, r4, r5, r6, r7, r8)
            r9.d = r1
            int r10 = r9.f
            r9.q = r11
            r9.f = r10
            androidx.constraintlayout.motion.utils.StopLogic r10 = r9.A
            r9.b = r10
            goto L_0x00f1
        L_0x0081:
            androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator r10 = r9.B
            float r11 = r9.o
            androidx.constraintlayout.motion.widget.MotionScene r0 = r9.f563a
            float r0 = r0.u()
            r10.b(r12, r11, r0)
            androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator r10 = r9.B
            r9.b = r10
            goto L_0x00f1
        L_0x0093:
            if (r10 == r0) goto L_0x009f
            if (r10 != r2) goto L_0x0098
            goto L_0x009f
        L_0x0098:
            if (r10 == r4) goto L_0x009c
            if (r10 != r3) goto L_0x00a0
        L_0x009c:
            r11 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00a0
        L_0x009f:
            r11 = r1
        L_0x00a0:
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.f563a
            int r10 = r10.k()
            if (r10 != 0) goto L_0x00c0
            androidx.constraintlayout.motion.utils.StopLogic r0 = r9.A
            float r1 = r9.o
            float r4 = r9.m
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.f563a
            float r5 = r10.u()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.f563a
            float r6 = r10.v()
            r2 = r11
            r3 = r12
            r0.b(r1, r2, r3, r4, r5, r6)
            goto L_0x00e7
        L_0x00c0:
            androidx.constraintlayout.motion.utils.StopLogic r0 = r9.A
            float r1 = r9.o
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.f563a
            float r4 = r10.B()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.f563a
            float r5 = r10.C()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.f563a
            float r6 = r10.A()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.f563a
            float r7 = r10.D()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.f563a
            int r8 = r10.z()
            r2 = r11
            r3 = r12
            r0.d(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x00e7:
            int r10 = r9.f
            r9.q = r11
            r9.f = r10
            androidx.constraintlayout.motion.utils.StopLogic r10 = r9.A
            r9.b = r10
        L_0x00f1:
            r10 = 0
            r9.r = r10
            long r10 = r9.getNanoTime()
            r9.l = r10
            r9.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.h0(int, float, float):void");
    }

    public void i0() {
        E(1.0f);
        this.s0 = null;
    }

    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    public void j0(Runnable runnable) {
        E(1.0f);
        this.s0 = runnable;
    }

    public void k0() {
        E(0.0f);
    }

    public void l0(int i2) {
        if (!isAttachedToWindow()) {
            if (this.r0 == null) {
                this.r0 = new StateCache();
            }
            this.r0.d(i2);
            return;
        }
        n0(i2, -1, -1);
    }

    public void loadLayoutDescription(int i2) {
        MotionScene.Transition transition;
        if (i2 != 0) {
            try {
                MotionScene motionScene = new MotionScene(getContext(), this, i2);
                this.f563a = motionScene;
                if (this.f == -1) {
                    this.f = motionScene.F();
                    this.e = this.f563a.F();
                    this.g = this.f563a.q();
                }
                if (isAttachedToWindow()) {
                    Display display = getDisplay();
                    this.A0 = display == null ? 0 : display.getRotation();
                    MotionScene motionScene2 = this.f563a;
                    if (motionScene2 != null) {
                        ConstraintSet l2 = motionScene2.l(this.f);
                        this.f563a.T(this);
                        ArrayList arrayList = this.Q;
                        if (arrayList != null) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((MotionHelper) it.next()).A(this);
                            }
                        }
                        if (l2 != null) {
                            l2.i(this);
                        }
                        this.e = this.f;
                    }
                    a0();
                    StateCache stateCache = this.r0;
                    if (stateCache == null) {
                        MotionScene motionScene3 = this.f563a;
                        if (motionScene3 != null && (transition = motionScene3.c) != null && transition.x() == 4) {
                            i0();
                            setState(TransitionState.SETUP);
                            setState(TransitionState.MOVING);
                        }
                    } else if (this.C0) {
                        post(new Runnable() {
                            public void run() {
                                MotionLayout.this.r0.a();
                            }
                        });
                    } else {
                        stateCache.a();
                    }
                } else {
                    this.f563a = null;
                }
            } catch (Exception e2) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e2);
            } catch (Exception e3) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e3);
            }
        } else {
            this.f563a = null;
        }
    }

    public void m0(int i2, int i3) {
        if (!isAttachedToWindow()) {
            if (this.r0 == null) {
                this.r0 = new StateCache();
            }
            this.r0.d(i2);
            return;
        }
        o0(i2, -1, -1, i3);
    }

    public void n0(int i2, int i3, int i4) {
        o0(i2, i3, i4, -1);
    }

    public void o0(int i2, int i3, int i4, int i5) {
        StateSet stateSet;
        int a2;
        MotionScene motionScene = this.f563a;
        if (!(motionScene == null || (stateSet = motionScene.b) == null || (a2 = stateSet.a(this.f, i2, (float) i3, (float) i4)) == -1)) {
            i2 = a2;
        }
        int i6 = this.f;
        if (i6 != i2) {
            if (this.e == i2) {
                E(0.0f);
                if (i5 > 0) {
                    this.m = ((float) i5) / 1000.0f;
                }
            } else if (this.g == i2) {
                E(1.0f);
                if (i5 > 0) {
                    this.m = ((float) i5) / 1000.0f;
                }
            } else {
                this.g = i2;
                if (i6 != -1) {
                    e0(i6, i2);
                    E(1.0f);
                    this.o = 0.0f;
                    i0();
                    if (i5 > 0) {
                        this.m = ((float) i5) / 1000.0f;
                        return;
                    }
                    return;
                }
                this.z = false;
                this.q = 1.0f;
                this.n = 0.0f;
                this.o = 0.0f;
                this.p = getNanoTime();
                this.l = getNanoTime();
                this.r = false;
                this.b = null;
                if (i5 == -1) {
                    this.m = ((float) this.f563a.p()) / 1000.0f;
                }
                this.e = -1;
                this.f563a.X(-1, this.g);
                SparseArray sparseArray = new SparseArray();
                if (i5 == 0) {
                    this.m = ((float) this.f563a.p()) / 1000.0f;
                } else if (i5 > 0) {
                    this.m = ((float) i5) / 1000.0f;
                }
                int childCount = getChildCount();
                this.k.clear();
                for (int i7 = 0; i7 < childCount; i7++) {
                    View childAt = getChildAt(i7);
                    this.k.put(childAt, new MotionController(childAt));
                    sparseArray.put(childAt.getId(), (MotionController) this.k.get(childAt));
                }
                this.s = true;
                this.E0.e(this.mLayoutWidget, (ConstraintSet) null, this.f563a.l(i2));
                c0();
                this.E0.a();
                K();
                int width = getWidth();
                int height = getHeight();
                if (this.Q != null) {
                    for (int i8 = 0; i8 < childCount; i8++) {
                        MotionController motionController = (MotionController) this.k.get(getChildAt(i8));
                        if (motionController != null) {
                            this.f563a.t(motionController);
                        }
                    }
                    Iterator it = this.Q.iterator();
                    while (it.hasNext()) {
                        ((MotionHelper) it.next()).D(this, this.k);
                    }
                    for (int i9 = 0; i9 < childCount; i9++) {
                        MotionController motionController2 = (MotionController) this.k.get(getChildAt(i9));
                        if (motionController2 != null) {
                            motionController2.I(width, height, this.m, getNanoTime());
                        }
                    }
                } else {
                    for (int i10 = 0; i10 < childCount; i10++) {
                        MotionController motionController3 = (MotionController) this.k.get(getChildAt(i10));
                        if (motionController3 != null) {
                            this.f563a.t(motionController3);
                            motionController3.I(width, height, this.m, getNanoTime());
                        }
                    }
                }
                float E2 = this.f563a.E();
                if (E2 != 0.0f) {
                    float f2 = Float.MAX_VALUE;
                    float f3 = -3.4028235E38f;
                    for (int i11 = 0; i11 < childCount; i11++) {
                        MotionController motionController4 = (MotionController) this.k.get(getChildAt(i11));
                        float o2 = motionController4.o() + motionController4.n();
                        f2 = Math.min(f2, o2);
                        f3 = Math.max(f3, o2);
                    }
                    for (int i12 = 0; i12 < childCount; i12++) {
                        MotionController motionController5 = (MotionController) this.k.get(getChildAt(i12));
                        float n2 = motionController5.n();
                        float o3 = motionController5.o();
                        motionController5.o = 1.0f / (1.0f - E2);
                        motionController5.n = E2 - ((((n2 + o3) - f2) * E2) / (f3 - f2));
                    }
                }
                this.n = 0.0f;
                this.o = 0.0f;
                this.s = true;
                invalidate();
            }
        }
    }

    public void onAttachedToWindow() {
        MotionScene.Transition transition;
        int i2;
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            this.A0 = display.getRotation();
        }
        MotionScene motionScene = this.f563a;
        if (!(motionScene == null || (i2 = this.f) == -1)) {
            ConstraintSet l2 = motionScene.l(i2);
            this.f563a.T(this);
            ArrayList arrayList = this.Q;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((MotionHelper) it.next()).A(this);
                }
            }
            if (l2 != null) {
                l2.i(this);
            }
            this.e = this.f;
        }
        a0();
        StateCache stateCache = this.r0;
        if (stateCache == null) {
            MotionScene motionScene2 = this.f563a;
            if (motionScene2 != null && (transition = motionScene2.c) != null && transition.x() == 4) {
                i0();
                setState(TransitionState.SETUP);
                setState(TransitionState.MOVING);
            }
        } else if (this.C0) {
            post(new Runnable() {
                public void run() {
                    MotionLayout.this.r0.a();
                }
            });
        } else {
            stateCache.a();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        TouchResponse B2;
        int q2;
        RectF p2;
        MotionScene motionScene = this.f563a;
        if (motionScene != null && this.j) {
            ViewTransitionController viewTransitionController = motionScene.s;
            if (viewTransitionController != null) {
                viewTransitionController.h(motionEvent);
            }
            MotionScene.Transition transition = this.f563a.c;
            if (transition != null && transition.C() && (B2 = transition.B()) != null && ((motionEvent.getAction() != 0 || (p2 = B2.p(this, new RectF())) == null || p2.contains(motionEvent.getX(), motionEvent.getY())) && (q2 = B2.q()) != -1)) {
                View view = this.H0;
                if (view == null || view.getId() != q2) {
                    this.H0 = findViewById(q2);
                }
                View view2 = this.H0;
                if (view2 != null) {
                    this.G0.set((float) view2.getLeft(), (float) this.H0.getTop(), (float) this.H0.getRight(), (float) this.H0.getBottom());
                    if (this.G0.contains(motionEvent.getX(), motionEvent.getY()) && !W((float) this.H0.getLeft(), (float) this.H0.getTop(), this.H0, motionEvent)) {
                        return onTouchEvent(motionEvent);
                    }
                }
            }
        }
        return false;
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        this.q0 = true;
        try {
            if (this.f563a == null) {
                super.onLayout(z2, i2, i3, i4, i5);
                return;
            }
            int i6 = i4 - i2;
            int i7 = i5 - i3;
            if (!(this.G == i6 && this.H == i7)) {
                c0();
                M(true);
            }
            this.G = i6;
            this.H = i7;
            this.E = i6;
            this.F = i7;
            this.q0 = false;
        } finally {
            this.q0 = false;
        }
    }

    public void onMeasure(int i2, int i3) {
        if (this.f563a == null) {
            super.onMeasure(i2, i3);
            return;
        }
        boolean z2 = false;
        boolean z3 = (this.h == i2 && this.i == i3) ? false : true;
        if (this.F0) {
            this.F0 = false;
            a0();
            b0();
            z3 = true;
        }
        if (this.mDirtyHierarchy) {
            z3 = true;
        }
        this.h = i2;
        this.i = i3;
        int F2 = this.f563a.F();
        int q2 = this.f563a.q();
        if ((z3 || this.E0.f(F2, q2)) && this.e != -1) {
            super.onMeasure(i2, i3);
            this.E0.e(this.mLayoutWidget, this.f563a.l(F2), this.f563a.l(q2));
            this.E0.h();
            this.E0.i(F2, q2);
        } else {
            if (z3) {
                super.onMeasure(i2, i3);
            }
            z2 = true;
        }
        if (this.h0 || z2) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int Y = this.mLayoutWidget.Y() + getPaddingLeft() + getPaddingRight();
            int z4 = this.mLayoutWidget.z() + paddingTop;
            int i4 = this.m0;
            if (i4 == Integer.MIN_VALUE || i4 == 0) {
                int i5 = this.i0;
                Y = (int) (((float) i5) + (this.o0 * ((float) (this.k0 - i5))));
                requestLayout();
            }
            int i6 = this.n0;
            if (i6 == Integer.MIN_VALUE || i6 == 0) {
                int i7 = this.j0;
                z4 = (int) (((float) i7) + (this.o0 * ((float) (this.l0 - i7))));
                requestLayout();
            }
            setMeasuredDimension(Y, z4);
        }
        N();
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        return false;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    public void onNestedPreScroll(final View view, int i2, int i3, int[] iArr, int i4) {
        MotionScene.Transition transition;
        TouchResponse B2;
        int q2;
        MotionScene motionScene = this.f563a;
        if (motionScene != null && (transition = motionScene.c) != null && transition.C()) {
            int i5 = -1;
            if (!transition.C() || (B2 = transition.B()) == null || (q2 = B2.q()) == -1 || view.getId() == q2) {
                if (motionScene.w()) {
                    TouchResponse B3 = transition.B();
                    if (!(B3 == null || (B3.e() & 4) == 0)) {
                        i5 = i3;
                    }
                    float f2 = this.n;
                    if ((f2 == 1.0f || f2 == 0.0f) && view.canScrollVertically(i5)) {
                        return;
                    }
                }
                if (!(transition.B() == null || (transition.B().e() & 1) == 0)) {
                    float x2 = motionScene.x((float) i2, (float) i3);
                    float f3 = this.o;
                    if ((f3 <= 0.0f && x2 < 0.0f) || (f3 >= 1.0f && x2 > 0.0f)) {
                        view.setNestedScrollingEnabled(false);
                        view.post(new Runnable(this) {
                            public void run() {
                                view.setNestedScrollingEnabled(true);
                            }
                        });
                        return;
                    }
                }
                float f4 = this.n;
                long nanoTime = getNanoTime();
                float f5 = (float) i2;
                this.J = f5;
                float f6 = (float) i3;
                this.K = f6;
                this.M = (float) (((double) (nanoTime - this.L)) * 1.0E-9d);
                this.L = nanoTime;
                motionScene.P(f5, f6);
                if (f4 != this.n) {
                    iArr[0] = i2;
                    iArr[1] = i3;
                }
                M(false);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    this.I = true;
                }
            }
        }
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6) {
    }

    public void onNestedScrollAccepted(View view, View view2, int i2, int i3) {
        this.L = getNanoTime();
        this.M = 0.0f;
        this.J = 0.0f;
        this.K = 0.0f;
    }

    public void onRtlPropertiesChanged(int i2) {
        MotionScene motionScene = this.f563a;
        if (motionScene != null) {
            motionScene.W(isRtl());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r1.c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onStartNestedScroll(android.view.View r1, android.view.View r2, int r3, int r4) {
        /*
            r0 = this;
            androidx.constraintlayout.motion.widget.MotionScene r1 = r0.f563a
            if (r1 == 0) goto L_0x0021
            androidx.constraintlayout.motion.widget.MotionScene$Transition r1 = r1.c
            if (r1 == 0) goto L_0x0021
            androidx.constraintlayout.motion.widget.TouchResponse r1 = r1.B()
            if (r1 == 0) goto L_0x0021
            androidx.constraintlayout.motion.widget.MotionScene r0 = r0.f563a
            androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r0.c
            androidx.constraintlayout.motion.widget.TouchResponse r0 = r0.B()
            int r0 = r0.e()
            r0 = r0 & 2
            if (r0 == 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r0 = 1
            return r0
        L_0x0021:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.onStartNestedScroll(android.view.View, android.view.View, int, int):boolean");
    }

    public void onStopNestedScroll(View view, int i2) {
        MotionScene motionScene = this.f563a;
        if (motionScene != null) {
            float f2 = this.M;
            if (f2 != 0.0f) {
                motionScene.Q(this.J / f2, this.K / f2);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionScene motionScene = this.f563a;
        if (motionScene == null || !this.j || !motionScene.b0()) {
            return super.onTouchEvent(motionEvent);
        }
        MotionScene.Transition transition = this.f563a.c;
        if (transition != null && !transition.C()) {
            return super.onTouchEvent(motionEvent);
        }
        this.f563a.R(motionEvent, getCurrentState(), this);
        if (this.f563a.c.D(4)) {
            return this.f563a.c.B().r();
        }
        return true;
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.R == null) {
                this.R = new CopyOnWriteArrayList();
            }
            this.R.add(motionHelper);
            if (motionHelper.z()) {
                if (this.O == null) {
                    this.O = new ArrayList();
                }
                this.O.add(motionHelper);
            }
            if (motionHelper.y()) {
                if (this.P == null) {
                    this.P = new ArrayList();
                }
                this.P.add(motionHelper);
            }
            if (motionHelper.x()) {
                if (this.Q == null) {
                    this.Q = new ArrayList();
                }
                this.Q.add(motionHelper);
            }
        }
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList arrayList = this.O;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList arrayList2 = this.P;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    public void p0() {
        this.E0.e(this.mLayoutWidget, this.f563a.l(this.e), this.f563a.l(this.g));
        c0();
    }

    public void parseLayoutDescription(int i2) {
        this.mConstraintLayoutSpec = null;
    }

    public void q0(int i2, ConstraintSet constraintSet) {
        MotionScene motionScene = this.f563a;
        if (motionScene != null) {
            motionScene.U(i2, constraintSet);
        }
        p0();
        if (this.f == i2) {
            constraintSet.i(this);
        }
    }

    public void r0(int i2, View... viewArr) {
        MotionScene motionScene = this.f563a;
        if (motionScene != null) {
            motionScene.c0(i2, viewArr);
        } else {
            Log.e("MotionLayout", " no motionScene");
        }
    }

    public void requestLayout() {
        MotionScene motionScene;
        MotionScene.Transition transition;
        if (!this.h0 && this.f == -1 && (motionScene = this.f563a) != null && (transition = motionScene.c) != null) {
            int z2 = transition.z();
            if (z2 != 0) {
                if (z2 == 2) {
                    int childCount = getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        ((MotionController) this.k.get(getChildAt(i2))).z();
                    }
                    return;
                }
            } else {
                return;
            }
        }
        super.requestLayout();
    }

    public void setDebugMode(int i2) {
        this.x = i2;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z2) {
        this.C0 = z2;
    }

    public void setInteractionEnabled(boolean z2) {
        this.j = z2;
    }

    public void setInterpolatedProgress(float f2) {
        if (this.f563a != null) {
            setState(TransitionState.MOVING);
            Interpolator s2 = this.f563a.s();
            if (s2 != null) {
                setProgress(s2.getInterpolation(f2));
                return;
            }
        }
        setProgress(f2);
    }

    public void setOnHide(float f2) {
        ArrayList arrayList = this.P;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((MotionHelper) this.P.get(i2)).setProgress(f2);
            }
        }
    }

    public void setOnShow(float f2) {
        ArrayList arrayList = this.O;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((MotionHelper) this.O.get(i2)).setProgress(f2);
            }
        }
    }

    public void setProgress(float f2) {
        int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i2 < 0 || f2 > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.r0 == null) {
                this.r0 = new StateCache();
            }
            this.r0.e(f2);
            return;
        }
        if (i2 <= 0) {
            if (this.o == 1.0f && this.f == this.g) {
                setState(TransitionState.MOVING);
            }
            this.f = this.e;
            if (this.o == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f2 >= 1.0f) {
            if (this.o == 0.0f && this.f == this.e) {
                setState(TransitionState.MOVING);
            }
            this.f = this.g;
            if (this.o == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.f = -1;
            setState(TransitionState.MOVING);
        }
        if (this.f563a != null) {
            this.r = true;
            this.q = f2;
            this.n = f2;
            this.p = -1;
            this.l = -1;
            this.b = null;
            this.s = true;
            invalidate();
        }
    }

    public void setScene(MotionScene motionScene) {
        this.f563a = motionScene;
        motionScene.W(isRtl());
        c0();
    }

    public void setStartState(int i2) {
        if (!isAttachedToWindow()) {
            if (this.r0 == null) {
                this.r0 = new StateCache();
            }
            this.r0.f(i2);
            this.r0.d(i2);
            return;
        }
        this.f = i2;
    }

    public void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.FINISHED;
        if (transitionState != transitionState2 || this.f != -1) {
            TransitionState transitionState3 = this.D0;
            this.D0 = transitionState;
            TransitionState transitionState4 = TransitionState.MOVING;
            if (transitionState3 == transitionState4 && transitionState == transitionState4) {
                O();
            }
            int i2 = AnonymousClass5.f568a[transitionState3.ordinal()];
            if (i2 == 1 || i2 == 2) {
                if (transitionState == transitionState4) {
                    O();
                }
                if (transitionState == transitionState2) {
                    P();
                }
            } else if (i2 == 3 && transitionState == transitionState2) {
                P();
            }
        }
    }

    public void setTransition(int i2) {
        float f2;
        if (this.f563a != null) {
            MotionScene.Transition U2 = U(i2);
            this.e = U2.A();
            this.g = U2.y();
            if (!isAttachedToWindow()) {
                if (this.r0 == null) {
                    this.r0 = new StateCache();
                }
                this.r0.f(this.e);
                this.r0.d(this.g);
                return;
            }
            int i3 = this.f;
            float f3 = 0.0f;
            if (i3 == this.e) {
                f2 = 0.0f;
            } else {
                f2 = i3 == this.g ? 1.0f : Float.NaN;
            }
            this.f563a.Y(U2);
            this.E0.e(this.mLayoutWidget, this.f563a.l(this.e), this.f563a.l(this.g));
            c0();
            if (this.o != f2) {
                if (f2 == 0.0f) {
                    L(true);
                    this.f563a.l(this.e).i(this);
                } else if (f2 == 1.0f) {
                    L(false);
                    this.f563a.l(this.g).i(this);
                }
            }
            if (!Float.isNaN(f2)) {
                f3 = f2;
            }
            this.o = f3;
            if (Float.isNaN(f2)) {
                Log.v("MotionLayout", Debug.b() + " transitionToStart ");
                k0();
                return;
            }
            setProgress(f2);
        }
    }

    public void setTransitionDuration(int i2) {
        MotionScene motionScene = this.f563a;
        if (motionScene == null) {
            Log.e("MotionLayout", "MotionScene not defined");
        } else {
            motionScene.V(i2);
        }
    }

    public void setTransitionListener(TransitionListener transitionListener) {
        this.u = transitionListener;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.r0 == null) {
            this.r0 = new StateCache();
        }
        this.r0.g(bundle);
        if (isAttachedToWindow()) {
            this.r0.a();
        }
    }

    public String toString() {
        Context context = getContext();
        return Debug.c(context, this.e) + "->" + Debug.c(context, this.g) + " (pos:" + this.o + " Dpos/Dt:" + this.d;
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (!(!this.I && i2 == 0 && i3 == 0)) {
            iArr[0] = iArr[0] + i4;
            iArr[1] = iArr[1] + i5;
        }
        this.I = false;
    }

    public void setState(int i2, int i3, int i4) {
        setState(TransitionState.SETUP);
        this.f = i2;
        this.e = -1;
        this.g = -1;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.d(i2, (float) i3, (float) i4);
            return;
        }
        MotionScene motionScene = this.f563a;
        if (motionScene != null) {
            motionScene.l(i2).i(this);
        }
    }

    public void setTransition(MotionScene.Transition transition) {
        this.f563a.Y(transition);
        setState(TransitionState.SETUP);
        if (this.f == this.f563a.q()) {
            this.o = 1.0f;
            this.n = 1.0f;
            this.q = 1.0f;
        } else {
            this.o = 0.0f;
            this.n = 0.0f;
            this.q = 0.0f;
        }
        this.p = transition.D(1) ? -1 : getNanoTime();
        int F2 = this.f563a.F();
        int q2 = this.f563a.q();
        if (F2 != this.e || q2 != this.g) {
            this.e = F2;
            this.g = q2;
            this.f563a.X(F2, q2);
            this.E0.e(this.mLayoutWidget, this.f563a.l(this.e), this.f563a.l(this.g));
            this.E0.i(this.e, this.g);
            this.E0.h();
            c0();
        }
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        X(attributeSet);
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        X(attributeSet);
    }
}
