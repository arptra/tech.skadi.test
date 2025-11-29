package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.MaybeEmitter;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlinx.coroutines.AbstractCoroutine;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0003J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/rx3/RxMaybeCoroutine;", "", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "value", "", "q1", "(Ljava/lang/Object;)V", "", "cause", "", "handled", "p1", "(Ljava/lang/Throwable;Z)V", "Lio/reactivex/rxjava3/core/MaybeEmitter;", "d", "Lio/reactivex/rxjava3/core/MaybeEmitter;", "subscriber", "kotlinx-coroutines-rx3"}, k = 1, mv = {1, 8, 0})
final class RxMaybeCoroutine<T> extends AbstractCoroutine<T> {
    public final MaybeEmitter d;

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

    public void q1(Object obj) {
        if (obj == null) {
            try {
                this.d.onComplete();
            } catch (Throwable th) {
                RxCancellableKt.a(th, getContext());
            }
        } else {
            this.d.onSuccess(obj);
        }
    }
}
