package com.upuphone.xr.sapp.utils;

import java.io.StringReader;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.StringUtils;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a!\u0010\u0003\u001a\u00020\u0000*\u0004\u0018\u00010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "Lkotlin/Function0;", "defaultValue", "b", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/String;", "a", "(Ljava/lang/String;)Ljava/lang/String;", "lib_common_release"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nStringExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringExt.kt\ncom/upuphone/xr/sapp/utils/StringExtKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,57:1\n1174#2,2:58\n*S KotlinDebug\n*F\n+ 1 StringExt.kt\ncom/upuphone/xr/sapp/utils/StringExtKt\n*L\n10#1:58,2\n*E\n"})
public final class StringExtKt {
    public static final String a(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        try {
            return CollectionsKt.joinToString$default(TextStreamsKt.readLines(new StringReader(str)), StringUtils.LF, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, StringExtKt$formatReleaseNote$1.INSTANCE, 30, (Object) null);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static final String b(String str, Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        return (str == null || str.length() == 0) ? (String) function0.invoke() : str;
    }
}
