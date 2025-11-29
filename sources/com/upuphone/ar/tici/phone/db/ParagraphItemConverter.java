package com.upuphone.ar.tici.phone.db;

import com.upuphone.ar.tici.phone.utils.JsonUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/upuphone/ar/tici/phone/db/ParagraphItemConverter;", "", "<init>", "()V", "", "Lcom/upuphone/ar/tici/phone/starrynet/msg/ParagraphItem;", "list", "", "b", "(Ljava/util/List;)Ljava/lang/String;", "json", "a", "(Ljava/lang/String;)Ljava/util/List;", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nParagraphItemConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ParagraphItemConverter.kt\ncom/upuphone/ar/tici/phone/db/ParagraphItemConverter\n+ 2 JsonUtils.kt\ncom/upuphone/ar/tici/phone/utils/JsonUtils\n*L\n1#1,24:1\n59#2,2:25\n*S KotlinDebug\n*F\n+ 1 ParagraphItemConverter.kt\ncom/upuphone/ar/tici/phone/db/ParagraphItemConverter\n*L\n22#1:25,2\n*E\n"})
public final class ParagraphItemConverter {
    public final List a(String str) {
        List list = (List) JsonUtils.f5992a.b().fromJson(str, new ParagraphItemConverter$jsonToList$$inlined$fromJsonList$1().getType());
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final String b(List list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return JsonUtils.f5992a.c(list);
    }
}
