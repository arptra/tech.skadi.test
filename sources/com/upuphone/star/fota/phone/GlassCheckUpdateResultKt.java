package com.upuphone.star.fota.phone;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/upuphone/star/fota/phone/GlassCheckUpdateResult;", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "b", "(Lcom/upuphone/star/fota/phone/GlassCheckUpdateResult;)Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "a", "ar-fota-lib_release"}, k = 2, mv = {1, 9, 0})
public final class GlassCheckUpdateResultKt {
    public static final GlassUpdateInfo a(GlassCheckUpdateResult glassCheckUpdateResult) {
        Intrinsics.checkNotNullParameter(glassCheckUpdateResult, "<this>");
        if (glassCheckUpdateResult.isSuccess()) {
            return glassCheckUpdateResult.getData();
        }
        return null;
    }

    public static final GlassUpdateInfo b(GlassCheckUpdateResult glassCheckUpdateResult) {
        Intrinsics.checkNotNullParameter(glassCheckUpdateResult, "<this>");
        GlassUpdateInfo data = glassCheckUpdateResult.getData();
        if (glassCheckUpdateResult.isSuccess() && data != null) {
            return data;
        }
        int code = glassCheckUpdateResult.getCode();
        String msg = glassCheckUpdateResult.getMsg();
        if (msg == null) {
            msg = GlassUpdateApiManager.f6471a.i();
        }
        throw new GlassUpdateException(code, msg);
    }
}
