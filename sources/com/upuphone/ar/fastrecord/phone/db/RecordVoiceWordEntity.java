package com.upuphone.ar.fastrecord.phone.db;

import androidx.annotation.Keep;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b/\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\rHÆ\u0003J\t\u0010/\u001a\u00020\rHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00108\u001a\u00020\rHÆ\u0003J\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010:\u001a\u00020\r2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020=HÖ\u0001J\t\u0010>\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u000f\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u001a\"\u0004\b\u001d\u0010\u001cR\u001e\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010\u0019R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0013\"\u0004\b,\u0010\u0015¨\u0006?"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/db/RecordVoiceWordEntity;", "", "wordId", "", "userId", "", "recordId", "fileName", "startTime", "endTime", "wordContent", "wordContentTemp", "isFinishWord", "", "isSelect", "isEtdStatus", "roles", "(JLjava/lang/String;JLjava/lang/String;JJLjava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;)V", "getEndTime", "()J", "setEndTime", "(J)V", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "()Z", "setEtdStatus", "(Z)V", "setFinishWord", "setSelect", "getRecordId", "setRecordId", "getRoles", "setRoles", "getStartTime", "setStartTime", "getUserId", "setUserId", "getWordContent", "setWordContent", "getWordContentTemp", "setWordContentTemp", "getWordId", "setWordId", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
@Entity
public final class RecordVoiceWordEntity {
    private long endTime;
    @Nullable
    private String fileName;
    @Ignore
    private boolean isEtdStatus;
    private boolean isFinishWord;
    @Ignore
    private boolean isSelect;
    private long recordId;
    @Nullable
    private String roles;
    private long startTime;
    @Nullable
    private String userId;
    @Nullable
    private String wordContent;
    @Nullable
    private String wordContentTemp;
    @PrimaryKey
    private long wordId;

