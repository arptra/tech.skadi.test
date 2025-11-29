package com.scwang.smart.refresh.layout.wrapper;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.viewpager.widget.ViewPager;
import com.scwang.smart.refresh.layout.api.RefreshContent;
import com.scwang.smart.refresh.layout.api.RefreshKernel;
import com.scwang.smart.refresh.layout.kernel.R;
import com.scwang.smart.refresh.layout.listener.CoordinatorLayoutListener;
import com.scwang.smart.refresh.layout.listener.ScrollBoundaryDecider;
import com.scwang.smart.refresh.layout.simple.SimpleBoundaryDecider;
import com.scwang.smart.refresh.layout.util.DesignUtil;
import com.scwang.smart.refresh.layout.util.SmartUtil;
import java.util.LinkedList;

public class RefreshContentWrapper implements RefreshContent, CoordinatorLayoutListener, ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public View f9869a;
    public View b;
    public View c;
    public View d;
    public View e;
    public int f = 0;
    public boolean g = true;
    public boolean h = true;
    public SimpleBoundaryDecider i = new SimpleBoundaryDecider();

    public RefreshContentWrapper(View view) {
        this.c = view;
        this.b = view;
        this.f9869a = view;
    }

    public void a(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        pointF.offset((float) (-this.f9869a.getLeft()), (float) (-this.f9869a.getTop()));
        View view = this.c;
        View view2 = this.f9869a;
        if (view != view2) {
            this.c = l(view2, pointF, view);
        }
        if (this.c == this.f9869a) {
            this.i.f9865a = null;
        } else {
            this.i.f9865a = pointF;
        }
    }

    public void b(boolean z) {
        this.i.c = z;
    }

    public ValueAnimator.AnimatorUpdateListener c(int i2) {
        View view = this.c;
        if (view == null || i2 == 0) {
            return null;
        }
        if ((i2 >= 0 || !view.canScrollVertically(1)) && (i2 <= 0 || !this.c.canScrollVertically(-1))) {
            return null;
        }
        this.f = i2;
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(int r6, int r7, int r8) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            r3 = -1
            if (r7 == r3) goto L_0x0021
            android.view.View r4 = r5.b
            android.view.View r7 = r4.findViewById(r7)
            if (r7 == 0) goto L_0x0021
            if (r6 <= 0) goto L_0x0016
            float r4 = (float) r6
            r7.setTranslationY(r4)
            r7 = r0
            goto L_0x0022
        L_0x0016:
            float r4 = r7.getTranslationY()
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 <= 0) goto L_0x0021
            r7.setTranslationY(r1)
        L_0x0021:
            r7 = r2
        L_0x0022:
            if (r8 == r3) goto L_0x003e
            android.view.View r3 = r5.b
            android.view.View r8 = r3.findViewById(r8)
            if (r8 == 0) goto L_0x003e
            if (r6 >= 0) goto L_0x0033
            float r7 = (float) r6
            r8.setTranslationY(r7)
            goto L_0x003f
        L_0x0033:
            float r0 = r8.getTranslationY()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x003e
            r8.setTranslationY(r1)
        L_0x003e:
            r0 = r7
        L_0x003f:
            if (r0 != 0) goto L_0x0048
            android.view.View r7 = r5.b
            float r8 = (float) r6
            r7.setTranslationY(r8)
            goto L_0x004d
        L_0x0048:
            android.view.View r7 = r5.b
            r7.setTranslationY(r1)
        L_0x004d:
            android.view.View r7 = r5.d
            if (r7 == 0) goto L_0x0059
            int r8 = java.lang.Math.max(r2, r6)
            float r8 = (float) r8
            r7.setTranslationY(r8)
        L_0x0059:
            android.view.View r5 = r5.e
            if (r5 == 0) goto L_0x0065
            int r6 = java.lang.Math.min(r2, r6)
            float r6 = (float) r6
            r5.setTranslationY(r6)
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.wrapper.RefreshContentWrapper.d(int, int, int):void");
    }

    public boolean e() {
        return this.h && this.i.a(this.f9869a);
    }

    public void f(ScrollBoundaryDecider scrollBoundaryDecider) {
        if (scrollBoundaryDecider instanceof SimpleBoundaryDecider) {
            this.i = (SimpleBoundaryDecider) scrollBoundaryDecider;
        } else {
            this.i.b = scrollBoundaryDecider;
        }
    }

    public void g(RefreshKernel refreshKernel, View view, View view2) {
        k(this.f9869a, refreshKernel);
        if (view != null || view2 != null) {
            this.d = view;
            this.e = view2;
            FrameLayout frameLayout = new FrameLayout(this.f9869a.getContext());
            int indexOfChild = refreshKernel.b().getLayout().indexOfChild(this.f9869a);
            refreshKernel.b().getLayout().removeView(this.f9869a);
            frameLayout.addView(this.f9869a, 0, new ViewGroup.LayoutParams(-1, -1));
            refreshKernel.b().getLayout().addView(frameLayout, indexOfChild, this.f9869a.getLayoutParams());
            this.f9869a = frameLayout;
            if (view != null) {
                view.setTag(R.id.srl_tag, "fixed-top");
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                int indexOfChild2 = viewGroup.indexOfChild(view);
                viewGroup.removeView(view);
                layoutParams.height = SmartUtil.h(view);
                viewGroup.addView(new Space(this.f9869a.getContext()), indexOfChild2, layoutParams);
                frameLayout.addView(view, 1, layoutParams);
            }
            if (view2 != null) {
                view2.setTag(R.id.srl_tag, "fixed-bottom");
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
                int indexOfChild3 = viewGroup2.indexOfChild(view2);
                viewGroup2.removeView(view2);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(layoutParams2);
                layoutParams2.height = SmartUtil.h(view2);
                viewGroup2.addView(new Space(this.f9869a.getContext()), indexOfChild3, layoutParams2);
                layoutParams3.gravity = 80;
                frameLayout.addView(view2, 1, layoutParams3);
            }
        }
    }

    public View getView() {
        return this.f9869a;
    }

    public View h() {
        return this.c;
    }

    public boolean i() {
        return this.g && this.i.b(this.f9869a);
    }

    public void j(boolean z, boolean z2) {
        this.g = z;
        this.h = z2;
    }

    public void k(View view, RefreshKernel refreshKernel) {
        boolean isInEditMode = this.f9869a.isInEditMode();
        View view2 = null;
        while (true) {
            if (view2 != null && (!(view2 instanceof NestedScrollingParent) || (view2 instanceof NestedScrollingChild))) {
                break;
            }
            view = m(view, view2 == null);
            if (view == view2) {
                break;
            }
            if (!isInEditMode) {
                DesignUtil.a(view, refreshKernel, this);
            }
            view2 = view;
        }
        if (view2 != null) {
            this.c = view2;
        }
    }

    public View l(View view, PointF pointF, View view2) {
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            PointF pointF2 = new PointF();
            while (childCount > 0) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (!SmartUtil.g(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    childCount--;
                } else if (!(childAt instanceof ViewPager) && SmartUtil.e(childAt)) {
                    return childAt;
                } else {
                    pointF.offset(pointF2.x, pointF2.y);
                    View l = l(childAt, pointF, view2);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return l;
                }
            }
        }
        return view2;
    }

    public View m(View view, boolean z) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        View view2 = null;
        while (linkedList.size() > 0 && view2 == null) {
            View view3 = (View) linkedList.poll();
            if (view3 != null) {
                if ((z || view3 != view) && SmartUtil.e(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        linkedList.add(viewGroup.getChildAt(i2));
                    }
                }
            }
        }
        return view2 == null ? view : view2;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            float scaleY = ((float) (intValue - this.f)) * this.c.getScaleY();
            View view = this.c;
            if (view instanceof AbsListView) {
                SmartUtil.j((AbsListView) view, (int) scaleY);
            } else {
                view.scrollBy(0, (int) scaleY);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f = intValue;
    }
}
