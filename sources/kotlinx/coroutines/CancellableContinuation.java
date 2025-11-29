package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002JH\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042#\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006H'¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0007H'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0004H'¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0016\u0010\u0017J8\u0010\u001a\u001a\u00020\u000b2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001d\u001a\u00020\u000b*\u00020\u001c2\u0006\u0010\u0003\u001a\u00028\u0000H'¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010\u001f\u001a\u00020\u000b*\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0007H'¢\u0006\u0004\b\u001f\u0010 J<\u0010!\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00028\u00002#\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006H'¢\u0006\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00158&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00158&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010$¨\u0006&"}, d2 = {"Lkotlinx/coroutines/CancellableContinuation;", "T", "Lkotlin/coroutines/Continuation;", "value", "", "idempotent", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "onCancellation", "H", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "exception", "F", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "token", "B", "(Ljava/lang/Object;)V", "", "e", "(Ljava/lang/Throwable;)Z", "Lkotlinx/coroutines/CompletionHandler;", "handler", "E", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CoroutineDispatcher;", "I", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "f", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "m", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "isActive", "()Z", "isCompleted", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
public interface CancellableContinuation<T> extends Continuation<T> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    void B(Object obj);

    void E(Function1 function1);

    Object F(Throwable th);

    Object H(Object obj, Object obj2, Function1 function1);

    void I(CoroutineDispatcher coroutineDispatcher, Object obj);

    boolean e(Throwable th);

    void f(CoroutineDispatcher coroutineDispatcher, Throwable th);

    boolean isActive();

    boolean isCompleted();

    void m(Object obj, Function1 function1);
}
