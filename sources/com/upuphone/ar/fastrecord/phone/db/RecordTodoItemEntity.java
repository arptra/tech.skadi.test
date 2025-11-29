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

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\bG\b\b\u0018\u00002\u00020\u0001B»\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000f¢\u0006\u0002\u0010\u0018J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u000fHÆ\u0003J\t\u0010A\u001a\u00020\u000fHÆ\u0003J\t\u0010B\u001a\u00020\u000fHÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u000fHÆ\u0003J\t\u0010F\u001a\u00020\u000fHÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u000fHÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010P\u001a\u00020\rHÆ\u0003J¿\u0001\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u000fHÆ\u0001J\u0013\u0010R\u001a\u00020\u000f2\b\u0010S\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010T\u001a\u00020\rHÖ\u0001J\t\u0010U\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0013\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010'\"\u0004\b(\u0010)R\u001a\u0010\u0011\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010'\"\u0004\b*\u0010)R\u001a\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010'\"\u0004\b+\u0010)R\u001a\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010'\"\u0004\b,\u0010)R\u001e\u0010\u0017\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010'\"\u0004\b-\u0010)R\u001e\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010'\"\u0004\b.\u0010)R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001a\"\u0004\b2\u0010\u001cR\u001e\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010 \"\u0004\b6\u0010\"R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001a\"\u0004\b8\u0010\u001cR\u001a\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010 \"\u0004\b:\u0010\"R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006V"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/db/RecordTodoItemEntity;", "", "todoItemId", "", "recognizeId", "", "recordId", "start_time", "end_time", "todoTitle", "content", "contentTemp", "viewType", "", "isAddSchedule", "", "isFinish", "isEdit", "calendarId", "calendarEventId", "isFinishDel", "isReport", "requestId", "isNeedRequestServer", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZZJJZZLjava/lang/String;Z)V", "getCalendarEventId", "()J", "setCalendarEventId", "(J)V", "getCalendarId", "setCalendarId", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getContentTemp", "setContentTemp", "getEnd_time", "setEnd_time", "()Z", "setAddSchedule", "(Z)V", "setEdit", "setFinish", "setFinishDel", "setNeedRequestServer", "setReport", "getRecognizeId", "setRecognizeId", "getRecordId", "setRecordId", "getRequestId", "setRequestId", "getStart_time", "setStart_time", "getTodoItemId", "setTodoItemId", "getTodoTitle", "setTodoTitle", "getViewType", "()I", "setViewType", "(I)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
@Entity
public final class RecordTodoItemEntity {
    private long calendarEventId;
    private long calendarId;
    @NotNull
    private String content;
    @Nullable
    private String contentTemp;
    @NotNull
    private String end_time;
    private boolean isAddSchedule;
    private boolean isEdit;
    private boolean isFinish;
    private boolean isFinishDel;
    @ColumnInfo
    private boolean isNeedRequestServer;
    @ColumnInfo
    private boolean isReport;
    @NotNull
    private String recognizeId;
    private long recordId;
    @ColumnInfo
    @NotNull
    private String requestId;
    @NotNull
    private String start_time;
    @PrimaryKey
    private long todoItemId;
    @NotNull
    private String todoTitle;
    private int viewType;

