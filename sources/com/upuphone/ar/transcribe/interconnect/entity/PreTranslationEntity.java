package com.upuphone.ar.transcribe.interconnect.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003Jc\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\b\u0010'\u001a\u00020\u0005H\u0016R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006("}, d2 = {"Lcom/upuphone/ar/transcribe/interconnect/entity/PreTranslationEntity;", "", "transType", "", "src", "", "dst", "subtitleSetType", "subtitleSizeType", "saveResult", "transVersionCode", "screenType", "versionCode", "(ILjava/lang/String;Ljava/lang/String;IIIIII)V", "getDst", "()Ljava/lang/String;", "getSaveResult", "()I", "getScreenType", "getSrc", "getSubtitleSetType", "getSubtitleSizeType", "getTransType", "getTransVersionCode", "getVersionCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PreTranslationEntity {
    @SerializedName("dst")
    @NotNull
    private final String dst;
    @SerializedName("saveResult")
    private final int saveResult;
    @SerializedName("screenType")
    private final int screenType;
    @SerializedName("src")
    @NotNull
    private final String src;
    @SerializedName("subtitleSetType")
    private final int subtitleSetType;
    @SerializedName("subtitleSizeType")
    private final int subtitleSizeType;
    @SerializedName("transType")
    private final int transType;
    @SerializedName("transVersionCode")
    private final int transVersionCode;
    @SerializedName("versionCode")
    private final int versionCode;

    public PreTranslationEntity(int i, @NotNull String str, @NotNull String str2, int i2, int i3, int i4, int i5, int i6, int i7) {
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "dst");
        this.transType = i;
        this.src = str;
        this.dst = str2;
        this.subtitleSetType = i2;
        this.subtitleSizeType = i3;
        this.saveResult = i4;
        this.transVersionCode = i5;
        this.screenType = i6;
        this.versionCode = i7;
    }

    public static /* synthetic */ PreTranslationEntity copy$default(PreTranslationEntity preTranslationEntity, int i, String str, String str2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Object obj) {
        PreTranslationEntity preTranslationEntity2 = preTranslationEntity;
        int i9 = i8;
        return preTranslationEntity.copy((i9 & 1) != 0 ? preTranslationEntity2.transType : i, (i9 & 2) != 0 ? preTranslationEntity2.src : str, (i9 & 4) != 0 ? preTranslationEntity2.dst : str2, (i9 & 8) != 0 ? preTranslationEntity2.subtitleSetType : i2, (i9 & 16) != 0 ? preTranslationEntity2.subtitleSizeType : i3, (i9 & 32) != 0 ? preTranslationEntity2.saveResult : i4, (i9 & 64) != 0 ? preTranslationEntity2.transVersionCode : i5, (i9 & 128) != 0 ? preTranslationEntity2.screenType : i6, (i9 & 256) != 0 ? preTranslationEntity2.versionCode : i7);
    }

    public final int component1() {
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
        return this.subtitleSizeType;
    }

    public final int component6() {
        return this.saveResult;
    }

    public final int component7() {
        return this.transVersionCode;
    }

    public final int component8() {
        return this.screenType;
    }

    public final int component9() {
        return this.versionCode;
    }

    @NotNull
    public final PreTranslationEntity copy(int i, @NotNull String str, @NotNull String str2, int i2, int i3, int i4, int i5, int i6, int i7) {
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "dst");
        return new PreTranslationEntity(i, str, str2, i2, i3, i4, i5, i6, i7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreTranslationEntity)) {
            return false;
        }
        PreTranslationEntity preTranslationEntity = (PreTranslationEntity) obj;
        return this.transType == preTranslationEntity.transType && Intrinsics.areEqual((Object) this.src, (Object) preTranslationEntity.src) && Intrinsics.areEqual((Object) this.dst, (Object) preTranslationEntity.dst) && this.subtitleSetType == preTranslationEntity.subtitleSetType && this.subtitleSizeType == preTranslationEntity.subtitleSizeType && this.saveResult == preTranslationEntity.saveResult && this.transVersionCode == preTranslationEntity.transVersionCode && this.screenType == preTranslationEntity.screenType && this.versionCode == preTranslationEntity.versionCode;
    }

    @NotNull
    public final String getDst() {
        return this.dst;
    }

    public final int getSaveResult() {
        return this.saveResult;
    }

    public final int getScreenType() {
        return this.screenType;
    }

    @NotNull
    public final String getSrc() {
        return this.src;
    }

    public final int getSubtitleSetType() {
        return this.subtitleSetType;
    }

    public final int getSubtitleSizeType() {
        return this.subtitleSizeType;
    }

    public final int getTransType() {
        return this.transType;
    }

    public final int getTransVersionCode() {
        return this.transVersionCode;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return (((((((((((((((Integer.hashCode(this.transType) * 31) + this.src.hashCode()) * 31) + this.dst.hashCode()) * 31) + Integer.hashCode(this.subtitleSetType)) * 31) + Integer.hashCode(this.subtitleSizeType)) * 31) + Integer.hashCode(this.saveResult)) * 31) + Integer.hashCode(this.transVersionCode)) * 31) + Integer.hashCode(this.screenType)) * 31) + Integer.hashCode(this.versionCode);
    }

    @NotNull
    public String toString() {
        int i = this.transType;
        String str = this.src;
        String str2 = this.dst;
        int i2 = this.subtitleSetType;
        int i3 = this.subtitleSizeType;
        int i4 = this.saveResult;
        int i5 = this.transVersionCode;
        int i6 = this.screenType;
        int i7 = this.versionCode;
        return "PreTranslationEntity(transType=" + i + ", src='" + str + "', dst='" + str2 + "', subtitleSetType=" + i2 + ", subtitleSizeType=" + i3 + ", saveResult=" + i4 + ", transVersionCode=" + i5 + ", screenType=" + i6 + ", versionCode=" + i7 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PreTranslationEntity(int r14, java.lang.String r15, java.lang.String r16, int r17, int r18, int r19, int r20, int r21, int r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 64
            r2 = 1
            if (r1 == 0) goto L_0x0009
            r10 = r2
            goto L_0x000b
        L_0x0009:
            r10 = r20
        L_0x000b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0011
            r11 = r2
            goto L_0x0013
        L_0x0011:
            r11 = r21
        L_0x0013:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0019
            r12 = r2
            goto L_0x001b
        L_0x0019:
            r12 = r22
        L_0x001b:
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.interconnect.entity.PreTranslationEntity.<init>(int, java.lang.String, java.lang.String, int, int, int, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
