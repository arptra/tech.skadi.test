package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\b\u00028\u0000H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\fø\u0001\u0000\u0002\u0004\n\u0002\b9¨\u0006\r"}, d2 = {"kotlinx/coroutines/rx3/RxAwaitKt$awaitSingleOrNull$2$1", "Lio/reactivex/rxjava3/core/MaybeObserver;", "onComplete", "", "onError", "error", "", "onSubscribe", "d", "Lio/reactivex/rxjava3/disposables/Disposable;", "onSuccess", "t", "(Ljava/lang/Object;)V", "kotlinx-coroutines-rx3"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RxAwaitKt$awaitSingleOrNull$2$1 implements MaybeObserver<Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f3953a;

    public RxAwaitKt$awaitSingleOrNull$2$1(CancellableContinuation cancellableContinuation) {
        this.f3953a = cancellableContinuation;
    }

    public void onComplete() {
        this.f3953a.resumeWith(Result.m20constructorimpl((Object) null));
    }

    public void onError(Throwable th) {
        CancellableContinuation cancellableContinuation = this.f3953a;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(th)));
    }

    public void onSubscribe(Disposable disposable) {
        RxAwaitKt.i(this.f3953a, disposable);
    }

    public void onSuccess(Object obj) {
        this.f3953a.resumeWith(Result.m20constructorimpl(obj));
    }
}
