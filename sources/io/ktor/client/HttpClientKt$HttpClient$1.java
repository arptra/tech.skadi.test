package io.ktor.client;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "Lio/ktor/client/engine/HttpClientEngineConfig;", "Lio/ktor/client/HttpClientConfig;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class HttpClientKt$HttpClient$1 extends Lambda implements Function1 {
    public static final HttpClientKt$HttpClient$1 INSTANCE = new HttpClientKt$HttpClient$1();

    public HttpClientKt$HttpClient$1() {
        super(1);
    }

    public final void invoke(@NotNull HttpClientConfig httpClientConfig) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "$this$null");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((HttpClientConfig) obj);
        return Unit.INSTANCE;
    }
}
