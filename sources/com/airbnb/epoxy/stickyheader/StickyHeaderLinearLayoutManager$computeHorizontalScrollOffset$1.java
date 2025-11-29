package com.airbnb.epoxy.stickyheader;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class StickyHeaderLinearLayoutManager$computeHorizontalScrollOffset$1 extends Lambda implements Function0<Integer> {
    final /* synthetic */ RecyclerView.State $state;
    final /* synthetic */ StickyHeaderLinearLayoutManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StickyHeaderLinearLayoutManager$computeHorizontalScrollOffset$1(StickyHeaderLinearLayoutManager stickyHeaderLinearLayoutManager, RecyclerView.State state) {
        super(0);
        this.this$0 = stickyHeaderLinearLayoutManager;
        this.$state = state;
    }

    @NotNull
    public final Integer invoke() {
        return Integer.valueOf(StickyHeaderLinearLayoutManager$computeHorizontalScrollOffset$1.super.computeHorizontalScrollOffset(this.$state));
    }
}
