package com.upuphone.xr.sapp.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\"!\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0004¨\u0006\u0005"}, d2 = {"isSuccess", "", "T", "Lcom/upuphone/xr/sapp/entity/BasicResponse;", "(Lcom/upuphone/xr/sapp/entity/BasicResponse;)Z", "app_intlRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class BasicResponseKt {
    public static final <T> boolean isSuccess(@NotNull BasicResponse<T> basicResponse) {
        Intrinsics.checkNotNullParameter(basicResponse, "<this>");
        return basicResponse.getCode() == 0;
    }
}
