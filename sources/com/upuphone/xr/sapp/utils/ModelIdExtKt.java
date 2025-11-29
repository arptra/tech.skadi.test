package com.upuphone.xr.sapp.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0003¨\u0006\u0007"}, d2 = {"", "", "b", "(Ljava/lang/String;)Z", "c", "d", "a", "lib_common_release"}, k = 2, mv = {1, 9, 0})
public final class ModelIdExtKt {
    public static final boolean a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return d(str) || b(str);
    }

    public static final boolean b(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Intrinsics.areEqual((Object) "1003", (Object) str) || Intrinsics.areEqual((Object) "5001", (Object) str);
    }

    public static final boolean c(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Intrinsics.areEqual((Object) "5001", (Object) str);
    }

    public static final boolean d(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Intrinsics.areEqual((Object) "5002", (Object) str) || Intrinsics.areEqual((Object) "1004", (Object) str);
    }
}
