package retrofit2;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class KotlinExtensions$suspendAndThrow$2$1 implements Runnable {
    final /* synthetic */ Continuation<?> $continuation;
    final /* synthetic */ Throwable $this_suspendAndThrow;

    public KotlinExtensions$suspendAndThrow$2$1(Continuation<?> continuation, Throwable th) {
        this.$continuation = continuation;
        this.$this_suspendAndThrow = th;
    }

    public final void run() {
        Continuation<?> intercepted = IntrinsicsKt.intercepted(this.$continuation);
        Result.Companion companion = Result.Companion;
        intercepted.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(this.$this_suspendAndThrow)));
    }
}
