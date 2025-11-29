package io.ktor.client.plugins.cookies;

import io.ktor.http.Cookie;
import io.ktor.http.CookieKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class HttpCookiesKt$renderClientCookies$1 extends FunctionReferenceImpl implements Function1<Cookie, String> {
    public static final HttpCookiesKt$renderClientCookies$1 INSTANCE = new HttpCookiesKt$renderClientCookies$1();

    public HttpCookiesKt$renderClientCookies$1() {
        super(1, CookieKt.class, "renderCookieHeader", "renderCookieHeader(Lio/ktor/http/Cookie;)Ljava/lang/String;", 1);
    }

    @NotNull
    public final String invoke(@NotNull Cookie cookie) {
        Intrinsics.checkNotNullParameter(cookie, "p0");
        return CookieKt.f(cookie);
    }
}
