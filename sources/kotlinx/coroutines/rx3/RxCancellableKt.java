package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "cause", "Lkotlin/coroutines/CoroutineContext;", "context", "", "a", "(Ljava/lang/Throwable;Lkotlin/coroutines/CoroutineContext;)V", "kotlinx-coroutines-rx3"}, k = 2, mv = {1, 8, 0})
public final class RxCancellableKt {
    public static final void a(Throwable th, CoroutineContext coroutineContext) {
        if (!(th instanceof CancellationException)) {
            try {
                RxJavaPlugins.onError(th);
            } catch (Throwable th2) {
                ExceptionsKt.addSuppressed(th, th2);
                CoroutineExceptionHandlerKt.a(coroutineContext, th);
            }
        }
    }
}
