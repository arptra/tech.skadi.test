package io.ktor.client.plugins;

import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import org.slf4j.Logger;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\"\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u0018\u0010\r\u001a\u00060\tj\u0002`\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lio/ktor/http/HttpStatusCode;", "", "d", "(Lio/ktor/http/HttpStatusCode;)Z", "", "Lio/ktor/http/HttpMethod;", "a", "Ljava/util/Set;", "ALLOWED_FOR_REDIRECT", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "b", "Lorg/slf4j/Logger;", "LOGGER", "ktor-client-core"}, k = 2, mv = {1, 8, 0})
public final class HttpRedirectKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Set f8853a;
    public static final Logger b = KtorSimpleLoggerJvmKt.a("io.ktor.client.plugins.HttpRedirect");

    static {
        HttpMethod.Companion companion = HttpMethod.b;
        f8853a = SetsKt.setOf(companion.a(), companion.b());
    }

    public static final boolean d(HttpStatusCode httpStatusCode) {
        int h0 = httpStatusCode.h0();
        HttpStatusCode.Companion companion = HttpStatusCode.c;
        return h0 == companion.r().h0() || h0 == companion.j().h0() || h0 == companion.R().h0() || h0 == companion.E().h0() || h0 == companion.N().h0();
    }
}
