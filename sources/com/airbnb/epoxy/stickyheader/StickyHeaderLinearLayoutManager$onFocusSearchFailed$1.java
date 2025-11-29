package com.airbnb.epoxy.stickyheader;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class StickyHeaderLinearLayoutManager$onFocusSearchFailed$1 extends Lambda implements Function0<View> {
    final /* synthetic */ int $focusDirection;
    final /* synthetic */ View $focused;
    final /* synthetic */ RecyclerView.Recycler $recycler;
    final /* synthetic */ RecyclerView.State $state;
    final /* synthetic */ StickyHeaderLinearLayoutManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StickyHeaderLinearLayoutManager$onFocusSearchFailed$1(StickyHeaderLinearLayoutManager stickyHeaderLinearLayoutManager, View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        super(0);
        this.this$0 = stickyHeaderLinearLayoutManager;
        this.$focused = view;
        this.$focusDirection = i;
        this.$recycler = recycler;
        this.$state = state;
    }

    @Nullable
    public final View invoke() {
        return StickyHeaderLinearLayoutManager$onFocusSearchFailed$1.super.onFocusSearchFailed(this.$focused, this.$focusDirection, this.$recycler, this.$state);
    }
}
