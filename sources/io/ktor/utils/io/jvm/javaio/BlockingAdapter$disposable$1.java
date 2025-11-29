package io.ktor.utils.io.jvm.javaio;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "cause", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class BlockingAdapter$disposable$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ BlockingAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BlockingAdapter$disposable$1(BlockingAdapter blockingAdapter) {
        super(1);
        this.this$0 = blockingAdapter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th) {
        if (th != null) {
            Continuation b = this.this$0.b;
            Result.Companion companion = Result.Companion;
            b.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(th)));
        }
    }
}
