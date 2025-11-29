package com.scwang.smart.refresh.layout.util;

import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ScrollingView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.scwang.smart.refresh.layout.api.RefreshComponent;
import com.scwang.smart.refresh.layout.kernel.R;

public class SmartUtil implements Interpolator {
    public static int b = 0;
    public static int c = 1;
    public static float d = Resources.getSystem().getDisplayMetrics().density;
    public static final float e;
    public static final float f;

    /* renamed from: a  reason: collision with root package name */
    public int f9868a;

    static {
        float k = 1.0f / k(1.0f);
        e = k;
        f = 1.0f - (k * k(1.0f));
    }

    public SmartUtil(int i) {
        this.f9868a = i;
    }

    public static boolean a(View view, PointF pointF, boolean z) {
        if (view.canScrollVertically(1) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null && !f(view)) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (g(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    Object tag = childAt.getTag(R.id.srl_tag);
                    if ("fixed".equals(tag) || "fixed-top".equals(tag)) {
                        return false;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean a2 = a(childAt, pointF, z);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return a2;
                }
            }
        }
        return z || view.canScrollVertically(-1);
    }

    public static boolean b(View view, PointF pointF) {
        if (view.canScrollVertically(-1) && view.getVisibility() == 0) {
            return false;
        }
        if (!(view instanceof ViewGroup) || pointF == null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        PointF pointF2 = new PointF();
        for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (g(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                Object tag = childAt.getTag(R.id.srl_tag);
                if ("fixed".equals(tag) || "fixed-bottom".equals(tag)) {
                    return false;
                }
                pointF.offset(pointF2.x, pointF2.y);
                boolean b2 = b(childAt, pointF);
                pointF.offset(-pointF2.x, -pointF2.y);
                return b2;
            }
        }
        return true;
    }

    public static int c(float f2) {
        return (int) ((f2 * d) + 0.5f);
    }

    public static void d(View view, int i) {
        if (view instanceof ScrollView) {
            ((ScrollView) view).fling(i);
        } else if (view instanceof AbsListView) {
            ((AbsListView) view).fling(i);
        } else if (view instanceof WebView) {
            ((WebView) view).flingScroll(0, i);
        } else if (view instanceof NestedScrollView) {
            ((NestedScrollView) view).fling(i);
        } else if (view instanceof RecyclerView) {
            ((RecyclerView) view).fling(0, i);
        }
    }

    public static boolean e(View view) {
        if (view instanceof RefreshComponent) {
            return false;
        }
        return f(view) || (view instanceof ViewPager) || (view instanceof NestedScrollingParent);
    }

    public static boolean f(View view) {
        if (view instanceof RefreshComponent) {
            return false;
        }
        return (view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof ScrollingView) || (view instanceof WebView) || (view instanceof NestedScrollingChild);
    }

    public static boolean g(View view, View view2, float f2, float f3, PointF pointF) {
        if (view2.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f2, f3};
        fArr[0] = ((float) (view.getScrollX() - view2.getLeft())) + f2;
        float scrollY = fArr[1] + ((float) (view.getScrollY() - view2.getTop()));
        fArr[1] = scrollY;
        float f4 = fArr[0];
        boolean z = f4 >= 0.0f && scrollY >= 0.0f && f4 < ((float) view2.getWidth()) && fArr[1] < ((float) view2.getHeight());
        if (z && pointF != null) {
            pointF.set(fArr[0] - f2, fArr[1] - f3);
        }
        return z;
    }

    public static int h(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        view.measure(childMeasureSpec, i > 0 ? View.MeasureSpec.makeMeasureSpec(i, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight();
    }

    public static float i(int i) {
        return ((float) i) / d;
    }

    public static void j(AbsListView absListView, int i) {
        absListView.scrollListBy(i);
    }

    public static float k(float f2) {
        float f3 = f2 * 8.0f;
        return f3 < 1.0f ? f3 - (1.0f - ((float) Math.exp((double) (-f3)))) : 0.36787945f + ((1.0f - ((float) Math.exp((double) (1.0f - f3)))) * 0.63212055f);
    }

    public float getInterpolation(float f2) {
        if (this.f9868a == c) {
            float f3 = 1.0f - f2;
            return 1.0f - (f3 * f3);
        }
        float k = e * k(f2);
        return k > 0.0f ? k + f : k;
    }
}
