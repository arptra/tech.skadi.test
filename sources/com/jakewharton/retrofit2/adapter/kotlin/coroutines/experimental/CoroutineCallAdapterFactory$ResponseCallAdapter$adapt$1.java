package com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.experimental.CompletableDeferred;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, k = 3, mv = {1, 1, 9})
public final class CoroutineCallAdapterFactory$ResponseCallAdapter$adapt$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ Call $call;
    final /* synthetic */ CompletableDeferred $deferred;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutineCallAdapterFactory$ResponseCallAdapter$adapt$1(CompletableDeferred completableDeferred, Call call) {
        super(1);
        this.$deferred = completableDeferred;
        this.$call = call;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th) {
        if (this.$deferred.isCancelled()) {
            this.$call.cancel();
        }
    }
}
