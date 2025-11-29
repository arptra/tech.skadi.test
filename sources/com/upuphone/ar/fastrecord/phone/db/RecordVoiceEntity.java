package com.upuphone.ar.fastrecord.phone.db;

import androidx.annotation.Keep;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000eJ\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jy\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012¨\u00068"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/db/RecordVoiceEntity;", "", "recordVoiceId", "", "userId", "", "recordId", "cacheFileDir", "cachePcmFilePath", "cacheOPlusFilePath", "startTag", "endTag", "tagInfo", "role", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;)V", "getCacheFileDir", "()Ljava/lang/String;", "setCacheFileDir", "(Ljava/lang/String;)V", "getCacheOPlusFilePath", "setCacheOPlusFilePath", "getCachePcmFilePath", "setCachePcmFilePath", "getEndTag", "()J", "setEndTag", "(J)V", "getRecordId", "setRecordId", "getRecordVoiceId", "setRecordVoiceId", "getRole", "setRole", "getStartTag", "setStartTag", "getTagInfo", "setTagInfo", "getUserId", "setUserId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
@Entity
public final class RecordVoiceEntity {
    @Nullable
    private String cacheFileDir;
    @Nullable
    private String cacheOPlusFilePath;
    @Nullable
    private String cachePcmFilePath;
    private long endTag;
    private long recordId;
    @PrimaryKey
    private long recordVoiceId;
    @Nullable
    private String role;
    private long startTag;
    @Nullable
    private String tagInfo;
    @Nullable
    private String userId;

