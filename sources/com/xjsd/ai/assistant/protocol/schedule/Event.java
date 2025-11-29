package com.xjsd.ai.assistant.protocol.schedule;

import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.meizu.common.widget.MzContactsContract;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 22\u00020\u0001:\u00012B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0002J\u000e\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u0013J\b\u0010)\u001a\u00020*H\u0016J\u0006\u0010+\u001a\u00020%J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0013J\u0010\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u0007H\u0002J\b\u00101\u001a\u00020\u0013H\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\u001a\u0010!\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017¨\u00063"}, d2 = {"Lcom/xjsd/ai/assistant/protocol/schedule/Event;", "", "()V", "c", "Landroid/database/Cursor;", "(Landroid/database/Cursor;)V", "dtEnd", "", "getDtEnd", "()Ljava/lang/Long;", "setDtEnd", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "dtStart", "getDtStart", "()J", "setDtStart", "(J)V", "duration", "", "getDuration", "()Ljava/lang/String;", "setDuration", "(Ljava/lang/String;)V", "exDate", "getExDate", "setExDate", "id", "getId", "setId", "rrule", "getRrule", "setRrule", "title", "getTitle", "setTitle", "equals", "", "o", "getRuleWithUntil", "until", "hashCode", "", "isRepeatSchedule", "setExDateWhenModify", "", "timeZ", "timeToString", "time", "toString", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Event.kt\ncom/xjsd/ai/assistant/protocol/schedule/Event\n+ 2 Cursor.kt\nandroidx/core/database/CursorKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,144:1\n86#2:145\n112#2:146\n112#2:147\n1#3:148\n*S KotlinDebug\n*F\n+ 1 Event.kt\ncom/xjsd/ai/assistant/protocol/schedule/Event\n*L\n83#1:145\n86#1:146\n87#1:147\n*E\n"})
public class Event {
    @NotNull
    public static final String ACCOUNT_NAME = "account_name";
    @NotNull
    public static final String CALENDAR_ID = "calendar_id";
    private static final int COL_CALENDAR_ID = 8;
    private static final int COL_EXDATE = 7;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String DEFAULT_SORT_ORDER = "dtstart ASC";
    private static final int DESCRIPTION_INDEX = 2;
    private static final int DTEND_INDEX = 4;
    private static final int DTSTART_INDEX = 3;
    private static final int DURATION_INDEX = 6;
    @NotNull
    public static final String END_TIME = "dtend";
    @NotNull
    public static final String EXDATE = "exdate";
    @NotNull
    public static final String ID = "_id";
    private static final int ID_INDEX = 0;
    public static final long INVALID_ID = -1;
    /* access modifiers changed from: private */
    @NotNull
    public static final String[] QUERY_COLUMNS = {"_id", "title", "description", START_TIME, END_TIME, RRULE, "duration", EXDATE, CALENDAR_ID};
    @NotNull
    public static final String RRULE = "rrule";
    private static final int RRULE_INDEX = 5;
    /* access modifiers changed from: private */
    @NotNull
    public static final Uri STANDARD_CONTENT_URI;
    @NotNull
    public static final String START_TIME = "dtstart";
    @NotNull
    public static final String TIME_ZONE = "eventTimezone";
    @NotNull
    public static final String TITLE = "title";
    private static final int TITLE_INDEX = 1;
    @NotNull
    private static final String UNTIL = "UNTIL";
    @Nullable
    private Long dtEnd;
    private long dtStart;
    @Nullable
    private String duration;
    @Nullable
    private String exDate;
    @NotNull
    private String id = "";
    @Nullable
    private String rrule;
    @NotNull
    private String title = "";

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u0019\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/xjsd/ai/assistant/protocol/schedule/Event$Companion;", "", "()V", "ACCOUNT_NAME", "", "CALENDAR_ID", "COL_CALENDAR_ID", "", "COL_EXDATE", "DEFAULT_SORT_ORDER", "DESCRIPTION_INDEX", "DTEND_INDEX", "DTSTART_INDEX", "DURATION_INDEX", "END_TIME", "EXDATE", "ID", "ID_INDEX", "INVALID_ID", "", "QUERY_COLUMNS", "", "getQUERY_COLUMNS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "RRULE", "RRULE_INDEX", "STANDARD_CONTENT_URI", "Landroid/net/Uri;", "getSTANDARD_CONTENT_URI", "()Landroid/net/Uri;", "START_TIME", "TIME_ZONE", "TITLE", "TITLE_INDEX", "UNTIL", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String[] getQUERY_COLUMNS() {
            return Event.QUERY_COLUMNS;
        }

