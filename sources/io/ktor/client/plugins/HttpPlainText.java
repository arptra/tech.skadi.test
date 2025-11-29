package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.TextContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.slf4j.Logger;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00122\u00020\u0001:\u0002%&BO\b\u0000\u0012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002\u0012\u0016\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\u0010\t\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004\u0012\n\u0010\n\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0018\u0010\n\u001a\u00060\u0003j\u0002`\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u00060\u0003j\u0002`\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010$\u001a\u00020\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010#¨\u0006'"}, d2 = {"Lio/ktor/client/plugins/HttpPlainText;", "", "", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "charsets", "", "", "charsetQuality", "sendCharset", "responseCharsetFallback", "<init>", "(Ljava/util/Set;Ljava/util/Map;Ljava/nio/charset/Charset;Ljava/nio/charset/Charset;)V", "Lio/ktor/client/call/HttpClientCall;", "call", "Lio/ktor/utils/io/core/Input;", "body", "", "d", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/utils/io/core/Input;)Ljava/lang/String;", "Lio/ktor/client/request/HttpRequestBuilder;", "context", "", "c", "(Lio/ktor/client/request/HttpRequestBuilder;)V", "request", "content", "Lio/ktor/http/ContentType;", "requestContentType", "e", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/String;Lio/ktor/http/ContentType;)Ljava/lang/Object;", "a", "Ljava/nio/charset/Charset;", "b", "requestCharset", "Ljava/lang/String;", "acceptCharsetHeader", "Config", "Plugin", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHttpPlainText.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpPlainText.kt\nio/ktor/client/plugins/HttpPlainText\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,181:1\n1054#2:182\n766#2:183\n857#2,2:184\n1045#2:186\n1855#2,2:187\n1855#2,2:189\n*S KotlinDebug\n*F\n+ 1 HttpPlainText.kt\nio/ktor/client/plugins/HttpPlainText\n*L\n38#1:182\n39#1:183\n39#1:184,2\n39#1:186\n42#1:187,2\n47#1:189,2\n*E\n"})
public final class HttpPlainText {
    public static final Plugin d = new Plugin((DefaultConstructorMarker) null);
    public static final AttributeKey e = new AttributeKey("HttpPlainText");

    /* renamed from: a  reason: collision with root package name */
    public final Charset f8848a;
    public final Charset b;
    public final String c;

