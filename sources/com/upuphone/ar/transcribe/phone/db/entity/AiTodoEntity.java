package com.upuphone.ar.transcribe.phone.db.entity;

import androidx.annotation.Keep;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\bD\b\b\u0018\u00002\u00020\u0001B­\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012¢\u0006\u0002\u0010\u0016J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0007HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\t\u0010D\u001a\u00020\u0012HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\t\u0010G\u001a\u00020\u0012HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0007HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\t\u0010O\u001a\u00020\u0007HÆ\u0003J¶\u0001\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0012HÆ\u0001¢\u0006\u0002\u0010QJ\u0013\u0010R\u001a\u00020\u00122\b\u0010S\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010T\u001a\u00020\u0003HÖ\u0001J\t\u0010U\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001aR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001eR\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010,\"\u0004\b-\u0010.R\u001e\u0010\u0015\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010,\"\u0004\b/\u0010.R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0018\"\u0004\b5\u0010\u001aR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b6\u0010$\"\u0004\b7\u0010&R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0018\"\u0004\b9\u0010\u001aR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0018\"\u0004\b;\u0010\u001aR\u001a\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0018\"\u0004\b=\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0018\"\u0004\b?\u0010\u001a¨\u0006V"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/db/entity/AiTodoEntity;", "", "itemType", "", "title", "", "id", "", "content", "startTime", "endTime", "accountId", "recognizeId", "calendarId", "calendarEventId", "src", "deleted", "isAddedSchedule", "", "requestId", "reported", "isIsDone", "(ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/Integer;Z)V", "getAccountId", "()Ljava/lang/String;", "setAccountId", "(Ljava/lang/String;)V", "getCalendarEventId", "()J", "setCalendarEventId", "(J)V", "getCalendarId", "setCalendarId", "getContent", "setContent", "getDeleted", "()Ljava/lang/Integer;", "setDeleted", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getEndTime", "setEndTime", "getId", "setId", "()Z", "setAddedSchedule", "(Z)V", "setIsDone", "getItemType", "()I", "setItemType", "(I)V", "getRecognizeId", "setRecognizeId", "getReported", "setReported", "getRequestId", "setRequestId", "getSrc", "setSrc", "getStartTime", "setStartTime", "getTitle", "setTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/Integer;Z)Lcom/upuphone/ar/transcribe/phone/db/entity/AiTodoEntity;", "equals", "other", "hashCode", "toString", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
@Entity
public final class AiTodoEntity {
    @NotNull
    private String accountId;
    @ColumnInfo
    private long calendarEventId;
    @ColumnInfo
    private long calendarId;
    @NotNull
    private String content;
    @Nullable
    private Integer deleted;
    @NotNull
    private String endTime;
    @PrimaryKey
    private long id;
    @Ignore
    private boolean isAddedSchedule;
    @ColumnInfo
    private boolean isIsDone;
    @Ignore
    private int itemType;
    @NotNull
    private String recognizeId;
    @Nullable
    private Integer reported;
    @Nullable
    private String requestId;
    @Nullable
    private String src;
    @NotNull
    private String startTime;
    @NotNull
    private String title;