        @NotNull
        public final Uri getSTANDARD_CONTENT_URI() {
            return Event.STANDARD_CONTENT_URI;
        }

        private Companion() {
        }
    }

    static {
        Uri uri = CalendarContract.Events.CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(uri, "CONTENT_URI");
        STANDARD_CONTENT_URI = uri;
    }

    public Event() {
    }

    private final String timeToString(long j) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.id, (Object) ((Event) obj).id);
    }

    @Nullable
    public final Long getDtEnd() {
        return this.dtEnd;
    }

    public final long getDtStart() {
        return this.dtStart;
    }

    @Nullable
    public final String getDuration() {
        return this.duration;
    }

    @Nullable
    public final String getExDate() {
        return this.exDate;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getRrule() {
        return this.rrule;
    }

    @NotNull
    public final String getRuleWithUntil(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "until");
        if (TextUtils.isEmpty(this.rrule)) {
            return "UNTIL=" + str;
        }
        String str2 = this.rrule;
        Intrinsics.checkNotNull(str2);
        ArrayList arrayList = new ArrayList(StringsKt.split$default((CharSequence) str2, new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD}, false, 0, 6, (Object) null));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String upperCase = ((String) it.next()).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            if (StringsKt.contains$default((CharSequence) upperCase, (CharSequence) UNTIL, false, 2, (Object) null)) {
                it.remove();
            }
        }
        arrayList.add("UNTIL=" + str);
        return CollectionsKt.joinToString$default(arrayList, MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return Long.valueOf(this.id).hashCode();
    }

    public final boolean isRepeatSchedule() {
        return !TextUtils.isEmpty(this.duration);
    }

    public final void setDtEnd(@Nullable Long l) {
        this.dtEnd = l;
    }

    public final void setDtStart(long j) {
        this.dtStart = j;
    }

    public final void setDuration(@Nullable String str) {
        this.duration = str;
    }

    public final void setExDate(@Nullable String str) {
        this.exDate = str;
    }

    public final void setExDateWhenModify(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "timeZ");
        if (!TextUtils.isEmpty(this.exDate)) {
            ArrayList arrayList = new ArrayList();
            String str2 = this.exDate;
            Intrinsics.checkNotNull(str2);
            ListIterator listIterator = new ArrayList(StringsKt.split$default((CharSequence) str2, new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD}, false, 0, 6, (Object) null)).listIterator();
            while (listIterator.hasNext()) {
                arrayList.add(new Regex("[0-9]{6}[Zz]").replace((CharSequence) listIterator.next(), str));
            }
            this.exDate = CollectionsKt.joinToString$default(arrayList, MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
    }

    public final void setId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final void setRrule(@Nullable String str) {
        this.rrule = str;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    @NotNull
    public String toString() {
        String str = this.id;
        String str2 = this.title;
        String str3 = this.rrule;
        String str4 = this.duration;
        String str5 = this.exDate;
        String timeToString = timeToString(this.dtStart);
        Long l = this.dtEnd;
        String timeToString2 = l != null ? timeToString(l.longValue()) : null;
        return "Event(id=" + str + ", title='" + str2 + "', rrule=" + str3 + ", duration=" + str4 + ", exDate = " + str5 + ",dtStart=" + timeToString + ", dtEnd=" + timeToString2 + ")";
    }

    public Event(@NotNull Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "c");
        this.id = String.valueOf(cursor.getLong(0));
        String string = cursor.getString(1);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.title = string;
        this.dtStart = cursor.getLong(3);
        String str = null;
        this.dtEnd = cursor.isNull(4) ? null : Long.valueOf(cursor.getLong(4));
        this.exDate = cursor.getString(7);
        this.duration = cursor.isNull(6) ? null : cursor.getString(6);
        this.rrule = !cursor.isNull(5) ? cursor.getString(5) : str;
    }
}