    public RecordVoiceEntity() {
        this(0, (String) null, 0, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, 1023, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RecordVoiceEntity copy$default(RecordVoiceEntity recordVoiceEntity, long j, String str, long j2, String str2, String str3, String str4, long j3, long j4, String str5, String str6, int i, Object obj) {
        RecordVoiceEntity recordVoiceEntity2 = recordVoiceEntity;
        int i2 = i;
        return recordVoiceEntity.copy((i2 & 1) != 0 ? recordVoiceEntity2.recordVoiceId : j, (i2 & 2) != 0 ? recordVoiceEntity2.userId : str, (i2 & 4) != 0 ? recordVoiceEntity2.recordId : j2, (i2 & 8) != 0 ? recordVoiceEntity2.cacheFileDir : str2, (i2 & 16) != 0 ? recordVoiceEntity2.cachePcmFilePath : str3, (i2 & 32) != 0 ? recordVoiceEntity2.cacheOPlusFilePath : str4, (i2 & 64) != 0 ? recordVoiceEntity2.startTag : j3, (i2 & 128) != 0 ? recordVoiceEntity2.endTag : j4, (i2 & 256) != 0 ? recordVoiceEntity2.tagInfo : str5, (i2 & 512) != 0 ? recordVoiceEntity2.role : str6);
    }

    public final long component1() {
        return this.recordVoiceId;
    }

    @Nullable
    public final String component10() {
        return this.role;
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
        return this.cacheFileDir;
    }

    @Nullable
    public final String component5() {
        return this.cachePcmFilePath;
    }

    @Nullable
    public final String component6() {
        return this.cacheOPlusFilePath;
    }

    public final long component7() {
        return this.startTag;
    }

    public final long component8() {
        return this.endTag;
    }

    @Nullable
    public final String component9() {
        return this.tagInfo;
    }

    @NotNull
    public final RecordVoiceEntity copy(long j, @Nullable String str, long j2, @Nullable String str2, @Nullable String str3, @Nullable String str4, long j3, long j4, @Nullable String str5, @Nullable String str6) {
        return new RecordVoiceEntity(j, str, j2, str2, str3, str4, j3, j4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordVoiceEntity)) {
            return false;
        }
        RecordVoiceEntity recordVoiceEntity = (RecordVoiceEntity) obj;
        return this.recordVoiceId == recordVoiceEntity.recordVoiceId && Intrinsics.areEqual((Object) this.userId, (Object) recordVoiceEntity.userId) && this.recordId == recordVoiceEntity.recordId && Intrinsics.areEqual((Object) this.cacheFileDir, (Object) recordVoiceEntity.cacheFileDir) && Intrinsics.areEqual((Object) this.cachePcmFilePath, (Object) recordVoiceEntity.cachePcmFilePath) && Intrinsics.areEqual((Object) this.cacheOPlusFilePath, (Object) recordVoiceEntity.cacheOPlusFilePath) && this.startTag == recordVoiceEntity.startTag && this.endTag == recordVoiceEntity.endTag && Intrinsics.areEqual((Object) this.tagInfo, (Object) recordVoiceEntity.tagInfo) && Intrinsics.areEqual((Object) this.role, (Object) recordVoiceEntity.role);
    }

    @Nullable
    public final String getCacheFileDir() {
        return this.cacheFileDir;
    }

    @Nullable
    public final String getCacheOPlusFilePath() {
        return this.cacheOPlusFilePath;
    }

    @Nullable
    public final String getCachePcmFilePath() {
        return this.cachePcmFilePath;
    }

    public final long getEndTag() {
        return this.endTag;
    }

    public final long getRecordId() {
        return this.recordId;
    }

    public final long getRecordVoiceId() {
        return this.recordVoiceId;
    }

    @Nullable
    public final String getRole() {
        return this.role;
    }

    public final long getStartTag() {
        return this.startTag;
    }

    @Nullable
    public final String getTagInfo() {
        return this.tagInfo;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.recordVoiceId) * 31;
        String str = this.userId;
        int i = 0;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.recordId)) * 31;
        String str2 = this.cacheFileDir;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.cachePcmFilePath;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.cacheOPlusFilePath;
        int hashCode5 = (((((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + Long.hashCode(this.startTag)) * 31) + Long.hashCode(this.endTag)) * 31;
        String str5 = this.tagInfo;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.role;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode6 + i;
    }

    public final void setCacheFileDir(@Nullable String str) {
        this.cacheFileDir = str;
    }

    public final void setCacheOPlusFilePath(@Nullable String str) {
        this.cacheOPlusFilePath = str;
    }

    public final void setCachePcmFilePath(@Nullable String str) {
        this.cachePcmFilePath = str;
    }

    public final void setEndTag(long j) {
        this.endTag = j;
    }

    public final void setRecordId(long j) {
        this.recordId = j;
    }

    public final void setRecordVoiceId(long j) {
        this.recordVoiceId = j;
    }

    public final void setRole(@Nullable String str) {
        this.role = str;
    }

    public final void setStartTag(long j) {
        this.startTag = j;
    }

    public final void setTagInfo(@Nullable String str) {
        this.tagInfo = str;
    }

    public final void setUserId(@Nullable String str) {
        this.userId = str;
    }

    @NotNull
    public String toString() {
        long j = this.recordVoiceId;
        String str = this.userId;
        long j2 = this.recordId;
        String str2 = this.cacheFileDir;
        String str3 = this.cachePcmFilePath;
        String str4 = this.cacheOPlusFilePath;
        long j3 = this.startTag;
        long j4 = this.endTag;
        String str5 = this.tagInfo;
        String str6 = this.role;
        return "RecordVoiceEntity(recordVoiceId=" + j + ", userId=" + str + ", recordId=" + j2 + ", cacheFileDir=" + str2 + ", cachePcmFilePath=" + str3 + ", cacheOPlusFilePath=" + str4 + ", startTag=" + j3 + ", endTag=" + j4 + ", tagInfo=" + str5 + ", role=" + str6 + ")";
    }

    public RecordVoiceEntity(long j, @Nullable String str, long j2, @Nullable String str2, @Nullable String str3, @Nullable String str4, long j3, long j4, @Nullable String str5, @Nullable String str6) {
        this.recordVoiceId = j;
        this.userId = str;
        this.recordId = j2;
        this.cacheFileDir = str2;
        this.cachePcmFilePath = str3;
        this.cacheOPlusFilePath = str4;
        this.startTag = j3;
        this.endTag = j4;
        this.tagInfo = str5;
        this.role = str6;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RecordVoiceEntity(long r16, java.lang.String r18, long r19, java.lang.String r21, java.lang.String r22, java.lang.String r23, long r24, long r26, java.lang.String r28, java.lang.String r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r15 = this;
            r0 = r30
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000a
            r4 = r2
            goto L_0x000c
        L_0x000a:
            r4 = r16
        L_0x000c:
            r1 = r0 & 2
            r6 = 0
            if (r1 == 0) goto L_0x0013
            r1 = r6
            goto L_0x0015
        L_0x0013:
            r1 = r18
        L_0x0015:
            r7 = r0 & 4
            if (r7 == 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r2 = r19
        L_0x001c:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x0022
            r7 = r6
            goto L_0x0024
        L_0x0022:
            r7 = r21
        L_0x0024:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x002a
            r8 = r6
            goto L_0x002c
        L_0x002a:
            r8 = r22
        L_0x002c:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x0032
            r9 = r6
            goto L_0x0034
        L_0x0032:
            r9 = r23
        L_0x0034:
            r10 = r0 & 64
            r11 = -1
            if (r10 == 0) goto L_0x003c
            r13 = r11
            goto L_0x003e
        L_0x003c:
            r13 = r24
        L_0x003e:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r11 = r26
        L_0x0045:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004b
            r10 = r6
            goto L_0x004d
        L_0x004b:
            r10 = r28
        L_0x004d:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            r6 = r29
        L_0x0054:
            r16 = r4
            r18 = r1
            r19 = r2
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r13
            r26 = r11
            r28 = r10
            r29 = r6
            r15.<init>(r16, r18, r19, r21, r22, r23, r24, r26, r28, r29)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.db.RecordVoiceEntity.<init>(long, java.lang.String, long, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
