package com.airbnb.epoxy;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\f\b\u0000\u0010\u0003*\u0006\u0012\u0002\b\u00030\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "T", "Lcom/airbnb/epoxy/EpoxyModel;", "V", "it", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class WrappedEpoxyModelClickListener$allViewsInHierarchy$1 extends Lambda implements Function1<View, Sequence<? extends View>> {
    final /* synthetic */ WrappedEpoxyModelClickListener<T, V> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WrappedEpoxyModelClickListener$allViewsInHierarchy$1(WrappedEpoxyModelClickListener<T, V> wrappedEpoxyModelClickListener) {
        super(1);
        this.this$0 = wrappedEpoxyModelClickListener;
    }

    @NotNull
    public final Sequence<View> invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        return SequencesKt.plus(SequencesKt.sequenceOf(view), view instanceof ViewGroup ? this.this$0.b(view) : SequencesKt.emptySequence());
    }
}
