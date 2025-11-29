package com.upuphone.ar.navi.lite.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SlideRecyclerView extends RecyclerView {

    /* renamed from: a  reason: collision with root package name */
    public VelocityTracker f5851a;
    public int b;
    public Rect c;
    public Scroller d;
    public float e;
    public float f;
    public float g;
    public boolean h;
    public ViewGroup i;
    public int j;
    public int k;

    public SlideRecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void a() {
        ViewGroup viewGroup = this.i;
        if (viewGroup != null && viewGroup.getScrollX() != 0) {
            this.i.scrollTo(0, 0);
        }
    }

    public final void b(MotionEvent motionEvent) {
        if (this.f5851a == null) {
            this.f5851a = VelocityTracker.obtain();
        }
        this.f5851a.addMovement(motionEvent);
    }

    public int c(int i2, int i3) {
        int findFirstVisibleItemPosition = ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition();
        Rect rect = this.c;
        if (rect == null) {
            rect = new Rect();
            this.c = rect;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i2, i3)) {
                    return findFirstVisibleItemPosition + childCount;
                }
            }
        }
        return -1;
    }

    public void computeScroll() {
        if (this.d.computeScrollOffset()) {
            this.i.scrollTo(this.d.getCurrX(), this.d.getCurrY());
            invalidate();
        }
    }

    public final void d() {
        VelocityTracker velocityTracker = this.f5851a;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f5851a.recycle();
            this.f5851a = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0065, code lost:
        if (java.lang.Math.abs(r0 - r7.f) > java.lang.Math.abs(((float) r1) - r7.g)) goto L_0x0067;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            float r0 = r8.getX()
            int r0 = (int) r0
            float r1 = r8.getY()
            int r1 = (int) r1
            r7.b(r8)
            int r2 = r8.getAction()
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x006e
            if (r2 == r4) goto L_0x006a
            if (r2 == r3) goto L_0x001b
            goto L_0x00c6
        L_0x001b:
            android.view.VelocityTracker r2 = r7.f5851a
            r3 = 1000(0x3e8, float:1.401E-42)
            r2.computeCurrentVelocity(r3)
            android.view.VelocityTracker r2 = r7.f5851a
            float r2 = r2.getXVelocity()
            android.view.VelocityTracker r3 = r7.f5851a
            float r3 = r3.getYVelocity()
            float r5 = java.lang.Math.abs(r2)
            r6 = 1142292480(0x44160000, float:600.0)
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x0044
            float r2 = java.lang.Math.abs(r2)
            float r3 = java.lang.Math.abs(r3)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x0067
        L_0x0044:
            float r0 = (float) r0
            float r2 = r7.f
            float r2 = r0 - r2
            float r2 = java.lang.Math.abs(r2)
            int r3 = r7.b
            float r3 = (float) r3
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x00c6
            float r2 = r7.f
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            float r1 = (float) r1
            float r2 = r7.g
            float r1 = r1 - r2
            float r1 = java.lang.Math.abs(r1)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x00c6
        L_0x0067:
            r7.h = r4
            return r4
        L_0x006a:
            r7.d()
            goto L_0x00c6
        L_0x006e:
            android.widget.Scroller r2 = r7.d
            boolean r2 = r2.isFinished()
            if (r2 != 0) goto L_0x007b
            android.widget.Scroller r2 = r7.d
            r2.abortAnimation()
        L_0x007b:
            float r2 = (float) r0
            r7.f = r2
            r7.e = r2
            float r2 = (float) r1
            r7.g = r2
            int r0 = r7.c(r0, r1)
            r7.j = r0
            r1 = -1
            if (r0 == r1) goto L_0x00c6
            android.view.ViewGroup r2 = r7.i
            androidx.recyclerview.widget.RecyclerView$LayoutManager r5 = r7.getLayoutManager()
            androidx.recyclerview.widget.LinearLayoutManager r5 = (androidx.recyclerview.widget.LinearLayoutManager) r5
            int r5 = r5.findFirstVisibleItemPosition()
            int r0 = r0 - r5
            android.view.View r0 = r7.getChildAt(r0)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r7.i = r0
            if (r2 == 0) goto L_0x00af
            if (r0 == r2) goto L_0x00af
            int r0 = r2.getScrollX()
            if (r0 == 0) goto L_0x00af
            r0 = 0
            r2.scrollTo(r0, r0)
        L_0x00af:
            android.view.ViewGroup r0 = r7.i
            int r0 = r0.getChildCount()
            if (r0 != r3) goto L_0x00c4
            android.view.ViewGroup r0 = r7.i
            android.view.View r0 = r0.getChildAt(r4)
            int r0 = r0.getWidth()
            r7.k = r0
            goto L_0x00c6
        L_0x00c4:
            r7.k = r1
        L_0x00c6:
            boolean r7 = super.onInterceptTouchEvent(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.navi.lite.view.SlideRecyclerView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.h || this.j == -1) {
            a();
            d();
            return super.onTouchEvent(motionEvent);
        }
        float x = motionEvent.getX();
        b(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1) {
            if (this.k != -1) {
                int scrollX = this.i.getScrollX();
                this.f5851a.computeCurrentVelocity(1000);
                if (this.f5851a.getXVelocity() < -600.0f) {
                    Scroller scroller = this.d;
                    int i2 = this.k;
                    scroller.startScroll(scrollX, 0, i2 - scrollX, 0, Math.abs(i2 - scrollX));
                } else if (this.f5851a.getXVelocity() >= 600.0f) {
                    this.d.startScroll(scrollX, 0, -scrollX, 0, Math.abs(scrollX));
                } else {
                    int i3 = this.k;
                    if (scrollX >= i3 / 2) {
                        this.d.startScroll(scrollX, 0, i3 - scrollX, 0, Math.abs(i3 - scrollX));
                    } else {
                        this.d.startScroll(scrollX, 0, -scrollX, 0, Math.abs(scrollX));
                    }
                }
                invalidate();
            }
            this.k = -1;
            this.h = false;
            this.j = -1;
            d();
        } else if (action == 2 && this.k != -1) {
            float f2 = this.e - x;
            if (((float) this.i.getScrollX()) + f2 <= ((float) this.k) && ((float) this.i.getScrollX()) + f2 > 0.0f) {
                this.i.scrollBy((int) f2, 0);
            }
            this.e = x;
        }
        return true;
    }

    public SlideRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = ViewConfiguration.get(context).getScaledTouchSlop();
        this.d = new Scroller(context);
    }
}
