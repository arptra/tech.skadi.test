package com.airbnb.epoxy;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0006\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\t0\t*\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a!\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004*\u00020\b2\u0006\u0010\r\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/airbnb/epoxy/EpoxyViewHolder;", "", "c", "(Lcom/airbnb/epoxy/EpoxyViewHolder;)Ljava/lang/Object;", "Lcom/airbnb/epoxy/EpoxyModel;", "", "d", "(Lcom/airbnb/epoxy/EpoxyModel;)I", "Lcom/airbnb/epoxy/BaseEpoxyAdapter;", "Lcom/airbnb/epoxy/BoundViewHolders;", "kotlin.jvm.PlatformType", "a", "(Lcom/airbnb/epoxy/BaseEpoxyAdapter;)Lcom/airbnb/epoxy/BoundViewHolders;", "position", "b", "(Lcom/airbnb/epoxy/BaseEpoxyAdapter;I)Lcom/airbnb/epoxy/EpoxyModel;", "epoxy-adapter_release"}, k = 2, mv = {1, 8, 0})
public final class InternalExposerKt {
    public static final BoundViewHolders a(BaseEpoxyAdapter baseEpoxyAdapter) {
        Intrinsics.checkNotNullParameter(baseEpoxyAdapter, "<this>");
        return baseEpoxyAdapter.i();
    }

    public static final EpoxyModel b(BaseEpoxyAdapter baseEpoxyAdapter, int i) {
        Intrinsics.checkNotNullParameter(baseEpoxyAdapter, "<this>");
        return baseEpoxyAdapter.k(i);
    }

    public static final Object c(EpoxyViewHolder epoxyViewHolder) {
        Intrinsics.checkNotNullParameter(epoxyViewHolder, "<this>");
        Object e = epoxyViewHolder.e();
        Intrinsics.checkNotNullExpressionValue(e, "objectToBind()");
        return e;
    }

    public static final int d(EpoxyModel epoxyModel) {
        Intrinsics.checkNotNullParameter(epoxyModel, "<this>");
        return epoxyModel.B();
    }
}
