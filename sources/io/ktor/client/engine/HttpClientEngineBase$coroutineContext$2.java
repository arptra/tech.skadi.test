package io.ktor.client.engine;

import io.ktor.util.CoroutinesUtilsKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class HttpClientEngineBase$coroutineContext$2 extends Lambda implements Function0<CoroutineContext> {
    final /* synthetic */ HttpClientEngineBase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpClientEngineBase$coroutineContext$2(HttpClientEngineBase httpClientEngineBase) {
        super(0);
        this.this$0 = httpClientEngineBase;
    }

    @NotNull
    public final CoroutineContext invoke() {
        CoroutineContext plus = CoroutinesUtilsKt.b((Job) null, 1, (Object) null).plus(this.this$0.x0());
        return plus.plus(new CoroutineName(this.this$0.f8823a + "-context"));
    }
}
