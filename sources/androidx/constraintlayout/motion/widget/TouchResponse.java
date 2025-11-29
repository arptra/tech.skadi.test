package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

class TouchResponse {
    public static final float[][] G = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    public static final float[][] H = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    public float A = 10.0f;
    public float B = 1.0f;
    public float C = Float.NaN;
    public float D = Float.NaN;
    public int E = 0;
    public int F = 0;

    /* renamed from: a  reason: collision with root package name */
    public int f579a = 0;
    public int b = 0;
    public int c = 0;
    public int d = -1;
    public int e = -1;
    public int f = -1;
    public float g = 0.5f;
    public float h = 0.5f;
    public float i = 0.5f;
    public float j = 0.5f;
    public int k = -1;
    public boolean l = false;
    public float m = 0.0f;
    public float n = 1.0f;
    public boolean o = false;
    public float[] p = new float[2];
    public int[] q = new int[2];
    public float r;
    public float s;
    public final MotionLayout t;
    public float u = 4.0f;
    public float v = 1.2f;
    public boolean w = true;
    public float x = 1.0f;
    public int y = 0;
    public float z = 10.0f;

    public TouchResponse(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.t = motionLayout;
        c(context, Xml.asAttributeSet(xmlPullParser));
    }

    public void A() {
        View view;
        int i2 = this.d;
        if (i2 != -1) {
            view = this.t.findViewById(i2);
            if (view == null) {
                Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + Debug.c(this.t.getContext(), this.d));
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new View.OnTouchListener(this) {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return false;
                }
            });
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener(this) {
                public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                }
            });
        }
    }

    public float a(float f2, float f3) {
        return (f2 * this.m) + (f3 * this.n);
    }

    public final void b(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            if (index == R.styleable.OnSwipe_touchAnchorId) {
                this.d = typedArray.getResourceId(index, this.d);
            } else if (index == R.styleable.OnSwipe_touchAnchorSide) {
                int i3 = typedArray.getInt(index, this.f579a);
                this.f579a = i3;
                float[] fArr = G[i3];
                this.h = fArr[0];
                this.g = fArr[1];
            } else if (index == R.styleable.OnSwipe_dragDirection) {
                int i4 = typedArray.getInt(index, this.b);
                this.b = i4;
                float[][] fArr2 = H;
                if (i4 < fArr2.length) {
                    float[] fArr3 = fArr2[i4];
                    this.m = fArr3[0];
                    this.n = fArr3[1];
                } else {
                    this.n = Float.NaN;
                    this.m = Float.NaN;
                    this.l = true;
                }
            } else if (index == R.styleable.OnSwipe_maxVelocity) {
                this.u = typedArray.getFloat(index, this.u);
            } else if (index == R.styleable.OnSwipe_maxAcceleration) {
                this.v = typedArray.getFloat(index, this.v);
            } else if (index == R.styleable.OnSwipe_moveWhenScrollAtTop) {
                this.w = typedArray.getBoolean(index, this.w);
            } else if (index == R.styleable.OnSwipe_dragScale) {
                this.x = typedArray.getFloat(index, this.x);
            } else if (index == R.styleable.OnSwipe_dragThreshold) {
                this.z = typedArray.getFloat(index, this.z);
            } else if (index == R.styleable.OnSwipe_touchRegionId) {
                this.e = typedArray.getResourceId(index, this.e);
            } else if (index == R.styleable.OnSwipe_onTouchUp) {
                this.c = typedArray.getInt(index, this.c);
            } else if (index == R.styleable.OnSwipe_nestedScrollFlags) {
                this.y = typedArray.getInteger(index, 0);
            } else if (index == R.styleable.OnSwipe_limitBoundsTo) {
                this.f = typedArray.getResourceId(index, 0);
            } else if (index == R.styleable.OnSwipe_rotationCenterId) {
                this.k = typedArray.getResourceId(index, this.k);
            } else if (index == R.styleable.OnSwipe_springDamping) {
                this.A = typedArray.getFloat(index, this.A);
            } else if (index == R.styleable.OnSwipe_springMass) {
                this.B = typedArray.getFloat(index, this.B);
            } else if (index == R.styleable.OnSwipe_springStiffness) {
                this.C = typedArray.getFloat(index, this.C);
            } else if (index == R.styleable.OnSwipe_springStopThreshold) {
                this.D = typedArray.getFloat(index, this.D);
            } else if (index == R.styleable.OnSwipe_springBoundary) {
                this.E = typedArray.getInt(index, this.E);
            } else if (index == R.styleable.OnSwipe_autoCompleteMode) {
                this.F = typedArray.getInt(index, this.F);
            }
        }
    }

    public final void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OnSwipe);
        b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public int d() {
        return this.F;
    }

    public int e() {
        return this.y;
    }

    public RectF f(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i2 = this.f;
        if (i2 == -1 || (findViewById = viewGroup.findViewById(i2)) == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    public float g() {
        return this.v;
    }

    public float h() {
        return this.u;
    }

    public boolean i() {
        return this.w;
    }

    public float j(float f2, float f3) {
        this.t.R(this.d, this.t.getProgress(), this.h, this.g, this.p);
        float f4 = this.m;
        if (f4 != 0.0f) {
            float[] fArr = this.p;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (f2 * f4) / fArr[0];
        }
        float[] fArr2 = this.p;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (f3 * this.n) / fArr2[1];
    }

    public int k() {
        return this.E;
    }

    public float l() {
        return this.A;
    }

    public float m() {
        return this.B;
    }

    public float n() {
        return this.C;
    }

    public float o() {
        return this.D;
    }

    public RectF p(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i2 = this.e;
        if (i2 == -1 || (findViewById = viewGroup.findViewById(i2)) == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    public int q() {
        return this.e;
    }

    public boolean r() {
        return this.o;
    }

    public void s(MotionEvent motionEvent, MotionLayout.MotionTracker motionTracker, int i2, MotionScene motionScene) {
        int i3;
        MotionLayout.MotionTracker motionTracker2 = motionTracker;
        if (this.l) {
            t(motionEvent, motionTracker, i2, motionScene);
            return;
        }
        motionTracker2.b(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.r = motionEvent.getRawX();
            this.s = motionEvent.getRawY();
            this.o = false;
        } else if (action == 1) {
            this.o = false;
            motionTracker2.d(1000);
            float e2 = motionTracker.e();
            float c2 = motionTracker.c();
            float progress = this.t.getProgress();
            int i4 = this.d;
            if (i4 != -1) {
                this.t.R(i4, progress, this.h, this.g, this.p);
            } else {
                float min = (float) Math.min(this.t.getWidth(), this.t.getHeight());
                float[] fArr = this.p;
                fArr[1] = this.n * min;
                fArr[0] = min * this.m;
            }
            float f2 = this.m;
            float[] fArr2 = this.p;
            float f3 = f2 != 0.0f ? e2 / fArr2[0] : c2 / fArr2[1];
            float f4 = !Float.isNaN(f3) ? (f3 / 3.0f) + progress : progress;
            if (f4 != 0.0f && f4 != 1.0f && (i3 = this.c) != 3) {
                float f5 = ((double) f4) < 0.5d ? 0.0f : 1.0f;
                if (i3 == 6) {
                    if (progress + f3 < 0.0f) {
                        f3 = Math.abs(f3);
                    }
                    f5 = 1.0f;
                }
                if (this.c == 7) {
                    if (progress + f3 > 1.0f) {
                        f3 = -Math.abs(f3);
                    }
                    f5 = 0.0f;
                }
                this.t.h0(this.c, f5, f3);
                if (0.0f >= progress || 1.0f <= progress) {
                    this.t.setState(MotionLayout.TransitionState.FINISHED);
                }
            } else if (0.0f >= f4 || 1.0f <= f4) {
                this.t.setState(MotionLayout.TransitionState.FINISHED);
            }
        } else if (action == 2) {
            float rawY = motionEvent.getRawY() - this.s;
            float rawX = motionEvent.getRawX() - this.r;
            if (Math.abs((this.m * rawX) + (this.n * rawY)) > this.z || this.o) {
                float progress2 = this.t.getProgress();
                if (!this.o) {
                    this.o = true;
                    this.t.setProgress(progress2);
                }
                int i5 = this.d;
                if (i5 != -1) {
                    this.t.R(i5, progress2, this.h, this.g, this.p);
                } else {
                    float min2 = (float) Math.min(this.t.getWidth(), this.t.getHeight());
                    float[] fArr3 = this.p;
                    fArr3[1] = this.n * min2;
                    fArr3[0] = min2 * this.m;
                }
                float f6 = this.m;
                float[] fArr4 = this.p;
                if (((double) Math.abs(((f6 * fArr4[0]) + (this.n * fArr4[1])) * this.x)) < 0.01d) {
                    float[] fArr5 = this.p;
                    fArr5[0] = 0.01f;
                    fArr5[1] = 0.01f;
                }
                float max = Math.max(Math.min(progress2 + (this.m != 0.0f ? rawX / this.p[0] : rawY / this.p[1]), 1.0f), 0.0f);
                if (this.c == 6) {
                    max = Math.max(max, 0.01f);
                }
                if (this.c == 7) {
                    max = Math.min(max, 0.99f);
                }
                float progress3 = this.t.getProgress();
                if (max != progress3) {
                    int i6 = (progress3 > 0.0f ? 1 : (progress3 == 0.0f ? 0 : -1));
                    if (i6 == 0 || progress3 == 1.0f) {
                        this.t.L(i6 == 0);
                    }
                    this.t.setProgress(max);
                    motionTracker2.d(1000);
                    this.t.d = this.m != 0.0f ? motionTracker.e() / this.p[0] : motionTracker.c() / this.p[1];
                } else {
                    this.t.d = 0.0f;
                }
                this.r = motionEvent.getRawX();
                this.s = motionEvent.getRawY();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x02b1  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x02be  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x02cf  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0320  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void t(android.view.MotionEvent r24, androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker r25, int r26, androidx.constraintlayout.motion.widget.MotionScene r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r25
            r2 = r24
            r1.b(r2)
            int r3 = r24.getAction()
            r4 = 0
            if (r3 == 0) goto L_0x0333
            r5 = 1135869952(0x43b40000, float:360.0)
            r6 = -1
            r9 = 1073741824(0x40000000, float:2.0)
            r10 = 1
            if (r3 == r10) goto L_0x01c1
            r11 = 2
            if (r3 == r11) goto L_0x001d
            goto L_0x0341
        L_0x001d:
            r24.getRawY()
            r24.getRawX()
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.t
            int r3 = r3.getWidth()
            float r3 = (float) r3
            float r3 = r3 / r9
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.t
            int r11 = r11.getHeight()
            float r11 = (float) r11
            float r11 = r11 / r9
            int r12 = r0.k
            if (r12 == r6) goto L_0x006c
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.t
            android.view.View r3 = r3.findViewById(r12)
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.t
            int[] r12 = r0.q
            r11.getLocationOnScreen(r12)
            int[] r11 = r0.q
            r11 = r11[r4]
            float r11 = (float) r11
            int r12 = r3.getLeft()
            int r13 = r3.getRight()
            int r12 = r12 + r13
            float r12 = (float) r12
            float r12 = r12 / r9
            float r11 = r11 + r12
            int[] r12 = r0.q
            r12 = r12[r10]
            float r12 = (float) r12
            int r13 = r3.getTop()
            int r3 = r3.getBottom()
            int r13 = r13 + r3
            float r3 = (float) r13
            float r3 = r3 / r9
            float r3 = r3 + r12
            r22 = r11
            r11 = r3
            r3 = r22
            goto L_0x00b3
        L_0x006c:
            int r12 = r0.d
            if (r12 == r6) goto L_0x00b3
            androidx.constraintlayout.motion.widget.MotionLayout r13 = r0.t
            androidx.constraintlayout.motion.widget.MotionController r12 = r13.T(r12)
            androidx.constraintlayout.motion.widget.MotionLayout r13 = r0.t
            int r12 = r12.h()
            android.view.View r12 = r13.findViewById(r12)
            if (r12 != 0) goto L_0x008a
            java.lang.String r9 = "TouchResponse"
            java.lang.String r12 = "could not find view to animate to"
            android.util.Log.e(r9, r12)
            goto L_0x00b3
        L_0x008a:
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.t
            int[] r11 = r0.q
            r3.getLocationOnScreen(r11)
            int[] r3 = r0.q
            r3 = r3[r4]
            float r3 = (float) r3
            int r11 = r12.getLeft()
            int r13 = r12.getRight()
            int r11 = r11 + r13
            float r11 = (float) r11
            float r11 = r11 / r9
            float r3 = r3 + r11
            int[] r11 = r0.q
            r11 = r11[r10]
            float r11 = (float) r11
            int r13 = r12.getTop()
            int r12 = r12.getBottom()
            int r13 = r13 + r12
            float r12 = (float) r13
            float r12 = r12 / r9
            float r11 = r11 + r12
        L_0x00b3:
            float r9 = r24.getRawX()
            float r9 = r9 - r3
            float r12 = r24.getRawY()
            float r12 = r12 - r11
            float r13 = r24.getRawY()
            float r13 = r13 - r11
            double r13 = (double) r13
            float r15 = r24.getRawX()
            float r15 = r15 - r3
            r27 = r9
            double r8 = (double) r15
            double r8 = java.lang.Math.atan2(r13, r8)
            float r13 = r0.s
            float r13 = r13 - r11
            double r13 = (double) r13
            float r11 = r0.r
            float r11 = r11 - r3
            double r6 = (double) r11
            double r6 = java.lang.Math.atan2(r13, r6)
            double r6 = r8 - r6
            r13 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r6 = r6 * r13
            r13 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r6 = r6 / r13
            float r6 = (float) r6
            r7 = 1134886912(0x43a50000, float:330.0)
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x00f2
            float r6 = r6 - r5
            goto L_0x00f9
        L_0x00f2:
            r7 = -1012596736(0xffffffffc3a50000, float:-330.0)
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x00f9
            float r6 = r6 + r5
        L_0x00f9:
            float r7 = java.lang.Math.abs(r6)
            double r13 = (double) r7
            r16 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r7 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r7 > 0) goto L_0x010b
            boolean r7 = r0.o
            if (r7 == 0) goto L_0x0341
        L_0x010b:
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r0.t
            float r7 = r7.getProgress()
            boolean r11 = r0.o
            if (r11 != 0) goto L_0x011c
            r0.o = r10
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.t
            r11.setProgress(r7)
        L_0x011c:
            int r11 = r0.d
            r3 = -1
            if (r11 == r3) goto L_0x0145
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.t
            float r5 = r0.h
            float r13 = r0.g
            float[] r14 = r0.p
            r16 = r3
            r17 = r11
            r18 = r7
            r19 = r5
            r20 = r13
            r21 = r14
            r16.R(r17, r18, r19, r20, r21)
            float[] r3 = r0.p
            r5 = r3[r10]
            double r13 = (double) r5
            double r13 = java.lang.Math.toDegrees(r13)
            float r5 = (float) r13
            r3[r10] = r5
            goto L_0x0149
        L_0x0145:
            float[] r3 = r0.p
            r3[r10] = r5
        L_0x0149:
            float r3 = r0.x
            float r6 = r6 * r3
            float[] r3 = r0.p
            r3 = r3[r10]
            float r6 = r6 / r3
            float r7 = r7 + r6
            r3 = 1065353216(0x3f800000, float:1.0)
            float r5 = java.lang.Math.min(r7, r3)
            r6 = 0
            float r5 = java.lang.Math.max(r5, r6)
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r0.t
            float r7 = r7.getProgress()
            int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x01ae
            int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x016f
            int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x0177
        L_0x016f:
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.t
            if (r6 != 0) goto L_0x0174
            r4 = r10
        L_0x0174:
            r3.L(r4)
        L_0x0177:
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.t
            r3.setProgress(r5)
            r3 = 1000(0x3e8, float:1.401E-42)
            r1.d(r3)
            float r3 = r25.e()
            float r1 = r25.c()
            double r4 = (double) r1
            double r6 = (double) r3
            double r10 = java.lang.Math.hypot(r4, r6)
            double r3 = java.lang.Math.atan2(r4, r6)
            double r3 = r3 - r8
            double r3 = java.lang.Math.sin(r3)
            double r10 = r10 * r3
            r9 = r27
            double r3 = (double) r9
            double r5 = (double) r12
            double r3 = java.lang.Math.hypot(r3, r5)
            double r10 = r10 / r3
            float r1 = (float) r10
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.t
            double r4 = (double) r1
            double r4 = java.lang.Math.toDegrees(r4)
            float r1 = (float) r4
            r3.d = r1
            goto L_0x01b3
        L_0x01ae:
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r0.t
            r3 = 0
            r1.d = r3
        L_0x01b3:
            float r1 = r24.getRawX()
            r0.r = r1
            float r1 = r24.getRawY()
            r0.s = r1
            goto L_0x0341
        L_0x01c1:
            r0.o = r4
            r6 = 16
            r1.d(r6)
            float r6 = r25.e()
            float r1 = r25.c()
            androidx.constraintlayout.motion.widget.MotionLayout r7 = r0.t
            float r7 = r7.getProgress()
            androidx.constraintlayout.motion.widget.MotionLayout r8 = r0.t
            int r8 = r8.getWidth()
            float r8 = (float) r8
            float r8 = r8 / r9
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.t
            int r11 = r11.getHeight()
            float r11 = (float) r11
            float r11 = r11 / r9
            int r12 = r0.k
            r3 = -1
            if (r12 == r3) goto L_0x021c
            androidx.constraintlayout.motion.widget.MotionLayout r8 = r0.t
            android.view.View r8 = r8.findViewById(r12)
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.t
            int[] r12 = r0.q
            r11.getLocationOnScreen(r12)
            int[] r11 = r0.q
            r4 = r11[r4]
            float r4 = (float) r4
            int r11 = r8.getLeft()
            int r12 = r8.getRight()
            int r11 = r11 + r12
            float r11 = (float) r11
            float r11 = r11 / r9
            float r4 = r4 + r11
            int[] r11 = r0.q
            r11 = r11[r10]
            float r11 = (float) r11
            int r12 = r8.getTop()
            int r8 = r8.getBottom()
        L_0x0216:
            int r12 = r12 + r8
            float r8 = (float) r12
            float r8 = r8 / r9
            float r11 = r11 + r8
            r8 = r4
            goto L_0x0257
        L_0x021c:
            int r12 = r0.d
            r3 = -1
            if (r12 == r3) goto L_0x0257
            androidx.constraintlayout.motion.widget.MotionLayout r8 = r0.t
            androidx.constraintlayout.motion.widget.MotionController r8 = r8.T(r12)
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.t
            int r8 = r8.h()
            android.view.View r8 = r11.findViewById(r8)
            androidx.constraintlayout.motion.widget.MotionLayout r11 = r0.t
            int[] r12 = r0.q
            r11.getLocationOnScreen(r12)
            int[] r11 = r0.q
            r4 = r11[r4]
            float r4 = (float) r4
            int r11 = r8.getLeft()
            int r12 = r8.getRight()
            int r11 = r11 + r12
            float r11 = (float) r11
            float r11 = r11 / r9
            float r4 = r4 + r11
            int[] r11 = r0.q
            r11 = r11[r10]
            float r11 = (float) r11
            int r12 = r8.getTop()
            int r8 = r8.getBottom()
            goto L_0x0216
        L_0x0257:
            float r4 = r24.getRawX()
            float r4 = r4 - r8
            float r2 = r24.getRawY()
            float r2 = r2 - r11
            double r8 = (double) r2
            double r11 = (double) r4
            double r8 = java.lang.Math.atan2(r8, r11)
            double r8 = java.lang.Math.toDegrees(r8)
            int r11 = r0.d
            r3 = -1
            if (r11 == r3) goto L_0x0294
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.t
            float r5 = r0.h
            float r12 = r0.g
            float[] r13 = r0.p
            r16 = r3
            r17 = r11
            r18 = r7
            r19 = r5
            r20 = r12
            r21 = r13
            r16.R(r17, r18, r19, r20, r21)
            float[] r3 = r0.p
            r5 = r3[r10]
            double r11 = (double) r5
            double r11 = java.lang.Math.toDegrees(r11)
            float r5 = (float) r11
            r3[r10] = r5
            goto L_0x0298
        L_0x0294:
            float[] r3 = r0.p
            r3[r10] = r5
        L_0x0298:
            float r1 = r1 + r2
            double r1 = (double) r1
            float r6 = r6 + r4
            double r3 = (double) r6
            double r1 = java.lang.Math.atan2(r1, r3)
            double r1 = java.lang.Math.toDegrees(r1)
            double r1 = r1 - r8
            float r1 = (float) r1
            r2 = 1115291648(0x427a0000, float:62.5)
            float r1 = r1 * r2
            boolean r2 = java.lang.Float.isNaN(r1)
            r3 = 1077936128(0x40400000, float:3.0)
            if (r2 != 0) goto L_0x02be
            float r2 = r1 * r3
            float r4 = r0.x
            float r2 = r2 * r4
            float[] r4 = r0.p
            r4 = r4[r10]
            float r2 = r2 / r4
            float r2 = r2 + r7
        L_0x02bc:
            r4 = 0
            goto L_0x02c0
        L_0x02be:
            r2 = r7
            goto L_0x02bc
        L_0x02c0:
            int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r5 == 0) goto L_0x0320
            r4 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r5 == 0) goto L_0x0320
            int r4 = r0.c
            r5 = 3
            if (r4 == r5) goto L_0x0320
            float r5 = r0.x
            float r1 = r1 * r5
            float[] r5 = r0.p
            r5 = r5[r10]
            float r1 = r1 / r5
            double r5 = (double) r2
            r8 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r2 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x02e0
            r2 = 0
            goto L_0x02e2
        L_0x02e0:
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x02e2:
            r5 = 6
            if (r4 != r5) goto L_0x02f2
            float r2 = r7 + r1
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x02f0
            float r1 = java.lang.Math.abs(r1)
        L_0x02f0:
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x02f2:
            int r4 = r0.c
            r5 = 7
            if (r4 != r5) goto L_0x0305
            float r2 = r7 + r1
            r4 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x0304
            float r1 = java.lang.Math.abs(r1)
            float r1 = -r1
        L_0x0304:
            r2 = 0
        L_0x0305:
            androidx.constraintlayout.motion.widget.MotionLayout r4 = r0.t
            int r5 = r0.c
            float r1 = r1 * r3
            r4.h0(r5, r2, r1)
            r1 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x0318
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 > 0) goto L_0x0341
        L_0x0318:
            androidx.constraintlayout.motion.widget.MotionLayout r0 = r0.t
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r1)
            goto L_0x0341
        L_0x0320:
            r1 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x032b
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x0341
        L_0x032b:
            androidx.constraintlayout.motion.widget.MotionLayout r0 = r0.t
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r1)
            goto L_0x0341
        L_0x0333:
            float r1 = r24.getRawX()
            r0.r = r1
            float r1 = r24.getRawY()
            r0.s = r1
            r0.o = r4
        L_0x0341:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.TouchResponse.t(android.view.MotionEvent, androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker, int, androidx.constraintlayout.motion.widget.MotionScene):void");
    }

    public String toString() {
        if (Float.isNaN(this.m)) {
            return "rotation";
        }
        return this.m + " , " + this.n;
    }

    public void u(float f2, float f3) {
        float progress = this.t.getProgress();
        if (!this.o) {
            this.o = true;
            this.t.setProgress(progress);
        }
        this.t.R(this.d, progress, this.h, this.g, this.p);
        float f4 = this.m;
        float[] fArr = this.p;
        if (((double) Math.abs((f4 * fArr[0]) + (this.n * fArr[1]))) < 0.01d) {
            float[] fArr2 = this.p;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f5 = this.m;
        float max = Math.max(Math.min(progress + (f5 != 0.0f ? (f2 * f5) / this.p[0] : (f3 * this.n) / this.p[1]), 1.0f), 0.0f);
        if (max != this.t.getProgress()) {
            this.t.setProgress(max);
        }
    }

    public void v(float f2, float f3) {
        boolean z2 = false;
        this.o = false;
        float progress = this.t.getProgress();
        this.t.R(this.d, progress, this.h, this.g, this.p);
        float f4 = this.m;
        float[] fArr = this.p;
        float f5 = 0.0f;
        float f6 = f4 != 0.0f ? (f2 * f4) / fArr[0] : (f3 * this.n) / fArr[1];
        if (!Float.isNaN(f6)) {
            progress += f6 / 3.0f;
        }
        if (progress != 0.0f) {
            boolean z3 = progress != 1.0f;
            int i2 = this.c;
            if (i2 != 3) {
                z2 = true;
            }
            if (z2 && z3) {
                MotionLayout motionLayout = this.t;
                if (((double) progress) >= 0.5d) {
                    f5 = 1.0f;
                }
                motionLayout.h0(i2, f5, f6);
            }
        }
    }

    public void w(float f2, float f3) {
        this.r = f2;
        this.s = f3;
    }

    public void x(boolean z2) {
        if (z2) {
            float[][] fArr = H;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = G;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = H;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = G;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[] fArr5 = G[this.f579a];
        this.h = fArr5[0];
        this.g = fArr5[1];
        int i2 = this.b;
        float[][] fArr6 = H;
        if (i2 < fArr6.length) {
            float[] fArr7 = fArr6[i2];
            this.m = fArr7[0];
            this.n = fArr7[1];
        }
    }

    public void y(int i2) {
        this.c = i2;
    }

    public void z(float f2, float f3) {
        this.r = f2;
        this.s = f3;
        this.o = false;
    }
}
