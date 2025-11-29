package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\b\u00028\u0000H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u000bø\u0001\u0000\u0002\u0004\n\u0002\b9¨\u0006\f"}, d2 = {"kotlinx/coroutines/rx3/RxAwaitKt$await$5$1", "Lio/reactivex/rxjava3/core/SingleObserver;", "onError", "", "error", "", "onSubscribe", "d", "Lio/reactivex/rxjava3/disposables/Disposable;", "onSuccess", "t", "(Ljava/lang/Object;)V", "kotlinx-coroutines-rx3"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RxAwaitKt$await$5$1 implements SingleObserver<Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f3951a;

    public RxAwaitKt$await$5$1(CancellableContinuation cancellableContinuation) {
        this.f3951a = cancellableContinuation;
    }

    public void onError(Throwable th) {
        CancellableContinuation cancellableContinuation = this.f3951a;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(th)));
    }

    public void onSubscribe(Disposable disposable) {
        RxAwaitKt.i(this.f3951a, disposable);
    }

    public void onSuccess(Object obj) {
        this.f3951a.resumeWith(Result.m20constructorimpl(obj));
    }
}
