package com.upuphone.xr.sapp.entity;

import com.upuphone.xr.sapp.context.GlassInfoExtKt;
import com.upuphone.xr.sapp.glass.SimpleGlassInfo;
import com.upuphone.xr.sapp.utils.StringExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004\"\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004\"\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"formatRomVersion", "", "Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;", "getFormatRomVersion", "(Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;)Ljava/lang/String;", "safeBuildType", "getSafeBuildType", "safeDisplayName", "getSafeDisplayName", "safeSubModel", "getSafeSubModel", "safeVersionType", "getSafeVersionType", "toSimpleGlassInfo", "Lcom/upuphone/xr/sapp/glass/SimpleGlassInfo;", "getToSimpleGlassInfo", "(Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;)Lcom/upuphone/xr/sapp/glass/SimpleGlassInfo;", "app_intlRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class BasicGlassInfoKt {
    @NotNull
    public static final String getFormatRomVersion(@NotNull BasicGlassInfo basicGlassInfo) {
        Intrinsics.checkNotNullParameter(basicGlassInfo, "<this>");
        return GlassInfoExtKt.b(basicGlassInfo.getRomVersion());
    }

    @NotNull
    public static final String getSafeBuildType(@NotNull BasicGlassInfo basicGlassInfo) {
        Intrinsics.checkNotNullParameter(basicGlassInfo, "<this>");
        return StringExtKt.b(basicGlassInfo.getBuildType(), BasicGlassInfoKt$safeBuildType$1.INSTANCE);
    }

    @NotNull
    public static final String getSafeDisplayName(@NotNull BasicGlassInfo basicGlassInfo) {
        Intrinsics.checkNotNullParameter(basicGlassInfo, "<this>");
        String displayName = basicGlassInfo.getDisplayName();
        return displayName == null ? "" : displayName;
    }

    @NotNull
    public static final String getSafeSubModel(@NotNull BasicGlassInfo basicGlassInfo) {
        Intrinsics.checkNotNullParameter(basicGlassInfo, "<this>");
        return StringExtKt.b(basicGlassInfo.getSubModel(), BasicGlassInfoKt$safeSubModel$1.INSTANCE);
    }

    @NotNull
    public static final String getSafeVersionType(@NotNull BasicGlassInfo basicGlassInfo) {
        Intrinsics.checkNotNullParameter(basicGlassInfo, "<this>");
        return "release";
    }

    @NotNull
    public static final SimpleGlassInfo getToSimpleGlassInfo(@NotNull BasicGlassInfo basicGlassInfo) {
        Intrinsics.checkNotNullParameter(basicGlassInfo, "<this>");
        return new SimpleGlassInfo(basicGlassInfo.getModel(), basicGlassInfo.getRomVersion());
    }
}
