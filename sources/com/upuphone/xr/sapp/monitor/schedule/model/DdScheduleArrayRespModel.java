package com.upuphone.xr.sapp.monitor.schedule.model;

import androidx.annotation.Keep;
import com.here.posclient.PositionEstimate;
import com.meizu.common.widget.MzContactsContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u0018B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel;", "", "events", "", "Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event;", "nextToken", "", "syncToken", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getEvents", "()Ljava/util/List;", "getNextToken", "()Ljava/lang/String;", "getSyncToken", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Event", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class DdScheduleArrayRespModel {
    @NotNull
    private final List<Event> events;
    @NotNull
    private final String nextToken;
    @NotNull
    private final String syncToken;

    @Keep
    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0010\b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001:\f^_`abcdefghiB½\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0003\u0012\u0006\u0010\u001f\u001a\u00020\b\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020\b\u0012\u0006\u0010#\u001a\u00020\b\u0012\u0006\u0010$\u001a\u00020\b¢\u0006\u0002\u0010%J\u000f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0016HÆ\u0003J\t\u0010G\u001a\u00020\u0018HÆ\u0003J\t\u0010H\u001a\u00020\u001aHÆ\u0003J\t\u0010I\u001a\u00020\u001cHÆ\u0003J\u000f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0003HÆ\u0003J\t\u0010K\u001a\u00020\bHÆ\u0003J\t\u0010L\u001a\u00020!HÆ\u0003J\t\u0010M\u001a\u00020\bHÆ\u0003J\t\u0010N\u001a\u00020\bHÆ\u0003J\u000f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\t\u0010P\u001a\u00020\bHÆ\u0003J\t\u0010Q\u001a\u00020\bHÆ\u0003J\t\u0010R\u001a\u00020\bHÆ\u0003J\t\u0010S\u001a\u00020\u000bHÆ\u0003J\t\u0010T\u001a\u00020\rHÆ\u0003J\t\u0010U\u001a\u00020\bHÆ\u0003J\t\u0010V\u001a\u00020\u0010HÆ\u0003J\t\u0010W\u001a\u00020\u0012HÆ\u0003Jé\u0001\u0010X\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\bHÆ\u0001J\u0013\u0010Y\u001a\u00020\u00102\b\u0010Z\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010[\u001a\u00020\\HÖ\u0001J\t\u0010]\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010*R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u00101R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010'R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010'R\u0011\u0010\u001f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b>\u0010*R\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0011\u0010\"\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bA\u0010*R\u0011\u0010#\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bB\u0010*R\u0011\u0010$\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bC\u0010*¨\u0006j"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event;", "", "attendees", "", "Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Attendee;", "categories", "Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Category;", "createTime", "", "description", "end", "Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$End;", "extendedProperties", "Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$ExtendedProperties;", "id", "isAllDay", "", "location", "Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Location;", "meetingRooms", "Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$MeetingRoom;", "onlineMeetingInfo", "Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$OnlineMeetingInfo;", "organizer", "Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Organizer;", "originStart", "Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$OriginStart;", "recurrence", "Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Recurrence;", "reminders", "Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Reminder;", "seriesMasterId", "start", "Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Start;", "status", "summary", "updateTime", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$End;Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$ExtendedProperties;Ljava/lang/String;ZLcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Location;Ljava/util/List;Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$OnlineMeetingInfo;Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Organizer;Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$OriginStart;Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Recurrence;Ljava/util/List;Ljava/lang/String;Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Start;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAttendees", "()Ljava/util/List;", "getCategories", "getCreateTime", "()Ljava/lang/String;", "getDescription", "getEnd", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$End;", "getExtendedProperties", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$ExtendedProperties;", "getId", "()Z", "getLocation", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Location;", "getMeetingRooms", "getOnlineMeetingInfo", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$OnlineMeetingInfo;", "getOrganizer", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Organizer;", "getOriginStart", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$OriginStart;", "getRecurrence", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Recurrence;", "getReminders", "getSeriesMasterId", "getStart", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Start;", "getStatus", "getSummary", "getUpdateTime", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "Attendee", "Category", "End", "ExtendedProperties", "Location", "MeetingRoom", "OnlineMeetingInfo", "Organizer", "OriginStart", "Recurrence", "Reminder", "Start", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Event {
        @NotNull
        private final List<Attendee> attendees;
        @NotNull
        private final List<Category> categories;
        @NotNull
        private final String createTime;
        @NotNull
        private final String description;
        @NotNull
        private final End end;
        @NotNull
        private final ExtendedProperties extendedProperties;
        @NotNull
        private final String id;
        private final boolean isAllDay;
        @NotNull
        private final Location location;
        @NotNull
        private final List<MeetingRoom> meetingRooms;
        @NotNull
        private final OnlineMeetingInfo onlineMeetingInfo;
        @NotNull
        private final Organizer organizer;
        @NotNull
        private final OriginStart originStart;
        @NotNull
        private final Recurrence recurrence;
        @NotNull
        private final List<Reminder> reminders;
        @NotNull
        private final String seriesMasterId;
        @NotNull
        private final Start start;
        @NotNull
        private final String status;
        @NotNull
        private final String summary;
        @NotNull
        private final String updateTime;

        @Keep
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Attendee;", "", "displayName", "", "id", "isOptional", "", "responseStatus", "self", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Z)V", "getDisplayName", "()Ljava/lang/String;", "getId", "()Z", "getResponseStatus", "getSelf", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Attendee {
            @NotNull
            private final String displayName;
            @NotNull
            private final String id;
            private final boolean isOptional;
            @NotNull
            private final String responseStatus;
            private final boolean self;

            public Attendee(@NotNull String str, @NotNull String str2, boolean z, @NotNull String str3, boolean z2) {
                Intrinsics.checkNotNullParameter(str, "displayName");
                Intrinsics.checkNotNullParameter(str2, "id");
                Intrinsics.checkNotNullParameter(str3, "responseStatus");
                this.displayName = str;
                this.id = str2;
                this.isOptional = z;
                this.responseStatus = str3;
                this.self = z2;
            }

            public static /* synthetic */ Attendee copy$default(Attendee attendee, String str, String str2, boolean z, String str3, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = attendee.displayName;
                }
                if ((i & 2) != 0) {
                    str2 = attendee.id;
                }
                String str4 = str2;
                if ((i & 4) != 0) {
                    z = attendee.isOptional;
                }
                boolean z3 = z;
                if ((i & 8) != 0) {
                    str3 = attendee.responseStatus;
                }
                String str5 = str3;
                if ((i & 16) != 0) {
                    z2 = attendee.self;
                }
                return attendee.copy(str, str4, z3, str5, z2);
            }

            @NotNull
            public final String component1() {
                return this.displayName;
            }

            @NotNull
            public final String component2() {
                return this.id;
            }

            public final boolean component3() {
                return this.isOptional;
            }

            @NotNull
            public final String component4() {
                return this.responseStatus;
            }

            public final boolean component5() {
                return this.self;
            }

            @NotNull
            public final Attendee copy(@NotNull String str, @NotNull String str2, boolean z, @NotNull String str3, boolean z2) {
                Intrinsics.checkNotNullParameter(str, "displayName");
                Intrinsics.checkNotNullParameter(str2, "id");
                Intrinsics.checkNotNullParameter(str3, "responseStatus");
                return new Attendee(str, str2, z, str3, z2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Attendee)) {
                    return false;
                }
                Attendee attendee = (Attendee) obj;
                return Intrinsics.areEqual((Object) this.displayName, (Object) attendee.displayName) && Intrinsics.areEqual((Object) this.id, (Object) attendee.id) && this.isOptional == attendee.isOptional && Intrinsics.areEqual((Object) this.responseStatus, (Object) attendee.responseStatus) && this.self == attendee.self;
            }

            @NotNull
            public final String getDisplayName() {
                return this.displayName;
            }

            @NotNull
            public final String getId() {
                return this.id;
            }

            @NotNull
            public final String getResponseStatus() {
                return this.responseStatus;
            }

            public final boolean getSelf() {
                return this.self;
            }

            public int hashCode() {
                return (((((((this.displayName.hashCode() * 31) + this.id.hashCode()) * 31) + Boolean.hashCode(this.isOptional)) * 31) + this.responseStatus.hashCode()) * 31) + Boolean.hashCode(this.self);
            }

            public final boolean isOptional() {
                return this.isOptional;
            }

            @NotNull
            public String toString() {
                String str = this.displayName;
                String str2 = this.id;
                boolean z = this.isOptional;
                String str3 = this.responseStatus;
                boolean z2 = this.self;
                return "Attendee(displayName=" + str + ", id=" + str2 + ", isOptional=" + z + ", responseStatus=" + str3 + ", self=" + z2 + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Category;", "", "displayName", "", "(Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Category {
            @NotNull
            private final String displayName;

            public Category(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "displayName");
                this.displayName = str;
            }

            public static /* synthetic */ Category copy$default(Category category, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = category.displayName;
                }
                return category.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.displayName;
            }

            @NotNull
            public final Category copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "displayName");
                return new Category(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Category) && Intrinsics.areEqual((Object) this.displayName, (Object) ((Category) obj).displayName);
            }

            @NotNull
            public final String getDisplayName() {
                return this.displayName;
            }

            public int hashCode() {
                return this.displayName.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.displayName;
                return "Category(displayName=" + str + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$End;", "", "date", "", "dateTime", "timeZone", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getDateTime", "getTimeZone", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class End {
            @NotNull
            private final String date;
            @NotNull
            private final String dateTime;
            @NotNull
            private final String timeZone;

            public End(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                Intrinsics.checkNotNullParameter(str, "date");
                Intrinsics.checkNotNullParameter(str2, "dateTime");
                Intrinsics.checkNotNullParameter(str3, "timeZone");
                this.date = str;
                this.dateTime = str2;
                this.timeZone = str3;
            }

            public static /* synthetic */ End copy$default(End end, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = end.date;
                }
                if ((i & 2) != 0) {
                    str2 = end.dateTime;
                }
                if ((i & 4) != 0) {
                    str3 = end.timeZone;
                }
                return end.copy(str, str2, str3);
            }

            @NotNull
            public final String component1() {
                return this.date;
            }

            @NotNull
            public final String component2() {
                return this.dateTime;
            }

            @NotNull
            public final String component3() {
                return this.timeZone;
            }

            @NotNull
            public final End copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                Intrinsics.checkNotNullParameter(str, "date");
                Intrinsics.checkNotNullParameter(str2, "dateTime");
                Intrinsics.checkNotNullParameter(str3, "timeZone");
                return new End(str, str2, str3);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof End)) {
                    return false;
                }
                End end = (End) obj;
                return Intrinsics.areEqual((Object) this.date, (Object) end.date) && Intrinsics.areEqual((Object) this.dateTime, (Object) end.dateTime) && Intrinsics.areEqual((Object) this.timeZone, (Object) end.timeZone);
            }

            @NotNull
            public final String getDate() {
                return this.date;
            }

            @NotNull
            public final String getDateTime() {
                return this.dateTime;
            }

            @NotNull
            public final String getTimeZone() {
                return this.timeZone;
            }

            public int hashCode() {
                return (((this.date.hashCode() * 31) + this.dateTime.hashCode()) * 31) + this.timeZone.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.date;
                String str2 = this.dateTime;
                String str3 = this.timeZone;
                return "End(date=" + str + ", dateTime=" + str2 + ", timeZone=" + str3 + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$ExtendedProperties;", "", "sharedProperties", "Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$ExtendedProperties$SharedProperties;", "(Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$ExtendedProperties$SharedProperties;)V", "getSharedProperties", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$ExtendedProperties$SharedProperties;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "SharedProperties", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ExtendedProperties {
            @NotNull
            private final SharedProperties sharedProperties;

            @Keep
            @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$ExtendedProperties$SharedProperties;", "", "belongCorpId", "", "sourceOpenCid", "(Ljava/lang/String;Ljava/lang/String;)V", "getBelongCorpId", "()Ljava/lang/String;", "getSourceOpenCid", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class SharedProperties {
                @NotNull
                private final String belongCorpId;
                @NotNull
                private final String sourceOpenCid;

                public SharedProperties(@NotNull String str, @NotNull String str2) {
                    Intrinsics.checkNotNullParameter(str, "belongCorpId");
                    Intrinsics.checkNotNullParameter(str2, "sourceOpenCid");
                    this.belongCorpId = str;
                    this.sourceOpenCid = str2;
                }

                public static /* synthetic */ SharedProperties copy$default(SharedProperties sharedProperties, String str, String str2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = sharedProperties.belongCorpId;
                    }
                    if ((i & 2) != 0) {
                        str2 = sharedProperties.sourceOpenCid;
                    }
                    return sharedProperties.copy(str, str2);
                }

                @NotNull
                public final String component1() {
                    return this.belongCorpId;
                }

                @NotNull
                public final String component2() {
                    return this.sourceOpenCid;
                }

                @NotNull
                public final SharedProperties copy(@NotNull String str, @NotNull String str2) {
                    Intrinsics.checkNotNullParameter(str, "belongCorpId");
                    Intrinsics.checkNotNullParameter(str2, "sourceOpenCid");
                    return new SharedProperties(str, str2);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof SharedProperties)) {
                        return false;
                    }
                    SharedProperties sharedProperties = (SharedProperties) obj;
                    return Intrinsics.areEqual((Object) this.belongCorpId, (Object) sharedProperties.belongCorpId) && Intrinsics.areEqual((Object) this.sourceOpenCid, (Object) sharedProperties.sourceOpenCid);
                }

                @NotNull
                public final String getBelongCorpId() {
                    return this.belongCorpId;
                }

                @NotNull
                public final String getSourceOpenCid() {
                    return this.sourceOpenCid;
                }

                public int hashCode() {
                    return (this.belongCorpId.hashCode() * 31) + this.sourceOpenCid.hashCode();
                }

                @NotNull
                public String toString() {
                    String str = this.belongCorpId;
                    String str2 = this.sourceOpenCid;
                    return "SharedProperties(belongCorpId=" + str + ", sourceOpenCid=" + str2 + ")";
                }
            }

            public ExtendedProperties(@NotNull SharedProperties sharedProperties2) {
                Intrinsics.checkNotNullParameter(sharedProperties2, "sharedProperties");
                this.sharedProperties = sharedProperties2;
            }

            public static /* synthetic */ ExtendedProperties copy$default(ExtendedProperties extendedProperties, SharedProperties sharedProperties2, int i, Object obj) {
                if ((i & 1) != 0) {
                    sharedProperties2 = extendedProperties.sharedProperties;
                }
                return extendedProperties.copy(sharedProperties2);
            }

            @NotNull
            public final SharedProperties component1() {
                return this.sharedProperties;
            }

            @NotNull
            public final ExtendedProperties copy(@NotNull SharedProperties sharedProperties2) {
                Intrinsics.checkNotNullParameter(sharedProperties2, "sharedProperties");
                return new ExtendedProperties(sharedProperties2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ExtendedProperties) && Intrinsics.areEqual((Object) this.sharedProperties, (Object) ((ExtendedProperties) obj).sharedProperties);
            }

            @NotNull
            public final SharedProperties getSharedProperties() {
                return this.sharedProperties;
            }

            public int hashCode() {
                return this.sharedProperties.hashCode();
            }

            @NotNull
            public String toString() {
                SharedProperties sharedProperties2 = this.sharedProperties;
                return "ExtendedProperties(sharedProperties=" + sharedProperties2 + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Location;", "", "displayName", "", "meetingRooms", "", "(Ljava/lang/String;Ljava/util/List;)V", "getDisplayName", "()Ljava/lang/String;", "getMeetingRooms", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Location {
            @NotNull
            private final String displayName;
            @NotNull
            private final List<String> meetingRooms;

            public Location(@NotNull String str, @NotNull List<String> list) {
                Intrinsics.checkNotNullParameter(str, "displayName");
                Intrinsics.checkNotNullParameter(list, "meetingRooms");
                this.displayName = str;
                this.meetingRooms = list;
            }

            public static /* synthetic */ Location copy$default(Location location, String str, List<String> list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = location.displayName;
                }
                if ((i & 2) != 0) {
                    list = location.meetingRooms;
                }
                return location.copy(str, list);
            }

            @NotNull
            public final String component1() {
                return this.displayName;
            }

            @NotNull
            public final List<String> component2() {
                return this.meetingRooms;
            }

            @NotNull
            public final Location copy(@NotNull String str, @NotNull List<String> list) {
                Intrinsics.checkNotNullParameter(str, "displayName");
                Intrinsics.checkNotNullParameter(list, "meetingRooms");
                return new Location(str, list);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Location)) {
                    return false;
                }
                Location location = (Location) obj;
                return Intrinsics.areEqual((Object) this.displayName, (Object) location.displayName) && Intrinsics.areEqual((Object) this.meetingRooms, (Object) location.meetingRooms);
            }

            @NotNull
            public final String getDisplayName() {
                return this.displayName;
            }

            @NotNull
            public final List<String> getMeetingRooms() {
                return this.meetingRooms;
            }

            public int hashCode() {
                return (this.displayName.hashCode() * 31) + this.meetingRooms.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.displayName;
                List<String> list = this.meetingRooms;
                return "Location(displayName=" + str + ", meetingRooms=" + list + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$MeetingRoom;", "", "displayName", "", "responseStatus", "roomId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getResponseStatus", "getRoomId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class MeetingRoom {
            @NotNull
            private final String displayName;
            @NotNull
            private final String responseStatus;
            @NotNull
            private final String roomId;

            public MeetingRoom(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                Intrinsics.checkNotNullParameter(str, "displayName");
                Intrinsics.checkNotNullParameter(str2, "responseStatus");
                Intrinsics.checkNotNullParameter(str3, "roomId");
                this.displayName = str;
                this.responseStatus = str2;
                this.roomId = str3;
            }

            public static /* synthetic */ MeetingRoom copy$default(MeetingRoom meetingRoom, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = meetingRoom.displayName;
                }
                if ((i & 2) != 0) {
                    str2 = meetingRoom.responseStatus;
                }
                if ((i & 4) != 0) {
                    str3 = meetingRoom.roomId;
                }
                return meetingRoom.copy(str, str2, str3);
            }

            @NotNull
            public final String component1() {
                return this.displayName;
            }

            @NotNull
            public final String component2() {
                return this.responseStatus;
            }

            @NotNull
            public final String component3() {
                return this.roomId;
            }

            @NotNull
            public final MeetingRoom copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                Intrinsics.checkNotNullParameter(str, "displayName");
                Intrinsics.checkNotNullParameter(str2, "responseStatus");
                Intrinsics.checkNotNullParameter(str3, "roomId");
                return new MeetingRoom(str, str2, str3);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MeetingRoom)) {
                    return false;
                }
                MeetingRoom meetingRoom = (MeetingRoom) obj;
                return Intrinsics.areEqual((Object) this.displayName, (Object) meetingRoom.displayName) && Intrinsics.areEqual((Object) this.responseStatus, (Object) meetingRoom.responseStatus) && Intrinsics.areEqual((Object) this.roomId, (Object) meetingRoom.roomId);
            }

            @NotNull
            public final String getDisplayName() {
                return this.displayName;
            }

            @NotNull
            public final String getResponseStatus() {
                return this.responseStatus;
            }

            @NotNull
            public final String getRoomId() {
                return this.roomId;
            }

            public int hashCode() {
                return (((this.displayName.hashCode() * 31) + this.responseStatus.hashCode()) * 31) + this.roomId.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.displayName;
                String str2 = this.responseStatus;
                String str3 = this.roomId;
                return "MeetingRoom(displayName=" + str + ", responseStatus=" + str2 + ", roomId=" + str3 + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$OnlineMeetingInfo;", "", "conferenceId", "", "type", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConferenceId", "()Ljava/lang/String;", "getType", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class OnlineMeetingInfo {
            @NotNull
            private final String conferenceId;
            @NotNull
            private final String type;
            @NotNull
            private final String url;

            public OnlineMeetingInfo(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                Intrinsics.checkNotNullParameter(str, "conferenceId");
                Intrinsics.checkNotNullParameter(str2, "type");
                Intrinsics.checkNotNullParameter(str3, "url");
                this.conferenceId = str;
                this.type = str2;
                this.url = str3;
            }

            public static /* synthetic */ OnlineMeetingInfo copy$default(OnlineMeetingInfo onlineMeetingInfo, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = onlineMeetingInfo.conferenceId;
                }
                if ((i & 2) != 0) {
                    str2 = onlineMeetingInfo.type;
                }
                if ((i & 4) != 0) {
                    str3 = onlineMeetingInfo.url;
                }
                return onlineMeetingInfo.copy(str, str2, str3);
            }

            @NotNull
            public final String component1() {
                return this.conferenceId;
            }

            @NotNull
            public final String component2() {
                return this.type;
            }

            @NotNull
            public final String component3() {
                return this.url;
            }

            @NotNull
            public final OnlineMeetingInfo copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                Intrinsics.checkNotNullParameter(str, "conferenceId");
                Intrinsics.checkNotNullParameter(str2, "type");
                Intrinsics.checkNotNullParameter(str3, "url");
                return new OnlineMeetingInfo(str, str2, str3);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof OnlineMeetingInfo)) {
                    return false;
                }
                OnlineMeetingInfo onlineMeetingInfo = (OnlineMeetingInfo) obj;
                return Intrinsics.areEqual((Object) this.conferenceId, (Object) onlineMeetingInfo.conferenceId) && Intrinsics.areEqual((Object) this.type, (Object) onlineMeetingInfo.type) && Intrinsics.areEqual((Object) this.url, (Object) onlineMeetingInfo.url);
            }

            @NotNull
            public final String getConferenceId() {
                return this.conferenceId;
            }

            @NotNull
            public final String getType() {
                return this.type;
            }

            @NotNull
            public final String getUrl() {
                return this.url;
            }

            public int hashCode() {
                return (((this.conferenceId.hashCode() * 31) + this.type.hashCode()) * 31) + this.url.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.conferenceId;
                String str2 = this.type;
                String str3 = this.url;
                return "OnlineMeetingInfo(conferenceId=" + str + ", type=" + str2 + ", url=" + str3 + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Organizer;", "", "displayName", "", "id", "responseStatus", "self", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDisplayName", "()Ljava/lang/String;", "getId", "getResponseStatus", "getSelf", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Organizer {
            @NotNull
            private final String displayName;
            @NotNull
            private final String id;
            @NotNull
            private final String responseStatus;
            private final boolean self;

            public Organizer(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
                Intrinsics.checkNotNullParameter(str, "displayName");
                Intrinsics.checkNotNullParameter(str2, "id");
                Intrinsics.checkNotNullParameter(str3, "responseStatus");
                this.displayName = str;
                this.id = str2;
                this.responseStatus = str3;
                this.self = z;
            }

            public static /* synthetic */ Organizer copy$default(Organizer organizer, String str, String str2, String str3, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = organizer.displayName;
                }
                if ((i & 2) != 0) {
                    str2 = organizer.id;
                }
                if ((i & 4) != 0) {
                    str3 = organizer.responseStatus;
                }
                if ((i & 8) != 0) {
                    z = organizer.self;
                }
                return organizer.copy(str, str2, str3, z);
            }

            @NotNull
            public final String component1() {
                return this.displayName;
            }

            @NotNull
            public final String component2() {
                return this.id;
            }

            @NotNull
            public final String component3() {
                return this.responseStatus;
            }

            public final boolean component4() {
                return this.self;
            }

            @NotNull
            public final Organizer copy(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
                Intrinsics.checkNotNullParameter(str, "displayName");
                Intrinsics.checkNotNullParameter(str2, "id");
                Intrinsics.checkNotNullParameter(str3, "responseStatus");
                return new Organizer(str, str2, str3, z);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Organizer)) {
                    return false;
                }
                Organizer organizer = (Organizer) obj;
                return Intrinsics.areEqual((Object) this.displayName, (Object) organizer.displayName) && Intrinsics.areEqual((Object) this.id, (Object) organizer.id) && Intrinsics.areEqual((Object) this.responseStatus, (Object) organizer.responseStatus) && this.self == organizer.self;
            }

            @NotNull
            public final String getDisplayName() {
                return this.displayName;
            }

            @NotNull
            public final String getId() {
                return this.id;
            }

            @NotNull
            public final String getResponseStatus() {
                return this.responseStatus;
            }

            public final boolean getSelf() {
                return this.self;
            }

            public int hashCode() {
                return (((((this.displayName.hashCode() * 31) + this.id.hashCode()) * 31) + this.responseStatus.hashCode()) * 31) + Boolean.hashCode(this.self);
            }

            @NotNull
            public String toString() {
                String str = this.displayName;
                String str2 = this.id;
                String str3 = this.responseStatus;
                boolean z = this.self;
                return "Organizer(displayName=" + str + ", id=" + str2 + ", responseStatus=" + str3 + ", self=" + z + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$OriginStart;", "", "dateTime", "", "(Ljava/lang/String;)V", "getDateTime", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class OriginStart {
            @NotNull
            private final String dateTime;

            public OriginStart(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "dateTime");
                this.dateTime = str;
            }

            public static /* synthetic */ OriginStart copy$default(OriginStart originStart, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = originStart.dateTime;
                }
                return originStart.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.dateTime;
            }

            @NotNull
            public final OriginStart copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "dateTime");
                return new OriginStart(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof OriginStart) && Intrinsics.areEqual((Object) this.dateTime, (Object) ((OriginStart) obj).dateTime);
            }

            @NotNull
            public final String getDateTime() {
                return this.dateTime;
            }

            public int hashCode() {
                return this.dateTime.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.dateTime;
                return "OriginStart(dateTime=" + str + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Recurrence;", "", "pattern", "Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Recurrence$Pattern;", "range", "Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Recurrence$Range;", "(Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Recurrence$Pattern;Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Recurrence$Range;)V", "getPattern", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Recurrence$Pattern;", "getRange", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Recurrence$Range;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Pattern", "Range", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Recurrence {
            @NotNull
            private final Pattern pattern;
            @NotNull
            private final Range range;

            @Keep
            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Recurrence$Pattern;", "", "dayOfMonth", "", "daysOfWeek", "", "index", "interval", "type", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getDayOfMonth", "()I", "getDaysOfWeek", "()Ljava/lang/String;", "getIndex", "getInterval", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Pattern {
                private final int dayOfMonth;
                @NotNull
                private final String daysOfWeek;
                @NotNull
                private final String index;
                private final int interval;
                @NotNull
                private final String type;

                public Pattern(int i, @NotNull String str, @NotNull String str2, int i2, @NotNull String str3) {
                    Intrinsics.checkNotNullParameter(str, "daysOfWeek");
                    Intrinsics.checkNotNullParameter(str2, "index");
                    Intrinsics.checkNotNullParameter(str3, "type");
                    this.dayOfMonth = i;
                    this.daysOfWeek = str;
                    this.index = str2;
                    this.interval = i2;
                    this.type = str3;
                }

                public static /* synthetic */ Pattern copy$default(Pattern pattern, int i, String str, String str2, int i2, String str3, int i3, Object obj) {
                    if ((i3 & 1) != 0) {
                        i = pattern.dayOfMonth;
                    }
                    if ((i3 & 2) != 0) {
                        str = pattern.daysOfWeek;
                    }
                    String str4 = str;
                    if ((i3 & 4) != 0) {
                        str2 = pattern.index;
                    }
                    String str5 = str2;
                    if ((i3 & 8) != 0) {
                        i2 = pattern.interval;
                    }
                    int i4 = i2;
                    if ((i3 & 16) != 0) {
                        str3 = pattern.type;
                    }
                    return pattern.copy(i, str4, str5, i4, str3);
                }

                public final int component1() {
                    return this.dayOfMonth;
                }

                @NotNull
                public final String component2() {
                    return this.daysOfWeek;
                }

                @NotNull
                public final String component3() {
                    return this.index;
                }

                public final int component4() {
                    return this.interval;
                }

                @NotNull
                public final String component5() {
                    return this.type;
                }

                @NotNull
                public final Pattern copy(int i, @NotNull String str, @NotNull String str2, int i2, @NotNull String str3) {
                    Intrinsics.checkNotNullParameter(str, "daysOfWeek");
                    Intrinsics.checkNotNullParameter(str2, "index");
                    Intrinsics.checkNotNullParameter(str3, "type");
                    return new Pattern(i, str, str2, i2, str3);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Pattern)) {
                        return false;
                    }
                    Pattern pattern = (Pattern) obj;
                    return this.dayOfMonth == pattern.dayOfMonth && Intrinsics.areEqual((Object) this.daysOfWeek, (Object) pattern.daysOfWeek) && Intrinsics.areEqual((Object) this.index, (Object) pattern.index) && this.interval == pattern.interval && Intrinsics.areEqual((Object) this.type, (Object) pattern.type);
                }

                public final int getDayOfMonth() {
                    return this.dayOfMonth;
                }

                @NotNull
                public final String getDaysOfWeek() {
                    return this.daysOfWeek;
                }

                @NotNull
                public final String getIndex() {
                    return this.index;
                }

                public final int getInterval() {
                    return this.interval;
                }

                @NotNull
                public final String getType() {
                    return this.type;
                }

                public int hashCode() {
                    return (((((((Integer.hashCode(this.dayOfMonth) * 31) + this.daysOfWeek.hashCode()) * 31) + this.index.hashCode()) * 31) + Integer.hashCode(this.interval)) * 31) + this.type.hashCode();
                }

                @NotNull
                public String toString() {
                    int i = this.dayOfMonth;
                    String str = this.daysOfWeek;
                    String str2 = this.index;
                    int i2 = this.interval;
                    String str3 = this.type;
                    return "Pattern(dayOfMonth=" + i + ", daysOfWeek=" + str + ", index=" + str2 + ", interval=" + i2 + ", type=" + str3 + ")";
                }
            }

            @Keep
            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Recurrence$Range;", "", "endDate", "", "numberOfOccurrences", "", "type", "(Ljava/lang/String;ILjava/lang/String;)V", "getEndDate", "()Ljava/lang/String;", "getNumberOfOccurrences", "()I", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Range {
                @NotNull
                private final String endDate;
                private final int numberOfOccurrences;
                @NotNull
                private final String type;

                public Range(@NotNull String str, int i, @NotNull String str2) {
                    Intrinsics.checkNotNullParameter(str, "endDate");
                    Intrinsics.checkNotNullParameter(str2, "type");
                    this.endDate = str;
                    this.numberOfOccurrences = i;
                    this.type = str2;
                }

                public static /* synthetic */ Range copy$default(Range range, String str, int i, String str2, int i2, Object obj) {
                    if ((i2 & 1) != 0) {
                        str = range.endDate;
                    }
                    if ((i2 & 2) != 0) {
                        i = range.numberOfOccurrences;
                    }
                    if ((i2 & 4) != 0) {
                        str2 = range.type;
                    }
                    return range.copy(str, i, str2);
                }

                @NotNull
                public final String component1() {
                    return this.endDate;
                }

                public final int component2() {
                    return this.numberOfOccurrences;
                }

                @NotNull
                public final String component3() {
                    return this.type;
                }

                @NotNull
                public final Range copy(@NotNull String str, int i, @NotNull String str2) {
                    Intrinsics.checkNotNullParameter(str, "endDate");
                    Intrinsics.checkNotNullParameter(str2, "type");
                    return new Range(str, i, str2);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Range)) {
                        return false;
                    }
                    Range range = (Range) obj;
                    return Intrinsics.areEqual((Object) this.endDate, (Object) range.endDate) && this.numberOfOccurrences == range.numberOfOccurrences && Intrinsics.areEqual((Object) this.type, (Object) range.type);
                }

                @NotNull
                public final String getEndDate() {
                    return this.endDate;
                }

                public final int getNumberOfOccurrences() {
                    return this.numberOfOccurrences;
                }

                @NotNull
                public final String getType() {
                    return this.type;
                }

                public int hashCode() {
                    return (((this.endDate.hashCode() * 31) + Integer.hashCode(this.numberOfOccurrences)) * 31) + this.type.hashCode();
                }

                @NotNull
                public String toString() {
                    String str = this.endDate;
                    int i = this.numberOfOccurrences;
                    String str2 = this.type;
                    return "Range(endDate=" + str + ", numberOfOccurrences=" + i + ", type=" + str2 + ")";
                }
            }

            public Recurrence(@NotNull Pattern pattern2, @NotNull Range range2) {
                Intrinsics.checkNotNullParameter(pattern2, "pattern");
                Intrinsics.checkNotNullParameter(range2, "range");
                this.pattern = pattern2;
                this.range = range2;
            }

            public static /* synthetic */ Recurrence copy$default(Recurrence recurrence, Pattern pattern2, Range range2, int i, Object obj) {
                if ((i & 1) != 0) {
                    pattern2 = recurrence.pattern;
                }
                if ((i & 2) != 0) {
                    range2 = recurrence.range;
                }
                return recurrence.copy(pattern2, range2);
            }

            @NotNull
            public final Pattern component1() {
                return this.pattern;
            }

            @NotNull
            public final Range component2() {
                return this.range;
            }

            @NotNull
            public final Recurrence copy(@NotNull Pattern pattern2, @NotNull Range range2) {
                Intrinsics.checkNotNullParameter(pattern2, "pattern");
                Intrinsics.checkNotNullParameter(range2, "range");
                return new Recurrence(pattern2, range2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Recurrence)) {
                    return false;
                }
                Recurrence recurrence = (Recurrence) obj;
                return Intrinsics.areEqual((Object) this.pattern, (Object) recurrence.pattern) && Intrinsics.areEqual((Object) this.range, (Object) recurrence.range);
            }

            @NotNull
            public final Pattern getPattern() {
                return this.pattern;
            }

            @NotNull
            public final Range getRange() {
                return this.range;
            }

            public int hashCode() {
                return (this.pattern.hashCode() * 31) + this.range.hashCode();
            }

            @NotNull
            public String toString() {
                Pattern pattern2 = this.pattern;
                Range range2 = this.range;
                return "Recurrence(pattern=" + pattern2 + ", range=" + range2 + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Reminder;", "", "method", "", "minutes", "(Ljava/lang/String;Ljava/lang/String;)V", "getMethod", "()Ljava/lang/String;", "getMinutes", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Reminder {
            @NotNull
            private final String method;
            @NotNull
            private final String minutes;

            public Reminder(@NotNull String str, @NotNull String str2) {
                Intrinsics.checkNotNullParameter(str, "method");
                Intrinsics.checkNotNullParameter(str2, "minutes");
                this.method = str;
                this.minutes = str2;
            }

            public static /* synthetic */ Reminder copy$default(Reminder reminder, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = reminder.method;
                }
                if ((i & 2) != 0) {
                    str2 = reminder.minutes;
                }
                return reminder.copy(str, str2);
            }

            @NotNull
            public final String component1() {
                return this.method;
            }

            @NotNull
            public final String component2() {
                return this.minutes;
            }

            @NotNull
            public final Reminder copy(@NotNull String str, @NotNull String str2) {
                Intrinsics.checkNotNullParameter(str, "method");
                Intrinsics.checkNotNullParameter(str2, "minutes");
                return new Reminder(str, str2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Reminder)) {
                    return false;
                }
                Reminder reminder = (Reminder) obj;
                return Intrinsics.areEqual((Object) this.method, (Object) reminder.method) && Intrinsics.areEqual((Object) this.minutes, (Object) reminder.minutes);
            }

            @NotNull
            public final String getMethod() {
                return this.method;
            }

            @NotNull
            public final String getMinutes() {
                return this.minutes;
            }

            public int hashCode() {
                return (this.method.hashCode() * 31) + this.minutes.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.method;
                String str2 = this.minutes;
                return "Reminder(method=" + str + ", minutes=" + str2 + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel$Event$Start;", "", "date", "", "dateTime", "timeZone", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getDateTime", "getTimeZone", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Start {
            @NotNull
            private final String date;
            @NotNull
            private final String dateTime;
            @NotNull
            private final String timeZone;

            public Start(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                Intrinsics.checkNotNullParameter(str, "date");
                Intrinsics.checkNotNullParameter(str2, "dateTime");
                Intrinsics.checkNotNullParameter(str3, "timeZone");
                this.date = str;
                this.dateTime = str2;
                this.timeZone = str3;
            }

            public static /* synthetic */ Start copy$default(Start start, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = start.date;
                }
                if ((i & 2) != 0) {
                    str2 = start.dateTime;
                }
                if ((i & 4) != 0) {
                    str3 = start.timeZone;
                }
                return start.copy(str, str2, str3);
            }

            @NotNull
            public final String component1() {
                return this.date;
            }

            @NotNull
            public final String component2() {
                return this.dateTime;
            }

            @NotNull
            public final String component3() {
                return this.timeZone;
            }

            @NotNull
            public final Start copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                Intrinsics.checkNotNullParameter(str, "date");
                Intrinsics.checkNotNullParameter(str2, "dateTime");
                Intrinsics.checkNotNullParameter(str3, "timeZone");
                return new Start(str, str2, str3);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Start)) {
                    return false;
                }
                Start start = (Start) obj;
                return Intrinsics.areEqual((Object) this.date, (Object) start.date) && Intrinsics.areEqual((Object) this.dateTime, (Object) start.dateTime) && Intrinsics.areEqual((Object) this.timeZone, (Object) start.timeZone);
            }

            @NotNull
            public final String getDate() {
                return this.date;
            }

            @NotNull
            public final String getDateTime() {
                return this.dateTime;
            }

            @NotNull
            public final String getTimeZone() {
                return this.timeZone;
            }

            public int hashCode() {
                return (((this.date.hashCode() * 31) + this.dateTime.hashCode()) * 31) + this.timeZone.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.date;
                String str2 = this.dateTime;
                String str3 = this.timeZone;
                return "Start(date=" + str + ", dateTime=" + str2 + ", timeZone=" + str3 + ")";
            }
        }

        public Event(@NotNull List<Attendee> list, @NotNull List<Category> list2, @NotNull String str, @NotNull String str2, @NotNull End end2, @NotNull ExtendedProperties extendedProperties2, @NotNull String str3, boolean z, @NotNull Location location2, @NotNull List<MeetingRoom> list3, @NotNull OnlineMeetingInfo onlineMeetingInfo2, @NotNull Organizer organizer2, @NotNull OriginStart originStart2, @NotNull Recurrence recurrence2, @NotNull List<Reminder> list4, @NotNull String str4, @NotNull Start start2, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
            List<Attendee> list5 = list;
            List<Category> list6 = list2;
            String str8 = str;
            String str9 = str2;
            End end3 = end2;
            ExtendedProperties extendedProperties3 = extendedProperties2;
            String str10 = str3;
            Location location3 = location2;
            List<MeetingRoom> list7 = list3;
            OnlineMeetingInfo onlineMeetingInfo3 = onlineMeetingInfo2;
            Organizer organizer3 = organizer2;
            OriginStart originStart3 = originStart2;
            Recurrence recurrence3 = recurrence2;
            List<Reminder> list8 = list4;
            Start start3 = start2;
            Intrinsics.checkNotNullParameter(list5, "attendees");
            Intrinsics.checkNotNullParameter(list6, "categories");
            Intrinsics.checkNotNullParameter(str8, "createTime");
            Intrinsics.checkNotNullParameter(str9, "description");
            Intrinsics.checkNotNullParameter(end3, "end");
            Intrinsics.checkNotNullParameter(extendedProperties3, "extendedProperties");
            Intrinsics.checkNotNullParameter(str10, "id");
            Intrinsics.checkNotNullParameter(location3, "location");
            Intrinsics.checkNotNullParameter(list7, "meetingRooms");
            Intrinsics.checkNotNullParameter(onlineMeetingInfo3, "onlineMeetingInfo");
            Intrinsics.checkNotNullParameter(organizer3, "organizer");
            Intrinsics.checkNotNullParameter(originStart3, "originStart");
            Intrinsics.checkNotNullParameter(recurrence3, "recurrence");
            Intrinsics.checkNotNullParameter(list8, "reminders");
            Intrinsics.checkNotNullParameter(str4, "seriesMasterId");
            Intrinsics.checkNotNullParameter(start2, MzContactsContract.START_PARAM_KEY);
            Intrinsics.checkNotNullParameter(str5, "status");
            Intrinsics.checkNotNullParameter(str6, "summary");
            Intrinsics.checkNotNullParameter(str7, "updateTime");
            this.attendees = list5;
            this.categories = list6;
            this.createTime = str8;
            this.description = str9;
            this.end = end3;
            this.extendedProperties = extendedProperties3;
            this.id = str10;
            this.isAllDay = z;
            this.location = location3;
            this.meetingRooms = list7;
            this.onlineMeetingInfo = onlineMeetingInfo3;
            this.organizer = organizer3;
            this.originStart = originStart3;
            this.recurrence = recurrence3;
            this.reminders = list8;
            this.seriesMasterId = str4;
            this.start = start2;
            this.status = str5;
            this.summary = str6;
            this.updateTime = str7;
        }

        public static /* synthetic */ Event copy$default(Event event, List list, List list2, String str, String str2, End end2, ExtendedProperties extendedProperties2, String str3, boolean z, Location location2, List list3, OnlineMeetingInfo onlineMeetingInfo2, Organizer organizer2, OriginStart originStart2, Recurrence recurrence2, List list4, String str4, Start start2, String str5, String str6, String str7, int i, Object obj) {
            Event event2 = event;
            int i2 = i;
            return event.copy((i2 & 1) != 0 ? event2.attendees : list, (i2 & 2) != 0 ? event2.categories : list2, (i2 & 4) != 0 ? event2.createTime : str, (i2 & 8) != 0 ? event2.description : str2, (i2 & 16) != 0 ? event2.end : end2, (i2 & 32) != 0 ? event2.extendedProperties : extendedProperties2, (i2 & 64) != 0 ? event2.id : str3, (i2 & 128) != 0 ? event2.isAllDay : z, (i2 & 256) != 0 ? event2.location : location2, (i2 & 512) != 0 ? event2.meetingRooms : list3, (i2 & 1024) != 0 ? event2.onlineMeetingInfo : onlineMeetingInfo2, (i2 & 2048) != 0 ? event2.organizer : organizer2, (i2 & 4096) != 0 ? event2.originStart : originStart2, (i2 & 8192) != 0 ? event2.recurrence : recurrence2, (i2 & 16384) != 0 ? event2.reminders : list4, (i2 & 32768) != 0 ? event2.seriesMasterId : str4, (i2 & 65536) != 0 ? event2.start : start2, (i2 & 131072) != 0 ? event2.status : str5, (i2 & PositionEstimate.Value.BUILDING_NAME) != 0 ? event2.summary : str6, (i2 & PositionEstimate.Value.TIME_SINCE_BOOT) != 0 ? event2.updateTime : str7);
        }

        @NotNull
        public final List<Attendee> component1() {
            return this.attendees;
        }

        @NotNull
        public final List<MeetingRoom> component10() {
            return this.meetingRooms;
        }

        @NotNull
        public final OnlineMeetingInfo component11() {
            return this.onlineMeetingInfo;
        }

        @NotNull
        public final Organizer component12() {
            return this.organizer;
        }

        @NotNull
        public final OriginStart component13() {
            return this.originStart;
        }

        @NotNull
        public final Recurrence component14() {
            return this.recurrence;
        }

        @NotNull
        public final List<Reminder> component15() {
            return this.reminders;
        }

        @NotNull
        public final String component16() {
            return this.seriesMasterId;
        }

        @NotNull
        public final Start component17() {
            return this.start;
        }

        @NotNull
        public final String component18() {
            return this.status;
        }

        @NotNull
        public final String component19() {
            return this.summary;
        }

        @NotNull
        public final List<Category> component2() {
            return this.categories;
        }

        @NotNull
        public final String component20() {
            return this.updateTime;
        }

        @NotNull
        public final String component3() {
            return this.createTime;
        }

        @NotNull
        public final String component4() {
            return this.description;
        }

        @NotNull
        public final End component5() {
            return this.end;
        }

        @NotNull
        public final ExtendedProperties component6() {
            return this.extendedProperties;
        }

        @NotNull
        public final String component7() {
            return this.id;
        }

        public final boolean component8() {
            return this.isAllDay;
        }

        @NotNull
        public final Location component9() {
            return this.location;
        }

        @NotNull
        public final Event copy(@NotNull List<Attendee> list, @NotNull List<Category> list2, @NotNull String str, @NotNull String str2, @NotNull End end2, @NotNull ExtendedProperties extendedProperties2, @NotNull String str3, boolean z, @NotNull Location location2, @NotNull List<MeetingRoom> list3, @NotNull OnlineMeetingInfo onlineMeetingInfo2, @NotNull Organizer organizer2, @NotNull OriginStart originStart2, @NotNull Recurrence recurrence2, @NotNull List<Reminder> list4, @NotNull String str4, @NotNull Start start2, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
            List<Attendee> list5 = list;
            Intrinsics.checkNotNullParameter(list5, "attendees");
            Intrinsics.checkNotNullParameter(list2, "categories");
            Intrinsics.checkNotNullParameter(str, "createTime");
            Intrinsics.checkNotNullParameter(str2, "description");
            Intrinsics.checkNotNullParameter(end2, "end");
            Intrinsics.checkNotNullParameter(extendedProperties2, "extendedProperties");
            Intrinsics.checkNotNullParameter(str3, "id");
            Intrinsics.checkNotNullParameter(location2, "location");
            Intrinsics.checkNotNullParameter(list3, "meetingRooms");
            Intrinsics.checkNotNullParameter(onlineMeetingInfo2, "onlineMeetingInfo");
            Intrinsics.checkNotNullParameter(organizer2, "organizer");
            Intrinsics.checkNotNullParameter(originStart2, "originStart");
            Intrinsics.checkNotNullParameter(recurrence2, "recurrence");
            Intrinsics.checkNotNullParameter(list4, "reminders");
            Intrinsics.checkNotNullParameter(str4, "seriesMasterId");
            Intrinsics.checkNotNullParameter(start2, MzContactsContract.START_PARAM_KEY);
            Intrinsics.checkNotNullParameter(str5, "status");
            Intrinsics.checkNotNullParameter(str6, "summary");
            Intrinsics.checkNotNullParameter(str7, "updateTime");
            return new Event(list5, list2, str, str2, end2, extendedProperties2, str3, z, location2, list3, onlineMeetingInfo2, organizer2, originStart2, recurrence2, list4, str4, start2, str5, str6, str7);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Event)) {
                return false;
            }
            Event event = (Event) obj;
            return Intrinsics.areEqual((Object) this.attendees, (Object) event.attendees) && Intrinsics.areEqual((Object) this.categories, (Object) event.categories) && Intrinsics.areEqual((Object) this.createTime, (Object) event.createTime) && Intrinsics.areEqual((Object) this.description, (Object) event.description) && Intrinsics.areEqual((Object) this.end, (Object) event.end) && Intrinsics.areEqual((Object) this.extendedProperties, (Object) event.extendedProperties) && Intrinsics.areEqual((Object) this.id, (Object) event.id) && this.isAllDay == event.isAllDay && Intrinsics.areEqual((Object) this.location, (Object) event.location) && Intrinsics.areEqual((Object) this.meetingRooms, (Object) event.meetingRooms) && Intrinsics.areEqual((Object) this.onlineMeetingInfo, (Object) event.onlineMeetingInfo) && Intrinsics.areEqual((Object) this.organizer, (Object) event.organizer) && Intrinsics.areEqual((Object) this.originStart, (Object) event.originStart) && Intrinsics.areEqual((Object) this.recurrence, (Object) event.recurrence) && Intrinsics.areEqual((Object) this.reminders, (Object) event.reminders) && Intrinsics.areEqual((Object) this.seriesMasterId, (Object) event.seriesMasterId) && Intrinsics.areEqual((Object) this.start, (Object) event.start) && Intrinsics.areEqual((Object) this.status, (Object) event.status) && Intrinsics.areEqual((Object) this.summary, (Object) event.summary) && Intrinsics.areEqual((Object) this.updateTime, (Object) event.updateTime);
        }

        @NotNull
        public final List<Attendee> getAttendees() {
            return this.attendees;
        }

        @NotNull
        public final List<Category> getCategories() {
            return this.categories;
        }

        @NotNull
        public final String getCreateTime() {
            return this.createTime;
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final End getEnd() {
            return this.end;
        }

        @NotNull
        public final ExtendedProperties getExtendedProperties() {
            return this.extendedProperties;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final Location getLocation() {
            return this.location;
        }

        @NotNull
        public final List<MeetingRoom> getMeetingRooms() {
            return this.meetingRooms;
        }

        @NotNull
        public final OnlineMeetingInfo getOnlineMeetingInfo() {
            return this.onlineMeetingInfo;
        }

        @NotNull
        public final Organizer getOrganizer() {
            return this.organizer;
        }

        @NotNull
        public final OriginStart getOriginStart() {
            return this.originStart;
        }

        @NotNull
        public final Recurrence getRecurrence() {
            return this.recurrence;
        }

        @NotNull
        public final List<Reminder> getReminders() {
            return this.reminders;
        }

        @NotNull
        public final String getSeriesMasterId() {
            return this.seriesMasterId;
        }

        @NotNull
        public final Start getStart() {
            return this.start;
        }

        @NotNull
        public final String getStatus() {
            return this.status;
        }

        @NotNull
        public final String getSummary() {
            return this.summary;
        }

        @NotNull
        public final String getUpdateTime() {
            return this.updateTime;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((this.attendees.hashCode() * 31) + this.categories.hashCode()) * 31) + this.createTime.hashCode()) * 31) + this.description.hashCode()) * 31) + this.end.hashCode()) * 31) + this.extendedProperties.hashCode()) * 31) + this.id.hashCode()) * 31) + Boolean.hashCode(this.isAllDay)) * 31) + this.location.hashCode()) * 31) + this.meetingRooms.hashCode()) * 31) + this.onlineMeetingInfo.hashCode()) * 31) + this.organizer.hashCode()) * 31) + this.originStart.hashCode()) * 31) + this.recurrence.hashCode()) * 31) + this.reminders.hashCode()) * 31) + this.seriesMasterId.hashCode()) * 31) + this.start.hashCode()) * 31) + this.status.hashCode()) * 31) + this.summary.hashCode()) * 31) + this.updateTime.hashCode();
        }

        public final boolean isAllDay() {
            return this.isAllDay;
        }

        @NotNull
        public String toString() {
            List<Attendee> list = this.attendees;
            List<Category> list2 = this.categories;
            String str = this.createTime;
            String str2 = this.description;
            End end2 = this.end;
            ExtendedProperties extendedProperties2 = this.extendedProperties;
            String str3 = this.id;
            boolean z = this.isAllDay;
            Location location2 = this.location;
            List<MeetingRoom> list3 = this.meetingRooms;
            OnlineMeetingInfo onlineMeetingInfo2 = this.onlineMeetingInfo;
            Organizer organizer2 = this.organizer;
            OriginStart originStart2 = this.originStart;
            Recurrence recurrence2 = this.recurrence;
            List<Reminder> list4 = this.reminders;
            String str4 = this.seriesMasterId;
            Start start2 = this.start;
            String str5 = this.status;
            String str6 = this.summary;
            String str7 = this.updateTime;
            return "Event(attendees=" + list + ", categories=" + list2 + ", createTime=" + str + ", description=" + str2 + ", end=" + end2 + ", extendedProperties=" + extendedProperties2 + ", id=" + str3 + ", isAllDay=" + z + ", location=" + location2 + ", meetingRooms=" + list3 + ", onlineMeetingInfo=" + onlineMeetingInfo2 + ", organizer=" + organizer2 + ", originStart=" + originStart2 + ", recurrence=" + recurrence2 + ", reminders=" + list4 + ", seriesMasterId=" + str4 + ", start=" + start2 + ", status=" + str5 + ", summary=" + str6 + ", updateTime=" + str7 + ")";
        }
    }

    public DdScheduleArrayRespModel(@NotNull List<Event> list, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(list, "events");
        Intrinsics.checkNotNullParameter(str, "nextToken");
        Intrinsics.checkNotNullParameter(str2, "syncToken");
        this.events = list;
        this.nextToken = str;
        this.syncToken = str2;
    }

    public static /* synthetic */ DdScheduleArrayRespModel copy$default(DdScheduleArrayRespModel ddScheduleArrayRespModel, List<Event> list, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = ddScheduleArrayRespModel.events;
        }
        if ((i & 2) != 0) {
            str = ddScheduleArrayRespModel.nextToken;
        }
        if ((i & 4) != 0) {
            str2 = ddScheduleArrayRespModel.syncToken;
        }
        return ddScheduleArrayRespModel.copy(list, str, str2);
    }

    @NotNull
    public final List<Event> component1() {
        return this.events;
    }

    @NotNull
    public final String component2() {
        return this.nextToken;
    }

    @NotNull
    public final String component3() {
        return this.syncToken;
    }

    @NotNull
    public final DdScheduleArrayRespModel copy(@NotNull List<Event> list, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(list, "events");
        Intrinsics.checkNotNullParameter(str, "nextToken");
        Intrinsics.checkNotNullParameter(str2, "syncToken");
        return new DdScheduleArrayRespModel(list, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DdScheduleArrayRespModel)) {
            return false;
        }
        DdScheduleArrayRespModel ddScheduleArrayRespModel = (DdScheduleArrayRespModel) obj;
        return Intrinsics.areEqual((Object) this.events, (Object) ddScheduleArrayRespModel.events) && Intrinsics.areEqual((Object) this.nextToken, (Object) ddScheduleArrayRespModel.nextToken) && Intrinsics.areEqual((Object) this.syncToken, (Object) ddScheduleArrayRespModel.syncToken);
    }

    @NotNull
    public final List<Event> getEvents() {
        return this.events;
    }

    @NotNull
    public final String getNextToken() {
        return this.nextToken;
    }

    @NotNull
    public final String getSyncToken() {
        return this.syncToken;
    }

    public int hashCode() {
        return (((this.events.hashCode() * 31) + this.nextToken.hashCode()) * 31) + this.syncToken.hashCode();
    }

    @NotNull
    public String toString() {
        List<Event> list = this.events;
        String str = this.nextToken;
        String str2 = this.syncToken;
        return "DdScheduleArrayRespModel(events=" + list + ", nextToken=" + str + ", syncToken=" + str2 + ")";
    }
}
