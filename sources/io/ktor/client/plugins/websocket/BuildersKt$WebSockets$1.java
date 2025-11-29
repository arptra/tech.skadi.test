package io.ktor.client.plugins.websocket;

import io.ktor.client.plugins.websocket.WebSockets;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/websocket/WebSockets$Config;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class BuildersKt$WebSockets$1 extends Lambda implements Function1<WebSockets.Config, Unit> {
    final /* synthetic */ Function1<WebSockets.Config, Unit> $config;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BuildersKt$WebSockets$1(Function1<? super WebSockets.Config, Unit> function1) {
        super(1);
        this.$config = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WebSockets.Config) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull WebSockets.Config config) {
        Intrinsics.checkNotNullParameter(config, "$this$install");
        this.$config.invoke(config);
    }
}
