package com.airbnb.epoxy;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class EpoxyRecyclerView$initViewPool$1 extends Lambda implements Function0<RecyclerView.RecycledViewPool> {
    final /* synthetic */ EpoxyRecyclerView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EpoxyRecyclerView$initViewPool$1(EpoxyRecyclerView epoxyRecyclerView) {
        super(0);
        this.this$0 = epoxyRecyclerView;
    }

    @NotNull
    public final RecyclerView.RecycledViewPool invoke() {
        return this.this$0.f();
    }
}
