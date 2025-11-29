package com.upuphone.ar.tici.phone.utils;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\b\u0004\u001a%\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "", "param", "a", "(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;", "ar-tici_release"}, k = 2, mv = {1, 9, 0})
public final class UrlExtKt {
    public static final String a(String str, Map map) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(map, "param");
        String joinToString$default = CollectionsKt.joinToString$default(map.entrySet(), "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, UrlExtKt$appendParam$subStr$1.INSTANCE, 30, (Object) null);
        return str + "?" + joinToString$default;
    }
}
