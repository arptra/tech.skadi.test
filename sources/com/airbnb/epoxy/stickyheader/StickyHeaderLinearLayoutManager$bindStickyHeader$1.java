package com.airbnb.epoxy.stickyheader;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager$bindStickyHeader$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "epoxy-adapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StickyHeaderLinearLayoutManager$bindStickyHeader$1 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f2335a;
    public final /* synthetic */ StickyHeaderLinearLayoutManager b;

    public StickyHeaderLinearLayoutManager$bindStickyHeader$1(View view, StickyHeaderLinearLayoutManager stickyHeaderLinearLayoutManager) {
        this.f2335a = view;
        this.b = stickyHeaderLinearLayoutManager;
    }

    public void onGlobalLayout() {
        this.f2335a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        if (this.b.h != -1) {
            StickyHeaderLinearLayoutManager stickyHeaderLinearLayoutManager = this.b;
            stickyHeaderLinearLayoutManager.scrollToPositionWithOffset(stickyHeaderLinearLayoutManager.h, this.b.i);
            this.b.J(-1, Integer.MIN_VALUE);
        }
    }
}
