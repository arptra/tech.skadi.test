package com.upuphone.ar.tici.phone.db.entity;

import com.upuphone.ar.tici.phone.data.TiciHistory;
import com.upuphone.ar.tici.phone.utils.ConstantsKt;
import com.upuphone.ar.tici.phone.utils.StringExtKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a1\u0010\u000e\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000e\u0010\u000f\"\u0015\u0010\u0012\u001a\u00020\u0006*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u0015\u0010\u0015\u001a\u00020\t*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u0016*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "Lcom/upuphone/ar/tici/phone/data/TiciHistory;", "f", "(Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;)Lcom/upuphone/ar/tici/phone/data/TiciHistory;", "", "page", "", "d", "(Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;I)Z", "", "fileName", "content", "fileType", "userId", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "c", "(Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;)Z", "isDefaultContent", "a", "(Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;)Ljava/lang/String;", "generateFileKey", "", "b", "(Ljava/lang/String;)Ljava/lang/Long;", "parseIdFromFileKey", "ar-tici_release"}, k = 2, mv = {1, 9, 0})
public final class TiciEntityKt {
    public static final String a(TiciEntity ticiEntity) {
        Intrinsics.checkNotNullParameter(ticiEntity, "<this>");
        long id = ticiEntity.getId();
        String fileName = ticiEntity.getFileName();
        return id + "/" + fileName;
    }

    public static final Long b(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.toLongOrNull(StringsKt.substringBefore$default(str, "/", (String) null, 2, (Object) null));
    }

    public static final boolean c(TiciEntity ticiEntity) {
        Intrinsics.checkNotNullParameter(ticiEntity, "<this>");
        return ticiEntity.getFileType() != null && ConstantsKt.i().contains(ticiEntity.getFileType().intValue());
    }

    public static final boolean d(TiciEntity ticiEntity, int i) {
        Intrinsics.checkNotNullParameter(ticiEntity, "<this>");
        return i == ticiEntity.getTotalPage() - 1;
    }

    public static final TiciEntity e(String str, String str2, Integer num, String str3) {
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(str4, "content");
        return new TiciEntity(0, str, StringExtKt.j(str4, 100), CollectionsKt.emptyList(), 0, (long) StringExtKt.a(str2), 0, System.currentTimeMillis(), num, 0, str3, 0, 1, str2.length());
    }

    public static final TiciHistory f(TiciEntity ticiEntity) {
        Intrinsics.checkNotNullParameter(ticiEntity, "<this>");
        return new TiciHistory(ticiEntity.getId(), ticiEntity.getFileName(), ticiEntity.getLastModified(), ticiEntity.getFileType(), ticiEntity.getFileSize(), ticiEntity.getTotalTextLength());
    }
}
