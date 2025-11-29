package com.honey.account.utils.coroutine;

import com.honey.account.g2.a;
import com.honey.account.utils.coroutine.DispatcherHelper;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"com/honey/account/utils/coroutine/DispatcherHelper$DispatchContext$interceptContinuation$1", "Lkotlin/coroutines/Continuation;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DispatcherHelper$DispatchContext$interceptContinuation$1 implements Continuation<T> {
    final /* synthetic */ Continuation<T> $continuation;
    @NotNull
    private final CoroutineContext context;

    public DispatcherHelper$DispatchContext$interceptContinuation$1(Continuation<? super T> continuation) {
        this.$continuation = continuation;
        this.context = continuation.getContext();
    }

    /* access modifiers changed from: private */
    public static final void resumeWith$lambda$0(Continuation continuation, Object obj) {
        Intrinsics.checkNotNullParameter(continuation, "$continuation");
        continuation.resumeWith(obj);
    }

    @NotNull
    public CoroutineContext getContext() {
        return this.context;
    }

    public void resumeWith(@NotNull Object obj) {
        DispatcherHelper.ExecutorContext executorContext = (DispatcherHelper.ExecutorContext) getContext().get(DispatcherHelper.ExecutorContext.Key);
        if (executorContext == null || executorContext.getThreadType() == null) {
            this.$continuation.resumeWith(obj);
        } else {
            executorContext.getThreadType().execute(new a(this.$continuation, obj));
        }
    }
}
