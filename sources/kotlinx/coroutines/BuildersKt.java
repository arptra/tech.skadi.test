package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"kotlinx/coroutines/BuildersKt__BuildersKt", "kotlinx/coroutines/BuildersKt__Builders_commonKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class BuildersKt {
    public static final Deferred a(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2) {
        return BuildersKt__Builders_commonKt.a(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static final Job c(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2) {
        return BuildersKt__Builders_commonKt.c(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static final Object e(CoroutineContext coroutineContext, Function2 function2) {
        return BuildersKt__BuildersKt.a(coroutineContext, function2);
    }

    public static final Object g(CoroutineContext coroutineContext, Function2 function2, Continuation continuation) {
        return BuildersKt__Builders_commonKt.e(coroutineContext, function2, continuation);
    }
}
