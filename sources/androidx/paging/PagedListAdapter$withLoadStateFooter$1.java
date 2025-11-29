package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "T", "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "loadType", "Landroidx/paging/LoadType;", "loadState", "Landroidx/paging/LoadState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class PagedListAdapter$withLoadStateFooter$1 extends Lambda implements Function2<LoadType, LoadState, Unit> {
    final /* synthetic */ LoadStateAdapter<?> $footer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagedListAdapter$withLoadStateFooter$1(LoadStateAdapter<?> loadStateAdapter) {
        super(2);
        this.$footer = loadStateAdapter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((LoadType) obj, (LoadState) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LoadType loadType, @NotNull LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        if (loadType == LoadType.APPEND) {
            this.$footer.k(loadState);
        }
    }
}
