package io.ktor.client.engine;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineName;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class HttpClientJvmEngine$coroutineContext$2 extends Lambda implements Function0<CoroutineContext> {
    final /* synthetic */ String $engineName;
    final /* synthetic */ HttpClientJvmEngine this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpClientJvmEngine$coroutineContext$2(HttpClientJvmEngine httpClientJvmEngine, String str) {
        super(0);
        this.this$0 = httpClientJvmEngine;
        this.$engineName = str;
    }

    @NotNull
    public final CoroutineContext invoke() {
        CoroutineContext plus = this.this$0.x0().plus(this.this$0.f8826a);
        return plus.plus(new CoroutineName(this.$engineName + "-context"));
    }
}
