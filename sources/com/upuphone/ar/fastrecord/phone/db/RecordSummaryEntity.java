package com.upuphone.ar.fastrecord.phone.db;

import androidx.annotation.Keep;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b7\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011¢\u0006\u0002\u0010\u0014J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0011HÆ\u0003J\t\u0010;\u001a\u00020\u0011HÆ\u0003J\t\u0010<\u001a\u00020\u0011HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J©\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0011HÆ\u0001J\u0013\u0010F\u001a\u00020\u00112\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020IHÖ\u0001J\t\u0010J\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010!\"\u0004\b\"\u0010#R\u001e\u0010\u0013\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010!\"\u0004\b$\u0010#R\u001e\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010!\"\u0004\b%\u0010#R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\u001a\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0016\"\u0004\b1\u0010\u0018R\u001a\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0016\"\u0004\b5\u0010\u0018¨\u0006K"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/db/RecordSummaryEntity;", "", "summaryId", "", "fileName", "", "content", "contentTemp", "versionCode", "appName", "recognizeId", "accountId", "requestId", "traceId", "recordId", "terminalTraceId", "isFinishDel", "", "isReport", "isNeedRequestServer", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ZZZ)V", "getAccountId", "()Ljava/lang/String;", "setAccountId", "(Ljava/lang/String;)V", "getAppName", "setAppName", "getContent", "setContent", "getContentTemp", "setContentTemp", "getFileName", "setFileName", "()Z", "setFinishDel", "(Z)V", "setNeedRequestServer", "setReport", "getRecognizeId", "setRecognizeId", "getRecordId", "()J", "setRecordId", "(J)V", "getRequestId", "setRequestId", "getSummaryId", "setSummaryId", "getTerminalTraceId", "setTerminalTraceId", "getTraceId", "setTraceId", "getVersionCode", "setVersionCode", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
@Entity
public final class RecordSummaryEntity {
    @NotNull
    private String accountId;
    @NotNull
    private String appName;
    @Nullable
    private String content;
    @Nullable
    private String contentTemp;
    @Nullable
    private String fileName;
    private boolean isFinishDel;
    @ColumnInfo
    private boolean isNeedRequestServer;
    @ColumnInfo
    private boolean isReport;
    @Nullable
    private String recognizeId;
    private long recordId;
    @NotNull
    private String requestId;
    @PrimaryKey
    private long summaryId;
    @NotNull
    private String terminalTraceId;
    @NotNull
    private String traceId;
    @Nullable
    private String versionCode;

