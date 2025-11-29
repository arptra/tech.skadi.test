package androidx.paging;

import androidx.paging.HintHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u00042\n\u0010\u0005\u001a\u00060\u0003R\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "prependHint", "Landroidx/paging/HintHandler$HintFlow;", "Landroidx/paging/HintHandler;", "appendHint", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class HintHandler$forceSetHint$2 extends Lambda implements Function2<HintHandler.HintFlow, HintHandler.HintFlow, Unit> {
    final /* synthetic */ LoadType $loadType;
    final /* synthetic */ ViewportHint $viewportHint;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HintHandler$forceSetHint$2(LoadType loadType, ViewportHint viewportHint) {
        super(2);
        this.$loadType = loadType;
        this.$viewportHint = viewportHint;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((HintHandler.HintFlow) obj, (HintHandler.HintFlow) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull HintHandler.HintFlow hintFlow, @NotNull HintHandler.HintFlow hintFlow2) {
        Intrinsics.checkNotNullParameter(hintFlow, "prependHint");
        Intrinsics.checkNotNullParameter(hintFlow2, "appendHint");
        if (this.$loadType == LoadType.PREPEND) {
            hintFlow.c(this.$viewportHint);
        } else {
            hintFlow2.c(this.$viewportHint);
        }
    }
}
