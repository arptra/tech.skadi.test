package io.ktor.client.plugins.cache;

import io.ktor.http.URLProtocol;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.util.URIUtil;
import org.slf4j.Logger;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aU\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00050\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\u000b\u001a\u00020\n*\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\f\"\u001e\u0010\u0013\u001a\u00060\rj\u0002`\u000e8\u0000X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lio/ktor/http/content/OutgoingContent;", "content", "Lkotlin/Function1;", "", "headerExtractor", "", "allHeadersExtractor", "d", "(Lio/ktor/http/content/OutgoingContent;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "Lio/ktor/http/URLProtocol;", "", "b", "(Lio/ktor/http/URLProtocol;)Z", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "a", "Lorg/slf4j/Logger;", "c", "()Lorg/slf4j/Logger;", "LOGGER", "ktor-client-core"}, k = 2, mv = {1, 8, 0})
public final class HttpCacheKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f8891a = KtorSimpleLoggerJvmKt.a("io.ktor.client.plugins.HttpCache");

    public static final boolean b(URLProtocol uRLProtocol) {
        return Intrinsics.areEqual((Object) uRLProtocol.f(), (Object) URIUtil.HTTP) || Intrinsics.areEqual((Object) uRLProtocol.f(), (Object) URIUtil.HTTPS);
    }

    public static final Logger c() {
        return f8891a;
    }

    public static final Function1 d(OutgoingContent outgoingContent, Function1 function1, Function1 function12) {
        Intrinsics.checkNotNullParameter(outgoingContent, "content");
        Intrinsics.checkNotNullParameter(function1, "headerExtractor");
        Intrinsics.checkNotNullParameter(function12, "allHeadersExtractor");
        return new HttpCacheKt$mergedHeadersLookup$1(outgoingContent, function1, function12);
    }
}