    public RecordSummaryEntity() {
        this(0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, false, false, false, 32767, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RecordSummaryEntity copy$default(RecordSummaryEntity recordSummaryEntity, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, long j2, String str10, boolean z, boolean z2, boolean z3, int i, Object obj) {
        RecordSummaryEntity recordSummaryEntity2 = recordSummaryEntity;
        int i2 = i;
        return recordSummaryEntity.copy((i2 & 1) != 0 ? recordSummaryEntity2.summaryId : j, (i2 & 2) != 0 ? recordSummaryEntity2.fileName : str, (i2 & 4) != 0 ? recordSummaryEntity2.content : str2, (i2 & 8) != 0 ? recordSummaryEntity2.contentTemp : str3, (i2 & 16) != 0 ? recordSummaryEntity2.versionCode : str4, (i2 & 32) != 0 ? recordSummaryEntity2.appName : str5, (i2 & 64) != 0 ? recordSummaryEntity2.recognizeId : str6, (i2 & 128) != 0 ? recordSummaryEntity2.accountId : str7, (i2 & 256) != 0 ? recordSummaryEntity2.requestId : str8, (i2 & 512) != 0 ? recordSummaryEntity2.traceId : str9, (i2 & 1024) != 0 ? recordSummaryEntity2.recordId : j2, (i2 & 2048) != 0 ? recordSummaryEntity2.terminalTraceId : str10, (i2 & 4096) != 0 ? recordSummaryEntity2.isFinishDel : z, (i2 & 8192) != 0 ? recordSummaryEntity2.isReport : z2, (i2 & 16384) != 0 ? recordSummaryEntity2.isNeedRequestServer : z3);
    }

    public final long component1() {
        return this.summaryId;
    }

    @NotNull
    public final String component10() {
        return this.traceId;
    }

    public final long component11() {
        return this.recordId;
    }

    @NotNull
    public final String component12() {
        return this.terminalTraceId;
    }

    public final boolean component13() {
        return this.isFinishDel;
    }

    public final boolean component14() {
        return this.isReport;
    }

    public final boolean component15() {
        return this.isNeedRequestServer;
    }

    @Nullable
    public final String component2() {
        return this.fileName;
    }

    @Nullable
    public final String component3() {
        return this.content;
    }

    @Nullable
    public final String component4() {
        return this.contentTemp;
    }

    @Nullable
    public final String component5() {
        return this.versionCode;
    }

    @NotNull
    public final String component6() {
        return this.appName;
    }

    @Nullable
    public final String component7() {
        return this.recognizeId;
    }

    @NotNull
    public final String component8() {
        return this.accountId;
    }

    @NotNull
    public final String component9() {
        return this.requestId;
    }

    @NotNull
    public final RecordSummaryEntity copy(long j, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull String str5, @Nullable String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, long j2, @NotNull String str10, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(str5, "appName");
        Intrinsics.checkNotNullParameter(str7, "accountId");
        Intrinsics.checkNotNullParameter(str8, "requestId");
        Intrinsics.checkNotNullParameter(str9, "traceId");
        Intrinsics.checkNotNullParameter(str10, "terminalTraceId");
        return new RecordSummaryEntity(j, str, str2, str3, str4, str5, str6, str7, str8, str9, j2, str10, z, z2, z3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordSummaryEntity)) {
            return false;
        }
        RecordSummaryEntity recordSummaryEntity = (RecordSummaryEntity) obj;
        return this.summaryId == recordSummaryEntity.summaryId && Intrinsics.areEqual((Object) this.fileName, (Object) recordSummaryEntity.fileName) && Intrinsics.areEqual((Object) this.content, (Object) recordSummaryEntity.content) && Intrinsics.areEqual((Object) this.contentTemp, (Object) recordSummaryEntity.contentTemp) && Intrinsics.areEqual((Object) this.versionCode, (Object) recordSummaryEntity.versionCode) && Intrinsics.areEqual((Object) this.appName, (Object) recordSummaryEntity.appName) && Intrinsics.areEqual((Object) this.recognizeId, (Object) recordSummaryEntity.recognizeId) && Intrinsics.areEqual((Object) this.accountId, (Object) recordSummaryEntity.accountId) && Intrinsics.areEqual((Object) this.requestId, (Object) recordSummaryEntity.requestId) && Intrinsics.areEqual((Object) this.traceId, (Object) recordSummaryEntity.traceId) && this.recordId == recordSummaryEntity.recordId && Intrinsics.areEqual((Object) this.terminalTraceId, (Object) recordSummaryEntity.terminalTraceId) && this.isFinishDel == recordSummaryEntity.isFinishDel && this.isReport == recordSummaryEntity.isReport && this.isNeedRequestServer == recordSummaryEntity.isNeedRequestServer;
    }

    @NotNull
    public final String getAccountId() {
        return this.accountId;
    }

    @NotNull
    public final String getAppName() {
        return this.appName;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final String getContentTemp() {
        return this.contentTemp;
    }

    @Nullable
    public final String getFileName() {
        return this.fileName;
    }

    @Nullable
    public final String getRecognizeId() {
        return this.recognizeId;
    }

    public final long getRecordId() {
        return this.recordId;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    public final long getSummaryId() {
        return this.summaryId;
    }

    @NotNull
    public final String getTerminalTraceId() {
        return this.terminalTraceId;
    }

    @NotNull
    public final String getTraceId() {
        return this.traceId;
    }

    @Nullable
    public final String getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.summaryId) * 31;
        String str = this.fileName;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.content;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.contentTemp;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.versionCode;
        int hashCode5 = (((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.appName.hashCode()) * 31;
        String str5 = this.recognizeId;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return ((((((((((((((((hashCode5 + i) * 31) + this.accountId.hashCode()) * 31) + this.requestId.hashCode()) * 31) + this.traceId.hashCode()) * 31) + Long.hashCode(this.recordId)) * 31) + this.terminalTraceId.hashCode()) * 31) + Boolean.hashCode(this.isFinishDel)) * 31) + Boolean.hashCode(this.isReport)) * 31) + Boolean.hashCode(this.isNeedRequestServer);
    }

    public final boolean isFinishDel() {
        return this.isFinishDel;
    }

    public final boolean isNeedRequestServer() {
        return this.isNeedRequestServer;
    }

    public final boolean isReport() {
        return this.isReport;
    }

    public final void setAccountId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accountId = str;
    }

    public final void setAppName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appName = str;
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setContentTemp(@Nullable String str) {
        this.contentTemp = str;
    }

    public final void setFileName(@Nullable String str) {
        this.fileName = str;
    }

    public final void setFinishDel(boolean z) {
        this.isFinishDel = z;
    }

    public final void setNeedRequestServer(boolean z) {
        this.isNeedRequestServer = z;
    }

    public final void setRecognizeId(@Nullable String str) {
        this.recognizeId = str;
    }

    public final void setRecordId(long j) {
        this.recordId = j;
    }

    public final void setReport(boolean z) {
        this.isReport = z;
    }

    public final void setRequestId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.requestId = str;
    }

    public final void setSummaryId(long j) {
        this.summaryId = j;
    }

    public final void setTerminalTraceId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.terminalTraceId = str;
    }

