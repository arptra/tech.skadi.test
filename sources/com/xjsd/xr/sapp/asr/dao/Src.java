package com.xjsd.xr.sapp.asr.dao;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\b\u0010#\u001a\u00020\u0005H\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006$"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/Src;", "", "type", "", "content", "", "end", "startTime", "", "endTime", "partIndex", "partNum", "(ILjava/lang/String;IJJII)V", "getContent", "()Ljava/lang/String;", "getEnd", "()I", "getEndTime", "()J", "getPartIndex", "getPartNum", "getStartTime", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Src {
    @SerializedName("content")
    @NotNull
    private final String content;
    @SerializedName("end")
    private final int end;
    @SerializedName("endTime")
    private final long endTime;
    @SerializedName("partIndex")
    private final int partIndex;
    @SerializedName("partNum")
    private final int partNum;
    @SerializedName("startTime")
    private final long startTime;
    @SerializedName("type")
    private final int type;

    public Src() {
        this(0, (String) null, 0, 0, 0, 0, 0, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Src copy$default(Src src, int i, String str, int i2, long j, long j2, int i3, int i4, int i5, Object obj) {
        Src src2 = src;
        return src.copy((i5 & 1) != 0 ? src2.type : i, (i5 & 2) != 0 ? src2.content : str, (i5 & 4) != 0 ? src2.end : i2, (i5 & 8) != 0 ? src2.startTime : j, (i5 & 16) != 0 ? src2.endTime : j2, (i5 & 32) != 0 ? src2.partIndex : i3, (i5 & 64) != 0 ? src2.partNum : i4);
    }

    public final int component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.content;
    }

    public final int component3() {
        return this.end;
    }

    public final long component4() {
        return this.startTime;
    }

    public final long component5() {
        return this.endTime;
    }

    public final int component6() {
        return this.partIndex;
    }

    public final int component7() {
        return this.partNum;
    }

    @NotNull
    public final Src copy(int i, @NotNull String str, int i2, long j, long j2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "content");
        return new Src(i, str, i2, j, j2, i3, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Src)) {
            return false;
        }
        Src src = (Src) obj;
        return this.type == src.type && Intrinsics.areEqual((Object) this.content, (Object) src.content) && this.end == src.end && this.startTime == src.startTime && this.endTime == src.endTime && this.partIndex == src.partIndex && this.partNum == src.partNum;
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
        return (((((((((((Integer.hashCode(this.type) * 31) + this.content.hashCode()) * 31) + Integer.hashCode(this.end)) * 31) + Long.hashCode(this.startTime)) * 31) + Long.hashCode(this.endTime)) * 31) + Integer.hashCode(this.partIndex)) * 31) + Integer.hashCode(this.partNum);
    }

    @NotNull
    public String toString() {
        return "Src(type=" + this.type + ", content='" + this.content + "', end=" + this.end + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", partIndex=" + this.partIndex + ", partNum=" + this.partNum + ')';
    }

    public Src(int i, @NotNull String str, int i2, long j, long j2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "content");
        this.type = i;
        this.content = str;
        this.end = i2;
        this.startTime = j;
        this.endTime = j2;
        this.partIndex = i3;
        this.partNum = i4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Src(int i, String str, int i2, long j, long j2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 1 : i, (i5 & 2) != 0 ? "" : str, (i5 & 4) != 0 ? 1 : i2, (i5 & 8) != 0 ? 0 : j, (i5 & 16) != 0 ? 0 : j2, (i5 & 32) != 0 ? 0 : i3, (i5 & 64) != 0 ? 0 : i4);
    }
}
