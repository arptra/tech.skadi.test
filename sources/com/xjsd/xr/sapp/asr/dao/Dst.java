package com.xjsd.xr.sapp.asr.dao;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003JY\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\b\u0010&\u001a\u00020\u0005H\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006'"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/Dst;", "", "type", "", "content", "", "finalSrc", "end", "startTime", "", "endTime", "partIndex", "partNum", "(ILjava/lang/String;Ljava/lang/String;IJJII)V", "getContent", "()Ljava/lang/String;", "getEnd", "()I", "getEndTime", "()J", "getFinalSrc", "getPartIndex", "getPartNum", "getStartTime", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Dst {
    @SerializedName("content")
    @NotNull
    private final String content;
    @SerializedName("end")
    private final int end;
    @SerializedName("endTime")
    private final long endTime;
    @SerializedName("finalSrc")
    @NotNull
    private final String finalSrc;
    @SerializedName("partIndex")
    private final int partIndex;
    @SerializedName("partNum")
    private final int partNum;
    @SerializedName("startTime")
    private final long startTime;
    @SerializedName("type")
    private final int type;

    public Dst() {
        this(0, (String) null, (String) null, 0, 0, 0, 0, 0, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Dst copy$default(Dst dst, int i, String str, String str2, int i2, long j, long j2, int i3, int i4, int i5, Object obj) {
        Dst dst2 = dst;
        int i6 = i5;
        return dst.copy((i6 & 1) != 0 ? dst2.type : i, (i6 & 2) != 0 ? dst2.content : str, (i6 & 4) != 0 ? dst2.finalSrc : str2, (i6 & 8) != 0 ? dst2.end : i2, (i6 & 16) != 0 ? dst2.startTime : j, (i6 & 32) != 0 ? dst2.endTime : j2, (i6 & 64) != 0 ? dst2.partIndex : i3, (i6 & 128) != 0 ? dst2.partNum : i4);
    }

    public final int component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.content;
    }

    @NotNull
    public final String component3() {
        return this.finalSrc;
    }

    public final int component4() {
        return this.end;
    }

    public final long component5() {
        return this.startTime;
    }

    public final long component6() {
        return this.endTime;
    }

    public final int component7() {
        return this.partIndex;
    }

    public final int component8() {
        return this.partNum;
    }

    @NotNull
    public final Dst copy(int i, @NotNull String str, @NotNull String str2, int i2, long j, long j2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(str2, "finalSrc");
        return new Dst(i, str, str2, i2, j, j2, i3, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Dst)) {
            return false;
        }
        Dst dst = (Dst) obj;
        return this.type == dst.type && Intrinsics.areEqual((Object) this.content, (Object) dst.content) && Intrinsics.areEqual((Object) this.finalSrc, (Object) dst.finalSrc) && this.end == dst.end && this.startTime == dst.startTime && this.endTime == dst.endTime && this.partIndex == dst.partIndex && this.partNum == dst.partNum;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final int getEnd() {
        return this.end;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final String getFinalSrc() {
        return this.finalSrc;
    }

    public final int getPartIndex() {
        return this.partIndex;
    }

    public final int getPartNum() {
        return this.partNum;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.type) * 31) + this.content.hashCode()) * 31) + this.finalSrc.hashCode()) * 31) + Integer.hashCode(this.end)) * 31) + Long.hashCode(this.startTime)) * 31) + Long.hashCode(this.endTime)) * 31) + Integer.hashCode(this.partIndex)) * 31) + Integer.hashCode(this.partNum);
    }

    @NotNull
    public String toString() {
        return "Dst(type=" + this.type + ", content='" + this.content + "', finalSrc='" + this.finalSrc + "', end=" + this.end + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", partIndex=" + this.partIndex + ", partNum=" + this.partNum + ')';
    }

    public Dst(int i, @NotNull String str, @NotNull String str2, int i2, long j, long j2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(str2, "finalSrc");
        this.type = i;
        this.content = str;
        this.finalSrc = str2;
        this.end = i2;
        this.startTime = j;
        this.endTime = j2;
        this.partIndex = i3;
        this.partNum = i4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Dst(int i, String str, String str2, int i2, long j, long j2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 1 : i, (i5 & 2) != 0 ? "" : str, (i5 & 4) != 0 ? "" : str2, (i5 & 8) != 0 ? 1 : i2, (i5 & 16) != 0 ? 0 : j, (i5 & 32) != 0 ? 0 : j2, (i5 & 64) != 0 ? 0 : i3, (i5 & 128) != 0 ? 0 : i4);
    }
}
