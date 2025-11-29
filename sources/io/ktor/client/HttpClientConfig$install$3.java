package io.ktor.client;

import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.util.Attributes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "TBuilder", "", "TPlugin", "T", "Lio/ktor/client/engine/HttpClientEngineConfig;", "scope", "Lio/ktor/client/HttpClient;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class HttpClientConfig$install$3 extends Lambda implements Function1<HttpClient, Unit> {
    final /* synthetic */ HttpClientPlugin<Object, Object> $plugin;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpClientConfig$install$3(HttpClientPlugin<Object, Object> httpClientPlugin) {
        super(1);
        this.$plugin = httpClientPlugin;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((HttpClient) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "scope");
        Object obj = httpClient.c().f8816a.get(this.$plugin.getKey());
        Intrinsics.checkNotNull(obj);
        Object a2 = this.$plugin.a((Function1) obj);
        this.$plugin.b(a2, httpClient);
        ((Attributes) httpClient.J().g(HttpClientPluginKt.a(), HttpClientConfig$install$3$attributes$1.INSTANCE)).a(this.$plugin.getKey(), a2);
    }
}
