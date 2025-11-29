package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

public class ViewDragHelper {
    public static final Interpolator x = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f964a;
    public int b;
    public int c = -1;
    public float[] d;
    public float[] e;
    public float[] f;
    public float[] g;
    public int[] h;
    public int[] i;
    public int[] j;
    public int k;
    public VelocityTracker l;
    public float m;
    public float n;
    public int o;
    public final int p;
    public int q;
    public OverScroller r;
    public final Callback s;
    public View t;
    public boolean u;
    public final ViewGroup v;
    public final Runnable w = new Runnable() {
        public void run() {
            ViewDragHelper.this.L(0);
        }
    };

    public static abstract class Callback {
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return 0;
        }

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public int getViewHorizontalDragRange(@NonNull View view) {
            return 0;
        }

        public int getViewVerticalDragRange(@NonNull View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(@NonNull View view, int i) {
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        }

        public void onViewReleased(View view, float f, float f2) {
        }

        public abstract boolean tryCaptureView(View view, int i);
    }

    public ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (callback != null) {
            this.v = viewGroup;
            this.s = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int i2 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.p = i2;
            this.o = i2;
            this.b = viewConfiguration.getScaledTouchSlop();
            this.m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.r = new OverScroller(context, x);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    public static ViewDragHelper o(ViewGroup viewGroup, float f2, Callback callback) {
        ViewDragHelper p2 = p(viewGroup, callback);
        p2.b = (int) (((float) p2.b) * (1.0f / f2));
        return p2;
    }

    public static ViewDragHelper p(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    public int A() {
        return this.b;
    }

    public int B() {
        return this.f964a;
    }

    public boolean C(int i2, int i3) {
        return F(this.t, i2, i3);
    }

    public boolean D(int i2) {
        return (this.k & (1 << i2)) != 0;
    }

    public final boolean E(int i2) {
        if (D(i2)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i2 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public boolean F(View view, int i2, int i3) {
        return view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom();
    }

    public void G(MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            b();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked == 0) {
            float x2 = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View u2 = u((int) x2, (int) y);
            J(x2, y, pointerId);
            S(u2, pointerId);
            int i4 = this.h[pointerId];
            int i5 = this.q;
            if ((i4 & i5) != 0) {
                this.s.onEdgeTouched(i4 & i5, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.f964a == 1) {
                H();
            }
            b();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f964a == 1) {
                    q(0.0f, 0.0f);
                }
                b();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x3 = motionEvent.getX(actionIndex);
                float y2 = motionEvent.getY(actionIndex);
                J(x3, y2, pointerId2);
                if (this.f964a == 0) {
                    S(u((int) x3, (int) y2), pointerId2);
                    int i6 = this.h[pointerId2];
                    int i7 = this.q;
                    if ((i6 & i7) != 0) {
                        this.s.onEdgeTouched(i6 & i7, pointerId2);
                    }
                } else if (C((int) x3, (int) y2)) {
                    S(this.t, pointerId2);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                if (this.f964a == 1 && pointerId3 == this.c) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (true) {
                        if (i3 >= pointerCount) {
                            i2 = -1;
                            break;
                        }
                        int pointerId4 = motionEvent.getPointerId(i3);
                        if (pointerId4 != this.c) {
                            View u3 = u((int) motionEvent.getX(i3), (int) motionEvent.getY(i3));
                            View view = this.t;
                            if (u3 == view && S(view, pointerId4)) {
                                i2 = this.c;
                                break;
                            }
                        }
                        i3++;
                    }
                    if (i2 == -1) {
                        H();
                    }
                }
                k(pointerId3);
            }
        } else if (this.f964a != 1) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (i3 < pointerCount2) {
                int pointerId5 = motionEvent.getPointerId(i3);
                if (E(pointerId5)) {
                    float x4 = motionEvent.getX(i3);
                    float y3 = motionEvent.getY(i3);
                    float f2 = x4 - this.d[pointerId5];
                    float f3 = y3 - this.e[pointerId5];
                    I(f2, f3, pointerId5);
                    if (this.f964a != 1) {
                        View u4 = u((int) x4, (int) y3);
                        if (g(u4, f2, f3) && S(u4, pointerId5)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i3++;
            }
            K(motionEvent);
        } else if (E(this.c)) {
            int findPointerIndex = motionEvent.findPointerIndex(this.c);
            float x5 = motionEvent.getX(findPointerIndex);
            float y4 = motionEvent.getY(findPointerIndex);
            float[] fArr = this.f;
            int i8 = this.c;
            int i9 = (int) (x5 - fArr[i8]);
            int i10 = (int) (y4 - this.g[i8]);
            s(this.t.getLeft() + i9, this.t.getTop() + i10, i9, i10);
            K(motionEvent);
        }
    }

    public final void H() {
        this.l.computeCurrentVelocity(1000, this.m);
        q(h(this.l.getXVelocity(this.c), this.n, this.m), h(this.l.getYVelocity(this.c), this.n, this.m));
    }

    public final void I(float f2, float f3, int i2) {
        boolean d2 = d(f2, f3, i2, 1);
        if (d(f3, f2, i2, 4)) {
            d2 |= true;
        }
        if (d(f2, f3, i2, 2)) {
            d2 |= true;
        }
        if (d(f3, f2, i2, 8)) {
            d2 |= true;
        }
        if (d2) {
            int[] iArr = this.i;
            iArr[i2] = iArr[i2] | d2;
            this.s.onEdgeDragStarted(d2 ? 1 : 0, i2);
        }
    }

    public final void J(float f2, float f3, int i2) {
        t(i2);
        float[] fArr = this.d;
        this.f[i2] = f2;
        fArr[i2] = f2;
        float[] fArr2 = this.e;
        this.g[i2] = f3;
        fArr2[i2] = f3;
        this.h[i2] = z((int) f2, (int) f3);
        this.k |= 1 << i2;
    }

    public final void K(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            if (E(pointerId)) {
                float x2 = motionEvent.getX(i2);
                float y = motionEvent.getY(i2);
                this.f[pointerId] = x2;
                this.g[pointerId] = y;
            }
        }
    }

    public void L(int i2) {
        this.v.removeCallbacks(this.w);
        if (this.f964a != i2) {
            this.f964a = i2;
            this.s.onViewDragStateChanged(i2);
            if (this.f964a == 0) {
                this.t = null;
            }
        }
    }

    public void M(int i2) {
        this.o = i2;
    }

    public void N(int i2) {
        this.q = i2;
    }

    public void O(float f2) {
        this.n = f2;
    }

    public boolean P(int i2, int i3) {
        if (this.u) {
            return v(i2, i3, (int) this.l.getXVelocity(this.c), (int) this.l.getYVelocity(this.c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00dd, code lost:
        if (r12 != r11) goto L_0x00e6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean Q(android.view.MotionEvent r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int r2 = r17.getActionMasked()
            int r3 = r17.getActionIndex()
            if (r2 != 0) goto L_0x0011
            r16.b()
        L_0x0011:
            android.view.VelocityTracker r4 = r0.l
            if (r4 != 0) goto L_0x001b
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r0.l = r4
        L_0x001b:
            android.view.VelocityTracker r4 = r0.l
            r4.addMovement(r1)
            r4 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0104
            if (r2 == r6) goto L_0x00ff
            if (r2 == r4) goto L_0x0070
            r7 = 3
            if (r2 == r7) goto L_0x00ff
            r7 = 5
            if (r2 == r7) goto L_0x003c
            r4 = 6
            if (r2 == r4) goto L_0x0034
        L_0x0031:
            r5 = 0
            goto L_0x0135
        L_0x0034:
            int r1 = r1.getPointerId(r3)
            r0.k(r1)
            goto L_0x0031
        L_0x003c:
            int r2 = r1.getPointerId(r3)
            float r7 = r1.getX(r3)
            float r1 = r1.getY(r3)
            r0.J(r7, r1, r2)
            int r3 = r0.f964a
            if (r3 != 0) goto L_0x0060
            int[] r1 = r0.h
            r1 = r1[r2]
            int r3 = r0.q
            r4 = r1 & r3
            if (r4 == 0) goto L_0x0031
            androidx.customview.widget.ViewDragHelper$Callback r4 = r0.s
            r1 = r1 & r3
            r4.onEdgeTouched(r1, r2)
            goto L_0x0031
        L_0x0060:
            if (r3 != r4) goto L_0x0031
            int r3 = (int) r7
            int r1 = (int) r1
            android.view.View r1 = r0.u(r3, r1)
            android.view.View r3 = r0.t
            if (r1 != r3) goto L_0x0031
            r0.S(r1, r2)
            goto L_0x0031
        L_0x0070:
            float[] r2 = r0.d
            if (r2 == 0) goto L_0x0031
            float[] r2 = r0.e
            if (r2 != 0) goto L_0x0079
            goto L_0x0031
        L_0x0079:
            int r2 = r17.getPointerCount()
            r3 = 0
        L_0x007e:
            if (r3 >= r2) goto L_0x00fa
            int r4 = r1.getPointerId(r3)
            boolean r7 = r0.E(r4)
            if (r7 != 0) goto L_0x008c
            goto L_0x00f7
        L_0x008c:
            float r7 = r1.getX(r3)
            float r8 = r1.getY(r3)
            float[] r9 = r0.d
            r9 = r9[r4]
            float r9 = r7 - r9
            float[] r10 = r0.e
            r10 = r10[r4]
            float r10 = r8 - r10
            int r7 = (int) r7
            int r8 = (int) r8
            android.view.View r7 = r0.u(r7, r8)
            if (r7 == 0) goto L_0x00b0
            boolean r8 = r0.g(r7, r9, r10)
            if (r8 == 0) goto L_0x00b0
            r8 = r6
            goto L_0x00b1
        L_0x00b0:
            r8 = 0
        L_0x00b1:
            if (r8 == 0) goto L_0x00e6
            int r11 = r7.getLeft()
            int r12 = (int) r9
            int r13 = r11 + r12
            androidx.customview.widget.ViewDragHelper$Callback r14 = r0.s
            int r12 = r14.clampViewPositionHorizontal(r7, r13, r12)
            int r13 = r7.getTop()
            int r14 = (int) r10
            int r15 = r13 + r14
            androidx.customview.widget.ViewDragHelper$Callback r5 = r0.s
            int r5 = r5.clampViewPositionVertical(r7, r15, r14)
            androidx.customview.widget.ViewDragHelper$Callback r14 = r0.s
            int r14 = r14.getViewHorizontalDragRange(r7)
            androidx.customview.widget.ViewDragHelper$Callback r15 = r0.s
            int r15 = r15.getViewVerticalDragRange(r7)
            if (r14 == 0) goto L_0x00df
            if (r14 <= 0) goto L_0x00e6
            if (r12 != r11) goto L_0x00e6
        L_0x00df:
            if (r15 == 0) goto L_0x00fa
            if (r15 <= 0) goto L_0x00e6
            if (r5 != r13) goto L_0x00e6
            goto L_0x00fa
        L_0x00e6:
            r0.I(r9, r10, r4)
            int r5 = r0.f964a
            if (r5 != r6) goto L_0x00ee
            goto L_0x00fa
        L_0x00ee:
            if (r8 == 0) goto L_0x00f7
            boolean r4 = r0.S(r7, r4)
            if (r4 == 0) goto L_0x00f7
            goto L_0x00fa
        L_0x00f7:
            int r3 = r3 + 1
            goto L_0x007e
        L_0x00fa:
            r16.K(r17)
            goto L_0x0031
        L_0x00ff:
            r16.b()
            goto L_0x0031
        L_0x0104:
            float r2 = r17.getX()
            float r3 = r17.getY()
            r5 = 0
            int r1 = r1.getPointerId(r5)
            r0.J(r2, r3, r1)
            int r2 = (int) r2
            int r3 = (int) r3
            android.view.View r2 = r0.u(r2, r3)
            android.view.View r3 = r0.t
            if (r2 != r3) goto L_0x0125
            int r3 = r0.f964a
            if (r3 != r4) goto L_0x0125
            r0.S(r2, r1)
        L_0x0125:
            int[] r2 = r0.h
            r2 = r2[r1]
            int r3 = r0.q
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0135
            androidx.customview.widget.ViewDragHelper$Callback r4 = r0.s
            r2 = r2 & r3
            r4.onEdgeTouched(r2, r1)
        L_0x0135:
            int r0 = r0.f964a
            if (r0 != r6) goto L_0x013a
            r5 = r6
        L_0x013a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.Q(android.view.MotionEvent):boolean");
    }

    public boolean R(View view, int i2, int i3) {
        this.t = view;
        this.c = -1;
        boolean v2 = v(i2, i3, 0, 0);
        if (!v2 && this.f964a == 0 && this.t != null) {
            this.t = null;
        }
        return v2;
    }

    public boolean S(View view, int i2) {
        if (view == this.t && this.c == i2) {
            return true;
        }
        if (view == null || !this.s.tryCaptureView(view, i2)) {
            return false;
        }
        this.c = i2;
        c(view, i2);
        return true;
    }

    public void a() {
        b();
        if (this.f964a == 2) {
            int currX = this.r.getCurrX();
            int currY = this.r.getCurrY();
            this.r.abortAnimation();
            int currX2 = this.r.getCurrX();
            int currY2 = this.r.getCurrY();
            this.s.onViewPositionChanged(this.t, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        L(0);
    }

    public void b() {
        this.c = -1;
        j();
        VelocityTracker velocityTracker = this.l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.l = null;
        }
    }

    public void c(View view, int i2) {
        if (view.getParent() == this.v) {
            this.t = view;
            this.c = i2;
            this.s.onViewCaptured(view, i2);
            L(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.v + ")");
    }

    public final boolean d(float f2, float f3, int i2, int i3) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.h[i2] & i3) != i3 || (this.q & i3) == 0 || (this.j[i2] & i3) == i3 || (this.i[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.b;
        if (abs <= ((float) i4) && abs2 <= ((float) i4)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.s.onEdgeLock(i3)) {
            return (this.i[i2] & i3) == 0 && abs > ((float) this.b);
        }
        int[] iArr = this.j;
        iArr[i2] = iArr[i2] | i3;
        return false;
    }

    public boolean e(int i2) {
        int length = this.d.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (f(i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public boolean f(int i2, int i3) {
        if (!D(i3)) {
            return false;
        }
        boolean z = (i2 & 1) == 1;
        boolean z2 = (i2 & 2) == 2;
        float f2 = this.f[i3] - this.d[i3];
        float f3 = this.g[i3] - this.e[i3];
        if (!z || !z2) {
            return z ? Math.abs(f2) > ((float) this.b) : z2 && Math.abs(f3) > ((float) this.b);
        }
        int i4 = this.b;
        return (f2 * f2) + (f3 * f3) > ((float) (i4 * i4));
    }

    public final boolean g(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z = this.s.getViewHorizontalDragRange(view) > 0;
        boolean z2 = this.s.getViewVerticalDragRange(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f2) > ((float) this.b) : z2 && Math.abs(f3) > ((float) this.b);
        }
        int i2 = this.b;
        return (f2 * f2) + (f3 * f3) > ((float) (i2 * i2));
    }

    public final float h(float f2, float f3, float f4) {
        float abs = Math.abs(f2);
        if (abs < f3) {
            return 0.0f;
        }
        return abs > f4 ? f2 > 0.0f ? f4 : -f4 : f2;
    }

    public final int i(int i2, int i3, int i4) {
        int abs = Math.abs(i2);
        if (abs < i3) {
            return 0;
        }
        return abs > i4 ? i2 > 0 ? i4 : -i4 : i2;
    }

    public final void j() {
        float[] fArr = this.d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.e, 0.0f);
            Arrays.fill(this.f, 0.0f);
            Arrays.fill(this.g, 0.0f);
            Arrays.fill(this.h, 0);
            Arrays.fill(this.i, 0);
            Arrays.fill(this.j, 0);
            this.k = 0;
        }
    }

    public final void k(int i2) {
        if (this.d != null && D(i2)) {
            this.d[i2] = 0.0f;
            this.e[i2] = 0.0f;
            this.f[i2] = 0.0f;
            this.g[i2] = 0.0f;
            this.h[i2] = 0;
            this.i[i2] = 0;
            this.j[i2] = 0;
            this.k = (~(1 << i2)) & this.k;
        }
    }

    public final int l(int i2, int i3, int i4) {
        if (i2 == 0) {
            return 0;
        }
        int width = this.v.getWidth();
        float f2 = (float) (width / 2);
        float r2 = f2 + (r(Math.min(1.0f, ((float) Math.abs(i2)) / ((float) width))) * f2);
        int abs = Math.abs(i3);
        return Math.min(abs > 0 ? Math.round(Math.abs(r2 / ((float) abs)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i2)) / ((float) i4)) + 1.0f) * 256.0f), 600);
    }

    public final int m(View view, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int i6 = i(i4, (int) this.n, (int) this.m);
        int i7 = i(i5, (int) this.n, (int) this.m);
        int abs = Math.abs(i2);
        int abs2 = Math.abs(i3);
        int abs3 = Math.abs(i6);
        int abs4 = Math.abs(i7);
        int i8 = abs3 + abs4;
        int i9 = abs + abs2;
        if (i6 != 0) {
            f2 = (float) abs3;
            f3 = (float) i8;
        } else {
            f2 = (float) abs;
            f3 = (float) i9;
        }
        float f6 = f2 / f3;
        if (i7 != 0) {
            f4 = (float) abs4;
            f5 = (float) i8;
        } else {
            f4 = (float) abs2;
            f5 = (float) i9;
        }
        float f7 = f4 / f5;
        return (int) ((((float) l(i2, i6, this.s.getViewHorizontalDragRange(view))) * f6) + (((float) l(i3, i7, this.s.getViewVerticalDragRange(view))) * f7));
    }

    public boolean n(boolean z) {
        if (this.f964a == 2) {
            boolean computeScrollOffset = this.r.computeScrollOffset();
            int currX = this.r.getCurrX();
            int currY = this.r.getCurrY();
            int left = currX - this.t.getLeft();
            int top2 = currY - this.t.getTop();
            if (left != 0) {
                ViewCompat.d0(this.t, left);
            }
            if (top2 != 0) {
                ViewCompat.e0(this.t, top2);
            }
            if (!(left == 0 && top2 == 0)) {
                this.s.onViewPositionChanged(this.t, currX, currY, left, top2);
            }
            if (computeScrollOffset && currX == this.r.getFinalX() && currY == this.r.getFinalY()) {
                this.r.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.v.post(this.w);
                } else {
                    L(0);
                }
            }
        }
        return this.f964a == 2;
    }

    public final void q(float f2, float f3) {
        this.u = true;
        this.s.onViewReleased(this.t, f2, f3);
        this.u = false;
        if (this.f964a == 1) {
            L(0);
        }
    }

    public final float r(float f2) {
        return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
    }

    public final void s(int i2, int i3, int i4, int i5) {
        int left = this.t.getLeft();
        int top2 = this.t.getTop();
        if (i4 != 0) {
            i2 = this.s.clampViewPositionHorizontal(this.t, i2, i4);
            ViewCompat.d0(this.t, i2 - left);
        }
        int i6 = i2;
        if (i5 != 0) {
            i3 = this.s.clampViewPositionVertical(this.t, i3, i5);
            ViewCompat.e0(this.t, i3 - top2);
        }
        int i7 = i3;
        if (i4 != 0 || i5 != 0) {
            this.s.onViewPositionChanged(this.t, i6, i7, i6 - left, i7 - top2);
        }
    }

    public final void t(int i2) {
        float[] fArr = this.d;
        if (fArr == null || fArr.length <= i2) {
            int i3 = i2 + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.d = fArr2;
            this.e = fArr3;
            this.f = fArr4;
            this.g = fArr5;
            this.h = iArr;
            this.i = iArr2;
            this.j = iArr3;
        }
    }

    public View u(int i2, int i3) {
        for (int childCount = this.v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.v.getChildAt(this.s.getOrderedChildIndex(childCount));
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean v(int i2, int i3, int i4, int i5) {
        int left = this.t.getLeft();
        int top2 = this.t.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top2;
        if (i6 == 0 && i7 == 0) {
            this.r.abortAnimation();
            L(0);
            return false;
        }
        this.r.startScroll(left, top2, i6, i7, m(this.t, i6, i7, i4, i5));
        L(2);
        return true;
    }

    public View w() {
        return this.t;
    }

    public int x() {
        return this.p;
    }

    public int y() {
        return this.o;
    }

    public final int z(int i2, int i3) {
        int i4 = i2 < this.v.getLeft() + this.o ? 1 : 0;
        if (i3 < this.v.getTop() + this.o) {
            i4 |= 4;
        }
        if (i2 > this.v.getRight() - this.o) {
            i4 |= 2;
        }
        return i3 > this.v.getBottom() - this.o ? i4 | 8 : i4;
    }
}
