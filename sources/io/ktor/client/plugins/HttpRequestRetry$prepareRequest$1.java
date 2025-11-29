package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "cause", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class HttpRequestRetry$prepareRequest$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ HttpRequestBuilder $subRequest;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpRequestRetry$prepareRequest$1(HttpRequestBuilder httpRequestBuilder) {
        super(1);
        this.$subRequest = httpRequestBuilder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th) {
        Job g = this.$subRequest.g();
        Intrinsics.checkNotNull(g, "null cannot be cast to non-null type kotlinx.coroutines.CompletableJob");
        CompletableJob completableJob = (CompletableJob) g;
        if (th == null) {
            completableJob.complete();
        } else {
            completableJob.d(th);
        }
    }
}
