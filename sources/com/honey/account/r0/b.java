package com.honey.account.r0;

import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.epoxy.EpoxyVisibilityTracker;

public final /* synthetic */ class b implements RecyclerView.ItemAnimator.ItemAnimatorFinishedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EpoxyVisibilityTracker f3087a;

    public /* synthetic */ b(EpoxyVisibilityTracker epoxyVisibilityTracker) {
        this.f3087a = epoxyVisibilityTracker;
    }

    public final void onAnimationsFinished() {
        EpoxyVisibilityTracker.m(this.f3087a);
    }
}
