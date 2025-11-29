package com.upuphone.ar.tici.phone.db.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ar/tici/phone/db/entity/TiciContentPart;", "", "index", "", "a", "(Lcom/upuphone/ar/tici/phone/db/entity/TiciContentPart;I)Z", "ar-tici_release"}, k = 2, mv = {1, 9, 0})
public final class TiciContentPartKt {
    public static final boolean a(TiciContentPart ticiContentPart, int i) {
        Intrinsics.checkNotNullParameter(ticiContentPart, "<this>");
        return i + 1 >= ticiContentPart.getParagraphIndexes().size();
    }
}
