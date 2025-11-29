package com.xjsd.xr.sapp.asr.dao;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\rHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003Jq\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\rHÖ\u0001J\b\u0010,\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006-"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/AsrResponseData;", "", "text", "", "translateText", "language", "accent", "startTime", "", "endTime", "data", "time", "partIndex", "", "partNum", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;JII)V", "getAccent", "()Ljava/lang/String;", "getData", "getEndTime", "()J", "getLanguage", "getPartIndex", "()I", "getPartNum", "getStartTime", "getText", "getTime", "getTranslateText", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AsrResponseData {
    @NotNull
    private final String accent;
    @Nullable
    private final String data;
    private final long endTime;
    @NotNull
    private final String language;
    private final int partIndex;
    private final int partNum;
    private final long startTime;
    @NotNull
    private final String text;
    private final long time;
    @Nullable
    private final String translateText;

    public AsrResponseData(@NotNull String str, @Nullable String str2, @NotNull String str3, @NotNull String str4, long j, long j2, @Nullable String str5, long j3, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str3, "language");
        Intrinsics.checkNotNullParameter(str4, "accent");
        this.text = str;
        this.translateText = str2;
        this.language = str3;
        this.accent = str4;
        this.startTime = j;
        this.endTime = j2;
        this.data = str5;
        this.time = j3;
        this.partIndex = i;
        this.partNum = i2;
    }

    public static /* synthetic */ AsrResponseData copy$default(AsrResponseData asrResponseData, String str, String str2, String str3, String str4, long j, long j2, String str5, long j3, int i, int i2, int i3, Object obj) {
        AsrResponseData asrResponseData2 = asrResponseData;
        int i4 = i3;
        return asrResponseData.copy((i4 & 1) != 0 ? asrResponseData2.text : str, (i4 & 2) != 0 ? asrResponseData2.translateText : str2, (i4 & 4) != 0 ? asrResponseData2.language : str3, (i4 & 8) != 0 ? asrResponseData2.accent : str4, (i4 & 16) != 0 ? asrResponseData2.startTime : j, (i4 & 32) != 0 ? asrResponseData2.endTime : j2, (i4 & 64) != 0 ? asrResponseData2.data : str5, (i4 & 128) != 0 ? asrResponseData2.time : j3, (i4 & 256) != 0 ? asrResponseData2.partIndex : i, (i4 & 512) != 0 ? asrResponseData2.partNum : i2);
    }

    @NotNull
    public final String component1() {
        return this.text;
    }

    public final int component10() {
        return this.partNum;
    }

    @Nullable
    public final String component2() {
        return this.translateText;
    }

    @NotNull
    public final String component3() {
        return this.language;
    }

    @NotNull
    public final String component4() {
        return this.accent;
    }

    public final long component5() {
        return this.startTime;
    }

    public final long component6() {
        return this.endTime;
    }

    @Nullable
    public final String component7() {
        return this.data;
    }

    public final long component8() {
        return this.time;
    }

    public final int component9() {
        return this.partIndex;
    }

    @NotNull
    public final AsrResponseData copy(@NotNull String str, @Nullable String str2, @NotNull String str3, @NotNull String str4, long j, long j2, @Nullable String str5, long j3, int i, int i2) {
        String str6 = str;
        Intrinsics.checkNotNullParameter(str6, "text");
        String str7 = str3;
        Intrinsics.checkNotNullParameter(str7, "language");
        String str8 = str4;
        Intrinsics.checkNotNullParameter(str8, "accent");
        return new AsrResponseData(str6, str2, str7, str8, j, j2, str5, j3, i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AsrResponseData)) {
            return false;
        }
        AsrResponseData asrResponseData = (AsrResponseData) obj;
        return Intrinsics.areEqual((Object) this.text, (Object) asrResponseData.text) && Intrinsics.areEqual((Object) this.translateText, (Object) asrResponseData.translateText) && Intrinsics.areEqual((Object) this.language, (Object) asrResponseData.language) && Intrinsics.areEqual((Object) this.accent, (Object) asrResponseData.accent) && this.startTime == asrResponseData.startTime && this.endTime == asrResponseData.endTime && Intrinsics.areEqual((Object) this.data, (Object) asrResponseData.data) && this.time == asrResponseData.time && this.partIndex == asrResponseData.partIndex && this.partNum == asrResponseData.partNum;
    }

    @NotNull
    public final String getAccent() {
        return this.accent;
    }

    @Nullable
    public final String getData() {
        return this.data;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
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

    @NotNull
    public final String getText() {
        return this.text;
    }

    public final long getTime() {
        return this.time;
    }

    @Nullable
    public final String getTranslateText() {
        return this.translateText;
    }

    public int hashCode() {
        int hashCode = this.text.hashCode() * 31;
        String str = this.translateText;
        int i = 0;
        int hashCode2 = (((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.language.hashCode()) * 31) + this.accent.hashCode()) * 31) + Long.hashCode(this.startTime)) * 31) + Long.hashCode(this.endTime)) * 31;
        String str2 = this.data;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((((hashCode2 + i) * 31) + Long.hashCode(this.time)) * 31) + Integer.hashCode(this.partIndex)) * 31) + Integer.hashCode(this.partNum);
    }

    @NotNull
    public String toString() {
        return "AsrResponseData(text='" + this.text + "', translateText=" + this.translateText + ", language='" + this.language + "', accent='" + this.accent + "', startTime=" + this.startTime + ", endTime=" + this.endTime + ", data=" + this.data + ", time=" + this.time + ", partIndex=" + this.partIndex + ", partNum=" + this.partNum + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AsrResponseData(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, long r22, long r24, java.lang.String r26, long r27, int r29, int r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r17 = this;
            r0 = r31
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r5 = r2
            goto L_0x000b
        L_0x0009:
            r5 = r19
        L_0x000b:
            r1 = r0 & 16
            r3 = 0
            if (r1 == 0) goto L_0x0013
            r8 = r3
            goto L_0x0015
        L_0x0013:
            r8 = r22
        L_0x0015:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x001b
            r10 = r3
            goto L_0x001d
        L_0x001b:
            r10 = r24
        L_0x001d:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0023
            r12 = r2
            goto L_0x0025
        L_0x0023:
            r12 = r26
        L_0x0025:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x002b
            r13 = r3
            goto L_0x002d
        L_0x002b:
            r13 = r27
        L_0x002d:
            r1 = r0 & 256(0x100, float:3.59E-43)
            r2 = 0
            if (r1 == 0) goto L_0x0034
            r15 = r2
            goto L_0x0036
        L_0x0034:
            r15 = r29
        L_0x0036:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x003d
            r16 = r2
            goto L_0x003f
        L_0x003d:
            r16 = r30
        L_0x003f:
            r3 = r17
            r4 = r18
            r6 = r20
            r7 = r21
            r3.<init>(r4, r5, r6, r7, r8, r10, r12, r13, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.xr.sapp.asr.dao.AsrResponseData.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, long, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