    public final void setTraceId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.traceId = str;
    }

    public final void setVersionCode(@Nullable String str) {
        this.versionCode = str;
    }

    @NotNull
    public String toString() {
        long j = this.summaryId;
        String str = this.fileName;
        String str2 = this.content;
        String str3 = this.contentTemp;
        String str4 = this.versionCode;
        String str5 = this.appName;
        String str6 = this.recognizeId;
        String str7 = this.accountId;
        String str8 = this.requestId;
        String str9 = this.traceId;
        long j2 = this.recordId;
        String str10 = this.terminalTraceId;
        boolean z = this.isFinishDel;
        boolean z2 = this.isReport;
        boolean z3 = this.isNeedRequestServer;
        return "RecordSummaryEntity(summaryId=" + j + ", fileName=" + str + ", content=" + str2 + ", contentTemp=" + str3 + ", versionCode=" + str4 + ", appName=" + str5 + ", recognizeId=" + str6 + ", accountId=" + str7 + ", requestId=" + str8 + ", traceId=" + str9 + ", recordId=" + j2 + ", terminalTraceId=" + str10 + ", isFinishDel=" + z + ", isReport=" + z2 + ", isNeedRequestServer=" + z3 + ")";
    }

    public RecordSummaryEntity(long j, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull String str5, @Nullable String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, long j2, @NotNull String str10, boolean z, boolean z2, boolean z3) {
        String str11 = str7;
        String str12 = str8;
        String str13 = str9;
        String str14 = str10;
        Intrinsics.checkNotNullParameter(str5, "appName");
        Intrinsics.checkNotNullParameter(str11, "accountId");
        Intrinsics.checkNotNullParameter(str12, "requestId");
        Intrinsics.checkNotNullParameter(str13, "traceId");
        Intrinsics.checkNotNullParameter(str14, "terminalTraceId");
        this.summaryId = j;
        this.fileName = str;
        this.content = str2;
        this.contentTemp = str3;
        this.versionCode = str4;
        this.appName = str5;
        this.recognizeId = str6;
        this.accountId = str11;
        this.requestId = str12;
        this.traceId = str13;
        this.recordId = j2;
        this.terminalTraceId = str14;
        this.isFinishDel = z;
        this.isReport = z2;
        this.isNeedRequestServer = z3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RecordSummaryEntity(long r18, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, long r29, java.lang.String r31, boolean r32, boolean r33, boolean r34, int r35, kotlin.jvm.internal.DefaultConstructorMarker r36) {
        /*
            r17 = this;
            r0 = r35
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000a
            r4 = r2
            goto L_0x000c
        L_0x000a:
            r4 = r18
        L_0x000c:
            r1 = r0 & 2
            java.lang.String r6 = ""
            if (r1 == 0) goto L_0x0014
            r1 = r6
            goto L_0x0016
        L_0x0014:
            r1 = r20
        L_0x0016:
            r7 = r0 & 4
            if (r7 == 0) goto L_0x001c
            r7 = r6
            goto L_0x001e
        L_0x001c:
            r7 = r21
        L_0x001e:
            r8 = r0 & 8
            if (r8 == 0) goto L_0x0024
            r8 = r6
            goto L_0x0026
        L_0x0024:
            r8 = r22
        L_0x0026:
            r9 = r0 & 16
            if (r9 == 0) goto L_0x002c
            r9 = r6
            goto L_0x002e
        L_0x002c:
            r9 = r23
        L_0x002e:
            r10 = r0 & 32
            if (r10 == 0) goto L_0x0034
            r10 = r6
            goto L_0x0036
        L_0x0034:
            r10 = r24
        L_0x0036:
            r11 = r0 & 64
            if (r11 == 0) goto L_0x003c
            r11 = r6
            goto L_0x003e
        L_0x003c:
            r11 = r25
        L_0x003e:
            r12 = r0 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x0044
            r12 = r6
            goto L_0x0046
        L_0x0044:
            r12 = r26
        L_0x0046:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x004c
            r13 = r6
            goto L_0x004e
        L_0x004c:
            r13 = r27
        L_0x004e:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x0054
            r14 = r6
            goto L_0x0056
        L_0x0054:
            r14 = r28
        L_0x0056:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            r2 = r29
        L_0x005d:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r6 = r31
        L_0x0064:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            r16 = 0
            if (r15 == 0) goto L_0x006d
            r15 = r16
            goto L_0x006f
        L_0x006d:
            r15 = r32
        L_0x006f:
            r32 = r15
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0078
            r15 = r16
            goto L_0x007a
        L_0x0078:
            r15 = r33
        L_0x007a:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x007f
            goto L_0x0081
        L_0x007f:
            r16 = r34
        L_0x0081:
            r18 = r4
            r20 = r1
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r13
            r28 = r14
            r29 = r2
            r31 = r6
            r33 = r15
            r34 = r16
            r17.<init>(r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r31, r32, r33, r34)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity.<init>(long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
