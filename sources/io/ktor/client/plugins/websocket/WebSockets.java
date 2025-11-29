package io.ktor.client.plugins.websocket;

import com.here.posclient.UpdateOptions;
import com.meizu.common.widget.MzContactsContract;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.HttpHeaders;
import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.DefaultWebSocketSessionKt;
import io.ktor.websocket.WebSocketExtension;
import io.ktor.websocket.WebSocketExtensionHeaderKt;
import io.ktor.websocket.WebSocketExtensionsConfig;
import io.ktor.websocket.WebSocketSession;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u00192\u00020\u0001:\u0002*+B-\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0017H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b#\u0010 \u001a\u0004\b$\u0010\"R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u001d\u0010'\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lio/ktor/client/plugins/websocket/WebSockets;", "", "", "pingInterval", "maxFrameSize", "Lio/ktor/websocket/WebSocketExtensionsConfig;", "extensionsConfig", "Lio/ktor/serialization/WebsocketContentConverter;", "contentConverter", "<init>", "(JJLio/ktor/websocket/WebSocketExtensionsConfig;Lio/ktor/serialization/WebsocketContentConverter;)V", "Lio/ktor/websocket/WebSocketSession;", "session", "Lio/ktor/websocket/DefaultWebSocketSession;", "f", "(Lio/ktor/websocket/WebSocketSession;)Lio/ktor/websocket/DefaultWebSocketSession;", "Lio/ktor/client/request/HttpRequestBuilder;", "context", "", "g", "(Lio/ktor/client/request/HttpRequestBuilder;)V", "Lio/ktor/client/call/HttpClientCall;", "call", "", "Lio/ktor/websocket/WebSocketExtension;", "e", "(Lio/ktor/client/call/HttpClientCall;)Ljava/util/List;", "Lio/ktor/websocket/WebSocketExtensionHeader;", "protocols", "d", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/util/List;)V", "a", "J", "getPingInterval", "()J", "b", "getMaxFrameSize", "c", "Lio/ktor/websocket/WebSocketExtensionsConfig;", "Lio/ktor/serialization/WebsocketContentConverter;", "getContentConverter", "()Lio/ktor/serialization/WebsocketContentConverter;", "Config", "Plugin", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nWebSockets.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebSockets.kt\nio/ktor/client/plugins/websocket/WebSockets\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,223:1\n1360#2:224\n1446#2,5:225\n766#2:231\n857#2,2:232\n1#3:230\n*S KotlinDebug\n*F\n+ 1 WebSockets.kt\nio/ktor/client/plugins/websocket/WebSockets\n*L\n72#1:224\n72#1:225,5\n86#1:231\n86#1:232,2\n*E\n"})
public final class WebSockets {
    public static final Plugin e = new Plugin((DefaultConstructorMarker) null);
    public static final AttributeKey f = new AttributeKey("Websocket");

    /* renamed from: a  reason: collision with root package name */
    public final long f8911a;
    public final long b;
    public final WebSocketExtensionsConfig c;
    public final WebsocketContentConverter d;

    @KtorDsl
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0005\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lio/ktor/client/plugins/websocket/WebSockets$Config;", "", "<init>", "()V", "Lio/ktor/websocket/WebSocketExtensionsConfig;", "a", "Lio/ktor/websocket/WebSocketExtensionsConfig;", "b", "()Lio/ktor/websocket/WebSocketExtensionsConfig;", "extensionsConfig", "", "J", "d", "()J", "setPingInterval", "(J)V", "pingInterval", "c", "setMaxFrameSize", "maxFrameSize", "Lio/ktor/serialization/WebsocketContentConverter;", "Lio/ktor/serialization/WebsocketContentConverter;", "()Lio/ktor/serialization/WebsocketContentConverter;", "setContentConverter", "(Lio/ktor/serialization/WebsocketContentConverter;)V", "contentConverter", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class Config {

        /* renamed from: a  reason: collision with root package name */
        public final WebSocketExtensionsConfig f8912a = new WebSocketExtensionsConfig();
        public long b = -1;
        public long c = UpdateOptions.SOURCE_ANY;
        public WebsocketContentConverter d;

        public final WebsocketContentConverter a() {
            return this.d;
        }

        public final WebSocketExtensionsConfig b() {
            return this.f8912a;
        }

        public final long c() {
            return this.c;
        }

        public final long d() {
            return this.b;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/client/plugins/websocket/WebSockets$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/websocket/WebSockets$Config;", "Lio/ktor/client/plugins/websocket/WebSockets;", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "d", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/websocket/WebSockets;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "c", "(Lio/ktor/client/plugins/websocket/WebSockets;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class Plugin implements HttpClientPlugin<Config, WebSockets> {
        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: c */
        public void b(WebSockets webSockets, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(webSockets, "plugin");
            Intrinsics.checkNotNullParameter(httpClient, "scope");
            boolean contains = httpClient.d().C().contains(WebSocketExtensionsCapability.f8910a);
            httpClient.n().l(HttpRequestPipeline.g.b(), new WebSockets$Plugin$install$1(contains, webSockets, (Continuation<? super WebSockets$Plugin$install$1>) null));
            httpClient.r().l(HttpResponsePipeline.g.c(), new WebSockets$Plugin$install$2(webSockets, contains, (Continuation<? super WebSockets$Plugin$install$2>) null));
        }

        /* renamed from: d */
        public WebSockets a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            Config config = new Config();
            function1.invoke(config);
            return new WebSockets(config.d(), config.c(), config.b(), config.a());
        }

        public AttributeKey getKey() {
            return WebSockets.f;
        }

        public Plugin() {
        }
    }

    public WebSockets(long j, long j2, WebSocketExtensionsConfig webSocketExtensionsConfig, WebsocketContentConverter websocketContentConverter) {
        Intrinsics.checkNotNullParameter(webSocketExtensionsConfig, "extensionsConfig");
        this.f8911a = j;
        this.b = j2;
        this.c = webSocketExtensionsConfig;
        this.d = websocketContentConverter;
    }

    public final void d(HttpRequestBuilder httpRequestBuilder, List list) {
        if (!list.isEmpty()) {
            UtilsKt.b(httpRequestBuilder, HttpHeaders.f8966a.v(), CollectionsKt.joinToString$default(list, MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
    }

    public final List e(HttpClientCall httpClientCall) {
        List list;
        String str = httpClientCall.g().a().get(HttpHeaders.f8966a.v());
        if (str == null || (list = WebSocketExtensionHeaderKt.a(str)) == null) {
            list = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : (List) httpClientCall.J().f(WebSocketsKt.f8913a)) {
            if (((WebSocketExtension) next).d(list)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public final DefaultWebSocketSession f(WebSocketSession webSocketSession) {
        Intrinsics.checkNotNullParameter(webSocketSession, "session");
        if (webSocketSession instanceof DefaultWebSocketSession) {
            return (DefaultWebSocketSession) webSocketSession;
        }
        long j = this.f8911a;
        DefaultWebSocketSession a2 = DefaultWebSocketSessionKt.a(webSocketSession, j, ((long) 2) * j);
        a2.d0(this.b);
        return a2;
    }

    public final void g(HttpRequestBuilder httpRequestBuilder) {
        List<WebSocketExtension> a2 = this.c.a();
        httpRequestBuilder.c().a(WebSocketsKt.f8913a, a2);
        ArrayList arrayList = new ArrayList();
        for (WebSocketExtension a3 : a2) {
            CollectionsKt.addAll(arrayList, a3.a());
        }
        d(httpRequestBuilder, arrayList);
    }
}