    @SourceDebugExtension({"SMAP\nHttpPlainText.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpPlainText.kt\nio/ktor/client/plugins/HttpPlainText$Config\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,181:1\n1#2:182\n*E\n"})
    @KtorDsl
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0007\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u000b\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR*\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\r0\f8\u0000X\u0004¢\u0006\f\n\u0004\b\t\u0010\u000e\u001a\u0004\b\u0007\u0010\u000fR*\u0010\u0017\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\u0019\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0011\u0010\u0014\"\u0004\b\u0018\u0010\u0016¨\u0006\u001a"}, d2 = {"Lio/ktor/client/plugins/HttpPlainText$Config;", "", "<init>", "()V", "", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "a", "Ljava/util/Set;", "b", "()Ljava/util/Set;", "charsets", "", "", "Ljava/util/Map;", "()Ljava/util/Map;", "charsetQuality", "c", "Ljava/nio/charset/Charset;", "d", "()Ljava/nio/charset/Charset;", "setSendCharset", "(Ljava/nio/charset/Charset;)V", "sendCharset", "setResponseCharsetFallback", "responseCharsetFallback", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class Config {

        /* renamed from: a  reason: collision with root package name */
        public final Set f8849a = new LinkedHashSet();
        public final Map b = new LinkedHashMap();
        public Charset c;
        public Charset d = Charsets.UTF_8;

        public final Map a() {
            return this.b;
        }

        public final Set b() {
            return this.f8849a;
        }

        public final Charset c() {
            return this.d;
        }

        public final Charset d() {
            return this.c;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/client/plugins/HttpPlainText$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/HttpPlainText$Config;", "Lio/ktor/client/plugins/HttpPlainText;", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "d", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/HttpPlainText;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "c", "(Lio/ktor/client/plugins/HttpPlainText;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class Plugin implements HttpClientPlugin<Config, HttpPlainText> {
        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: c */
        public void b(HttpPlainText httpPlainText, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(httpPlainText, "plugin");
            Intrinsics.checkNotNullParameter(httpClient, "scope");
            httpClient.n().l(HttpRequestPipeline.g.b(), new HttpPlainText$Plugin$install$1(httpPlainText, (Continuation<? super HttpPlainText$Plugin$install$1>) null));
            httpClient.r().l(HttpResponsePipeline.g.c(), new HttpPlainText$Plugin$install$2(httpPlainText, (Continuation<? super HttpPlainText$Plugin$install$2>) null));
        }

        /* renamed from: d */
        public HttpPlainText a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            Config config = new Config();
            function1.invoke(config);
            return new HttpPlainText(config.b(), config.a(), config.d(), config.c());
        }

        public AttributeKey getKey() {
            return HttpPlainText.e;
        }

        public Plugin() {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: java.nio.charset.Charset} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpPlainText(java.util.Set r9, java.util.Map r10, java.nio.charset.Charset r11, java.nio.charset.Charset r12) {
        /*
            r8 = this;
            java.lang.String r0 = "charsets"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "charsetQuality"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "responseCharsetFallback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r8.<init>()
            r8.f8848a = r12
            java.util.List r12 = kotlin.collections.MapsKt.toList(r10)
            io.ktor.client.plugins.HttpPlainText$special$$inlined$sortedByDescending$1 r0 = new io.ktor.client.plugins.HttpPlainText$special$$inlined$sortedByDescending$1
            r0.<init>()
            java.util.List r12 = kotlin.collections.CollectionsKt.sortedWith(r12, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r9 = r9.iterator()
        L_0x002a:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L_0x0043
            java.lang.Object r1 = r9.next()
            r2 = r1
            java.nio.charset.Charset r2 = (java.nio.charset.Charset) r2
            boolean r2 = r10.containsKey(r2)
            r2 = r2 ^ 1
            if (r2 == 0) goto L_0x002a
            r0.add(r1)
            goto L_0x002a
        L_0x0043:
            io.ktor.client.plugins.HttpPlainText$special$$inlined$sortedBy$1 r9 = new io.ktor.client.plugins.HttpPlainText$special$$inlined$sortedBy$1
            r9.<init>()
            java.util.List r9 = kotlin.collections.CollectionsKt.sortedWith(r0, r9)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.util.Iterator r0 = r9.iterator()
        L_0x0055:
            boolean r1 = r0.hasNext()
            java.lang.String r2 = ","
            if (r1 == 0) goto L_0x0074
            java.lang.Object r1 = r0.next()
            java.nio.charset.Charset r1 = (java.nio.charset.Charset) r1
            int r3 = r10.length()
            if (r3 <= 0) goto L_0x006c
            r10.append(r2)
        L_0x006c:
            java.lang.String r1 = io.ktor.utils.io.charsets.CharsetJVMKt.i(r1)
            r10.append(r1)
            goto L_0x0055
        L_0x0074:
            java.util.Iterator r0 = r12.iterator()
        L_0x0078:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00de
            java.lang.Object r1 = r0.next()
            kotlin.Pair r1 = (kotlin.Pair) r1
            java.lang.Object r3 = r1.component1()
            java.nio.charset.Charset r3 = (java.nio.charset.Charset) r3
            java.lang.Object r1 = r1.component2()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            int r4 = r10.length()
            if (r4 <= 0) goto L_0x009d
            r10.append(r2)
        L_0x009d:
            double r4 = (double) r1
            r6 = 0
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x00d2
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 > 0) goto L_0x00d2
            r4 = 100
            float r4 = (float) r4
            float r4 = r4 * r1
            int r1 = kotlin.math.MathKt.roundToInt((float) r4)
            double r4 = (double) r1
            r6 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r4 = r4 / r6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = io.ktor.utils.io.charsets.CharsetJVMKt.i(r3)
            r1.append(r3)
            java.lang.String r3 = ";q="
            r1.append(r3)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r10.append(r1)
            goto L_0x0078
        L_0x00d2:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Check failed."
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x00de:
            int r0 = r10.length()
            if (r0 != 0) goto L_0x00ed
            java.nio.charset.Charset r0 = r8.f8848a
            java.lang.String r0 = io.ktor.utils.io.charsets.CharsetJVMKt.i(r0)
            r10.append(r0)
        L_0x00ed:
            java.lang.String r10 = r10.toString()
            java.lang.String r0 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)
            r8.c = r10
            if (r11 != 0) goto L_0x0119
            java.lang.Object r9 = kotlin.collections.CollectionsKt.firstOrNull(r9)
            r11 = r9
            java.nio.charset.Charset r11 = (java.nio.charset.Charset) r11
            if (r11 != 0) goto L_0x0119
            java.lang.Object r9 = kotlin.collections.CollectionsKt.firstOrNull(r12)
            kotlin.Pair r9 = (kotlin.Pair) r9
            if (r9 == 0) goto L_0x0113
            java.lang.Object r9 = r9.getFirst()
            java.nio.charset.Charset r9 = (java.nio.charset.Charset) r9
        L_0x0111:
            r11 = r9
            goto L_0x0115
        L_0x0113:
            r9 = 0
            goto L_0x0111
        L_0x0115:
            if (r11 != 0) goto L_0x0119
            java.nio.charset.Charset r11 = kotlin.text.Charsets.UTF_8
        L_0x0119:
            r8.b = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpPlainText.<init>(java.util.Set, java.util.Map, java.nio.charset.Charset, java.nio.charset.Charset):void");
    }

    public final void c(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "context");
        HeadersBuilder a2 = httpRequestBuilder.a();
        HttpHeaders httpHeaders = HttpHeaders.f8966a;
        if (a2.h(httpHeaders.d()) == null) {
            Logger a3 = HttpPlainTextKt.f8850a;
            a3.trace("Adding Accept-Charset=" + this.c + " to " + httpRequestBuilder.i());
            httpRequestBuilder.a().k(httpHeaders.d(), this.c);
        }
    }

    public final String d(HttpClientCall httpClientCall, Input input) {
        Intrinsics.checkNotNullParameter(httpClientCall, "call");
        Intrinsics.checkNotNullParameter(input, "body");
        Charset b2 = HttpMessagePropertiesKt.b(httpClientCall.g());
        if (b2 == null) {
            b2 = this.f8848a;
        }
        Logger a2 = HttpPlainTextKt.f8850a;
        a2.trace("Reading response body for " + httpClientCall.f().T() + " as String with charset " + b2);
        return StringsKt.h(input, b2, 0, 2, (Object) null);
    }

    public final Object e(HttpRequestBuilder httpRequestBuilder, String str, ContentType contentType) {
        Charset charset;
        ContentType a2 = contentType == null ? ContentType.Text.f8951a.a() : contentType;
        if (contentType == null || (charset = ContentTypesKt.a(contentType)) == null) {
            charset = this.b;
        }
        Logger a3 = HttpPlainTextKt.f8850a;
        a3.trace("Sending request body to " + httpRequestBuilder.i() + " as text/plain with charset " + charset);
        return new TextContent(str, ContentTypesKt.b(a2, charset), (HttpStatusCode) null, 4, (DefaultConstructorMarker) null);
    }
}
