package rxhttp;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import rxhttp.wrapper.coroutines.Await;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0010\u0010\u0003\u001a\u00028\u0000H@¢\u0006\u0004\b\u0003\u0010\u0004R*\u0010\n\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lrxhttp/SafeAwait;", "T", "Lrxhttp/wrapper/coroutines/Await;", "c", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "a", "Lkotlin/jvm/functions/Function1;", "block", "rxhttp"}, k = 1, mv = {1, 9, 0})
final class SafeAwait<T> implements Await<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f3527a;

    public Object c(Continuation continuation) {
        return this.f3527a.invoke(continuation);
    }
}
