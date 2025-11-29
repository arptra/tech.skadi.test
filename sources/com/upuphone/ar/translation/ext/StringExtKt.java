package com.upuphone.ar.translation.ext;

import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0011\u0010\u0003\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0002\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0002\u001a\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\t\u001a\u00020\b*\u00020\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", "a", "(Ljava/lang/String;)Ljava/lang/String;", "c", "d", "", "e", "(Ljava/lang/String;)Ljava/util/List;", "", "b", "(Ljava/lang/String;)Z", "ar-translator_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class StringExtKt {
    public static final String a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt.isBlank(str)) {
            return str;
        }
        String obj = StringsKt.trim((CharSequence) str).toString();
        char charAt = obj.charAt(0);
        if (('a' > charAt || charAt >= '{') && ('A' > charAt || charAt >= '[')) {
            return obj;
        }
        if ('A' <= charAt && charAt < '[') {
            return obj;
        }
        String valueOf = String.valueOf(charAt);
        String upperCase = valueOf.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        LogExt.g("firstLetterUppercase old=" + valueOf + ", new=" + upperCase, "StringExt");
        return StringsKt.replaceFirst$default(obj, valueOf, upperCase, false, 4, (Object) null);
    }

    public static final boolean b(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        char[] charArray = str.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        return Bidi.requiresBidi(charArray, 0, str.length());
    }

    public static final String c(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new Regex("\\s+").replace((CharSequence) str, "");
    }

    public static final String d(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new Regex("[/\\\\]+").replace((CharSequence) str, "");
    }

    public static final List e(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt.isBlank(str)) {
            return new ArrayList();
        }
        return new Regex("\\s+").split(StringsKt.trim((CharSequence) str).toString(), 0);
    }
}
