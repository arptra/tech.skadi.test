package com.upuphone.xr.sapp.unicron;

import androidx.annotation.Keep;
import com.upuphone.star.fota.phone.GlassUpdateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/upuphone/xr/sapp/unicron/UnicronUpdateConfig;", "", "filePath", "", "updateInfo", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "(Ljava/lang/String;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;)V", "getFilePath", "()Ljava/lang/String;", "getUpdateInfo", "()Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class UnicronUpdateConfig {
    @NotNull
    private final String filePath;
    @NotNull
    private final GlassUpdateInfo updateInfo;

    public UnicronUpdateConfig(@NotNull String str, @NotNull GlassUpdateInfo glassUpdateInfo) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        Intrinsics.checkNotNullParameter(glassUpdateInfo, "updateInfo");
        this.filePath = str;
        this.updateInfo = glassUpdateInfo;
    }

    public static /* synthetic */ UnicronUpdateConfig copy$default(UnicronUpdateConfig unicronUpdateConfig, String str, GlassUpdateInfo glassUpdateInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = unicronUpdateConfig.filePath;
        }
        if ((i & 2) != 0) {
            glassUpdateInfo = unicronUpdateConfig.updateInfo;
        }
        return unicronUpdateConfig.copy(str, glassUpdateInfo);
    }

    @NotNull
    public final String component1() {
        return this.filePath;
    }

    @NotNull
    public final GlassUpdateInfo component2() {
        return this.updateInfo;
    }

    @NotNull
    public final UnicronUpdateConfig copy(@NotNull String str, @NotNull GlassUpdateInfo glassUpdateInfo) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        Intrinsics.checkNotNullParameter(glassUpdateInfo, "updateInfo");
        return new UnicronUpdateConfig(str, glassUpdateInfo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnicronUpdateConfig)) {
            return false;
        }
        UnicronUpdateConfig unicronUpdateConfig = (UnicronUpdateConfig) obj;
        return Intrinsics.areEqual((Object) this.filePath, (Object) unicronUpdateConfig.filePath) && Intrinsics.areEqual((Object) this.updateInfo, (Object) unicronUpdateConfig.updateInfo);
    }

    @NotNull
    public final String getFilePath() {
        return this.filePath;
    }

    @NotNull
    public final GlassUpdateInfo getUpdateInfo() {
        return this.updateInfo;
    }

    public int hashCode() {
        return (this.filePath.hashCode() * 31) + this.updateInfo.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.filePath;
        GlassUpdateInfo glassUpdateInfo = this.updateInfo;
        return "UnicronUpdateConfig(filePath=" + str + ", updateInfo=" + glassUpdateInfo + ")";
    }
}
