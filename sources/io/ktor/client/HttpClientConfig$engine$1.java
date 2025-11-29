package io.ktor.client;

import io.ktor.client.engine.HttpClientEngineConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "Lio/ktor/client/engine/HttpClientEngineConfig;", "invoke", "(Lio/ktor/client/engine/HttpClientEngineConfig;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class HttpClientConfig$engine$1 extends Lambda implements Function1<HttpClientEngineConfig, Unit> {
    final /* synthetic */ Function1<HttpClientEngineConfig, Unit> $block;
    final /* synthetic */ Function1<HttpClientEngineConfig, Unit> $oldConfig;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpClientConfig$engine$1(Function1<HttpClientEngineConfig, Unit> function1, Function1<HttpClientEngineConfig, Unit> function12) {
        super(1);
        this.$oldConfig = function1;
        this.$block = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((HttpClientEngineConfig) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull HttpClientEngineConfig httpClientEngineConfig) {
        Intrinsics.checkNotNullParameter(httpClientEngineConfig, "$this$null");
        this.$oldConfig.invoke(httpClientEngineConfig);
        this.$block.invoke(httpClientEngineConfig);
    }
}
