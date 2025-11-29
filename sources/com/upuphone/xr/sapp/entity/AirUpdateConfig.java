package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import com.upuphone.star.fota.phone.GlassUpdateInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/upuphone/xr/sapp/entity/AirUpdateConfig;", "", "glassUpdateInfo", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "existUpdate", "", "romMd5", "", "info", "", "Lcom/upuphone/xr/sapp/entity/AirUpdateFileInfo;", "(Lcom/upuphone/star/fota/phone/GlassUpdateInfo;ZLjava/lang/String;Ljava/util/List;)V", "getExistUpdate", "()Z", "getGlassUpdateInfo", "()Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "getInfo", "()Ljava/util/List;", "getRomMd5", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AirUpdateConfig {
    private final boolean existUpdate;
    @NotNull
    private final GlassUpdateInfo glassUpdateInfo;
    @NotNull
    private final List<AirUpdateFileInfo> info;
    @Nullable
    private final String romMd5;

    public AirUpdateConfig(@NotNull GlassUpdateInfo glassUpdateInfo2, boolean z, @Nullable String str, @NotNull List<AirUpdateFileInfo> list) {
        Intrinsics.checkNotNullParameter(glassUpdateInfo2, "glassUpdateInfo");
        Intrinsics.checkNotNullParameter(list, "info");
        this.glassUpdateInfo = glassUpdateInfo2;
        this.existUpdate = z;
        this.romMd5 = str;
        this.info = list;
    }

    public static /* synthetic */ AirUpdateConfig copy$default(AirUpdateConfig airUpdateConfig, GlassUpdateInfo glassUpdateInfo2, boolean z, String str, List<AirUpdateFileInfo> list, int i, Object obj) {
        if ((i & 1) != 0) {
            glassUpdateInfo2 = airUpdateConfig.glassUpdateInfo;
        }
        if ((i & 2) != 0) {
            z = airUpdateConfig.existUpdate;
        }
        if ((i & 4) != 0) {
            str = airUpdateConfig.romMd5;
        }
        if ((i & 8) != 0) {
            list = airUpdateConfig.info;
        }
        return airUpdateConfig.copy(glassUpdateInfo2, z, str, list);
    }

    @NotNull
    public final GlassUpdateInfo component1() {
        return this.glassUpdateInfo;
    }

    public final boolean component2() {
        return this.existUpdate;
    }

    @Nullable
    public final String component3() {
        return this.romMd5;
    }

    @NotNull
    public final List<AirUpdateFileInfo> component4() {
        return this.info;
    }

    @NotNull
    public final AirUpdateConfig copy(@NotNull GlassUpdateInfo glassUpdateInfo2, boolean z, @Nullable String str, @NotNull List<AirUpdateFileInfo> list) {
        Intrinsics.checkNotNullParameter(glassUpdateInfo2, "glassUpdateInfo");
        Intrinsics.checkNotNullParameter(list, "info");
        return new AirUpdateConfig(glassUpdateInfo2, z, str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AirUpdateConfig)) {
            return false;
        }
        AirUpdateConfig airUpdateConfig = (AirUpdateConfig) obj;
        return Intrinsics.areEqual((Object) this.glassUpdateInfo, (Object) airUpdateConfig.glassUpdateInfo) && this.existUpdate == airUpdateConfig.existUpdate && Intrinsics.areEqual((Object) this.romMd5, (Object) airUpdateConfig.romMd5) && Intrinsics.areEqual((Object) this.info, (Object) airUpdateConfig.info);
    }

    public final boolean getExistUpdate() {
        return this.existUpdate;
    }

    @NotNull
    public final GlassUpdateInfo getGlassUpdateInfo() {
        return this.glassUpdateInfo;
    }

    @NotNull
    public final List<AirUpdateFileInfo> getInfo() {
        return this.info;
    }

    @Nullable
    public final String getRomMd5() {
        return this.romMd5;
    }

    public int hashCode() {
        int hashCode = ((this.glassUpdateInfo.hashCode() * 31) + Boolean.hashCode(this.existUpdate)) * 31;
        String str = this.romMd5;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.info.hashCode();
    }

    @NotNull
    public String toString() {
        GlassUpdateInfo glassUpdateInfo2 = this.glassUpdateInfo;
        boolean z = this.existUpdate;
        String str = this.romMd5;
        List<AirUpdateFileInfo> list = this.info;
        return "AirUpdateConfig(glassUpdateInfo=" + glassUpdateInfo2 + ", existUpdate=" + z + ", romMd5=" + str + ", info=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AirUpdateConfig(GlassUpdateInfo glassUpdateInfo2, boolean z, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(glassUpdateInfo2, z, (i & 4) != 0 ? null : str, list);
    }
}
