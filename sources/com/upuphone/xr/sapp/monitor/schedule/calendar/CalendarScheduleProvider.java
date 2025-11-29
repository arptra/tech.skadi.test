package com.upuphone.xr.sapp.monitor.schedule.calendar;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import androidx.core.content.ContextCompat;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.monitor.notification.model.ArReminderModel;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import com.xjsd.ai.assistant.protocol.schedule.Event;
import java.io.Closeable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0007\u001a\u00020\fH\u0003¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\r2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u0007\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001c\u0010\u0010R\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001e¨\u0006 "}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/calendar/CalendarScheduleProvider;", "", "<init>", "()V", "", "c", "Lcom/upuphone/xr/sapp/MainApplication;", "context", "", "Lcom/upuphone/xr/sapp/monitor/notification/model/ArReminderModel;", "g", "(Lcom/upuphone/xr/sapp/MainApplication;)Ljava/util/List;", "Landroid/content/Context;", "", "", "b", "(Landroid/content/Context;)Ljava/util/List;", "startCalendarId", "endCalendarId", "e", "(Landroid/content/Context;II)Ljava/util/List;", "Landroid/content/ContentResolver;", "contentResolver", "", "eventId", "starTime", "d", "(Landroid/content/ContentResolver;JJ)Ljava/util/List;", "f", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class CalendarScheduleProvider {

    /* renamed from: a  reason: collision with root package name */
    public static final CalendarScheduleProvider f7784a = new CalendarScheduleProvider();
    public static final CoroutineScope b = CoroutineScopeKt.a(Dispatchers.c().plus(SupervisorKt.b((Job) null, 1, (Object) null)));

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c5, code lost:
        kotlin.io.CloseableKt.closeFinally(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c8, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List b(android.content.Context r9) {
        /*
            r8 = this;
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r0 = "checkCalendarAccounts.."
            java.lang.String r1 = "Calendar-ScheduleProvider"
            r8.g(r1, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.content.ContentResolver r2 = r9.getContentResolver()
            java.lang.String r9 = "content://com.android.calendar/calendars"
            android.net.Uri r3 = android.net.Uri.parse(r9)
            r6 = 0
            java.lang.String r7 = "calendar_access_level ASC "
            r4 = 0
            r5 = 0
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)
            if (r9 != 0) goto L_0x0024
            return r0
        L_0x0024:
            java.io.Closeable r9 = (java.io.Closeable) r9
            r2 = r9
            android.database.Cursor r2 = (android.database.Cursor) r2     // Catch:{ all -> 0x00bc }
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch:{ all -> 0x005a }
            int r3 = r2.getCount()     // Catch:{ all -> 0x005a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            r4.<init>()     // Catch:{ all -> 0x005a }
            java.lang.String r5 = "checkCalendarAccounts..count:"
            r4.append(r5)     // Catch:{ all -> 0x005a }
            r4.append(r3)     // Catch:{ all -> 0x005a }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x005a }
            r8.g(r1, r3)     // Catch:{ all -> 0x005a }
            int r3 = r2.getCount()     // Catch:{ all -> 0x005a }
            if (r3 <= 0) goto L_0x008a
            com.upuphone.xr.sapp.utils.PhoneTypeUtils r3 = com.upuphone.xr.sapp.utils.PhoneTypeUtils.f7912a     // Catch:{ all -> 0x005a }
            boolean r3 = r3.i()     // Catch:{ all -> 0x005a }
            if (r3 == 0) goto L_0x005c
            java.lang.String r3 = "checkCalendarAccounts..isMeizu"
            r8.g(r1, r3)     // Catch:{ all -> 0x005a }
            r2.moveToNext()     // Catch:{ all -> 0x005a }
            goto L_0x005c
        L_0x005a:
            r8 = move-exception
            goto L_0x0091
        L_0x005c:
            boolean r8 = r2.moveToNext()     // Catch:{ all -> 0x005a }
            if (r8 == 0) goto L_0x008a
            java.lang.String r8 = "_id"
            int r8 = r2.getColumnIndex(r8)     // Catch:{ all -> 0x005a }
            com.upuphone.star.core.log.ULog$Delegate r3 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ all -> 0x005a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            r4.<init>()     // Catch:{ all -> 0x005a }
            java.lang.String r5 = "checkCalendarAccounts..columnIndex"
            r4.append(r5)     // Catch:{ all -> 0x005a }
            r4.append(r8)     // Catch:{ all -> 0x005a }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x005a }
            r3.g(r1, r4)     // Catch:{ all -> 0x005a }
            int r8 = r2.getInt(r8)     // Catch:{ all -> 0x005a }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x005a }
            r0.add(r8)     // Catch:{ all -> 0x005a }
            goto L_0x005c
        L_0x008a:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005a }
            java.lang.Object r8 = kotlin.Result.m20constructorimpl(r8)     // Catch:{ all -> 0x005a }
            goto L_0x009b
        L_0x0091:
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x00bc }
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)     // Catch:{ all -> 0x00bc }
            java.lang.Object r8 = kotlin.Result.m20constructorimpl(r8)     // Catch:{ all -> 0x00bc }
        L_0x009b:
            java.lang.Throwable r8 = kotlin.Result.m23exceptionOrNullimpl(r8)     // Catch:{ all -> 0x00bc }
            if (r8 == 0) goto L_0x00be
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ all -> 0x00bc }
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x00bc }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bc }
            r3.<init>()     // Catch:{ all -> 0x00bc }
            java.lang.String r4 = "checkCalendarAccounts onFailure:"
            r3.append(r4)     // Catch:{ all -> 0x00bc }
            r3.append(r8)     // Catch:{ all -> 0x00bc }
            java.lang.String r8 = r3.toString()     // Catch:{ all -> 0x00bc }
            r2.g(r1, r8)     // Catch:{ all -> 0x00bc }
            goto L_0x00be
        L_0x00bc:
            r8 = move-exception
            goto L_0x00c3
        L_0x00be:
            r8 = 0
            kotlin.io.CloseableKt.closeFinally(r9, r8)
            return r0
        L_0x00c3:
            throw r8     // Catch:{ all -> 0x00c4 }
        L_0x00c4:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r9, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.schedule.calendar.CalendarScheduleProvider.b(android.content.Context):java.util.List");
    }

    public final void c() {
        MainApplication f = MainApplication.k.f();
        if (ContextCompat.checkSelfPermission(f, "android.permission.READ_CALENDAR") != 0) {
            ULog.f6446a.g("Calendar-ScheduleProvider", "fail to grant READ_CALENDAR permission!");
        } else {
            Job unused = BuildersKt__Builders_commonKt.d(b, (CoroutineContext) null, (CoroutineStart) null, new CalendarScheduleProvider$feedbackScheduleList$1(f, (Continuation<? super CalendarScheduleProvider$feedbackScheduleList$1>) null), 3, (Object) null);
        }
    }

    public final List d(ContentResolver contentResolver, long j, long j2) {
        Throwable th;
        Uri uri = CalendarContract.Reminders.CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(uri, "CONTENT_URI");
        String[] strArr = {String.valueOf(j)};
        Cursor query = contentResolver.query(uri, (String[]) null, "event_id = ?", strArr, (String) null);
        ArrayList arrayList = new ArrayList();
        ULog.Delegate delegate = ULog.f6446a;
        String joinToString$default = ArraysKt.joinToString$default((Object[]) strArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) CalendarScheduleProvider$getEventReminders$1.INSTANCE, 31, (Object) null);
        delegate.a("Calendar-ScheduleProvider", "getEventReminders selection=" + "event_id = ?" + " selectionArgs" + joinToString$default);
        try {
            Result.Companion companion = Result.Companion;
            Unit unit = null;
            if (query != null) {
                Closeable closeable = query;
                try {
                    Cursor cursor = (Cursor) closeable;
                    int count = cursor.getCount();
                    delegate.a("Calendar-ScheduleProvider", "getEventReminders count=" + count);
                    while (query.moveToNext()) {
                        long j3 = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
                        int i = cursor.getInt(cursor.getColumnIndexOrThrow("minutes"));
                        ULog.Delegate delegate2 = ULog.f6446a;
                        delegate2.g("Calendar-ScheduleProvider", "getEventReminders Reminder ID: " + j3 + ", Minutes: " + i);
                        int columnIndex = query.getColumnIndex("minutes");
                        if (columnIndex >= 0) {
                            int i2 = query.getInt(columnIndex);
                            if (i2 == -1 || i2 == 0) {
                                arrayList.add(Long.valueOf(j2));
                            }
                            if (i2 > 0) {
                                arrayList.add(Long.valueOf(j2 - ((long) (i2 * 60000))));
                            }
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                    CloseableKt.closeFinally(closeable, (Throwable) null);
                    unit = Unit.INSTANCE;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    CloseableKt.closeFinally(closeable, th);
                    throw th3;
                }
            }
            Result.m20constructorimpl(unit);
        } catch (Throwable th4) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th4));
        }
        if (arrayList.isEmpty()) {
            arrayList.add(Long.valueOf(j2));
        }
        ULog.Delegate delegate3 = ULog.f6446a;
        int size = arrayList.size();
        delegate3.a("Calendar-ScheduleProvider", "remindersTime=" + size);
        return arrayList;
    }

    public final List e(Context context, int i, int i2) {
        Object obj;
        ULog.f6446a.g("Calendar-ScheduleProvider", "queryCalendarSchedule ....");
        ArrayList arrayList = new ArrayList();
        LocalDateTime plusDays = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).plusDays(2);
        long epochMilli = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long epochMilli2 = plusDays.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        Uri.Builder buildUpon = CalendarContract.Instances.CONTENT_URI.buildUpon();
        ContentUris.appendId(buildUpon, epochMilli);
        ContentUris.appendId(buildUpon, epochMilli2);
        ContentResolver contentResolver = context.getContentResolver();
        Cursor query = contentResolver.query(buildUpon.build(), (String[]) null, "(calendar_id >= " + i + " AND calendar_id <= " + i2 + ")", (String[]) null, "dtstart ASC, begin ASC");
        if (query == null) {
            return arrayList;
        }
        Closeable closeable = query;
        try {
            Cursor cursor = (Cursor) closeable;
            CalendarScheduleProvider calendarScheduleProvider = f7784a;
            Result.Companion companion = Result.Companion;
            while (cursor.moveToNext()) {
                SdkContext.f6675a.a();
                int columnIndex = cursor.getColumnIndex("_id");
                long j = 0;
                long j2 = columnIndex >= 0 ? cursor.getLong(columnIndex) : 0;
                int columnIndex2 = cursor.getColumnIndex("event_id");
                long j3 = columnIndex2 >= 0 ? cursor.getLong(columnIndex2) : 0;
                int columnIndex3 = cursor.getColumnIndex(Event.START_TIME);
                long j4 = columnIndex3 >= 0 ? cursor.getLong(columnIndex3) : 0;
                String str = "";
                int columnIndex4 = cursor.getColumnIndex("title");
                if (columnIndex4 >= 0) {
                    str = cursor.getString(columnIndex4);
                    Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
                }
                String str2 = str;
                int columnIndex5 = cursor.getColumnIndex("begin");
                long j5 = columnIndex5 >= 0 ? cursor.getLong(columnIndex5) : 0;
                int columnIndex6 = cursor.getColumnIndex(Event.END_TIME);
                if (columnIndex6 >= 0) {
                    j = cursor.getLong(columnIndex6);
                }
                Intrinsics.checkNotNull(contentResolver);
                arrayList.add(new ArReminderModel(String.valueOf(j2), j4, "com.android.calendar", str2, Long.valueOf(j5), Long.valueOf(j), "system_calendar", calendarScheduleProvider.d(contentResolver, j3, j5)));
            }
            obj = Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Throwable th2 = th;
            try {
                throw th2;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                CloseableKt.closeFinally(closeable, th2);
                throw th4;
            }
        }
        Throwable r0 = Result.m23exceptionOrNullimpl(obj);
        if (r0 != null) {
            ULog.f6446a.g("Calendar-ScheduleProvider", "queryCalendarSchedule onFailure:" + r0.getMessage());
        }
        CloseableKt.closeFinally(closeable, (Throwable) null);
        ULog.f6446a.g("Calendar-ScheduleProvider", "queryCalendarSchedule return:" + arrayList.size());
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008e, code lost:
        kotlin.io.CloseableKt.closeFinally(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0091, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List f(android.content.Context r9) {
        /*
            r8 = this;
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r0 = "queryFLYMEImportantDaySchedule ...."
            java.lang.String r1 = "Calendar-ScheduleProvider"
            r8.g(r1, r0)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            android.content.ContentResolver r2 = r9.getContentResolver()
            java.lang.String r9 = "content://com.flyme.calendar.personalization/events"
            android.net.Uri r3 = android.net.Uri.parse(r9)
            r6 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)
            if (r9 != 0) goto L_0x0023
            return r8
        L_0x0023:
            java.time.LocalDateTime r0 = java.time.LocalDateTime.now()
            r2 = 0
            java.time.LocalDateTime r0 = r0.withHour(r2)
            java.time.LocalDateTime r0 = r0.withMinute(r2)
            java.time.LocalDateTime r0 = r0.withSecond(r2)
            r2 = 2
            r0.plusDays(r2)
            java.time.LocalDateTime.now()
            java.io.Closeable r9 = (java.io.Closeable) r9
            r0 = r9
            android.database.Cursor r0 = (android.database.Cursor) r0     // Catch:{ all -> 0x0085 }
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0051 }
        L_0x0043:
            boolean r2 = r0.moveToNext()     // Catch:{ all -> 0x0051 }
            if (r2 == 0) goto L_0x0053
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ all -> 0x0051 }
            java.lang.String r3 = "moveToNext "
            r2.g(r1, r3)     // Catch:{ all -> 0x0051 }
            goto L_0x0043
        L_0x0051:
            r0 = move-exception
            goto L_0x005a
        L_0x0053:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0051 }
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)     // Catch:{ all -> 0x0051 }
            goto L_0x0064
        L_0x005a:
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0085 }
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch:{ all -> 0x0085 }
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)     // Catch:{ all -> 0x0085 }
        L_0x0064:
            java.lang.Throwable r0 = kotlin.Result.m23exceptionOrNullimpl(r0)     // Catch:{ all -> 0x0085 }
            if (r0 == 0) goto L_0x0087
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ all -> 0x0085 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0085 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            r3.<init>()     // Catch:{ all -> 0x0085 }
            java.lang.String r4 = "queryFLYMEImportantDaySchedule onFailure:"
            r3.append(r4)     // Catch:{ all -> 0x0085 }
            r3.append(r0)     // Catch:{ all -> 0x0085 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0085 }
            r2.g(r1, r0)     // Catch:{ all -> 0x0085 }
            goto L_0x0087
        L_0x0085:
            r8 = move-exception
            goto L_0x008c
        L_0x0087:
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r9, r0)
            return r8
        L_0x008c:
            throw r8     // Catch:{ all -> 0x008d }
        L_0x008d:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r9, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.schedule.calendar.CalendarScheduleProvider.f(android.content.Context):java.util.List");
    }

    public final List g(MainApplication mainApplication) {
        ArrayList arrayList = new ArrayList();
        List b2 = b(mainApplication);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("Calendar-ScheduleProvider", "scheduleModels ...");
        if (!b2.isEmpty()) {
            Integer num = (Integer) Collections.min(b2);
            Integer num2 = (Integer) Collections.max(b2);
            delegate.g("Calendar-ScheduleProvider", "getScheduleList startCalendarId::" + num + " endCalendarId::" + num2);
            Intrinsics.checkNotNull(num);
            int intValue = num.intValue();
            Intrinsics.checkNotNull(num2);
            arrayList.addAll(e(mainApplication, intValue, num2.intValue()));
        }
        if (PhoneTypeUtils.f7912a.i()) {
            delegate.g("Calendar-ScheduleProvider", "scheduleModels isMeizu");
            List f = f(mainApplication);
            if (!f.isEmpty()) {
                delegate.g("Calendar-ScheduleProvider", "has importantEventsItems");
                arrayList.addAll(f);
            }
        }
        return arrayList;
    }
}
