package com.upuphone.ar.translation.interconnect.entity;

import com.google.gson.annotations.SerializedName;
import com.upuphone.ar.translation.ext.InterconnectMsgCodExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JV\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\b\u0010$\u001a\u00020\u0005H\u0016R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006%"}, d2 = {"Lcom/upuphone/ar/translation/interconnect/entity/InitPhone2GlassInfo;", "", "transType", "", "src", "", "dst", "subtitleSetType", "saveResult", "transVersionCode", "versionCode", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;IIII)V", "getDst", "()Ljava/lang/String;", "getSaveResult", "()I", "getSrc", "getSubtitleSetType", "getTransType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTransVersionCode", "getVersionCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;IIII)Lcom/upuphone/ar/translation/interconnect/entity/InitPhone2GlassInfo;", "equals", "", "other", "hashCode", "toString", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InitPhone2GlassInfo {
    @SerializedName("dst")
    @NotNull
    private final String dst;
    @SerializedName("saveResult")
    private final int saveResult;
    @SerializedName("src")
    @NotNull
    private final String src;
    @SerializedName("subtitleSetType")
    private final int subtitleSetType;
    @SerializedName("transType")
    @Nullable
    private final Integer transType;
    @SerializedName("transVersionCode")
    private final int transVersionCode;
    @SerializedName("versionCode")
    private final int versionCode;

    public InitPhone2GlassInfo(@Nullable Integer num, @NotNull String str, @NotNull String str2, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "dst");
        this.transType = num;
        this.src = str;
        this.dst = str2;
        this.subtitleSetType = i;
        this.saveResult = i2;
        this.transVersionCode = i3;
        this.versionCode = i4;
    }

    public static /* synthetic */ InitPhone2GlassInfo copy$default(InitPhone2GlassInfo initPhone2GlassInfo, Integer num, String str, String str2, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            num = initPhone2GlassInfo.transType;
        }
        if ((i5 & 2) != 0) {
            str = initPhone2GlassInfo.src;
        }
        String str3 = str;
        if ((i5 & 4) != 0) {
            str2 = initPhone2GlassInfo.dst;
        }
        String str4 = str2;
        if ((i5 & 8) != 0) {
            i = initPhone2GlassInfo.subtitleSetType;
        }
        int i6 = i;
        if ((i5 & 16) != 0) {
            i2 = initPhone2GlassInfo.saveResult;
        }
        int i7 = i2;
        if ((i5 & 32) != 0) {
            i3 = initPhone2GlassInfo.transVersionCode;
        }
        int i8 = i3;
        if ((i5 & 64) != 0) {
            i4 = initPhone2GlassInfo.versionCode;
        }
        return initPhone2GlassInfo.copy(num, str3, str4, i6, i7, i8, i4);
    }

    @Nullable
    public final Integer component1() {
        return this.transType;
    }

    @NotNull
    public final String component2() {
        return this.src;
    }

    @NotNull
    public final String component3() {
        return this.dst;
    }

    public final int component4() {
        return this.subtitleSetType;
    }

    public final int component5() {
        return this.saveResult;
    }

    public final int component6() {
        return this.transVersionCode;
    }

    public final int component7() {
        return this.versionCode;
    }

    @NotNull
    public final InitPhone2GlassInfo copy(@Nullable Integer num, @NotNull String str, @NotNull String str2, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "dst");
        return new InitPhone2GlassInfo(num, str, str2, i, i2, i3, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InitPhone2GlassInfo)) {
            return false;
        }
        InitPhone2GlassInfo initPhone2GlassInfo = (InitPhone2GlassInfo) obj;
        return Intrinsics.areEqual((Object) this.transType, (Object) initPhone2GlassInfo.transType) && Intrinsics.areEqual((Object) this.src, (Object) initPhone2GlassInfo.src) && Intrinsics.areEqual((Object) this.dst, (Object) initPhone2GlassInfo.dst) && this.subtitleSetType == initPhone2GlassInfo.subtitleSetType && this.saveResult == initPhone2GlassInfo.saveResult && this.transVersionCode == initPhone2GlassInfo.transVersionCode && this.versionCode == initPhone2GlassInfo.versionCode;
    }

    @NotNull
    public final String getDst() {
        return this.dst;
    }

    public final int getSaveResult() {
        return this.saveResult;
    }

    @NotNull
    public final String getSrc() {
        return this.src;
    }

    public final int getSubtitleSetType() {
        return this.subtitleSetType;
    }

    @Nullable
    public final Integer getTransType() {
        return this.transType;
    }

    public final int getTransVersionCode() {
        return this.transVersionCode;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        Integer num = this.transType;
        return ((((((((((((num == null ? 0 : num.hashCode()) * 31) + this.src.hashCode()) * 31) + this.dst.hashCode()) * 31) + Integer.hashCode(this.subtitleSetType)) * 31) + Integer.hashCode(this.saveResult)) * 31) + Integer.hashCode(this.transVersionCode)) * 31) + Integer.hashCode(this.versionCode);
    }

    @NotNull
    public String toString() {
        Integer num = this.transType;
        String k = num != null ? InterconnectMsgCodExtKt.k(num.intValue()) : null;
        String str = this.src;
        String str2 = this.dst;
        String h = InterconnectMsgCodExtKt.h(this.subtitleSetType);
        int i = this.saveResult;
        int i2 = this.transVersionCode;
        int i3 = this.versionCode;
        return "InitPhone2GlassInfo(transType=" + k + ", src='" + str + "', dst='" + str2 + "', subtitleSetType=" + h + ", saveResult=" + i + ", transVersionCode=" + i2 + ", versionCode=" + i3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InitPhone2GlassInfo(Integer num, String str, String str2, int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : num, str, str2, i, i2, (i5 & 32) != 0 ? 1 : i3, (i5 & 64) != 0 ? 1 : i4);
    }
}
