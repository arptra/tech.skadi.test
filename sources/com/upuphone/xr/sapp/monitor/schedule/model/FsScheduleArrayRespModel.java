package com.upuphone.xr.sapp.monitor.schedule.model;

import androidx.annotation.Keep;
import com.here.posclient.PositionEstimate;
import com.meizu.common.widget.MzContactsContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u001cB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel;", "", "hasMore", "", "items", "", "Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule;", "pageToken", "", "syncToken", "(ZLjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getHasMore", "()Z", "getItems", "()Ljava/util/List;", "getPageToken", "()Ljava/lang/String;", "getSyncToken", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "FsSchedule", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class FsScheduleArrayRespModel {
    private final boolean hasMore;
    @NotNull
    private final List<FsSchedule> items;
    @NotNull
    private final String pageToken;
    @NotNull
    private final String syncToken;

    @Keep
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bD\b\b\u0018\u00002\u00020\u0001:\b^_`abcdeBÓ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0005\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010!\u001a\u00020\"\u0012\u0006\u0010#\u001a\u00020\u0003¢\u0006\u0002\u0010$J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0013HÆ\u0003J\t\u0010F\u001a\u00020\u0015HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\u000f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0005HÆ\u0003J\u000f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0005HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\u000f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010P\u001a\u00020\"HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\tHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0010HÆ\u0003J\u0002\u0010Y\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00052\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u0003HÆ\u0001J\u0013\u0010Z\u001a\u00020\u00132\b\u0010[\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\\\u001a\u00020\tHÖ\u0001J\t\u0010]\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010&R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010&R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010&R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u00104R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010&R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010&R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010&R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010(R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010(R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010&R\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010&R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0011\u0010#\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010&¨\u0006f"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule;", "", "appLink", "", "attachments", "", "Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$Attachment;", "attendeeAbility", "color", "", "createTime", "description", "endTime", "Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$EndTime;", "eventId", "eventOrganizer", "Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$EventOrganizer;", "freeBusyStatus", "isException", "", "location", "Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$Location;", "organizerCalendarId", "recurrence", "recurringEventId", "reminders", "Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$Reminder;", "schemas", "Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$Schema;", "startTime", "Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$StartTime;", "status", "summary", "vchat", "Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$Vchat;", "visibility", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$EndTime;Ljava/lang/String;Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$EventOrganizer;Ljava/lang/String;ZLcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$Location;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$StartTime;Ljava/lang/String;Ljava/lang/String;Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$Vchat;Ljava/lang/String;)V", "getAppLink", "()Ljava/lang/String;", "getAttachments", "()Ljava/util/List;", "getAttendeeAbility", "getColor", "()I", "getCreateTime", "getDescription", "getEndTime", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$EndTime;", "getEventId", "getEventOrganizer", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$EventOrganizer;", "getFreeBusyStatus", "()Z", "getLocation", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$Location;", "getOrganizerCalendarId", "getRecurrence", "getRecurringEventId", "getReminders", "getSchemas", "getStartTime", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$StartTime;", "getStatus", "getSummary", "getVchat", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$Vchat;", "getVisibility", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Attachment", "EndTime", "EventOrganizer", "Location", "Reminder", "Schema", "StartTime", "Vchat", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FsSchedule {
        @NotNull
        private final String appLink;
        @NotNull
        private final List<Attachment> attachments;
        @NotNull
        private final String attendeeAbility;
        private final int color;
        @Nullable
        private final String createTime;
        @Nullable
        private final String description;
        @Nullable
        private final EndTime endTime;
        @Nullable
        private final String eventId;
        @NotNull
        private final EventOrganizer eventOrganizer;
        @NotNull
        private final String freeBusyStatus;
        private final boolean isException;
        @NotNull
        private final Location location;
        @NotNull
        private final String organizerCalendarId;
        @NotNull
        private final String recurrence;
        @NotNull
        private final String recurringEventId;
        @NotNull
        private final List<Reminder> reminders;
        @NotNull
        private final List<Schema> schemas;
        @Nullable
        private final StartTime startTime;
        @NotNull
        private final String status;
        @Nullable
        private final String summary;
        @NotNull
        private final Vchat vchat;
        @NotNull
        private final String visibility;

        @Keep
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$Attachment;", "", "fileSize", "", "fileToken", "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFileSize", "()Ljava/lang/String;", "getFileToken", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Attachment {
            @NotNull
            private final String fileSize;
            @NotNull
            private final String fileToken;
            @NotNull
            private final String name;

            public Attachment(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                Intrinsics.checkNotNullParameter(str, "fileSize");
                Intrinsics.checkNotNullParameter(str2, "fileToken");
                Intrinsics.checkNotNullParameter(str3, "name");
                this.fileSize = str;
                this.fileToken = str2;
                this.name = str3;
            }

            public static /* synthetic */ Attachment copy$default(Attachment attachment, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = attachment.fileSize;
                }
                if ((i & 2) != 0) {
                    str2 = attachment.fileToken;
                }
                if ((i & 4) != 0) {
                    str3 = attachment.name;
                }
                return attachment.copy(str, str2, str3);
            }

            @NotNull
            public final String component1() {
                return this.fileSize;
            }

            @NotNull
            public final String component2() {
                return this.fileToken;
            }

            @NotNull
            public final String component3() {
                return this.name;
            }

            @NotNull
            public final Attachment copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                Intrinsics.checkNotNullParameter(str, "fileSize");
                Intrinsics.checkNotNullParameter(str2, "fileToken");
                Intrinsics.checkNotNullParameter(str3, "name");
                return new Attachment(str, str2, str3);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Attachment)) {
                    return false;
                }
                Attachment attachment = (Attachment) obj;
                return Intrinsics.areEqual((Object) this.fileSize, (Object) attachment.fileSize) && Intrinsics.areEqual((Object) this.fileToken, (Object) attachment.fileToken) && Intrinsics.areEqual((Object) this.name, (Object) attachment.name);
            }

            @NotNull
            public final String getFileSize() {
                return this.fileSize;
            }

            @NotNull
            public final String getFileToken() {
                return this.fileToken;
            }

            @NotNull
            public final String getName() {
                return this.name;
            }

            public int hashCode() {
                return (((this.fileSize.hashCode() * 31) + this.fileToken.hashCode()) * 31) + this.name.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.fileSize;
                String str2 = this.fileToken;
                String str3 = this.name;
                return "Attachment(fileSize=" + str + ", fileToken=" + str2 + ", name=" + str3 + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$EndTime;", "", "date", "", "timestamp", "timezone", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getTimestamp", "getTimezone", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class EndTime {
            @NotNull
            private final String date;
            @NotNull
            private final String timestamp;
            @Nullable
            private final String timezone;

            public EndTime(@NotNull String str, @NotNull String str2, @Nullable String str3) {
                Intrinsics.checkNotNullParameter(str, "date");
                Intrinsics.checkNotNullParameter(str2, "timestamp");
                this.date = str;
                this.timestamp = str2;
                this.timezone = str3;
            }

            public static /* synthetic */ EndTime copy$default(EndTime endTime, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = endTime.date;
                }
                if ((i & 2) != 0) {
                    str2 = endTime.timestamp;
                }
                if ((i & 4) != 0) {
                    str3 = endTime.timezone;
                }
                return endTime.copy(str, str2, str3);
            }

            @NotNull
            public final String component1() {
                return this.date;
            }

            @NotNull
            public final String component2() {
                return this.timestamp;
            }

            @Nullable
            public final String component3() {
                return this.timezone;
            }

            @NotNull
            public final EndTime copy(@NotNull String str, @NotNull String str2, @Nullable String str3) {
                Intrinsics.checkNotNullParameter(str, "date");
                Intrinsics.checkNotNullParameter(str2, "timestamp");
                return new EndTime(str, str2, str3);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof EndTime)) {
                    return false;
                }
                EndTime endTime = (EndTime) obj;
                return Intrinsics.areEqual((Object) this.date, (Object) endTime.date) && Intrinsics.areEqual((Object) this.timestamp, (Object) endTime.timestamp) && Intrinsics.areEqual((Object) this.timezone, (Object) endTime.timezone);
            }

            @NotNull
            public final String getDate() {
                return this.date;
            }

            @NotNull
            public final String getTimestamp() {
                return this.timestamp;
            }

            @Nullable
            public final String getTimezone() {
                return this.timezone;
            }

            public int hashCode() {
                int hashCode = ((this.date.hashCode() * 31) + this.timestamp.hashCode()) * 31;
                String str = this.timezone;
                return hashCode + (str == null ? 0 : str.hashCode());
            }

            @NotNull
            public String toString() {
                String str = this.date;
                String str2 = this.timestamp;
                String str3 = this.timezone;
                return "EndTime(date=" + str + ", timestamp=" + str2 + ", timezone=" + str3 + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$EventOrganizer;", "", "displayName", "", "userId", "(Ljava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getUserId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class EventOrganizer {
            @NotNull
            private final String displayName;
            @NotNull
            private final String userId;

            public EventOrganizer(@NotNull String str, @NotNull String str2) {
                Intrinsics.checkNotNullParameter(str, "displayName");
                Intrinsics.checkNotNullParameter(str2, "userId");
                this.displayName = str;
                this.userId = str2;
            }

            public static /* synthetic */ EventOrganizer copy$default(EventOrganizer eventOrganizer, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = eventOrganizer.displayName;
                }
                if ((i & 2) != 0) {
                    str2 = eventOrganizer.userId;
                }
                return eventOrganizer.copy(str, str2);
            }

            @NotNull
            public final String component1() {
                return this.displayName;
            }

            @NotNull
            public final String component2() {
                return this.userId;
            }

            @NotNull
            public final EventOrganizer copy(@NotNull String str, @NotNull String str2) {
                Intrinsics.checkNotNullParameter(str, "displayName");
                Intrinsics.checkNotNullParameter(str2, "userId");
                return new EventOrganizer(str, str2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof EventOrganizer)) {
                    return false;
                }
                EventOrganizer eventOrganizer = (EventOrganizer) obj;
                return Intrinsics.areEqual((Object) this.displayName, (Object) eventOrganizer.displayName) && Intrinsics.areEqual((Object) this.userId, (Object) eventOrganizer.userId);
            }

            @NotNull
            public final String getDisplayName() {
                return this.displayName;
            }

            @NotNull
            public final String getUserId() {
                return this.userId;
            }

            public int hashCode() {
                return (this.displayName.hashCode() * 31) + this.userId.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.displayName;
                String str2 = this.userId;
                return "EventOrganizer(displayName=" + str + ", userId=" + str2 + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$Location;", "", "address", "", "latitude", "", "longitude", "name", "(Ljava/lang/String;DDLjava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getLatitude", "()D", "getLongitude", "getName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Location {
            @NotNull
            private final String address;
            private final double latitude;
            private final double longitude;
            @NotNull
            private final String name;

            public Location(@NotNull String str, double d, double d2, @NotNull String str2) {
                Intrinsics.checkNotNullParameter(str, MzContactsContract.MzContactColumns.ADDRESS);
                Intrinsics.checkNotNullParameter(str2, "name");
                this.address = str;
                this.latitude = d;
                this.longitude = d2;
                this.name = str2;
            }

            public static /* synthetic */ Location copy$default(Location location, String str, double d, double d2, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = location.address;
                }
                if ((i & 2) != 0) {
                    d = location.latitude;
                }
                double d3 = d;
                if ((i & 4) != 0) {
                    d2 = location.longitude;
                }
                double d4 = d2;
                if ((i & 8) != 0) {
                    str2 = location.name;
                }
                return location.copy(str, d3, d4, str2);
            }

            @NotNull
            public final String component1() {
                return this.address;
            }

            public final double component2() {
                return this.latitude;
            }

            public final double component3() {
                return this.longitude;
            }

            @NotNull
            public final String component4() {
                return this.name;
            }

            @NotNull
            public final Location copy(@NotNull String str, double d, double d2, @NotNull String str2) {
                Intrinsics.checkNotNullParameter(str, MzContactsContract.MzContactColumns.ADDRESS);
                Intrinsics.checkNotNullParameter(str2, "name");
                return new Location(str, d, d2, str2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Location)) {
                    return false;
                }
                Location location = (Location) obj;
                return Intrinsics.areEqual((Object) this.address, (Object) location.address) && Double.compare(this.latitude, location.latitude) == 0 && Double.compare(this.longitude, location.longitude) == 0 && Intrinsics.areEqual((Object) this.name, (Object) location.name);
            }

            @NotNull
            public final String getAddress() {
                return this.address;
            }

            public final double getLatitude() {
                return this.latitude;
            }

            public final double getLongitude() {
                return this.longitude;
            }

            @NotNull
            public final String getName() {
                return this.name;
            }

            public int hashCode() {
                return (((((this.address.hashCode() * 31) + Double.hashCode(this.latitude)) * 31) + Double.hashCode(this.longitude)) * 31) + this.name.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.address;
                double d = this.latitude;
                double d2 = this.longitude;
                String str2 = this.name;
                return "Location(address=" + str + ", latitude=" + d + ", longitude=" + d2 + ", name=" + str2 + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$Reminder;", "", "minutes", "", "(I)V", "getMinutes", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Reminder {
            private final int minutes;

            public Reminder(int i) {
                this.minutes = i;
            }

            public static /* synthetic */ Reminder copy$default(Reminder reminder, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = reminder.minutes;
                }
                return reminder.copy(i);
            }

            public final int component1() {
                return this.minutes;
            }

            @NotNull
            public final Reminder copy(int i) {
                return new Reminder(i);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Reminder) && this.minutes == ((Reminder) obj).minutes;
            }

            public final int getMinutes() {
                return this.minutes;
            }

            public int hashCode() {
                return Integer.hashCode(this.minutes);
            }

            @NotNull
            public String toString() {
                int i = this.minutes;
                return "Reminder(minutes=" + i + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$Schema;", "", "appLink", "", "uiName", "uiStatus", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppLink", "()Ljava/lang/String;", "getUiName", "getUiStatus", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Schema {
            @NotNull
            private final String appLink;
            @NotNull
            private final String uiName;
            @NotNull
            private final String uiStatus;

            public Schema(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                Intrinsics.checkNotNullParameter(str, "appLink");
                Intrinsics.checkNotNullParameter(str2, "uiName");
                Intrinsics.checkNotNullParameter(str3, "uiStatus");
                this.appLink = str;
                this.uiName = str2;
                this.uiStatus = str3;
            }

            public static /* synthetic */ Schema copy$default(Schema schema, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = schema.appLink;
                }
                if ((i & 2) != 0) {
                    str2 = schema.uiName;
                }
                if ((i & 4) != 0) {
                    str3 = schema.uiStatus;
                }
                return schema.copy(str, str2, str3);
            }

            @NotNull
            public final String component1() {
                return this.appLink;
            }

            @NotNull
            public final String component2() {
                return this.uiName;
            }

            @NotNull
            public final String component3() {
                return this.uiStatus;
            }

            @NotNull
            public final Schema copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                Intrinsics.checkNotNullParameter(str, "appLink");
                Intrinsics.checkNotNullParameter(str2, "uiName");
                Intrinsics.checkNotNullParameter(str3, "uiStatus");
                return new Schema(str, str2, str3);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Schema)) {
                    return false;
                }
                Schema schema = (Schema) obj;
                return Intrinsics.areEqual((Object) this.appLink, (Object) schema.appLink) && Intrinsics.areEqual((Object) this.uiName, (Object) schema.uiName) && Intrinsics.areEqual((Object) this.uiStatus, (Object) schema.uiStatus);
            }

            @NotNull
            public final String getAppLink() {
                return this.appLink;
            }

            @NotNull
            public final String getUiName() {
                return this.uiName;
            }

            @NotNull
            public final String getUiStatus() {
                return this.uiStatus;
            }

            public int hashCode() {
                return (((this.appLink.hashCode() * 31) + this.uiName.hashCode()) * 31) + this.uiStatus.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.appLink;
                String str2 = this.uiName;
                String str3 = this.uiStatus;
                return "Schema(appLink=" + str + ", uiName=" + str2 + ", uiStatus=" + str3 + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$StartTime;", "", "date", "", "timestamp", "timezone", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getTimestamp", "getTimezone", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class StartTime {
            @NotNull
            private final String date;
            @NotNull
            private final String timestamp;
            @Nullable
            private final String timezone;

            public StartTime(@NotNull String str, @NotNull String str2, @Nullable String str3) {
                Intrinsics.checkNotNullParameter(str, "date");
                Intrinsics.checkNotNullParameter(str2, "timestamp");
                this.date = str;
                this.timestamp = str2;
                this.timezone = str3;
            }

            public static /* synthetic */ StartTime copy$default(StartTime startTime, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = startTime.date;
                }
                if ((i & 2) != 0) {
                    str2 = startTime.timestamp;
                }
                if ((i & 4) != 0) {
                    str3 = startTime.timezone;
                }
                return startTime.copy(str, str2, str3);
            }

            @NotNull
            public final String component1() {
                return this.date;
            }

            @NotNull
            public final String component2() {
                return this.timestamp;
            }

            @Nullable
            public final String component3() {
                return this.timezone;
            }

            @NotNull
            public final StartTime copy(@NotNull String str, @NotNull String str2, @Nullable String str3) {
                Intrinsics.checkNotNullParameter(str, "date");
                Intrinsics.checkNotNullParameter(str2, "timestamp");
                return new StartTime(str, str2, str3);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof StartTime)) {
                    return false;
                }
                StartTime startTime = (StartTime) obj;
                return Intrinsics.areEqual((Object) this.date, (Object) startTime.date) && Intrinsics.areEqual((Object) this.timestamp, (Object) startTime.timestamp) && Intrinsics.areEqual((Object) this.timezone, (Object) startTime.timezone);
            }

            @NotNull
            public final String getDate() {
                return this.date;
            }

            @NotNull
            public final String getTimestamp() {
                return this.timestamp;
            }

            @Nullable
            public final String getTimezone() {
                return this.timezone;
            }

            public int hashCode() {
                int hashCode = ((this.date.hashCode() * 31) + this.timestamp.hashCode()) * 31;
                String str = this.timezone;
                return hashCode + (str == null ? 0 : str.hashCode());
            }

            @NotNull
            public String toString() {
                String str = this.date;
                String str2 = this.timestamp;
                String str3 = this.timezone;
                return "StartTime(date=" + str + ", timestamp=" + str2 + ", timezone=" + str3 + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel$FsSchedule$Vchat;", "", "description", "", "iconType", "meetingUrl", "vcType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getIconType", "getMeetingUrl", "getVcType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Vchat {
            @NotNull
            private final String description;
            @NotNull
            private final String iconType;
            @NotNull
            private final String meetingUrl;
            @NotNull
            private final String vcType;

            public Vchat(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
                Intrinsics.checkNotNullParameter(str, "description");
                Intrinsics.checkNotNullParameter(str2, "iconType");
                Intrinsics.checkNotNullParameter(str3, "meetingUrl");
                Intrinsics.checkNotNullParameter(str4, "vcType");
                this.description = str;
                this.iconType = str2;
                this.meetingUrl = str3;
                this.vcType = str4;
            }

            public static /* synthetic */ Vchat copy$default(Vchat vchat, String str, String str2, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = vchat.description;
                }
                if ((i & 2) != 0) {
                    str2 = vchat.iconType;
                }
                if ((i & 4) != 0) {
                    str3 = vchat.meetingUrl;
                }
                if ((i & 8) != 0) {
                    str4 = vchat.vcType;
                }
                return vchat.copy(str, str2, str3, str4);
            }

            @NotNull
            public final String component1() {
                return this.description;
            }

            @NotNull
            public final String component2() {
                return this.iconType;
            }

            @NotNull
            public final String component3() {
                return this.meetingUrl;
            }

            @NotNull
            public final String component4() {
                return this.vcType;
            }

            @NotNull
            public final Vchat copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
                Intrinsics.checkNotNullParameter(str, "description");
                Intrinsics.checkNotNullParameter(str2, "iconType");
                Intrinsics.checkNotNullParameter(str3, "meetingUrl");
                Intrinsics.checkNotNullParameter(str4, "vcType");
                return new Vchat(str, str2, str3, str4);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Vchat)) {
                    return false;
                }
                Vchat vchat = (Vchat) obj;
                return Intrinsics.areEqual((Object) this.description, (Object) vchat.description) && Intrinsics.areEqual((Object) this.iconType, (Object) vchat.iconType) && Intrinsics.areEqual((Object) this.meetingUrl, (Object) vchat.meetingUrl) && Intrinsics.areEqual((Object) this.vcType, (Object) vchat.vcType);
            }

            @NotNull
            public final String getDescription() {
                return this.description;
            }

            @NotNull
            public final String getIconType() {
                return this.iconType;
            }

            @NotNull
            public final String getMeetingUrl() {
                return this.meetingUrl;
            }

            @NotNull
            public final String getVcType() {
                return this.vcType;
            }

            public int hashCode() {
                return (((((this.description.hashCode() * 31) + this.iconType.hashCode()) * 31) + this.meetingUrl.hashCode()) * 31) + this.vcType.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.description;
                String str2 = this.iconType;
                String str3 = this.meetingUrl;
                String str4 = this.vcType;
                return "Vchat(description=" + str + ", iconType=" + str2 + ", meetingUrl=" + str3 + ", vcType=" + str4 + ")";
            }
        }

        public FsSchedule(@NotNull String str, @NotNull List<Attachment> list, @NotNull String str2, int i, @Nullable String str3, @Nullable String str4, @Nullable EndTime endTime2, @Nullable String str5, @NotNull EventOrganizer eventOrganizer2, @NotNull String str6, boolean z, @NotNull Location location2, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull List<Reminder> list2, @NotNull List<Schema> list3, @Nullable StartTime startTime2, @NotNull String str10, @Nullable String str11, @NotNull Vchat vchat2, @NotNull String str12) {
            String str13 = str;
            List<Attachment> list4 = list;
            String str14 = str2;
            EventOrganizer eventOrganizer3 = eventOrganizer2;
            String str15 = str6;
            Location location3 = location2;
            String str16 = str7;
            String str17 = str8;
            String str18 = str9;
            List<Reminder> list5 = list2;
            List<Schema> list6 = list3;
            String str19 = str10;
            Vchat vchat3 = vchat2;
            String str20 = str12;
            Intrinsics.checkNotNullParameter(str13, "appLink");
            Intrinsics.checkNotNullParameter(list4, "attachments");
            Intrinsics.checkNotNullParameter(str14, "attendeeAbility");
            Intrinsics.checkNotNullParameter(eventOrganizer3, "eventOrganizer");
            Intrinsics.checkNotNullParameter(str15, "freeBusyStatus");
            Intrinsics.checkNotNullParameter(location3, "location");
            Intrinsics.checkNotNullParameter(str16, "organizerCalendarId");
            Intrinsics.checkNotNullParameter(str17, "recurrence");
            Intrinsics.checkNotNullParameter(str18, "recurringEventId");
            Intrinsics.checkNotNullParameter(list5, "reminders");
            Intrinsics.checkNotNullParameter(list6, "schemas");
            Intrinsics.checkNotNullParameter(str19, "status");
            Intrinsics.checkNotNullParameter(vchat3, "vchat");
            Intrinsics.checkNotNullParameter(str20, "visibility");
            this.appLink = str13;
            this.attachments = list4;
            this.attendeeAbility = str14;
            this.color = i;
            this.createTime = str3;
            this.description = str4;
            this.endTime = endTime2;
            this.eventId = str5;
            this.eventOrganizer = eventOrganizer3;
            this.freeBusyStatus = str15;
            this.isException = z;
            this.location = location3;
            this.organizerCalendarId = str16;
            this.recurrence = str17;
            this.recurringEventId = str18;
            this.reminders = list5;
            this.schemas = list6;
            this.startTime = startTime2;
            this.status = str19;
            this.summary = str11;
            this.vchat = vchat3;
            this.visibility = str20;
        }

        public static /* synthetic */ FsSchedule copy$default(FsSchedule fsSchedule, String str, List list, String str2, int i, String str3, String str4, EndTime endTime2, String str5, EventOrganizer eventOrganizer2, String str6, boolean z, Location location2, String str7, String str8, String str9, List list2, List list3, StartTime startTime2, String str10, String str11, Vchat vchat2, String str12, int i2, Object obj) {
            FsSchedule fsSchedule2 = fsSchedule;
            int i3 = i2;
            return fsSchedule.copy((i3 & 1) != 0 ? fsSchedule2.appLink : str, (i3 & 2) != 0 ? fsSchedule2.attachments : list, (i3 & 4) != 0 ? fsSchedule2.attendeeAbility : str2, (i3 & 8) != 0 ? fsSchedule2.color : i, (i3 & 16) != 0 ? fsSchedule2.createTime : str3, (i3 & 32) != 0 ? fsSchedule2.description : str4, (i3 & 64) != 0 ? fsSchedule2.endTime : endTime2, (i3 & 128) != 0 ? fsSchedule2.eventId : str5, (i3 & 256) != 0 ? fsSchedule2.eventOrganizer : eventOrganizer2, (i3 & 512) != 0 ? fsSchedule2.freeBusyStatus : str6, (i3 & 1024) != 0 ? fsSchedule2.isException : z, (i3 & 2048) != 0 ? fsSchedule2.location : location2, (i3 & 4096) != 0 ? fsSchedule2.organizerCalendarId : str7, (i3 & 8192) != 0 ? fsSchedule2.recurrence : str8, (i3 & 16384) != 0 ? fsSchedule2.recurringEventId : str9, (i3 & 32768) != 0 ? fsSchedule2.reminders : list2, (i3 & 65536) != 0 ? fsSchedule2.schemas : list3, (i3 & 131072) != 0 ? fsSchedule2.startTime : startTime2, (i3 & PositionEstimate.Value.BUILDING_NAME) != 0 ? fsSchedule2.status : str10, (i3 & PositionEstimate.Value.TIME_SINCE_BOOT) != 0 ? fsSchedule2.summary : str11, (i3 & PositionEstimate.Value.SITUATION) != 0 ? fsSchedule2.vchat : vchat2, (i3 & PositionEstimate.Value.WLAN_AP_COUNT) != 0 ? fsSchedule2.visibility : str12);
        }

        @NotNull
        public final String component1() {
            return this.appLink;
        }

        @NotNull
        public final String component10() {
            return this.freeBusyStatus;
        }

        public final boolean component11() {
            return this.isException;
        }

        @NotNull
        public final Location component12() {
            return this.location;
        }

        @NotNull
        public final String component13() {
            return this.organizerCalendarId;
        }

        @NotNull
        public final String component14() {
            return this.recurrence;
        }

        @NotNull
        public final String component15() {
            return this.recurringEventId;
        }

        @NotNull
        public final List<Reminder> component16() {
            return this.reminders;
        }

        @NotNull
        public final List<Schema> component17() {
            return this.schemas;
        }

        @Nullable
        public final StartTime component18() {
            return this.startTime;
        }

        @NotNull
        public final String component19() {
            return this.status;
        }

        @NotNull
        public final List<Attachment> component2() {
            return this.attachments;
        }

        @Nullable
        public final String component20() {
            return this.summary;
        }

        @NotNull
        public final Vchat component21() {
            return this.vchat;
        }

        @NotNull
        public final String component22() {
            return this.visibility;
        }

        @NotNull
        public final String component3() {
            return this.attendeeAbility;
        }

        public final int component4() {
            return this.color;
        }

        @Nullable
        public final String component5() {
            return this.createTime;
        }

        @Nullable
        public final String component6() {
            return this.description;
        }

        @Nullable
        public final EndTime component7() {
            return this.endTime;
        }

        @Nullable
        public final String component8() {
            return this.eventId;
        }

        @NotNull
        public final EventOrganizer component9() {
            return this.eventOrganizer;
        }

        @NotNull
        public final FsSchedule copy(@NotNull String str, @NotNull List<Attachment> list, @NotNull String str2, int i, @Nullable String str3, @Nullable String str4, @Nullable EndTime endTime2, @Nullable String str5, @NotNull EventOrganizer eventOrganizer2, @NotNull String str6, boolean z, @NotNull Location location2, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull List<Reminder> list2, @NotNull List<Schema> list3, @Nullable StartTime startTime2, @NotNull String str10, @Nullable String str11, @NotNull Vchat vchat2, @NotNull String str12) {
            String str13 = str;
            Intrinsics.checkNotNullParameter(str13, "appLink");
            Intrinsics.checkNotNullParameter(list, "attachments");
            Intrinsics.checkNotNullParameter(str2, "attendeeAbility");
            Intrinsics.checkNotNullParameter(eventOrganizer2, "eventOrganizer");
            Intrinsics.checkNotNullParameter(str6, "freeBusyStatus");
            Intrinsics.checkNotNullParameter(location2, "location");
            Intrinsics.checkNotNullParameter(str7, "organizerCalendarId");
            Intrinsics.checkNotNullParameter(str8, "recurrence");
            Intrinsics.checkNotNullParameter(str9, "recurringEventId");
            Intrinsics.checkNotNullParameter(list2, "reminders");
            Intrinsics.checkNotNullParameter(list3, "schemas");
            Intrinsics.checkNotNullParameter(str10, "status");
            Intrinsics.checkNotNullParameter(vchat2, "vchat");
            Intrinsics.checkNotNullParameter(str12, "visibility");
            return new FsSchedule(str13, list, str2, i, str3, str4, endTime2, str5, eventOrganizer2, str6, z, location2, str7, str8, str9, list2, list3, startTime2, str10, str11, vchat2, str12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FsSchedule)) {
                return false;
            }
            FsSchedule fsSchedule = (FsSchedule) obj;
            return Intrinsics.areEqual((Object) this.appLink, (Object) fsSchedule.appLink) && Intrinsics.areEqual((Object) this.attachments, (Object) fsSchedule.attachments) && Intrinsics.areEqual((Object) this.attendeeAbility, (Object) fsSchedule.attendeeAbility) && this.color == fsSchedule.color && Intrinsics.areEqual((Object) this.createTime, (Object) fsSchedule.createTime) && Intrinsics.areEqual((Object) this.description, (Object) fsSchedule.description) && Intrinsics.areEqual((Object) this.endTime, (Object) fsSchedule.endTime) && Intrinsics.areEqual((Object) this.eventId, (Object) fsSchedule.eventId) && Intrinsics.areEqual((Object) this.eventOrganizer, (Object) fsSchedule.eventOrganizer) && Intrinsics.areEqual((Object) this.freeBusyStatus, (Object) fsSchedule.freeBusyStatus) && this.isException == fsSchedule.isException && Intrinsics.areEqual((Object) this.location, (Object) fsSchedule.location) && Intrinsics.areEqual((Object) this.organizerCalendarId, (Object) fsSchedule.organizerCalendarId) && Intrinsics.areEqual((Object) this.recurrence, (Object) fsSchedule.recurrence) && Intrinsics.areEqual((Object) this.recurringEventId, (Object) fsSchedule.recurringEventId) && Intrinsics.areEqual((Object) this.reminders, (Object) fsSchedule.reminders) && Intrinsics.areEqual((Object) this.schemas, (Object) fsSchedule.schemas) && Intrinsics.areEqual((Object) this.startTime, (Object) fsSchedule.startTime) && Intrinsics.areEqual((Object) this.status, (Object) fsSchedule.status) && Intrinsics.areEqual((Object) this.summary, (Object) fsSchedule.summary) && Intrinsics.areEqual((Object) this.vchat, (Object) fsSchedule.vchat) && Intrinsics.areEqual((Object) this.visibility, (Object) fsSchedule.visibility);
        }

        @NotNull
        public final String getAppLink() {
            return this.appLink;
        }

        @NotNull
        public final List<Attachment> getAttachments() {
            return this.attachments;
        }

        @NotNull
        public final String getAttendeeAbility() {
            return this.attendeeAbility;
        }

        public final int getColor() {
            return this.color;
        }

        @Nullable
        public final String getCreateTime() {
            return this.createTime;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final EndTime getEndTime() {
            return this.endTime;
        }

        @Nullable
        public final String getEventId() {
            return this.eventId;
        }

        @NotNull
        public final EventOrganizer getEventOrganizer() {
            return this.eventOrganizer;
        }

        @NotNull
        public final String getFreeBusyStatus() {
            return this.freeBusyStatus;
        }

        @NotNull
        public final Location getLocation() {
            return this.location;
        }

        @NotNull
        public final String getOrganizerCalendarId() {
            return this.organizerCalendarId;
        }

        @NotNull
        public final String getRecurrence() {
            return this.recurrence;
        }

        @NotNull
        public final String getRecurringEventId() {
            return this.recurringEventId;
        }

        @NotNull
        public final List<Reminder> getReminders() {
            return this.reminders;
        }

        @NotNull
        public final List<Schema> getSchemas() {
            return this.schemas;
        }

        @Nullable
        public final StartTime getStartTime() {
            return this.startTime;
        }

        @NotNull
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final String getSummary() {
            return this.summary;
        }

        @NotNull
        public final Vchat getVchat() {
            return this.vchat;
        }

        @NotNull
        public final String getVisibility() {
            return this.visibility;
        }

        public int hashCode() {
            int hashCode = ((((((this.appLink.hashCode() * 31) + this.attachments.hashCode()) * 31) + this.attendeeAbility.hashCode()) * 31) + Integer.hashCode(this.color)) * 31;
            String str = this.createTime;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.description;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            EndTime endTime2 = this.endTime;
            int hashCode4 = (hashCode3 + (endTime2 == null ? 0 : endTime2.hashCode())) * 31;
            String str3 = this.eventId;
            int hashCode5 = (((((((((((((((((((hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.eventOrganizer.hashCode()) * 31) + this.freeBusyStatus.hashCode()) * 31) + Boolean.hashCode(this.isException)) * 31) + this.location.hashCode()) * 31) + this.organizerCalendarId.hashCode()) * 31) + this.recurrence.hashCode()) * 31) + this.recurringEventId.hashCode()) * 31) + this.reminders.hashCode()) * 31) + this.schemas.hashCode()) * 31;
            StartTime startTime2 = this.startTime;
            int hashCode6 = (((hashCode5 + (startTime2 == null ? 0 : startTime2.hashCode())) * 31) + this.status.hashCode()) * 31;
            String str4 = this.summary;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return ((((hashCode6 + i) * 31) + this.vchat.hashCode()) * 31) + this.visibility.hashCode();
        }

        public final boolean isException() {
            return this.isException;
        }

        @NotNull
        public String toString() {
            String str = this.appLink;
            List<Attachment> list = this.attachments;
            String str2 = this.attendeeAbility;
            int i = this.color;
            String str3 = this.createTime;
            String str4 = this.description;
            EndTime endTime2 = this.endTime;
            String str5 = this.eventId;
            EventOrganizer eventOrganizer2 = this.eventOrganizer;
            String str6 = this.freeBusyStatus;
            boolean z = this.isException;
            Location location2 = this.location;
            String str7 = this.organizerCalendarId;
            String str8 = this.recurrence;
            String str9 = this.recurringEventId;
            List<Reminder> list2 = this.reminders;
            List<Schema> list3 = this.schemas;
            StartTime startTime2 = this.startTime;
            String str10 = this.status;
            String str11 = this.summary;
            Vchat vchat2 = this.vchat;
            String str12 = this.visibility;
            return "FsSchedule(appLink=" + str + ", attachments=" + list + ", attendeeAbility=" + str2 + ", color=" + i + ", createTime=" + str3 + ", description=" + str4 + ", endTime=" + endTime2 + ", eventId=" + str5 + ", eventOrganizer=" + eventOrganizer2 + ", freeBusyStatus=" + str6 + ", isException=" + z + ", location=" + location2 + ", organizerCalendarId=" + str7 + ", recurrence=" + str8 + ", recurringEventId=" + str9 + ", reminders=" + list2 + ", schemas=" + list3 + ", startTime=" + startTime2 + ", status=" + str10 + ", summary=" + str11 + ", vchat=" + vchat2 + ", visibility=" + str12 + ")";
        }
    }

    public FsScheduleArrayRespModel(boolean z, @NotNull List<FsSchedule> list, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(str, "pageToken");
        Intrinsics.checkNotNullParameter(str2, "syncToken");
        this.hasMore = z;
        this.items = list;
        this.pageToken = str;
        this.syncToken = str2;
    }

    public static /* synthetic */ FsScheduleArrayRespModel copy$default(FsScheduleArrayRespModel fsScheduleArrayRespModel, boolean z, List<FsSchedule> list, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = fsScheduleArrayRespModel.hasMore;
        }
        if ((i & 2) != 0) {
            list = fsScheduleArrayRespModel.items;
        }
        if ((i & 4) != 0) {
            str = fsScheduleArrayRespModel.pageToken;
        }
        if ((i & 8) != 0) {
            str2 = fsScheduleArrayRespModel.syncToken;
        }
        return fsScheduleArrayRespModel.copy(z, list, str, str2);
    }

    public final boolean component1() {
        return this.hasMore;
    }

    @NotNull
    public final List<FsSchedule> component2() {
        return this.items;
    }

    @NotNull
    public final String component3() {
        return this.pageToken;
    }

    @NotNull
    public final String component4() {
        return this.syncToken;
    }

    @NotNull
    public final FsScheduleArrayRespModel copy(boolean z, @NotNull List<FsSchedule> list, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(str, "pageToken");
        Intrinsics.checkNotNullParameter(str2, "syncToken");
        return new FsScheduleArrayRespModel(z, list, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FsScheduleArrayRespModel)) {
            return false;
        }
        FsScheduleArrayRespModel fsScheduleArrayRespModel = (FsScheduleArrayRespModel) obj;
        return this.hasMore == fsScheduleArrayRespModel.hasMore && Intrinsics.areEqual((Object) this.items, (Object) fsScheduleArrayRespModel.items) && Intrinsics.areEqual((Object) this.pageToken, (Object) fsScheduleArrayRespModel.pageToken) && Intrinsics.areEqual((Object) this.syncToken, (Object) fsScheduleArrayRespModel.syncToken);
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    @NotNull
    public final List<FsSchedule> getItems() {
        return this.items;
    }

    @NotNull
    public final String getPageToken() {
        return this.pageToken;
    }

    @NotNull
    public final String getSyncToken() {
        return this.syncToken;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.hasMore) * 31) + this.items.hashCode()) * 31) + this.pageToken.hashCode()) * 31) + this.syncToken.hashCode();
    }

    @NotNull
    public String toString() {
        boolean z = this.hasMore;
        List<FsSchedule> list = this.items;
        String str = this.pageToken;
        String str2 = this.syncToken;
        return "FsScheduleArrayRespModel(hasMore=" + z + ", items=" + list + ", pageToken=" + str + ", syncToken=" + str2 + ")";
    }
}
