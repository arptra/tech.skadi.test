package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\"\b\b\u0018\u0000 ?2\u00020\u0001:\u0001?Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u00105\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020\u00032\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\bHÖ\u0001J\t\u0010>\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010-\u001a\u0004\b.\u0010,¨\u0006@"}, d2 = {"Lcom/upuphone/xr/sapp/entity/AppUpdateInfo;", "", "existsUpdate", "", "latestVersion", "", "downloadLink", "upgradeModalStatus", "", "upgradeModelCount", "modal", "Lcom/upuphone/xr/sapp/entity/AppUpdateModel;", "apkSize", "", "digest", "displayProtocol", "protocol", "Lcom/upuphone/xr/sapp/entity/ProtocolModel;", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/upuphone/xr/sapp/entity/AppUpdateModel;Ljava/lang/Long;Ljava/lang/String;ZLcom/upuphone/xr/sapp/entity/ProtocolModel;)V", "getApkSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDigest", "()Ljava/lang/String;", "getDisplayProtocol", "()Z", "setDisplayProtocol", "(Z)V", "getDownloadLink", "downloadProgress", "", "getDownloadProgress", "()F", "setDownloadProgress", "(F)V", "getExistsUpdate", "getLatestVersion", "getModal", "()Lcom/upuphone/xr/sapp/entity/AppUpdateModel;", "getProtocol", "()Lcom/upuphone/xr/sapp/entity/ProtocolModel;", "setProtocol", "(Lcom/upuphone/xr/sapp/entity/ProtocolModel;)V", "getUpgradeModalStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUpgradeModelCount", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/upuphone/xr/sapp/entity/AppUpdateModel;Ljava/lang/Long;Ljava/lang/String;ZLcom/upuphone/xr/sapp/entity/ProtocolModel;)Lcom/upuphone/xr/sapp/entity/AppUpdateInfo;", "equals", "other", "hashCode", "toString", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AppUpdateInfo {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int STATUS_FORCE = 1;
    public static final int STATUS_NOTICE = 2;
    public static final int STATUS_SILENT = 0;
    @Nullable
    private final Long apkSize;
    @Nullable
    private final String digest;
    private boolean displayProtocol;
    @Nullable
    private final String downloadLink;
    private float downloadProgress;
    private final boolean existsUpdate;
    @Nullable
    private final String latestVersion;
    @Nullable
    private final AppUpdateModel modal;
    @Nullable
    private ProtocolModel protocol;
    @Nullable
    private final Integer upgradeModalStatus;
    @Nullable
    private final Integer upgradeModelCount;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/entity/AppUpdateInfo$Companion;", "", "()V", "STATUS_FORCE", "", "STATUS_NOTICE", "STATUS_SILENT", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AppUpdateInfo(boolean z, @Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable Integer num2, @Nullable AppUpdateModel appUpdateModel, @Nullable Long l, @Nullable String str3, boolean z2, @Nullable ProtocolModel protocolModel) {
        this.existsUpdate = z;
        this.latestVersion = str;
        this.downloadLink = str2;
        this.upgradeModalStatus = num;
        this.upgradeModelCount = num2;
        this.modal = appUpdateModel;
        this.apkSize = l;
        this.digest = str3;
        this.displayProtocol = z2;
        this.protocol = protocolModel;
    }

    public static /* synthetic */ AppUpdateInfo copy$default(AppUpdateInfo appUpdateInfo, boolean z, String str, String str2, Integer num, Integer num2, AppUpdateModel appUpdateModel, Long l, String str3, boolean z2, ProtocolModel protocolModel, int i, Object obj) {
        AppUpdateInfo appUpdateInfo2 = appUpdateInfo;
        int i2 = i;
        return appUpdateInfo.copy((i2 & 1) != 0 ? appUpdateInfo2.existsUpdate : z, (i2 & 2) != 0 ? appUpdateInfo2.latestVersion : str, (i2 & 4) != 0 ? appUpdateInfo2.downloadLink : str2, (i2 & 8) != 0 ? appUpdateInfo2.upgradeModalStatus : num, (i2 & 16) != 0 ? appUpdateInfo2.upgradeModelCount : num2, (i2 & 32) != 0 ? appUpdateInfo2.modal : appUpdateModel, (i2 & 64) != 0 ? appUpdateInfo2.apkSize : l, (i2 & 128) != 0 ? appUpdateInfo2.digest : str3, (i2 & 256) != 0 ? appUpdateInfo2.displayProtocol : z2, (i2 & 512) != 0 ? appUpdateInfo2.protocol : protocolModel);
    }

    public final boolean component1() {
        return this.existsUpdate;
    }

    @Nullable
    public final ProtocolModel component10() {
        return this.protocol;
    }

    @Nullable
    public final String component2() {
        return this.latestVersion;
    }

    @Nullable
    public final String component3() {
        return this.downloadLink;
    }

    @Nullable
    public final Integer component4() {
        return this.upgradeModalStatus;
    }

    @Nullable
    public final Integer component5() {
        return this.upgradeModelCount;
    }

    @Nullable
    public final AppUpdateModel component6() {
        return this.modal;
    }

    @Nullable
    public final Long component7() {
        return this.apkSize;
    }

    @Nullable
    public final String component8() {
        return this.digest;
    }

    public final boolean component9() {
        return this.displayProtocol;
    }

    @NotNull
    public final AppUpdateInfo copy(boolean z, @Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable Integer num2, @Nullable AppUpdateModel appUpdateModel, @Nullable Long l, @Nullable String str3, boolean z2, @Nullable ProtocolModel protocolModel) {
        return new AppUpdateInfo(z, str, str2, num, num2, appUpdateModel, l, str3, z2, protocolModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppUpdateInfo)) {
            return false;
        }
        AppUpdateInfo appUpdateInfo = (AppUpdateInfo) obj;
        return this.existsUpdate == appUpdateInfo.existsUpdate && Intrinsics.areEqual((Object) this.latestVersion, (Object) appUpdateInfo.latestVersion) && Intrinsics.areEqual((Object) this.downloadLink, (Object) appUpdateInfo.downloadLink) && Intrinsics.areEqual((Object) this.upgradeModalStatus, (Object) appUpdateInfo.upgradeModalStatus) && Intrinsics.areEqual((Object) this.upgradeModelCount, (Object) appUpdateInfo.upgradeModelCount) && Intrinsics.areEqual((Object) this.modal, (Object) appUpdateInfo.modal) && Intrinsics.areEqual((Object) this.apkSize, (Object) appUpdateInfo.apkSize) && Intrinsics.areEqual((Object) this.digest, (Object) appUpdateInfo.digest) && this.displayProtocol == appUpdateInfo.displayProtocol && Intrinsics.areEqual((Object) this.protocol, (Object) appUpdateInfo.protocol);
    }

    @Nullable
    public final Long getApkSize() {
        return this.apkSize;
    }

    @Nullable
    public final String getDigest() {
        return this.digest;
    }

    public final boolean getDisplayProtocol() {
        return this.displayProtocol;
    }

    @Nullable
    public final String getDownloadLink() {
        return this.downloadLink;
    }

    public final float getDownloadProgress() {
        return this.downloadProgress;
    }

    public final boolean getExistsUpdate() {
        return this.existsUpdate;
    }

    @Nullable
    public final String getLatestVersion() {
        return this.latestVersion;
    }

    @Nullable
    public final AppUpdateModel getModal() {
        return this.modal;
    }

    @Nullable
    public final ProtocolModel getProtocol() {
        return this.protocol;
    }

    @Nullable
    public final Integer getUpgradeModalStatus() {
        return this.upgradeModalStatus;
    }

    @Nullable
    public final Integer getUpgradeModelCount() {
        return this.upgradeModelCount;
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.existsUpdate) * 31;
        String str = this.latestVersion;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.downloadLink;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.upgradeModalStatus;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.upgradeModelCount;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        AppUpdateModel appUpdateModel = this.modal;
        int hashCode6 = (hashCode5 + (appUpdateModel == null ? 0 : appUpdateModel.hashCode())) * 31;
        Long l = this.apkSize;
        int hashCode7 = (hashCode6 + (l == null ? 0 : l.hashCode())) * 31;
        String str3 = this.digest;
        int hashCode8 = (((hashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31) + Boolean.hashCode(this.displayProtocol)) * 31;
        ProtocolModel protocolModel = this.protocol;
        if (protocolModel != null) {
            i = protocolModel.hashCode();
        }
        return hashCode8 + i;
    }

    public final void setDisplayProtocol(boolean z) {
        this.displayProtocol = z;
    }

    public final void setDownloadProgress(float f) {
        this.downloadProgress = f;
    }

    public final void setProtocol(@Nullable ProtocolModel protocolModel) {
        this.protocol = protocolModel;
    }

    @NotNull
    public String toString() {
        boolean z = this.existsUpdate;
        String str = this.latestVersion;
        String str2 = this.downloadLink;
        Integer num = this.upgradeModalStatus;
        Integer num2 = this.upgradeModelCount;
        AppUpdateModel appUpdateModel = this.modal;
        Long l = this.apkSize;
        String str3 = this.digest;
        boolean z2 = this.displayProtocol;
        ProtocolModel protocolModel = this.protocol;
        return "AppUpdateInfo(existsUpdate=" + z + ", latestVersion=" + str + ", downloadLink=" + str2 + ", upgradeModalStatus=" + num + ", upgradeModelCount=" + num2 + ", modal=" + appUpdateModel + ", apkSize=" + l + ", digest=" + str3 + ", displayProtocol=" + z2 + ", protocol=" + protocolModel + ")";
    }
}
