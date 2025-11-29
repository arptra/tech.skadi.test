package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "T", "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "loadStates", "Landroidx/paging/CombinedLoadStates;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class PagingDataAdapter$withLoadStateHeaderAndFooter$1 extends Lambda implements Function1<CombinedLoadStates, Unit> {
    final /* synthetic */ LoadStateAdapter<?> $footer;
    final /* synthetic */ LoadStateAdapter<?> $header;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagingDataAdapter$withLoadStateHeaderAndFooter$1(LoadStateAdapter<?> loadStateAdapter, LoadStateAdapter<?> loadStateAdapter2) {
        super(1);
        this.$header = loadStateAdapter;
        this.$footer = loadStateAdapter2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CombinedLoadStates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull CombinedLoadStates combinedLoadStates) {
        Intrinsics.checkNotNullParameter(combinedLoadStates, "loadStates");
        this.$header.k(combinedLoadStates.c());
        this.$footer.k(combinedLoadStates.a());
    }
}
