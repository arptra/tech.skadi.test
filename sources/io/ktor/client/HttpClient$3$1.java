package io.ktor.client;

import io.ktor.client.plugins.DefaultTransformKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lio/ktor/client/HttpClient;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class HttpClient$3$1 extends Lambda implements Function1<HttpClient, Unit> {
    public static final HttpClient$3$1 INSTANCE = new HttpClient$3$1();

    public HttpClient$3$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((HttpClient) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "$this$install");
        DefaultTransformKt.b(httpClient);
    }
}
