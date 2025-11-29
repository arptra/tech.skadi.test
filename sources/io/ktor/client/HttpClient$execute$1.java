package io.ktor.client;

import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.HttpClient", f = "HttpClient.kt", i = {}, l = {191}, m = "execute$ktor_client_core", n = {}, s = {})
public final class HttpClient$execute$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpClient$execute$1(HttpClient httpClient, Continuation<? super HttpClient$execute$1> continuation) {
        super(continuation);
        this.this$0 = httpClient;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a((HttpRequestBuilder) null, this);
    }
}
