package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata(d1 = {"kotlinx/coroutines/ThreadPoolDispatcherKt__MultithreadedDispatchers_commonKt", "kotlinx/coroutines/ThreadPoolDispatcherKt__ThreadPoolDispatcherKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class ThreadPoolDispatcherKt {
    public static final ExecutorCoroutineDispatcher a(int i, String str) {
        return ThreadPoolDispatcherKt__ThreadPoolDispatcherKt.b(i, str);
    }

    public static final ExecutorCoroutineDispatcher b(String str) {
        return ThreadPoolDispatcherKt__MultithreadedDispatchers_commonKt.a(str);
    }
}
