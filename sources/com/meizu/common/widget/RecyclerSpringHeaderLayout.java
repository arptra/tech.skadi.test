package com.meizu.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import com.honey.account.u2.d;
import flyme.support.v7.widget.MzRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u001e\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB!\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ \u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020:H\u0016J\u0018\u0010>\u001a\u00020:2\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u000fH\u0016J,\u0010?\u001a\u00020:2\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\f2\b\u0010=\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010BH\u0016J4\u0010?\u001a\u00020:2\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\f2\b\u0010=\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010B2\u0006\u0010D\u001a\u00020\fH\u0016J2\u0010E\u001a\u00020:2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u00010BH\u0016J:\u0010E\u001a\u00020:2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u00010B2\u0006\u0010D\u001a\u00020\fH\u0016JB\u0010E\u001a\u00020J2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u00010B2\u0006\u0010D\u001a\u00020\f2\u0006\u0010=\u001a\u00020BH\u0016JD\u0010K\u001a\u00020J2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u00010B2\u0006\u0010D\u001a\u00020\f2\b\u0010=\u001a\u0004\u0018\u00010BH\u0002J\u0010\u0010L\u001a\u00020:2\u0006\u0010D\u001a\u00020\fH\u0016J\b\u0010M\u001a\u00020:H\u0016J(\u0010N\u001a\u00020:2\u0006\u0010O\u001a\u00020(2\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020:H\u0016J \u0010P\u001a\u00020:2\u0006\u0010O\u001a\u00020(2\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u000fH\u0016J(\u0010Q\u001a\u00020J2\u0006\u0010O\u001a\u00020(2\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\f2\u0006\u0010=\u001a\u00020BH\u0016J0\u0010Q\u001a\u00020J2\u0006\u0010O\u001a\u00020(2\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\f2\u0006\u0010=\u001a\u00020B2\u0006\u0010D\u001a\u00020\fH\u0016J0\u0010R\u001a\u00020J2\u0006\u0010O\u001a\u00020(2\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\f2\u0006\u0010=\u001a\u00020B2\u0006\u0010D\u001a\u00020\fH\u0002J0\u0010S\u001a\u00020J2\u0006\u0010O\u001a\u00020(2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\fH\u0016J8\u0010S\u001a\u00020J2\u0006\u0010O\u001a\u00020(2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\f2\u0006\u0010D\u001a\u00020\fH\u0016J@\u0010S\u001a\u00020J2\u0006\u0010O\u001a\u00020(2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\f2\u0006\u0010D\u001a\u00020\f2\u0006\u0010=\u001a\u00020BH\u0016J(\u0010T\u001a\u00020J2\u0006\u0010U\u001a\u00020(2\u0006\u0010O\u001a\u00020(2\u0006\u0010V\u001a\u00020\f2\u0006\u0010D\u001a\u00020\fH\u0016JB\u0010W\u001a\u00020J2\u0006\u0010O\u001a\u00020(2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\f2\u0006\u0010D\u001a\u00020\f2\b\u0010=\u001a\u0004\u0018\u00010BH\u0002J\"\u0010X\u001a\u00020J2\b\u0010O\u001a\u0004\u0018\u00010(2\u0006\u0010Y\u001a\u00020\u000f2\u0006\u0010Z\u001a\u00020\u000fH\u0016J\u001a\u0010[\u001a\u00020J2\b\u0010O\u001a\u0004\u0018\u00010(2\u0006\u0010\\\u001a\u00020\fH\u0016J \u0010]\u001a\u00020:2\u0006\u0010U\u001a\u00020(2\u0006\u0010O\u001a\u00020(2\u0006\u0010^\u001a\u00020\fH\u0016J(\u0010]\u001a\u00020:2\u0006\u0010U\u001a\u00020(2\u0006\u0010O\u001a\u00020(2\u0006\u0010V\u001a\u00020\f2\u0006\u0010D\u001a\u00020\fH\u0016J\u0010\u0010_\u001a\u00020J2\u0006\u0010U\u001a\u00020(H\u0016J\u0018\u0010_\u001a\u00020J2\u0006\u0010O\u001a\u00020(2\u0006\u0010D\u001a\u00020\fH\u0016J\u0010\u0010`\u001a\u00020:2\u0006\u0010V\u001a\u00020\fH\u0016J\u0018\u0010`\u001a\u00020:2\u0006\u0010V\u001a\u00020\f2\u0006\u0010D\u001a\u00020\fH\u0016J\b\u0010a\u001a\u00020JH\u0016J\u0010\u0010a\u001a\u00020J2\u0006\u0010D\u001a\u00020\fH\u0016J\u000e\u0010b\u001a\u00020J2\u0006\u0010c\u001a\u00020\u001dJ\u0010\u0010d\u001a\u00020J2\b\u0010e\u001a\u0004\u0018\u00010(J\b\u0010f\u001a\u00020JH\u0002J\u0010\u0010g\u001a\u00020J2\b\u0010e\u001a\u0004\u0018\u000104R\u0014\u0010\u000e\u001a\u00020\u000fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006h"}, d2 = {"Lcom/meizu/common/widget/RecyclerSpringHeaderLayout;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/NestedScrollingParent3;", "Landroidx/core/view/NestedScrollingChild3;", "Lflyme/support/v7/widget/MzRecyclerView$OverScrollListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "HEAD_RADIO", "", "getHEAD_RADIO", "()F", "OVER_SCROLL_THRESHOLD", "getOVER_SCROLL_THRESHOLD", "TAG", "", "childHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "getChildHelper", "()Landroidx/core/view/NestedScrollingChildHelper;", "setChildHelper", "(Landroidx/core/view/NestedScrollingChildHelper;)V", "content", "Landroid/view/ViewGroup;", "getContent", "()Landroid/view/ViewGroup;", "setContent", "(Landroid/view/ViewGroup;)V", "headerHeight", "getHeaderHeight", "()I", "setHeaderHeight", "(I)V", "headerView", "Landroid/view/View;", "getHeaderView", "()Landroid/view/View;", "setHeaderView", "(Landroid/view/View;)V", "parentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "getParentHelper", "()Landroidx/core/view/NestedScrollingParentHelper;", "setParentHelper", "(Landroidx/core/view/NestedScrollingParentHelper;)V", "recyclerView", "Lflyme/support/v7/widget/MzRecyclerView;", "getRecyclerView", "()Lflyme/support/v7/widget/MzRecyclerView;", "setRecyclerView", "(Lflyme/support/v7/widget/MzRecyclerView;)V", "dispatchNestedFling", "", "velocityX", "velocityY", "consumed", "dispatchNestedPreFling", "dispatchNestedPreScroll", "dx", "dy", "", "offsetInWindow", "type", "dispatchNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "", "dispatchNestedScrollFlyme", "hasNestedScrollingParent", "isNestedScrollingEnabled", "onNestedFling", "target", "onNestedPreFling", "onNestedPreScroll", "onNestedPreScrollInternal", "onNestedScroll", "onNestedScrollAccepted", "child", "axes", "onNestedScrollInternal", "onOverScroll", "translationX", "translationY", "onOverScrollStateChanged", "newState", "onStartNestedScroll", "nestedScrollAxes", "onStopNestedScroll", "startNestedScroll", "stopNestedScroll", "updateContent", "viewGroup", "updateHeaderView", "newView", "updateLayout", "updateRecyclerView", "MeizuCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RecyclerSpringHeaderLayout extends FrameLayout implements NestedScrollingParent3, NestedScrollingChild3, MzRecyclerView.OverScrollListener {
    private final float HEAD_RADIO;
    private final float OVER_SCROLL_THRESHOLD;
    @NotNull
    private final String TAG;
    @Nullable
    private NestedScrollingChildHelper childHelper;
    @Nullable
    private ViewGroup content;
    private int headerHeight;
    @Nullable
    private View headerView;
    @Nullable
    private NestedScrollingParentHelper parentHelper;
    @Nullable
    private MzRecyclerView recyclerView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RecyclerSpringHeaderLayout(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void dispatchNestedScrollFlyme(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        if (iArr2 == null) {
            dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
        } else {
            dispatchNestedScroll(i, i2, i3, i4, iArr, i5, iArr2);
        }
    }

    private final void onNestedPreScrollInternal(View view, int i, int i2, int[] iArr, int i3) {
        int i4;
        if (i2 >= 0 && i2 > (i4 = iArr[1])) {
            View view2 = this.headerView;
            int translationY = view2 != null ? (int) view2.getTranslationY() : 0;
            int i5 = this.headerHeight;
            if (((double) (0 - translationY)) > ((double) i5) + 0.1d) {
                View view3 = this.headerView;
                if (view3 != null) {
                    view3.setTranslationY((float) (0 - i5));
                    return;
                }
                return;
            }
            int i6 = i2 - i4;
            if (i6 > 0 && translationY > 0 - i5) {
                int min = Math.min(i5 + translationY, i6);
                iArr[1] = iArr[1] + min;
                View view4 = this.headerView;
                if (view4 != null) {
                    view4.setTranslationY((float) (translationY - min));
                }
                ViewGroup viewGroup = this.content;
                if (viewGroup != null) {
                    float f = (float) this.headerHeight;
                    View view5 = this.headerView;
                    viewGroup.setTranslationY(f + (view5 != null ? Float.valueOf(view5.getTranslationY()) : 0).floatValue());
                }
            }
        }
    }

    private final void onNestedScrollInternal(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        int i6 = 0;
        if (i4 >= 0) {
            dispatchNestedScrollFlyme(i, 0, i3, i4, (int[]) null, i5, iArr);
            return;
        }
        View view2 = this.headerView;
        int translationY = view2 != null ? (int) view2.getTranslationY() : 0;
        if (translationY >= 0) {
            dispatchNestedScrollFlyme(i, 0, i3, i4, (int[]) null, i5, iArr);
            return;
        }
        if (i4 < 0) {
            i6 = Math.max(i4, translationY);
        }
        if (iArr != null) {
            iArr[1] = iArr[1] + i6;
        }
        int i7 = i4 - i6;
        View view3 = this.headerView;
        if (view3 != null) {
            view3.setTranslationY((float) (translationY - i6));
        }
        ViewGroup viewGroup = this.content;
        if (viewGroup != null) {
            float f = (float) this.headerHeight;
            View view4 = this.headerView;
            viewGroup.setTranslationY(f + (view4 != null ? Float.valueOf(view4.getTranslationY()) : 0).floatValue());
        }
        dispatchNestedScrollFlyme(i, i6, i3, i7, (int[]) null, i5, iArr);
    }

    private final void updateLayout() {
        post(new d(this));
    }

    /* access modifiers changed from: private */
    public static final void updateLayout$lambda$0(RecyclerSpringHeaderLayout recyclerSpringHeaderLayout) {
        Intrinsics.checkNotNullParameter(recyclerSpringHeaderLayout, "this$0");
        View view = recyclerSpringHeaderLayout.headerView;
        if (view != null && recyclerSpringHeaderLayout.content != null) {
            int height = view != null ? view.getHeight() : 0;
            recyclerSpringHeaderLayout.headerHeight = height;
            ViewGroup viewGroup = recyclerSpringHeaderLayout.content;
            if (viewGroup != null) {
                viewGroup.setTranslationY((float) height);
            }
            ViewGroup viewGroup2 = recyclerSpringHeaderLayout.content;
            if (viewGroup2 != null) {
                viewGroup2.setTranslationY((float) recyclerSpringHeaderLayout.headerHeight);
            }
        }
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        NestedScrollingChildHelper nestedScrollingChildHelper = this.childHelper;
        if (nestedScrollingChildHelper != null) {
            return nestedScrollingChildHelper.a(f, f2, z);
        }
        return false;
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        NestedScrollingChildHelper nestedScrollingChildHelper = this.childHelper;
        if (nestedScrollingChildHelper != null) {
            return nestedScrollingChildHelper.b(f, f2);
        }
        return false;
    }

    public boolean dispatchNestedPreScroll(int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2, int i3) {
        NestedScrollingChildHelper nestedScrollingChildHelper = this.childHelper;
        if (nestedScrollingChildHelper != null) {
            return nestedScrollingChildHelper.d(i, i2, iArr, iArr2, i3);
        }
        return false;
    }

    public void dispatchNestedScroll(int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, @NotNull int[] iArr2) {
        Intrinsics.checkNotNullParameter(iArr2, "consumed");
        NestedScrollingChildHelper nestedScrollingChildHelper = this.childHelper;
        if (nestedScrollingChildHelper != null) {
            nestedScrollingChildHelper.e(i, i2, i3, i4, iArr, i5, iArr2);
        }
    }

    @Nullable
    public final NestedScrollingChildHelper getChildHelper() {
        return this.childHelper;
    }

    @Nullable
    public final ViewGroup getContent() {
        return this.content;
    }

    public final float getHEAD_RADIO() {
        return this.HEAD_RADIO;
    }

    public final int getHeaderHeight() {
        return this.headerHeight;
    }

    @Nullable
    public final View getHeaderView() {
        return this.headerView;
    }

    public final float getOVER_SCROLL_THRESHOLD() {
        return this.OVER_SCROLL_THRESHOLD;
    }

    @Nullable
    public final NestedScrollingParentHelper getParentHelper() {
        return this.parentHelper;
    }

    @Nullable
    public final MzRecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public boolean hasNestedScrollingParent(int i) {
        NestedScrollingChildHelper nestedScrollingChildHelper = this.childHelper;
        boolean l = nestedScrollingChildHelper != null ? nestedScrollingChildHelper.l(i) : false;
        String str = this.TAG;
        Log.e(str, "hasNestedScrollingParent:" + l);
        return l;
    }

    public boolean isNestedScrollingEnabled() {
        return true;
    }

    public boolean onNestedFling(@NotNull View view, float f, float f2, boolean z) {
        Intrinsics.checkNotNullParameter(view, "target");
        return dispatchNestedFling(f, f2, true);
    }

    public boolean onNestedPreFling(@NotNull View view, float f, float f2) {
        Intrinsics.checkNotNullParameter(view, "target");
        return dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(@NotNull View view, int i, int i2, @NotNull int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(view, "target");
        Intrinsics.checkNotNullParameter(iArr, "consumed");
        dispatchNestedPreScroll(i, i2, iArr, (int[]) null, i3);
        onNestedPreScrollInternal(view, i, i2, iArr, i3);
    }

    public void onNestedScroll(@NotNull View view, int i, int i2, int i3, int i4, int i5, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(view, "target");
        Intrinsics.checkNotNullParameter(iArr, "consumed");
        onNestedScrollInternal(view, i, i2, i3, i4, i5, iArr);
    }

    public void onNestedScrollAccepted(@NotNull View view, @NotNull View view2, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "child");
        Intrinsics.checkNotNullParameter(view2, "target");
        NestedScrollingParentHelper nestedScrollingParentHelper = this.parentHelper;
        if (nestedScrollingParentHelper != null) {
            nestedScrollingParentHelper.c(view, view2, i, i2);
        }
    }

    public void onOverScroll(@Nullable View view, float f, float f2) {
        View view2;
        if (f2 >= this.OVER_SCROLL_THRESHOLD) {
            View view3 = this.headerView;
            if ((view3 != null ? view3.getTranslationY() : 0.0f) >= ((float) 0) && (view2 = this.headerView) != null) {
                view2.setTranslationY(f2 * this.HEAD_RADIO);
            }
        }
    }

    public void onOverScrollStateChanged(@Nullable View view, int i) {
        View view2;
        if (i == 0) {
            View view3 = this.headerView;
            if ((view3 != null ? view3.getTranslationY() : 0.0f) >= ((float) 0) && (view2 = this.headerView) != null) {
                view2.setTranslationY(0.0f);
            }
        }
    }

    public boolean onStartNestedScroll(@NotNull View view, @NotNull View view2, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "child");
        Intrinsics.checkNotNullParameter(view2, "target");
        if (this.headerHeight == 0) {
            View view3 = this.headerView;
            this.headerHeight = view3 != null ? view3.getHeight() : 0;
        }
        startNestedScroll(i, i2);
        if ((i & 2) == 0 || this.headerView == null || this.recyclerView == null) {
            return false;
        }
        return true;
    }

    public void onStopNestedScroll(@NotNull View view, int i) {
        Intrinsics.checkNotNullParameter(view, "target");
        stopNestedScroll(i);
        NestedScrollingParentHelper nestedScrollingParentHelper = this.parentHelper;
        if (nestedScrollingParentHelper != null) {
            nestedScrollingParentHelper.e(view, i);
        }
    }

    public final void setChildHelper(@Nullable NestedScrollingChildHelper nestedScrollingChildHelper) {
        this.childHelper = nestedScrollingChildHelper;
    }

    public final void setContent(@Nullable ViewGroup viewGroup) {
        this.content = viewGroup;
    }

    public final void setHeaderHeight(int i) {
        this.headerHeight = i;
    }

    public final void setHeaderView(@Nullable View view) {
        this.headerView = view;
    }

    public final void setParentHelper(@Nullable NestedScrollingParentHelper nestedScrollingParentHelper) {
        this.parentHelper = nestedScrollingParentHelper;
    }

    public final void setRecyclerView(@Nullable MzRecyclerView mzRecyclerView) {
        this.recyclerView = mzRecyclerView;
    }

    public boolean startNestedScroll(int i, int i2) {
        NestedScrollingChildHelper nestedScrollingChildHelper = this.childHelper;
        if (nestedScrollingChildHelper != null) {
            return nestedScrollingChildHelper.q(i, i2);
        }
        return false;
    }

    public void stopNestedScroll(int i) {
        NestedScrollingChildHelper nestedScrollingChildHelper = this.childHelper;
        if (nestedScrollingChildHelper != null) {
            nestedScrollingChildHelper.s(i);
        }
    }

    public final void updateContent(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        this.content = viewGroup;
        updateLayout();
    }

    public final void updateHeaderView(@Nullable View view) {
        this.headerView = view;
        updateLayout();
    }

    public final void updateRecyclerView(@Nullable MzRecyclerView mzRecyclerView) {
        MzRecyclerView mzRecyclerView2 = this.recyclerView;
        if (mzRecyclerView2 != null) {
            mzRecyclerView2.removeOverScrollListener(this);
        }
        this.recyclerView = mzRecyclerView;
        if (mzRecyclerView != null) {
            mzRecyclerView.addOnOverScrollListener(this);
        }
        if (this.content == null) {
            MzRecyclerView mzRecyclerView3 = this.recyclerView;
            ViewGroup viewGroup = null;
            ViewParent parent = mzRecyclerView3 != null ? mzRecyclerView3.getParent() : null;
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            }
            this.content = viewGroup;
        }
        updateLayout();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RecyclerSpringHeaderLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public boolean dispatchNestedPreScroll(int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5) {
        NestedScrollingChildHelper nestedScrollingChildHelper = this.childHelper;
        if (nestedScrollingChildHelper != null) {
            return nestedScrollingChildHelper.g(i, i2, i3, i4, iArr, i5);
        }
        return false;
    }

    public void onNestedScroll(@NotNull View view, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(view, "target");
        onNestedScrollInternal(view, i, i2, i3, i4, i5, (int[]) null);
    }

    public boolean startNestedScroll(int i) {
        return startNestedScroll(i, 0);
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecyclerSpringHeaderLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = " [RecyclerSpring] ";
        this.OVER_SCROLL_THRESHOLD = 16.0f;
        this.HEAD_RADIO = 0.13f;
        NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        this.childHelper = nestedScrollingChildHelper;
        nestedScrollingChildHelper.n(true);
        this.parentHelper = new NestedScrollingParentHelper(this);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, @Nullable int[] iArr) {
        NestedScrollingChildHelper nestedScrollingChildHelper = this.childHelper;
        if (nestedScrollingChildHelper != null) {
            return nestedScrollingChildHelper.f(i, i2, i3, i4, iArr);
        }
        return false;
    }

    public void onNestedPreScroll(@NotNull View view, int i, int i2, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(view, "target");
        Intrinsics.checkNotNullParameter(iArr, "consumed");
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    public void onNestedScroll(@NotNull View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(view, "target");
        onNestedScrollInternal(view, i, i2, i3, i4, 0, (int[]) null);
    }

    public void onStopNestedScroll(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "child");
        onStopNestedScroll(view, 0);
    }

    public boolean onStartNestedScroll(@NotNull View view, @NotNull View view2, int i) {
        Intrinsics.checkNotNullParameter(view, "child");
        Intrinsics.checkNotNullParameter(view2, "target");
        return onStartNestedScroll(view, view2, i, 0);
    }
}
