package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.CompletableEmitter;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.AbstractCoroutine;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/rx3/RxCompletableCoroutine;", "Lkotlinx/coroutines/AbstractCoroutine;", "", "value", "s1", "(Lkotlin/Unit;)V", "", "cause", "", "handled", "p1", "(Ljava/lang/Throwable;Z)V", "Lio/reactivex/rxjava3/core/CompletableEmitter;", "d", "Lio/reactivex/rxjava3/core/CompletableEmitter;", "subscriber", "kotlinx-coroutines-rx3"}, k = 1, mv = {1, 8, 0})
final class RxCompletableCoroutine extends AbstractCoroutine<Unit> {
    public final CompletableEmitter d;

    public void p1(Throwable th, boolean z) {
        try {
            if (this.d.tryOnError(th)) {
                return;
            }
        } catch (Throwable th2) {
            ExceptionsKt.addSuppressed(th, th2);
        }
        RxCancellableKt.a(th, getContext());
    }

    /* renamed from: s1 */
    public void q1(Unit unit) {
        try {
            this.d.onComplete();
        } catch (Throwable th) {
            RxCancellableKt.a(th, getContext());
        }
    }
}
