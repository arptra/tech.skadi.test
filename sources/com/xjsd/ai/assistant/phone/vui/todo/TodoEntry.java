package com.xjsd.ai.assistant.phone.vui.todo;

import androidx.annotation.Keep;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0007HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010<\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010>\u001a\u00020\u0005J\t\u0010?\u001a\u00020@HÖ\u0001J\t\u0010A\u001a\u00020\u0005HÖ\u0001R \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010\u0015R\u001e\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015R\u001e\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015R \u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015¨\u0006B"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/todo/TodoEntry;", "", "id", "", "target", "", "completed", "", "startTime", "Ljava/util/Date;", "endTime", "time", "timeText", "originQuery", "createTime", "updateTime", "accountId", "(JLjava/lang/String;ZLjava/util/Date;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccountId", "()Ljava/lang/String;", "setAccountId", "(Ljava/lang/String;)V", "getCompleted", "()Z", "setCompleted", "(Z)V", "getCreateTime", "setCreateTime", "getEndTime", "()Ljava/util/Date;", "setEndTime", "(Ljava/util/Date;)V", "getId", "()J", "setId", "(J)V", "getOriginQuery", "setOriginQuery", "getStartTime", "setStartTime", "getTarget", "setTarget", "getTime", "setTime", "getTimeText", "setTimeText", "getUpdateTime", "setUpdateTime", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getTodoContent", "hashCode", "", "toString", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
@Entity
public final class TodoEntry {
    @ColumnInfo
    @Nullable
    private String accountId;
    private boolean completed;
    @ColumnInfo
    @NotNull
    private String createTime;
    @Nullable
    private Date endTime;
    @PrimaryKey
    private long id;
    @ColumnInfo
    @NotNull
    private String originQuery;
    @Nullable
    private Date startTime;
    @NotNull
    private String target;
    @ColumnInfo
    @NotNull
    private String time;
    @ColumnInfo
    @NotNull
    private String timeText;
    @ColumnInfo
    @Nullable
    private String updateTime;

    public TodoEntry(long j, @NotNull String str, boolean z, @Nullable Date date, @Nullable Date date2, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable String str6, @Nullable String str7) {
        Intrinsics.checkNotNullParameter(str, "target");
        Intrinsics.checkNotNullParameter(str2, RtspHeaders.Values.TIME);
        Intrinsics.checkNotNullParameter(str3, "timeText");
        Intrinsics.checkNotNullParameter(str4, "originQuery");
        Intrinsics.checkNotNullParameter(str5, "createTime");
        this.id = j;
        this.target = str;
        this.completed = z;
        this.startTime = date;
        this.endTime = date2;
        this.time = str2;
        this.timeText = str3;
        this.originQuery = str4;
        this.createTime = str5;
        this.updateTime = str6;
        this.accountId = str7;
    }

    public static /* synthetic */ TodoEntry copy$default(TodoEntry todoEntry, long j, String str, boolean z, Date date, Date date2, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        TodoEntry todoEntry2 = todoEntry;
        int i2 = i;
        return todoEntry.copy((i2 & 1) != 0 ? todoEntry2.id : j, (i2 & 2) != 0 ? todoEntry2.target : str, (i2 & 4) != 0 ? todoEntry2.completed : z, (i2 & 8) != 0 ? todoEntry2.startTime : date, (i2 & 16) != 0 ? todoEntry2.endTime : date2, (i2 & 32) != 0 ? todoEntry2.time : str2, (i2 & 64) != 0 ? todoEntry2.timeText : str3, (i2 & 128) != 0 ? todoEntry2.originQuery : str4, (i2 & 256) != 0 ? todoEntry2.createTime : str5, (i2 & 512) != 0 ? todoEntry2.updateTime : str6, (i2 & 1024) != 0 ? todoEntry2.accountId : str7);
    }

    public final long component1() {
        return this.id;
    }

    @Nullable
    public final String component10() {
        return this.updateTime;
    }

    @Nullable
    public final String component11() {
        return this.accountId;
    }

    @NotNull
    public final String component2() {
        return this.target;
    }

    public final boolean component3() {
        return this.completed;
    }

    @Nullable
    public final Date component4() {
        return this.startTime;
    }

    @Nullable
    public final Date component5() {
        return this.endTime;
    }

    @NotNull
    public final String component6() {
        return this.time;
    }

    @NotNull
    public final String component7() {
        return this.timeText;
    }

    @NotNull
    public final String component8() {
        return this.originQuery;
    }

    @NotNull
    public final String component9() {
        return this.createTime;
    }

