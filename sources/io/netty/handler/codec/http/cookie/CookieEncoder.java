package io.netty.handler.codec.http.cookie;

public abstract class CookieEncoder {
    protected final boolean strict;

    public CookieEncoder(boolean z) {
        this.strict = z;
    }

    public void validateCookie(String str, String str2) {
        if (this.strict) {
            int firstInvalidCookieNameOctet = CookieUtil.firstInvalidCookieNameOctet(str);
            if (firstInvalidCookieNameOctet < 0) {
                CharSequence unwrapValue = CookieUtil.unwrapValue(str2);
                if (unwrapValue != null) {
                    int firstInvalidCookieValueOctet = CookieUtil.firstInvalidCookieValueOctet(unwrapValue);
                    if (firstInvalidCookieValueOctet >= 0) {
                        throw new IllegalArgumentException("Cookie value contains an invalid char: " + unwrapValue.charAt(firstInvalidCookieValueOctet));
                    }
                    return;
                }
                throw new IllegalArgumentException("Cookie value wrapping quotes are not balanced: " + str2);
            }
            throw new IllegalArgumentException("Cookie name contains an invalid char: " + str.charAt(firstInvalidCookieNameOctet));
        }
    }
}
