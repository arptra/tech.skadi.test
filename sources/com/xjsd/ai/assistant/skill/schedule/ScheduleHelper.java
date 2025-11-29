package com.xjsd.ai.assistant.skill.schedule;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.protocol.schedule.Event;
import com.xjsd.ai.assistant.protocol.schedule.Instance;
import com.xjsd.ai.assistant.protocol.schedule.Schedule;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.BooleanUtils;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014J9\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010 \u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0006¢\u0006\u0004\b \u0010!J%\u0010%\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0006¢\u0006\u0004\b%\u0010&J%\u0010(\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u0006¢\u0006\u0004\b(\u0010&J\u0017\u0010)\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010*J\u001f\u0010-\u001a\u00020,2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b-\u0010.\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleHelper;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "target", "", "Lcom/xjsd/ai/assistant/protocol/schedule/Event;", "g", "(Landroid/content/Context;Ljava/lang/String;)Ljava/util/List;", "", "eventId", "k", "(Landroid/content/Context;J)Lcom/xjsd/ai/assistant/protocol/schedule/Event;", "begin", "end", "Lcom/xjsd/ai/assistant/protocol/schedule/Instance;", "j", "(Landroid/content/Context;JJ)Ljava/util/List;", "startTime", "endTime", "title", "Lkotlin/Result;", "c", "(Landroid/content/Context;JJLjava/lang/String;)Ljava/lang/Object;", "event", "", "l", "(Landroid/content/Context;Lcom/xjsd/ai/assistant/protocol/schedule/Event;)Z", "idStr", "f", "(Landroid/content/Context;Ljava/lang/String;)Z", "Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;", "schedule", "exDate", "d", "(Landroid/content/Context;Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;Ljava/lang/String;)Z", "rrule", "e", "i", "(Landroid/content/Context;)J", "a", "", "b", "(Landroid/content/Context;J)V", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nScheduleHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScheduleHelper.kt\ncom/xjsd/ai/assistant/skill/schedule/ScheduleHelper\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,420:1\n26#2:421\n26#2:422\n*S KotlinDebug\n*F\n+ 1 ScheduleHelper.kt\ncom/xjsd/ai/assistant/skill/schedule/ScheduleHelper\n*L\n47#1:421\n101#1:422\n*E\n"})
public final class ScheduleHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8695a = new Companion((DefaultConstructorMarker) null);
    public static final Uri b = CalendarContract.Calendars.CONTENT_URI;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleHelper$Companion;", "", "()V", "CALENDARS_ACCOUNT_NAME", "", "CALENDARS_ACCOUNT_TYPE", "CALENDARS_DISPLAY_NAME", "CALENDARS_NAME", "CALENDAR_URL", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "REMIND_MINUTES", "", "TAG", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static /* synthetic */ List h(ScheduleHelper scheduleHelper, Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        return scheduleHelper.g(context, str);
    }

    public final long a(Context context) {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            ContentValues contentValues = new ContentValues();
            contentValues.put(Event.ACCOUNT_NAME, "calendar@myvu.com");
            contentValues.put("account_type", "LOCAL");
            contentValues.put("name", "MYVU");
            contentValues.put("calendar_displayName", "日程");
            contentValues.put("visible", 1);
            contentValues.put("calendar_color", -16776961);
            contentValues.put("calendar_access_level", 700);
            contentValues.put("ownerAccount", "calendar@myvu.com");
            contentValues.put("sync_events", 1);
            contentValues.put("calendar_timezone", timeZone.getID());
            contentValues.put("canOrganizerRespond", 0);
            Uri build = b.buildUpon().appendQueryParameter("caller_is_syncadapter", BooleanUtils.TRUE).appendQueryParameter(Event.ACCOUNT_NAME, "calendar@myvu.com").appendQueryParameter("account_type", "LOCAL").build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            Uri insert = context.getContentResolver().insert(build, contentValues);
            if (insert != null) {
                return ContentUris.parseId(insert);
            }
        } catch (Exception e) {
            ILog.h("ScheduleHelper", "addCalendarAccount: error", e);
        }
        return -1;
    }

    public final void b(Context context, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_id", Long.valueOf(j));
        contentValues.put("minutes", 5);
        contentValues.put("method", 1);
        try {
            if (context.getContentResolver().insert(CalendarContract.Reminders.CONTENT_URI, contentValues) == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } catch (Exception e) {
            ILog.h("ScheduleHelper", "addReminder: error", e);
        }
    }

    public final Object c(Context context, long j, long j2, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        long i = i(context);
        if (-1 == i) {
            Result.Companion companion = Result.Companion;
            return Result.m20constructorimpl(ResultKt.createFailure(new Throwable("getScheduleCalenderId -1!")));
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(Event.CALENDAR_ID, String.valueOf(i));
        contentValues.put(Event.START_TIME, Long.valueOf(j));
        contentValues.put(Event.END_TIME, Long.valueOf(j2));
        contentValues.put(Event.TIME_ZONE, TimeZone.getDefault().getID());
        contentValues.put("title", str);
        ILog.a("ScheduleHelper", "addSchedule: contentValues->" + contentValues);
        try {
            Uri insert = context.getContentResolver().insert(Event.Companion.getSTANDARD_CONTENT_URI(), contentValues);
            if (insert != null) {
                String lastPathSegment = insert.getLastPathSegment();
                Intrinsics.checkNotNull(lastPathSegment);
                long parseLong = Long.parseLong(lastPathSegment);
                b(context, parseLong);
                Result.Companion companion2 = Result.Companion;
                return Result.m20constructorimpl(Long.valueOf(parseLong));
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        } catch (Exception e) {
            ILog.h("ScheduleHelper", "addSchedule: error", e);
            if (StringsKt.contains$default((CharSequence) String.valueOf(e.getMessage()), (CharSequence) "android.permission.WRITE_CALENDAR", false, 2, (Object) null)) {
                Result.Companion companion3 = Result.Companion;
                return Result.m20constructorimpl(ResultKt.createFailure(new Throwable("insert failed, lack WRITE_CALENDAR permission")));
            }
            Result.Companion companion4 = Result.Companion;
            return Result.m20constructorimpl(ResultKt.createFailure(new Throwable("insert schedule failed")));
        }
    }

    public final boolean d(Context context, Schedule schedule, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schedule, VuiModelType.SCHEDULE);
        Intrinsics.checkNotNullParameter(str, "exDate");
        String e = GsonUtils.e(schedule);
        ILog.j("ScheduleHelper", "deleteCurrentSchedule: schedule->" + e);
        ContentValues contentValues = new ContentValues();
        contentValues.put(Event.EXDATE, str);
        contentValues.put(Event.RRULE, schedule.getRrule());
        contentValues.put(Event.START_TIME, Long.valueOf(schedule.getDtStart()));
        try {
            Uri withAppendedId = ContentUris.withAppendedId(Event.Companion.getSTANDARD_CONTENT_URI(), Long.parseLong(schedule.getId()));
            Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(...)");
            int update = context.getContentResolver().update(withAppendedId, contentValues, (String) null, (String[]) null);
            ILog.j("ScheduleHelper", "deleteCurrentSchedule: result " + update);
            return ((long) update) > -1;
        } catch (Exception e2) {
            ILog.h("ScheduleHelper", "deleteCurrentSchedule: error", e2);
            return false;
        }
    }

    public final boolean e(Context context, Schedule schedule, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schedule, VuiModelType.SCHEDULE);
        Intrinsics.checkNotNullParameter(str, Event.RRULE);
        String e = GsonUtils.e(schedule);
        ILog.j("ScheduleHelper", "deleteFutureSchedule: schedule->" + e);
        ContentValues contentValues = new ContentValues();
        contentValues.put(Event.RRULE, str);
        contentValues.put(Event.START_TIME, Long.valueOf(schedule.getDtStart()));
        contentValues.put("title", schedule.getTitle());
        try {
            Uri withAppendedId = ContentUris.withAppendedId(Event.Companion.getSTANDARD_CONTENT_URI(), Long.parseLong(schedule.getId()));
            Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(...)");
            int update = context.getContentResolver().update(withAppendedId, contentValues, (String) null, (String[]) null);
            ILog.j("ScheduleHelper", "deleteFutureSchedule: result " + update);
            return ((long) update) > -1;
        } catch (Exception e2) {
            ILog.h("ScheduleHelper", "deleteFutureSchedule: error", e2);
            return false;
        }
    }

    public final boolean f(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "idStr");
        ILog.j("ScheduleHelper", "deleteSchedule: id->" + str);
        long parseLong = Long.parseLong(str);
        if (parseLong <= -1) {
            return false;
        }
        try {
            int delete = context.getContentResolver().delete(Event.Companion.getSTANDARD_CONTENT_URI(), "_id=?", new String[]{String.valueOf(parseLong)});
            ILog.j("ScheduleHelper", "deleteSchedule: result->" + delete);
            return delete > 0;
        } catch (Exception e) {
            ILog.h("ScheduleHelper", "deleteSchedule: error", e);
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.lang.String[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List g(android.content.Context r12, java.lang.String r13) {
        /*
            r11 = this;
            java.lang.String r11 = "ScheduleHelper"
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "target"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = 0
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0030 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
            r4.<init>()     // Catch:{ Exception -> 0x0030 }
            java.lang.String r5 = "account_name not like 'FestivalDays%' "
            r4.append(r5)     // Catch:{ Exception -> 0x0030 }
            boolean r5 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x0030 }
            if (r5 != 0) goto L_0x0033
            java.lang.String r5 = "and title=? "
            r4.append(r5)     // Catch:{ Exception -> 0x0030 }
            java.lang.Object[] r3 = kotlin.collections.ArraysKt.plus((T[]) r3, r13)     // Catch:{ Exception -> 0x0030 }
            goto L_0x0033
        L_0x0030:
            r12 = move-exception
            goto L_0x00b5
        L_0x0033:
            java.lang.String r8 = r4.toString()     // Catch:{ Exception -> 0x0030 }
            java.lang.String r13 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r13)     // Catch:{ Exception -> 0x0030 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
            r13.<init>()     // Catch:{ Exception -> 0x0030 }
            java.lang.String r4 = "getAllEventList: where->"
            r13.append(r4)     // Catch:{ Exception -> 0x0030 }
            r13.append(r8)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x0030 }
            com.xjsd.ai.assistant.log.ILog.j(r11, r13)     // Catch:{ Exception -> 0x0030 }
            android.content.ContentResolver r5 = r12.getContentResolver()     // Catch:{ Exception -> 0x0030 }
            com.xjsd.ai.assistant.protocol.schedule.Event$Companion r12 = com.xjsd.ai.assistant.protocol.schedule.Event.Companion     // Catch:{ Exception -> 0x0030 }
            android.net.Uri r6 = r12.getSTANDARD_CONTENT_URI()     // Catch:{ Exception -> 0x0030 }
            java.lang.String[] r7 = r12.getQUERY_COLUMNS()     // Catch:{ Exception -> 0x0030 }
            r9 = r3
            java.lang.String[] r9 = (java.lang.String[]) r9     // Catch:{ Exception -> 0x0030 }
            java.lang.String r10 = "dtstart ASC"
            android.database.Cursor r12 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0030 }
            java.io.Closeable r12 = (java.io.Closeable) r12     // Catch:{ Exception -> 0x0030 }
            r13 = r12
            android.database.Cursor r13 = (android.database.Cursor) r13     // Catch:{ all -> 0x00a2 }
            if (r13 == 0) goto L_0x00a4
            int r3 = r13.getCount()     // Catch:{ all -> 0x00a2 }
            if (r3 <= 0) goto L_0x00a4
            boolean r3 = r13.moveToFirst()     // Catch:{ all -> 0x00a2 }
            if (r3 == 0) goto L_0x00a4
        L_0x007b:
            com.xjsd.ai.assistant.protocol.schedule.Event r3 = new com.xjsd.ai.assistant.protocol.schedule.Event     // Catch:{ all -> 0x00a2 }
            r3.<init>(r13)     // Catch:{ all -> 0x00a2 }
            r0.add(r3)     // Catch:{ all -> 0x00a2 }
            boolean r3 = r13.moveToNext()     // Catch:{ all -> 0x00a2 }
            if (r3 != 0) goto L_0x007b
            int r13 = r0.size()     // Catch:{ all -> 0x00a2 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a2 }
            r3.<init>()     // Catch:{ all -> 0x00a2 }
            java.lang.String r4 = "getAllEventList: event result size->"
            r3.append(r4)     // Catch:{ all -> 0x00a2 }
            r3.append(r13)     // Catch:{ all -> 0x00a2 }
            java.lang.String r13 = r3.toString()     // Catch:{ all -> 0x00a2 }
            com.xjsd.ai.assistant.log.ILog.a(r11, r13)     // Catch:{ all -> 0x00a2 }
            goto L_0x00a9
        L_0x00a2:
            r13 = move-exception
            goto L_0x00af
        L_0x00a4:
            java.lang.String r13 = "getAllEventList: event result is empty"
            com.xjsd.ai.assistant.log.ILog.a(r11, r13)     // Catch:{ all -> 0x00a2 }
        L_0x00a9:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00a2 }
            kotlin.io.CloseableKt.closeFinally(r12, r1)     // Catch:{ Exception -> 0x0030 }
            goto L_0x00e8
        L_0x00af:
            throw r13     // Catch:{ all -> 0x00b0 }
        L_0x00b0:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r12, r13)     // Catch:{ Exception -> 0x0030 }
            throw r3     // Catch:{ Exception -> 0x0030 }
        L_0x00b5:
            java.lang.String r13 = "getAllEventList: error"
            com.xjsd.ai.assistant.log.ILog.h(r11, r13, r12)
            java.lang.String r11 = r12.getMessage()
            java.lang.String r12 = java.lang.String.valueOf(r11)
            java.lang.String r13 = "android.permission.READ_CALENDAR"
            r3 = 2
            boolean r12 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r12, (java.lang.CharSequence) r13, (boolean) r2, (int) r3, (java.lang.Object) r1)
            if (r12 == 0) goto L_0x00de
            java.lang.String r12 = java.lang.String.valueOf(r11)
            java.lang.String r4 = "android.permission.WRITE_CALENDAR"
            boolean r12 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r12, (java.lang.CharSequence) r4, (boolean) r2, (int) r3, (java.lang.Object) r1)
            if (r12 != 0) goto L_0x00d8
            goto L_0x00de
        L_0x00d8:
            com.xjsd.ai.assistant.skill.schedule.ScheduleException$ScheduleReadAndWritePermissionException r11 = new com.xjsd.ai.assistant.skill.schedule.ScheduleException$ScheduleReadAndWritePermissionException
            r11.<init>()
            throw r11
        L_0x00de:
            java.lang.String r11 = java.lang.String.valueOf(r11)
            boolean r11 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r11, (java.lang.CharSequence) r13, (boolean) r2, (int) r3, (java.lang.Object) r1)
            if (r11 != 0) goto L_0x00e9
        L_0x00e8:
            return r0
        L_0x00e9:
            com.xjsd.ai.assistant.skill.schedule.ScheduleException$ScheduleReadPermissionException r11 = new com.xjsd.ai.assistant.skill.schedule.ScheduleException$ScheduleReadPermissionException
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.schedule.ScheduleHelper.g(android.content.Context, java.lang.String):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ba, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bf, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c0, code lost:
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c4, code lost:
        throw r6;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:28:0x00b6, B:33:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long i(android.content.Context r14) {
        /*
            r13 = this;
            java.lang.String r1 = "ScheduleHelper"
            r2 = -1
            java.lang.String r0 = "_id"
            java.lang.String r4 = "account_name"
            java.lang.String r5 = "account_type"
            java.lang.String[] r0 = new java.lang.String[]{r0, r4, r5}     // Catch:{ Exception -> 0x00c5 }
            android.content.ContentResolver r4 = r14.getContentResolver()     // Catch:{ Exception -> 0x00c5 }
            android.net.Uri r5 = b     // Catch:{ Exception -> 0x00c5 }
            r6 = 0
            android.database.Cursor r0 = r4.query(r5, r0, r6, r6)     // Catch:{ Exception -> 0x00c5 }
            r4 = r0
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ Exception -> 0x00c5 }
            r0 = r4
            android.database.Cursor r0 = (android.database.Cursor) r0     // Catch:{ all -> 0x00ac }
            if (r0 == 0) goto L_0x00b3
            boolean r5 = r0.moveToFirst()     // Catch:{ all -> 0x00ac }
            if (r5 == 0) goto L_0x00b3
            int r5 = r0.getCount()     // Catch:{ all -> 0x00ac }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ac }
            r7.<init>()     // Catch:{ all -> 0x00ac }
            java.lang.String r8 = "getCalendarId: calendar count->"
            r7.append(r8)     // Catch:{ all -> 0x00ac }
            r7.append(r5)     // Catch:{ all -> 0x00ac }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x00ac }
            com.xjsd.ai.assistant.log.ILog.a(r1, r5)     // Catch:{ all -> 0x00ac }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x00ac }
            r5.<init>()     // Catch:{ all -> 0x00ac }
        L_0x0044:
            r7 = 0
            long r7 = r0.getLong(r7)     // Catch:{ all -> 0x00ac }
            r9 = 1
            java.lang.String r9 = r0.getString(r9)     // Catch:{ all -> 0x00ac }
            r10 = 2
            java.lang.String r10 = r0.getString(r10)     // Catch:{ all -> 0x00ac }
            java.lang.Long r11 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x00ac }
            r5.add(r11)     // Catch:{ all -> 0x00ac }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ac }
            r11.<init>()     // Catch:{ all -> 0x00ac }
            java.lang.String r12 = "getCalendarId: calendar id->"
            r11.append(r12)     // Catch:{ all -> 0x00ac }
            r11.append(r7)     // Catch:{ all -> 0x00ac }
            java.lang.String r7 = ", accountName->"
            r11.append(r7)     // Catch:{ all -> 0x00ac }
            r11.append(r9)     // Catch:{ all -> 0x00ac }
            java.lang.String r7 = ", accountType->"
            r11.append(r7)     // Catch:{ all -> 0x00ac }
            r11.append(r10)     // Catch:{ all -> 0x00ac }
            java.lang.String r7 = r11.toString()     // Catch:{ all -> 0x00ac }
            com.xjsd.ai.assistant.log.ILog.a(r1, r7)     // Catch:{ all -> 0x00ac }
            boolean r7 = r0.moveToNext()     // Catch:{ all -> 0x00ac }
            if (r7 != 0) goto L_0x0044
            boolean r0 = com.xjsd.ai.assistant.common.util.DeviceBrandUtil.c()     // Catch:{ all -> 0x00ac }
            if (r0 != 0) goto L_0x00b0
            boolean r0 = com.xjsd.ai.assistant.common.util.DeviceBrandUtil.e()     // Catch:{ all -> 0x00ac }
            if (r0 != 0) goto L_0x00b0
            boolean r0 = com.xjsd.ai.assistant.common.util.DeviceBrandUtil.f()     // Catch:{ all -> 0x00ac }
            if (r0 != 0) goto L_0x00b0
            boolean r0 = com.xjsd.ai.assistant.common.util.DeviceBrandUtil.b()     // Catch:{ all -> 0x00ac }
            if (r0 == 0) goto L_0x009d
            goto L_0x00b0
        L_0x009d:
            int r0 = kotlin.collections.CollectionsKt.getLastIndex(r5)     // Catch:{ all -> 0x00ac }
            java.lang.Object r0 = r5.get(r0)     // Catch:{ all -> 0x00ac }
            java.lang.Number r0 = (java.lang.Number) r0     // Catch:{ all -> 0x00ac }
            long r7 = r0.longValue()     // Catch:{ all -> 0x00ac }
            goto L_0x00b4
        L_0x00ac:
            r0 = move-exception
            r5 = r0
            r7 = r2
            goto L_0x00be
        L_0x00b0:
            r7 = 1
            goto L_0x00b4
        L_0x00b3:
            r7 = r2
        L_0x00b4:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00bc }
            kotlin.io.CloseableKt.closeFinally(r4, r6)     // Catch:{ Exception -> 0x00ba }
            goto L_0x00cc
        L_0x00ba:
            r0 = move-exception
            goto L_0x00c7
        L_0x00bc:
            r0 = move-exception
            r5 = r0
        L_0x00be:
            throw r5     // Catch:{ all -> 0x00bf }
        L_0x00bf:
            r0 = move-exception
            r6 = r0
            kotlin.io.CloseableKt.closeFinally(r4, r5)     // Catch:{ Exception -> 0x00ba }
            throw r6     // Catch:{ Exception -> 0x00ba }
        L_0x00c5:
            r0 = move-exception
            r7 = r2
        L_0x00c7:
            java.lang.String r4 = "getCalendarId: error"
            com.xjsd.ai.assistant.log.ILog.h(r1, r4, r0)
        L_0x00cc:
            int r0 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00d1
            return r7
        L_0x00d1:
            long r0 = r13.a(r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.schedule.ScheduleHelper.i(android.content.Context):long");
    }

    public final List j(Context context, long j, long j2) {
        Intrinsics.checkNotNullParameter(context, "context");
        ILog.a("ScheduleHelper", "getCalendarInstances: begin->" + j + ", end->" + j2);
        ArrayList arrayList = new ArrayList();
        Closeable query = CalendarContract.Instances.query(context.getContentResolver(), Instance.Companion.getINSTANCE_COLUMNS(), j, j2);
        try {
            Cursor cursor = (Cursor) query;
            if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                ILog.a("ScheduleHelper", "getCalendarInstances: instance result is empty");
            } else {
                do {
                    arrayList.add(new Instance(cursor));
                } while (cursor.moveToNext());
                int size = arrayList.size();
                ILog.a("ScheduleHelper", "getCalendarInstances: instance result size->" + size);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(query, (Throwable) null);
            return arrayList;
        } catch (Throwable th) {
            CloseableKt.closeFinally(query, th);
            throw th;
        }
    }

    public final Event k(Context context, long j) {
        Closeable query;
        Event event;
        Intrinsics.checkNotNullParameter(context, "context");
        Event event2 = null;
        try {
            Object[] plus = ArraysKt.plus((T[]) new String[0], String.valueOf(j));
            String str = "_id=?";
            Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
            ILog.j("ScheduleHelper", "getSchedule: where->" + str);
            ContentResolver contentResolver = context.getContentResolver();
            Event.Companion companion = Event.Companion;
            query = contentResolver.query(companion.getSTANDARD_CONTENT_URI(), companion.getQUERY_COLUMNS(), str, (String[]) plus, Event.DEFAULT_SORT_ORDER);
            try {
                Cursor cursor = (Cursor) query;
                if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                    ILog.a("ScheduleHelper", "getSchedule: event is empty");
                    event = null;
                } else {
                    event = new Event(cursor);
                    try {
                        ILog.a("ScheduleHelper", "getSchedule: event->" + event);
                    } catch (Throwable th) {
                        th = th;
                        event2 = event;
                    }
                }
                Unit unit = Unit.INSTANCE;
                try {
                    CloseableKt.closeFinally(query, (Throwable) null);
                    return event;
                } catch (Exception e) {
                    e = e;
                    event2 = event;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            ILog.h("ScheduleHelper", "getSchedule: error", e);
            return event2;
        } catch (Throwable th3) {
            CloseableKt.closeFinally(query, th);
            throw th3;
        }
    }

    public final boolean l(Context context, Event event) {
        ContentValues contentValues;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.isRepeatSchedule()) {
            contentValues = new ContentValues();
            contentValues.put(Event.START_TIME, Long.valueOf(event.getDtStart()));
            contentValues.put("title", event.getTitle());
            contentValues.put(Event.RRULE, event.getRrule());
            contentValues.put(Event.EXDATE, event.getExDate());
        } else {
            contentValues = new ContentValues();
            contentValues.put(Event.START_TIME, Long.valueOf(event.getDtStart()));
            contentValues.put(Event.END_TIME, event.getDtEnd());
            contentValues.put("title", event.getTitle());
        }
        try {
            Uri withAppendedId = ContentUris.withAppendedId(Event.Companion.getSTANDARD_CONTENT_URI(), Long.parseLong(event.getId()));
            Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(...)");
            int update = context.getContentResolver().update(withAppendedId, contentValues, (String) null, (String[]) null);
            ILog.j("ScheduleHelper", "modifyEvent: 更新行数->" + update);
            return ((long) update) > -1;
        } catch (Exception e) {
            ILog.h("ScheduleHelper", "modifyEvent: error", e);
            return false;
        }
    }
}
