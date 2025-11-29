package com.airbnb.epoxy.stickyheader;

import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/PointF;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class StickyHeaderLinearLayoutManager$computeScrollVectorForPosition$1 extends Lambda implements Function0<PointF> {
    final /* synthetic */ int $targetPosition;
    final /* synthetic */ StickyHeaderLinearLayoutManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StickyHeaderLinearLayoutManager$computeScrollVectorForPosition$1(StickyHeaderLinearLayoutManager stickyHeaderLinearLayoutManager, int i) {
        super(0);
        this.this$0 = stickyHeaderLinearLayoutManager;
        this.$targetPosition = i;
    }

    @Nullable
    public final PointF invoke() {
        return StickyHeaderLinearLayoutManager$computeScrollVectorForPosition$1.super.computeScrollVectorForPosition(this.$targetPosition);
    }
}
