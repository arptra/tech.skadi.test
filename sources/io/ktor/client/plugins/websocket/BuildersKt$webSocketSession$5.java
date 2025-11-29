package io.ktor.client.plugins.websocket;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.http.HttpMethod;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lio/ktor/client/request/HttpRequestBuilder;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class BuildersKt$webSocketSession$5 extends Lambda implements Function1<HttpRequestBuilder, Unit> {
    final /* synthetic */ Function1<HttpRequestBuilder, Unit> $block;
    final /* synthetic */ String $host;
    final /* synthetic */ HttpMethod $method;
    final /* synthetic */ String $path;
    final /* synthetic */ Integer $port;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BuildersKt$webSocketSession$5(HttpMethod httpMethod, String str, Integer num, String str2, Function1<? super HttpRequestBuilder, Unit> function1) {
        super(1);
        this.$method = httpMethod;
        this.$host = str;
        this.$port = num;
        this.$path = str2;
        this.$block = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((HttpRequestBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "$this$webSocketSession");
        httpRequestBuilder.n(this.$method);
        HttpRequestKt.b(httpRequestBuilder, "ws", this.$host, this.$port, this.$path, (Function1) null, 16, (Object) null);
        this.$block.invoke(httpRequestBuilder);
    }
}
