package io.ktor.client.request;

import com.upuphone.runasone.relay.api.IntentKey;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\"\n\u0002\b\u0005\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b\u001c\u0010%R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b!\u0010&\u001a\u0004\b#\u0010'R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u001e\u0010(\u001a\u0004\b\u0018\u0010)R$\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110*8\u0000X\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b+\u0010-¨\u0006/"}, d2 = {"Lio/ktor/client/request/HttpRequestData;", "", "Lio/ktor/http/Url;", "url", "Lio/ktor/http/HttpMethod;", "method", "Lio/ktor/http/Headers;", "headers", "Lio/ktor/http/content/OutgoingContent;", "body", "Lkotlinx/coroutines/Job;", "executionContext", "Lio/ktor/util/Attributes;", "attributes", "<init>", "(Lio/ktor/http/Url;Lio/ktor/http/HttpMethod;Lio/ktor/http/Headers;Lio/ktor/http/content/OutgoingContent;Lkotlinx/coroutines/Job;Lio/ktor/util/Attributes;)V", "T", "Lio/ktor/client/engine/HttpClientEngineCapability;", "key", "c", "(Lio/ktor/client/engine/HttpClientEngineCapability;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "a", "Lio/ktor/http/Url;", "h", "()Lio/ktor/http/Url;", "b", "Lio/ktor/http/HttpMethod;", "f", "()Lio/ktor/http/HttpMethod;", "Lio/ktor/http/Headers;", "e", "()Lio/ktor/http/Headers;", "d", "Lio/ktor/http/content/OutgoingContent;", "()Lio/ktor/http/content/OutgoingContent;", "Lkotlinx/coroutines/Job;", "()Lkotlinx/coroutines/Job;", "Lio/ktor/util/Attributes;", "()Lio/ktor/util/Attributes;", "", "g", "Ljava/util/Set;", "()Ljava/util/Set;", "requiredCapabilities", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class HttpRequestData {

    /* renamed from: a  reason: collision with root package name */
    public final Url f8917a;
    public final HttpMethod b;
    public final Headers c;
    public final OutgoingContent d;
    public final Job e;
    public final Attributes f;
    public final Set g;

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x003a, code lost:
        r2 = r2.keySet();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequestData(io.ktor.http.Url r2, io.ktor.http.HttpMethod r3, io.ktor.http.Headers r4, io.ktor.http.content.OutgoingContent r5, kotlinx.coroutines.Job r6, io.ktor.util.Attributes r7) {
        /*
            r1 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "method"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "headers"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "body"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "executionContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "attributes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r1.<init>()
            r1.f8917a = r2
            r1.b = r3
            r1.c = r4
            r1.d = r5
            r1.e = r6
            r1.f = r7
            io.ktor.util.AttributeKey r2 = io.ktor.client.engine.HttpClientEngineCapabilityKt.a()
            java.lang.Object r2 = r7.e(r2)
            java.util.Map r2 = (java.util.Map) r2
            if (r2 == 0) goto L_0x0040
            java.util.Set r2 = r2.keySet()
            if (r2 != 0) goto L_0x0044
        L_0x0040:
            java.util.Set r2 = kotlin.collections.SetsKt.emptySet()
        L_0x0044:
            r1.g = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.request.HttpRequestData.<init>(io.ktor.http.Url, io.ktor.http.HttpMethod, io.ktor.http.Headers, io.ktor.http.content.OutgoingContent, kotlinx.coroutines.Job, io.ktor.util.Attributes):void");
    }

    public final Attributes a() {
        return this.f;
    }

    public final OutgoingContent b() {
        return this.d;
    }

    public final Object c(HttpClientEngineCapability httpClientEngineCapability) {
        Intrinsics.checkNotNullParameter(httpClientEngineCapability, IntentKey.ACTIVITY.ACTION_KEY);
        Map map = (Map) this.f.e(HttpClientEngineCapabilityKt.a());
        if (map != null) {
            return map.get(httpClientEngineCapability);
        }
        return null;
    }

    public final Job d() {
        return this.e;
    }

    public final Headers e() {
        return this.c;
    }

    public final HttpMethod f() {
        return this.b;
    }

    public final Set g() {
        return this.g;
    }

    public final Url h() {
        return this.f8917a;
    }

    public String toString() {
        return "HttpRequestData(url=" + this.f8917a + ", method=" + this.b + ')';
    }
}
