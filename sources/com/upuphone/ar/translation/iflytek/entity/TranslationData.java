package com.upuphone.ar.translation.iflytek.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001c\b\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\b\u0010$\u001a\u00020\u0005H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006%"}, d2 = {"Lcom/upuphone/ar/translation/iflytek/entity/TranslationData;", "", "bg", "", "biz", "", "dst", "ed", "isEnd", "", "segId", "src", "type", "(ILjava/lang/String;Ljava/lang/String;IZILjava/lang/String;I)V", "getBg", "()I", "getBiz", "()Ljava/lang/String;", "getDst", "getEd", "()Z", "getSegId", "getSrc", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranslationData {
    @SerializedName("bg")
    private final int bg;
    @SerializedName("biz")
    @NotNull
    private final String biz;
    @SerializedName("dst")
    @NotNull
    private final String dst;
    @SerializedName("ed")
    private final int ed;
    @SerializedName("isEnd")
    private final boolean isEnd;
    @SerializedName("segId")
    private final int segId;
    @SerializedName("src")
    @NotNull
    private final String src;
    @SerializedName("type")
    private final int type;

    public TranslationData() {
        this(0, (String) null, (String) null, 0, false, 0, (String) null, 0, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TranslationData copy$default(TranslationData translationData, int i, String str, String str2, int i2, boolean z, int i3, String str3, int i4, int i5, Object obj) {
        TranslationData translationData2 = translationData;
        int i6 = i5;
        return translationData.copy((i6 & 1) != 0 ? translationData2.bg : i, (i6 & 2) != 0 ? translationData2.biz : str, (i6 & 4) != 0 ? translationData2.dst : str2, (i6 & 8) != 0 ? translationData2.ed : i2, (i6 & 16) != 0 ? translationData2.isEnd : z, (i6 & 32) != 0 ? translationData2.segId : i3, (i6 & 64) != 0 ? translationData2.src : str3, (i6 & 128) != 0 ? translationData2.type : i4);
    }

    public final int component1() {
        return this.bg;
    }

    @NotNull
    public final String component2() {
        return this.biz;
    }

    @NotNull
    public final String component3() {
        return this.dst;
    }

    public final int component4() {
        return this.ed;
    }

    public final boolean component5() {
        return this.isEnd;
    }

    public final int component6() {
        return this.segId;
    }

    @NotNull
    public final String component7() {
        return this.src;
    }

    public final int component8() {
        return this.type;
    }

    @NotNull
    public final TranslationData copy(int i, @NotNull String str, @NotNull String str2, int i2, boolean z, int i3, @NotNull String str3, int i4) {
        Intrinsics.checkNotNullParameter(str, "biz");
        Intrinsics.checkNotNullParameter(str2, "dst");
        String str4 = str3;
        Intrinsics.checkNotNullParameter(str4, "src");
        return new TranslationData(i, str, str2, i2, z, i3, str4, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TranslationData)) {
            return false;
        }
        TranslationData translationData = (TranslationData) obj;
        return this.bg == translationData.bg && Intrinsics.areEqual((Object) this.biz, (Object) translationData.biz) && Intrinsics.areEqual((Object) this.dst, (Object) translationData.dst) && this.ed == translationData.ed && this.isEnd == translationData.isEnd && this.segId == translationData.segId && Intrinsics.areEqual((Object) this.src, (Object) translationData.src) && this.type == translationData.type;
    }

    public final int getBg() {
        return this.bg;
    }

    @NotNull
    public final String getBiz() {
        return this.biz;
    }

    @NotNull
    public final String getDst() {
        return this.dst;
    }

    public final int getEd() {
        return this.ed;
    }

    public final int getSegId() {
        return this.segId;
    }

    @NotNull
    public final String getSrc() {
        return this.src;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.bg) * 31) + this.biz.hashCode()) * 31) + this.dst.hashCode()) * 31) + Integer.hashCode(this.ed)) * 31) + Boolean.hashCode(this.isEnd)) * 31) + Integer.hashCode(this.segId)) * 31) + this.src.hashCode()) * 31) + Integer.hashCode(this.type);
    }

    public final boolean isEnd() {
        return this.isEnd;
    }

    @NotNull
    public String toString() {
        int i = this.bg;
        String str = this.biz;
        String str2 = this.dst;
        int i2 = this.ed;
        boolean z = this.isEnd;
        int i3 = this.segId;
        String str3 = this.src;
        int i4 = this.type;
        return "TranslationData(bg=" + i + ", biz='" + str + "', dst='" + str2 + "', ed=" + i2 + ", isEnd=" + z + ", segId=" + i3 + ", src='" + str3 + "', type=" + i4 + ")";
    }

    public TranslationData(int i, @NotNull String str, @NotNull String str2, int i2, boolean z, int i3, @NotNull String str3, int i4) {
        Intrinsics.checkNotNullParameter(str, "biz");
        Intrinsics.checkNotNullParameter(str2, "dst");
        Intrinsics.checkNotNullParameter(str3, "src");
        this.bg = i;
        this.biz = str;
        this.dst = str2;
        this.ed = i2;
        this.isEnd = z;
        this.segId = i3;
        this.src = str3;
        this.type = i4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TranslationData(int i, String str, String str2, int i2, boolean z, int i3, String str3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? "" : str, (i5 & 4) != 0 ? "" : str2, (i5 & 8) != 0 ? 0 : i2, (i5 & 16) != 0 ? false : z, (i5 & 32) != 0 ? 0 : i3, (i5 & 64) != 0 ? "" : str3, (i5 & 128) != 0 ? 1 : i4);
    }
}
