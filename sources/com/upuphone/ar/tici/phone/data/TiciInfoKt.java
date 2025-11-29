package com.upuphone.ar.tici.phone.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\b\u001a\u00020\u0005*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/TiciInfo;", "", "b", "(Lcom/upuphone/ar/tici/phone/data/TiciInfo;)J", "id", "", "a", "(Lcom/upuphone/ar/tici/phone/data/TiciInfo;)Ljava/lang/String;", "fileName", "ar-tici_release"}, k = 2, mv = {1, 9, 0})
public final class TiciInfoKt {
    public static final String a(TiciInfo ticiInfo) {
        Intrinsics.checkNotNullParameter(ticiInfo, "<this>");
        return ticiInfo.getTiciEntity().getFileName();
    }

    public static final long b(TiciInfo ticiInfo) {
        Intrinsics.checkNotNullParameter(ticiInfo, "<this>");
        return ticiInfo.getTiciEntity().getId();
    }
}
