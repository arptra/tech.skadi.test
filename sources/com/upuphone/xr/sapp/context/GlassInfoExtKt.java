package com.upuphone.xr.sapp.context;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\u001a\u0015\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0019\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001d\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\u000b\u0010\b\"\u0015\u0010\u0010\u001a\u00020\r*\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0015\u0010\u0012\u001a\u00020\r*\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f\"\u0015\u0010\u0014\u001a\u00020\r*\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000f\"\u0015\u0010\u0016\u001a\u00020\r*\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000f\"\u0015\u0010\u0018\u001a\u00020\r*\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000f\"\u0015\u0010\u001a\u001a\u00020\u0000*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0003\"\u0015\u0010\u001c\u001a\u00020\u0000*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0003¨\u0006\u001d"}, d2 = {"", "romVersion", "b", "(Ljava/lang/String;)Ljava/lang/String;", "a", "other", "", "j", "(Ljava/lang/String;Ljava/lang/String;)I", "version", "version2", "k", "Lcom/upuphone/xr/sapp/context/IGlassInfo;", "", "i", "(Lcom/upuphone/xr/sapp/context/IGlassInfo;)Z", "isStar", "f", "isAirInternal", "g", "isAirIntl", "h", "isAirPro", "e", "isAirImiki", "d", "formatRomVersion", "c", "first3DotPart", "lib_context_release"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlassInfoExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassInfoExt.kt\ncom/upuphone/xr/sapp/context/GlassInfoExtKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,126:1\n1603#2,9:127\n1855#2:136\n1856#2:139\n1612#2:140\n1#3:137\n1#3:138\n1174#4,2:141\n*S KotlinDebug\n*F\n+ 1 GlassInfoExt.kt\ncom/upuphone/xr/sapp/context/GlassInfoExtKt\n*L\n64#1:127,9\n64#1:136\n64#1:139\n64#1:140\n64#1:138\n74#1:141,2\n*E\n"})
public final class GlassInfoExtKt {
    public static final String a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public static final String b(String str) {
        Intrinsics.checkNotNullParameter(str, "romVersion");
        List<String> split$default = StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null);
        if (split$default.size() > 4) {
            split$default = split$default.subList(0, 4);
        }
        ArrayList arrayList = new ArrayList();
        for (String a2 : split$default) {
            String a3 = a(a2);
            if (a3.length() == 0) {
                a3 = null;
            }
            if (a3 != null) {
                arrayList.add(a3);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, ".", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public static final String c(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        List split$default = StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null);
        if (split$default.size() > 3) {
            split$default = split$default.subList(0, 3);
        }
        return CollectionsKt.joinToString$default(split$default, ".", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public static final String d(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return b(str);
    }

    public static final boolean e(IGlassInfo iGlassInfo) {
        Intrinsics.checkNotNullParameter(iGlassInfo, "<this>");
        return StringsKt.equals("Air_imiki", iGlassInfo.getModel(), true);
    }

    public static final boolean f(IGlassInfo iGlassInfo) {
        Intrinsics.checkNotNullParameter(iGlassInfo, "<this>");
        return StringsKt.equals("Star Air", iGlassInfo.getModel(), true);
    }

    public static final boolean g(IGlassInfo iGlassInfo) {
        Intrinsics.checkNotNullParameter(iGlassInfo, "<this>");
        return StringsKt.equals("Star Air intl", iGlassInfo.getModel(), true);
    }

    public static final boolean h(IGlassInfo iGlassInfo) {
        Intrinsics.checkNotNullParameter(iGlassInfo, "<this>");
        return StringsKt.equals("Air Pro", iGlassInfo.getModel(), true);
    }

    public static final boolean i(IGlassInfo iGlassInfo) {
        Intrinsics.checkNotNullParameter(iGlassInfo, "<this>");
        return StringsKt.equals("Star", iGlassInfo.getModel(), true);
    }

    public static final int j(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "other");
        return k(str, str2);
    }

    public static final int k(String str, String str2) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(str, "version");
        Intrinsics.checkNotNullParameter(str2, "version2");
        if (Intrinsics.areEqual((Object) str, (Object) str2)) {
            return 0;
        }
        int i3 = 0;
        int i4 = 0;
        do {
            if (i3 >= str.length() && i4 >= str2.length()) {
                return 0;
            }
            i = 0;
            while (i3 < str.length() && str.charAt(i3) != '.') {
                int i5 = i * 10;
                Integer digitToIntOrNull = CharsKt.digitToIntOrNull(str.charAt(i3));
                i = i5 + (digitToIntOrNull != null ? digitToIntOrNull.intValue() : 0);
                i3++;
            }
            i3++;
            i2 = 0;
            while (i4 < str2.length() && str2.charAt(i4) != '.') {
                int i6 = i2 * 10;
                Integer digitToIntOrNull2 = CharsKt.digitToIntOrNull(str2.charAt(i4));
                i2 = i6 + (digitToIntOrNull2 != null ? digitToIntOrNull2.intValue() : 0);
                i4++;
            }
            i4++;
        } while (i == i2);
        return Intrinsics.compare(i, i2);
    }
}
