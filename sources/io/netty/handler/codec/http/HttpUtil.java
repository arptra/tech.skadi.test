package io.netty.handler.codec.http;

import com.here.posclient.UpdateOptions;
import com.meizu.common.widget.MzContactsContract;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class HttpUtil {
    private static final AsciiString CHARSET_EQUALS = AsciiString.of(HttpHeaderValues.CHARSET + "=");
    private static final String COMMA_STRING = String.valueOf(StringUtil.COMMA);
    private static final AsciiString SEMICOLON = AsciiString.cached(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD);

    private HttpUtil() {
    }

    public static String formatHostnameForHttp(InetSocketAddress inetSocketAddress) {
        String hostname = NetUtil.getHostname(inetSocketAddress);
        if (!NetUtil.isValidIpV6Address(hostname)) {
            return hostname;
        }
        if (!inetSocketAddress.isUnresolved()) {
            hostname = NetUtil.toAddressString(inetSocketAddress.getAddress());
        }
        return '[' + hostname + ']';
    }

    public static Charset getCharset(HttpMessage httpMessage) {
        return getCharset(httpMessage, CharsetUtil.ISO_8859_1);
    }

    public static CharSequence getCharsetAsSequence(HttpMessage httpMessage) {
        String str = httpMessage.headers().get((CharSequence) HttpHeaderNames.CONTENT_TYPE);
        if (str != null) {
            return getCharsetAsSequence((CharSequence) str);
        }
        return null;
    }

    @Deprecated
    public static CharSequence getCharsetAsString(HttpMessage httpMessage) {
        return getCharsetAsSequence(httpMessage);
    }

    public static long getContentLength(HttpMessage httpMessage) {
        HttpHeaders headers = httpMessage.headers();
        AsciiString asciiString = HttpHeaderNames.CONTENT_LENGTH;
        String str = headers.get((CharSequence) asciiString);
        if (str != null) {
            return Long.parseLong(str);
        }
        long webSocketContentLength = (long) getWebSocketContentLength(httpMessage);
        if (webSocketContentLength >= 0) {
            return webSocketContentLength;
        }
        throw new NumberFormatException("header not found: " + asciiString);
    }

    public static CharSequence getMimeType(HttpMessage httpMessage) {
        String str = httpMessage.headers().get((CharSequence) HttpHeaderNames.CONTENT_TYPE);
        if (str != null) {
            return getMimeType((CharSequence) str);
        }
        return null;
    }

    private static int getWebSocketContentLength(HttpMessage httpMessage) {
        HttpHeaders headers = httpMessage.headers();
        return httpMessage instanceof HttpRequest ? (!HttpMethod.GET.equals(((HttpRequest) httpMessage).method()) || !headers.contains((CharSequence) HttpHeaderNames.SEC_WEBSOCKET_KEY1) || !headers.contains((CharSequence) HttpHeaderNames.SEC_WEBSOCKET_KEY2)) ? -1 : 8 : (!(httpMessage instanceof HttpResponse) || ((HttpResponse) httpMessage).status().code() != 101 || !headers.contains((CharSequence) HttpHeaderNames.SEC_WEBSOCKET_ORIGIN) || !headers.contains((CharSequence) HttpHeaderNames.SEC_WEBSOCKET_LOCATION)) ? -1 : 16;
    }

    public static boolean is100ContinueExpected(HttpMessage httpMessage) {
        return isExpectHeaderValid(httpMessage) && httpMessage.headers().contains((CharSequence) HttpHeaderNames.EXPECT, (CharSequence) HttpHeaderValues.CONTINUE, true);
    }

    public static boolean isAsteriskForm(URI uri) {
        return isAsteriskForm(uri.toString());
    }

    public static boolean isContentLengthSet(HttpMessage httpMessage) {
        return httpMessage.headers().contains((CharSequence) HttpHeaderNames.CONTENT_LENGTH);
    }

    private static boolean isExpectHeaderValid(HttpMessage httpMessage) {
        return (httpMessage instanceof HttpRequest) && httpMessage.protocolVersion().compareTo(HttpVersion.HTTP_1_1) >= 0;
    }

    public static boolean isKeepAlive(HttpMessage httpMessage) {
        HttpHeaders headers = httpMessage.headers();
        AsciiString asciiString = HttpHeaderNames.CONNECTION;
        return !headers.containsValue(asciiString, HttpHeaderValues.CLOSE, true) && (httpMessage.protocolVersion().isKeepAliveDefault() || httpMessage.headers().containsValue(asciiString, HttpHeaderValues.KEEP_ALIVE, true));
    }

    public static boolean isOriginForm(URI uri) {
        return isOriginForm(uri.toString());
    }

    public static boolean isTransferEncodingChunked(HttpMessage httpMessage) {
        return httpMessage.headers().containsValue(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r2 = r2.headers().get((java.lang.CharSequence) io.netty.handler.codec.http.HttpHeaderNames.EXPECT);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isUnsupportedExpectation(io.netty.handler.codec.http.HttpMessage r2) {
        /*
            boolean r0 = isExpectHeaderValid(r2)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            io.netty.handler.codec.http.HttpHeaders r2 = r2.headers()
            io.netty.util.AsciiString r0 = io.netty.handler.codec.http.HttpHeaderNames.EXPECT
            java.lang.String r2 = r2.get((java.lang.CharSequence) r0)
            if (r2 == 0) goto L_0x0021
            io.netty.util.AsciiString r0 = io.netty.handler.codec.http.HttpHeaderValues.CONTINUE
            java.lang.String r0 = r0.toString()
            boolean r2 = r0.equalsIgnoreCase(r2)
            if (r2 != 0) goto L_0x0021
            r1 = 1
        L_0x0021:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.HttpUtil.isUnsupportedExpectation(io.netty.handler.codec.http.HttpMessage):boolean");
    }

    public static long normalizeAndGetContentLength(List<? extends CharSequence> list, boolean z, boolean z2) {
        if (list.isEmpty()) {
            return -1;
        }
        String charSequence = ((CharSequence) list.get(0)).toString();
        if ((list.size() > 1 || charSequence.indexOf(44) >= 0) && !z) {
            if (z2) {
                charSequence = null;
                for (CharSequence charSequence2 : list) {
                    String[] split = charSequence2.toString().split(COMMA_STRING, -1);
                    int length = split.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            String trim = split[i].trim();
                            if (charSequence == null) {
                                charSequence = trim;
                            } else if (!trim.equals(charSequence)) {
                                throw new IllegalArgumentException("Multiple Content-Length values found: " + list);
                            }
                            i++;
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("Multiple Content-Length values found: " + list);
            }
        }
        if (charSequence.isEmpty() || !Character.isDigit(charSequence.charAt(0))) {
            throw new IllegalArgumentException("Content-Length value is not a number: " + charSequence);
        }
        try {
            return ObjectUtil.checkPositiveOrZero(Long.parseLong(charSequence), "Content-Length value");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Content-Length value is not a number: " + charSequence, e);
        }
    }

    public static void set100ContinueExpected(HttpMessage httpMessage, boolean z) {
        if (z) {
            httpMessage.headers().set((CharSequence) HttpHeaderNames.EXPECT, (Object) HttpHeaderValues.CONTINUE);
        } else {
            httpMessage.headers().remove((CharSequence) HttpHeaderNames.EXPECT);
        }
    }

    public static void setContentLength(HttpMessage httpMessage, long j) {
        httpMessage.headers().set((CharSequence) HttpHeaderNames.CONTENT_LENGTH, (Object) Long.valueOf(j));
    }

    public static void setKeepAlive(HttpMessage httpMessage, boolean z) {
        setKeepAlive(httpMessage.headers(), httpMessage.protocolVersion(), z);
    }

    public static void setTransferEncodingChunked(HttpMessage httpMessage, boolean z) {
        if (z) {
            httpMessage.headers().set((CharSequence) HttpHeaderNames.TRANSFER_ENCODING, (Object) HttpHeaderValues.CHUNKED);
            httpMessage.headers().remove((CharSequence) HttpHeaderNames.CONTENT_LENGTH);
            return;
        }
        List<String> all = httpMessage.headers().getAll((CharSequence) HttpHeaderNames.TRANSFER_ENCODING);
        if (!all.isEmpty()) {
            ArrayList arrayList = new ArrayList(all);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (HttpHeaderValues.CHUNKED.contentEqualsIgnoreCase((CharSequence) it.next())) {
                    it.remove();
                }
            }
            if (arrayList.isEmpty()) {
                httpMessage.headers().remove((CharSequence) HttpHeaderNames.TRANSFER_ENCODING);
            } else {
                httpMessage.headers().set((CharSequence) HttpHeaderNames.TRANSFER_ENCODING, (Iterable<?>) arrayList);
            }
        }
    }

    public static Charset getCharset(CharSequence charSequence) {
        if (charSequence != null) {
            return getCharset(charSequence, CharsetUtil.ISO_8859_1);
        }
        return CharsetUtil.ISO_8859_1;
    }

    public static boolean isAsteriskForm(String str) {
        return "*".equals(str);
    }

    public static boolean isOriginForm(String str) {
        return str.startsWith("/");
    }

    public static void setKeepAlive(HttpHeaders httpHeaders, HttpVersion httpVersion, boolean z) {
        if (httpVersion.isKeepAliveDefault()) {
            if (z) {
                httpHeaders.remove((CharSequence) HttpHeaderNames.CONNECTION);
            } else {
                httpHeaders.set((CharSequence) HttpHeaderNames.CONNECTION, (Object) HttpHeaderValues.CLOSE);
            }
        } else if (z) {
            httpHeaders.set((CharSequence) HttpHeaderNames.CONNECTION, (Object) HttpHeaderValues.KEEP_ALIVE);
        } else {
            httpHeaders.remove((CharSequence) HttpHeaderNames.CONNECTION);
        }
    }

    public static CharSequence getCharsetAsSequence(CharSequence charSequence) {
        int length;
        ObjectUtil.checkNotNull(charSequence, "contentTypeValue");
        AsciiString asciiString = CHARSET_EQUALS;
        int indexOfIgnoreCaseAscii = AsciiString.indexOfIgnoreCaseAscii(charSequence, asciiString, 0);
        if (indexOfIgnoreCaseAscii == -1 || (length = indexOfIgnoreCaseAscii + asciiString.length()) >= charSequence.length()) {
            return null;
        }
        CharSequence subSequence = charSequence.subSequence(length, charSequence.length());
        int indexOfIgnoreCaseAscii2 = AsciiString.indexOfIgnoreCaseAscii(subSequence, SEMICOLON, 0);
        if (indexOfIgnoreCaseAscii2 == -1) {
            return subSequence;
        }
        return subSequence.subSequence(0, indexOfIgnoreCaseAscii2);
    }

    public static CharSequence getMimeType(CharSequence charSequence) {
        ObjectUtil.checkNotNull(charSequence, "contentTypeValue");
        int indexOfIgnoreCaseAscii = AsciiString.indexOfIgnoreCaseAscii(charSequence, SEMICOLON, 0);
        if (indexOfIgnoreCaseAscii != -1) {
            return charSequence.subSequence(0, indexOfIgnoreCaseAscii);
        }
        if (charSequence.length() > 0) {
            return charSequence;
        }
        return null;
    }

    public static Charset getCharset(HttpMessage httpMessage, Charset charset) {
        String str = httpMessage.headers().get((CharSequence) HttpHeaderNames.CONTENT_TYPE);
        return str != null ? getCharset((CharSequence) str, charset) : charset;
    }

    public static long getContentLength(HttpMessage httpMessage, long j) {
        String str = httpMessage.headers().get((CharSequence) HttpHeaderNames.CONTENT_LENGTH);
        if (str != null) {
            return Long.parseLong(str);
        }
        long webSocketContentLength = (long) getWebSocketContentLength(httpMessage);
        return webSocketContentLength >= 0 ? webSocketContentLength : j;
    }

    public static Charset getCharset(CharSequence charSequence, Charset charset) {
        CharSequence charsetAsSequence;
        if (!(charSequence == null || (charsetAsSequence = getCharsetAsSequence(charSequence)) == null)) {
            if (charsetAsSequence.length() > 2 && charsetAsSequence.charAt(0) == '\"' && charsetAsSequence.charAt(charsetAsSequence.length() - 1) == '\"') {
                charsetAsSequence = charsetAsSequence.subSequence(1, charsetAsSequence.length() - 1);
            }
            try {
                return Charset.forName(charsetAsSequence.toString());
            } catch (IllegalCharsetNameException | UnsupportedCharsetException unused) {
            }
        }
        return charset;
    }

    public static int getContentLength(HttpMessage httpMessage, int i) {
        return (int) Math.min(UpdateOptions.SOURCE_ANY, getContentLength(httpMessage, (long) i));
    }
}
