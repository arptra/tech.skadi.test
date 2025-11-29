package com.upuphone.ar.tici.phone.data;

import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
import com.upuphone.ar.tici.phone.db.entity.TiciEntityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/DefaultTiciContent;", "", "userId", "Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "a", "(Lcom/upuphone/ar/tici/phone/data/DefaultTiciContent;Ljava/lang/String;)Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "ar-tici_release"}, k = 2, mv = {1, 9, 0})
public final class DefaultTiciContentKt {
    public static final TiciEntity a(DefaultTiciContent defaultTiciContent, String str) {
        Intrinsics.checkNotNullParameter(defaultTiciContent, "<this>");
        return TiciEntityKt.e(defaultTiciContent.getFileName(), defaultTiciContent.getContent(), Integer.valueOf(defaultTiciContent.getFileType()), str);
    }
}
