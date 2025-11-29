package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/sapp/entity/AirSilentUpdateInfo;", "", "existUpdate", "", "romMd5", "", "info", "", "Lcom/upuphone/xr/sapp/entity/AirUpdateFileInfo;", "(ZLjava/lang/String;Ljava/util/List;)V", "getExistUpdate", "()Z", "getInfo", "()Ljava/util/List;", "getRomMd5", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AirSilentUpdateInfo {
    private final boolean existUpdate;
    @NotNull
    private final List<AirUpdateFileInfo> info;
    @Nullable
    private final String romMd5;

    public AirSilentUpdateInfo(boolean z, @Nullable String str, @NotNull List<AirUpdateFileInfo> list) {
        Intrinsics.checkNotNullParameter(list, "info");
        this.existUpdate = z;
        this.romMd5 = str;
        this.info = list;
    }

    public static /* synthetic */ AirSilentUpdateInfo copy$default(AirSilentUpdateInfo airSilentUpdateInfo, boolean z, String str, List<AirUpdateFileInfo> list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = airSilentUpdateInfo.existUpdate;
        }
        if ((i & 2) != 0) {
            str = airSilentUpdateInfo.romMd5;
        }
        if ((i & 4) != 0) {
            list = airSilentUpdateInfo.info;
        }
        return airSilentUpdateInfo.copy(z, str, list);
    }

    public final boolean component1() {
        return this.existUpdate;
    }

    @Nullable
    public final String component2() {
        return this.romMd5;
    }

    @NotNull
    public final List<AirUpdateFileInfo> component3() {
        return this.info;
    }

    @NotNull
    public final AirSilentUpdateInfo copy(boolean z, @Nullable String str, @NotNull List<AirUpdateFileInfo> list) {
        Intrinsics.checkNotNullParameter(list, "info");
        return new AirSilentUpdateInfo(z, str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AirSilentUpdateInfo)) {
            return false;
        }
        AirSilentUpdateInfo airSilentUpdateInfo = (AirSilentUpdateInfo) obj;
        return this.existUpdate == airSilentUpdateInfo.existUpdate && Intrinsics.areEqual((Object) this.romMd5, (Object) airSilentUpdateInfo.romMd5) && Intrinsics.areEqual((Object) this.info, (Object) airSilentUpdateInfo.info);
    }

    public final boolean getExistUpdate() {
        return this.existUpdate;
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
        int hashCode = Boolean.hashCode(this.existUpdate) * 31;
        String str = this.romMd5;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.info.hashCode();
    }

    @NotNull
    public String toString() {
        boolean z = this.existUpdate;
        String str = this.romMd5;
        List<AirUpdateFileInfo> list = this.info;
        return "AirSilentUpdateInfo(existUpdate=" + z + ", romMd5=" + str + ", info=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AirSilentUpdateInfo(boolean z, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : str, list);
    }
}
