package com.upuphone.runasone.relay.lib.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u0004\u0018\u0001H\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003¢\u0006\u0002\u0010\u0004\u001a\u001f\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u0004\u0018\u0001H\u00012\u0006\u0010\u0005\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0006\u001a.\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u00010\b\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\t*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\t0\b¨\u0006\n"}, d2 = {"or", "T", "compute", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "default", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "reverseKV", "", "E", "relay-lib_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class KtExtensionKt {
    public static final <T> T or(@Nullable T t, T t2) {
        return t == null ? t2 : t;
    }

    @NotNull
    public static final <T, E> Map<E, T> reverseKV(@NotNull Map<T, ? extends E> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            linkedHashMap.put(next.getValue(), next.getKey());
        }
        return linkedHashMap;
    }

    public static final <T> T or(@Nullable T t, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "compute");
        return t == null ? function0.invoke() : t;
    }
}
