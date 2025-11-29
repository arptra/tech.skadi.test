package androidx.paging;

import androidx.paging.PagedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"androidx/paging/LegacyPageFetcher$loadStateManager$1", "Landroidx/paging/PagedList$LoadStateManager;", "Landroidx/paging/LoadType;", "type", "Landroidx/paging/LoadState;", "state", "", "c", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V", "paging-common"}, k = 1, mv = {1, 8, 0})
public final class LegacyPageFetcher$loadStateManager$1 extends PagedList.LoadStateManager {
    public final /* synthetic */ LegacyPageFetcher d;

    public LegacyPageFetcher$loadStateManager$1(LegacyPageFetcher legacyPageFetcher) {
        this.d = legacyPageFetcher;
    }

    public void c(LoadType loadType, LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadType, "type");
        Intrinsics.checkNotNullParameter(loadState, "state");
        this.d.g().d(loadType, loadState);
    }
}
