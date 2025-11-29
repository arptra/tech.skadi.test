package io.ktor.http;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.util.URIUtil;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"Lio/ktor/http/URLProtocol;", "", "b", "(Lio/ktor/http/URLProtocol;)Z", "a", "ktor-http"}, k = 2, mv = {1, 8, 0})
public final class URLProtocolKt {
    public static final boolean a(URLProtocol uRLProtocol) {
        Intrinsics.checkNotNullParameter(uRLProtocol, "<this>");
        return Intrinsics.areEqual((Object) uRLProtocol.f(), (Object) URIUtil.HTTPS) || Intrinsics.areEqual((Object) uRLProtocol.f(), (Object) "wss");
    }

    public static final boolean b(URLProtocol uRLProtocol) {
        Intrinsics.checkNotNullParameter(uRLProtocol, "<this>");
        return Intrinsics.areEqual((Object) uRLProtocol.f(), (Object) "ws") || Intrinsics.areEqual((Object) uRLProtocol.f(), (Object) "wss");
    }
}
