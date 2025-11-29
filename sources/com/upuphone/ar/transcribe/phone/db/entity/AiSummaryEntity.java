package com.upuphone.ar.transcribe.phone.db.entity;

import androidx.annotation.Keep;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\rJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0013Jf\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\nHÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\u001e\u0010\f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0011¨\u00064"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/db/entity/AiSummaryEntity;", "", "id", "", "accountId", "", "recognizeId", "summary", "src", "deleted", "", "requestId", "reported", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getAccountId", "()Ljava/lang/String;", "setAccountId", "(Ljava/lang/String;)V", "getDeleted", "()Ljava/lang/Integer;", "setDeleted", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getId", "()J", "setId", "(J)V", "getRecognizeId", "setRecognizeId", "getReported", "setReported", "getRequestId", "setRequestId", "getSrc", "setSrc", "getSummary", "setSummary", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/upuphone/ar/transcribe/phone/db/entity/AiSummaryEntity;", "equals", "", "other", "hashCode", "toString", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
@Entity
public final class AiSummaryEntity {
    @NotNull
    private String accountId;
    @Nullable
    private Integer deleted;
    @PrimaryKey
    private long id;
    @NotNull
    private String recognizeId;
    @Nullable
    private Integer reported;
    @Nullable
    private String requestId;
    @Nullable
    private String src;
    @NotNull
    private String summary;

    public AiSummaryEntity() {
        this(0, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AiSummaryEntity copy$default(AiSummaryEntity aiSummaryEntity, long j, String str, String str2, String str3, String str4, Integer num, String str5, Integer num2, int i, Object obj) {
        AiSummaryEntity aiSummaryEntity2 = aiSummaryEntity;
        int i2 = i;
        return aiSummaryEntity.copy((i2 & 1) != 0 ? aiSummaryEntity2.id : j, (i2 & 2) != 0 ? aiSummaryEntity2.accountId : str, (i2 & 4) != 0 ? aiSummaryEntity2.recognizeId : str2, (i2 & 8) != 0 ? aiSummaryEntity2.summary : str3, (i2 & 16) != 0 ? aiSummaryEntity2.src : str4, (i2 & 32) != 0 ? aiSummaryEntity2.deleted : num, (i2 & 64) != 0 ? aiSummaryEntity2.requestId : str5, (i2 & 128) != 0 ? aiSummaryEntity2.reported : num2);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.accountId;
    }

    @NotNull
    public final String component3() {
        return this.recognizeId;
    }

    @NotNull
    public final String component4() {
        return this.summary;
    }

    @Nullable
    public final String component5() {
        return this.src;
    }

    @Nullable
    public final Integer component6() {
        return this.deleted;
    }

    @Nullable
    public final String component7() {
        return this.requestId;
    }

    @Nullable
    public final Integer component8() {
        return this.reported;
    }

    @NotNull
    public final AiSummaryEntity copy(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable Integer num, @Nullable String str5, @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(str, "accountId");
        Intrinsics.checkNotNullParameter(str2, "recognizeId");
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str6, "summary");
        return new AiSummaryEntity(j, str, str2, str6, str4, num, str5, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AiSummaryEntity)) {
            return false;
        }
        AiSummaryEntity aiSummaryEntity = (AiSummaryEntity) obj;
        return this.id == aiSummaryEntity.id && Intrinsics.areEqual((Object) this.accountId, (Object) aiSummaryEntity.accountId) && Intrinsics.areEqual((Object) this.recognizeId, (Object) aiSummaryEntity.recognizeId) && Intrinsics.areEqual((Object) this.summary, (Object) aiSummaryEntity.summary) && Intrinsics.areEqual((Object) this.src, (Object) aiSummaryEntity.src) && Intrinsics.areEqual((Object) this.deleted, (Object) aiSummaryEntity.deleted) && Intrinsics.areEqual((Object) this.requestId, (Object) aiSummaryEntity.requestId) && Intrinsics.areEqual((Object) this.reported, (Object) aiSummaryEntity.reported);
    }

    @NotNull
    public final String getAccountId() {
        return this.accountId;
    }

    @Nullable
    public final Integer getDeleted() {
        return this.deleted;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getRecognizeId() {
        return this.recognizeId;
    }

    @Nullable
    public final Integer getReported() {
        return this.reported;
    }

    @Nullable
    public final String getRequestId() {
        return this.requestId;
    }

    @Nullable
    public final String getSrc() {
        return this.src;
    }

    @NotNull
    public final String getSummary() {
        return this.summary;
    }

    public int hashCode() {
        int hashCode = ((((((Long.hashCode(this.id) * 31) + this.accountId.hashCode()) * 31) + this.recognizeId.hashCode()) * 31) + this.summary.hashCode()) * 31;
        String str = this.src;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.deleted;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.requestId;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num2 = this.reported;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode4 + i;
    }

    public final void setAccountId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accountId = str;
    }

    public final void setDeleted(@Nullable Integer num) {
        this.deleted = num;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final void setRecognizeId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.recognizeId = str;
    }

    public final void setReported(@Nullable Integer num) {
        this.reported = num;
    }

    public final void setRequestId(@Nullable String str) {
        this.requestId = str;
    }

    public final void setSrc(@Nullable String str) {
        this.src = str;
    }

    public final void setSummary(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.summary = str;
    }

    @NotNull
    public String toString() {
        long j = this.id;
        String str = this.accountId;
        String str2 = this.recognizeId;
        String str3 = this.summary;
        String str4 = this.src;
        Integer num = this.deleted;
        String str5 = this.requestId;
        Integer num2 = this.reported;
        return "AiSummaryEntity(id=" + j + ", accountId=" + str + ", recognizeId=" + str2 + ", summary=" + str3 + ", src=" + str4 + ", deleted=" + num + ", requestId=" + str5 + ", reported=" + num2 + ")";
    }

    public AiSummaryEntity(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable Integer num, @Nullable String str5, @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(str, "accountId");
        Intrinsics.checkNotNullParameter(str2, "recognizeId");
        Intrinsics.checkNotNullParameter(str3, "summary");
        this.id = j;
        this.accountId = str;
        this.recognizeId = str2;
        this.summary = str3;
        this.src = str4;
        this.deleted = num;
        this.requestId = str5;
        this.reported = num2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AiSummaryEntity(long r12, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.Integer r18, java.lang.String r19, java.lang.Integer r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r11 = this;
            r0 = r21
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            r1 = 0
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r3 = r0 & 2
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0012
            r3 = r4
            goto L_0x0013
        L_0x0012:
            r3 = r14
        L_0x0013:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0019
            r5 = r4
            goto L_0x001a
        L_0x0019:
            r5 = r15
        L_0x001a:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0020
            r6 = r4
            goto L_0x0022
        L_0x0020:
            r6 = r16
        L_0x0022:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0028
            r7 = r4
            goto L_0x002a
        L_0x0028:
            r7 = r17
        L_0x002a:
            r8 = r0 & 32
            r9 = 0
            if (r8 == 0) goto L_0x0034
            java.lang.Integer r8 = java.lang.Integer.valueOf(r9)
            goto L_0x0036
        L_0x0034:
            r8 = r18
        L_0x0036:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r4 = r19
        L_0x003d:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0046
            java.lang.Integer r0 = java.lang.Integer.valueOf(r9)
            goto L_0x0048
        L_0x0046:
            r0 = r20
        L_0x0048:
            r12 = r1
            r14 = r3
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r4
            r20 = r0
            r11.<init>(r12, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity.<init>(long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
