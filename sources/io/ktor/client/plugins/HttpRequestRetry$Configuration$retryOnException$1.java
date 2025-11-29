package io.ktor.client.plugins;

import io.ktor.client.plugins.HttpRequestRetry;
import io.ktor.client.request.HttpRequestBuilder;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/HttpRequestRetry$ShouldRetryContext;", "<anonymous parameter 0>", "Lio/ktor/client/request/HttpRequestBuilder;", "cause", "", "invoke", "(Lio/ktor/client/plugins/HttpRequestRetry$ShouldRetryContext;Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/Throwable;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class HttpRequestRetry$Configuration$retryOnException$1 extends Lambda implements Function3<HttpRequestRetry.ShouldRetryContext, HttpRequestBuilder, Throwable, Boolean> {
    final /* synthetic */ boolean $retryOnTimeout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpRequestRetry$Configuration$retryOnException$1(boolean z) {
        super(3);
        this.$retryOnTimeout = z;
    }

    @NotNull
    public final Boolean invoke(@NotNull HttpRequestRetry.ShouldRetryContext shouldRetryContext, @NotNull HttpRequestBuilder httpRequestBuilder, @NotNull Throwable th) {
        boolean z;
        Intrinsics.checkNotNullParameter(shouldRetryContext, "$this$retryOnExceptionIf");
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(th, "cause");
        if (HttpRequestRetryKt.h(th)) {
            z = this.$retryOnTimeout;
        } else {
            z = !(th instanceof CancellationException);
        }
        return Boolean.valueOf(z);
    }
}
