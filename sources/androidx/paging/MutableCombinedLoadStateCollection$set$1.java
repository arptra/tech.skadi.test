package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/paging/CombinedLoadStates;", "currState", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class MutableCombinedLoadStateCollection$set$1 extends Lambda implements Function1<CombinedLoadStates, CombinedLoadStates> {
    final /* synthetic */ LoadStates $remoteLoadStates;
    final /* synthetic */ LoadStates $sourceLoadStates;
    final /* synthetic */ MutableCombinedLoadStateCollection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MutableCombinedLoadStateCollection$set$1(MutableCombinedLoadStateCollection mutableCombinedLoadStateCollection, LoadStates loadStates, LoadStates loadStates2) {
        super(1);
        this.this$0 = mutableCombinedLoadStateCollection;
        this.$sourceLoadStates = loadStates;
        this.$remoteLoadStates = loadStates2;
    }

    @NotNull
    public final CombinedLoadStates invoke(@Nullable CombinedLoadStates combinedLoadStates) {
        return this.this$0.c(combinedLoadStates, this.$sourceLoadStates, this.$remoteLoadStates);
    }
}