    public RecordTodoItemEntity() {
        this(0, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 0, false, false, false, 0, 0, false, false, (String) null, false, 262143, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RecordTodoItemEntity copy$default(RecordTodoItemEntity recordTodoItemEntity, long j, String str, long j2, String str2, String str3, String str4, String str5, String str6, int i, boolean z, boolean z2, boolean z3, long j3, long j4, boolean z4, boolean z5, String str7, boolean z6, int i2, Object obj) {
        RecordTodoItemEntity recordTodoItemEntity2 = recordTodoItemEntity;
        int i3 = i2;
        return recordTodoItemEntity.copy((i3 & 1) != 0 ? recordTodoItemEntity2.todoItemId : j, (i3 & 2) != 0 ? recordTodoItemEntity2.recognizeId : str, (i3 & 4) != 0 ? recordTodoItemEntity2.recordId : j2, (i3 & 8) != 0 ? recordTodoItemEntity2.start_time : str2, (i3 & 16) != 0 ? recordTodoItemEntity2.end_time : str3, (i3 & 32) != 0 ? recordTodoItemEntity2.todoTitle : str4, (i3 & 64) != 0 ? recordTodoItemEntity2.content : str5, (i3 & 128) != 0 ? recordTodoItemEntity2.contentTemp : str6, (i3 & 256) != 0 ? recordTodoItemEntity2.viewType : i, (i3 & 512) != 0 ? recordTodoItemEntity2.isAddSchedule : z, (i3 & 1024) != 0 ? recordTodoItemEntity2.isFinish : z2, (i3 & 2048) != 0 ? recordTodoItemEntity2.isEdit : z3, (i3 & 4096) != 0 ? recordTodoItemEntity2.calendarId : j3, (i3 & 8192) != 0 ? recordTodoItemEntity2.calendarEventId : j4, (i3 & 16384) != 0 ? recordTodoItemEntity2.isFinishDel : z4, (32768 & i3) != 0 ? recordTodoItemEntity2.isReport : z5, (i3 & 65536) != 0 ? recordTodoItemEntity2.requestId : str7, (i3 & 131072) != 0 ? recordTodoItemEntity2.isNeedRequestServer : z6);
    }

    public final long component1() {
        return this.todoItemId;
    }

    public final boolean component10() {
        return this.isAddSchedule;
    }

    public final boolean component11() {
        return this.isFinish;
    }

    public final boolean component12() {
        return this.isEdit;
    }

    public final long component13() {
        return this.calendarId;
    }

    public final long component14() {
        return this.calendarEventId;
    }

    public final boolean component15() {
        return this.isFinishDel;
    }

    public final boolean component16() {
        return this.isReport;
    }

    @NotNull
    public final String component17() {
        return this.requestId;
    }

    public final boolean component18() {
        return this.isNeedRequestServer;
    }

    @NotNull
    public final String component2() {
        return this.recognizeId;
    }

    public final long component3() {
        return this.recordId;
    }

    @NotNull
    public final String component4() {
        return this.start_time;
    }

    @NotNull
    public final String component5() {
        return this.end_time;
    }

    @NotNull
    public final String component6() {
        return this.todoTitle;
    }

    @NotNull
    public final String component7() {
        return this.content;
    }

    @Nullable
    public final String component8() {
        return this.contentTemp;
    }

    public final int component9() {
        return this.viewType;
    }

    @NotNull
    public final RecordTodoItemEntity copy(long j, @NotNull String str, long j2, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable String str6, int i, boolean z, boolean z2, boolean z3, long j3, long j4, boolean z4, boolean z5, @NotNull String str7, boolean z6) {
        Intrinsics.checkNotNullParameter(str, "recognizeId");
        Intrinsics.checkNotNullParameter(str2, "start_time");
        Intrinsics.checkNotNullParameter(str3, "end_time");
        Intrinsics.checkNotNullParameter(str4, "todoTitle");
        Intrinsics.checkNotNullParameter(str5, "content");
        Intrinsics.checkNotNullParameter(str7, "requestId");
        return new RecordTodoItemEntity(j, str, j2, str2, str3, str4, str5, str6, i, z, z2, z3, j3, j4, z4, z5, str7, z6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordTodoItemEntity)) {
            return false;
        }
        RecordTodoItemEntity recordTodoItemEntity = (RecordTodoItemEntity) obj;
        return this.todoItemId == recordTodoItemEntity.todoItemId && Intrinsics.areEqual((Object) this.recognizeId, (Object) recordTodoItemEntity.recognizeId) && this.recordId == recordTodoItemEntity.recordId && Intrinsics.areEqual((Object) this.start_time, (Object) recordTodoItemEntity.start_time) && Intrinsics.areEqual((Object) this.end_time, (Object) recordTodoItemEntity.end_time) && Intrinsics.areEqual((Object) this.todoTitle, (Object) recordTodoItemEntity.todoTitle) && Intrinsics.areEqual((Object) this.content, (Object) recordTodoItemEntity.content) && Intrinsics.areEqual((Object) this.contentTemp, (Object) recordTodoItemEntity.contentTemp) && this.viewType == recordTodoItemEntity.viewType && this.isAddSchedule == recordTodoItemEntity.isAddSchedule && this.isFinish == recordTodoItemEntity.isFinish && this.isEdit == recordTodoItemEntity.isEdit && this.calendarId == recordTodoItemEntity.calendarId && this.calendarEventId == recordTodoItemEntity.calendarEventId && this.isFinishDel == recordTodoItemEntity.isFinishDel && this.isReport == recordTodoItemEntity.isReport && Intrinsics.areEqual((Object) this.requestId, (Object) recordTodoItemEntity.requestId) && this.isNeedRequestServer == recordTodoItemEntity.isNeedRequestServer;
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
    public final String getContentTemp() {
        return this.contentTemp;
    }

    @NotNull
    public final String getEnd_time() {
        return this.end_time;
    }

    @NotNull
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

    @NotNull
    public final String getStart_time() {
        return this.start_time;
    }

    public final long getTodoItemId() {
        return this.todoItemId;
    }

    @NotNull
    public final String getTodoTitle() {
        return this.todoTitle;
    }

    public final int getViewType() {
        return this.viewType;
    }

    public int hashCode() {
        int hashCode = ((((((((((((Long.hashCode(this.todoItemId) * 31) + this.recognizeId.hashCode()) * 31) + Long.hashCode(this.recordId)) * 31) + this.start_time.hashCode()) * 31) + this.end_time.hashCode()) * 31) + this.todoTitle.hashCode()) * 31) + this.content.hashCode()) * 31;
        String str = this.contentTemp;
        return ((((((((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.viewType)) * 31) + Boolean.hashCode(this.isAddSchedule)) * 31) + Boolean.hashCode(this.isFinish)) * 31) + Boolean.hashCode(this.isEdit)) * 31) + Long.hashCode(this.calendarId)) * 31) + Long.hashCode(this.calendarEventId)) * 31) + Boolean.hashCode(this.isFinishDel)) * 31) + Boolean.hashCode(this.isReport)) * 31) + this.requestId.hashCode()) * 31) + Boolean.hashCode(this.isNeedRequestServer);
    }

    public final boolean isAddSchedule() {
        return this.isAddSchedule;
    }

    public final boolean isEdit() {
        return this.isEdit;
    }

    public final boolean isFinish() {
        return this.isFinish;
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

    public final void setAddSchedule(boolean z) {
        this.isAddSchedule = z;
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

    public final void setContentTemp(@Nullable String str) {
        this.contentTemp = str;
    }

    public final void setEdit(boolean z) {
        this.isEdit = z;
    }

    public final void setEnd_time(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.end_time = str;
    }

    public final void setFinish(boolean z) {
        this.isFinish = z;
    }

    public final void setFinishDel(boolean z) {
        this.isFinishDel = z;
    }

    public final void setNeedRequestServer(boolean z) {
        this.isNeedRequestServer = z;
    }

    public final void setRecognizeId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
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

    public final void setStart_time(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.start_time = str;
    }

    public final void setTodoItemId(long j) {
        this.todoItemId = j;
    }

    public final void setTodoTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.todoTitle = str;
    }

    public final void setViewType(int i) {
        this.viewType = i;
    }

    @NotNull
    public String toString() {
        long j = this.todoItemId;
        String str = this.recognizeId;
        long j2 = this.recordId;
        String str2 = this.start_time;
        String str3 = this.end_time;
        String str4 = this.todoTitle;
        String str5 = this.content;
        String str6 = this.contentTemp;
        int i = this.viewType;
        boolean z = this.isAddSchedule;
        boolean z2 = this.isFinish;
        boolean z3 = this.isEdit;
        long j3 = this.calendarId;
        long j4 = this.calendarEventId;
        boolean z4 = this.isFinishDel;
        boolean z5 = this.isReport;
        String str7 = this.requestId;
        boolean z6 = this.isNeedRequestServer;
        return "RecordTodoItemEntity(todoItemId=" + j + ", recognizeId=" + str + ", recordId=" + j2 + ", start_time=" + str2 + ", end_time=" + str3 + ", todoTitle=" + str4 + ", content=" + str5 + ", contentTemp=" + str6 + ", viewType=" + i + ", isAddSchedule=" + z + ", isFinish=" + z2 + ", isEdit=" + z3 + ", calendarId=" + j3 + ", calendarEventId=" + j4 + ", isFinishDel=" + z4 + ", isReport=" + z5 + ", requestId=" + str7 + ", isNeedRequestServer=" + z6 + ")";
    }

    public RecordTodoItemEntity(long j, @NotNull String str, long j2, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable String str6, int i, boolean z, boolean z2, boolean z3, long j3, long j4, boolean z4, boolean z5, @NotNull String str7, boolean z6) {
        String str8 = str3;
        String str9 = str4;
        String str10 = str5;
        String str11 = str7;
        Intrinsics.checkNotNullParameter(str, "recognizeId");
        Intrinsics.checkNotNullParameter(str2, "start_time");
        Intrinsics.checkNotNullParameter(str8, "end_time");
        Intrinsics.checkNotNullParameter(str9, "todoTitle");
        Intrinsics.checkNotNullParameter(str10, "content");
        Intrinsics.checkNotNullParameter(str11, "requestId");
        this.todoItemId = j;
        this.recognizeId = str;
        this.recordId = j2;
        this.start_time = str2;
        this.end_time = str8;
        this.todoTitle = str9;
        this.content = str10;
        this.contentTemp = str6;
        this.viewType = i;
        this.isAddSchedule = z;
        this.isFinish = z2;
        this.isEdit = z3;
        this.calendarId = j3;
        this.calendarEventId = j4;
        this.isFinishDel = z4;
        this.isReport = z5;
        this.requestId = str11;
        this.isNeedRequestServer = z6;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RecordTodoItemEntity(long r24, java.lang.String r26, long r27, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, int r34, boolean r35, boolean r36, boolean r37, long r38, long r40, boolean r42, boolean r43, java.lang.String r44, boolean r45, int r46, kotlin.jvm.internal.DefaultConstructorMarker r47) {
        /*
            r23 = this;
            r0 = r46
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            r4 = 0
            goto L_0x000b
        L_0x0009:
            r4 = r24
        L_0x000b:
            r1 = r0 & 2
            java.lang.String r6 = ""
            if (r1 == 0) goto L_0x0013
            r1 = r6
            goto L_0x0015
        L_0x0013:
            r1 = r26
        L_0x0015:
            r7 = r0 & 4
            if (r7 == 0) goto L_0x001c
            r7 = 0
            goto L_0x001e
        L_0x001c:
            r7 = r27
        L_0x001e:
            r9 = r0 & 8
            if (r9 == 0) goto L_0x0024
            r9 = r6
            goto L_0x0026
        L_0x0024:
            r9 = r29
        L_0x0026:
            r10 = r0 & 16
            if (r10 == 0) goto L_0x002c
            r10 = r6
            goto L_0x002e
        L_0x002c:
            r10 = r30
        L_0x002e:
            r11 = r0 & 32
            if (r11 == 0) goto L_0x0034
            r11 = r6
            goto L_0x0036
        L_0x0034:
            r11 = r31
        L_0x0036:
            r12 = r0 & 64
            if (r12 == 0) goto L_0x003c
            r12 = r6
            goto L_0x003e
        L_0x003c:
            r12 = r32
        L_0x003e:
            r13 = r0 & 128(0x80, float:1.794E-43)
            if (r13 == 0) goto L_0x0044
            r13 = r6
            goto L_0x0046
        L_0x0044:
            r13 = r33
        L_0x0046:
            r14 = r0 & 256(0x100, float:3.59E-43)
            if (r14 == 0) goto L_0x004c
            r14 = 0
            goto L_0x004e
        L_0x004c:
            r14 = r34
        L_0x004e:
            r2 = r0 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0054
            r2 = 0
            goto L_0x0056
        L_0x0054:
            r2 = r35
        L_0x0056:
            r3 = r0 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x005c
            r3 = 0
            goto L_0x005e
        L_0x005c:
            r3 = r36
        L_0x005e:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x0064
            r15 = 0
            goto L_0x0066
        L_0x0064:
            r15 = r37
        L_0x0066:
            r25 = r6
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x006f
            r18 = 0
            goto L_0x0071
        L_0x006f:
            r18 = r38
        L_0x0071:
            r6 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x0078
            r16 = 0
            goto L_0x007a
        L_0x0078:
            r16 = r40
        L_0x007a:
            r6 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x0080
            r6 = 0
            goto L_0x0082
        L_0x0080:
            r6 = r42
        L_0x0082:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x008c
            r20 = 0
            goto L_0x008e
        L_0x008c:
            r20 = r43
        L_0x008e:
            r21 = 65536(0x10000, float:9.18355E-41)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x0097
            r21 = r25
            goto L_0x0099
        L_0x0097:
            r21 = r44
        L_0x0099:
            r22 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r22
            if (r0 == 0) goto L_0x00a1
            r0 = 0
            goto L_0x00a3
        L_0x00a1:
            r0 = r45
        L_0x00a3:
            r24 = r4
            r26 = r1
            r27 = r7
            r29 = r9
            r30 = r10
            r31 = r11
            r32 = r12
            r33 = r13
            r34 = r14
            r35 = r2
            r36 = r3
            r37 = r15
            r38 = r18
            r40 = r16
            r42 = r6
            r43 = r20
            r44 = r21
            r45 = r0
            r23.<init>(r24, r26, r27, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r40, r42, r43, r44, r45)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity.<init>(long, java.lang.String, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, boolean, boolean, boolean, long, long, boolean, boolean, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
