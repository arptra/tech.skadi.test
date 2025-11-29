package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"kotlinx/coroutines/rx3/RxAwaitKt$await$2$1", "Lio/reactivex/rxjava3/core/CompletableObserver;", "onComplete", "", "onError", "e", "", "onSubscribe", "d", "Lio/reactivex/rxjava3/disposables/Disposable;", "kotlinx-coroutines-rx3"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RxAwaitKt$await$2$1 implements CompletableObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f3950a;

    public RxAwaitKt$await$2$1(CancellableContinuation cancellableContinuation) {
        this.f3950a = cancellableContinuation;
    }

    public void onComplete() {
        CancellableContinuation cancellableContinuation = this.f3950a;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m20constructorimpl(Unit.INSTANCE));
    }

    public void onError(Throwable th) {
        CancellableContinuation cancellableContinuation = this.f3950a;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(th)));
    }

    public void onSubscribe(Disposable disposable) {
        RxAwaitKt.i(this.f3950a, disposable);
    }
}
