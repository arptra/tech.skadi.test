package io.ktor.client;

import io.ktor.client.engine.HttpClientEngine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "Lio/ktor/client/engine/HttpClientEngineConfig;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class HttpClientKt$HttpClient$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ HttpClientEngine $engine;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpClientKt$HttpClient$2(HttpClientEngine httpClientEngine) {
        super(1);
        this.$engine = httpClientEngine;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th) {
        this.$engine.close();
    }
}
