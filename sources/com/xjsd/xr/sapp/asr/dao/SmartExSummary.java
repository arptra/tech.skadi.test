package com.xjsd.xr.sapp.asr.dao;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\b\u0010\u001e\u001a\u00020\u0003H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/SmartExSummary;", "", "summary", "", "versionCode", "baseStatus", "", "requestId", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getBaseStatus", "()I", "setBaseStatus", "(I)V", "getRequestId", "()Ljava/lang/String;", "setRequestId", "(Ljava/lang/String;)V", "getSummary", "setSummary", "getVersionCode", "setVersionCode", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SmartExSummary {
    @SerializedName("base_status")
    private int baseStatus;
    @SerializedName("requestId")
    @NotNull
    private String requestId;
    @NotNull
    private String summary;
    @SerializedName("version_code")
    @NotNull
    private String versionCode;

    public SmartExSummary(@NotNull String str, @NotNull String str2, int i, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "summary");
        Intrinsics.checkNotNullParameter(str2, "versionCode");
        Intrinsics.checkNotNullParameter(str3, "requestId");
        this.summary = str;
        this.versionCode = str2;
        this.baseStatus = i;
        this.requestId = str3;
    }

    public static /* synthetic */ SmartExSummary copy$default(SmartExSummary smartExSummary, String str, String str2, int i, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = smartExSummary.summary;
        }
        if ((i2 & 2) != 0) {
            str2 = smartExSummary.versionCode;
        }
        if ((i2 & 4) != 0) {
            i = smartExSummary.baseStatus;
        }
        if ((i2 & 8) != 0) {
            str3 = smartExSummary.requestId;
        }
        return smartExSummary.copy(str, str2, i, str3);
    }

    @NotNull
    public final String component1() {
        return this.summary;
    }

    @NotNull
    public final String component2() {
        return this.versionCode;
    }

    public final int component3() {
        return this.baseStatus;
    }

    @NotNull
    public final String component4() {
        return this.requestId;
    }

    @NotNull
    public final SmartExSummary copy(@NotNull String str, @NotNull String str2, int i, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "summary");
        Intrinsics.checkNotNullParameter(str2, "versionCode");
        Intrinsics.checkNotNullParameter(str3, "requestId");
        return new SmartExSummary(str, str2, i, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmartExSummary)) {
            return false;
        }
        SmartExSummary smartExSummary = (SmartExSummary) obj;
        return Intrinsics.areEqual((Object) this.summary, (Object) smartExSummary.summary) && Intrinsics.areEqual((Object) this.versionCode, (Object) smartExSummary.versionCode) && this.baseStatus == smartExSummary.baseStatus && Intrinsics.areEqual((Object) this.requestId, (Object) smartExSummary.requestId);
    }

    public final int getBaseStatus() {
        return this.baseStatus;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final String getSummary() {
        return this.summary;
    }

    @NotNull
    public final String getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return (((((this.summary.hashCode() * 31) + this.versionCode.hashCode()) * 31) + Integer.hashCode(this.baseStatus)) * 31) + this.requestId.hashCode();
    }

    public final void setBaseStatus(int i) {
        this.baseStatus = i;
    }

    public final void setRequestId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.requestId = str;
    }

    public final void setSummary(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.summary = str;
    }

    public final void setVersionCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.versionCode = str;
    }

    @NotNull
    public String toString() {
        return "SmartExSummary(summary='" + this.summary + "', versionCode='" + this.versionCode + "', baseStatus=" + this.baseStatus + ", requestId='" + this.requestId + "')";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SmartExSummary(String str, String str2, int i, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, (i2 & 8) != 0 ? "" : str3);
    }
}
