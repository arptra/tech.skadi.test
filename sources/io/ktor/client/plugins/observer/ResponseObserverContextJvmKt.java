package io.ktor.client.plugins.observer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.slf4j.MDCContext;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u0003"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {1, 8, 0})
public final class ResponseObserverContextJvmKt {
    public static final Object a(Continuation continuation) {
        MDCContext mDCContext = (MDCContext) continuation.getContext().get(MDCContext.b);
        return mDCContext != null ? mDCContext : EmptyCoroutineContext.INSTANCE;
    }
}
