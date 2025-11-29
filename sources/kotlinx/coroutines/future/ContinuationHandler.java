package kotlinx.coroutines.future;

import java.util.concurrent.CompletionException;
import java.util.function.BiFunction;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002J#\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00018\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/future/ContinuationHandler;", "T", "Ljava/util/function/BiFunction;", "", "", "result", "exception", "a", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/Continuation;", "cont", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
final class ContinuationHandler<T> implements BiFunction<T, Throwable, Unit> {
    @Nullable
    @JvmField
    public volatile Continuation<? super T> cont;

    public void a(Object obj, Throwable th) {
        Throwable cause;
        Continuation<? super T> continuation = this.cont;
        if (continuation != null) {
            if (th == null) {
                continuation.resumeWith(Result.m20constructorimpl(obj));
                return;
            }
            CompletionException completionException = th instanceof CompletionException ? (CompletionException) th : null;
            if (!(completionException == null || (cause = completionException.getCause()) == null)) {
                th = cause;
            }
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) {
        a(obj, (Throwable) obj2);
        return Unit.INSTANCE;
    }
}
