package io.ktor.client.plugins;

import io.ktor.client.plugins.HttpRequestRetry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/HttpRequestRetry$DelayContext;", "it", "", "invoke", "(Lio/ktor/client/plugins/HttpRequestRetry$DelayContext;I)Ljava/lang/Long;"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class HttpRequestRetry$Configuration$delayMillis$1 extends Lambda implements Function2<HttpRequestRetry.DelayContext, Integer, Long> {
    final /* synthetic */ Function2<HttpRequestRetry.DelayContext, Integer, Long> $block;
    final /* synthetic */ boolean $respectRetryAfterHeader;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpRequestRetry$Configuration$delayMillis$1(boolean z, Function2<? super HttpRequestRetry.DelayContext, ? super Integer, Long> function2) {
        super(2);
        this.$respectRetryAfterHeader = z;
        this.$block = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((HttpRequestRetry.DelayContext) obj, ((Number) obj2).intValue());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        r0 = kotlin.text.StringsKt.toLongOrNull((r0 = (r0 = r0.a()).get(io.ktor.http.HttpHeaders.f8966a.u())));
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Long invoke(@org.jetbrains.annotations.NotNull io.ktor.client.plugins.HttpRequestRetry.DelayContext r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "$this$null"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            boolean r0 = r4.$respectRetryAfterHeader
            if (r0 == 0) goto L_0x0053
            io.ktor.client.statement.HttpResponse r0 = r5.a()
            if (r0 == 0) goto L_0x0034
            io.ktor.http.Headers r0 = r0.a()
            if (r0 == 0) goto L_0x0034
            io.ktor.http.HttpHeaders r1 = io.ktor.http.HttpHeaders.f8966a
            java.lang.String r1 = r1.u()
            java.lang.String r0 = r0.get(r1)
            if (r0 == 0) goto L_0x0034
            java.lang.Long r0 = kotlin.text.StringsKt.toLongOrNull(r0)
            if (r0 == 0) goto L_0x0034
            long r0 = r0.longValue()
            r2 = 1000(0x3e8, float:1.401E-42)
            long r2 = (long) r2
            long r0 = r0 * r2
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            kotlin.jvm.functions.Function2<io.ktor.client.plugins.HttpRequestRetry$DelayContext, java.lang.Integer, java.lang.Long> r4 = r4.$block
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r4 = r4.invoke(r5, r6)
            java.lang.Number r4 = (java.lang.Number) r4
            long r4 = r4.longValue()
            if (r0 == 0) goto L_0x004c
            long r0 = r0.longValue()
            goto L_0x004e
        L_0x004c:
            r0 = 0
        L_0x004e:
            long r4 = java.lang.Math.max(r4, r0)
            goto L_0x0063
        L_0x0053:
            kotlin.jvm.functions.Function2<io.ktor.client.plugins.HttpRequestRetry$DelayContext, java.lang.Integer, java.lang.Long> r4 = r4.$block
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r4 = r4.invoke(r5, r6)
            java.lang.Number r4 = (java.lang.Number) r4
            long r4 = r4.longValue()
        L_0x0063:
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRequestRetry$Configuration$delayMillis$1.invoke(io.ktor.client.plugins.HttpRequestRetry$DelayContext, int):java.lang.Long");
    }
}
