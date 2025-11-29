package io.netty.handler.codec.http;

import io.netty.handler.codec.http.cookie.Cookie;

@Deprecated
public final class ClientCookieEncoder {
    private ClientCookieEncoder() {
    }

    @Deprecated
    public static String encode(String str, String str2) {
        return io.netty.handler.codec.http.cookie.ClientCookieEncoder.LAX.encode(str, str2);
    }

    @Deprecated
    public static String encode(Cookie cookie) {
        return io.netty.handler.codec.http.cookie.ClientCookieEncoder.LAX.encode((Cookie) cookie);
    }

    @Deprecated
    public static String encode(Cookie... cookieArr) {
        return io.netty.handler.codec.http.cookie.ClientCookieEncoder.LAX.encode((Cookie[]) cookieArr);
    }

    @Deprecated
    public static String encode(Iterable<Cookie> iterable) {
        return io.netty.handler.codec.http.cookie.ClientCookieEncoder.LAX.encode((Iterable<? extends Cookie>) iterable);
    }
}
