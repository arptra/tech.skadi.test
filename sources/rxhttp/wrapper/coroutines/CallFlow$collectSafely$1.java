package rxhttp.wrapper.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "rxhttp.wrapper.coroutines.CallFlow", f = "CallFlow.kt", i = {}, l = {34, 34}, m = "collectSafely", n = {}, s = {})
public final class CallFlow$collectSafely$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CallFlow<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CallFlow$collectSafely$1(CallFlow<T> callFlow, Continuation<? super CallFlow$collectSafely$1> continuation) {
        super(continuation);
        this.this$0 = callFlow;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e((FlowCollector) null, this);
    }
}
