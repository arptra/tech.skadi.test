package io.netty.handler.codec.http2;

import com.here.sdk.search.PlaceCategory;
import com.upuphone.runasone.api.ApiConstant;
import io.netty.handler.codec.UnsupportedValueConverter;
import io.netty.util.AsciiString;
import java.util.Arrays;
import java.util.List;
import okhttp3.internal.http2.Header;
import org.eclipse.jetty.util.URIUtil;

final class HpackStaticTable {
    private static final int MAX_SAME_NAME_FIELD_INDEX = maxSameNameFieldIndex();
    static final int NOT_FOUND = -1;
    private static final CharSequenceMap<Integer> STATIC_INDEX_BY_NAME = createMap();
    private static final List<HpackHeaderField> STATIC_TABLE;
    static final int length;

    static {
        List<HpackHeaderField> asList = Arrays.asList(new HpackHeaderField[]{newEmptyHeaderField(Header.TARGET_AUTHORITY_UTF8), newHeaderField(Header.TARGET_METHOD_UTF8, "GET"), newHeaderField(Header.TARGET_METHOD_UTF8, "POST"), newHeaderField(Header.TARGET_PATH_UTF8, "/"), newHeaderField(Header.TARGET_PATH_UTF8, "/index.html"), newHeaderField(Header.TARGET_SCHEME_UTF8, URIUtil.HTTP), newHeaderField(Header.TARGET_SCHEME_UTF8, URIUtil.HTTPS), newHeaderField(Header.RESPONSE_STATUS_UTF8, "200"), newHeaderField(Header.RESPONSE_STATUS_UTF8, "204"), newHeaderField(Header.RESPONSE_STATUS_UTF8, "206"), newHeaderField(Header.RESPONSE_STATUS_UTF8, "304"), newHeaderField(Header.RESPONSE_STATUS_UTF8, PlaceCategory.TRANSPORT), newHeaderField(Header.RESPONSE_STATUS_UTF8, "404"), newHeaderField(Header.RESPONSE_STATUS_UTF8, PlaceCategory.ACCOMMODATION), newEmptyHeaderField("accept-charset"), newHeaderField("accept-encoding", "gzip, deflate"), newEmptyHeaderField("accept-language"), newEmptyHeaderField("accept-ranges"), newEmptyHeaderField("accept"), newEmptyHeaderField("access-control-allow-origin"), newEmptyHeaderField("age"), newEmptyHeaderField("allow"), newEmptyHeaderField("authorization"), newEmptyHeaderField("cache-control"), newEmptyHeaderField("content-disposition"), newEmptyHeaderField("content-encoding"), newEmptyHeaderField("content-language"), newEmptyHeaderField("content-length"), newEmptyHeaderField("content-location"), newEmptyHeaderField("content-range"), newEmptyHeaderField("content-type"), newEmptyHeaderField("cookie"), newEmptyHeaderField("date"), newEmptyHeaderField("etag"), newEmptyHeaderField("expect"), newEmptyHeaderField("expires"), newEmptyHeaderField("from"), newEmptyHeaderField(ApiConstant.VALUE_HOST), newEmptyHeaderField("if-match"), newEmptyHeaderField("if-modified-since"), newEmptyHeaderField("if-none-match"), newEmptyHeaderField("if-range"), newEmptyHeaderField("if-unmodified-since"), newEmptyHeaderField("last-modified"), newEmptyHeaderField("link"), newEmptyHeaderField("location"), newEmptyHeaderField("max-forwards"), newEmptyHeaderField("proxy-authenticate"), newEmptyHeaderField("proxy-authorization"), newEmptyHeaderField("range"), newEmptyHeaderField("referer"), newEmptyHeaderField("refresh"), newEmptyHeaderField("retry-after"), newEmptyHeaderField("server"), newEmptyHeaderField("set-cookie"), newEmptyHeaderField("strict-transport-security"), newEmptyHeaderField("transfer-encoding"), newEmptyHeaderField("user-agent"), newEmptyHeaderField("vary"), newEmptyHeaderField("via"), newEmptyHeaderField("www-authenticate")});
        STATIC_TABLE = asList;
        length = asList.size();
    }

    private HpackStaticTable() {
    }

    private static CharSequenceMap<Integer> createMap() {
        int size = STATIC_TABLE.size();
        CharSequenceMap<Integer> charSequenceMap = new CharSequenceMap<>(true, UnsupportedValueConverter.instance(), size);
        while (size > 0) {
            charSequenceMap.set(getEntry(size).name, Integer.valueOf(size));
            size--;
        }
        return charSequenceMap;
    }

    public static HpackHeaderField getEntry(int i) {
        return STATIC_TABLE.get(i - 1);
    }

    public static int getIndex(CharSequence charSequence) {
        Integer num = STATIC_INDEX_BY_NAME.get(charSequence);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public static int getIndexInsensitive(CharSequence charSequence, CharSequence charSequence2) {
        HpackHeaderField entry;
        int index = getIndex(charSequence);
        if (index == -1) {
            return -1;
        }
        if (HpackUtil.equalsVariableTime(charSequence2, getEntry(index).value)) {
            return index;
        }
        do {
            index++;
            if (index > MAX_SAME_NAME_FIELD_INDEX) {
                return -1;
            }
            entry = getEntry(index);
            if (!HpackUtil.equalsVariableTime(charSequence, entry.name)) {
                return -1;
            }
        } while (!HpackUtil.equalsVariableTime(charSequence2, entry.value));
        return index;
    }

    private static int maxSameNameFieldIndex() {
        int size = STATIC_TABLE.size();
        HpackHeaderField entry = getEntry(size);
        int i = size - 1;
        while (i > 0) {
            HpackHeaderField entry2 = getEntry(i);
            if (HpackUtil.equalsVariableTime(entry2.name, entry.name)) {
                return i + 1;
            }
            i--;
            entry = entry2;
        }
        return size;
    }

    private static HpackHeaderField newEmptyHeaderField(String str) {
        return new HpackHeaderField(AsciiString.cached(str), AsciiString.EMPTY_STRING);
    }

    private static HpackHeaderField newHeaderField(String str, String str2) {
        return new HpackHeaderField(AsciiString.cached(str), AsciiString.cached(str2));
    }
}
