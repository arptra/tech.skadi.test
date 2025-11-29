package com.airbnb.epoxy;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.airbnb.viewmodeladapter.R;
import java.util.List;

@ModelView
public class Carousel extends EpoxyRecyclerView {
    public static SnapHelperFactory m = new SnapHelperFactory() {
        public SnapHelper a(Context context) {
            return new LinearSnapHelper();
        }
    };
    public static int n = 8;
    public float l;

    public static class Padding {

        /* renamed from: a  reason: collision with root package name */
        public final int f2275a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final PaddingType f;

        public enum PaddingType {
            PX,
            DP,
            RESOURCE
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Padding padding = (Padding) obj;
            if (this.f2275a == padding.f2275a && this.b == padding.b && this.c == padding.c && this.d == padding.d) {
                return this.e == padding.e;
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f2275a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e;
        }
    }

    public static abstract class SnapHelperFactory {
        public abstract SnapHelper a(Context context);
    }

    public Carousel(Context context) {
        super(context);
    }

    public static int q(View view) {
        return view.getHeight() > 0 ? view.getHeight() : view.getMeasuredHeight() > 0 ? view.getMeasuredHeight() : view.getContext().getResources().getDisplayMetrics().heightPixels;
    }

    public static int r(View view) {
        return view.getWidth() > 0 ? view.getWidth() : view.getMeasuredWidth() > 0 ? view.getMeasuredWidth() : view.getContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static void setDefaultGlobalSnapHelperFactory(@Nullable SnapHelperFactory snapHelperFactory) {
        m = snapHelperFactory;
    }

    public static void setDefaultItemSpacingDp(@Dimension int i) {
        n = i;
    }

    public void b() {
        super.b();
    }

    @Dimension
    public int getDefaultSpacingBetweenItemsDp() {
        return n;
    }

    public float getNumViewsToShowOnScreen() {
        return this.l;
    }

    @Nullable
    public SnapHelperFactory getSnapHelperFactory() {
        return m;
    }

    public void h() {
        super.h();
        int defaultSpacingBetweenItemsDp = getDefaultSpacingBetweenItemsDp();
        if (defaultSpacingBetweenItemsDp >= 0) {
            setItemSpacingDp(defaultSpacingBetweenItemsDp);
            if (getPaddingLeft() == 0 && getPaddingRight() == 0 && getPaddingTop() == 0 && getPaddingBottom() == 0) {
                setPaddingDp(defaultSpacingBetweenItemsDp);
            }
        }
        SnapHelperFactory snapHelperFactory = getSnapHelperFactory();
        if (snapHelperFactory != null) {
            snapHelperFactory.a(getContext()).attachToRecyclerView(this);
        }
        setRemoveAdapterWhenDetachedFromWindow(false);
    }

    public void onChildAttachedToWindow(View view) {
        if (this.l > 0.0f) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            view.setTag(R.id.epoxy_recycler_view_child_initial_size_id, Integer.valueOf(layoutParams.width));
            int b = getSpacingDecorator().b();
            int i = b > 0 ? (int) (((float) b) * this.l) : 0;
            boolean canScrollHorizontally = getLayoutManager().canScrollHorizontally();
            int p = (int) (((float) (p(canScrollHorizontally) - i)) / this.l);
            if (canScrollHorizontally) {
                layoutParams.width = p;
            } else {
                layoutParams.height = p;
            }
        }
    }

    public void onChildDetachedFromWindow(View view) {
        Object tag = view.getTag(R.id.epoxy_recycler_view_child_initial_size_id);
        if (tag instanceof Integer) {
            view.getLayoutParams().width = ((Integer) tag).intValue();
            view.setTag(R.id.epoxy_recycler_view_child_initial_size_id, (Object) null);
        }
    }

    public final int p(boolean z) {
        int i = 0;
        if (z) {
            int r = r(this) - getPaddingLeft();
            if (getClipToPadding()) {
                i = getPaddingRight();
            }
            return r - i;
        }
        int q = q(this) - getPaddingTop();
        if (getClipToPadding()) {
            i = getPaddingBottom();
        }
        return q - i;
    }

    @ModelProp
    public void setHasFixedSize(boolean z) {
        super.setHasFixedSize(z);
    }

    @ModelProp
    public void setInitialPrefetchItemCount(int i) {
        if (i >= 0) {
            if (i == 0) {
                i = 2;
            }
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).setInitialPrefetchItemCount(i);
                return;
            }
            return;
        }
        throw new IllegalStateException("numItemsToPrefetch must be greater than 0");
    }

    @ModelProp
    public void setModels(@NonNull List<? extends EpoxyModel<?>> list) {
        super.setModels(list);
    }

    @ModelProp
    public void setNumViewsToShowOnScreen(float f) {
        this.l = f;
        setInitialPrefetchItemCount((int) Math.ceil((double) f));
    }

    @ModelProp
    public void setPadding(@Nullable Padding padding) {
        if (padding == null) {
            setPaddingDp(0);
            return;
        }
        Padding.PaddingType paddingType = padding.f;
        if (paddingType == Padding.PaddingType.PX) {
            setPadding(padding.f2275a, padding.b, padding.c, padding.d);
            setItemSpacingPx(padding.e);
        } else if (paddingType == Padding.PaddingType.DP) {
            setPadding(g(padding.f2275a), g(padding.b), g(padding.c), g(padding.d));
            setItemSpacingPx(g(padding.e));
        } else if (paddingType == Padding.PaddingType.RESOURCE) {
            setPadding(l(padding.f2275a), l(padding.b), l(padding.c), l(padding.d));
            setItemSpacingPx(l(padding.e));
        }
    }

    @ModelProp
    public void setPaddingDp(@Dimension int i) {
        if (i == -1) {
            i = getDefaultSpacingBetweenItemsDp();
        }
        int g = g(i);
        setPadding(g, g, g, g);
        setItemSpacingPx(g);
    }

    @ModelProp
    public void setPaddingRes(@DimenRes int i) {
        int l2 = l(i);
        setPadding(l2, l2, l2, l2);
        setItemSpacingPx(l2);
    }

    public Carousel(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Carousel(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
