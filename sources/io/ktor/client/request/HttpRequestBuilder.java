package io.ktor.client.request;

import com.upuphone.runasone.relay.api.IntentKey;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.client.utils.EmptyContent;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMethod;
import io.ktor.http.Parameters;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLProtocol;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.AttributesKt;
import io.ktor.util.StringValuesKt;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 62\u00020\u0001:\u0001EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\t\u001a\u00020\u00062\u001d\u0010\b\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0010J-\u0010\u0017\u001a\u00020\u0006\"\b\b\u0000\u0010\u0013*\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0019\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0013*\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020 8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010+\u001a\u00020'8\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b\u001b\u0010*R*\u00102\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00128\u0006@GX\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b-\u0010/\"\u0004\b0\u00101R*\u0010:\u001a\u0002032\u0006\u0010,\u001a\u0002038\u0006@@X\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0017\u0010>\u001a\u00020;8\u0006¢\u0006\f\n\u0004\b\u0019\u0010<\u001a\u0004\b(\u0010=R(\u0010D\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010?8F@GX\u000e¢\u0006\f\u001a\u0004\b4\u0010A\"\u0004\bB\u0010C¨\u0006F"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/http/HttpMessageBuilder;", "<init>", "()V", "Lkotlin/Function2;", "Lio/ktor/http/URLBuilder;", "", "Lkotlin/ExtensionFunctionType;", "block", "q", "(Lkotlin/jvm/functions/Function2;)V", "Lio/ktor/client/request/HttpRequestData;", "b", "()Lio/ktor/client/request/HttpRequestData;", "builder", "p", "(Lio/ktor/client/request/HttpRequestBuilder;)Lio/ktor/client/request/HttpRequestBuilder;", "o", "", "T", "Lio/ktor/client/engine/HttpClientEngineCapability;", "key", "capability", "l", "(Lio/ktor/client/engine/HttpClientEngineCapability;Ljava/lang/Object;)V", "f", "(Lio/ktor/client/engine/HttpClientEngineCapability;)Ljava/lang/Object;", "a", "Lio/ktor/http/URLBuilder;", "i", "()Lio/ktor/http/URLBuilder;", "url", "Lio/ktor/http/HttpMethod;", "Lio/ktor/http/HttpMethod;", "h", "()Lio/ktor/http/HttpMethod;", "n", "(Lio/ktor/http/HttpMethod;)V", "method", "Lio/ktor/http/HeadersBuilder;", "c", "Lio/ktor/http/HeadersBuilder;", "()Lio/ktor/http/HeadersBuilder;", "headers", "<set-?>", "d", "Ljava/lang/Object;", "()Ljava/lang/Object;", "j", "(Ljava/lang/Object;)V", "body", "Lkotlinx/coroutines/Job;", "e", "Lkotlinx/coroutines/Job;", "g", "()Lkotlinx/coroutines/Job;", "m", "(Lkotlinx/coroutines/Job;)V", "executionContext", "Lio/ktor/util/Attributes;", "Lio/ktor/util/Attributes;", "()Lio/ktor/util/Attributes;", "attributes", "Lio/ktor/util/reflect/TypeInfo;", "value", "()Lio/ktor/util/reflect/TypeInfo;", "k", "(Lio/ktor/util/reflect/TypeInfo;)V", "bodyType", "Companion", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class HttpRequestBuilder implements HttpMessageBuilder {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final URLBuilder f8916a = new URLBuilder((URLProtocol) null, (String) null, 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 511, (DefaultConstructorMarker) null);
    public HttpMethod b = HttpMethod.b.a();
    public final HeadersBuilder c = new HeadersBuilder(0, 1, (DefaultConstructorMarker) null);
    public Object d = EmptyContent.f8936a;
    public Job e = SupervisorKt.b((Job) null, 1, (Object) null);
    public final Attributes f = AttributesJvmKt.a(true);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder$Companion;", "", "()V", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public HeadersBuilder a() {
        return this.c;
    }

    public final HttpRequestData b() {
        Url b2 = this.f8916a.b();
        HttpMethod httpMethod = this.b;
        Headers n = a().n();
        Object obj = this.d;
        OutgoingContent outgoingContent = obj instanceof OutgoingContent ? (OutgoingContent) obj : null;
        if (outgoingContent != null) {
            return new HttpRequestData(b2, httpMethod, n, outgoingContent, this.e, this.f);
        }
        throw new IllegalStateException(("No request transformation found: " + this.d).toString());
    }

    public final Attributes c() {
        return this.f;
    }

    public final Object d() {
        return this.d;
    }

    public final TypeInfo e() {
        return (TypeInfo) this.f.e(RequestBodyKt.a());
    }

    public final Object f(HttpClientEngineCapability httpClientEngineCapability) {
        Intrinsics.checkNotNullParameter(httpClientEngineCapability, IntentKey.ACTIVITY.ACTION_KEY);
        Map map = (Map) this.f.e(HttpClientEngineCapabilityKt.a());
        if (map != null) {
            return map.get(httpClientEngineCapability);
        }
        return null;
    }

    public final Job g() {
        return this.e;
    }

    public final HttpMethod h() {
        return this.b;
    }

    public final URLBuilder i() {
        return this.f8916a;
    }

    public final void j(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.d = obj;
    }

    public final void k(TypeInfo typeInfo) {
        if (typeInfo != null) {
            this.f.a(RequestBodyKt.a(), typeInfo);
        } else {
            this.f.c(RequestBodyKt.a());
        }
    }

    public final void l(HttpClientEngineCapability httpClientEngineCapability, Object obj) {
        Intrinsics.checkNotNullParameter(httpClientEngineCapability, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(obj, "capability");
        ((Map) this.f.g(HttpClientEngineCapabilityKt.a(), HttpRequestBuilder$setCapability$capabilities$1.INSTANCE)).put(httpClientEngineCapability, obj);
    }

    public final void m(Job job) {
        Intrinsics.checkNotNullParameter(job, "<set-?>");
        this.e = job;
    }

    public final void n(HttpMethod httpMethod) {
        Intrinsics.checkNotNullParameter(httpMethod, "<set-?>");
        this.b = httpMethod;
    }

    public final HttpRequestBuilder o(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "builder");
        this.b = httpRequestBuilder.b;
        this.d = httpRequestBuilder.d;
        k(httpRequestBuilder.e());
        URLUtilsKt.h(this.f8916a, httpRequestBuilder.f8916a);
        URLBuilder uRLBuilder = this.f8916a;
        uRLBuilder.u(uRLBuilder.g());
        StringValuesKt.c(a(), httpRequestBuilder.a());
        AttributesKt.a(this.f, httpRequestBuilder.f);
        return this;
    }

    public final HttpRequestBuilder p(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "builder");
        this.e = httpRequestBuilder.e;
        return o(httpRequestBuilder);
    }

    public final void q(Function2 function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        URLBuilder uRLBuilder = this.f8916a;
        function2.invoke(uRLBuilder, uRLBuilder);
    }
}
