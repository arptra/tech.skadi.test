package io.ktor.client.plugins.websocket;

import com.upuphone.runasone.channel.linker.websocket.WsUtil;
import io.ktor.client.request.ClientUpgradeContent;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.util.Base64Kt;
import io.ktor.util.CryptoKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\u000e\u001a\u00020\n8\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/websocket/WebSocketContent;", "Lio/ktor/client/request/ClientUpgradeContent;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "b", "Ljava/lang/String;", "nonce", "Lio/ktor/http/Headers;", "c", "Lio/ktor/http/Headers;", "()Lio/ktor/http/Headers;", "headers", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class WebSocketContent extends ClientUpgradeContent {
    public final String b;
    public final Headers c;

    public WebSocketContent() {
        String str = Base64Kt.g(CryptoKt.b(16));
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().apply(builderAction).toString()");
        this.b = str;
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, (DefaultConstructorMarker) null);
        HttpHeaders httpHeaders = HttpHeaders.f8966a;
        headersBuilder.e(httpHeaders.A(), WsUtil.WEB_SOCKET_PATH);
        headersBuilder.e(httpHeaders.g(), "Upgrade");
        headersBuilder.e(httpHeaders.w(), str);
        headersBuilder.e(httpHeaders.x(), "13");
        this.c = headersBuilder.n();
    }

    public Headers c() {
        return this.c;
    }

    public String toString() {
        return "WebSocketContent";
    }
}
