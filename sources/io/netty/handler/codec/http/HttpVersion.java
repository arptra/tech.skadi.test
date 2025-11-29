package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpVersion implements Comparable<HttpVersion> {
    public static final HttpVersion HTTP_1_0 = new HttpVersion("HTTP", 1, 0, false, true);
    private static final String HTTP_1_0_STRING = "HTTP/1.0";
    public static final HttpVersion HTTP_1_1 = new HttpVersion("HTTP", 1, 1, true, true);
    private static final String HTTP_1_1_STRING = "HTTP/1.1";
    private static final Pattern VERSION_PATTERN = Pattern.compile("(\\S+)/(\\d+)\\.(\\d+)");
    private final byte[] bytes;
    private final boolean keepAliveDefault;
    private final int majorVersion;
    private final int minorVersion;
    private final String protocolName;
    private final String text;

    public HttpVersion(String str, boolean z) {
        String upperCase = ObjectUtil.checkNonEmptyAfterTrim(str, "text").toUpperCase();
        Matcher matcher = VERSION_PATTERN.matcher(upperCase);
        if (matcher.matches()) {
            String group = matcher.group(1);
            this.protocolName = group;
            int parseInt = Integer.parseInt(matcher.group(2));
            this.majorVersion = parseInt;
            int parseInt2 = Integer.parseInt(matcher.group(3));
            this.minorVersion = parseInt2;
            this.text = group + '/' + parseInt + '.' + parseInt2;
            this.keepAliveDefault = z;
            this.bytes = null;
            return;
        }
        throw new IllegalArgumentException("invalid version format: " + upperCase);
    }

    public static HttpVersion valueOf(String str) {
        ObjectUtil.checkNotNull(str, "text");
        String trim = str.trim();
        if (!trim.isEmpty()) {
            HttpVersion version0 = version0(trim);
            return version0 == null ? new HttpVersion(trim, true) : version0;
        }
        throw new IllegalArgumentException("text is empty (possibly HTTP/0.9)");
    }

    private static HttpVersion version0(String str) {
        if (HTTP_1_1_STRING.equals(str)) {
            return HTTP_1_1;
        }
        if (HTTP_1_0_STRING.equals(str)) {
            return HTTP_1_0;
        }
        return null;
    }

    public void encode(ByteBuf byteBuf) {
        byte[] bArr = this.bytes;
        if (bArr == null) {
            byteBuf.writeCharSequence(this.text, CharsetUtil.US_ASCII);
        } else {
            byteBuf.writeBytes(bArr);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HttpVersion)) {
            return false;
        }
        HttpVersion httpVersion = (HttpVersion) obj;
        return minorVersion() == httpVersion.minorVersion() && majorVersion() == httpVersion.majorVersion() && protocolName().equals(httpVersion.protocolName());
    }

    public int hashCode() {
        return (((protocolName().hashCode() * 31) + majorVersion()) * 31) + minorVersion();
    }

    public boolean isKeepAliveDefault() {
        return this.keepAliveDefault;
    }

    public int majorVersion() {
        return this.majorVersion;
    }

    public int minorVersion() {
        return this.minorVersion;
    }

    public String protocolName() {
        return this.protocolName;
    }

    public String text() {
        return this.text;
    }

    public String toString() {
        return text();
    }

    public int compareTo(HttpVersion httpVersion) {
        int compareTo = protocolName().compareTo(httpVersion.protocolName());
        if (compareTo != 0) {
            return compareTo;
        }
        int majorVersion2 = majorVersion() - httpVersion.majorVersion();
        if (majorVersion2 != 0) {
            return majorVersion2;
        }
        return minorVersion() - httpVersion.minorVersion();
    }

    public HttpVersion(String str, int i, int i2, boolean z) {
        this(str, i, i2, z, false);
    }

    private HttpVersion(String str, int i, int i2, boolean z, boolean z2) {
        String upperCase = ObjectUtil.checkNonEmptyAfterTrim(str, "protocolName").toUpperCase();
        for (int i3 = 0; i3 < upperCase.length(); i3++) {
            if (Character.isISOControl(upperCase.charAt(i3)) || Character.isWhitespace(upperCase.charAt(i3))) {
                throw new IllegalArgumentException("invalid character in protocolName");
            }
        }
        ObjectUtil.checkPositiveOrZero(i, "majorVersion");
        ObjectUtil.checkPositiveOrZero(i2, "minorVersion");
        this.protocolName = upperCase;
        this.majorVersion = i;
        this.minorVersion = i2;
        String str2 = upperCase + '/' + i + '.' + i2;
        this.text = str2;
        this.keepAliveDefault = z;
        if (z2) {
            this.bytes = str2.getBytes(CharsetUtil.US_ASCII);
        } else {
            this.bytes = null;
        }
    }
}
