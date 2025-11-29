package com.upuphone.ar.fastrecord.phone.schedule;

import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.xjsd.ai.assistant.protocol.schedule.Event;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/schedule/ScheduleManger;", "", "()V", "TAG", "", "getCalenderId", "", "insertSchedule", "", "startDate", "endDate", "title", "insertScheduleReminder", "eventUri", "Landroid/net/Uri;", "querySchedule", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScheduleManger {
    @NotNull
    public static final ScheduleManger INSTANCE = new ScheduleManger();
    @NotNull
    private static final String TAG = "CalanderManger";

    private ScheduleManger() {
    }

    private final boolean insertScheduleReminder(Uri uri) {
        long parseId = ContentUris.parseId(uri);
        LogExt.logV("insertScheduleReminder eventId=" + parseId, TAG);
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_id", Long.valueOf(parseId));
        ScheduleUtils scheduleUtils = ScheduleUtils.INSTANCE;
        contentValues.put("minutes", Integer.valueOf(scheduleUtils.getREMINDERS_MINUTES()));
        contentValues.put("method", 4);
        Intrinsics.checkNotNull(FastRecordManager.Companion.getInstance().appContext().getContentResolver().insert(scheduleUtils.getREMINDER_URI(), contentValues), "null cannot be cast to non-null type android.net.Uri");
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005e, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0061, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getCalenderId() {
        /*
            r6 = this;
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r6 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r6 = r6.getInstance()
            android.content.Context r6 = r6.appContext()
            android.content.ContentResolver r0 = r6.getContentResolver()
            com.upuphone.ar.fastrecord.phone.schedule.ScheduleUtils r6 = com.upuphone.ar.fastrecord.phone.schedule.ScheduleUtils.INSTANCE
            android.net.Uri r1 = r6.getCALENDAR_URI()
            r4 = 0
            r5 = 0
            r2 = 0
            r3 = 0
            android.database.Cursor r6 = r0.query(r1, r2, r3, r4, r5)
            if (r6 == 0) goto L_0x0062
            int r0 = r6.getCount()
            if (r0 < 0) goto L_0x0062
            java.io.Closeable r6 = (java.io.Closeable) r6
            r0 = r6
            android.database.Cursor r0 = (android.database.Cursor) r0     // Catch:{ all -> 0x005b }
            r0.moveToFirst()     // Catch:{ all -> 0x005b }
            java.lang.String r1 = "_id"
            int r1 = r0.getColumnIndex(r1)     // Catch:{ all -> 0x005b }
            int r0 = r0.getInt(r1)     // Catch:{ all -> 0x005b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005b }
            r2.<init>()     // Catch:{ all -> 0x005b }
            java.lang.String r3 = "getCalenderId..recordIdIndex="
            r2.append(r3)     // Catch:{ all -> 0x005b }
            r2.append(r1)     // Catch:{ all -> 0x005b }
            java.lang.String r1 = " calenderId="
            r2.append(r1)     // Catch:{ all -> 0x005b }
            r2.append(r0)     // Catch:{ all -> 0x005b }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x005b }
            java.lang.String r2 = "CalanderManger"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logI(r1, r2)     // Catch:{ all -> 0x005b }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005b }
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r6, r1)
            goto L_0x0063
        L_0x005b:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x005d }
        L_0x005d:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r6, r0)
            throw r1
        L_0x0062:
            r0 = -1
        L_0x0063:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.schedule.ScheduleManger.getCalenderId():int");
    }

    public final boolean insertSchedule(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "startDate");
        Intrinsics.checkNotNullParameter(str2, "endDate");
        Intrinsics.checkNotNullParameter(str3, "title");
        int calenderId = getCalenderId();
        LogExt.logV("insertSchedule calendarId=" + calenderId, TAG);
        if (calenderId == -1) {
            return false;
        }
        ScheduleUtils scheduleUtils = ScheduleUtils.INSTANCE;
        long dateToTimestamp = scheduleUtils.dateToTimestamp(str, "yyyy-MM-dd HH:mm:ss");
        long dateToTimestamp2 = scheduleUtils.dateToTimestamp(str2, "yyyy-MM-dd HH:mm:ss");
        ContentValues contentValues = new ContentValues();
        contentValues.put(Event.START_TIME, Long.valueOf(dateToTimestamp));
        contentValues.put(Event.END_TIME, Long.valueOf(dateToTimestamp2));
        contentValues.put("title", str3);
        contentValues.put("description", str3);
        contentValues.put(Event.CALENDAR_ID, Integer.valueOf(calenderId));
        contentValues.put(Event.TIME_ZONE, Calendar.getInstance().getTimeZone().getID());
        Uri insert = FastRecordManager.Companion.getInstance().appContext().getContentResolver().insert(scheduleUtils.getEVENT_URI(), contentValues);
        Intrinsics.checkNotNull(insert, "null cannot be cast to non-null type android.net.Uri");
        String lastPathSegment = insert.getLastPathSegment();
        if (lastPathSegment != null) {
            Long.parseLong(lastPathSegment);
        }
        LogExt.logV("insertSchedule insertUri=" + insert, TAG);
        insertScheduleReminder(insert);
        return true;
    }

    public final void querySchedule() {
        Cursor query = FastRecordManager.Companion.getInstance().appContext().getContentResolver().query(ScheduleUtils.INSTANCE.getREMINDER_URI(), (String[]) null, (String) null, (String[]) null, (String) null);
        if (query != null && query.getCount() >= 0) {
            while (query.moveToNext()) {
                try {
                    int columnIndex = query.getColumnIndex("title");
                    int columnIndex2 = query.getColumnIndex("description");
                    int columnIndex3 = query.getColumnIndex("eventLocation");
                    int columnIndex4 = query.getColumnIndex("begin");
                    int columnIndex5 = query.getColumnIndex("end");
                    int columnIndex6 = query.getColumnIndex("event_id");
                    String string = query.getString(columnIndex);
                    String string2 = query.getString(columnIndex2);
                    String string3 = query.getString(columnIndex3);
                    String string4 = query.getString(columnIndex4);
                    String string5 = query.getString(columnIndex5);
                    long j = query.getLong(columnIndex6);
                    LogExt.logI("querySchedule ######## eventTitle=" + string + " description=" + string2 + " location=" + string3 + " startTime=" + string4 + " endTime=" + string5 + " eventId=" + j, TAG);
                } finally {
                    query.close();
                }
            }
        }
    }
}
