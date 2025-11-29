package com.upuphone.xr.sapp.entity;

import com.upuphone.star.fota.phone.GlassCheckUpdateResult;
import com.upuphone.xr.sapp.entity.GlassCheckUpdateState;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007*\u00020\n\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"ERROR_CODE_FAIL_TO_GET_GLASS_INFO", "", "ERROR_CODE_GLASS_NOT_CONNECTED", "ERROR_CODE_NETWORK_ERROR", "ERROR_CODE_NO_NETWORK", "ERROR_CODE_SERVER_ERROR", "getResultOrNull", "Lkotlin/Pair;", "Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;", "Lcom/upuphone/star/fota/phone/GlassCheckUpdateResult;", "Lcom/upuphone/xr/sapp/entity/GlassCheckUpdateState;", "app_intlRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class GlassCheckUpdateStateKt {
    public static final int ERROR_CODE_FAIL_TO_GET_GLASS_INFO = 3;
    public static final int ERROR_CODE_GLASS_NOT_CONNECTED = 2;
    public static final int ERROR_CODE_NETWORK_ERROR = 4;
    public static final int ERROR_CODE_NO_NETWORK = 1;
    public static final int ERROR_CODE_SERVER_ERROR = 5;

    @Nullable
    public static final Pair<BasicGlassInfo, GlassCheckUpdateResult> getResultOrNull(@NotNull GlassCheckUpdateState glassCheckUpdateState) {
        Intrinsics.checkNotNullParameter(glassCheckUpdateState, "<this>");
        if (glassCheckUpdateState instanceof GlassCheckUpdateState.Result) {
            return ((GlassCheckUpdateState.Result) glassCheckUpdateState).getPair();
        }
        return null;
    }
}
