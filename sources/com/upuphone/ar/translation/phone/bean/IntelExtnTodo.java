package com.upuphone.ar.translation.phone.bean;

import androidx.annotation.Keep;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.xjsd.xr.sapp.asr.utils.AsrExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010<\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020\"8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u001e\u0010(\u001a\u00020\"8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\u001e\u0010*\u001a\u00020\u00168\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR\u001e\u0010-\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001e\u00103\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001a\u00106\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\u001e\u00109\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\b¨\u0006="}, d2 = {"Lcom/upuphone/ar/translation/phone/bean/IntelExtnTodo;", "", "()V", "accountId", "", "getAccountId", "()Ljava/lang/String;", "setAccountId", "(Ljava/lang/String;)V", "calendarEventId", "", "getCalendarEventId", "()J", "setCalendarEventId", "(J)V", "calendarId", "getCalendarId", "setCalendarId", "content", "getContent", "setContent", "deleteStatus", "", "getDeleteStatus", "()I", "setDeleteStatus", "(I)V", "endTime", "getEndTime", "setEndTime", "id", "getId", "setId", "isAddedSchedule", "", "()Z", "setAddedSchedule", "(Z)V", "isIsDone", "setIsDone", "isReported", "setReported", "itemType", "getItemType", "setItemType", "originalContent", "getOriginalContent", "setOriginalContent", "recognizeId", "getRecognizeId", "setRecognizeId", "requestId", "getRequestId", "setRequestId", "startTime", "getStartTime", "setStartTime", "title", "getTitle", "setTitle", "toString", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
@Entity
public final class IntelExtnTodo {
    @NotNull
    private String accountId = "";
    @ColumnInfo
    private long calendarEventId;
    @ColumnInfo
    private long calendarId;
    @NotNull
    private String content = "";
    @ColumnInfo
    private int deleteStatus;
    @NotNull
    private String endTime = "";
    @PrimaryKey
    private long id;
    @ColumnInfo
    private boolean isAddedSchedule;
    @ColumnInfo
    private boolean isIsDone;
    @ColumnInfo
    private boolean isReported;
    @Ignore
    private int itemType;
    @ColumnInfo
    @NotNull
    private String originalContent = "";
    @NotNull
    private String recognizeId = "";
    @ColumnInfo
    @NotNull
    private String requestId = "";
    @NotNull
    private String startTime = "";
    @ColumnInfo
    @NotNull
    private String title = "";

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

    public final int getDeleteStatus() {
        return this.deleteStatus;
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
    public final String getOriginalContent() {
        return this.originalContent;
    }

    @NotNull
    public final String getRecognizeId() {
        return this.recognizeId;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final String getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final boolean isAddedSchedule() {
        return this.isAddedSchedule;
    }

    public final boolean isIsDone() {
        return this.isIsDone;
    }

    public final boolean isReported() {
        return this.isReported;
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

    public final void setDeleteStatus(int i) {
        this.deleteStatus = i;
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

    public final void setOriginalContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.originalContent = str;
    }

    public final void setRecognizeId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.recognizeId = str;
    }

    public final void setReported(boolean z) {
        this.isReported = z;
    }

    public final void setRequestId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.requestId = str;
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
        String str3 = this.originalContent;
        String str4 = this.startTime;
        String str5 = this.endTime;
        String mixSpecialData = AsrExtKt.mixSpecialData(this.accountId);
        String str6 = this.recognizeId;
        String str7 = this.requestId;
        long j2 = this.calendarId;
        long j3 = this.calendarEventId;
        boolean z = this.isAddedSchedule;
        boolean z2 = this.isIsDone;
        int i2 = this.deleteStatus;
        boolean z3 = this.isReported;
        return "IntelExtnTodo(itemType=" + i + ", title='" + str + "', id=" + j + ", content='" + str2 + "', originalContent='" + str3 + "', startTime='" + str4 + "', endTime='" + str5 + "', accountId='" + mixSpecialData + "', recognizeId='" + str6 + "', requestId='" + str7 + "', calendarId=" + j2 + ", calendarEventId=" + j3 + ", isAddedSchedule=" + z + ", isIsDone=" + z2 + ", deleteStatus=" + i2 + ", isReported=" + z3 + ")";
    }
}
