package io.ktor.client.plugins.observer;

import io.ktor.client.plugins.observer.ResponseObserver;
import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/observer/ResponseObserver$Config;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class ResponseObserverKt$ResponseObserver$1 extends Lambda implements Function1<ResponseObserver.Config, Unit> {
    final /* synthetic */ Function2<HttpResponse, Continuation<? super Unit>, Object> $block;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ResponseObserverKt$ResponseObserver$1(Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> function2) {
        super(1);
        this.$block = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ResponseObserver.Config) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ResponseObserver.Config config) {
        Intrinsics.checkNotNullParameter(config, "$this$install");
        config.c(this.$block);
    }
}