    @NotNull
    public final TodoEntry copy(long j, @NotNull String str, boolean z, @Nullable Date date, @Nullable Date date2, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable String str6, @Nullable String str7) {
        String str8 = str;
        Intrinsics.checkNotNullParameter(str8, "target");
        String str9 = str2;
        Intrinsics.checkNotNullParameter(str9, RtspHeaders.Values.TIME);
        String str10 = str3;
        Intrinsics.checkNotNullParameter(str10, "timeText");
        String str11 = str4;
        Intrinsics.checkNotNullParameter(str11, "originQuery");
        String str12 = str5;
        Intrinsics.checkNotNullParameter(str12, "createTime");
        return new TodoEntry(j, str8, z, date, date2, str9, str10, str11, str12, str6, str7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TodoEntry)) {
            return false;
        }
        TodoEntry todoEntry = (TodoEntry) obj;
        return this.id == todoEntry.id && Intrinsics.areEqual((Object) this.target, (Object) todoEntry.target) && this.completed == todoEntry.completed && Intrinsics.areEqual((Object) this.startTime, (Object) todoEntry.startTime) && Intrinsics.areEqual((Object) this.endTime, (Object) todoEntry.endTime) && Intrinsics.areEqual((Object) this.time, (Object) todoEntry.time) && Intrinsics.areEqual((Object) this.timeText, (Object) todoEntry.timeText) && Intrinsics.areEqual((Object) this.originQuery, (Object) todoEntry.originQuery) && Intrinsics.areEqual((Object) this.createTime, (Object) todoEntry.createTime) && Intrinsics.areEqual((Object) this.updateTime, (Object) todoEntry.updateTime) && Intrinsics.areEqual((Object) this.accountId, (Object) todoEntry.accountId);
    }

    @Nullable
    public final String getAccountId() {
        return this.accountId;
    }

    public final boolean getCompleted() {
        return this.completed;
    }

    @NotNull
    public final String getCreateTime() {
        return this.createTime;
    }

    @Nullable
    public final Date getEndTime() {
        return this.endTime;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getOriginQuery() {
        return this.originQuery;
    }

    @Nullable
    public final Date getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final String getTarget() {
        return this.target;
    }

    @NotNull
    public final String getTime() {
        return this.time;
    }

    @NotNull
    public final String getTimeText() {
        return this.timeText;
    }

    @NotNull
    public final String getTodoContent() {
        return this.target;
    }

    @Nullable
    public final String getUpdateTime() {
        return this.updateTime;
    }

    public int hashCode() {
        int hashCode = ((((Long.hashCode(this.id) * 31) + this.target.hashCode()) * 31) + Boolean.hashCode(this.completed)) * 31;
        Date date = this.startTime;
        int i = 0;
        int hashCode2 = (hashCode + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.endTime;
        int hashCode3 = (((((((((hashCode2 + (date2 == null ? 0 : date2.hashCode())) * 31) + this.time.hashCode()) * 31) + this.timeText.hashCode()) * 31) + this.originQuery.hashCode()) * 31) + this.createTime.hashCode()) * 31;
        String str = this.updateTime;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.accountId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode4 + i;
    }

    public final void setAccountId(@Nullable String str) {
        this.accountId = str;
    }

    public final void setCompleted(boolean z) {
        this.completed = z;
    }

    public final void setCreateTime(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.createTime = str;
    }

    public final void setEndTime(@Nullable Date date) {
        this.endTime = date;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final void setOriginQuery(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.originQuery = str;
    }

    public final void setStartTime(@Nullable Date date) {
        this.startTime = date;
    }

    public final void setTarget(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.target = str;
    }

    public final void setTime(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.time = str;
    }

    public final void setTimeText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timeText = str;
    }

    public final void setUpdateTime(@Nullable String str) {
        this.updateTime = str;
    }

    @NotNull
    public String toString() {
        long j = this.id;
        String str = this.target;
        boolean z = this.completed;
        Date date = this.startTime;
        Date date2 = this.endTime;
        String str2 = this.time;
        String str3 = this.timeText;
        String str4 = this.originQuery;
        String str5 = this.createTime;
        String str6 = this.updateTime;
        String str7 = this.accountId;
        return "TodoEntry(id=" + j + ", target=" + str + ", completed=" + z + ", startTime=" + date + ", endTime=" + date2 + ", time=" + str2 + ", timeText=" + str3 + ", originQuery=" + str4 + ", createTime=" + str5 + ", updateTime=" + str6 + ", accountId=" + str7 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TodoEntry(long r17, java.lang.String r19, boolean r20, java.util.Date r21, java.util.Date r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, int r29, kotlin.jvm.internal.DefaultConstructorMarker r30) {
        /*
            r16 = this;
            r0 = r29
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000a
            r1 = 0
            r4 = r1
            goto L_0x000c
        L_0x000a:
            r4 = r17
        L_0x000c:
            r1 = r0 & 32
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0014
            r10 = r2
            goto L_0x0016
        L_0x0014:
            r10 = r23
        L_0x0016:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x001c
            r11 = r2
            goto L_0x001e
        L_0x001c:
            r11 = r24
        L_0x001e:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0024
            r12 = r2
            goto L_0x0026
        L_0x0024:
            r12 = r25
        L_0x0026:
            r3 = r16
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r13 = r26
            r14 = r27
            r15 = r28
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.vui.todo.TodoEntry.<init>(long, java.lang.String, boolean, java.util.Date, java.util.Date, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
