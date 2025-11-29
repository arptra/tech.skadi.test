package com.upuphone.ar.translation.phone.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\rHÆ\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\bHÖ\u0001J\b\u0010&\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0011R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006'"}, d2 = {"Lcom/upuphone/ar/translation/phone/bean/SimulRunning;", "", "src", "", "dst", "tempSrc", "tempDst", "itemUpdateType", "", "itemUpdateIndex", "isDisplaySrc", "", "recordTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZJ)V", "getDst", "()Ljava/lang/String;", "()Z", "getItemUpdateIndex", "()I", "getItemUpdateType", "getRecordTime", "()J", "getSrc", "getTempDst", "getTempSrc", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SimulRunning {
    @NotNull
    private final String dst;
    private final boolean isDisplaySrc;
    private final int itemUpdateIndex;
    private final int itemUpdateType;
    private final long recordTime;
    @NotNull
    private final String src;
    @NotNull
    private final String tempDst;
    @NotNull
    private final String tempSrc;

    public SimulRunning(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i, int i2, boolean z, long j) {
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "dst");
        Intrinsics.checkNotNullParameter(str3, "tempSrc");
        Intrinsics.checkNotNullParameter(str4, "tempDst");
        this.src = str;
        this.dst = str2;
        this.tempSrc = str3;
        this.tempDst = str4;
        this.itemUpdateType = i;
        this.itemUpdateIndex = i2;
        this.isDisplaySrc = z;
        this.recordTime = j;
    }

    public static /* synthetic */ SimulRunning copy$default(SimulRunning simulRunning, String str, String str2, String str3, String str4, int i, int i2, boolean z, long j, int i3, Object obj) {
        SimulRunning simulRunning2 = simulRunning;
        int i4 = i3;
        return simulRunning.copy((i4 & 1) != 0 ? simulRunning2.src : str, (i4 & 2) != 0 ? simulRunning2.dst : str2, (i4 & 4) != 0 ? simulRunning2.tempSrc : str3, (i4 & 8) != 0 ? simulRunning2.tempDst : str4, (i4 & 16) != 0 ? simulRunning2.itemUpdateType : i, (i4 & 32) != 0 ? simulRunning2.itemUpdateIndex : i2, (i4 & 64) != 0 ? simulRunning2.isDisplaySrc : z, (i4 & 128) != 0 ? simulRunning2.recordTime : j);
    }

    @NotNull
    public final String component1() {
        return this.src;
    }

    @NotNull
    public final String component2() {
        return this.dst;
    }

    @NotNull
    public final String component3() {
        return this.tempSrc;
    }

    @NotNull
    public final String component4() {
        return this.tempDst;
    }

    public final int component5() {
        return this.itemUpdateType;
    }

    public final int component6() {
        return this.itemUpdateIndex;
    }

    public final boolean component7() {
        return this.isDisplaySrc;
    }

    public final long component8() {
        return this.recordTime;
    }

    @NotNull
    public final SimulRunning copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i, int i2, boolean z, long j) {
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "dst");
        Intrinsics.checkNotNullParameter(str3, "tempSrc");
        Intrinsics.checkNotNullParameter(str4, "tempDst");
        return new SimulRunning(str, str2, str3, str4, i, i2, z, j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimulRunning)) {
            return false;
        }
        SimulRunning simulRunning = (SimulRunning) obj;
        return Intrinsics.areEqual((Object) this.src, (Object) simulRunning.src) && Intrinsics.areEqual((Object) this.dst, (Object) simulRunning.dst) && Intrinsics.areEqual((Object) this.tempSrc, (Object) simulRunning.tempSrc) && Intrinsics.areEqual((Object) this.tempDst, (Object) simulRunning.tempDst) && this.itemUpdateType == simulRunning.itemUpdateType && this.itemUpdateIndex == simulRunning.itemUpdateIndex && this.isDisplaySrc == simulRunning.isDisplaySrc && this.recordTime == simulRunning.recordTime;
    }

    @NotNull
    public final String getDst() {
        return this.dst;
    }

    public final int getItemUpdateIndex() {
        return this.itemUpdateIndex;
    }

    public final int getItemUpdateType() {
        return this.itemUpdateType;
    }

    public final long getRecordTime() {
        return this.recordTime;
    }

    @NotNull
    public final String getSrc() {
        return this.src;
    }

    @NotNull
    public final String getTempDst() {
        return this.tempDst;
    }

    @NotNull
    public final String getTempSrc() {
        return this.tempSrc;
    }

    public int hashCode() {
        return (((((((((((((this.src.hashCode() * 31) + this.dst.hashCode()) * 31) + this.tempSrc.hashCode()) * 31) + this.tempDst.hashCode()) * 31) + Integer.hashCode(this.itemUpdateType)) * 31) + Integer.hashCode(this.itemUpdateIndex)) * 31) + Boolean.hashCode(this.isDisplaySrc)) * 31) + Long.hashCode(this.recordTime);
    }

    public final boolean isDisplaySrc() {
        return this.isDisplaySrc;
    }

    @NotNull
    public String toString() {
        String str = this.src;
        String str2 = this.dst;
        String str3 = this.tempSrc;
        String str4 = this.tempDst;
        int i = this.itemUpdateType;
        int i2 = this.itemUpdateIndex;
        boolean z = this.isDisplaySrc;
        long j = this.recordTime;
        return "SimulRunning(src='" + str + "', dst='" + str2 + "', tempSrc='" + str3 + "', tempDst='" + str4 + "', itemUpdateType=" + i + ", itemUpdateIndex=" + i2 + ", isDisplaySrc=" + z + ", recordTime=" + j + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SimulRunning(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, int r17, int r18, boolean r19, long r20, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r12 = this;
            r0 = r22
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0009
            r1 = 0
            r9 = r1
            goto L_0x000b
        L_0x0009:
            r9 = r19
        L_0x000b:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0013
            r0 = 0
            r10 = r0
            goto L_0x0015
        L_0x0013:
            r10 = r20
        L_0x0015:
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.bean.SimulRunning.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, boolean, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
