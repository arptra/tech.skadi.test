package kotlinx.coroutines.rx3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx3.RxObservableCoroutine", f = "RxObservable.kt", i = {0, 0}, l = {117}, m = "send", n = {"this", "element"}, s = {"L$0", "L$1"})
public final class RxObservableCoroutine$send$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RxObservableCoroutine<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxObservableCoroutine$send$1(RxObservableCoroutine<T> rxObservableCoroutine, Continuation<? super RxObservableCoroutine$send$1> continuation) {
        super(continuation);
        this.this$0 = rxObservableCoroutine;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.L((Object) null, this);
    }
}
