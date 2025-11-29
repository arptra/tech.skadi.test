package com.upuphone.xr.interconnect.util.log;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001¨\u0006\u0004"}, d2 = {"stringify", "", "", "name", "Shared_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPrettyPrintExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PrettyPrintExt.kt\ncom/upuphone/xr/interconnect/util/log/PrettyPrintExtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,12:1\n1#2:13\n*E\n"})
public final class PrettyPrintExtKt {
    @NotNull
    public static final String stringify(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        String simpleName = obj.getClass().getSimpleName();
        if (StringsKt.isBlank(simpleName)) {
            simpleName = obj.toString();
        }
        Intrinsics.checkNotNullExpressionValue(simpleName, "this::class.java.simpleName.ifBlank { toString() }");
        return stringify(obj, simpleName);
    }

    @NotNull
    public static final String stringify(@NotNull Object obj, @NotNull String str) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('@');
        String num = Integer.toString(obj.hashCode(), CharsKt.checkRadix(36));
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        sb.append(num);
        return sb.toString();
    }
}
