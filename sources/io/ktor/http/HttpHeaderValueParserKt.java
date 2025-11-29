package io.ktor.http;

import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a+\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\n*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\r\u001a#\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001aE\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u001c\u0010\u0015\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0013j\b\u0012\u0004\u0012\u00020\u0003`\u00140\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a=\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u001c\u0010\u0019\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00180\u0013j\b\u0012\u0004\u0012\u00020\u0018`\u00140\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a+\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00000\u001d2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a+\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00000\u001d2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b \u0010\u001f\u001a\u001b\u0010!\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"", "text", "", "Lio/ktor/http/HeaderValue;", "b", "(Ljava/lang/String;)Ljava/util/List;", "", "parametersOnly", "c", "(Ljava/lang/String;Z)Ljava/util/List;", "T", "Lkotlin/Lazy;", "j", "(Lkotlin/Lazy;)Ljava/util/List;", "", "start", "end", "i", "(Ljava/lang/String;II)Ljava/lang/String;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "items", "d", "(Ljava/lang/String;ILkotlin/Lazy;Z)I", "Lio/ktor/http/HeaderValueParam;", "parameters", "e", "(Ljava/lang/String;ILkotlin/Lazy;)I", "value", "Lkotlin/Pair;", "g", "(Ljava/lang/String;I)Lkotlin/Pair;", "h", "a", "(Ljava/lang/String;I)Z", "ktor-http"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHttpHeaderValueParser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpHeaderValueParser.kt\nio/ktor/http/HttpHeaderValueParserKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,224:1\n1054#2:225\n1549#2:226\n1620#2,3:227\n*S KotlinDebug\n*F\n+ 1 HttpHeaderValueParser.kt\nio/ktor/http/HttpHeaderValueParserKt\n*L\n49#1:225\n96#1:226\n96#1:227,3\n*E\n"})
public final class HttpHeaderValueParserKt {
    public static final boolean a(String str, int i) {
        int i2 = i + 1;
        while (i2 < str.length() && str.charAt(i2) == ' ') {
            i2++;
        }
        return i2 == str.length() || str.charAt(i2) == ';';
    }

    public static final List b(String str) {
        return c(str, false);
    }

    public static final List c(String str, boolean z) {
        if (str == null) {
            return CollectionsKt.emptyList();
        }
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, HttpHeaderValueParserKt$parseHeaderValue$items$1.INSTANCE);
        int i = 0;
        while (i <= StringsKt.getLastIndex(str)) {
            i = d(str, i, lazy, z);
        }
        return j(lazy);
    }

    public static final int d(String str, int i, Lazy lazy, boolean z) {
        Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1.INSTANCE);
        Integer valueOf = z ? Integer.valueOf(i) : null;
        int i2 = i;
        while (i2 <= StringsKt.getLastIndex(str)) {
            char charAt = str.charAt(i2);
            if (charAt == ',') {
                ((ArrayList) lazy.getValue()).add(new HeaderValue(i(str, i, valueOf != null ? valueOf.intValue() : i2), j(lazy2)));
                return i2 + 1;
            } else if (charAt == ';') {
                if (valueOf == null) {
                    valueOf = Integer.valueOf(i2);
                }
                i2 = e(str, i2 + 1, lazy2);
            } else {
                i2 = z ? e(str, i2, lazy2) : i2 + 1;
            }
        }
        ((ArrayList) lazy.getValue()).add(new HeaderValue(i(str, i, valueOf != null ? valueOf.intValue() : i2), j(lazy2)));
        return i2;
    }

    public static final int e(String str, int i, Lazy lazy) {
        int i2 = i;
        while (i2 <= StringsKt.getLastIndex(str)) {
            char charAt = str.charAt(i2);
            if (charAt == '=') {
                Pair g = g(str, i2 + 1);
                int intValue = ((Number) g.component1()).intValue();
                f(lazy, str, i, i2, (String) g.component2());
                return intValue;
            } else if (charAt == ';' || charAt == ',') {
                f(lazy, str, i, i2, "");
                return i2;
            } else {
                i2++;
            }
        }
        f(lazy, str, i, i2, "");
        return i2;
    }

    public static final void f(Lazy lazy, String str, int i, int i2, String str2) {
        String i3 = i(str, i, i2);
        if (i3.length() != 0) {
            ((ArrayList) lazy.getValue()).add(new HeaderValueParam(i3, str2));
        }
    }

    public static final Pair g(String str, int i) {
        if (str.length() == i) {
            return TuplesKt.to(Integer.valueOf(i), "");
        }
        if (str.charAt(i) == '\"') {
            return h(str, i + 1);
        }
        int i2 = i;
        while (i2 <= StringsKt.getLastIndex(str)) {
            char charAt = str.charAt(i2);
            if (charAt == ';' || charAt == ',') {
                return TuplesKt.to(Integer.valueOf(i2), i(str, i, i2));
            }
            i2++;
        }
        return TuplesKt.to(Integer.valueOf(i2), i(str, i, i2));
    }

    public static final Pair h(String str, int i) {
        StringBuilder sb = new StringBuilder();
        while (i <= StringsKt.getLastIndex(str)) {
            char charAt = str.charAt(i);
            if (charAt == '\"' && a(str, i)) {
                Integer valueOf = Integer.valueOf(i + 1);
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
                return TuplesKt.to(valueOf, sb2);
            } else if (charAt != '\\' || i >= StringsKt.getLastIndex(str) - 2) {
                sb.append(charAt);
                i++;
            } else {
                sb.append(str.charAt(i + 1));
                i += 2;
            }
        }
        Integer valueOf2 = Integer.valueOf(i);
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "builder.toString()");
        return TuplesKt.to(valueOf2, '\"' + sb3);
    }

    public static final String i(String str, int i, int i2) {
        String substring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return StringsKt.trim((CharSequence) substring).toString();
    }

    public static final List j(Lazy lazy) {
        return lazy.isInitialized() ? (List) lazy.getValue() : CollectionsKt.emptyList();
    }
}
