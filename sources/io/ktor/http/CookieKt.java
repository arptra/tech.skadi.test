package io.ktor.http;

import com.here.posclient.UpdateOptions;
import com.honey.account.constant.AccountConstantKt;
import io.ktor.util.Base64Kt;
import io.ktor.util.TextKt;
import io.ktor.util.date.GMTDate;
import io.netty.util.internal.StringUtil;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a+\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001a\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u001d\u0010\u0010\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001d\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0011\u001a\u0013\u0010\u0015\u001a\u00020\u0005*\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0013\u0010\u0018\u001a\u00020\u0017*\u00020\u0000H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\"\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00000\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001b\"\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001e\"\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001b¨\u0006!"}, d2 = {"", "cookiesHeader", "Lio/ktor/http/Cookie;", "e", "(Ljava/lang/String;)Lio/ktor/http/Cookie;", "", "skipEscaped", "", "c", "(Ljava/lang/String;Z)Ljava/util/Map;", "cookie", "f", "(Lio/ktor/http/Cookie;)Ljava/lang/String;", "value", "Lio/ktor/http/CookieEncoding;", "encoding", "b", "(Ljava/lang/String;Lio/ktor/http/CookieEncoding;)Ljava/lang/String;", "encodedValue", "a", "", "g", "(C)Z", "", "h", "(Ljava/lang/String;)I", "", "Ljava/util/Set;", "loweredPartNames", "Lkotlin/text/Regex;", "Lkotlin/text/Regex;", "clientCookieHeaderPattern", "cookieCharsShouldBeEscaped", "ktor-http"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCookie.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cookie.kt\nio/ktor/http/CookieKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,228:1\n213#1:245\n217#1:246\n217#1:247\n213#1:248\n213#1:249\n221#1:250\n221#1:251\n225#1:255\n221#1:256\n213#1:257\n225#1:259\n221#1:260\n213#1:261\n221#1:271\n213#1:272\n223#2,2:229\n1238#2,4:234\n766#2:262\n857#2,2:263\n1#3:231\n457#4:232\n403#4:233\n467#4,7:238\n125#5:252\n152#5,2:253\n154#5:258\n1083#6,2:265\n1083#6,2:267\n1083#6,2:269\n*S KotlinDebug\n*F\n+ 1 Cookie.kt\nio/ktor/http/CookieKt\n*L\n152#1:245\n153#1:246\n154#1:247\n155#1:248\n156#1:249\n158#1:250\n159#1:251\n160#1:255\n160#1:256\n160#1:257\n161#1:259\n161#1:260\n161#1:261\n225#1:271\n225#1:272\n72#1:229,2\n74#1:234,4\n162#1:262\n162#1:263,2\n74#1:232\n74#1:233\n86#1:238,7\n160#1:252\n160#1:253,2\n160#1:258\n170#1:265,2\n182#1:267,2\n203#1:269,2\n*E\n"})
public final class CookieKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Set f8955a = SetsKt.setOf("max-age", "expires", "domain", "path", "secure", "httponly", "$x-enc");
    public static final Regex b = new Regex("(^|;)\\s*([^;=\\{\\}\\s]+)\\s*(=\\s*(\"[^\"]*\"|[^;]*))?");
    public static final Set c = SetsKt.setOf(';', Character.valueOf(StringUtil.COMMA), '\"');

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                io.ktor.http.CookieEncoding[] r0 = io.ktor.http.CookieEncoding.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                io.ktor.http.CookieEncoding r1 = io.ktor.http.CookieEncoding.RAW     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                io.ktor.http.CookieEncoding r1 = io.ktor.http.CookieEncoding.DQUOTES     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                io.ktor.http.CookieEncoding r1 = io.ktor.http.CookieEncoding.BASE64_ENCODING     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                io.ktor.http.CookieEncoding r1 = io.ktor.http.CookieEncoding.URI_ENCODING     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.CookieKt.WhenMappings.<clinit>():void");
        }
    }

    public static final String a(String str, CookieEncoding cookieEncoding) {
        Intrinsics.checkNotNullParameter(str, "encodedValue");
        Intrinsics.checkNotNullParameter(cookieEncoding, "encoding");
        int i = WhenMappings.$EnumSwitchMapping$0[cookieEncoding.ordinal()];
        if (i == 1 || i == 2) {
            return (!StringsKt.startsWith$default(StringsKt.trimStart((CharSequence) str).toString(), "\"", false, 2, (Object) null) || !StringsKt.endsWith$default(StringsKt.trimEnd((CharSequence) str).toString(), "\"", false, 2, (Object) null)) ? str : StringsKt.removeSurrounding(StringsKt.trim((CharSequence) str).toString(), (CharSequence) "\"");
        }
        if (i == 3) {
            return Base64Kt.d(str);
        }
        if (i == 4) {
            return CodecsKt.k(str, 0, 0, true, (Charset) null, 11, (Object) null);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String b(String str, CookieEncoding cookieEncoding) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        Intrinsics.checkNotNullParameter(cookieEncoding, "encoding");
        int i = WhenMappings.$EnumSwitchMapping$0[cookieEncoding.ordinal()];
        int i2 = 0;
        if (i == 1) {
            while (i2 < str.length()) {
                if (!g(str.charAt(i2))) {
                    i2++;
                } else {
                    throw new IllegalArgumentException("The cookie value contains characters that cannot be encoded in RAW format.  Consider URL_ENCODING mode");
                }
            }
            return str;
        } else if (i != 2) {
            if (i == 3) {
                return Base64Kt.f(str);
            }
            if (i == 4) {
                return CodecsKt.l(str, true);
            }
            throw new NoWhenBranchMatchedException();
        } else if (!StringsKt.contains$default((CharSequence) str, '\"', false, 2, (Object) null)) {
            while (i2 < str.length()) {
                if (g(str.charAt(i2))) {
                    return '\"' + str + '\"';
                }
                i2++;
            }
            return str;
        } else {
            throw new IllegalArgumentException("The cookie value contains characters that cannot be encoded in DQUOTES format. Consider URL_ENCODING mode");
        }
    }

    public static final Map c(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "cookiesHeader");
        return MapsKt.toMap(SequencesKt.map(SequencesKt.filter(SequencesKt.map(Regex.findAll$default(b, str, 0, 2, (Object) null), CookieKt$parseClientCookiesHeader$1.INSTANCE), new CookieKt$parseClientCookiesHeader$2(z)), CookieKt$parseClientCookiesHeader$3.INSTANCE));
    }

    public static /* synthetic */ Map d(String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return c(str, z);
    }

    public static final Cookie e(String str) {
        CookieEncoding cookieEncoding;
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "cookiesHeader");
        int i = 0;
        Map c2 = c(str2, false);
        for (Map.Entry entry : c2.entrySet()) {
            GMTDate gMTDate = null;
            if (!StringsKt.startsWith$default((String) entry.getKey(), "$", false, 2, (Object) null)) {
                String str3 = (String) c2.get("$x-enc");
                if (str3 == null || (cookieEncoding = CookieEncoding.valueOf(str3)) == null) {
                    cookieEncoding = CookieEncoding.RAW;
                }
                CookieEncoding cookieEncoding2 = cookieEncoding;
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(c2.size()));
                for (Map.Entry entry2 : c2.entrySet()) {
                    linkedHashMap.put(TextKt.c((String) entry2.getKey()), entry2.getValue());
                }
                String str4 = (String) entry.getKey();
                String a2 = a((String) entry.getValue(), cookieEncoding2);
                String str5 = (String) linkedHashMap.get("max-age");
                if (str5 != null) {
                    i = h(str5);
                }
                int i2 = i;
                String str6 = (String) linkedHashMap.get("expires");
                if (str6 != null) {
                    gMTDate = DateUtilsKt.a(str6);
                }
                GMTDate gMTDate2 = gMTDate;
                String str7 = (String) linkedHashMap.get("domain");
                String str8 = (String) linkedHashMap.get("path");
                boolean containsKey = linkedHashMap.containsKey("secure");
                boolean containsKey2 = linkedHashMap.containsKey("httponly");
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry entry3 : c2.entrySet()) {
                    String str9 = (String) entry3.getKey();
                    if (!f8955a.contains(TextKt.c(str9)) && !Intrinsics.areEqual((Object) str9, entry.getKey())) {
                        linkedHashMap2.put(entry3.getKey(), entry3.getValue());
                    }
                }
                return new Cookie(str4, a2, cookieEncoding2, i2, gMTDate2, str7, str8, containsKey, containsKey2, linkedHashMap2);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static final String f(Cookie cookie) {
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        return cookie.f() + '=' + b(cookie.i(), cookie.d());
    }

    public static final boolean g(char c2) {
        return CharsKt.isWhitespace(c2) || Intrinsics.compare((int) c2, 32) < 0 || c.contains(Character.valueOf(c2));
    }

    public static final int h(String str) {
        return (int) RangesKt.coerceIn(Long.parseLong(str), 0, (long) UpdateOptions.SOURCE_ANY);
    }
}
