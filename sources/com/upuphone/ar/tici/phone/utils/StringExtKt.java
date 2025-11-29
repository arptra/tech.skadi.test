package com.upuphone.ar.tici.phone.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0018\u0010\n\u001a\u00020\u0000*\u00020\u00008@X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0018\u0010\f\u001a\u00020\u0000*\u00020\u00008@X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t\"\u0018\u0010\u000e\u001a\u00020\u0000*\u00020\u00008@X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\t\"\u0018\u0010\u0010\u001a\u00020\u0000*\u00020\u00008@X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\t\"\u0018\u0010\u0012\u001a\u00020\u0000*\u00020\u00008@X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\t\"\u0018\u0010\u0014\u001a\u00020\u0000*\u00020\u00008@X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\t\"\u0015\u0010\u0018\u001a\u00020\u0015*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u001a\u001a\u00020\u0000*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\t¨\u0006\u001b"}, d2 = {"", "", "size", "j", "(Ljava/lang/String;I)Ljava/lang/String;", "a", "(Ljava/lang/String;)I", "byteSize", "c", "(Ljava/lang/String;)Ljava/lang/String;", "deleteEmptyLines", "e", "formatTiciContent", "f", "formatTiciTitle", "h", "toSingleLine", "d", "deleteSpecialSymbols", "b", "deleteEmoji", "", "i", "(Ljava/lang/String;)Z", "isWordFile", "g", "removeSuffixName", "ar-tici_release"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nStringExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringExt.kt\ncom/upuphone/ar/tici/phone/utils/StringExtKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,83:1\n483#2,11:84\n*S KotlinDebug\n*F\n+ 1 StringExt.kt\ncom/upuphone/ar/tici/phone/utils/StringExtKt\n*L\n49#1:84,11\n*E\n"})
public final class StringExtKt {
    public static final int a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes.length;
    }

    public static final String b(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!CharExtKt.a(charAt)) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public static final String c(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new Regex("(?m)^[ \\t]*\\r?\\n").replace((CharSequence) str, "");
    }

    public static final String d(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new Regex("[\\\\/]").replace((CharSequence) str, "");
    }

    public static final String e(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return c(b(StringsKt.removePrefix(str, (CharSequence) "﻿")));
    }

    public static final String f(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return h(StringsKt.trim((CharSequence) c(d(b(StringsKt.removePrefix(str, (CharSequence) "﻿"))))).toString());
    }

    public static final String g(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, ".", 0, false, 6, (Object) null);
        if (lastIndexOf$default <= 0) {
            return str;
        }
        String substring = str.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static final String h(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new Regex("\\r?\\n").replace((CharSequence) str, "");
    }

    public static final boolean i(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.endsWith$default(str, ".doc", false, 2, (Object) null) || StringsKt.endsWith$default(str, ".docx", false, 2, (Object) null);
    }

    public static final String j(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() <= i) {
            return str;
        }
        String substring = str.substring(0, i);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }
}
