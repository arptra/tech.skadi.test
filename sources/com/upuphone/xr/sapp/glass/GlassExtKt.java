package com.upuphone.xr.sapp.glass;

import com.upuphone.star.fota.phone.GlassUpdateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "", "a", "(Lcom/upuphone/star/fota/phone/GlassUpdateInfo;)J", "requiredStorage", "app_intlRelease"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlassExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassExt.kt\ncom/upuphone/xr/sapp/glass/GlassExtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,10:1\n1#2:11\n*E\n"})
public final class GlassExtKt {
    public static final long a(GlassUpdateInfo glassUpdateInfo) {
        Intrinsics.checkNotNullParameter(glassUpdateInfo, "<this>");
        Long fileSize = glassUpdateInfo.getFileSize();
        if (fileSize != null) {
            return fileSize.longValue() * ((long) 2);
        }
        return 0;
    }
}