    public AiTodoEntity() {
        this(0, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (Integer) null, false, (String) null, (Integer) null, false, 65535, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AiTodoEntity copy$default(AiTodoEntity aiTodoEntity, int i, String str, long j, String str2, String str3, String str4, String str5, String str6, long j2, long j3, String str7, Integer num, boolean z, String str8, Integer num2, boolean z2, int i2, Object obj) {
        AiTodoEntity aiTodoEntity2 = aiTodoEntity;
        int i3 = i2;
        return aiTodoEntity.copy((i3 & 1) != 0 ? aiTodoEntity2.itemType : i, (i3 & 2) != 0 ? aiTodoEntity2.title : str, (i3 & 4) != 0 ? aiTodoEntity2.id : j, (i3 & 8) != 0 ? aiTodoEntity2.content : str2, (i3 & 16) != 0 ? aiTodoEntity2.startTime : str3, (i3 & 32) != 0 ? aiTodoEntity2.endTime : str4, (i3 & 64) != 0 ? aiTodoEntity2.accountId : str5, (i3 & 128) != 0 ? aiTodoEntity2.recognizeId : str6, (i3 & 256) != 0 ? aiTodoEntity2.calendarId : j2, (i3 & 512) != 0 ? aiTodoEntity2.calendarEventId : j3, (i3 & 1024) != 0 ? aiTodoEntity2.src : str7, (i3 & 2048) != 0 ? aiTodoEntity2.deleted : num, (i3 & 4096) != 0 ? aiTodoEntity2.isAddedSchedule : z, (i3 & 8192) != 0 ? aiTodoEntity2.requestId : str8, (i3 & 16384) != 0 ? aiTodoEntity2.reported : num2, (i3 & 32768) != 0 ? aiTodoEntity2.isIsDone : z2);
    }

    public final int component1() {
        return this.itemType;
    }

    public final long component10() {
        return this.calendarEventId;
    }

    @Nullable
    public final String component11() {
        return this.src;
    }

    @Nullable
    public final Integer component12() {
        return this.deleted;
    }

    public final boolean component13() {
        return this.isAddedSchedule;
    }

    @Nullable
    public final String component14() {
        return this.requestId;
    }

    @Nullable
    public final Integer component15() {
        return this.reported;
    }

    public final boolean component16() {
        return this.isIsDone;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    public final long component3() {
        return this.id;
    }

    @NotNull
    public final String component4() {
        return this.content;
    }

    @NotNull
    public final String component5() {
        return this.startTime;
    }

    @NotNull
    public final String component6() {
        return this.endTime;
    }

    @NotNull
    public final String component7() {
        return this.accountId;
    }

    @NotNull
    public final String component8() {
        return this.recognizeId;
    }

    public final long component9() {
        return this.calendarId;
    }

    @NotNull
    public final AiTodoEntity copy(int i, @NotNull String str, long j, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, long j2, long j3, @Nullable String str7, @Nullable Integer num, boolean z, @Nullable String str8, @Nullable Integer num2, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(str3, "startTime");
        Intrinsics.checkNotNullParameter(str4, "endTime");
        Intrinsics.checkNotNullParameter(str5, "accountId");
        Intrinsics.checkNotNullParameter(str6, "recognizeId");
        return new AiTodoEntity(i, str, j, str2, str3, str4, str5, str6, j2, j3, str7, num, z, str8, num2, z2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AiTodoEntity)) {
            return false;
        }
        AiTodoEntity aiTodoEntity = (AiTodoEntity) obj;
        return this.itemType == aiTodoEntity.itemType && Intrinsics.areEqual((Object) this.title, (Object) aiTodoEntity.title) && this.id == aiTodoEntity.id && Intrinsics.areEqual((Object) this.content, (Object) aiTodoEntity.content) && Intrinsics.areEqual((Object) this.startTime, (Object) aiTodoEntity.startTime) && Intrinsics.areEqual((Object) this.endTime, (Object) aiTodoEntity.endTime) && Intrinsics.areEqual((Object) this.accountId, (Object) aiTodoEntity.accountId) && Intrinsics.areEqual((Object) this.recognizeId, (Object) aiTodoEntity.recognizeId) && this.calendarId == aiTodoEntity.calendarId && this.calendarEventId == aiTodoEntity.calendarEventId && Intrinsics.areEqual((Object) this.src, (Object) aiTodoEntity.src) && Intrinsics.areEqual((Object) this.deleted, (Object) aiTodoEntity.deleted) && this.isAddedSchedule == aiTodoEntity.isAddedSchedule && Intrinsics.areEqual((Object) this.requestId, (Object) aiTodoEntity.requestId) && Intrinsics.areEqual((Object) this.reported, (Object) aiTodoEntity.reported) && this.isIsDone == aiTodoEntity.isIsDone;
    }

    @NotNull
    public final String getAccountId() {
        return this.accountId;
    }

    public final long getCalendarEventId() {
        return this.calendarEventId;
    }

    public final long getCalendarId() {
        return this.calendarId;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final Integer getDeleted() {
        return this.deleted;
    }

    @NotNull
    public final String getEndTime() {
        return this.endTime;
    }

    public final long getId() {
        return this.id;
    }

    public final int getItemType() {
        return this.itemType;
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
    public final String getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((Integer.hashCode(this.itemType) * 31) + this.title.hashCode()) * 31) + Long.hashCode(this.id)) * 31) + this.content.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.endTime.hashCode()) * 31) + this.accountId.hashCode()) * 31) + this.recognizeId.hashCode()) * 31) + Long.hashCode(this.calendarId)) * 31) + Long.hashCode(this.calendarEventId)) * 31;
        String str = this.src;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.deleted;
        int hashCode3 = (((hashCode2 + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.isAddedSchedule)) * 31;
        String str2 = this.requestId;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num2 = this.reported;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return ((hashCode4 + i) * 31) + Boolean.hashCode(this.isIsDone);
    }

    public final boolean isAddedSchedule() {
        return this.isAddedSchedule;
    }

    public final boolean isIsDone() {
        return this.isIsDone;
    }

    public final void setAccountId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accountId = str;
    }

    public final void setAddedSchedule(boolean z) {
        this.isAddedSchedule = z;
    }

    public final void setCalendarEventId(long j) {
        this.calendarEventId = j;
    }

    public final void setCalendarId(long j) {
        this.calendarId = j;
    }

    public final void setContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final void setDeleted(@Nullable Integer num) {
        this.deleted = num;
    }

    public final void setEndTime(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.endTime = str;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final void setIsDone(boolean z) {
        this.isIsDone = z;
    }

    public final void setItemType(int i) {
        this.itemType = i;
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

    public final void setStartTime(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.startTime = str;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    @NotNull
    public String toString() {
        int i = this.itemType;
        String str = this.title;
        long j = this.id;
        String str2 = this.content;
        String str3 = this.startTime;
        String str4 = this.endTime;
        String str5 = this.accountId;
        String str6 = this.recognizeId;
        long j2 = this.calendarId;
        long j3 = this.calendarEventId;
        String str7 = this.src;
        Integer num = this.deleted;
        boolean z = this.isAddedSchedule;
        String str8 = this.requestId;
        Integer num2 = this.reported;
        boolean z2 = this.isIsDone;
        return "AiTodoEntity(itemType=" + i + ", title=" + str + ", id=" + j + ", content=" + str2 + ", startTime=" + str3 + ", endTime=" + str4 + ", accountId=" + str5 + ", recognizeId=" + str6 + ", calendarId=" + j2 + ", calendarEventId=" + j3 + ", src=" + str7 + ", deleted=" + num + ", isAddedSchedule=" + z + ", requestId=" + str8 + ", reported=" + num2 + ", isIsDone=" + z2 + ")";
    }

    public AiTodoEntity(int i, @NotNull String str, long j, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, long j2, long j3, @Nullable String str7, @Nullable Integer num, boolean z, @Nullable String str8, @Nullable Integer num2, boolean z2) {
        String str9 = str4;
        String str10 = str5;
        String str11 = str6;
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(str3, "startTime");
        Intrinsics.checkNotNullParameter(str9, "endTime");
        Intrinsics.checkNotNullParameter(str10, "accountId");
        Intrinsics.checkNotNullParameter(str11, "recognizeId");
        this.itemType = i;
        this.title = str;
        this.id = j;
        this.content = str2;
        this.startTime = str3;
        this.endTime = str9;
        this.accountId = str10;
        this.recognizeId = str11;
        this.calendarId = j2;
        this.calendarEventId = j3;
        this.src = str7;
        this.deleted = num;
        this.isAddedSchedule = z;
        this.requestId = str8;
        this.reported = num2;
        this.isIsDone = z2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AiTodoEntity(int r19, java.lang.String r20, long r21, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, long r28, long r30, java.lang.String r32, java.lang.Integer r33, boolean r34, java.lang.String r35, java.lang.Integer r36, boolean r37, int r38, kotlin.jvm.internal.DefaultConstructorMarker r39) {
        /*
            r18 = this;
            r0 = r38
            r1 = r0 & 1
            r2 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            if (r1 == 0) goto L_0x000d
            r1 = r2
            goto L_0x000f
        L_0x000d:
            r1 = r19
        L_0x000f:
            r4 = r0 & 2
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x0017
            r4 = r5
            goto L_0x0019
        L_0x0017:
            r4 = r20
        L_0x0019:
            r6 = r0 & 4
            r7 = 0
            if (r6 == 0) goto L_0x0021
            r9 = r7
            goto L_0x0023
        L_0x0021:
            r9 = r21
        L_0x0023:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0029
            r6 = r5
            goto L_0x002b
        L_0x0029:
            r6 = r23
        L_0x002b:
            r11 = r0 & 16
            if (r11 == 0) goto L_0x0031
            r11 = r5
            goto L_0x0033
        L_0x0031:
            r11 = r24
        L_0x0033:
            r12 = r0 & 32
            if (r12 == 0) goto L_0x0039
            r12 = r5
            goto L_0x003b
        L_0x0039:
            r12 = r25
        L_0x003b:
            r13 = r0 & 64
            if (r13 == 0) goto L_0x0041
            r13 = r5
            goto L_0x0043
        L_0x0041:
            r13 = r26
        L_0x0043:
            r14 = r0 & 128(0x80, float:1.794E-43)
            if (r14 == 0) goto L_0x0049
            r14 = r5
            goto L_0x004b
        L_0x0049:
            r14 = r27
        L_0x004b:
            r15 = r0 & 256(0x100, float:3.59E-43)
            if (r15 == 0) goto L_0x0051
            r15 = r7
            goto L_0x0053
        L_0x0051:
            r15 = r28
        L_0x0053:
            r2 = r0 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0058
            goto L_0x005a
        L_0x0058:
            r7 = r30
        L_0x005a:
            r2 = r0 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x0060
            r2 = r5
            goto L_0x0062
        L_0x0060:
            r2 = r32
        L_0x0062:
            r17 = r3
            r3 = r0 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x006b
            r3 = r17
            goto L_0x006d
        L_0x006b:
            r3 = r33
        L_0x006d:
            r19 = r5
            r5 = r0 & 4096(0x1000, float:5.74E-42)
            if (r5 == 0) goto L_0x0075
            r5 = 0
            goto L_0x0077
        L_0x0075:
            r5 = r34
        L_0x0077:
            r34 = r5
            r5 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x0080
            r5 = r19
            goto L_0x0082
        L_0x0080:
            r5 = r35
        L_0x0082:
            r35 = r5
            r5 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r5 == 0) goto L_0x0089
            goto L_0x008b
        L_0x0089:
            r17 = r36
        L_0x008b:
            r5 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r5
            if (r0 == 0) goto L_0x0093
            r0 = 0
            goto L_0x0095
        L_0x0093:
            r0 = r37
        L_0x0095:
            r19 = r1
            r20 = r4
            r21 = r9
            r23 = r6
            r24 = r11
            r25 = r12
            r26 = r13
            r27 = r14
            r28 = r15
            r30 = r7
            r32 = r2
            r33 = r3
            r36 = r17
            r37 = r0
            r18.<init>(r19, r20, r21, r23, r24, r25, r26, r27, r28, r30, r32, r33, r34, r35, r36, r37)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity.<init>(int, java.lang.String, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, java.lang.Integer, boolean, java.lang.String, java.lang.Integer, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
