package com.xjsd.ai.assistant.protocol.schedule;

import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\n¨\u0006!"}, d2 = {"Lcom/xjsd/ai/assistant/protocol/schedule/Instance;", "", "c", "Landroid/database/Cursor;", "(Landroid/database/Cursor;)V", "begin", "", "getBegin", "()J", "setBegin", "(J)V", "end", "getEnd", "setEnd", "endDay", "getEndDay", "setEndDay", "eventId", "", "getEventId", "()Ljava/lang/String;", "setEventId", "(Ljava/lang/String;)V", "id", "getId", "setId", "startDay", "getStartDay", "setStartDay", "timeToString", "time", "toString", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Instance {
    /* access modifiers changed from: private */
    public static final int COLUMN_BEGIN = 2;
    /* access modifiers changed from: private */
    public static final int COLUMN_END = 3;
    /* access modifiers changed from: private */
    public static final int COLUMN_END_DAY = 5;
    /* access modifiers changed from: private */
    public static final int COLUMN_EVENT_ID = 1;
    /* access modifiers changed from: private */
    public static final int COLUMN_ID = 0;
    /* access modifiers changed from: private */
    public static final int COLUMN_START_DAY = 4;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final String[] INSTANCE_COLUMNS = {"_id", "event_id", "begin", "end", "startDay", "endDay"};
    /* access modifiers changed from: private */
    public static final Uri INSTANCE_CONTENT_URI = CalendarContract.Instances.CONTENT_URI;
    private long begin;
    private long end;
    private long endDay;
    @NotNull
    private String eventId = "";
    @NotNull
    private String id = "";
    private long startDay;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0019\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/xjsd/ai/assistant/protocol/schedule/Instance$Companion;", "", "()V", "COLUMN_BEGIN", "", "getCOLUMN_BEGIN", "()I", "COLUMN_END", "getCOLUMN_END", "COLUMN_END_DAY", "getCOLUMN_END_DAY", "COLUMN_EVENT_ID", "getCOLUMN_EVENT_ID", "COLUMN_ID", "getCOLUMN_ID", "COLUMN_START_DAY", "getCOLUMN_START_DAY", "INSTANCE_COLUMNS", "", "", "getINSTANCE_COLUMNS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "INSTANCE_CONTENT_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "getINSTANCE_CONTENT_URI", "()Landroid/net/Uri;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getCOLUMN_BEGIN() {
            return Instance.COLUMN_BEGIN;
        }

        public final int getCOLUMN_END() {
            return Instance.COLUMN_END;
        }

        public final int getCOLUMN_END_DAY() {
            return Instance.COLUMN_END_DAY;
        }

        public final int getCOLUMN_EVENT_ID() {
            return Instance.COLUMN_EVENT_ID;
        }

        public final int getCOLUMN_ID() {
            return Instance.COLUMN_ID;
        }

        public final int getCOLUMN_START_DAY() {
            return Instance.COLUMN_START_DAY;
        }

        @NotNull
        public final String[] getINSTANCE_COLUMNS() {
            return Instance.INSTANCE_COLUMNS;
        }

        public final Uri getINSTANCE_CONTENT_URI() {
            return Instance.INSTANCE_CONTENT_URI;
        }

        private Companion() {
        }
    }

    public Instance(@NotNull Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "c");
        this.id = String.valueOf(cursor.getLong(COLUMN_ID));
        this.eventId = String.valueOf(cursor.getLong(COLUMN_EVENT_ID));
        this.begin = cursor.getLong(COLUMN_BEGIN);
        this.end = cursor.getLong(COLUMN_END);
        this.startDay = cursor.getLong(COLUMN_START_DAY);
        this.endDay = cursor.getLong(COLUMN_END_DAY);
    }

    private final String timeToString(long j) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public final long getBegin() {
        return this.begin;
    }

    public final long getEnd() {
        return this.end;
    }

    public final long getEndDay() {
        return this.endDay;
    }

    @NotNull
    public final String getEventId() {
        return this.eventId;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final long getStartDay() {
        return this.startDay;
    }

    public final void setBegin(long j) {
        this.begin = j;
    }

    public final void setEnd(long j) {
        this.end = j;
    }

    public final void setEndDay(long j) {
        this.endDay = j;
    }

    public final void setEventId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.eventId = str;
    }

    public final void setId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final void setStartDay(long j) {
        this.startDay = j;
    }

    @NotNull
    public String toString() {
        String str = this.eventId;
        String timeToString = timeToString(this.begin);
        String timeToString2 = timeToString(this.end);
        String str2 = this.id;
        return "Instance(eventId=" + str + ", begin=" + timeToString + ", end=" + timeToString2 + ", id=" + str2 + ")";
    }
}
