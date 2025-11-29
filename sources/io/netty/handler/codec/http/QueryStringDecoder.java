package io.netty.handler.codec.http;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class QueryStringDecoder {
    private static final int DEFAULT_MAX_PARAMS = 1024;
    private final Charset charset;
    private final int maxParams;
    private Map<String, List<String>> params;
    private String path;
    private int pathEndIdx;
    private final boolean semicolonIsNormalChar;
    private final String uri;

    public QueryStringDecoder(String str) {
        this(str, HttpConstants.DEFAULT_CHARSET);
    }

    private static boolean addParam(String str, int i, int i2, int i3, Map<String, List<String>> map, Charset charset2) {
        if (i >= i3) {
            return false;
        }
        if (i2 <= i) {
            i2 = i3 + 1;
        }
        String decodeComponent = decodeComponent(str, i, i2 - 1, charset2, false);
        String decodeComponent2 = decodeComponent(str, i2, i3, charset2, false);
        List list = map.get(decodeComponent);
        if (list == null) {
            list = new ArrayList(1);
            map.put(decodeComponent, list);
        }
        list.add(decodeComponent2);
        return true;
    }

    public static String decodeComponent(String str) {
        return decodeComponent(str, HttpConstants.DEFAULT_CHARSET);
    }

    private static Map<String, List<String>> decodeParams(String str, int i, Charset charset2, int i2, boolean z) {
        int length = str.length();
        if (i >= length) {
            return Collections.emptyMap();
        }
        if (str.charAt(i) == '?') {
            i++;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i3 = i;
        int i4 = i3;
        int i5 = -1;
        while (i4 < length) {
            char charAt = str.charAt(i4);
            if (charAt == '#') {
                break;
            }
            if (charAt != '&') {
                if (charAt != ';') {
                    if (charAt == '=') {
                        if (i3 != i4) {
                            if (i5 < i3) {
                                i5 = i4 + 1;
                            }
                        }
                        i3 = i4 + 1;
                    }
                } else if (z) {
                    continue;
                }
                i4++;
            }
            if (addParam(str, i3, i5, i4, linkedHashMap, charset2) && i2 - 1 == 0) {
                return linkedHashMap;
            }
            i3 = i4 + 1;
            i4++;
        }
        addParam(str, i3, i5, i4, linkedHashMap, charset2);
        return linkedHashMap;
    }

    private static int findPathEndIndex(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '?' || charAt == '#') {
                return i;
            }
        }
        return length;
    }

    private int pathEndIdx() {
        if (this.pathEndIdx == -1) {
            this.pathEndIdx = findPathEndIndex(this.uri);
        }
        return this.pathEndIdx;
    }

    public Map<String, List<String>> parameters() {
        if (this.params == null) {
            this.params = decodeParams(this.uri, pathEndIdx(), this.charset, this.maxParams, this.semicolonIsNormalChar);
        }
        return this.params;
    }

    public String path() {
        if (this.path == null) {
            this.path = decodeComponent(this.uri, 0, pathEndIdx(), this.charset, true);
        }
        return this.path;
    }

    public String rawPath() {
        return this.uri.substring(0, pathEndIdx());
    }

    public String rawQuery() {
        int pathEndIdx2 = pathEndIdx() + 1;
        return pathEndIdx2 < this.uri.length() ? this.uri.substring(pathEndIdx2) : "";
    }

    public String toString() {
        return uri();
    }

    public String uri() {
        return this.uri;
    }

    public QueryStringDecoder(String str, boolean z) {
        this(str, HttpConstants.DEFAULT_CHARSET, z);
    }

    public static String decodeComponent(String str, Charset charset2) {
        if (str == null) {
            return "";
        }
        return decodeComponent(str, 0, str.length(), charset2, false);
    }

    public QueryStringDecoder(String str, Charset charset2) {
        this(str, charset2, true);
    }

    public QueryStringDecoder(String str, Charset charset2, boolean z) {
        this(str, charset2, z, 1024);
    }

    private static String decodeComponent(String str, int i, int i2, Charset charset2, boolean z) {
        int i3;
        int i4 = i2 - i;
        if (i4 <= 0) {
            return "";
        }
        int i5 = i;
        while (true) {
            if (i5 >= i2) {
                i5 = -1;
                break;
            }
            char charAt = str.charAt(i5);
            if (charAt == '%' || (charAt == '+' && !z)) {
                break;
            }
            i5++;
        }
        if (i5 == -1) {
            return str.substring(i, i2);
        }
        byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray((i2 - i5) / 3);
        StringBuilder sb = new StringBuilder(i4);
        sb.append(str, i, i5);
        while (i5 < i2) {
            char charAt2 = str.charAt(i5);
            if (charAt2 != '%') {
                if (charAt2 == '+' && !z) {
                    charAt2 = ' ';
                }
                sb.append(charAt2);
            } else {
                int i6 = 0;
                while (true) {
                    int i7 = i5 + 3;
                    if (i7 <= i2) {
                        i3 = i6 + 1;
                        allocateUninitializedArray[i6] = StringUtil.decodeHexByte(str, i5 + 1);
                        if (i7 >= i2 || str.charAt(i7) != '%') {
                            i5 += 2;
                            sb.append(new String(allocateUninitializedArray, 0, i3, charset2));
                        } else {
                            i5 = i7;
                            i6 = i3;
                        }
                    } else {
                        throw new IllegalArgumentException("unterminated escape sequence at index " + i5 + " of: " + str);
                    }
                }
                i5 += 2;
                sb.append(new String(allocateUninitializedArray, 0, i3, charset2));
            }
            i5++;
        }
        return sb.toString();
    }

    public QueryStringDecoder(String str, Charset charset2, boolean z, int i) {
        this(str, charset2, z, i, false);
    }

    public QueryStringDecoder(String str, Charset charset2, boolean z, int i, boolean z2) {
        this.uri = (String) ObjectUtil.checkNotNull(str, "uri");
        this.charset = (Charset) ObjectUtil.checkNotNull(charset2, "charset");
        this.maxParams = ObjectUtil.checkPositive(i, "maxParams");
        this.semicolonIsNormalChar = z2;
        this.pathEndIdx = z ? -1 : 0;
    }

    public QueryStringDecoder(URI uri2) {
        this(uri2, HttpConstants.DEFAULT_CHARSET);
    }

    public QueryStringDecoder(URI uri2, Charset charset2) {
        this(uri2, charset2, 1024);
    }

    public QueryStringDecoder(URI uri2, Charset charset2, int i) {
        this(uri2, charset2, i, false);
    }

    public QueryStringDecoder(URI uri2, Charset charset2, int i, boolean z) {
        String str;
        String rawPath = uri2.getRawPath();
        rawPath = rawPath == null ? "" : rawPath;
        String rawQuery = uri2.getRawQuery();
        if (rawQuery == null) {
            str = rawPath;
        } else {
            str = rawPath + '?' + rawQuery;
        }
        this.uri = str;
        this.charset = (Charset) ObjectUtil.checkNotNull(charset2, "charset");
        this.maxParams = ObjectUtil.checkPositive(i, "maxParams");
        this.semicolonIsNormalChar = z;
        this.pathEndIdx = rawPath.length();
    }
}