    public RecordVoiceWordEntity() {
        this(0, (String) null, 0, (String) null, 0, 0, (String) null, (String) null, false, false, false, (String) null, 4095, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RecordVoiceWordEntity copy$default(RecordVoiceWordEntity recordVoiceWordEntity, long j, String str, long j2, String str2, long j3, long j4, String str3, String str4, boolean z, boolean z2, boolean z3, String str5, int i, Object obj) {
        RecordVoiceWordEntity recordVoiceWordEntity2 = recordVoiceWordEntity;
        int i2 = i;
        return recordVoiceWordEntity.copy((i2 & 1) != 0 ? recordVoiceWordEntity2.wordId : j, (i2 & 2) != 0 ? recordVoiceWordEntity2.userId : str, (i2 & 4) != 0 ? recordVoiceWordEntity2.recordId : j2, (i2 & 8) != 0 ? recordVoiceWordEntity2.fileName : str2, (i2 & 16) != 0 ? recordVoiceWordEntity2.startTime : j3, (i2 & 32) != 0 ? recordVoiceWordEntity2.endTime : j4, (i2 & 64) != 0 ? recordVoiceWordEntity2.wordContent : str3, (i2 & 128) != 0 ? recordVoiceWordEntity2.wordContentTemp : str4, (i2 & 256) != 0 ? recordVoiceWordEntity2.isFinishWord : z, (i2 & 512) != 0 ? recordVoiceWordEntity2.isSelect : z2, (i2 & 1024) != 0 ? recordVoiceWordEntity2.isEtdStatus : z3, (i2 & 2048) != 0 ? recordVoiceWordEntity2.roles : str5);
    }

    public final long component1() {
        return this.wordId;
    }

    public final boolean component10() {
        return this.isSelect;
    }

    public final boolean component11() {
        return this.isEtdStatus;
    }

    @Nullable
    public final String component12() {
        return this.roles;
    }

    @Nullable
    public final String component2() {
        return this.userId;
    }

    public final long component3() {
        return this.recordId;
    }

    @Nullable
    public final String component4() {
        return this.fileName;
    }

    public final long component5() {
        return this.startTime;
    }

    public final long component6() {
        return this.endTime;
    }

    @Nullable
    public final String component7() {
        return this.wordContent;
    }

    @Nullable
    public final String component8() {
        return this.wordContentTemp;
    }

    public final boolean component9() {
        return this.isFinishWord;
    }

    @NotNull
    public final RecordVoiceWordEntity copy(long j, @Nullable String str, long j2, @Nullable String str2, long j3, long j4, @Nullable String str3, @Nullable String str4, boolean z, boolean z2, boolean z3, @Nullable String str5) {
        return new RecordVoiceWordEntity(j, str, j2, str2, j3, j4, str3, str4, z, z2, z3, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordVoiceWordEntity)) {
            return false;
        }
        RecordVoiceWordEntity recordVoiceWordEntity = (RecordVoiceWordEntity) obj;
        return this.wordId == recordVoiceWordEntity.wordId && Intrinsics.areEqual((Object) this.userId, (Object) recordVoiceWordEntity.userId) && this.recordId == recordVoiceWordEntity.recordId && Intrinsics.areEqual((Object) this.fileName, (Object) recordVoiceWordEntity.fileName) && this.startTime == recordVoiceWordEntity.startTime && this.endTime == recordVoiceWordEntity.endTime && Intrinsics.areEqual((Object) this.wordContent, (Object) recordVoiceWordEntity.wordContent) && Intrinsics.areEqual((Object) this.wordContentTemp, (Object) recordVoiceWordEntity.wordContentTemp) && this.isFinishWord == recordVoiceWordEntity.isFinishWord && this.isSelect == recordVoiceWordEntity.isSelect && this.isEtdStatus == recordVoiceWordEntity.isEtdStatus && Intrinsics.areEqual((Object) this.roles, (Object) recordVoiceWordEntity.roles);
    }

    public final long getEndTime() {
        return this.endTime;
    }

    @Nullable
    public final String getFileName() {
        return this.fileName;
    }

    public final long getRecordId() {
        return this.recordId;
    }

    @Nullable
    public final String getRoles() {
        return this.roles;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    @Nullable
    public final String getWordContent() {
        return this.wordContent;
    }

    @Nullable
    public final String getWordContentTemp() {
        return this.wordContentTemp;
    }

    public final long getWordId() {
        return this.wordId;
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.wordId) * 31;
        String str = this.userId;
        int i = 0;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.recordId)) * 31;
        String str2 = this.fileName;
        int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Long.hashCode(this.startTime)) * 31) + Long.hashCode(this.endTime)) * 31;
        String str3 = this.wordContent;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.wordContentTemp;
        int hashCode5 = (((((((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + Boolean.hashCode(this.isFinishWord)) * 31) + Boolean.hashCode(this.isSelect)) * 31) + Boolean.hashCode(this.isEtdStatus)) * 31;
        String str5 = this.roles;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode5 + i;
    }

    public final boolean isEtdStatus() {
        return this.isEtdStatus;
    }

    public final boolean isFinishWord() {
        return this.isFinishWord;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setEndTime(long j) {
        this.endTime = j;
    }

    public final void setEtdStatus(boolean z) {
        this.isEtdStatus = z;
    }

    public final void setFileName(@Nullable String str) {
        this.fileName = str;
    }

    public final void setFinishWord(boolean z) {
        this.isFinishWord = z;
    }

    public final void setRecordId(long j) {
        this.recordId = j;
    }

    public final void setRoles(@Nullable String str) {
        this.roles = str;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }

    public final void setStartTime(long j) {
        this.startTime = j;
    }

    public final void setUserId(@Nullable String str) {
        this.userId = str;
    }

    public final void setWordContent(@Nullable String str) {
        this.wordContent = str;
    }

    public final void setWordContentTemp(@Nullable String str) {
        this.wordContentTemp = str;
    }

    public final void setWordId(long j) {
        this.wordId = j;
    }

    @NotNull
    public String toString() {
        long j = this.wordId;
        String str = this.userId;
        long j2 = this.recordId;
        String str2 = this.fileName;
        long j3 = this.startTime;
        long j4 = this.endTime;
        String str3 = this.wordContent;
        String str4 = this.wordContentTemp;
        boolean z = this.isFinishWord;
        boolean z2 = this.isSelect;
        boolean z3 = this.isEtdStatus;
        String str5 = this.roles;
        return "RecordVoiceWordEntity(wordId=" + j + ", userId=" + str + ", recordId=" + j2 + ", fileName=" + str2 + ", startTime=" + j3 + ", endTime=" + j4 + ", wordContent=" + str3 + ", wordContentTemp=" + str4 + ", isFinishWord=" + z + ", isSelect=" + z2 + ", isEtdStatus=" + z3 + ", roles=" + str5 + ")";
    }

    public RecordVoiceWordEntity(long j, @Nullable String str, long j2, @Nullable String str2, long j3, long j4, @Nullable String str3, @Nullable String str4, boolean z, boolean z2, boolean z3, @Nullable String str5) {
        this.wordId = j;
        this.userId = str;
        this.recordId = j2;
        this.fileName = str2;
        this.startTime = j3;
        this.endTime = j4;
        this.wordContent = str3;
        this.wordContentTemp = str4;
        this.isFinishWord = z;
        this.isSelect = z2;
        this.isEtdStatus = z3;
        this.roles = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RecordVoiceWordEntity(long r17, java.lang.String r19, long r20, java.lang.String r22, long r23, long r25, java.lang.String r27, java.lang.String r28, boolean r29, boolean r30, boolean r31, java.lang.String r32, int r33, kotlin.jvm.internal.DefaultConstructorMarker r34) {
        /*
            r16 = this;
            r0 = r33
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000a
            r4 = r2
            goto L_0x000c
        L_0x000a:
            r4 = r17
        L_0x000c:
            r1 = r0 & 2
            r6 = 0
            if (r1 == 0) goto L_0x0013
            r1 = r6
            goto L_0x0015
        L_0x0013:
            r1 = r19
        L_0x0015:
            r7 = r0 & 4
            if (r7 == 0) goto L_0x001b
            r7 = r2
            goto L_0x001d
        L_0x001b:
            r7 = r20
        L_0x001d:
            r9 = r0 & 8
            if (r9 == 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r6 = r22
        L_0x0024:
            r9 = r0 & 16
            if (r9 == 0) goto L_0x002a
            r9 = r2
            goto L_0x002c
        L_0x002a:
            r9 = r23
        L_0x002c:
            r11 = r0 & 32
            if (r11 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r2 = r25
        L_0x0033:
            r11 = r0 & 64
            java.lang.String r12 = ""
            if (r11 == 0) goto L_0x003b
            r11 = r12
            goto L_0x003d
        L_0x003b:
            r11 = r27
        L_0x003d:
            r13 = r0 & 128(0x80, float:1.794E-43)
            if (r13 == 0) goto L_0x0043
            r13 = r12
            goto L_0x0045
        L_0x0043:
            r13 = r28
        L_0x0045:
            r14 = r0 & 256(0x100, float:3.59E-43)
            if (r14 == 0) goto L_0x004b
            r14 = 0
            goto L_0x004d
        L_0x004b:
            r14 = r29
        L_0x004d:
            r15 = r0 & 512(0x200, float:7.175E-43)
            if (r15 == 0) goto L_0x0053
            r15 = 0
            goto L_0x0055
        L_0x0053:
            r15 = r30
        L_0x0055:
            r18 = r12
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x005d
            r12 = 0
            goto L_0x005f
        L_0x005d:
            r12 = r31
        L_0x005f:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0066
            r0 = r18
            goto L_0x0068
        L_0x0066:
            r0 = r32
        L_0x0068:
            r17 = r4
            r19 = r1
            r20 = r7
            r22 = r6
            r23 = r9
            r25 = r2
            r27 = r11
            r28 = r13
            r29 = r14
            r30 = r15
            r31 = r12
            r32 = r0
            r16.<init>(r17, r19, r20, r22, r23, r25, r27, r28, r29, r30, r31, r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.db.RecordVoiceWordEntity.<init>(long, java.lang.String, long, java.lang.String, long, long, java.lang.String, java.lang.String, boolean, boolean, boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
