package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/paging/CombinedLoadStates;", "currState", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class MutableCombinedLoadStateCollection$set$2 extends Lambda implements Function1<CombinedLoadStates, CombinedLoadStates> {
    final /* synthetic */ boolean $remote;
    final /* synthetic */ LoadState $state;
    final /* synthetic */ LoadType $type;
    final /* synthetic */ MutableCombinedLoadStateCollection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MutableCombinedLoadStateCollection$set$2(boolean z, LoadType loadType, LoadState loadState, MutableCombinedLoadStateCollection mutableCombinedLoadStateCollection) {
        super(1);
        this.$remote = z;
        this.$type = loadType;
        this.$state = loadState;
        this.this$0 = mutableCombinedLoadStateCollection;
    }

    @NotNull
    public final CombinedLoadStates invoke(@Nullable CombinedLoadStates combinedLoadStates) {
        LoadStates loadStates;
        LoadStates loadStates2;
        if (combinedLoadStates == null || (loadStates = combinedLoadStates.e()) == null) {
            loadStates = LoadStates.d.a();
        }
        if (combinedLoadStates == null || (loadStates2 = combinedLoadStates.b()) == null) {
            loadStates2 = LoadStates.d.a();
        }
        if (this.$remote) {
            loadStates2 = loadStates2.g(this.$type, this.$state);
        } else {
            loadStates = loadStates.g(this.$type, this.$state);
        }
        return this.this$0.c(combinedLoadStates, loadStates, loadStates2);
    }
}
