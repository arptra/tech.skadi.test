package com.upuphone.ar.tici.phone.data;

import com.upuphone.ar.tici.phone.utils.StringExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/SystemFileInfo;", "", "a", "(Lcom/upuphone/ar/tici/phone/data/SystemFileInfo;)Z", "isWordFile", "ar-tici_release"}, k = 2, mv = {1, 9, 0})
public final class SystemFileInfoKt {
    public static final boolean a(SystemFileInfo systemFileInfo) {
        Intrinsics.checkNotNullParameter(systemFileInfo, "<this>");
        return StringExtKt.i(systemFileInfo.getName());
    }
}
