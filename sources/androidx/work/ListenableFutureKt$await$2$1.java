package androidx.work;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "R", "run"}, k = 3, mv = {1, 8, 0}, xi = 176)
@SourceDebugExtension({"SMAP\nListenableFuture.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListenableFuture.kt\nandroidx/work/ListenableFutureKt$await$2$1\n*L\n1#1,91:1\n*E\n"})
public final class ListenableFutureKt$await$2$1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f2058a;
    public final /* synthetic */ ListenableFuture b;

    public ListenableFutureKt$await$2$1(CancellableContinuation cancellableContinuation, ListenableFuture listenableFuture) {
        this.f2058a = cancellableContinuation;
        this.b = listenableFuture;
    }

    public final void run() {
        try {
            CancellableContinuation cancellableContinuation = this.f2058a;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(this.b.get()));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                cause = th;
            }
            if (th instanceof CancellationException) {
                this.f2058a.e(cause);
                return;
            }
            CancellableContinuation cancellableContinuation2 = this.f2058a;
            Result.Companion companion2 = Result.Companion;
            cancellableContinuation2.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(cause)));
        }
    }
}
