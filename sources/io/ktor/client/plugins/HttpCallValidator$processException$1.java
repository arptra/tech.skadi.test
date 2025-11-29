package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidator", f = "HttpCallValidator.kt", i = {0, 0, 1, 1}, l = {58, 59}, m = "processException", n = {"cause", "request", "cause", "request"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class HttpCallValidator$processException$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpCallValidator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpCallValidator$processException$1(HttpCallValidator httpCallValidator, Continuation<? super HttpCallValidator$processException$1> continuation) {
        super(continuation);
        this.this$0 = httpCallValidator;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e((Throwable) null, (HttpRequest) null, this);
    }
}
