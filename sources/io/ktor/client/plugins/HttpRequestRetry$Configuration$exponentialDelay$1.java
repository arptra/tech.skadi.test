package io.ktor.client.plugins;

import io.ktor.client.plugins.HttpRequestRetry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/HttpRequestRetry$DelayContext;", "retry", "", "invoke", "(Lio/ktor/client/plugins/HttpRequestRetry$DelayContext;I)Ljava/lang/Long;"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class HttpRequestRetry$Configuration$exponentialDelay$1 extends Lambda implements Function2<HttpRequestRetry.DelayContext, Integer, Long> {
    final /* synthetic */ double $base;
    final /* synthetic */ long $maxDelayMs;
    final /* synthetic */ long $randomizationMs;
    final /* synthetic */ HttpRequestRetry.Configuration this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpRequestRetry$Configuration$exponentialDelay$1(double d, long j, HttpRequestRetry.Configuration configuration, long j2) {
        super(2);
        this.$base = d;
        this.$maxDelayMs = j;
        this.this$0 = configuration;
        this.$randomizationMs = j2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((HttpRequestRetry.DelayContext) obj, ((Number) obj2).intValue());
    }

    @NotNull
    public final Long invoke(@NotNull HttpRequestRetry.DelayContext delayContext, int i) {
        Intrinsics.checkNotNullParameter(delayContext, "$this$delayMillis");
        return Long.valueOf(Math.min(((long) Math.pow(this.$base, (double) i)) * 1000, this.$maxDelayMs) + this.this$0.k(this.$randomizationMs));
    }
}
