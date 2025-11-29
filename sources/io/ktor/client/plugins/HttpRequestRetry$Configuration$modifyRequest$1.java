package io.ktor.client.plugins;

import io.ktor.client.plugins.HttpRequestRetry;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/HttpRequestRetry$ModifyRequestContext;", "it", "Lio/ktor/client/request/HttpRequestBuilder;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class HttpRequestRetry$Configuration$modifyRequest$1 extends Lambda implements Function2<HttpRequestRetry.ModifyRequestContext, HttpRequestBuilder, Unit> {
    public static final HttpRequestRetry$Configuration$modifyRequest$1 INSTANCE = new HttpRequestRetry$Configuration$modifyRequest$1();

    public HttpRequestRetry$Configuration$modifyRequest$1() {
        super(2);
    }

    public final void invoke(@NotNull HttpRequestRetry.ModifyRequestContext modifyRequestContext, @NotNull HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(modifyRequestContext, "$this$null");
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((HttpRequestRetry.ModifyRequestContext) obj, (HttpRequestBuilder) obj2);
        return Unit.INSTANCE;
    }
}
