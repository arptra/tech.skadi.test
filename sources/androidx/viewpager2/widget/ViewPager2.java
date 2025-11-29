package androidx.viewpager2.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.R;
import androidx.viewpager2.adapter.StatefulAdapter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ViewPager2 extends ViewGroup {
    public static boolean u = true;

    /* renamed from: a  reason: collision with root package name */
    public final Rect f1937a = new Rect();
    public final Rect b = new Rect();
    public CompositeOnPageChangeCallback c = new CompositeOnPageChangeCallback(3);
    public int d;
    public boolean e = false;
    public RecyclerView.AdapterDataObserver f = new DataSetChangeObserver() {
        public void onChanged() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.e = true;
            viewPager2.l.j();
        }
    };
    public LinearLayoutManager g;
    public int h = -1;
    public Parcelable i;
    public RecyclerView j;
    public PagerSnapHelper k;
    public ScrollEventAdapter l;
    public CompositeOnPageChangeCallback m;
    public FakeDrag n;
    public PageTransformerAdapter o;
    public RecyclerView.ItemAnimator p = null;
    public boolean q = false;
    public boolean r = true;
    public int s = -1;
    public AccessibilityProvider t;

    public abstract class AccessibilityProvider {
        public AccessibilityProvider() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int i) {
            return false;
        }

        public boolean c(int i, Bundle bundle) {
            return false;
        }

        public boolean d() {
            return false;
        }

        public void e(RecyclerView.Adapter adapter) {
        }

        public void f(RecyclerView.Adapter adapter) {
        }

        public String g() {
            throw new IllegalStateException("Not implemented.");
        }

        public void h(CompositeOnPageChangeCallback compositeOnPageChangeCallback, RecyclerView recyclerView) {
        }

        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        public void j(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public boolean k(int i) {
            throw new IllegalStateException("Not implemented.");
        }

        public boolean l(int i, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        public void m() {
        }

        public CharSequence n() {
            throw new IllegalStateException("Not implemented.");
        }

        public void o(AccessibilityEvent accessibilityEvent) {
        }

        public void p() {
        }

        public void q() {
        }

        public void r() {
        }

        public void s() {
        }
    }

    public class BasicAccessibilityProvider extends AccessibilityProvider {
        public BasicAccessibilityProvider() {
            super();
        }

        public boolean b(int i) {
            return (i == 8192 || i == 4096) && !ViewPager2.this.e();
        }

        public boolean d() {
            return true;
        }

        public void j(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (!ViewPager2.this.e()) {
                accessibilityNodeInfoCompat.a0(AccessibilityNodeInfoCompat.AccessibilityActionCompat.r);
                accessibilityNodeInfoCompat.a0(AccessibilityNodeInfoCompat.AccessibilityActionCompat.q);
                accessibilityNodeInfoCompat.F0(false);
            }
        }

        public boolean k(int i) {
            if (b(i)) {
                return false;
            }
            throw new IllegalStateException();
        }

        public CharSequence n() {
            if (d()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    public static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        public DataSetChangeObserver() {
        }

        public abstract void onChanged();

        public final void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        public final void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }

        public final void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        public final void onItemRangeChanged(int i, int i2, Object obj) {
            onChanged();
        }
    }

    public class LinearLayoutManagerImpl extends LinearLayoutManager {
        public LinearLayoutManagerImpl(Context context) {
            super(context);
        }

        public void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(state, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
            ViewPager2.this.t.j(accessibilityNodeInfoCompat);
        }

        public boolean performAccessibilityAction(RecyclerView.Recycler recycler, RecyclerView.State state, int i, Bundle bundle) {
            return ViewPager2.this.t.b(i) ? ViewPager2.this.t.k(i) : super.performAccessibilityAction(recycler, state, i, bundle);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }
    }

    @RestrictTo
    @IntRange
    @Retention(RetentionPolicy.SOURCE)
    public @interface OffscreenPageLimit {
    }

    public static abstract class OnPageChangeCallback {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, @Px int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public class PageAwareAccessibilityProvider extends AccessibilityProvider {
        public final AccessibilityViewCommand b = new AccessibilityViewCommand() {
            public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                PageAwareAccessibilityProvider.this.v(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        };
        public final AccessibilityViewCommand c = new AccessibilityViewCommand() {
            public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                PageAwareAccessibilityProvider.this.v(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        };
        public RecyclerView.AdapterDataObserver d;

        public PageAwareAccessibilityProvider() {
            super();
        }

        public boolean a() {
            return true;
        }

        public boolean c(int i, Bundle bundle) {
            return i == 8192 || i == 4096;
        }

        public void e(RecyclerView.Adapter adapter) {
            w();
            if (adapter != null) {
                adapter.registerAdapterDataObserver(this.d);
            }
        }

        public void f(RecyclerView.Adapter adapter) {
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(this.d);
            }
        }

        public String g() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        public void h(CompositeOnPageChangeCallback compositeOnPageChangeCallback, RecyclerView recyclerView) {
            ViewCompat.G0(recyclerView, 2);
            this.d = new DataSetChangeObserver() {
                public void onChanged() {
                    PageAwareAccessibilityProvider.this.w();
                }
            };
            if (ViewCompat.x(ViewPager2.this) == 0) {
                ViewCompat.G0(ViewPager2.this, 1);
            }
        }

        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
            t(accessibilityNodeInfo);
            u(accessibilityNodeInfo);
        }

        public boolean l(int i, Bundle bundle) {
            if (c(i, bundle)) {
                v(i == 8192 ? ViewPager2.this.getCurrentItem() - 1 : ViewPager2.this.getCurrentItem() + 1);
                return true;
            }
            throw new IllegalStateException();
        }

        public void m() {
            w();
        }

        public void o(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(g());
        }

        public void p() {
            w();
        }

        public void q() {
            w();
        }

        public void r() {
            w();
        }

        public void s() {
            w();
        }

        public final void t(AccessibilityNodeInfo accessibilityNodeInfo) {
            int i;
            int i2;
            if (ViewPager2.this.getAdapter() == null) {
                i = 0;
                i2 = 0;
            } else if (ViewPager2.this.getOrientation() == 1) {
                i = ViewPager2.this.getAdapter().getItemCount();
                i2 = 0;
            } else {
                i2 = ViewPager2.this.getAdapter().getItemCount();
                i = 0;
            }
            AccessibilityNodeInfoCompat.P0(accessibilityNodeInfo).j0(AccessibilityNodeInfoCompat.CollectionInfoCompat.b(i, i2, false, 0));
        }

        public final void u(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
            if (adapter != null && (itemCount = adapter.getItemCount()) != 0 && ViewPager2.this.e()) {
                if (ViewPager2.this.d > 0) {
                    accessibilityNodeInfo.addAction(8192);
                }
                if (ViewPager2.this.d < itemCount - 1) {
                    accessibilityNodeInfo.addAction(4096);
                }
                accessibilityNodeInfo.setScrollable(true);
            }
        }

        public void v(int i) {
            if (ViewPager2.this.e()) {
                ViewPager2.this.k(i, true);
            }
        }

        public void w() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i = 16908360;
            ViewCompat.n0(viewPager2, 16908360);
            ViewCompat.n0(viewPager2, 16908361);
            ViewCompat.n0(viewPager2, 16908358);
            ViewCompat.n0(viewPager2, 16908359);
            if (ViewPager2.this.getAdapter() != null && (itemCount = ViewPager2.this.getAdapter().getItemCount()) != 0 && ViewPager2.this.e()) {
                if (ViewPager2.this.getOrientation() == 0) {
                    boolean d2 = ViewPager2.this.d();
                    int i2 = d2 ? 16908360 : 16908361;
                    if (d2) {
                        i = 16908361;
                    }
                    if (ViewPager2.this.d < itemCount - 1) {
                        ViewCompat.p0(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i2, (CharSequence) null), (CharSequence) null, this.b);
                    }
                    if (ViewPager2.this.d > 0) {
                        ViewCompat.p0(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i, (CharSequence) null), (CharSequence) null, this.c);
                        return;
                    }
                    return;
                }
                if (ViewPager2.this.d < itemCount - 1) {
                    ViewCompat.p0(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908359, (CharSequence) null), (CharSequence) null, this.b);
                }
                if (ViewPager2.this.d > 0) {
                    ViewCompat.p0(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908358, (CharSequence) null), (CharSequence) null, this.c);
                }
            }
        }
    }

    public interface PageTransformer {
        void a(View view, float f);
    }

    public class PagerSnapHelperImpl extends PagerSnapHelper {
        public PagerSnapHelperImpl() {
        }

        public View findSnapView(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.c()) {
                return null;
            }
            return super.findSnapView(layoutManager);
        }
    }

    public class RecyclerViewImpl extends RecyclerView {
        public RecyclerViewImpl(Context context) {
            super(context);
        }

        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.t.d() ? ViewPager2.this.t.n() : super.getAccessibilityClassName();
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.d);
            accessibilityEvent.setToIndex(ViewPager2.this.d);
            ViewPager2.this.t.o(accessibilityEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.e() && super.onInterceptTouchEvent(motionEvent);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.e() && super.onTouchEvent(motionEvent);
        }
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollState {
    }

    public static class SmoothScrollToPosition implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final int f1949a;
        public final RecyclerView b;

        public SmoothScrollToPosition(int i, RecyclerView recyclerView) {
            this.f1949a = i;
            this.b = recyclerView;
        }

        public void run() {
            this.b.smoothScrollToPosition(this.f1949a);
        }
    }

    public ViewPager2(@NonNull Context context) {
        super(context);
        b(context, (AttributeSet) null);
    }

    public final RecyclerView.OnChildAttachStateChangeListener a() {
        return new RecyclerView.OnChildAttachStateChangeListener() {
            public void onChildViewAttachedToWindow(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (layoutParams.width != -1 || layoutParams.height != -1) {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }

            public void onChildViewDetachedFromWindow(View view) {
            }
        };
    }

    public final void b(Context context, AttributeSet attributeSet) {
        this.t = u ? new PageAwareAccessibilityProvider() : new BasicAccessibilityProvider();
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.j = recyclerViewImpl;
        recyclerViewImpl.setId(ViewCompat.j());
        this.j.setDescendantFocusability(131072);
        LinearLayoutManagerImpl linearLayoutManagerImpl = new LinearLayoutManagerImpl(context);
        this.g = linearLayoutManagerImpl;
        this.j.setLayoutManager(linearLayoutManagerImpl);
        this.j.setScrollingTouchSlop(1);
        l(context, attributeSet);
        this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.j.addOnChildAttachStateChangeListener(a());
        ScrollEventAdapter scrollEventAdapter = new ScrollEventAdapter(this);
        this.l = scrollEventAdapter;
        this.n = new FakeDrag(this, scrollEventAdapter, this.j);
        PagerSnapHelperImpl pagerSnapHelperImpl = new PagerSnapHelperImpl();
        this.k = pagerSnapHelperImpl;
        pagerSnapHelperImpl.attachToRecyclerView(this.j);
        this.j.addOnScrollListener(this.l);
        CompositeOnPageChangeCallback compositeOnPageChangeCallback = new CompositeOnPageChangeCallback(3);
        this.m = compositeOnPageChangeCallback;
        this.l.m(compositeOnPageChangeCallback);
        AnonymousClass2 r3 = new OnPageChangeCallback() {
            public void onPageScrollStateChanged(int i) {
                if (i == 0) {
                    ViewPager2.this.o();
                }
            }

            public void onPageSelected(int i) {
                ViewPager2 viewPager2 = ViewPager2.this;
                if (viewPager2.d != i) {
                    viewPager2.d = i;
                    viewPager2.t.q();
                }
            }
        };
        AnonymousClass3 r4 = new OnPageChangeCallback() {
            public void onPageSelected(int i) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.j.requestFocus(2);
                }
            }
        };
        this.m.a(r3);
        this.m.a(r4);
        this.t.h(this.m, this.j);
        this.m.a(this.c);
        PageTransformerAdapter pageTransformerAdapter = new PageTransformerAdapter(this.g);
        this.o = pageTransformerAdapter;
        this.m.a(pageTransformerAdapter);
        RecyclerView recyclerView = this.j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    public boolean c() {
        return this.n.a();
    }

    public boolean canScrollHorizontally(int i2) {
        return this.j.canScrollHorizontally(i2);
    }

    public boolean canScrollVertically(int i2) {
        return this.j.canScrollVertically(i2);
    }

    public boolean d() {
        return this.g.getLayoutDirection() == 1;
    }

    public void dispatchRestoreInstanceState(SparseArray sparseArray) {
        Parcelable parcelable = (Parcelable) sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i2 = ((SavedState) parcelable).mRecyclerViewId;
            sparseArray.put(this.j.getId(), sparseArray.get(i2));
            sparseArray.remove(i2);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        i();
    }

    public boolean e() {
        return this.r;
    }

    public final void f(RecyclerView.Adapter adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f);
        }
    }

    public void g(OnPageChangeCallback onPageChangeCallback) {
        this.c.a(onPageChangeCallback);
    }

    @RequiresApi
    public CharSequence getAccessibilityClassName() {
        return this.t.a() ? this.t.g() : super.getAccessibilityClassName();
    }

    @Nullable
    public RecyclerView.Adapter getAdapter() {
        return this.j.getAdapter();
    }

    public int getCurrentItem() {
        return this.d;
    }

    public int getItemDecorationCount() {
        return this.j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.s;
    }

    public int getOrientation() {
        return this.g.getOrientation();
    }

    public int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.j;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.l.f();
    }

    public void h() {
        if (this.o.a() != null) {
            double e2 = this.l.e();
            int i2 = (int) e2;
            float f2 = (float) (e2 - ((double) i2));
            this.o.onPageScrolled(i2, f2, Math.round(((float) getPageSize()) * f2));
        }
    }

    public final void i() {
        RecyclerView.Adapter adapter;
        if (this.h != -1 && (adapter = getAdapter()) != null) {
            Parcelable parcelable = this.i;
            if (parcelable != null) {
                if (adapter instanceof StatefulAdapter) {
                    ((StatefulAdapter) adapter).restoreState(parcelable);
                }
                this.i = null;
            }
            int max = Math.max(0, Math.min(this.h, adapter.getItemCount() - 1));
            this.d = max;
            this.h = -1;
            this.j.scrollToPosition(max);
            this.t.m();
        }
    }

    public void j(int i2, boolean z) {
        if (!c()) {
            k(i2, z);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public void k(int i2, boolean z) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.h != -1) {
                this.h = Math.max(i2, 0);
            }
        } else if (adapter.getItemCount() > 0) {
            int min = Math.min(Math.max(i2, 0), adapter.getItemCount() - 1);
            if (min != this.d || !this.l.h()) {
                int i3 = this.d;
                if (min != i3 || !z) {
                    double d2 = (double) i3;
                    this.d = min;
                    this.t.q();
                    if (!this.l.h()) {
                        d2 = this.l.e();
                    }
                    this.l.k(min, z);
                    if (!z) {
                        this.j.scrollToPosition(min);
                        return;
                    }
                    double d3 = (double) min;
                    if (Math.abs(d3 - d2) > 3.0d) {
                        this.j.scrollToPosition(d3 > d2 ? min - 3 : min + 3);
                        RecyclerView recyclerView = this.j;
                        recyclerView.post(new SmoothScrollToPosition(min, recyclerView));
                        return;
                    }
                    this.j.smoothScrollToPosition(min);
                }
            }
        }
    }

    public final void l(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewPager2);
        saveAttributeDataForStyleable(context, R.styleable.ViewPager2, attributeSet, obtainStyledAttributes, 0, 0);
        try {
            setOrientation(obtainStyledAttributes.getInt(R.styleable.ViewPager2_android_orientation, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void m(RecyclerView.Adapter adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.f);
        }
    }

    public void n(OnPageChangeCallback onPageChangeCallback) {
        this.c.b(onPageChangeCallback);
    }

    public void o() {
        PagerSnapHelper pagerSnapHelper = this.k;
        if (pagerSnapHelper != null) {
            View findSnapView = pagerSnapHelper.findSnapView(this.g);
            if (findSnapView != null) {
                int position = this.g.getPosition(findSnapView);
                if (position != this.d && getScrollState() == 0) {
                    this.m.onPageSelected(position);
                }
                this.e = false;
                return;
            }
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.t.i(accessibilityNodeInfo);
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = this.j.getMeasuredWidth();
        int measuredHeight = this.j.getMeasuredHeight();
        this.f1937a.left = getPaddingLeft();
        this.f1937a.right = (i4 - i2) - getPaddingRight();
        this.f1937a.top = getPaddingTop();
        this.f1937a.bottom = (i5 - i3) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f1937a, this.b);
        RecyclerView recyclerView = this.j;
        Rect rect = this.b;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.e) {
            o();
        }
    }

    public void onMeasure(int i2, int i3) {
        measureChild(this.j, i2, i3);
        int measuredWidth = this.j.getMeasuredWidth();
        int measuredHeight = this.j.getMeasuredHeight();
        int measuredState = this.j.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, measuredState), View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, measuredState << 16));
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.h = savedState.mCurrentItem;
        this.i = savedState.mAdapterState;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mRecyclerViewId = this.j.getId();
        int i2 = this.h;
        if (i2 == -1) {
            i2 = this.d;
        }
        savedState.mCurrentItem = i2;
        Parcelable parcelable = this.i;
        if (parcelable != null) {
            savedState.mAdapterState = parcelable;
        } else {
            RecyclerView.Adapter adapter = this.j.getAdapter();
            if (adapter instanceof StatefulAdapter) {
                savedState.mAdapterState = ((StatefulAdapter) adapter).saveState();
            }
        }
        return savedState;
    }

    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        return this.t.c(i2, bundle) ? this.t.l(i2, bundle) : super.performAccessibilityAction(i2, bundle);
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.j.getAdapter();
        this.t.f(adapter2);
        m(adapter2);
        this.j.setAdapter(adapter);
        this.d = 0;
        i();
        this.t.e(adapter);
        f(adapter);
    }

    public void setCurrentItem(int i2) {
        j(i2, true);
    }

    @RequiresApi
    public void setLayoutDirection(int i2) {
        super.setLayoutDirection(i2);
        this.t.p();
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 >= 1 || i2 == -1) {
            this.s = i2;
            this.j.requestLayout();
            return;
        }
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setOrientation(int i2) {
        this.g.setOrientation(i2);
        this.t.r();
    }

    public void setPageTransformer(@Nullable PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.q) {
                this.p = this.j.getItemAnimator();
                this.q = true;
            }
            this.j.setItemAnimator((RecyclerView.ItemAnimator) null);
        } else if (this.q) {
            this.j.setItemAnimator(this.p);
            this.p = null;
            this.q = false;
        }
        if (pageTransformer != this.o.a()) {
            this.o.b(pageTransformer);
            h();
        }
    }

    public void setUserInputEnabled(boolean z) {
        this.r = z;
        this.t.s();
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        Parcelable mAdapterState;
        int mCurrentItem;
        int mRecyclerViewId;

        @RequiresApi
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            readValues(parcel, classLoader);
        }

        private void readValues(Parcel parcel, ClassLoader classLoader) {
            this.mRecyclerViewId = parcel.readInt();
            this.mCurrentItem = parcel.readInt();
            this.mAdapterState = parcel.readParcelable(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mRecyclerViewId);
            parcel.writeInt(this.mCurrentItem);
            parcel.writeParcelable(this.mAdapterState, i);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            readValues(parcel, (ClassLoader) null);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b(context, attributeSet);
    }
}
