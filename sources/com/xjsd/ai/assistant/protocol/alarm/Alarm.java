package com.xjsd.ai.assistant.protocol.alarm;

import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010;\u001a\u00020\u00152\b\u0010<\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010=\u001a\u00020\u001eH\u0016J\b\u0010>\u001a\u00020-H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R\u001a\u00105\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010 \"\u0004\b7\u0010\"R\u001a\u00108\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0017\"\u0004\b:\u0010\u0019¨\u0006@"}, d2 = {"Lcom/xjsd/ai/assistant/protocol/alarm/Alarm;", "", "()V", "c", "Landroid/database/Cursor;", "(Landroid/database/Cursor;)V", "alarm", "(Lcom/xjsd/ai/assistant/protocol/alarm/Alarm;)V", "alert", "Landroid/net/Uri;", "getAlert", "()Landroid/net/Uri;", "setAlert", "(Landroid/net/Uri;)V", "daysOfWeek", "Lcom/xjsd/ai/assistant/protocol/alarm/Weekdays;", "getDaysOfWeek", "()Lcom/xjsd/ai/assistant/protocol/alarm/Weekdays;", "setDaysOfWeek", "(Lcom/xjsd/ai/assistant/protocol/alarm/Weekdays;)V", "deleteAfterUse", "", "getDeleteAfterUse", "()Z", "setDeleteAfterUse", "(Z)V", "enabled", "getEnabled", "setEnabled", "festival", "", "getFestival", "()I", "setFestival", "(I)V", "hour", "getHour", "setHour", "id", "", "getId", "()J", "setId", "(J)V", "label", "", "getLabel", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "minutes", "getMinutes", "setMinutes", "snoozeLength", "getSnoozeLength", "setSnoozeLength", "vibrate", "getVibrate", "setVibrate", "equals", "o", "hashCode", "toString", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Alarm {
    /* access modifiers changed from: private */
    public static final Uri ALARMS_WITH_INSTANCES_URI = Uri.parse("content://com.meizu.wearable.alarmclock/alarms_with_instances");
    @NotNull
    public static final String AUTHORITY = "com.meizu.wearable.alarmclock";
    /* access modifiers changed from: private */
    public static final Uri CONTENT_URI = Uri.parse("content://com.meizu.wearable.alarmclock/alarms");
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String DAILY_ENABLED = "daily_enabled";
    @NotNull
    public static final String DAYS_OF_WEEK = "daysofweek";
    private static final int DAYS_OF_WEEK_INDEX = 3;
    @NotNull
    public static final String DEFAULT_SORT_ORDER = "hour, minutes ASC, _id DESC";
    @NotNull
    public static final String DELETE_AFTER_USE = "delete_after_use";
    private static final int DELETE_AFTER_USE_INDEX = 9;
    @NotNull
    public static final String ENABLED = "enabled";
    private static final int ENABLED_INDEX = 4;
    @NotNull
    public static final String FESTIVAL = "festival";
    private static final int FESTIVAL_INDEX = 10;
    @NotNull
    public static final String HOUR = "hour";
    private static final int HOUR_INDEX = 1;
    private static final int ID_INDEX = 0;
    public static final long INVALID_ID = -1;
    @NotNull
    public static final String LABEL = "label";
    private static final int LABEL_INDEX = 6;
    @NotNull
    public static final String MINUTES = "minutes";
    private static final int MINUTES_INDEX = 2;
    /* access modifiers changed from: private */
    @NotNull
    public static final String[] QUERY_COLUMNS = {"_id", "hour", "minutes", "daysofweek", "enabled", "vibrate", "label", "ringtone", "snooze", "delete_after_use", "festival"};
    @NotNull
    public static final String RINGTONE = "ringtone";
    private static final int RINGTONE_INDEX = 7;
    @NotNull
    public static final String SNOOZE_LENGTH = "snooze";
    private static final int SNOOZE_LENGTH_INDEX = 8;
    @NotNull
    public static final String STANDARD_AUTHORITY = "com.android.alarmclock";
    /* access modifiers changed from: private */
    public static final Uri STANDARD_CONTENT_URI = Uri.parse("content://com.android.alarmclock/alarms");
    @NotNull
    public static final String VIBRATE = "vibrate";
    private static final int VIBRATE_INDEX = 5;
    @Nullable
    private Uri alert;
    @Nullable
    private Weekdays daysOfWeek;
    private boolean deleteAfterUse;
    private boolean enabled;
    private int festival;
    private int hour;
    private long id;
    @Nullable
    private String label;
    private int minutes;
    private int snoozeLength;
    private boolean vibrate;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u0019\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0!¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u000e\u0010%\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0019\u0010*\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0007R\u000e\u0010,\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/xjsd/ai/assistant/protocol/alarm/Alarm$Companion;", "", "()V", "ALARMS_WITH_INSTANCES_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "getALARMS_WITH_INSTANCES_URI", "()Landroid/net/Uri;", "AUTHORITY", "", "CONTENT_URI", "getCONTENT_URI", "DAILY_ENABLED", "DAYS_OF_WEEK", "DAYS_OF_WEEK_INDEX", "", "DEFAULT_SORT_ORDER", "DELETE_AFTER_USE", "DELETE_AFTER_USE_INDEX", "ENABLED", "ENABLED_INDEX", "FESTIVAL", "FESTIVAL_INDEX", "HOUR", "HOUR_INDEX", "ID_INDEX", "INVALID_ID", "", "LABEL", "LABEL_INDEX", "MINUTES", "MINUTES_INDEX", "QUERY_COLUMNS", "", "getQUERY_COLUMNS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "RINGTONE", "RINGTONE_INDEX", "SNOOZE_LENGTH", "SNOOZE_LENGTH_INDEX", "STANDARD_AUTHORITY", "STANDARD_CONTENT_URI", "getSTANDARD_CONTENT_URI", "VIBRATE", "VIBRATE_INDEX", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Uri getALARMS_WITH_INSTANCES_URI() {
            return Alarm.ALARMS_WITH_INSTANCES_URI;
        }

        public final Uri getCONTENT_URI() {
            return Alarm.CONTENT_URI;
        }

        @NotNull
        public final String[] getQUERY_COLUMNS() {
            return Alarm.QUERY_COLUMNS;
        }

        public final Uri getSTANDARD_CONTENT_URI() {
            return Alarm.STANDARD_CONTENT_URI;
        }

        private Companion() {
        }
    }

    public Alarm() {
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof Alarm) && this.id == ((Alarm) obj).id;
    }

    @Nullable
    public final Uri getAlert() {
        return this.alert;
    }

    @Nullable
    public final Weekdays getDaysOfWeek() {
        return this.daysOfWeek;
    }

    public final boolean getDeleteAfterUse() {
        return this.deleteAfterUse;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final int getFestival() {
        return this.festival;
    }

    public final int getHour() {
        return this.hour;
    }

    public final long getId() {
        return this.id;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    public final int getMinutes() {
        return this.minutes;
    }

    public final int getSnoozeLength() {
        return this.snoozeLength;
    }

    public final boolean getVibrate() {
        return this.vibrate;
    }

    public int hashCode() {
        return Long.valueOf(this.id).hashCode();
    }

    public final void setAlert(@Nullable Uri uri) {
        this.alert = uri;
    }

    public final void setDaysOfWeek(@Nullable Weekdays weekdays) {
        this.daysOfWeek = weekdays;
    }

    public final void setDeleteAfterUse(boolean z) {
        this.deleteAfterUse = z;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final void setFestival(int i) {
        this.festival = i;
    }

    public final void setHour(int i) {
        this.hour = i;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final void setLabel(@Nullable String str) {
        this.label = str;
    }

    public final void setMinutes(int i) {
        this.minutes = i;
    }

    public final void setSnoozeLength(int i) {
        this.snoozeLength = i;
    }

    public final void setVibrate(boolean z) {
        this.vibrate = z;
    }

    @NotNull
    public String toString() {
        long j = this.id;
        boolean z = this.enabled;
        int i = this.hour;
        int i2 = this.minutes;
        Weekdays weekdays = this.daysOfWeek;
        boolean z2 = this.vibrate;
        String str = this.label;
        Uri uri = this.alert;
        int i3 = this.snoozeLength;
        boolean z3 = this.deleteAfterUse;
        int i4 = this.festival;
        return "Alarm(id=" + j + ", enabled=" + z + ", hour=" + i + ", minutes=" + i2 + ", daysOfWeek=" + weekdays + ", vibrate=" + z2 + ", label=" + str + ", alert=" + uri + ", snoozeLength=" + i3 + ", deleteAfterUse=" + z3 + ", festival=" + i4 + ")";
    }

    public Alarm(@NotNull Cursor cursor) {
        Uri uri;
        Intrinsics.checkNotNullParameter(cursor, "c");
        boolean z = false;
        this.id = cursor.getLong(0);
        this.enabled = cursor.getInt(4) == 1;
        this.hour = cursor.getInt(1);
        this.minutes = cursor.getInt(2);
        this.daysOfWeek = Weekdays.Companion.fromBits(cursor.getInt(3));
        this.vibrate = cursor.getInt(5) == 1;
        this.label = cursor.getString(6);
        this.snoozeLength = cursor.getInt(8);
        this.deleteAfterUse = cursor.getInt(9) == 1 ? true : z;
        if (cursor.isNull(7)) {
            uri = RingtoneManager.getDefaultUri(4);
        } else {
            uri = Uri.parse(cursor.getString(7));
        }
        this.alert = uri;
        this.festival = cursor.getInt(10);
    }

    public Alarm(@NotNull Alarm alarm) {
        Intrinsics.checkNotNullParameter(alarm, VuiModelType.ALARM);
        this.id = alarm.id;
        this.hour = alarm.hour;
        this.minutes = alarm.minutes;
        this.label = alarm.label;
        this.daysOfWeek = alarm.daysOfWeek;
        this.enabled = alarm.enabled;
        this.alert = alarm.alert;
        this.deleteAfterUse = alarm.deleteAfterUse;
        this.snoozeLength = alarm.snoozeLength;
        this.vibrate = alarm.vibrate;
        this.festival = alarm.festival;
    }
}
