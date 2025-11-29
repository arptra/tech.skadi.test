package androidx.paging;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PagingDataDiffer", f = "PagingDataDiffer.kt", i = {0, 0, 0, 0, 0, 0}, l = {460}, m = "presentNewList", n = {"this", "sourceLoadStates", "mediatorLoadStates", "newPresenter", "onListPresentableCalled", "dispatchLoadStates"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"})
public final class PagingDataDiffer$presentNewList$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PagingDataDiffer<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagingDataDiffer$presentNewList$1(PagingDataDiffer<T> pagingDataDiffer, Continuation<? super PagingDataDiffer$presentNewList$1> continuation) {
        super(continuation);
        this.this$0 = pagingDataDiffer;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.u((List) null, 0, 0, false, (LoadStates) null, (LoadStates) null, (HintReceiver) null, this);
    }
}
