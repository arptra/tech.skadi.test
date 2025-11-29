package com.upuphone.ar.tici.phone.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/TiciHistory;", "", "b", "(Lcom/upuphone/ar/tici/phone/data/TiciHistory;)Z", "isDefaultContent", "a", "canEdit", "ar-tici_release"}, k = 2, mv = {1, 9, 0})
public final class TiciHistoryKt {
    public static final boolean a(TiciHistory ticiHistory) {
        Intrinsics.checkNotNullParameter(ticiHistory, "<this>");
        return ticiHistory.getTotalTextLength() <= 60000;
    }

    public static final boolean b(TiciHistory ticiHistory) {
        Intrinsics.checkNotNullParameter(ticiHistory, "<this>");
        return ticiHistory.getFileType() != null && new IntRange(1, 6).contains(ticiHistory.getFileType().intValue());
    }
}
