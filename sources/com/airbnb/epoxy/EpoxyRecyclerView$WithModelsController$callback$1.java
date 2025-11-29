package com.airbnb.epoxy;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/airbnb/epoxy/EpoxyController;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class EpoxyRecyclerView$WithModelsController$callback$1 extends Lambda implements Function1<EpoxyController, Unit> {
    public static final EpoxyRecyclerView$WithModelsController$callback$1 INSTANCE = new EpoxyRecyclerView$WithModelsController$callback$1();

    public EpoxyRecyclerView$WithModelsController$callback$1() {
        super(1);
    }

    public final void invoke(@NotNull EpoxyController epoxyController) {
        Intrinsics.checkNotNullParameter(epoxyController, "$this$null");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((EpoxyController) obj);
        return Unit.INSTANCE;
    }
}
