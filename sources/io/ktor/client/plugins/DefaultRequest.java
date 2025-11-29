package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.Parameters;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLProtocol;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.KtorDsl;
import io.ktor.util.StringValuesKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000b2\u00020\u0001:\u0002\f\rB\"\b\u0002\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005¢\u0006\u0004\b\u0007\u0010\bR%\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lio/ktor/client/plugins/DefaultRequest;", "", "Lkotlin/Function1;", "Lio/ktor/client/plugins/DefaultRequest$DefaultRequestBuilder;", "", "Lkotlin/ExtensionFunctionType;", "block", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "a", "Lkotlin/jvm/functions/Function1;", "b", "DefaultRequestBuilder", "Plugin", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class DefaultRequest {
    public static final Plugin b = new Plugin((DefaultConstructorMarker) null);
    public static final AttributeKey c = new AttributeKey("DefaultRequest");

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f8833a;

    @KtorDsl
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\b\u001a\u00020\u00048\u0016X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011¨\u0006\u0013"}, d2 = {"Lio/ktor/client/plugins/DefaultRequest$DefaultRequestBuilder;", "Lio/ktor/http/HttpMessageBuilder;", "<init>", "()V", "Lio/ktor/http/HeadersBuilder;", "a", "Lio/ktor/http/HeadersBuilder;", "()Lio/ktor/http/HeadersBuilder;", "headers", "Lio/ktor/http/URLBuilder;", "b", "Lio/ktor/http/URLBuilder;", "c", "()Lio/ktor/http/URLBuilder;", "url", "Lio/ktor/util/Attributes;", "Lio/ktor/util/Attributes;", "()Lio/ktor/util/Attributes;", "attributes", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class DefaultRequestBuilder implements HttpMessageBuilder {

        /* renamed from: a  reason: collision with root package name */
        public final HeadersBuilder f8834a = new HeadersBuilder(0, 1, (DefaultConstructorMarker) null);
        public final URLBuilder b = new URLBuilder((URLProtocol) null, (String) null, 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 511, (DefaultConstructorMarker) null);
        public final Attributes c = AttributesJvmKt.a(true);

        public DefaultRequestBuilder() {
        }

        public HeadersBuilder a() {
            return this.f8834a;
        }

        public final Attributes b() {
            return this.c;
        }

        public final URLBuilder c() {
            return this.b;
        }
    }

    @SourceDebugExtension({"SMAP\nDefaultRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultRequest.kt\nio/ktor/client/plugins/DefaultRequest$Plugin\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,212:1\n1855#2,2:213\n*S KotlinDebug\n*F\n+ 1 DefaultRequest.kt\nio/ktor/client/plugins/DefaultRequest$Plugin\n*L\n115#1:213,2\n*E\n"})
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J1\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d8\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lio/ktor/client/plugins/DefaultRequest$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/DefaultRequest$DefaultRequestBuilder;", "Lio/ktor/client/plugins/DefaultRequest;", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "g", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/DefaultRequest;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "e", "(Lio/ktor/client/plugins/DefaultRequest;Lio/ktor/client/HttpClient;)V", "Lio/ktor/http/Url;", "baseUrl", "Lio/ktor/http/URLBuilder;", "requestUrl", "f", "(Lio/ktor/http/Url;Lio/ktor/http/URLBuilder;)V", "", "", "parent", "child", "d", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class Plugin implements HttpClientPlugin<DefaultRequestBuilder, DefaultRequest> {
        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List d(List list, List list2) {
            if (list2.isEmpty()) {
                return list;
            }
            if (list.isEmpty() || ((CharSequence) CollectionsKt.first(list2)).length() == 0) {
                return list2;
            }
            List createListBuilder = CollectionsKt.createListBuilder((list.size() + list2.size()) - 1);
            int size = list.size() - 1;
            for (int i = 0; i < size; i++) {
                createListBuilder.add(list.get(i));
            }
            createListBuilder.addAll(list2);
            return CollectionsKt.build(createListBuilder);
        }

        /* renamed from: e */
        public void b(DefaultRequest defaultRequest, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(defaultRequest, "plugin");
            Intrinsics.checkNotNullParameter(httpClient, "scope");
            httpClient.n().l(HttpRequestPipeline.g.a(), new DefaultRequest$Plugin$install$1(defaultRequest, (Continuation<? super DefaultRequest$Plugin$install$1>) null));
        }

        public final void f(Url url, URLBuilder uRLBuilder) {
            if (Intrinsics.areEqual((Object) uRLBuilder.o(), (Object) URLProtocol.c.c())) {
                uRLBuilder.y(url.k());
            }
            if (uRLBuilder.j().length() <= 0) {
                URLBuilder a2 = URLUtilsKt.a(url);
                a2.y(uRLBuilder.o());
                if (uRLBuilder.n() != 0) {
                    a2.x(uRLBuilder.n());
                }
                a2.u(DefaultRequest.b.d(a2.g(), uRLBuilder.g()));
                if (uRLBuilder.d().length() > 0) {
                    a2.r(uRLBuilder.d());
                }
                ParametersBuilder b = ParametersKt.b(0, 1, (Object) null);
                StringValuesKt.c(b, a2.e());
                a2.s(uRLBuilder.e());
                for (Map.Entry entry : b.entries()) {
                    String str = (String) entry.getKey();
                    List list = (List) entry.getValue();
                    if (!a2.e().contains(str)) {
                        a2.e().c(str, list);
                    }
                }
                URLUtilsKt.h(uRLBuilder, a2);
            }
        }

        /* renamed from: g */
        public DefaultRequest a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            return new DefaultRequest(function1, (DefaultConstructorMarker) null);
        }

        public AttributeKey getKey() {
            return DefaultRequest.c;
        }

        public Plugin() {
        }
    }

    public /* synthetic */ DefaultRequest(Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1);
    }

    public DefaultRequest(Function1 function1) {
        this.f8833a = function1;
    }
}
